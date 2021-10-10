package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zas;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zal();
    private final int zaa;
    private final ConnectionResult zab;
    private final zas zac;

    zam(int i, ConnectionResult connectionResult, zas zas) {
        this.zaa = i;
        this.zab = connectionResult;
        this.zac = zas;
    }

    public zam(int i) {
        this(new ConnectionResult(8, null), null);
    }

    private zam(ConnectionResult connectionResult, zas zas) {
        this(1, connectionResult, null);
    }

    public final ConnectionResult zaa() {
        return this.zab;
    }

    public final zas zab() {
        return this.zac;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
