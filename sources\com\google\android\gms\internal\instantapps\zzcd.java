package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* access modifiers changed from: package-private */
public final class zzcd extends zzcb {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzall;
    private int zzalm;
    private int zzaln;
    private int zzalo;
    private int zzalp;

    private zzcd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzalp = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzaln = i;
        this.zzall = z;
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzaa() throws IOException {
        if (zzaq()) {
            this.zzalo = 0;
            return 0;
        }
        int zzau = zzau();
        this.zzalo = zzau;
        if ((zzau >>> 3) != 0) {
            return zzau;
        }
        throw zzdf.zzci();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final void zzm(int i) throws zzdf {
        if (this.zzalo != i) {
            throw zzdf.zzcj();
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final boolean zzn(int i) throws IOException {
        int zzaa;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzdf.zzch();
            }
            while (i3 < 10) {
                if (zzaz() < 0) {
                    i3++;
                }
            }
            throw zzdf.zzch();
            return true;
        } else if (i2 == 1) {
            zzv(8);
            return true;
        } else if (i2 == 2) {
            zzv(zzau());
            return true;
        } else if (i2 == 3) {
            do {
                zzaa = zzaa();
                if (zzaa == 0) {
                    break;
                }
            } while (zzn(zzaa));
            zzm(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzv(4);
                return true;
            }
            throw zzdf.zzck();
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzax());
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzaw());
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final long zzab() throws IOException {
        return zzav();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final long zzac() throws IOException {
        return zzav();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzad() throws IOException {
        return zzau();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final long zzae() throws IOException {
        return zzax();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzaf() throws IOException {
        return zzaw();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final boolean zzag() throws IOException {
        return zzav() != 0;
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final String readString() throws IOException {
        int zzau = zzau();
        if (zzau > 0 && zzau <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzau, zzcy.UTF_8);
            this.pos += zzau;
            return str;
        } else if (zzau == 0) {
            return "";
        } else {
            if (zzau < 0) {
                throw zzdf.zzcg();
            }
            throw zzdf.zzcf();
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final String zzah() throws IOException {
        int zzau = zzau();
        if (zzau > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzau <= i - i2) {
                String zzg = zzfv.zzg(this.buffer, i2, zzau);
                this.pos += zzau;
                return zzg;
            }
        }
        if (zzau == 0) {
            return "";
        }
        if (zzau <= 0) {
            throw zzdf.zzcg();
        }
        throw zzdf.zzcf();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final zzbp zzai() throws IOException {
        byte[] bArr;
        int zzau = zzau();
        if (zzau > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzau <= i - i2) {
                zzbp zzb = zzbp.zzb(this.buffer, i2, zzau);
                this.pos += zzau;
                return zzb;
            }
        }
        if (zzau == 0) {
            return zzbp.zzakv;
        }
        if (zzau > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzau <= i3 - i4) {
                int i5 = zzau + i4;
                this.pos = i5;
                bArr = Arrays.copyOfRange(this.buffer, i4, i5);
                return zzbp.zza(bArr);
            }
        }
        if (zzau > 0) {
            throw zzdf.zzcf();
        } else if (zzau == 0) {
            bArr = zzcy.zzapu;
            return zzbp.zza(bArr);
        } else {
            throw zzdf.zzcg();
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzaj() throws IOException {
        return zzau();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzak() throws IOException {
        return zzau();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzal() throws IOException {
        return zzaw();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final long zzam() throws IOException {
        return zzax();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzan() throws IOException {
        return zzq(zzau());
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final long zzao() throws IOException {
        return zzc(zzav());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    private final int zzau() throws IOException {
        int i;
        int i2 = this.pos;
        int i3 = this.limit;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i4;
                return b;
            } else if (i3 - i4 >= 9) {
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
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i7;
                }
                this.pos = i5;
                return i;
            }
        }
        return (int) zzap();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    private final long zzav() throws IOException {
        long j;
        long j2;
        long j3;
        int i;
        int i2 = this.pos;
        int i3 = this.limit;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i4;
                return (long) b;
            } else if (i3 - i4 >= 9) {
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
                    this.pos = i5;
                    return j;
                }
                j = (long) i;
                this.pos = i5;
                return j;
            }
        }
        return zzap();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final long zzap() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzaz = zzaz();
            j |= ((long) (zzaz & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzaz & 128) == 0) {
                return j;
            }
        }
        throw zzdf.zzch();
    }

    private final int zzaw() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        }
        throw zzdf.zzcf();
    }

    private final long zzax() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzdf.zzcf();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzo(int i) throws zzdf {
        if (i >= 0) {
            int zzar = i + zzar();
            int i2 = this.zzalp;
            if (zzar <= i2) {
                this.zzalp = zzar;
                zzay();
                return i2;
            }
            throw zzdf.zzcf();
        }
        throw zzdf.zzcg();
    }

    private final void zzay() {
        int i = this.limit + this.zzalm;
        this.limit = i;
        int i2 = i - this.zzaln;
        int i3 = this.zzalp;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzalm = i4;
            this.limit = i - i4;
            return;
        }
        this.zzalm = 0;
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final void zzp(int i) {
        this.zzalp = i;
        zzay();
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final boolean zzaq() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.instantapps.zzcb
    public final int zzar() {
        return this.pos - this.zzaln;
    }

    private final byte zzaz() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzdf.zzcf();
    }

    private final void zzv(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzdf.zzcg();
        }
        throw zzdf.zzcf();
    }
}
