package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {
    static final CacheSubscription[] EMPTY = new CacheSubscription[0];
    static final CacheSubscription[] TERMINATED = new CacheSubscription[0];
    final int capacityHint;
    volatile boolean done;
    Throwable error;
    final Node<T> head;
    final AtomicBoolean once = new AtomicBoolean();
    volatile long size;
    final AtomicReference<CacheSubscription<T>[]> subscribers;
    Node<T> tail;
    int tailOffset;

    public FlowableCache(Flowable<T> flowable, int i) {
        super(flowable);
        this.capacityHint = i;
        Node<T> node = new Node<>(i);
        this.head = node;
        this.tail = node;
        this.subscribers = new AtomicReference<>(EMPTY);
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        CacheSubscription<T> cacheSubscription = new CacheSubscription<>(subscriber, this);
        subscriber.onSubscribe(cacheSubscription);
        add(cacheSubscription);
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            replay(cacheSubscription);
        } else {
            this.source.subscribe((FlowableSubscriber) this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.once.get();
    }

    /* access modifiers changed from: package-private */
    public boolean hasSubscribers() {
        return this.subscribers.get().length != 0;
    }

    /* access modifiers changed from: package-private */
    public long cachedEventCount() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public void add(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription<T>[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.subscribers.get();
            if (cacheSubscriptionArr != TERMINATED) {
                int length = cacheSubscriptionArr.length;
                cacheSubscriptionArr2 = new CacheSubscription[(length + 1)];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
                cacheSubscriptionArr2[length] = cacheSubscription;
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    public void remove(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription<T>[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.subscribers.get();
            int length = cacheSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheSubscriptionArr[i2] == cacheSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cacheSubscriptionArr2 = EMPTY;
                    } else {
                        CacheSubscription<T>[] cacheSubscriptionArr3 = new CacheSubscription[(length - 1)];
                        System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i);
                        System.arraycopy(cacheSubscriptionArr, i + 1, cacheSubscriptionArr3, i, (length - i) - 1);
                        cacheSubscriptionArr2 = cacheSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    public void replay(CacheSubscription<T> cacheSubscription) {
        if (cacheSubscription.getAndIncrement() == 0) {
            long j = cacheSubscription.index;
            int i = cacheSubscription.offset;
            Node<T> node = cacheSubscription.node;
            AtomicLong atomicLong = cacheSubscription.requested;
            Subscriber<? super T> subscriber = cacheSubscription.downstream;
            int i2 = this.capacityHint;
            int i3 = 1;
            while (true) {
                boolean z = this.done;
                boolean z2 = this.size == j;
                if (!z || !z2) {
                    if (!z2) {
                        long j2 = atomicLong.get();
                        if (j2 == Long.MIN_VALUE) {
                            cacheSubscription.node = null;
                            return;
                        } else if (j2 != j) {
                            if (i == i2) {
                                node = node.next;
                                i = 0;
                            }
                            subscriber.onNext(node.values[i]);
                            i++;
                            j++;
                        }
                    }
                    cacheSubscription.index = j;
                    cacheSubscription.offset = i;
                    cacheSubscription.node = node;
                    i3 = cacheSubscription.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    cacheSubscription.node = null;
                    Throwable th = this.error;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        subscription.request(LongCompanionObject.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        int i = this.tailOffset;
        if (i == this.capacityHint) {
            Node<T> node = new Node<>(i);
            node.values[0] = t;
            this.tailOffset = 1;
            this.tail.next = node;
            this.tail = node;
        } else {
            this.tail.values[i] = t;
            this.tailOffset = i + 1;
        }
        this.size++;
        for (CacheSubscription<T> cacheSubscription : this.subscribers.get()) {
            replay(cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.error = th;
        this.done = true;
        for (CacheSubscription<T> cacheSubscription : this.subscribers.getAndSet(TERMINATED)) {
            replay(cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        for (CacheSubscription<T> cacheSubscription : this.subscribers.getAndSet(TERMINATED)) {
            replay(cacheSubscription);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final Subscriber<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested = new AtomicLong();

        CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.downstream = subscriber;
            this.parent = flowableCache;
            this.node = flowableCache.head;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this.requested, j);
                this.parent.replay(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int i) {
            this.values = (T[]) new Object[i];
        }
    }
}
