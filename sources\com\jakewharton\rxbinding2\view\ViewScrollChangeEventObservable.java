package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class ViewScrollChangeEventObservable extends Observable<ViewScrollChangeEvent> {
    private final View view;

    ViewScrollChangeEventObservable(View view2) {
        this.view = view2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super ViewScrollChangeEvent> observer) {
        if (Preconditions.checkMainThread(observer)) {
            Listener listener = new Listener(this.view, observer);
            observer.onSubscribe(listener);
            this.view.setOnScrollChangeListener(listener);
        }
    }

    static final class Listener extends MainThreadDisposable implements View.OnScrollChangeListener {
        private final Observer<? super ViewScrollChangeEvent> observer;
        private final View view;

        Listener(View view2, Observer<? super ViewScrollChangeEvent> observer2) {
            this.view = view2;
            this.observer = observer2;
        }

        public void onScrollChange(View view2, int i, int i2, int i3, int i4) {
            if (!isDisposed()) {
                this.observer.onNext(ViewScrollChangeEvent.create(view2, i, i2, i3, i4));
            }
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.view.setOnScrollChangeListener(null);
        }
    }
}
