package com.google.android.gms.internal.gtm;

public class zzrr {
    private static final zzqp zzavr = zzqp.zzoq();
    private zzps zzbcb;
    private volatile zzsk zzbcc;
    private volatile zzps zzbcd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzrr)) {
            return false;
        }
        zzrr zzrr = (zzrr) obj;
        zzsk zzsk = this.zzbcc;
        zzsk zzsk2 = zzrr.zzbcc;
        if (zzsk == null && zzsk2 == null) {
            return zzmv().equals(zzrr.zzmv());
        }
        if (zzsk != null && zzsk2 != null) {
            return zzsk.equals(zzsk2);
        }
        if (zzsk != null) {
            return zzsk.equals(zzrr.zzh(zzsk.zzpi()));
        }
        return zzh(zzsk2.zzpi()).equals(zzsk2);
    }

    private final zzsk zzh(zzsk zzsk) {
        if (this.zzbcc == null) {
            synchronized (this) {
                if (this.zzbcc == null) {
                    try {
                        this.zzbcc = zzsk;
                        this.zzbcd = zzps.zzavx;
                    } catch (zzrk unused) {
                        this.zzbcc = zzsk;
                        this.zzbcd = zzps.zzavx;
                    }
                }
            }
        }
        return this.zzbcc;
    }

    public final zzsk zzi(zzsk zzsk) {
        zzsk zzsk2 = this.zzbcc;
        this.zzbcb = null;
        this.zzbcd = null;
        this.zzbcc = zzsk;
        return zzsk2;
    }

    public final int zzpe() {
        if (this.zzbcd != null) {
            return this.zzbcd.size();
        }
        if (this.zzbcc != null) {
            return this.zzbcc.zzpe();
        }
        return 0;
    }

    public final zzps zzmv() {
        if (this.zzbcd != null) {
            return this.zzbcd;
        }
        synchronized (this) {
            if (this.zzbcd != null) {
                return this.zzbcd;
            }
            if (this.zzbcc == null) {
                this.zzbcd = zzps.zzavx;
            } else {
                this.zzbcd = this.zzbcc.zzmv();
            }
            return this.zzbcd;
        }
    }
}
