package com.digitalwallet.app.view.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.util.AlertFragment;
import com.digitalwallet.utilities.FragmentHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: NicknameCreateFragment.kt */
final class NicknameCreateFragment$done$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NicknameCreateFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NicknameCreateFragment$done$1(NicknameCreateFragment nicknameCreateFragment) {
        super(0);
        this.this$0 = nicknameCreateFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        FragmentHelperKt.hideKeyboard(this.this$0);
        AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, this.this$0.getString(R.string.nickname_complete), null, false, null, null, null, null, null, null, null, false, 2046, null);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(AlertFragment.class).getSimpleName();
        beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
    }
}
