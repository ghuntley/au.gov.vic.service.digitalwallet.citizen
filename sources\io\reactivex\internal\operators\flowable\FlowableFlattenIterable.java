package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        super(flowable);
        this.mapper = function;
        this.prefetch = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (this.source instanceof Callable) {
            try {
                Object call = ((Callable) this.source).call();
                if (call == null) {
                    EmptySubscription.complete(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.subscribe(subscriber, ((Iterable) this.mapper.apply(call)).iterator());
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        } else {
            this.source.subscribe((FlowableSubscriber) new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch));
        }
    }

    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        int fusionMode;
        final int limit;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription upstream;

        FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.downstream.onSubscribe(this);
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (this.fusionMode != 0 || this.queue.offer(t)) {
                    drain();
                } else {
                    onError(new MissingBackpressureException("Queue is full?!"));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done || !ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
                return;
            }
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

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x001a */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0121, code lost:
            if (r6 == null) goto L_0x012c;
         */
        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<?> subscriber = this.downstream;
                SimpleQueue<T> simpleQueue = this.queue;
                boolean z = true;
                boolean z2 = this.fusionMode != 1;
                Iterator<T> it = this.current;
                int i = 1;
                while (true) {
                    if (it == null) {
                        boolean z3 = this.done;
                        try {
                            T poll = simpleQueue.poll();
                            if (!checkTerminated(z3, poll == null ? z : false, subscriber, simpleQueue)) {
                                if (poll != null) {
                                    try {
                                        it = ((Iterable) this.mapper.apply(poll)).iterator();
                                        if (!it.hasNext()) {
                                            consumedOne(z2);
                                            it = null;
                                        } else {
                                            this.current = it;
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.upstream.cancel();
                                        ExceptionHelper.addThrowable(this.error, th);
                                        subscriber.onError(ExceptionHelper.terminate(this.error));
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.upstream.cancel();
                            ExceptionHelper.addThrowable(this.error, th2);
                            Throwable terminate = ExceptionHelper.terminate(this.error);
                            this.current = null;
                            simpleQueue.clear();
                            subscriber.onError(terminate);
                            return;
                        }
                    }
                    if (it != null) {
                        long j = this.requested.get();
                        long j2 = 0;
                        while (true) {
                            if (j2 == j) {
                                break;
                            } else if (!checkTerminated(this.done, false, subscriber, simpleQueue)) {
                                try {
                                    subscriber.onNext((Object) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                                    if (!checkTerminated(this.done, false, subscriber, simpleQueue)) {
                                        j2++;
                                        try {
                                            if (!it.hasNext()) {
                                                consumedOne(z2);
                                                this.current = null;
                                                it = null;
                                                break;
                                            }
                                        } catch (Throwable th3) {
                                            Exceptions.throwIfFatal(th3);
                                            this.current = null;
                                            this.upstream.cancel();
                                            ExceptionHelper.addThrowable(this.error, th3);
                                            subscriber.onError(ExceptionHelper.terminate(this.error));
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th4) {
                                    Exceptions.throwIfFatal(th4);
                                    this.current = null;
                                    this.upstream.cancel();
                                    ExceptionHelper.addThrowable(this.error, th4);
                                    subscriber.onError(ExceptionHelper.terminate(this.error));
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (j2 == j) {
                            if (checkTerminated(this.done, simpleQueue.isEmpty() && it == null, subscriber, simpleQueue)) {
                                return;
                            }
                        }
                        if (!(j2 == 0 || j == LongCompanionObject.MAX_VALUE)) {
                            this.requested.addAndGet(-j2);
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                    z = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void consumedOne(boolean z) {
            if (z) {
                int i = this.consumed + 1;
                if (i == this.limit) {
                    this.consumed = 0;
                    this.upstream.request((long) i);
                    return;
                }
                this.consumed = i;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.cancelled) {
                this.current = null;
                simpleQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionHelper.terminate(this.error);
                    this.current = null;
                    simpleQueue.clear();
                    subscriber.onError(terminate);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.current == null && this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
            Iterator<T> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = ((Iterable) this.mapper.apply(poll)).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r = (R) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return r;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }
}
