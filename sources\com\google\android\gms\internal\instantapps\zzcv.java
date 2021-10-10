package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcx;

final class zzcv implements zzec {
    private static final zzcv zzaow = new zzcv();

    private zzcv() {
    }

    public static zzcv zzbr() {
        return zzaow;
    }

    @Override // com.google.android.gms.internal.instantapps.zzec
    public final boolean zza(Class<?> cls) {
        return zzcx.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.instantapps.zzec
    public final zzed zzb(Class<?> cls) {
        if (!zzcx.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzed) zzcx.zzc(cls.asSubclass(zzcx.class)).zza(zzcx.zzd.zzapi, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
