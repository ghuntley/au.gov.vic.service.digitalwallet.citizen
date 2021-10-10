package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcx;

/* access modifiers changed from: package-private */
public final class zzds implements zzex {
    private static final zzec zzara = new zzdv();
    private final zzec zzaqz;

    public zzds() {
        this(new zzdu(zzcv.zzbr(), zzcu()));
    }

    private zzds(zzec zzec) {
        this.zzaqz = (zzec) zzcy.zza((Object) zzec, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.instantapps.zzex
    public final <T> zzeu<T> zzd(Class<T> cls) {
        zzew.zzf(cls);
        zzed zzb = this.zzaqz.zzb(cls);
        if (zzb.zzdc()) {
            if (zzcx.class.isAssignableFrom(cls)) {
                return zzel.zza(zzew.zzdo(), zzcn.zzbj(), zzb.zzdd());
            }
            return zzel.zza(zzew.zzdm(), zzcn.zzbk(), zzb.zzdd());
        } else if (zzcx.class.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzej.zza(cls, zzb, zzep.zzdg(), zzdp.zzct(), zzew.zzdo(), zzcn.zzbj(), zzea.zzcz());
            }
            return zzej.zza(cls, zzb, zzep.zzdg(), zzdp.zzct(), zzew.zzdo(), (zzcm<?>) null, zzea.zzcz());
        } else if (zza(zzb)) {
            return zzej.zza(cls, zzb, zzep.zzdf(), zzdp.zzcs(), zzew.zzdm(), zzcn.zzbk(), zzea.zzcy());
        } else {
            return zzej.zza(cls, zzb, zzep.zzdf(), zzdp.zzcs(), zzew.zzdn(), (zzcm<?>) null, zzea.zzcy());
        }
    }

    private static boolean zza(zzed zzed) {
        return zzed.zzdb() == zzcx.zzd.zzapo;
    }

    private static zzec zzcu() {
        try {
            return (zzec) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzara;
        }
    }
}
