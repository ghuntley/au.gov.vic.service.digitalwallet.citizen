package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzak;
import com.google.android.gms.location.zzan;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzo();
    private int zza;
    private zzj zzb;
    private zzak zzc;
    private zzai zzd;

    zzl(int i, zzj zzj, IBinder iBinder, IBinder iBinder2) {
        zzak zzak;
        this.zza = i;
        this.zzb = zzj;
        zzai zzai = null;
        if (iBinder == null) {
            zzak = null;
        } else {
            zzak = zzan.zza(iBinder);
        }
        this.zzc = zzak;
        if (!(iBinder2 == null || iBinder2 == null)) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzai = queryLocalInterface instanceof zzai ? (zzai) queryLocalInterface : new zzak(iBinder2);
        }
        this.zzd = zzai;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzak zzak = this.zzc;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 3, zzak == null ? null : zzak.asBinder(), false);
        zzai zzai = this.zzd;
        if (zzai != null) {
            iBinder = zzai.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
