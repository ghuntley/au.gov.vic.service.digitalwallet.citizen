package com.google.android.gms.internal.instantapps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new zzas();
    private final int port;
    private final String zzad;
    private final String zzby;
    @Nullable
    private final String zzbz;
    @Nullable
    private final String zzca;
    @Nullable
    private final String zzcb;
    @Nullable
    private final String zzcc;
    private final String zzcd;

    public zzap(String str, int i, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, String str6, String str7) {
        this.zzby = Preconditions.checkNotEmpty(str);
        this.port = i;
        this.zzbz = str2;
        this.zzca = str3;
        this.zzcb = str4;
        this.zzcc = str5;
        this.zzad = str6;
        this.zzcd = str7;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzby, false);
        SafeParcelWriter.writeInt(parcel, 3, this.port);
        SafeParcelWriter.writeString(parcel, 4, this.zzbz, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzca, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzcb, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzad, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzcd, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzcb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
