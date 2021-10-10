package com.digitalwallet.app.view.harvester;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "onBackStackChanged", "com/digitalwallet/app/view/harvester/HarvestActivity$onCreate$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestActivity.kt */
final class HarvestActivity$onCreate$$inlined$also$lambda$1 implements FragmentManager.OnBackStackChangedListener {
    final /* synthetic */ HarvestJobListFragment $fragment$inlined;
    final /* synthetic */ HarvestActivity this$0;

    HarvestActivity$onCreate$$inlined$also$lambda$1(HarvestActivity harvestActivity, HarvestJobListFragment harvestJobListFragment) {
        this.this$0 = harvestActivity;
        this.$fragment$inlined = harvestJobListFragment;
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final void onBackStackChanged() {
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        int i = 0;
        for (T t : fragments) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            boolean z = true;
            if (i != fragments.size() - 1) {
                z = false;
            }
            t2.setUserVisibleHint(z);
            i = i2;
        }
    }
}
