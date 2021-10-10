package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

final class zzrb implements zzsj {
    private static final zzrb zzbaj = new zzrb();

    private zzrb() {
    }

    public static zzrb zzpc() {
        return zzbaj;
    }

    @Override // com.google.android.gms.internal.gtm.zzsj
    public final boolean zze(Class<?> cls) {
        return zzrc.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.gtm.zzsj
    public final zzsi zzf(Class<?> cls) {
        if (!zzrc.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzsi) zzrc.zzg(cls.asSubclass(zzrc.class)).zza(zzrc.zze.zzbat, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
