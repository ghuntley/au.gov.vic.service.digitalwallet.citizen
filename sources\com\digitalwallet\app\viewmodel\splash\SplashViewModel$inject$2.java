package com.digitalwallet.app.viewmodel.splash;

import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: SplashViewModel.kt */
public final class SplashViewModel$inject$2 implements Action {
    final /* synthetic */ SplashViewModel this$0;

    SplashViewModel$inject$2(SplashViewModel splashViewModel) {
        this.this$0 = splashViewModel;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        SplashViewModel.access$getSplashView$p(this.this$0).navigateToPin();
        this.this$0.authUtility.setFirstRun();
    }
}
