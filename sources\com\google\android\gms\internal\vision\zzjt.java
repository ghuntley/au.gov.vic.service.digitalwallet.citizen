package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public class zzjt {
    private static final zzio zza = zzio.zzb();
    private zzht zzb;
    private volatile zzkk zzc;
    private volatile zzht zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjt)) {
            return false;
        }
        zzjt zzjt = (zzjt) obj;
        zzkk zzkk = this.zzc;
        zzkk zzkk2 = zzjt.zzc;
        if (zzkk == null && zzkk2 == null) {
            return zzc().equals(zzjt.zzc());
        }
        if (zzkk != null && zzkk2 != null) {
            return zzkk.equals(zzkk2);
        }
        if (zzkk != null) {
            return zzkk.equals(zzjt.zzb(zzkk.zzr()));
        }
        return zzb(zzkk2.zzr()).equals(zzkk2);
    }

    private final zzkk zzb(zzkk zzkk) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzkk;
                        this.zzd = zzht.zza;
                    } catch (zzjk unused) {
                        this.zzc = zzkk;
                        this.zzd = zzht.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzkk zza(zzkk zzkk) {
        zzkk zzkk2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzkk;
        return zzkk2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzm();
        }
        return 0;
    }

    public final zzht zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzht.zza;
            } else {
                this.zzd = this.zzc.zzg();
            }
            return this.zzd;
        }
    }
}
