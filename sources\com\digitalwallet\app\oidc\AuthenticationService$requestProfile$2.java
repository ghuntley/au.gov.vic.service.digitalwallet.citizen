package com.digitalwallet.app.oidc;

import com.digitalwallet.app.oidc.model.Profile;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/oidc/model/Profile;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final class AuthenticationService$requestProfile$2<T> implements Consumer<Profile> {
    final /* synthetic */ AuthenticationService this$0;

    AuthenticationService$requestProfile$2(AuthenticationService authenticationService) {
        this.this$0 = authenticationService;
    }

    public final void accept(Profile profile) {
        this.this$0.getAuthenticationUtility().newLoginSession$app_citizenProdRelease();
    }
}
