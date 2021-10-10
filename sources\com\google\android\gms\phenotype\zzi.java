package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Comparator;

public final class zzi extends AbstractSafeParcelable implements Comparable<zzi> {
    public static final Parcelable.Creator<zzi> CREATOR = new zzk();
    private static final Comparator<zzi> zzai = new zzj();
    public final String name;
    private final long zzab;
    private final boolean zzac;
    private final double zzad;
    private final String zzae;
    private final byte[] zzaf;
    private final int zzag;
    public final int zzah;

    public zzi(String str, long j, boolean z, double d, String str2, byte[] bArr, int i, int i2) {
        this.name = str;
        this.zzab = j;
        this.zzac = z;
        this.zzad = d;
        this.zzae = str2;
        this.zzaf = bArr;
        this.zzag = i;
        this.zzah = i2;
    }

    private static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzi zzi) {
        zzi zzi2 = zzi;
        int compareTo = this.name.compareTo(zzi2.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int compare = compare(this.zzag, zzi2.zzag);
        if (compare != 0) {
            return compare;
        }
        int i = this.zzag;
        if (i == 1) {
            int i2 = (this.zzab > zzi2.zzab ? 1 : (this.zzab == zzi2.zzab ? 0 : -1));
            if (i2 < 0) {
                return -1;
            }
            return i2 == 0 ? 0 : 1;
        } else if (i == 2) {
            boolean z = this.zzac;
            if (z == zzi2.zzac) {
                return 0;
            }
            return z ? 1 : -1;
        } else if (i == 3) {
            return Double.compare(this.zzad, zzi2.zzad);
        } else {
            if (i == 4) {
                String str = this.zzae;
                String str2 = zzi2.zzae;
                if (str == str2) {
                    return 0;
                }
                if (str == null) {
                    return -1;
                }
                if (str2 == null) {
                    return 1;
                }
                return str.compareTo(str2);
            } else if (i == 5) {
                byte[] bArr = this.zzaf;
                byte[] bArr2 = zzi2.zzaf;
                if (bArr == bArr2) {
                    return 0;
                }
                if (bArr == null) {
                    return -1;
                }
                if (bArr2 == null) {
                    return 1;
                }
                for (int i3 = 0; i3 < Math.min(this.zzaf.length, zzi2.zzaf.length); i3++) {
                    int i4 = this.zzaf[i3] - zzi2.zzaf[i3];
                    if (i4 != 0) {
                        return i4;
                    }
                }
                return compare(this.zzaf.length, zzi2.zzaf.length);
            } else {
                int i5 = this.zzag;
                StringBuilder sb = new StringBuilder(31);
                sb.append("Invalid enum value: ");
                sb.append(i5);
                throw new AssertionError(sb.toString());
            }
        }
    }

    public final boolean equals(Object obj) {
        int i;
        if (obj instanceof zzi) {
            zzi zzi = (zzi) obj;
            if (zzn.equals(this.name, zzi.name) && (i = this.zzag) == zzi.zzag && this.zzah == zzi.zzah) {
                if (i != 1) {
                    if (i == 2) {
                        return this.zzac == zzi.zzac;
                    }
                    if (i == 3) {
                        return this.zzad == zzi.zzad;
                    }
                    if (i == 4) {
                        return zzn.equals(this.zzae, zzi.zzae);
                    }
                    if (i == 5) {
                        return Arrays.equals(this.zzaf, zzi.zzaf);
                    }
                    int i2 = this.zzag;
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Invalid enum value: ");
                    sb.append(i2);
                    throw new AssertionError(sb.toString());
                } else if (this.zzab == zzi.zzab) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Flag(");
        sb.append(this.name);
        sb.append(", ");
        int i = this.zzag;
        if (i == 1) {
            sb.append(this.zzab);
        } else if (i == 2) {
            sb.append(this.zzac);
        } else if (i != 3) {
            if (i == 4) {
                sb.append("'");
                str = this.zzae;
            } else if (i != 5) {
                String str2 = this.name;
                int i2 = this.zzag;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 27);
                sb2.append("Invalid type: ");
                sb2.append(str2);
                sb2.append(", ");
                sb2.append(i2);
                throw new AssertionError(sb2.toString());
            } else if (this.zzaf == null) {
                sb.append("null");
            } else {
                sb.append("'");
                str = Base64.encodeToString(this.zzaf, 3);
            }
            sb.append(str);
            sb.append("'");
        } else {
            sb.append(this.zzad);
        }
        sb.append(", ");
        sb.append(this.zzag);
        sb.append(", ");
        sb.append(this.zzah);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzab);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzac);
        SafeParcelWriter.writeDouble(parcel, 5, this.zzad);
        SafeParcelWriter.writeString(parcel, 6, this.zzae, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzaf, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzag);
        SafeParcelWriter.writeInt(parcel, 9, this.zzah);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
