package com.google.android.gms.internal.gtm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* access modifiers changed from: package-private */
public class zzex extends BroadcastReceiver {
    private static final String zzabm = "com.google.android.gms.internal.gtm.zzex";
    private final zzfn zzaof;

    zzex(zzfn zzfn) {
        this.zzaof = zzfn;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.zzaof.zzf(!bool.booleanValue());
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(zzabm)) {
            this.zzaof.zzjp();
        }
    }

    public static void zzn(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzabm, true);
        context.sendBroadcast(intent);
    }
}
