package com.google.android.gms.internal.gtm;

import android.os.RemoteException;

final class zzgm implements Runnable {
    private final /* synthetic */ String zzaqk;
    private final /* synthetic */ String zzaql;
    private final /* synthetic */ String zzaqm;
    private final /* synthetic */ zzeo zzaqu;
    private final /* synthetic */ zzgl zzaqv;

    zzgm(zzgl zzgl, String str, String str2, String str3, zzeo zzeo) {
        this.zzaqv = zzgl;
        this.zzaqk = str;
        this.zzaql = str2;
        this.zzaqm = str3;
        this.zzaqu = zzeo;
    }

    public final void run() {
        boolean z = true;
        try {
            if (!zzgl.zza(this.zzaqv).containsKey(this.zzaqk)) {
                zzgl.zza(this.zzaqv).put(this.zzaqk, zzgl.zzb(this.zzaqv).zzb(this.zzaqk, this.zzaql, this.zzaqm));
            }
        } catch (Exception e) {
            zzea.zza("Fail to load container: ", e, zzgl.zzc(this.zzaqv));
            z = false;
        }
        try {
            zzeo zzeo = this.zzaqu;
            if (zzeo != null) {
                zzeo.zza(z, this.zzaqk);
            }
        } catch (RemoteException e2) {
            zzea.zza("Error relaying callback: ", e2, zzgl.zzc(this.zzaqv));
        }
    }
}
