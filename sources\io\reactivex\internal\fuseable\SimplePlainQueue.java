package io.reactivex.internal.fuseable;

public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    @Override // io.reactivex.internal.fuseable.SimpleQueue
    T poll();
}
