package com.digitalwallet.app.view.harvester;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.harvester.HarvestTagView;
import com.digitalwallet.app.view.util.AlertFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestActivity.kt */
final class HarvestActivity$showTagSuccess$showNextOptions$1 extends Lambda implements Function0<Integer> {
    final /* synthetic */ int $numTags;
    final /* synthetic */ HarvestActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestActivity$showTagSuccess$showNextOptions$1(HarvestActivity harvestActivity, int i) {
        super(0);
        this.this$0 = harvestActivity;
        this.$numTags = i;
    }

    /* Return type fixed from 'int' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        AlertFragment.Companion companion = AlertFragment.Companion;
        Resources resources = this.this$0.getResources();
        int i = this.$numTags;
        AlertFragment create$default = AlertFragment.Companion.create$default(companion, null, HarvestActivityKt.getFragmentName(HarvestTagView.Screen.Scanner), false, resources.getQuantityString(R.plurals.harvest_tag_total_message, i, Integer.valueOf(i)), this.this$0.getString(R.string.harvest_tag_added_action), new HarvestActivity$showTagSuccess$showNextOptions$1$fragment$1(this), this.this$0.getString(R.string.harvest_tag_added_dismiss), null, Integer.valueOf((int) R.drawable.ic_icon_info_slate), null, false, 1665, null);
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(AlertFragment.class).getSimpleName();
        return beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
    }
}
