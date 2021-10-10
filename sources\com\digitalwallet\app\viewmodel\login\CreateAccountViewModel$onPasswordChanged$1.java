package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.utilities.ValidationHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CreateAccountViewModel.kt */
public final class CreateAccountViewModel$onPasswordChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CreateAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateAccountViewModel$onPasswordChanged$1(CreateAccountViewModel createAccountViewModel) {
        super(0);
        this.this$0 = createAccountViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        String str = this.this$0.getPassword().get();
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "password.get() ?: \"\"");
        boolean z = str.length() >= this.this$0.passwordMinLength;
        boolean containsAnUpperCaseLetter = ValidationHelperKt.containsAnUpperCaseLetter(str);
        boolean containsALowerCaseLetter = ValidationHelperKt.containsALowerCaseLetter(str);
        this.this$0.getPwLengthHintColor().set(Integer.valueOf(this.this$0.passwordHintColor(z)));
        this.this$0.getPwUpperLetterHintColor().set(Integer.valueOf(this.this$0.passwordHintColor(containsAnUpperCaseLetter)));
        this.this$0.getPwLowerLetterHintColor().set(Integer.valueOf(this.this$0.passwordHintColor(containsALowerCaseLetter)));
        this.this$0.onAnInputChanged();
    }
}
