package com.digitalwallet.app.viewmodel.login;

import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.ValidationHelperKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CreateAccountViewModel.kt */
public final class CreateAccountViewModel$onGivenNamesChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CreateAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateAccountViewModel$onGivenNamesChanged$1(CreateAccountViewModel createAccountViewModel) {
        super(0);
        this.this$0 = createAccountViewModel;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004f  */
    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        boolean z;
        String str;
        String str2 = this.this$0.getGivenNames().get();
        if (str2 == null) {
            str2 = "";
        }
        Intrinsics.checkNotNullExpressionValue(str2, "(givenNames.get() ?: \"\")");
        Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj = StringsKt.trim((CharSequence) str2).toString();
        if (ValidationHelperKt.isNameValid(obj)) {
            int i = this.this$0.givenNamesMinLength;
            int i2 = this.this$0.givenNamesMaxLength;
            int length = obj.length();
            if (i <= length && i2 >= length) {
                z = true;
                ObservableField<String> givenNamesError = this.this$0.getGivenNamesError();
                if (!z) {
                    str = null;
                } else {
                    str = this.this$0.context.getString(R.string.error_invalid_name, Integer.valueOf(this.this$0.givenNamesMinLength), Integer.valueOf(this.this$0.givenNamesMaxLength));
                }
                givenNamesError.set(str);
                this.this$0.onAnInputChanged();
            }
        }
        z = false;
        ObservableField<String> givenNamesError2 = this.this$0.getGivenNamesError();
        if (!z) {
        }
        givenNamesError2.set(str);
        this.this$0.onAnInputChanged();
    }
}
