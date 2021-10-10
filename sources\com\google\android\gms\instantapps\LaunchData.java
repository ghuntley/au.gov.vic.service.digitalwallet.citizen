package com.google.android.gms.instantapps;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class LaunchData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LaunchData> CREATOR = new zzl();
    private final Intent intent;
    private final String packageName;
    private final String zzq;
    private final BitmapTeleporter zzr;
    private final Bitmap zzs;

    public LaunchData(Intent intent2, String str, String str2, BitmapTeleporter bitmapTeleporter) {
        this.intent = intent2;
        this.packageName = str;
        this.zzq = str2;
        this.zzr = bitmapTeleporter;
        this.zzs = bitmapTeleporter != null ? bitmapTeleporter.get() : null;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getApplicationLabel() {
        return this.zzq;
    }

    public Bitmap getApplicationIcon() {
        return this.zzs;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getIntent(), i, false);
        SafeParcelWriter.writeString(parcel, 3, getPackageName(), false);
        SafeParcelWriter.writeString(parcel, 4, getApplicationLabel(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzr, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
