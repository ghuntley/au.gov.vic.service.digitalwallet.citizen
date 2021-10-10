package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzar();
    public final zzab zza;
    public final String zzb;
    public final String zzc;
    private final zzal[] zzd;
    private final zzab zze;
    private final float zzf;
    private final boolean zzg;

    public zzao(zzal[] zzalArr, zzab zzab, zzab zzab2, String str, float f, String str2, boolean z) {
        this.zzd = zzalArr;
        this.zza = zzab;
        this.zze = zzab2;
        this.zzb = str;
        this.zzf = f;
        this.zzc = str2;
        this.zzg = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zze, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzb, false);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzf);
        SafeParcelWriter.writeString(parcel, 7, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
