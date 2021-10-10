package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzkq<T> implements zzlc<T> {
    private final zzkk zza;
    private final zzlu<?, ?> zzb;
    private final boolean zzc;
    private final zziq<?> zzd;

    private zzkq(zzlu<?, ?> zzlu, zziq<?> zziq, zzkk zzkk) {
        this.zzb = zzlu;
        this.zzc = zziq.zza(zzkk);
        this.zzd = zziq;
        this.zza = zzkk;
    }

    static <T> zzkq<T> zza(zzlu<?, ?> zzlu, zziq<?> zziq, zzkk zzkk) {
        return new zzkq<>(zzlu, zziq, zzkk);
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final T zza() {
        return (T) this.zza.zzq().zze();
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zzb(T t, T t2) {
        zzle.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzle.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zza(T t, zzmr zzmr) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry<?, Object> next = zzd2.next();
            zziw zziw = (zziw) next.getKey();
            if (zziw.zzc() != zzmo.MESSAGE || zziw.zzd() || zziw.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzjr) {
                zzmr.zza(zziw.zza(), (Object) ((zzjr) next).zza().zzc());
            } else {
                zzmr.zza(zziw.zza(), next.getValue());
            }
        }
        zzlu<?, ?> zzlu = this.zzb;
        zzlu.zzb(zzlu.zzb(t), zzmr);
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zza(T t, byte[] bArr, int i, int i2, zzhn zzhn) throws IOException {
        T t2 = t;
        zzlx zzlx = t2.zzb;
        if (zzlx == zzlx.zza()) {
            zzlx = zzlx.zzb();
            t2.zzb = zzlx;
        }
        zziu<zzjb.zzf> zza2 = t.zza();
        zzjb.zze zze = null;
        while (i < i2) {
            int zza3 = zzhl.zza(bArr, i, zzhn);
            int i3 = zzhn.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzht zzht = null;
                while (zza3 < i2) {
                    zza3 = zzhl.zza(bArr, zza3, zzhn);
                    int i5 = zzhn.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zze != null) {
                                zza3 = zzhl.zza(zzky.zza().zza((Class) zze.zzc.getClass()), bArr, zza3, i2, zzhn);
                                zza2.zza(zze.zzd, zzhn.zzc);
                            } else if (i7 == 2) {
                                zza3 = zzhl.zze(bArr, zza3, zzhn);
                                zzht = (zzht) zzhn.zzc;
                            }
                        }
                    } else if (i7 == 0) {
                        zza3 = zzhl.zza(bArr, zza3, zzhn);
                        i4 = zzhn.zza;
                        zze = (zzjb.zze) this.zzd.zza(zzhn.zzd, this.zza, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza3 = zzhl.zza(i5, bArr, zza3, i2, zzhn);
                }
                if (zzht != null) {
                    zzlx.zza((i4 << 3) | 2, zzht);
                }
                i = zza3;
            } else if ((i3 & 7) == 2) {
                zzjb.zze zze2 = (zzjb.zze) this.zzd.zza(zzhn.zzd, this.zza, i3 >>> 3);
                if (zze2 != null) {
                    i = zzhl.zza(zzky.zza().zza((Class) zze2.zzc.getClass()), bArr, zza3, i2, zzhn);
                    zza2.zza(zze2.zzd, zzhn.zzc);
                } else {
                    i = zzhl.zza(i3, bArr, zza3, i2, zzlx, zzhn);
                }
                zze = zze2;
            } else {
                i = zzhl.zza(i3, bArr, zza3, i2, zzhn);
            }
        }
        if (i != i2) {
            throw zzjk.zzg();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zza(T t, zzld zzld, zzio zzio) throws IOException {
        boolean z;
        zzlu<?, ?> zzlu = this.zzb;
        zziq<?> zziq = this.zzd;
        Object zzc2 = zzlu.zzc(t);
        zziu<?> zzb2 = zziq.zzb(t);
        do {
            try {
                if (zzld.zza() == Integer.MAX_VALUE) {
                    zzlu.zzb(t, zzc2);
                    return;
                }
                int zzb3 = zzld.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzht zzht = null;
                    while (zzld.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzld.zzb();
                        if (zzb4 == 16) {
                            i = zzld.zzo();
                            obj = zziq.zza(zzio, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zziq.zza(zzld, obj, zzio, zzb2);
                            } else {
                                zzht = zzld.zzn();
                            }
                        } else if (!zzld.zzc()) {
                            break;
                        }
                    }
                    if (zzld.zzb() != 12) {
                        throw zzjk.zze();
                    } else if (zzht != null) {
                        if (obj != null) {
                            zziq.zza(zzht, obj, zzio, zzb2);
                        } else {
                            zzlu.zza(zzc2, i, zzht);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zziq.zza(zzio, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zziq.zza(zzld, zza2, zzio, zzb2);
                    } else {
                        z = zzlu.zza(zzc2, zzld);
                        continue;
                    }
                } else {
                    z = zzld.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzlu.zzb(t, zzc2);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final int zzb(T t) {
        zzlu<?, ?> zzlu = this.zzb;
        int zze = zzlu.zze(zzlu.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }
}
