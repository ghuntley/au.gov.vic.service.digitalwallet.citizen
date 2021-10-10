package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzqh implements zzsy {
    private int tag;
    private final zzqe zzawp;
    private int zzawq;
    private int zzawr = 0;

    public static zzqh zza(zzqe zzqe) {
        if (zzqe.zzawi != null) {
            return zzqe.zzawi;
        }
        return new zzqh(zzqe);
    }

    private zzqh(zzqe zzqe) {
        zzqe zzqe2 = (zzqe) zzre.zza(zzqe, "input");
        this.zzawp = zzqe2;
        zzqe2.zzawi = this;
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final int zzog() throws IOException {
        int i = this.zzawr;
        if (i != 0) {
            this.tag = i;
            this.zzawr = 0;
        } else {
            this.tag = this.zzawp.zzni();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzawq) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final boolean zzoh() throws IOException {
        int i;
        if (this.zzawp.zzny() || (i = this.tag) == this.zzawq) {
            return false;
        }
        return this.zzawp.zzao(i);
    }

    private final void zzat(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzrk.zzpt();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final double readDouble() throws IOException {
        zzat(1);
        return this.zzawp.readDouble();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final float readFloat() throws IOException {
        zzat(5);
        return this.zzawp.readFloat();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final long zznj() throws IOException {
        zzat(0);
        return this.zzawp.zznj();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final long zznk() throws IOException {
        zzat(0);
        return this.zzawp.zznk();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final int zznl() throws IOException {
        zzat(0);
        return this.zzawp.zznl();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final long zznm() throws IOException {
        zzat(1);
        return this.zzawp.zznm();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final int zznn() throws IOException {
        zzat(5);
        return this.zzawp.zznn();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final boolean zzno() throws IOException {
        zzat(0);
        return this.zzawp.zzno();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final String readString() throws IOException {
        zzat(2);
        return this.zzawp.readString();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final String zznp() throws IOException {
        zzat(2);
        return this.zzawp.zznp();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final <T> T zza(zzsz<T> zzsz, zzqp zzqp) throws IOException {
        zzat(2);
        return (T) zzc(zzsz, zzqp);
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final <T> T zzb(zzsz<T> zzsz, zzqp zzqp) throws IOException {
        zzat(3);
        return (T) zzd(zzsz, zzqp);
    }

    private final <T> T zzc(zzsz<T> zzsz, zzqp zzqp) throws IOException {
        int zznr = this.zzawp.zznr();
        if (this.zzawp.zzawf < this.zzawp.zzawg) {
            int zzaq = this.zzawp.zzaq(zznr);
            T newInstance = zzsz.newInstance();
            this.zzawp.zzawf++;
            zzsz.zza(newInstance, this, zzqp);
            zzsz.zzt(newInstance);
            this.zzawp.zzan(0);
            zzqe zzqe = this.zzawp;
            zzqe.zzawf--;
            this.zzawp.zzar(zzaq);
            return newInstance;
        }
        throw zzrk.zzpu();
    }

    private final <T> T zzd(zzsz<T> zzsz, zzqp zzqp) throws IOException {
        int i = this.zzawq;
        this.zzawq = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzsz.newInstance();
            zzsz.zza(newInstance, this, zzqp);
            zzsz.zzt(newInstance);
            if (this.tag == this.zzawq) {
                return newInstance;
            }
            throw zzrk.zzpv();
        } finally {
            this.zzawq = i;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final zzps zznq() throws IOException {
        zzat(2);
        return this.zzawp.zznq();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final int zznr() throws IOException {
        zzat(0);
        return this.zzawp.zznr();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final int zzns() throws IOException {
        zzat(0);
        return this.zzawp.zzns();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final int zznt() throws IOException {
        zzat(5);
        return this.zzawp.zznt();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final long zznu() throws IOException {
        zzat(1);
        return this.zzawp.zznu();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final int zznv() throws IOException {
        zzat(0);
        return this.zzawp.zznv();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final long zznw() throws IOException {
        zzat(0);
        return this.zzawp.zznw();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzg(List<Double> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzqm) {
            zzqm zzqm = (zzqm) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzqm.zzd(this.zzawp.readDouble());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznr = this.zzawp.zznr();
                zzau(zznr);
                int zznz = this.zzawp.zznz() + zznr;
                do {
                    zzqm.zzd(this.zzawp.readDouble());
                } while (this.zzawp.zznz() < zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzawp.readDouble()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznr2 = this.zzawp.zznr();
                zzau(zznr2);
                int zznz2 = this.zzawp.zznz() + zznr2;
                do {
                    list.add(Double.valueOf(this.zzawp.readDouble()));
                } while (this.zzawp.zznz() < zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzh(List<Float> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzqz) {
            zzqz zzqz = (zzqz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zznr = this.zzawp.zznr();
                zzav(zznr);
                int zznz = this.zzawp.zznz() + zznr;
                do {
                    zzqz.zzc(this.zzawp.readFloat());
                } while (this.zzawp.zznz() < zznz);
            } else if (i == 5) {
                do {
                    zzqz.zzc(this.zzawp.readFloat());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zznr2 = this.zzawp.zznr();
                zzav(zznr2);
                int zznz2 = this.zzawp.zznz() + zznr2;
                do {
                    list.add(Float.valueOf(this.zzawp.readFloat()));
                } while (this.zzawp.zznz() < zznz2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzawp.readFloat()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzi(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzry.zzaa(this.zzawp.zznj());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznz = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    zzry.zzaa(this.zzawp.zznj());
                } while (this.zzawp.zznz() < zznz);
                zzaw(zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzawp.zznj()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznz2 = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    list.add(Long.valueOf(this.zzawp.zznj()));
                } while (this.zzawp.zznz() < zznz2);
                zzaw(zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzj(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzry.zzaa(this.zzawp.zznk());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznz = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    zzry.zzaa(this.zzawp.zznk());
                } while (this.zzawp.zznz() < zznz);
                zzaw(zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzawp.zznk()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznz2 = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    list.add(Long.valueOf(this.zzawp.zznk()));
                } while (this.zzawp.zznz() < zznz2);
                zzaw(zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzk(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzrd.zzbm(this.zzawp.zznl());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznz = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    zzrd.zzbm(this.zzawp.zznl());
                } while (this.zzawp.zznz() < zznz);
                zzaw(zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzawp.zznl()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznz2 = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    list.add(Integer.valueOf(this.zzawp.zznl()));
                } while (this.zzawp.zznz() < zznz2);
                zzaw(zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzl(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzry.zzaa(this.zzawp.zznm());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznr = this.zzawp.zznr();
                zzau(zznr);
                int zznz = this.zzawp.zznz() + zznr;
                do {
                    zzry.zzaa(this.zzawp.zznm());
                } while (this.zzawp.zznz() < zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzawp.zznm()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznr2 = this.zzawp.zznr();
                zzau(zznr2);
                int zznz2 = this.zzawp.zznz() + zznr2;
                do {
                    list.add(Long.valueOf(this.zzawp.zznm()));
                } while (this.zzawp.zznz() < zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzm(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zznr = this.zzawp.zznr();
                zzav(zznr);
                int zznz = this.zzawp.zznz() + zznr;
                do {
                    zzrd.zzbm(this.zzawp.zznn());
                } while (this.zzawp.zznz() < zznz);
            } else if (i == 5) {
                do {
                    zzrd.zzbm(this.zzawp.zznn());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zznr2 = this.zzawp.zznr();
                zzav(zznr2);
                int zznz2 = this.zzawp.zznz() + zznr2;
                do {
                    list.add(Integer.valueOf(this.zzawp.zznn()));
                } while (this.zzawp.zznz() < zznz2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzawp.zznn()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzn(List<Boolean> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzpq) {
            zzpq zzpq = (zzpq) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzpq.addBoolean(this.zzawp.zzno());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznz = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    zzpq.addBoolean(this.zzawp.zzno());
                } while (this.zzawp.zznz() < zznz);
                zzaw(zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzawp.zzno()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznz2 = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    list.add(Boolean.valueOf(this.zzawp.zzno()));
                } while (this.zzawp.zznz() < zznz2);
                zzaw(zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzni;
        int zzni2;
        if ((this.tag & 7) != 2) {
            throw zzrk.zzpt();
        } else if (!(list instanceof zzrt) || z) {
            do {
                list.add(z ? zznp() : readString());
                if (!this.zzawp.zzny()) {
                    zzni = this.zzawp.zzni();
                } else {
                    return;
                }
            } while (zzni == this.tag);
            this.zzawr = zzni;
        } else {
            zzrt zzrt = (zzrt) list;
            do {
                zzrt.zzc(zznq());
                if (!this.zzawp.zzny()) {
                    zzni2 = this.zzawp.zzni();
                } else {
                    return;
                }
            } while (zzni2 == this.tag);
            this.zzawr = zzni2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.zzsy
    public final <T> void zza(List<T> list, zzsz<T> zzsz, zzqp zzqp) throws IOException {
        int zzni;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzsz, zzqp));
                if (!this.zzawp.zzny() && this.zzawr == 0) {
                    zzni = this.zzawp.zzni();
                } else {
                    return;
                }
            } while (zzni == i);
            this.zzawr = zzni;
            return;
        }
        throw zzrk.zzpt();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.zzsy
    public final <T> void zzb(List<T> list, zzsz<T> zzsz, zzqp zzqp) throws IOException {
        int zzni;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzsz, zzqp));
                if (!this.zzawp.zzny() && this.zzawr == 0) {
                    zzni = this.zzawp.zzni();
                } else {
                    return;
                }
            } while (zzni == i);
            this.zzawr = zzni;
            return;
        }
        throw zzrk.zzpt();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzp(List<zzps> list) throws IOException {
        int zzni;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zznq());
                if (!this.zzawp.zzny()) {
                    zzni = this.zzawp.zzni();
                } else {
                    return;
                }
            } while (zzni == this.tag);
            this.zzawr = zzni;
            return;
        }
        throw zzrk.zzpt();
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzq(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzrd.zzbm(this.zzawp.zznr());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznz = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    zzrd.zzbm(this.zzawp.zznr());
                } while (this.zzawp.zznz() < zznz);
                zzaw(zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzawp.zznr()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznz2 = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    list.add(Integer.valueOf(this.zzawp.zznr()));
                } while (this.zzawp.zznz() < zznz2);
                zzaw(zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzr(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzrd.zzbm(this.zzawp.zzns());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznz = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    zzrd.zzbm(this.zzawp.zzns());
                } while (this.zzawp.zznz() < zznz);
                zzaw(zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzawp.zzns()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznz2 = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    list.add(Integer.valueOf(this.zzawp.zzns()));
                } while (this.zzawp.zznz() < zznz2);
                zzaw(zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzs(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zznr = this.zzawp.zznr();
                zzav(zznr);
                int zznz = this.zzawp.zznz() + zznr;
                do {
                    zzrd.zzbm(this.zzawp.zznt());
                } while (this.zzawp.zznz() < zznz);
            } else if (i == 5) {
                do {
                    zzrd.zzbm(this.zzawp.zznt());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zznr2 = this.zzawp.zznr();
                zzav(zznr2);
                int zznz2 = this.zzawp.zznz() + zznr2;
                do {
                    list.add(Integer.valueOf(this.zzawp.zznt()));
                } while (this.zzawp.zznz() < zznz2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzawp.zznt()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzt(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzry.zzaa(this.zzawp.zznu());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznr = this.zzawp.zznr();
                zzau(zznr);
                int zznz = this.zzawp.zznz() + zznr;
                do {
                    zzry.zzaa(this.zzawp.zznu());
                } while (this.zzawp.zznz() < zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzawp.zznu()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznr2 = this.zzawp.zznr();
                zzau(zznr2);
                int zznz2 = this.zzawp.zznz() + zznr2;
                do {
                    list.add(Long.valueOf(this.zzawp.zznu()));
                } while (this.zzawp.zznz() < zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzu(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzrd.zzbm(this.zzawp.zznv());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznz = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    zzrd.zzbm(this.zzawp.zznv());
                } while (this.zzawp.zznz() < zznz);
                zzaw(zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzawp.zznv()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznz2 = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    list.add(Integer.valueOf(this.zzawp.zznv()));
                } while (this.zzawp.zznz() < zznz2);
                zzaw(zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsy
    public final void zzv(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzry.zzaa(this.zzawp.zznw());
                    if (!this.zzawp.zzny()) {
                        zzni2 = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni2 == this.tag);
                this.zzawr = zzni2;
            } else if (i == 2) {
                int zznz = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    zzry.zzaa(this.zzawp.zznw());
                } while (this.zzawp.zznz() < zznz);
                zzaw(zznz);
            } else {
                throw zzrk.zzpt();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzawp.zznw()));
                    if (!this.zzawp.zzny()) {
                        zzni = this.zzawp.zzni();
                    } else {
                        return;
                    }
                } while (zzni == this.tag);
                this.zzawr = zzni;
            } else if (i2 == 2) {
                int zznz2 = this.zzawp.zznz() + this.zzawp.zznr();
                do {
                    list.add(Long.valueOf(this.zzawp.zznw()));
                } while (this.zzawp.zznz() < zznz2);
                zzaw(zznz2);
            } else {
                throw zzrk.zzpt();
            }
        }
    }

    private static void zzau(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzrk.zzpv();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.zzsy
    public final <K, V> void zza(Map<K, V> map, zzsd<K, V> zzsd, zzqp zzqp) throws IOException {
        zzat(2);
        int zzaq = this.zzawp.zzaq(this.zzawp.zznr());
        Object obj = zzsd.zzbcq;
        Object obj2 = zzsd.zzbcs;
        while (true) {
            try {
                int zzog = zzog();
                if (zzog == Integer.MAX_VALUE || this.zzawp.zzny()) {
                    map.put(obj, obj2);
                } else if (zzog == 1) {
                    obj = zza(zzsd.zzbcp, (Class<?>) null, (zzqp) null);
                } else if (zzog != 2) {
                    try {
                        if (!zzoh()) {
                            throw new zzrk("Unable to parse map entry.");
                        }
                    } catch (zzrl unused) {
                        if (!zzoh()) {
                            throw new zzrk("Unable to parse map entry.");
                        }
                    }
                } else {
                    obj2 = zza(zzsd.zzbcr, zzsd.zzbcs.getClass(), zzqp);
                }
            } finally {
                this.zzawp.zzar(zzaq);
            }
        }
        map.put(obj, obj2);
    }

    private final Object zza(zzug zzug, Class<?> cls, zzqp zzqp) throws IOException {
        switch (zzqi.zzaws[zzug.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzno());
            case 2:
                return zznq();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzns());
            case 5:
                return Integer.valueOf(zznn());
            case 6:
                return Long.valueOf(zznm());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zznl());
            case 9:
                return Long.valueOf(zznk());
            case 10:
                zzat(2);
                return zzc(zzsw.zzqs().zzi(cls), zzqp);
            case 11:
                return Integer.valueOf(zznt());
            case 12:
                return Long.valueOf(zznu());
            case 13:
                return Integer.valueOf(zznv());
            case 14:
                return Long.valueOf(zznw());
            case 15:
                return zznp();
            case 16:
                return Integer.valueOf(zznr());
            case 17:
                return Long.valueOf(zznj());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzav(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzrk.zzpv();
        }
    }

    private final void zzaw(int i) throws IOException {
        if (this.zzawp.zznz() != i) {
            throw zzrk.zzpp();
        }
    }
}
