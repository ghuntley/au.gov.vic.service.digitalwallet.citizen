package com.digitalwallet.app.viewmodel.splash;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/CompletableObserver;", "subscribe", "com/digitalwallet/app/viewmodel/splash/SplashViewModel$refresh$1$2"}, k = 3, mv = {1, 4, 0})
/* compiled from: SplashViewModel.kt */
public final class SplashViewModel$refresh$$inlined$let$lambda$2 implements CompletableSource {
    final /* synthetic */ SplashViewModel this$0;

    SplashViewModel$refresh$$inlined$let$lambda$2(SplashViewModel splashViewModel) {
        this.this$0 = splashViewModel;
    }

    @Override // io.reactivex.CompletableSource
    public final void subscribe(CompletableObserver completableObserver) {
        Intrinsics.checkNotNullParameter(completableObserver, "it");
        if (this.this$0.authUtility.getUserPin() != null) {
            completableObserver.onComplete();
        } else {
            completableObserver.onError(new PinNotSetException());
        }
    }
}
