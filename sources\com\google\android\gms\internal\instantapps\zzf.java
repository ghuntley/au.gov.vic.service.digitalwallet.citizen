package com.google.android.gms.internal.instantapps;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzi();
    private final String packageName;
    private final List<zzat> zzaa;
    private final byte[] zzab;
    private final String zzu;
    private final List<zzap> zzv;
    private final List<zzh> zzw;
    private final int zzx;
    private final byte[] zzy;
    private final PackageInfo zzz;

    zzf(String str, String str2, List<zzap> list, List<zzh> list2, List<zzat> list3, int i, byte[] bArr, PackageInfo packageInfo, byte[] bArr2) {
        this.packageName = str;
        this.zzu = str2;
        this.zzv = list;
        this.zzw = list2;
        this.zzx = i;
        this.zzy = bArr;
        this.zzz = packageInfo;
        this.zzaa = list3;
        this.zzab = bArr2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzu, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zzv, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzw, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzx);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzy, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzz, i, false);
        SafeParcelWriter.writeTypedList(parcel, 11, this.zzaa, false);
        SafeParcelWriter.writeByteArray(parcel, 12, this.zzab, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
