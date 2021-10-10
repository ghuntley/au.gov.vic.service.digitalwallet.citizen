package com.digitalwallet.app.view.harvester;

import android.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/digitalwallet/utilities/StandardHelperKt$main$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class HarvestActivity$toast$$inlined$main$1 implements Runnable {
    final /* synthetic */ int $message$inlined;
    final /* synthetic */ HarvestActivity this$0;

    public HarvestActivity$toast$$inlined$main$1(HarvestActivity harvestActivity, int i) {
        this.this$0 = harvestActivity;
        this.$message$inlined = i;
    }

    public final void run() {
        HarvestActivity harvestActivity = this.this$0;
        Toast.makeText(harvestActivity, harvestActivity.getString(this.$message$inlined), 0).show();
    }
}
