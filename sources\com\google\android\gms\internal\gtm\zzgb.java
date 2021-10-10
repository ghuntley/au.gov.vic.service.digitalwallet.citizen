package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.os.RemoteException;

final class zzgb implements Runnable {
    private boolean zzaqc = false;
    private final /* synthetic */ String zzaqd;
    private final /* synthetic */ Bundle zzaqe;
    private final /* synthetic */ String zzaqf;
    private final /* synthetic */ long zzaqg;
    private final /* synthetic */ String zzaqh;
    private final /* synthetic */ zzga zzaqi;

    zzgb(zzga zzga, String str, Bundle bundle, String str2, long j, String str3) {
        this.zzaqi = zzga;
        this.zzaqd = str;
        this.zzaqe = bundle;
        this.zzaqf = str2;
        this.zzaqg = j;
        this.zzaqh = str3;
    }

    public final void run() {
        if (this.zzaqi.zzaqb.zzapx == 3) {
            this.zzaqi.zzaqb.zzaps.zza(this.zzaqd, this.zzaqe, this.zzaqf, this.zzaqg, true);
        } else if (this.zzaqi.zzaqb.zzapx == 4) {
            zzev.zzab(String.format("Container failed to load: skipping  event interceptor by logging event back to Firebase directly: name = %s, origin = %s, params = %s.", this.zzaqd, this.zzaqf, this.zzaqe));
            try {
                this.zzaqi.zzaqb.zzamx.logEventInternalNoInterceptor(this.zzaqf, this.zzaqd, this.zzaqe, this.zzaqg);
            } catch (RemoteException e) {
                zzea.zza("Error logging event on measurement proxy: ", e, this.zzaqi.zzaqb.zzrm);
            }
        } else if (this.zzaqi.zzaqb.zzapx != 1 && this.zzaqi.zzaqb.zzapx != 2) {
            int i = this.zzaqi.zzaqb.zzapx;
            StringBuilder sb = new StringBuilder(28);
            sb.append("Unexpected state:");
            sb.append(i);
            zzea.zzb(sb.toString(), this.zzaqi.zzaqb.zzrm);
        } else if (!this.zzaqc) {
            zzev.zzab(String.format("Container not loaded yet: deferring event interceptor by enqueuing the event: name = %s, origin = %s, params = %s.", this.zzaqd, this.zzaqh, this.zzaqe));
            this.zzaqc = true;
            this.zzaqi.zzaqb.zzapy.add(this);
        } else {
            zzea.zzb("Invalid state - not expecting to see a deferredevent during container loading.", this.zzaqi.zzaqb.zzrm);
        }
    }
}
