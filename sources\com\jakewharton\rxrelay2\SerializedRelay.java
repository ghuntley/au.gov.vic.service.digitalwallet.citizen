package com.jakewharton.rxrelay2;

import io.reactivex.Observer;

final class SerializedRelay<T> extends Relay<T> {
    private final Relay<T> actual;
    private boolean emitting;
    private AppendOnlyLinkedArrayList<T> queue;

    SerializedRelay(Relay<T> relay) {
        this.actual = relay;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.actual.subscribe(observer);
    }

    @Override // com.jakewharton.rxrelay2.Relay, io.reactivex.functions.Consumer
    public void accept(T t) {
        synchronized (this) {
            if (this.emitting) {
                AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.queue = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(t);
                return;
            }
            this.emitting = true;
            this.actual.accept(t);
            emitLoop();
        }
    }

    private void emitLoop() {
        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
            appendOnlyLinkedArrayList.accept(this.actual);
        }
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public boolean hasObservers() {
        return this.actual.hasObservers();
    }
}
