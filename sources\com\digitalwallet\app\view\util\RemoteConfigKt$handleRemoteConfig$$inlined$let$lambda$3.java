package com.digitalwallet.app.view.util;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.RemoteConfigNotice;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/digitalwallet/app/view/util/RemoteConfigKt$handleRemoteConfig$2$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$3 implements Runnable {
    final /* synthetic */ RemoteConfigNotice $notice;
    final /* synthetic */ SharedPreferences $prefs;
    final /* synthetic */ AppCompatActivity $this_handleRemoteConfig$inlined;

    RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$3(RemoteConfigNotice remoteConfigNotice, SharedPreferences sharedPreferences, AppCompatActivity appCompatActivity) {
        this.$notice = remoteConfigNotice;
        this.$prefs = sharedPreferences;
        this.$this_handleRemoteConfig$inlined = appCompatActivity;
    }

    public final void run() {
        new AlertDialog.Builder(this.$this_handleRemoteConfig$inlined).setTitle(this.$notice.getTitle()).setMessage(this.$notice.getMessage()).setCancelable(false).setPositiveButton(R.string.understood_RES_2114650511, new DialogInterface.OnClickListener(this) {
            /* class com.digitalwallet.app.view.util.RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$3.AnonymousClass1 */
            final /* synthetic */ RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$3 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.this$0.$prefs.edit().putString(RemoteConfigKt.KEY_LAST_SHOWN_TITLE, this.this$0.$notice.getTitle()).putString(RemoteConfigKt.KEY_LAST_SHOWN_MESSAGE, this.this$0.$notice.getMessage()).apply();
            }
        }).show();
    }
}
