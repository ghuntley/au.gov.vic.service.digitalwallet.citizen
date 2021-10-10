package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.Call;
import retrofit2.CallAdapter;

final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    @Nullable
    private final Scheduler scheduler;

    RxJava2CallAdapter(Type type, @Nullable Scheduler scheduler2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.responseType = type;
        this.scheduler = scheduler2;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isFlowable = z4;
        this.isSingle = z5;
        this.isMaybe = z6;
        this.isCompletable = z7;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> call) {
        Observable observable;
        Scheduler scheduler2;
        Observable bodyObservable;
        if (this.isAsync) {
            observable = new CallEnqueueObservable(call);
        } else {
            observable = new CallExecuteObservable(call);
        }
        if (this.isResult) {
            bodyObservable = new ResultObservable(observable);
        } else {
            if (this.isBody) {
                bodyObservable = new BodyObservable(observable);
            }
            scheduler2 = this.scheduler;
            if (scheduler2 != null) {
                observable = observable.subscribeOn(scheduler2);
            }
            if (!this.isFlowable) {
                return observable.toFlowable(BackpressureStrategy.LATEST);
            }
            if (this.isSingle) {
                return observable.singleOrError();
            }
            if (this.isMaybe) {
                return observable.singleElement();
            }
            return this.isCompletable ? observable.ignoreElements() : observable;
        }
        observable = bodyObservable;
        scheduler2 = this.scheduler;
        if (scheduler2 != null) {
        }
        if (!this.isFlowable) {
        }
    }
}
