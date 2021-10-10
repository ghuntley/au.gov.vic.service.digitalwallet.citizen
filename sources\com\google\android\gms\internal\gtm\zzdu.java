package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

final class zzdu implements zzmp, Runnable {
    private final /* synthetic */ zzdq zzanc;

    private zzdu(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    public final void run() {
        boolean z = true;
        if (zzdq.zza(this.zzanc) != 1) {
            z = false;
        }
        Preconditions.checkState(z);
        ArrayList arrayList = new ArrayList();
        zzdq.zza(this.zzanc, false);
        if (zzfd.zzkr().zzbw(zzdq.zzd(this.zzanc))) {
            arrayList.add(0);
        } else {
            zzdq zzdq = this.zzanc;
            zzdq.zza(zzdq, zzdq.zzg(zzdq).zzke());
            if (!zzdq.zzl(this.zzanc)) {
                arrayList.add(0);
                arrayList.add(1);
            } else {
                arrayList.add(1);
                arrayList.add(0);
            }
            arrayList.add(2);
        }
        zzdq.zzh(this.zzanc).zza(zzdq.zzd(this.zzanc), zzdq.zze(this.zzanc), zzdq.zzf(this.zzanc), arrayList, this, zzdq.zzg(this.zzanc));
    }

    @Override // com.google.android.gms.internal.gtm.zzmp
    public final void zza(zzmx zzmx) {
        if (zzmx.getStatus() == Status.RESULT_SUCCESS) {
            zzdq.zzc(this.zzanc).execute(new zzdx(this.zzanc, zzmx));
        } else {
            zzdq.zzc(this.zzanc).execute(new zzdt(this.zzanc, null));
        }
    }

    /* synthetic */ zzdu(zzdq zzdq, zzdr zzdr) {
        this(zzdq);
    }
}
