package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzsp<T> implements zzsz<T> {
    private final zzsk zzbdc;
    private final boolean zzbdd;
    private final zztr<?, ?> zzbdm;
    private final zzqq<?> zzbdn;

    private zzsp(zztr<?, ?> zztr, zzqq<?> zzqq, zzsk zzsk) {
        this.zzbdm = zztr;
        this.zzbdd = zzqq.zze(zzsk);
        this.zzbdn = zzqq;
        this.zzbdc = zzsk;
    }

    static <T> zzsp<T> zza(zztr<?, ?> zztr, zzqq<?> zzqq, zzsk zzsk) {
        return new zzsp<>(zztr, zzqq, zzsk);
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final T newInstance() {
        return (T) this.zzbdc.zzph().zzpl();
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final boolean equals(T t, T t2) {
        if (!this.zzbdm.zzag(t).equals(this.zzbdm.zzag(t2))) {
            return false;
        }
        if (this.zzbdd) {
            return this.zzbdn.zzr(t).equals(this.zzbdn.zzr(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final int hashCode(T t) {
        int hashCode = this.zzbdm.zzag(t).hashCode();
        return this.zzbdd ? (hashCode * 53) + this.zzbdn.zzr(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final void zzd(T t, T t2) {
        zztb.zza(this.zzbdm, t, t2);
        if (this.zzbdd) {
            zztb.zza(this.zzbdn, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final void zza(T t, zzum zzum) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzbdn.zzr(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzqv zzqv = (zzqv) next.getKey();
            if (zzqv.zzoy() != zzul.MESSAGE || zzqv.zzoz() || zzqv.zzpa()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzrp) {
                zzum.zza(zzqv.zzc(), (Object) ((zzrp) next).zzpz().zzmv());
            } else {
                zzum.zza(zzqv.zzc(), next.getValue());
            }
        }
        zztr<?, ?> zztr = this.zzbdm;
        zztr.zzc(zztr.zzag(t), zzum);
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final void zza(T t, zzsy zzsy, zzqp zzqp) throws IOException {
        boolean z;
        zztr<?, ?> zztr = this.zzbdm;
        zzqq<?> zzqq = this.zzbdn;
        Object zzah = zztr.zzah(t);
        zzqt<?> zzs = zzqq.zzs(t);
        do {
            try {
                if (zzsy.zzog() == Integer.MAX_VALUE) {
                    zztr.zzg(t, zzah);
                    return;
                }
                int tag = zzsy.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzps zzps = null;
                    while (zzsy.zzog() != Integer.MAX_VALUE) {
                        int tag2 = zzsy.getTag();
                        if (tag2 == 16) {
                            i = zzsy.zznr();
                            obj = zzqq.zza(zzqp, this.zzbdc, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzqq.zza(zzsy, obj, zzqp, zzs);
                            } else {
                                zzps = zzsy.zznq();
                            }
                        } else if (!zzsy.zzoh()) {
                            break;
                        }
                    }
                    if (zzsy.getTag() != 12) {
                        throw zzrk.zzps();
                    } else if (zzps != null) {
                        if (obj != null) {
                            zzqq.zza(zzps, obj, zzqp, zzs);
                        } else {
                            zztr.zza(zzah, i, zzps);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzqq.zza(zzqp, this.zzbdc, tag >>> 3);
                    if (zza != null) {
                        zzqq.zza(zzsy, zza, zzqp, zzs);
                    } else {
                        z = zztr.zza(zzah, zzsy);
                        continue;
                    }
                } else {
                    z = zzsy.zzoh();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zztr.zzg(t, zzah);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final void zzt(T t) {
        this.zzbdm.zzt(t);
        this.zzbdn.zzt(t);
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final boolean zzae(T t) {
        return this.zzbdn.zzr(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final int zzad(T t) {
        zztr<?, ?> zztr = this.zzbdm;
        int zzai = zztr.zzai(zztr.zzag(t)) + 0;
        return this.zzbdd ? zzai + this.zzbdn.zzr(t).zzow() : zzai;
    }
}
