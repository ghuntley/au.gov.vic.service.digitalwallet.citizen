package com.digitalwallet.app.view.login;

import android.content.Intent;
import com.digitalwallet.app.view.pin.PinActivity;
import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/digitalwallet/app/view/login/LoginActivity$onActivityResult$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: LoginActivity.kt */
final class LoginActivity$onActivityResult$$inlined$let$lambda$1 implements Action {
    final /* synthetic */ Intent $data$inlined;
    final /* synthetic */ int $requestCode$inlined;
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onActivityResult$$inlined$let$lambda$1(LoginActivity loginActivity, int i, Intent intent) {
        this.this$0 = loginActivity;
        this.$requestCode$inlined = i;
        this.$data$inlined = intent;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.this$0.startActivity(new Intent(this.this$0, PinActivity.class));
        this.this$0.dismissLoginProgressIndicator();
    }
}
