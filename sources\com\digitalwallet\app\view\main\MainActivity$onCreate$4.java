package com.digitalwallet.app.view.main;

import android.app.Application;
import androidx.lifecycle.Observer;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.view.pin.PinActivity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivity.kt */
public final class MainActivity$onCreate$4<T> implements Observer<Boolean> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$4(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void onChanged(Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            Application application = this.this$0.getApplication();
            Objects.requireNonNull(application, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
            if (((DigitalWalletApplication) application).isAppBackgrounded()) {
                PinActivity.Companion.launch(this.this$0, true);
            }
        }
    }
}
