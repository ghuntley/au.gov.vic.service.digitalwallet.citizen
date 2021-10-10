package com.google.android.gms.internal.gtm;

import android.os.RemoteException;

/* access modifiers changed from: package-private */
public final class zzdv implements Runnable {
    private final /* synthetic */ zzdq zzanc;
    private final zzee zzand;

    public zzdv(zzdq zzdq, zzee zzee) {
        this.zzanc = zzdq;
        this.zzand = zzee;
    }

    public final void run() {
        if (this.zzanc.state == 2) {
            String valueOf = String.valueOf(this.zzand.zzkf());
            zzev.zzab(valueOf.length() != 0 ? "Evaluating tags for event ".concat(valueOf) : new String("Evaluating tags for event "));
            this.zzanc.zzamz.zzb(this.zzand);
        } else if (this.zzanc.state == 1) {
            this.zzanc.zzana.add(this.zzand);
            String zzkf = this.zzand.zzkf();
            StringBuilder sb = new StringBuilder(String.valueOf(zzkf).length() + 30);
            sb.append("Added event ");
            sb.append(zzkf);
            sb.append(" to pending queue.");
            zzev.zzab(sb.toString());
        } else if (this.zzanc.state == 3) {
            String zzkf2 = this.zzand.zzkf();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzkf2).length() + 61);
            sb2.append("Failed to evaluate tags for event ");
            sb2.append(zzkf2);
            sb2.append(" (container failed to load)");
            zzev.zzab(sb2.toString());
            if (this.zzand.zzki()) {
                try {
                    this.zzanc.zzamx.logEventInternalNoInterceptor("app", this.zzand.zzkf(), this.zzand.zzkg(), this.zzand.currentTimeMillis());
                    String zzkf3 = this.zzand.zzkf();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(zzkf3).length() + 38);
                    sb3.append("Logged passthrough event ");
                    sb3.append(zzkf3);
                    sb3.append(" to Firebase.");
                    zzev.zzab(sb3.toString());
                } catch (RemoteException e) {
                    zzea.zza("Error logging event with measurement proxy:", e, this.zzanc.zzrm);
                }
            } else {
                String valueOf2 = String.valueOf(this.zzand.zzkf());
                zzev.zzab(valueOf2.length() != 0 ? "Discarded non-passthrough event ".concat(valueOf2) : new String("Discarded non-passthrough event "));
            }
        }
    }
}
