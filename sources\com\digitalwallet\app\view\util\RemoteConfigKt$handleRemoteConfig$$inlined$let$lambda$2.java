package com.digitalwallet.app.view.util;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.RemoteConfigUpdateData;
import com.digitalwallet.utilities.ActivityHelperKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/digitalwallet/app/view/util/RemoteConfigKt$handleRemoteConfig$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$2 implements Runnable {
    final /* synthetic */ AnalyticsHelper $analytics$inlined;
    final /* synthetic */ RemoteConfigUpdateData $androidConfig;
    final /* synthetic */ AppCompatActivity $this_handleRemoteConfig$inlined;

    RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$2(RemoteConfigUpdateData remoteConfigUpdateData, AppCompatActivity appCompatActivity, AnalyticsHelper analyticsHelper) {
        this.$androidConfig = remoteConfigUpdateData;
        this.$this_handleRemoteConfig$inlined = appCompatActivity;
        this.$analytics$inlined = analyticsHelper;
    }

    public final void run() {
        new AlertDialog.Builder(this.$this_handleRemoteConfig$inlined).setTitle(this.$androidConfig.getTitle()).setMessage(this.$androidConfig.getMessage()).setPositiveButton(R.string.update_RES_2114650514, new DialogInterface.OnClickListener(this) {
            /* class com.digitalwallet.app.view.util.RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$2.AnonymousClass1 */
            final /* synthetic */ RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AnalyticsHelper.selectContent$default(this.this$0.$analytics$inlined, "Optional Upgrade - Update", null, 2, null);
                ActivityHelperKt.viewAppInStore(this.this$0.$this_handleRemoteConfig$inlined);
            }
        }).setNegativeButton(R.string.not_now_RES_2114650412, new DialogInterface.OnClickListener(this) {
            /* class com.digitalwallet.app.view.util.RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$2.AnonymousClass2 */
            final /* synthetic */ RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AnalyticsHelper.selectContent$default(this.this$0.$analytics$inlined, "Optional Upgrade - Not now", null, 2, null);
            }
        }).show();
    }
}
