package com.digitalwallet.app.view.main;

import com.digitalwallet.utilities.FragmentHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: NicknameEditFragment.kt */
final class NicknameEditFragment$done$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NicknameEditFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NicknameEditFragment$done$1(NicknameEditFragment nicknameEditFragment) {
        super(0);
        this.this$0 = nicknameEditFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        FragmentHelperKt.hideKeyboard(this.this$0);
        this.this$0.getParentFragmentManager().popBackStack();
    }
}
