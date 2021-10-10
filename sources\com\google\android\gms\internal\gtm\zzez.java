package com.google.android.gms.internal.gtm;

final class zzez implements zzfw {
    private final /* synthetic */ zzey zzaom;

    zzez(zzey zzey) {
        this.zzaom = zzey;
    }

    @Override // com.google.android.gms.internal.gtm.zzfw
    public final void zza(zzeh zzeh) {
        zzey.zza(this.zzaom, zzeh.zzih());
    }

    @Override // com.google.android.gms.internal.gtm.zzfw
    public final void zzb(zzeh zzeh) {
        zzey.zza(this.zzaom, zzeh.zzih());
        long zzih = zzeh.zzih();
        StringBuilder sb = new StringBuilder(57);
        sb.append("Permanent failure dispatching hitId: ");
        sb.append(zzih);
        zzev.zzab(sb.toString());
    }

    @Override // com.google.android.gms.internal.gtm.zzfw
    public final void zzc(zzeh zzeh) {
        long zzii = zzeh.zzii();
        if (zzii == 0) {
            zzey.zza(this.zzaom, zzeh.zzih(), zzey.zza(this.zzaom).currentTimeMillis());
        } else if (zzii + 14400000 < zzey.zza(this.zzaom).currentTimeMillis()) {
            zzey.zza(this.zzaom, zzeh.zzih());
            long zzih = zzeh.zzih();
            StringBuilder sb = new StringBuilder(47);
            sb.append("Giving up on failed hitId: ");
            sb.append(zzih);
            zzev.zzab(sb.toString());
        }
    }
}
