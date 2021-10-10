package retrofit2.adapter.rxjava2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Call;
import retrofit2.Response;

final class CallExecuteObservable<T> extends Observable<Response<T>> {
    private final Call<T> originalCall;

    CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Response<T>> observer) {
        boolean z;
        Throwable th;
        Call<T> clone = this.originalCall.clone();
        observer.onSubscribe(new CallDisposable(clone));
        try {
            Response<T> execute = clone.execute();
            if (!clone.isCanceled()) {
                observer.onNext(execute);
            }
            if (!clone.isCanceled()) {
                try {
                    observer.onComplete();
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            Exceptions.throwIfFatal(th);
            if (z) {
                RxJavaPlugins.onError(th);
            } else if (!clone.isCanceled()) {
                try {
                    observer.onError(th);
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    RxJavaPlugins.onError(new CompositeException(th, th4));
                }
            }
        }
    }

    private static final class CallDisposable implements Disposable {
        private final Call<?> call;

        CallDisposable(Call<?> call2) {
            this.call = call2;
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
