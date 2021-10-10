package com.digitalwallet.app.view.login;

import android.app.AlertDialog;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: VerifyEmailFragment.kt */
public final class VerifyEmailFragment$observeEvents$1 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ VerifyEmailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyEmailFragment$observeEvents$1(VerifyEmailFragment verifyEmailFragment) {
        super(1);
        this.this$0 = verifyEmailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke(unit);
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        this.this$0.getViewModel().clearOtpInput();
        new AlertDialog.Builder(this.this$0.getContext()).setTitle(R.string.email_sent).setMessage(R.string.email_successfully_resent).setPositiveButton(R.string.ok_RES_2114650415, AnonymousClass1.INSTANCE).show();
    }
}
