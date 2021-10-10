package com.google.android.gms.internal.instantapps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;

public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzax();
    private String packageName;
    @Nullable
    private BitmapTeleporter zzcn;
    private String zzco;
    private String zzcp;
    private String zzcq;
    private ArrayList<String> zzcr;
    @Nullable
    private zzm zzcs;

    public zzay(@Nullable BitmapTeleporter bitmapTeleporter, String str, String str2, String str3, String str4, Collection<String> collection, @Nullable zzm zzm) {
        this.zzcn = bitmapTeleporter;
        this.zzco = str;
        this.zzcp = str2;
        this.zzcq = str3;
        this.packageName = str4;
        ArrayList<String> arrayList = new ArrayList<>(collection == null ? 0 : collection.size());
        this.zzcr = arrayList;
        if (collection != null) {
            arrayList.addAll(collection);
        }
        this.zzcs = zzm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzcn, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzco, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzcp, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzcq, false);
        SafeParcelWriter.writeString(parcel, 6, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 7, Collections.unmodifiableList(this.zzcr), false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzcs, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
