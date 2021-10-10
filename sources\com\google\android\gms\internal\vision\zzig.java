package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzig implements zzld {
    private final zzif zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public static zzig zza(zzif zzif) {
        if (zzif.zzc != null) {
            return zzif.zzc;
        }
        return new zzig(zzif);
    }

    private zzig(zzif zzif) {
        zzif zzif2 = (zzif) zzjf.zza((Object) zzif, "input");
        this.zza = zzif2;
        zzif2.zzc = this;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zza() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zza();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final boolean zzc() throws IOException {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzb(i);
    }

    private final void zza(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzjk.zzf();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final double zzd() throws IOException {
        zza(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final float zze() throws IOException {
        zza(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzf() throws IOException {
        zza(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzg() throws IOException {
        zza(0);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzh() throws IOException {
        zza(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzi() throws IOException {
        zza(1);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzj() throws IOException {
        zza(5);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final boolean zzk() throws IOException {
        zza(0);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final String zzl() throws IOException {
        zza(2);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final String zzm() throws IOException {
        zza(2);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zza(Class<T> cls, zzio zzio) throws IOException {
        zza(2);
        return (T) zzc(zzky.zza().zza((Class) cls), zzio);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zza(zzlc<T> zzlc, zzio zzio) throws IOException {
        zza(2);
        return (T) zzc(zzlc, zzio);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zzb(Class<T> cls, zzio zzio) throws IOException {
        zza(3);
        return (T) zzd(zzky.zza().zza((Class) cls), zzio);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zzb(zzlc<T> zzlc, zzio zzio) throws IOException {
        zza(3);
        return (T) zzd(zzlc, zzio);
    }

    private final <T> T zzc(zzlc<T> zzlc, zzio zzio) throws IOException {
        int zzm = this.zza.zzm();
        if (this.zza.zza < this.zza.zzb) {
            int zzc2 = this.zza.zzc(zzm);
            T zza2 = zzlc.zza();
            this.zza.zza++;
            zzlc.zza(zza2, this, zzio);
            zzlc.zzc(zza2);
            this.zza.zza(0);
            zzif zzif = this.zza;
            zzif.zza--;
            this.zza.zzd(zzc2);
            return zza2;
        }
        throw new zzjk("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzlc<T> zzlc, zzio zzio) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzlc.zza();
            zzlc.zza(zza2, this, zzio);
            zzlc.zzc(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzjk.zzg();
        } finally {
            this.zzc = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final zzht zzn() throws IOException {
        zza(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzo() throws IOException {
        zza(0);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzp() throws IOException {
        zza(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzq() throws IOException {
        zza(5);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzr() throws IOException {
        zza(1);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzs() throws IOException {
        zza(0);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzt() throws IOException {
        zza(0);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zza(List<Double> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzin) {
            zzin zzin = (zzin) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzin.zza(this.zza.zzb());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzin.zza(this.zza.zzb());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzb(List<Float> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzja.zza(this.zza.zzc());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzja.zza(this.zza.zzc());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzc(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjy.zza(this.zza.zzd());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzjy.zza(this.zza.zzd());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzd(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjy.zza(this.zza.zze());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzjy.zza(this.zza.zze());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zze(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjd.zzc(this.zza.zzf());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzjd.zzc(this.zza.zzf());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzf(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzjy.zza(this.zza.zzg());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzjy.zza(this.zza.zzg());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzg(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzjd.zzc(this.zza.zzh());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzjd.zzc(this.zza.zzh());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzh(List<Boolean> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzhr) {
            zzhr zzhr = (zzhr) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzhr.zza(this.zza.zzi());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzhr.zza(this.zza.zzi());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzi(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzj(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzjk.zzf();
        } else if (!(list instanceof zzjv) || z) {
            do {
                list.add(z ? zzm() : zzl());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        } else {
            zzjv zzjv = (zzjv) list;
            do {
                zzjv.zza(zzn());
                if (!this.zza.zzt()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> void zza(List<T> list, zzlc<T> zzlc, zzio zzio) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzlc, zzio));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzjk.zzf();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> void zzb(List<T> list, zzlc<T> zzlc, zzio zzio) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzlc, zzio));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzk(List<zzht> list) throws IOException {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzn());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzl(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjd.zzc(this.zza.zzm());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzjd.zzc(this.zza.zzm());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzm(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjd.zzc(this.zza.zzn());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzjd.zzc(this.zza.zzn());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzn(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzjd.zzc(this.zza.zzo());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzjd.zzc(this.zza.zzo());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzo(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzjy.zza(this.zza.zzp());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzjy.zza(this.zza.zzp());
                } while (this.zza.zzu() < zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzu() < zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzp(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjd.zzc(this.zza.zzq());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzjd.zzc(this.zza.zzq());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzq(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjy.zza(this.zza.zzr());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzjy.zza(this.zza.zzr());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    private static void zzb(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzjk.zzg();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <K, V> void zza(Map<K, V> map, zzkf<K, V> zzkf, zzio zzio) throws IOException {
        zza(2);
        int zzc2 = this.zza.zzc(this.zza.zzm());
        Object obj = zzkf.zzb;
        Object obj2 = zzkf.zzd;
        while (true) {
            try {
                int zza2 = zza();
                if (zza2 == Integer.MAX_VALUE || this.zza.zzt()) {
                    map.put(obj, obj2);
                } else if (zza2 == 1) {
                    obj = zza(zzkf.zza, (Class<?>) null, (zzio) null);
                } else if (zza2 != 2) {
                    try {
                        if (!zzc()) {
                            throw new zzjk("Unable to parse map entry.");
                        }
                    } catch (zzjn unused) {
                        if (!zzc()) {
                            throw new zzjk("Unable to parse map entry.");
                        }
                    }
                } else {
                    obj2 = zza(zzkf.zzc, zzkf.zzd.getClass(), zzio);
                }
            } finally {
                this.zza.zzd(zzc2);
            }
        }
        map.put(obj, obj2);
    }

    private final Object zza(zzml zzml, Class<?> cls, zzio zzio) throws IOException {
        switch (zzij.zza[zzml.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                return zza(cls, zzio);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zzm();
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzjk.zzg();
        }
    }

    private final void zzd(int i) throws IOException {
        if (this.zza.zzu() != i) {
            throw zzjk.zza();
        }
    }
}
