package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.utilities.AnalyticsHelper;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: LoginActivityViewModel.kt */
public final class LoginActivityViewModel$handleLoginActivityResult$2 implements Action {
    final /* synthetic */ LoginActivityViewModel this$0;

    LoginActivityViewModel$handleLoginActivityResult$2(LoginActivityViewModel loginActivityViewModel) {
        this.this$0 = loginActivityViewModel;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        AnalyticsHelper.selectContent$default(this.this$0.analytics, "Login success", null, 2, null);
    }
}
