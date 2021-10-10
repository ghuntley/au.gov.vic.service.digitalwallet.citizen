package com.google.android.gms.internal.gtm;

import android.os.RemoteException;

final class zzdt implements Runnable {
    private final /* synthetic */ zzdq zzanc;

    private zzdt(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    public final void run() {
        this.zzanc.state = 3;
        String str = this.zzanc.zzaec;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Container ");
        sb.append(str);
        sb.append(" loading failed.");
        zzev.zzac(sb.toString());
        if (this.zzanc.zzana != null) {
            for (zzee zzee : this.zzanc.zzana) {
                if (zzee.zzki()) {
                    try {
                        this.zzanc.zzamx.logEventInternalNoInterceptor("app", zzee.zzkf(), zzee.zzkg(), zzee.currentTimeMillis());
                        String zzkf = zzee.zzkf();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zzkf).length() + 50);
                        sb2.append("Logged event ");
                        sb2.append(zzkf);
                        sb2.append(" to Firebase (marked as passthrough).");
                        zzev.zzab(sb2.toString());
                    } catch (RemoteException e) {
                        zzea.zza("Error logging event with measurement proxy:", e, this.zzanc.zzrm);
                    }
                } else {
                    String zzkf2 = zzee.zzkf();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(zzkf2).length() + 45);
                    sb3.append("Discarded event ");
                    sb3.append(zzkf2);
                    sb3.append(" (marked as non-passthrough).");
                    zzev.zzab(sb3.toString());
                }
            }
            this.zzanc.zzana = null;
        }
    }

    /* synthetic */ zzdt(zzdq zzdq, zzdr zzdr) {
        this(zzdq);
    }
}
