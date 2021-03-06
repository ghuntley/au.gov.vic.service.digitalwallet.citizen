package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

final class zzec implements zzdm {
    private final String info;
    private final zzdo zzmn;
    private final zzed zzng;

    zzec(zzdo zzdo, String str, Object[] objArr) {
        this.zzmn = zzdo;
        this.info = str;
        this.zzng = new zzed(zzdo.getClass(), str, objArr);
    }

    public final int getFieldCount() {
        return zzed.zzd(this.zzng);
    }

    @Override // com.google.android.gms.internal.clearcut.zzdm
    public final int zzcf() {
        return (zzed.zza(this.zzng) & 1) == 1 ? zzcg.zzg.zzkl : zzcg.zzg.zzkm;
    }

    @Override // com.google.android.gms.internal.clearcut.zzdm
    public final boolean zzcg() {
        return (zzed.zza(this.zzng) & 2) == 2;
    }

    @Override // com.google.android.gms.internal.clearcut.zzdm
    public final zzdo zzch() {
        return this.zzmn;
    }

    /* access modifiers changed from: package-private */
    public final zzed zzco() {
        return this.zzng;
    }

    public final int zzcp() {
        return zzed.zzb(this.zzng);
    }

    public final int zzcq() {
        return zzed.zzc(this.zzng);
    }

    public final int zzcr() {
        return zzed.zze(this.zzng);
    }

    public final int zzcs() {
        return zzed.zzf(this.zzng);
    }

    /* access modifiers changed from: package-private */
    public final int[] zzct() {
        return zzed.zzg(this.zzng);
    }

    public final int zzcu() {
        return zzed.zzh(this.zzng);
    }

    public final int zzcv() {
        return zzed.zzi(this.zzng);
    }
}
