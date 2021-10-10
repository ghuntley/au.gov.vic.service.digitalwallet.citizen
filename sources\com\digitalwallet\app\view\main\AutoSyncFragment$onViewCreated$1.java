package com.digitalwallet.app.view.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.AttributeDetailItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: AutoSyncFragment.kt */
final class AutoSyncFragment$onViewCreated$1<T> implements Observer<Boolean> {
    final /* synthetic */ boolean $setup;
    final /* synthetic */ AutoSyncFragment this$0;

    AutoSyncFragment$onViewCreated$1(AutoSyncFragment autoSyncFragment, boolean z) {
        this.this$0 = autoSyncFragment;
        this.$setup = z;
    }

    public final void onChanged(Boolean bool) {
        String str;
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            str = "Automatic";
        } else {
            str = Intrinsics.areEqual(bool, false) ? "Manual" : AttributeDetailItem.NOT_AVAILABLE;
        }
        this.this$0.getAnalytics().selectContent("New items sync", str);
        if (this.$setup) {
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            NicknameCreateFragment nicknameCreateFragment = new NicknameCreateFragment();
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
            for (T t : fragments) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                t.setUserVisibleHint(false);
            }
            FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
            String simpleName = Reflection.getOrCreateKotlinClass(NicknameCreateFragment.class).getSimpleName();
            beginTransaction.add(R.id.fragment_container_RES_2114322527, nicknameCreateFragment, simpleName).addToBackStack(simpleName).commit();
            this.this$0.getAnalytics().viewItem("Alert", "Setup complete");
            return;
        }
        this.this$0.getParentFragmentManager().popBackStack((String) null, 1);
    }
}
