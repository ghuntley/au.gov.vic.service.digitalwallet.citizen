package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzho extends zzhm {
    private final boolean zza = true;
    private final byte[] zzb;
    private int zzc;
    private final int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public zzho(ByteBuffer byteBuffer, boolean z) {
        super(null);
        this.zzb = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.zzc = arrayOffset;
        this.zzd = arrayOffset;
        this.zze = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final boolean zzu() {
        return this.zzc == this.zze;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zza() throws IOException {
        if (zzu()) {
            return Integer.MAX_VALUE;
        }
        int zzv = zzv();
        this.zzf = zzv;
        if (zzv == this.zzg) {
            return Integer.MAX_VALUE;
        }
        return zzv >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzb() {
        return this.zzf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
    @Override // com.google.android.gms.internal.vision.zzld
    public final boolean zzc() throws IOException {
        int i;
        int i2;
        if (zzu() || (i = this.zzf) == (i2 = this.zzg)) {
            return false;
        }
        int i3 = i & 7;
        if (i3 == 0) {
            int i4 = this.zze;
            int i5 = this.zzc;
            if (i4 - i5 >= 10) {
                byte[] bArr = this.zzb;
                int i6 = 0;
                while (true) {
                    if (i6 >= 10) {
                        break;
                    }
                    int i7 = i5 + 1;
                    if (bArr[i5] >= 0) {
                        this.zzc = i7;
                        break;
                    }
                    i6++;
                    i5 = i7;
                }
                return true;
            }
            for (int i8 = 0; i8 < 10; i8++) {
                if (zzy() >= 0) {
                    return true;
                }
            }
            throw zzjk.zzc();
        } else if (i3 == 1) {
            zza(8);
            return true;
        } else if (i3 == 2) {
            zza(zzv());
            return true;
        } else if (i3 == 3) {
            this.zzg = ((i >>> 3) << 3) | 4;
            while (zza() != Integer.MAX_VALUE && zzc()) {
                while (zza() != Integer.MAX_VALUE) {
                    while (zza() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (this.zzf == this.zzg) {
                this.zzg = i2;
                return true;
            }
            throw zzjk.zzg();
        } else if (i3 == 5) {
            zza(4);
            return true;
        } else {
            throw zzjk.zzf();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final double zzd() throws IOException {
        zzc(1);
        return Double.longBitsToDouble(zzaa());
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final float zze() throws IOException {
        zzc(5);
        return Float.intBitsToFloat(zzz());
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzf() throws IOException {
        zzc(0);
        return zzw();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzg() throws IOException {
        zzc(0);
        return zzw();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzh() throws IOException {
        zzc(0);
        return zzv();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzi() throws IOException {
        zzc(1);
        return zzaa();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzj() throws IOException {
        zzc(5);
        return zzz();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final boolean zzk() throws IOException {
        zzc(0);
        if (zzv() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final String zzl() throws IOException {
        return zza(false);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final String zzm() throws IOException {
        return zza(true);
    }

    private final String zza(boolean z) throws IOException {
        zzc(2);
        int zzv = zzv();
        if (zzv == 0) {
            return "";
        }
        zzb(zzv);
        if (z) {
            byte[] bArr = this.zzb;
            int i = this.zzc;
            if (!zzmd.zza(bArr, i, i + zzv)) {
                throw zzjk.zzh();
            }
        }
        String str = new String(this.zzb, this.zzc, zzv, zzjf.zza);
        this.zzc += zzv;
        return str;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zza(Class<T> cls, zzio zzio) throws IOException {
        zzc(2);
        return (T) zzc(zzky.zza().zza((Class) cls), zzio);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zza(zzlc<T> zzlc, zzio zzio) throws IOException {
        zzc(2);
        return (T) zzc(zzlc, zzio);
    }

    private final <T> T zzc(zzlc<T> zzlc, zzio zzio) throws IOException {
        int zzv = zzv();
        zzb(zzv);
        int i = this.zze;
        int i2 = this.zzc + zzv;
        this.zze = i2;
        try {
            T zza2 = zzlc.zza();
            zzlc.zza(zza2, this, zzio);
            zzlc.zzc(zza2);
            if (this.zzc == i2) {
                return zza2;
            }
            throw zzjk.zzg();
        } finally {
            this.zze = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zzb(Class<T> cls, zzio zzio) throws IOException {
        zzc(3);
        return (T) zzd(zzky.zza().zza((Class) cls), zzio);
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> T zzb(zzlc<T> zzlc, zzio zzio) throws IOException {
        zzc(3);
        return (T) zzd(zzlc, zzio);
    }

    private final <T> T zzd(zzlc<T> zzlc, zzio zzio) throws IOException {
        int i = this.zzg;
        this.zzg = ((this.zzf >>> 3) << 3) | 4;
        try {
            T zza2 = zzlc.zza();
            zzlc.zza(zza2, this, zzio);
            zzlc.zzc(zza2);
            if (this.zzf == this.zzg) {
                return zza2;
            }
            throw zzjk.zzg();
        } finally {
            this.zzg = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final zzht zzn() throws IOException {
        zzht zzht;
        zzc(2);
        int zzv = zzv();
        if (zzv == 0) {
            return zzht.zza;
        }
        zzb(zzv);
        if (this.zza) {
            zzht = zzht.zzb(this.zzb, this.zzc, zzv);
        } else {
            zzht = zzht.zza(this.zzb, this.zzc, zzv);
        }
        this.zzc += zzv;
        return zzht;
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzo() throws IOException {
        zzc(0);
        return zzv();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzp() throws IOException {
        zzc(0);
        return zzv();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzq() throws IOException {
        zzc(5);
        return zzz();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzr() throws IOException {
        zzc(1);
        return zzaa();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final int zzs() throws IOException {
        zzc(0);
        return zzif.zze(zzv());
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final long zzt() throws IOException {
        zzc(0);
        return zzif.zza(zzw());
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zza(List<Double> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzin) {
            zzin zzin = (zzin) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzin.zza(zzd());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = zzv();
                zzd(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzin.zza(Double.longBitsToDouble(zzac()));
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 1) {
                do {
                    list.add(Double.valueOf(zzd()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i5 == 2) {
                int zzv2 = zzv();
                zzd(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzac())));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzb(List<Float> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int zzv = zzv();
                zze(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzja.zza(Float.intBitsToFloat(zzab()));
                }
            } else if (i3 == 5) {
                do {
                    zzja.zza(zze());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 2) {
                int zzv2 = zzv();
                zze(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzab())));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Float.valueOf(zze()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzc(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjy.zza(zzf());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjy.zza(zzw());
                }
                zzf(zzv);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzf()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Long.valueOf(zzw()));
                }
                zzf(zzv2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzd(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjy.zza(zzg());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjy.zza(zzw());
                }
                zzf(zzv);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzg()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Long.valueOf(zzw()));
                }
                zzf(zzv2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zze(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjd.zzc(zzh());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjd.zzc(zzv());
                }
                zzf(zzv);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzh()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Integer.valueOf(zzv()));
                }
                zzf(zzv2);
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzf(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzjy.zza(zzi());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = zzv();
                zzd(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzjy.zza(zzac());
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzi()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i5 == 2) {
                int zzv2 = zzv();
                zzd(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Long.valueOf(zzac()));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzg(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int zzv = zzv();
                zze(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzjd.zzc(zzab());
                }
            } else if (i3 == 5) {
                do {
                    zzjd.zzc(zzj());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 2) {
                int zzv2 = zzv();
                zze(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Integer.valueOf(zzab()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzj()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzh(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhr) {
            zzhr zzhr = (zzhr) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzhr.zza(zzk());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzhr.zza(zzv() != 0);
                }
                zzf(zzv);
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Boolean.valueOf(zzk()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Boolean.valueOf(zzv() != 0));
                }
                zzf(zzv2);
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
        int i;
        int i2;
        if ((this.zzf & 7) != 2) {
            throw zzjk.zzf();
        } else if (!(list instanceof zzjv) || z) {
            do {
                list.add(zza(z));
                if (!zzu()) {
                    i = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
        } else {
            zzjv zzjv = (zzjv) list;
            do {
                zzjv.zza(zzn());
                if (!zzu()) {
                    i2 = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == this.zzf);
            this.zzc = i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> void zza(List<T> list, zzlc<T> zzlc, zzio zzio) throws IOException {
        int i;
        int i2 = this.zzf;
        if ((i2 & 7) == 2) {
            do {
                list.add(zzc(zzlc, zzio));
                if (!zzu()) {
                    i = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == i2);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <T> void zzb(List<T> list, zzlc<T> zzlc, zzio zzio) throws IOException {
        int i;
        int i2 = this.zzf;
        if ((i2 & 7) == 3) {
            do {
                list.add(zzd(zzlc, zzio));
                if (!zzu()) {
                    i = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == i2);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzk(List<zzht> list) throws IOException {
        int i;
        if ((this.zzf & 7) == 2) {
            do {
                list.add(zzn());
                if (!zzu()) {
                    i = this.zzc;
                } else {
                    return;
                }
            } while (zzv() == this.zzf);
            this.zzc = i;
            return;
        }
        throw zzjk.zzf();
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzl(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjd.zzc(zzo());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjd.zzc(zzv());
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzo()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Integer.valueOf(zzv()));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzm(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjd.zzc(zzp());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjd.zzc(zzv());
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzp()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Integer.valueOf(zzv()));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzn(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 2) {
                int zzv = zzv();
                zze(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzjd.zzc(zzab());
                }
            } else if (i3 == 5) {
                do {
                    zzjd.zzc(zzq());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 2) {
                int zzv2 = zzv();
                zze(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Integer.valueOf(zzab()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzq()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzo(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 1) {
                do {
                    zzjy.zza(zzr());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = zzv();
                zzd(zzv);
                int i4 = this.zzc + zzv;
                while (this.zzc < i4) {
                    zzjy.zza(zzac());
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i5 = this.zzf & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzr()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i5 == 2) {
                int zzv2 = zzv();
                zzd(zzv2);
                int i6 = this.zzc + zzv2;
                while (this.zzc < i6) {
                    list.add(Long.valueOf(zzac()));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzp(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjd.zzc(zzs());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjd.zzc(zzif.zze(zzv()));
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzs()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Integer.valueOf(zzif.zze(zzv())));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzld
    public final void zzq(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i3 = this.zzf & 7;
            if (i3 == 0) {
                do {
                    zzjy.zza(zzt());
                    if (!zzu()) {
                        i2 = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i2;
            } else if (i3 == 2) {
                int zzv = this.zzc + zzv();
                while (this.zzc < zzv) {
                    zzjy.zza(zzif.zza(zzw()));
                }
            } else {
                throw zzjk.zzf();
            }
        } else {
            int i4 = this.zzf & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzt()));
                    if (!zzu()) {
                        i = this.zzc;
                    } else {
                        return;
                    }
                } while (zzv() == this.zzf);
                this.zzc = i;
            } else if (i4 == 2) {
                int zzv2 = this.zzc + zzv();
                while (this.zzc < zzv2) {
                    list.add(Long.valueOf(zzif.zza(zzw())));
                }
            } else {
                throw zzjk.zzf();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzld
    public final <K, V> void zza(Map<K, V> map, zzkf<K, V> zzkf, zzio zzio) throws IOException {
        zzc(2);
        int zzv = zzv();
        zzb(zzv);
        int i = this.zze;
        this.zze = this.zzc + zzv;
        try {
            Object obj = zzkf.zzb;
            Object obj2 = zzkf.zzd;
            while (true) {
                int zza2 = zza();
                if (zza2 == Integer.MAX_VALUE) {
                    map.put(obj, obj2);
                    return;
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
            }
        } finally {
            this.zze = i;
        }
    }

    private final Object zza(zzml zzml, Class<?> cls, zzio zzio) throws IOException {
        switch (zzhp.zza[zzml.ordinal()]) {
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
                return zza(true);
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzv() throws IOException {
        int i;
        int i2 = this.zzc;
        int i3 = this.zze;
        if (i3 != i2) {
            byte[] bArr = this.zzb;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzc = i4;
                return b;
            } else if (i3 - i4 < 9) {
                return (int) zzx();
            } else {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ -128;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ -2080896;
                        } else {
                            i7 = i5 + 1;
                            byte b2 = bArr[i5];
                            i = (i9 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i5 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            i7 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i7 + 1;
                                                if (bArr[i7] < 0) {
                                                    throw zzjk.zzc();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i7;
                }
                this.zzc = i5;
                return i;
            }
        } else {
            throw zzjk.zza();
        }
    }

    private final long zzw() throws IOException {
        long j;
        long j2;
        long j3;
        int i;
        int i2 = this.zzc;
        int i3 = this.zze;
        if (i3 != i2) {
            byte[] bArr = this.zzb;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzc = i4;
                return (long) b;
            } else if (i3 - i4 < 9) {
                return zzx();
            } else {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ -128;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        i5 = i7;
                        j = (long) (i8 ^ 16256);
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ -2080896;
                        } else {
                            long j4 = (long) i9;
                            int i10 = i5 + 1;
                            long j5 = j4 ^ (((long) bArr[i5]) << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                i5 = i10 + 1;
                                long j6 = j5 ^ (((long) bArr[i10]) << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i10 = i5 + 1;
                                    j5 = j6 ^ (((long) bArr[i5]) << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i5 = i10 + 1;
                                        j6 = j5 ^ (((long) bArr[i10]) << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i11 = i5 + 1;
                                            long j7 = (j6 ^ (((long) bArr[i5]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i5 = i11 + 1;
                                                if (((long) bArr[i11]) < 0) {
                                                    throw zzjk.zzc();
                                                }
                                            } else {
                                                i5 = i11;
                                            }
                                            j = j7;
                                        }
                                    }
                                }
                                j = j6 ^ j2;
                            }
                            j = j5 ^ j3;
                            i5 = i10;
                        }
                    }
                    this.zzc = i5;
                    return j;
                }
                j = (long) i;
                this.zzc = i5;
                return j;
            }
        } else {
            throw zzjk.zza();
        }
    }

    private final long zzx() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzy = zzy();
            j |= ((long) (zzy & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzy & 128) == 0) {
                return j;
            }
        }
        throw zzjk.zzc();
    }

    private final byte zzy() throws IOException {
        int i = this.zzc;
        if (i != this.zze) {
            byte[] bArr = this.zzb;
            this.zzc = i + 1;
            return bArr[i];
        }
        throw zzjk.zza();
    }

    private final int zzz() throws IOException {
        zzb(4);
        return zzab();
    }

    private final long zzaa() throws IOException {
        zzb(8);
        return zzac();
    }

    private final int zzab() {
        int i = this.zzc;
        byte[] bArr = this.zzb;
        this.zzc = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    private final long zzac() {
        int i = this.zzc;
        byte[] bArr = this.zzb;
        this.zzc = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zza(int i) throws IOException {
        zzb(i);
        this.zzc += i;
    }

    private final void zzb(int i) throws IOException {
        if (i < 0 || i > this.zze - this.zzc) {
            throw zzjk.zza();
        }
    }

    private final void zzc(int i) throws IOException {
        if ((this.zzf & 7) != i) {
            throw zzjk.zzf();
        }
    }

    private final void zzd(int i) throws IOException {
        zzb(i);
        if ((i & 7) != 0) {
            throw zzjk.zzg();
        }
    }

    private final void zze(int i) throws IOException {
        zzb(i);
        if ((i & 3) != 0) {
            throw zzjk.zzg();
        }
    }

    private final void zzf(int i) throws IOException {
        if (this.zzc != i) {
            throw zzjk.zza();
        }
    }
}
