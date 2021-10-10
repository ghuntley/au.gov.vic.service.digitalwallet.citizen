package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayError;
    final int prefetch;
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.selector = function;
        this.prefetch = i;
        this.delayError = z;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.prefetch, this.delayError);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.selector.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.source.subscribe((FlowableSubscriber) multicastProcessor);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> downstream;
        final MulticastProcessor<?> processor;
        Subscription upstream;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.downstream = subscriber;
            this.processor = multicastProcessor;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.processor.dispose();
        }
    }

    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
        static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
        int consumed;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        volatile SimpleQueue<T> queue;
        int sourceMode;
        final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicReference<Subscription> upstream = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        MulticastProcessor(int i, boolean z) {
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.delayError = z;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        QueueDrainHelper.request(subscription, this.prefetch);
                        return;
                    }
                }
                this.queue = QueueDrainHelper.createQueue(this.prefetch);
                QueueDrainHelper.request(subscription, this.prefetch);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.upstream);
            if (this.wip.getAndIncrement() == 0 && (simpleQueue = this.queue) != null) {
                simpleQueue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0 || this.queue.offer(t)) {
                    drain();
                    return;
                }
                this.upstream.get().cancel();
                onError(new MissingBackpressureException());
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
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean add(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.subscribers.get();
                if (multicastSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void remove(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.subscribers.get();
                int length = multicastSubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            multicastSubscriptionArr2 = EMPTY;
                        } else {
                            MulticastSubscription<T>[] multicastSubscriptionArr3 = new MulticastSubscription[(length - 1)];
                            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                            System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                            multicastSubscriptionArr2 = multicastSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (!add(multicastSubscription)) {
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
            } else if (multicastSubscription.isCancelled()) {
                remove(multicastSubscription);
            } else {
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f8, code lost:
            if (r7 != 0) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fe, code lost:
            if (isDisposed() == false) goto L_0x0104;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0100, code lost:
            r0.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0103, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0104, code lost:
            r5 = r24.done;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0106, code lost:
            if (r5 == false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x010a, code lost:
            if (r24.delayError != false) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x010c, code lost:
            r6 = r24.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x010e, code lost:
            if (r6 == null) goto L_0x0114;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0110, code lost:
            errorAll(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0113, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0114, code lost:
            if (r5 == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x011a, code lost:
            if (r0.isEmpty() == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x011c, code lost:
            r0 = r24.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x011e, code lost:
            if (r0 == null) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0120, code lost:
            errorAll(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0124, code lost:
            completeAll();
         */
        public void drain() {
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            MulticastSubscription<T>[] multicastSubscriptionArr;
            Throwable th;
            if (this.wip.getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.queue;
                int i = this.consumed;
                int i2 = this.limit;
                boolean z = this.sourceMode != 1;
                AtomicReference<MulticastSubscription<T>[]> atomicReference2 = this.subscribers;
                MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference2.get();
                int i3 = 1;
                while (true) {
                    int length = multicastSubscriptionArr2.length;
                    if (simpleQueue == null || length == 0) {
                        atomicReference = atomicReference2;
                    } else {
                        int length2 = multicastSubscriptionArr2.length;
                        long j = LongCompanionObject.MAX_VALUE;
                        long j2 = Long.MAX_VALUE;
                        int i4 = 0;
                        while (i4 < length2) {
                            MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr2[i4];
                            long j3 = multicastSubscription.get() - multicastSubscription.emitted;
                            if (j3 == Long.MIN_VALUE) {
                                length--;
                            } else if (j2 > j3) {
                                j2 = j3;
                            }
                            i4++;
                            atomicReference2 = atomicReference2;
                        }
                        atomicReference = atomicReference2;
                        long j4 = 0;
                        if (length == 0) {
                            j2 = 0;
                        }
                        while (true) {
                            int i5 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
                            if (i5 == 0) {
                                break;
                            } else if (isDisposed()) {
                                simpleQueue.clear();
                                return;
                            } else {
                                boolean z2 = this.done;
                                if (!z2 || this.delayError || (th = this.error) == null) {
                                    try {
                                        T poll = simpleQueue.poll();
                                        boolean z3 = poll == null;
                                        if (z2 && z3) {
                                            Throwable th2 = this.error;
                                            if (th2 != null) {
                                                errorAll(th2);
                                                return;
                                            } else {
                                                completeAll();
                                                return;
                                            }
                                        } else if (z3) {
                                            break;
                                        } else {
                                            int length3 = multicastSubscriptionArr2.length;
                                            int i6 = 0;
                                            boolean z4 = false;
                                            while (i6 < length3) {
                                                MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr2[i6];
                                                long j5 = multicastSubscription2.get();
                                                if (j5 != Long.MIN_VALUE) {
                                                    if (j5 != j) {
                                                        multicastSubscription2.emitted++;
                                                    }
                                                    multicastSubscription2.downstream.onNext(poll);
                                                } else {
                                                    z4 = true;
                                                }
                                                i6++;
                                                j = LongCompanionObject.MAX_VALUE;
                                            }
                                            j2--;
                                            if (z && (i = i + 1) == i2) {
                                                this.upstream.get().request((long) i2);
                                                i = 0;
                                            }
                                            multicastSubscriptionArr = atomicReference.get();
                                            if (z4 || multicastSubscriptionArr != multicastSubscriptionArr2) {
                                                multicastSubscriptionArr2 = multicastSubscriptionArr;
                                            } else {
                                                j4 = 0;
                                                j = LongCompanionObject.MAX_VALUE;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        SubscriptionHelper.cancel(this.upstream);
                                        errorAll(th3);
                                        return;
                                    }
                                } else {
                                    errorAll(th);
                                    return;
                                }
                            }
                        }
                        multicastSubscriptionArr2 = multicastSubscriptionArr;
                        atomicReference2 = atomicReference;
                    }
                    this.consumed = i;
                    i3 = this.wip.addAndGet(-i3);
                    if (i3 != 0) {
                        if (simpleQueue == null) {
                            simpleQueue = this.queue;
                        }
                        multicastSubscriptionArr2 = atomicReference.get();
                        atomicReference2 = atomicReference;
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void errorAll(Throwable th) {
            MulticastSubscription<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
            for (MulticastSubscription<T> multicastSubscription : andSet) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void completeAll() {
            MulticastSubscription<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
            for (MulticastSubscription<T> multicastSubscription : andSet) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }
    }
}
