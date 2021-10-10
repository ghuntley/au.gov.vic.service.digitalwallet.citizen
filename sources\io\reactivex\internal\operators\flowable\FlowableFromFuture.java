package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableFromFuture<T> extends Flowable<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public FlowableFromFuture(Future<? extends T> future2, long j, TimeUnit timeUnit) {
        this.future = future2;
        this.timeout = j;
        this.unit = timeUnit;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.internal.subscriptions.DeferredScalarSubscription */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.unit;
            Object obj = timeUnit != null ? this.future.get(this.timeout, timeUnit) : this.future.get();
            if (obj == null) {
                subscriber.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.complete(obj);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!deferredScalarSubscription.isCancelled()) {
                subscriber.onError(th);
            }
        }
    }
}
