package com.google.android.gms.internal.gtm;

import android.content.DialogInterface;
import android.content.Intent;

final class zzfc implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzfb zzaop;

    zzfc(zzfb zzfb) {
        this.zzaop = zzfb;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String packageName = zzfb.zza(this.zzaop).getPackageName();
        Intent launchIntentForPackage = zzfb.zza(this.zzaop).getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage != null) {
            String valueOf = String.valueOf(packageName);
            zzev.zzaw(valueOf.length() != 0 ? "Invoke the launch activity for package name: ".concat(valueOf) : new String("Invoke the launch activity for package name: "));
            zzfb.zza(this.zzaop).startActivity(launchIntentForPackage);
            return;
        }
        String valueOf2 = String.valueOf(packageName);
        zzev.zzac(valueOf2.length() != 0 ? "No launch activity found for package name: ".concat(valueOf2) : new String("No launch activity found for package name: "));
    }
}
