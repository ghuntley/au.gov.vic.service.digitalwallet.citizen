package com.google.android.gms.internal.instantapps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new zzv();
    private final String packageName;
    private final String splitName;
    private final int versionCode;
    private final int zzar;
    private final String zzas;
    private final boolean zzat;
    private final Intent zzau;
    private final Intent zzav;
    private final zzf zzaw;
    private final zzap zzax;
    private final boolean zzay;
    private final byte[] zzaz;
    private final int zzba;
    private final byte[] zzbb;
    private final Bundle zzbc;

    zzw(int i, String str, boolean z, Intent intent, Intent intent2, zzf zzf, zzap zzap, boolean z2, byte[] bArr, String str2, int i2, int i3, String str3, byte[] bArr2, Bundle bundle) {
        this.zzar = i;
        this.zzas = str;
        this.zzat = z;
        this.zzau = intent;
        this.zzav = intent2;
        this.zzaw = zzf;
        this.zzax = zzap;
        this.zzay = z2;
        this.zzaz = bArr;
        this.packageName = str2;
        this.versionCode = i2;
        this.splitName = str3;
        this.zzba = i3;
        this.zzbb = bArr2;
        this.zzbc = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzar);
        SafeParcelWriter.writeString(parcel, 3, this.zzas, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzat);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzau, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzav, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzaw, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzax, i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzay);
        SafeParcelWriter.writeByteArray(parcel, 11, this.zzaz, false);
        SafeParcelWriter.writeString(parcel, 12, this.packageName, false);
        SafeParcelWriter.writeInt(parcel, 13, this.versionCode);
        SafeParcelWriter.writeString(parcel, 14, this.splitName, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzbc, false);
        SafeParcelWriter.writeInt(parcel, 16, this.zzba);
        SafeParcelWriter.writeByteArray(parcel, 17, this.zzbb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
