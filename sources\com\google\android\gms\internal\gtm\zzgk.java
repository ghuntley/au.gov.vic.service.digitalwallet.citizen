package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzfy;

final class zzgk implements Runnable {
    private final /* synthetic */ String zzaqk;
    private final /* synthetic */ boolean zzaqq;
    private final /* synthetic */ zzfy.zzb zzaqr;

    zzgk(zzfy.zzb zzb, boolean z, String str) {
        this.zzaqr = zzb;
        this.zzaqq = z;
        this.zzaqk = str;
    }

    public final void run() {
        if (zzfy.this.zzapx == 2) {
            if (this.zzaqq) {
                zzfy.this.zzapx = 3;
                String str = this.zzaqk;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 18);
                sb.append("Container ");
                sb.append(str);
                sb.append(" loaded.");
                zzev.zzab(sb.toString());
            } else {
                zzfy.this.zzapx = 4;
                String valueOf = String.valueOf(this.zzaqk);
                zzev.zzav(valueOf.length() != 0 ? "Error loading container:".concat(valueOf) : new String("Error loading container:"));
            }
            while (!zzfy.this.zzapy.isEmpty()) {
                zzfy.this.zzamv.execute((Runnable) zzfy.this.zzapy.remove());
            }
            return;
        }
        zzev.zzac("Container load callback completed after timeout");
    }
}
