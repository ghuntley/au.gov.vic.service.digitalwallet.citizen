package com.digitalwallet.app.viewmodel.splash;

import com.digitalwallet.app.oidc.AuthSession;
import com.digitalwallet.app.oidc.model.Tokens;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/digitalwallet/app/oidc/model/Tokens;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/oidc/AuthSession;", "apply", "com/digitalwallet/app/viewmodel/splash/SplashViewModel$refresh$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: SplashViewModel.kt */
public final class SplashViewModel$refresh$$inlined$let$lambda$1<T, R> implements Function<AuthSession, SingleSource<? extends Tokens>> {
    final /* synthetic */ Tokens $tokens;
    final /* synthetic */ SplashViewModel this$0;

    SplashViewModel$refresh$$inlined$let$lambda$1(Tokens tokens, SplashViewModel splashViewModel) {
        this.$tokens = tokens;
        this.this$0 = splashViewModel;
    }

    public final SingleSource<? extends Tokens> apply(AuthSession authSession) {
        Intrinsics.checkNotNullParameter(authSession, "it");
        return this.this$0.authService.refreshAuthorization(authSession, this.$tokens);
    }
}
