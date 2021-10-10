package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

final class CallEnqueueObservable<T> extends Observable<Response<T>> {
    private final Call<T> originalCall;

    CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Response<T>> observer) {
        Call<T> clone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(clone, observer);
        observer.onSubscribe(callCallback);
        clone.enqueue(callCallback);
    }

    private static final class CallCallback<T> implements Disposable, Callback<T> {
        private final Call<?> call;
        private final Observer<? super Response<T>> observer;
        boolean terminated = false;

        CallCallback(Call<?> call2, Observer<? super Response<T>> observer2) {
            this.call = call2;
            this.observer = observer2;
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call2, Response<T> response) {
            if (!call2.isCanceled()) {
                try {
                    this.observer.onNext(response);
                    if (!call2.isCanceled()) {
                        this.terminated = true;
                        this.observer.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(new CompositeException(th, th));
                }
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call2, Throwable th) {
            if (!call2.isCanceled()) {
                try {
                    this.observer.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.call.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }
}
