package com.google.android.gms.internal.gtm;

import android.net.Uri;

/* access modifiers changed from: package-private */
public final class zzgj implements Runnable {
    private final /* synthetic */ zzfy zzaqb;
    private final /* synthetic */ Uri zzaqp;

    zzgj(zzfy zzfy, Uri uri) {
        this.zzaqb = zzfy;
        this.zzaqp = uri;
    }

    public final void run() {
        String valueOf = String.valueOf(this.zzaqp);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
        sb.append("Preview requested to uri ");
        sb.append(valueOf);
        zzev.zzab(sb.toString());
        synchronized (this.zzaqb.zzapv) {
            if (this.zzaqb.zzapx == 2) {
                zzev.zzab("Still initializing. Defer preview container loading.");
                this.zzaqb.zzapy.add(this);
                return;
            }
            String str = (String) this.zzaqb.zzc((String[]) null).first;
            if (str == null) {
                zzev.zzac("Preview failed (no container found)");
            } else if (!this.zzaqb.zzapt.zza(str, this.zzaqp)) {
                String valueOf2 = String.valueOf(this.zzaqp);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 73);
                sb2.append("Cannot preview the app with the uri: ");
                sb2.append(valueOf2);
                sb2.append(". Launching current version instead.");
                zzev.zzac(sb2.toString());
            } else if (!(this.zzaqb.zzrq)) {
                String valueOf3 = String.valueOf(this.zzaqp);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 84);
                sb3.append("Deferring container loading for preview uri: ");
                sb3.append(valueOf3);
                sb3.append("(Tag Manager has not been initialized).");
                zzev.zzab(sb3.toString());
            } else {
                String valueOf4 = String.valueOf(this.zzaqp);
                StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf4).length() + 36);
                sb4.append("Starting to load preview container: ");
                sb4.append(valueOf4);
                zzev.zzaw(sb4.toString());
                if (!this.zzaqb.zzaps.zzla()) {
                    zzev.zzac("Failed to reset TagManager service for preview");
                    return;
                }
                this.zzaqb.zzrq = false;
                this.zzaqb.zzapx = 1;
                this.zzaqb.zzag();
            }
        }
    }
}
