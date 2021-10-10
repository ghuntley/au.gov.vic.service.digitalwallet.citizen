package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcx;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzel<T> implements zzeu<T> {
    private final zzef zzarr;
    private final boolean zzars;
    private final zzfm<?, ?> zzasb;
    private final zzcm<?> zzasc;

    private zzel(zzfm<?, ?> zzfm, zzcm<?> zzcm, zzef zzef) {
        this.zzasb = zzfm;
        this.zzars = zzcm.zze(zzef);
        this.zzasc = zzcm;
        this.zzarr = zzef;
    }

    static <T> zzel<T> zza(zzfm<?, ?> zzfm, zzcm<?> zzcm, zzef zzef) {
        return new zzel<>(zzfm, zzcm, zzef);
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final T newInstance() {
        return (T) this.zzarr.zzcc().zzbv();
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final boolean equals(T t, T t2) {
        if (!this.zzasb.zzq(t).equals(this.zzasb.zzq(t2))) {
            return false;
        }
        if (this.zzars) {
            return this.zzasc.zza((Object) t).equals(this.zzasc.zza((Object) t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final int hashCode(T t) {
        int hashCode = this.zzasb.zzq(t).hashCode();
        return this.zzars ? (hashCode * 53) + this.zzasc.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zzc(T t, T t2) {
        zzew.zza(this.zzasb, t, t2);
        if (this.zzars) {
            zzew.zza(this.zzasc, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zza(T t, zzgi zzgi) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzasc.zza((Object) t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzcs zzcs = (zzcs) next.getKey();
            if (zzcs.zzbo() != zzgg.MESSAGE || zzcs.zzbp() || zzcs.zzbq()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzdi) {
                zzgi.zza(zzcs.zzk(), (Object) ((zzdi) next).zzcp().zzm());
            } else {
                zzgi.zza(zzcs.zzk(), next.getValue());
            }
        }
        zzfm<?, ?> zzfm = this.zzasb;
        zzfm.zzc(zzfm.zzq(t), zzgi);
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zza(T t, byte[] bArr, int i, int i2, zzbk zzbk) throws IOException {
        T t2 = t;
        zzfp zzfp = t2.zzapc;
        if (zzfp == zzfp.zzea()) {
            zzfp = zzfp.zzeb();
            t2.zzapc = zzfp;
        }
        t.zzcd();
        zzcx.zze zze = null;
        while (i < i2) {
            int zza = zzbl.zza(bArr, i, zzbk);
            int i3 = zzbk.zzako;
            if (i3 == 11) {
                int i4 = 0;
                zzbp zzbp = null;
                while (zza < i2) {
                    zza = zzbl.zza(bArr, zza, zzbk);
                    int i5 = zzbk.zzako;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zze != null) {
                                zzeq.zzdi();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza = zzbl.zze(bArr, zza, zzbk);
                                zzbp = (zzbp) zzbk.zzakq;
                            }
                        }
                    } else if (i7 == 0) {
                        zza = zzbl.zza(bArr, zza, zzbk);
                        i4 = zzbk.zzako;
                        zze = (zzcx.zze) this.zzasc.zza(zzbk.zzakr, this.zzarr, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzbl.zza(i5, bArr, zza, i2, zzbk);
                }
                if (zzbp != null) {
                    zzfp.zzb((i4 << 3) | 2, zzbp);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zze = (zzcx.zze) this.zzasc.zza(zzbk.zzakr, this.zzarr, i3 >>> 3);
                if (zze == null) {
                    i = zzbl.zza(i3, bArr, zza, i2, zzfp, zzbk);
                } else {
                    zzeq.zzdi();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzbl.zza(i3, bArr, zza, i2, zzbk);
            }
        }
        if (i != i2) {
            throw zzdf.zzcl();
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zza(T t, zzev zzev, zzck zzck) throws IOException {
        boolean z;
        zzfm<?, ?> zzfm = this.zzasb;
        zzcm<?> zzcm = this.zzasc;
        Object zzr = zzfm.zzr(t);
        zzcq<?> zzb = zzcm.zzb(t);
        do {
            try {
                if (zzev.zzas() == Integer.MAX_VALUE) {
                    zzfm.zzf(t, zzr);
                    return;
                }
                int tag = zzev.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzbp zzbp = null;
                    while (zzev.zzas() != Integer.MAX_VALUE) {
                        int tag2 = zzev.getTag();
                        if (tag2 == 16) {
                            i = zzev.zzaj();
                            obj = zzcm.zza(zzck, this.zzarr, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzcm.zza(zzev, obj, zzck, zzb);
                            } else {
                                zzbp = zzev.zzai();
                            }
                        } else if (!zzev.zzat()) {
                            break;
                        }
                    }
                    if (zzev.getTag() != 12) {
                        throw zzdf.zzcj();
                    } else if (zzbp != null) {
                        if (obj != null) {
                            zzcm.zza(zzbp, obj, zzck, zzb);
                        } else {
                            zzfm.zza(zzr, i, zzbp);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzcm.zza(zzck, this.zzarr, tag >>> 3);
                    if (zza != null) {
                        zzcm.zza(zzev, zza, zzck, zzb);
                    } else {
                        z = zzfm.zza(zzr, zzev);
                        continue;
                    }
                } else {
                    z = zzev.zzat();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzfm.zzf(t, zzr);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zzc(T t) {
        this.zzasb.zzc(t);
        this.zzasc.zzc(t);
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final boolean zzo(T t) {
        return this.zzasc.zza((Object) t).isInitialized();
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final int zzm(T t) {
        zzfm<?, ?> zzfm = this.zzasb;
        int zzs = zzfm.zzs(zzfm.zzq(t)) + 0;
        return this.zzars ? zzs + this.zzasc.zza((Object) t).zzbm() : zzs;
    }
}
