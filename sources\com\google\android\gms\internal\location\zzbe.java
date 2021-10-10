package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzao;
import com.google.android.gms.location.zzap;
import com.google.android.gms.location.zzaq;
import com.google.android.gms.location.zzat;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbd();
    private int zza;
    private zzbc zzb;
    private zzaq zzc;
    private PendingIntent zzd;
    private zzap zze;
    private zzai zzf;

    public static zzbe zza(zzaq zzaq, zzai zzai) {
        return new zzbe(2, null, zzaq.asBinder(), null, null, zzai != null ? zzai.asBinder() : null);
    }

    public static zzbe zza(zzbc zzbc, PendingIntent pendingIntent, zzai zzai) {
        return new zzbe(1, zzbc, null, pendingIntent, null, zzai != null ? zzai.asBinder() : null);
    }

    public static zzbe zza(zzap zzap, zzai zzai) {
        return new zzbe(2, null, null, null, zzap.asBinder(), zzai != null ? zzai.asBinder() : null);
    }

    zzbe(int i, zzbc zzbc, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        zzaq zzaq;
        zzap zzap;
        this.zza = i;
        this.zzb = zzbc;
        zzai zzai = null;
        if (iBinder == null) {
            zzaq = null;
        } else {
            zzaq = zzat.zza(iBinder);
        }
        this.zzc = zzaq;
        this.zzd = pendingIntent;
        if (iBinder2 == null) {
            zzap = null;
        } else {
            zzap = zzao.zza(iBinder2);
        }
        this.zze = zzap;
        if (!(iBinder3 == null || iBinder3 == null)) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzai = queryLocalInterface instanceof zzai ? (zzai) queryLocalInterface : new zzak(iBinder3);
        }
        this.zzf = zzai;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzaq zzaq = this.zzc;
        IBinder iBinder = null;
        SafeParcelWriter.writeIBinder(parcel, 3, zzaq == null ? null : zzaq.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        zzap zzap = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 5, zzap == null ? null : zzap.asBinder(), false);
        zzai zzai = this.zzf;
        if (zzai != null) {
            iBinder = zzai.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
