package com.google.android.gms.internal.instantapps;

public class zzdk {
    private static final zzck zzakk = zzck.zzbf();
    private zzbp zzaqp;
    private volatile zzef zzaqq;
    private volatile zzbp zzaqr;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdk)) {
            return false;
        }
        zzdk zzdk = (zzdk) obj;
        zzef zzef = this.zzaqq;
        zzef zzef2 = zzdk.zzaqq;
        if (zzef == null && zzef2 == null) {
            return zzm().equals(zzdk.zzm());
        }
        if (zzef != null && zzef2 != null) {
            return zzef.equals(zzef2);
        }
        if (zzef != null) {
            return zzef.equals(zzdk.zzg(zzef.zzbx()));
        }
        return zzg(zzef2.zzbx()).equals(zzef2);
    }

    private final zzef zzg(zzef zzef) {
        if (this.zzaqq == null) {
            synchronized (this) {
                if (this.zzaqq == null) {
                    try {
                        this.zzaqq = zzef;
                        this.zzaqr = zzbp.zzakv;
                    } catch (zzdf unused) {
                        this.zzaqq = zzef;
                        this.zzaqr = zzbp.zzakv;
                    }
                }
            }
        }
        return this.zzaqq;
    }

    public final zzef zzh(zzef zzef) {
        zzef zzef2 = this.zzaqq;
        this.zzaqp = null;
        this.zzaqr = null;
        this.zzaqq = zzef;
        return zzef2;
    }

    public final int zzbz() {
        if (this.zzaqr != null) {
            return this.zzaqr.size();
        }
        if (this.zzaqq != null) {
            return this.zzaqq.zzbz();
        }
        return 0;
    }

    public final zzbp zzm() {
        if (this.zzaqr != null) {
            return this.zzaqr;
        }
        synchronized (this) {
            if (this.zzaqr != null) {
                return this.zzaqr;
            }
            if (this.zzaqq == null) {
                this.zzaqr = zzbp.zzakv;
            } else {
                this.zzaqr = this.zzaqq.zzm();
            }
            return this.zzaqr;
        }
    }
}
