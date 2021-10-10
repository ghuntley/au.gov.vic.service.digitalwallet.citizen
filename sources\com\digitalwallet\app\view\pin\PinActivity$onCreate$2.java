package com.digitalwallet.app.view.pin;

import android.text.Editable;
import android.text.TextWatcher;
import com.digitalwallet.app.databinding.PinBinding;
import com.mukesh.OtpView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.TextBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/digitalwallet/app/view/pin/PinActivity$onCreate$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", TextBundle.TEXT_ENTRY, "", "start", "", "count", "after", "onTextChanged", "before", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: PinActivity.kt */
public final class PinActivity$onCreate$2 implements TextWatcher {
    final /* synthetic */ PinActivity this$0;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    PinActivity$onCreate$2(PinActivity pinActivity) {
        this.this$0 = pinActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        OtpView otpView = ((PinBinding) this.this$0.getBinding()).pinText;
        Intrinsics.checkNotNullExpressionValue(otpView, "binding.pinText");
        otpView.setTextAlignment(charSequence == null || charSequence.length() == 0 ? 2 : 4);
    }
}
