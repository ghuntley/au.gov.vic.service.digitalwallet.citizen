package com.google.android.gms.internal.instantapps;

final class zzdu implements zzec {
    private zzec[] zzard;

    zzdu(zzec... zzecArr) {
        this.zzard = zzecArr;
    }

    @Override // com.google.android.gms.internal.instantapps.zzec
    public final boolean zza(Class<?> cls) {
        for (zzec zzec : this.zzard) {
            if (zzec.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.instantapps.zzec
    public final zzed zzb(Class<?> cls) {
        zzec[] zzecArr = this.zzard;
        for (zzec zzec : zzecArr) {
            if (zzec.zza(cls)) {
                return zzec.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
