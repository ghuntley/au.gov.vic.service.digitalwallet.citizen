package com.digitalwallet.app.view.splash;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: SplashActivity.kt */
final class SplashActivity$onCreate$1<T> implements Observer<Boolean> {
    final /* synthetic */ SplashActivity this$0;

    SplashActivity$onCreate$1(SplashActivity splashActivity) {
        this.this$0 = splashActivity;
    }

    public final void onChanged(Boolean bool) {
        this.this$0.navigateToLogin(Intrinsics.areEqual((Object) bool, (Object) true));
    }
}
