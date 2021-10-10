package com.digitalwallet.app.view.harvester;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.util.AlertFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestActivity.kt */
final class HarvestActivity$closeJob$deleteSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $jobId;
    final /* synthetic */ HarvestActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestActivity$closeJob$deleteSuccess$1(HarvestActivity harvestActivity, long j) {
        super(0);
        this.this$0 = harvestActivity;
        this.$jobId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.getViewModel().deleteJob(this.$jobId);
        AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, this.this$0.getString(R.string.success_RES_2114650501), null, false, this.this$0.getString(R.string.harvest_job_delete_this_job_success_message), null, null, this.this$0.getString(R.string.ok_RES_2114650415), null, null, null, false, 1974, null);
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
        beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
    }
}
