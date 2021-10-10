package com.digitalwallet.app.viewmodel.splash;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/CompletableObserver;", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: SplashViewModel.kt */
public final class SplashViewModel$viewOnDelay$1 implements CompletableSource {
    public static final SplashViewModel$viewOnDelay$1 INSTANCE = new SplashViewModel$viewOnDelay$1();

    SplashViewModel$viewOnDelay$1() {
    }

    @Override // io.reactivex.CompletableSource
    public final void subscribe(CompletableObserver completableObserver) {
        Intrinsics.checkNotNullParameter(completableObserver, "it");
        completableObserver.onComplete();
    }
}
