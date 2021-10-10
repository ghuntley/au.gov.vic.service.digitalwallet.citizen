package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzfy;

/* access modifiers changed from: package-private */
public final class zzge implements Runnable {
    private final /* synthetic */ zzfy zzaqb;
    private final /* synthetic */ String zzaqk;
    private final /* synthetic */ String zzaql;
    private final /* synthetic */ String zzaqm = null;

    zzge(zzfy zzfy, String str, String str2, String str3) {
        this.zzaqb = zzfy;
        this.zzaqk = str;
        this.zzaql = str2;
    }

    public final void run() {
        String str = this.zzaqk;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 28);
        sb.append("Starting to load container ");
        sb.append(str);
        sb.append(".");
        zzev.zzab(sb.toString());
        if (this.zzaqb.zzapx != 1) {
            zzea.zzb("Unexpected state - container loading already initiated.", this.zzaqb.zzrm);
            return;
        }
        this.zzaqb.zzapx = 2;
        this.zzaqb.zzaps.zzb(this.zzaqk, this.zzaql, this.zzaqm, new zzfy.zzb(this.zzaqb, null));
    }
}
