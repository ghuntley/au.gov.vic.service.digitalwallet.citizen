package com.jakewharton.rxrelay2;

import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.functions.Consumer;

public abstract class Relay<T> extends Observable<T> implements Consumer<T> {
    @Override // io.reactivex.functions.Consumer
    public abstract void accept(T t);

    public abstract boolean hasObservers();

    @CheckReturnValue
    public final Relay<T> toSerialized() {
        if (this instanceof SerializedRelay) {
            return this;
        }
        return new SerializedRelay(this);
    }
}
