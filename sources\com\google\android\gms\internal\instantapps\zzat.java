package com.google.android.gms.internal.instantapps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzat> CREATOR = new zzaw();
    private final String packageName;
    private final int versionCode;
    private final String zzae;
    private final byte[] zzai;
    private final String zzcl;
    private final long zzcm;

    public zzat(String str, int i, String str2, String str3, long j, byte[] bArr) {
        this.packageName = str;
        this.versionCode = i;
        this.zzcl = str2;
        this.zzae = str3;
        this.zzcm = j;
        this.zzai = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.packageName, false);
        SafeParcelWriter.writeInt(parcel, 2, this.versionCode);
        SafeParcelWriter.writeString(parcel, 3, this.zzcl, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzae, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzcm);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzai, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
