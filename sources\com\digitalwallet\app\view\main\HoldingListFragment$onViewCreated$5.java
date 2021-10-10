package com.digitalwallet.app.view.main;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.main.holdings.MoreCardsInfoFragment;
import com.digitalwallet.utilities.AnalyticsHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
final class HoldingListFragment$onViewCreated$5 implements View.OnClickListener {
    final /* synthetic */ HoldingListFragment this$0;

    HoldingListFragment$onViewCreated$5(HoldingListFragment holdingListFragment) {
        this.this$0 = holdingListFragment;
    }

    public final void onClick(View view) {
        AnalyticsHelper.selectContent$default(this.this$0.getAnalytics(), "More info about cards - Button", null, 2, null);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MoreCardsInfoFragment moreCardsInfoFragment = new MoreCardsInfoFragment();
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(MoreCardsInfoFragment.class).getSimpleName();
        beginTransaction.add(R.id.fragment_container_RES_2114322527, moreCardsInfoFragment, simpleName).addToBackStack(simpleName).commit();
    }
}
