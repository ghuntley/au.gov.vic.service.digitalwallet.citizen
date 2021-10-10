package com.digitalwallet.app.viewmodel.login;

import android.content.Context;
import android.content.Intent;
import com.digitalwallet.app.oidc.AuthSession;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.RetrofitHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.firebase.messaging.Constants;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/app/viewmodel/login/LoginActivityViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "authenticationService", "Lcom/digitalwallet/app/oidc/AuthenticationService;", "moshi", "Lcom/squareup/moshi/Moshi;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "context", "Landroid/content/Context;", "(Lcom/digitalwallet/app/oidc/AuthenticationService;Lcom/squareup/moshi/Moshi;Lcom/digitalwallet/utilities/AnalyticsHelper;Landroid/content/Context;)V", "authSession", "Lcom/digitalwallet/app/oidc/AuthSession;", "getAuthSession", "()Lcom/digitalwallet/app/oidc/AuthSession;", "setAuthSession", "(Lcom/digitalwallet/app/oidc/AuthSession;)V", "getAuthRequest", "Lio/reactivex/Single;", "Lnet/openid/appauth/AuthorizationRequest;", "handleLoginActivityResult", "Lio/reactivex/Completable;", "requestCode", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LoginActivityViewModel.kt */
public final class LoginActivityViewModel extends BaseViewModel {
    private final AnalyticsHelper analytics;
    private AuthSession authSession;
    private final AuthenticationService authenticationService;
    private final Context context;
    private final Moshi moshi;

    @Inject
    public LoginActivityViewModel(AuthenticationService authenticationService2, Moshi moshi2, AnalyticsHelper analyticsHelper, Context context2) {
        Intrinsics.checkNotNullParameter(authenticationService2, "authenticationService");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.authenticationService = authenticationService2;
        this.moshi = moshi2;
        this.analytics = analyticsHelper;
        this.context = context2;
    }

    public final AuthSession getAuthSession() {
        return this.authSession;
    }

    public final void setAuthSession(AuthSession authSession2) {
        this.authSession = authSession2;
    }

    public final Single<AuthorizationRequest> getAuthRequest() {
        Single<R> map = this.authenticationService.generateAuthSession().doOnSuccess(new LoginActivityViewModel$getAuthRequest$1(this)).map(new LoginActivityViewModel$getAuthRequest$2(this));
        Intrinsics.checkNotNullExpressionValue(map, "authenticationService.ge…orizationRequest(moshi) }");
        return map;
    }

    public final Completable handleLoginActivityResult(int i, Intent intent, AuthSession authSession2) {
        Intrinsics.checkNotNullParameter(intent, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        Intrinsics.checkNotNullParameter(authSession2, "authSession");
        Completable doOnComplete = this.authenticationService.handleAuthenticationResponse(i, intent, authSession2, this.context).doOnError(new LoginActivityViewModel$sam$io_reactivex_functions_Consumer$0(new LoginActivityViewModel$handleLoginActivityResult$1(RetrofitHelper.Companion))).doOnComplete(new LoginActivityViewModel$handleLoginActivityResult$2(this));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "authenticationService.ha…ontent(\"Login success\") }");
        return doOnComplete;
    }
}
