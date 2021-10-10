package com.google.android.gms.internal.instantapps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzk();
    private final String zzad;
    private final String zzae;
    private final String[] zzaf;
    private final int[] zzag;
    private final int zzah;
    private final byte[] zzai;
    private final boolean zzaj;

    public zzh(String str, String str2, String[] strArr, int[] iArr, int i, byte[] bArr, boolean z) {
        this.zzad = str;
        this.zzae = str2;
        this.zzaf = strArr;
        this.zzag = iArr;
        this.zzah = i;
        this.zzai = bArr;
        this.zzaj = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzad, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzae, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzaf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzah);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzai, false);
        SafeParcelWriter.writeIntArray(parcel, 8, this.zzag, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzaj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
