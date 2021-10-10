package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbb();
    static final List<ClientIdentity> zza = Collections.emptyList();
    private LocationRequest zzb;
    private List<ClientIdentity> zzc;
    private String zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private long zzl;
    private boolean zzm = true;

    @Deprecated
    public static zzbc zza(LocationRequest locationRequest) {
        return zza(null, locationRequest);
    }

    public static zzbc zza(String str, LocationRequest locationRequest) {
        return new zzbc(locationRequest, zza, null, false, false, false, null, false, false, null, LongCompanionObject.MAX_VALUE);
    }

    zzbc(LocationRequest locationRequest, List<ClientIdentity> list, String str, boolean z, boolean z2, boolean z3, String str2, boolean z4, boolean z5, String str3, long j) {
        this.zzb = locationRequest;
        this.zzc = list;
        this.zzd = str;
        this.zze = z;
        this.zzf = z2;
        this.zzg = z3;
        this.zzh = str2;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = str3;
        this.zzl = j;
    }

    public final zzbc zza(long j) {
        if (this.zzb.getMaxWaitTime() <= this.zzb.getInterval()) {
            this.zzl = 10000;
            return this;
        }
        long interval = this.zzb.getInterval();
        long maxWaitTime = this.zzb.getMaxWaitTime();
        StringBuilder sb = new StringBuilder(120);
        sb.append("could not set max age when location batching is requested, interval=");
        sb.append(interval);
        sb.append("maxWaitTime=");
        sb.append(maxWaitTime);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzbc zza(String str) {
        this.zzk = str;
        return this;
    }

    public final zzbc zza(boolean z) {
        this.zzj = true;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzg);
        SafeParcelWriter.writeString(parcel, 10, this.zzh, false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzj);
        SafeParcelWriter.writeString(parcel, 13, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        if (this.zzd != null) {
            sb.append(" tag=");
            sb.append(this.zzd);
        }
        if (this.zzh != null) {
            sb.append(" moduleId=");
            sb.append(this.zzh);
        }
        if (this.zzk != null) {
            sb.append(" contextAttributionTag=");
            sb.append(this.zzk);
        }
        sb.append(" hideAppOps=");
        sb.append(this.zze);
        sb.append(" clients=");
        sb.append(this.zzc);
        sb.append(" forceCoarseLocation=");
        sb.append(this.zzf);
        if (this.zzg) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        if (this.zzi) {
            sb.append(" locationSettingsIgnored");
        }
        if (this.zzj) {
            sb.append(" inaccurateLocationsDelayed");
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbc)) {
            return false;
        }
        zzbc zzbc = (zzbc) obj;
        if (!Objects.equal(this.zzb, zzbc.zzb) || !Objects.equal(this.zzc, zzbc.zzc) || !Objects.equal(this.zzd, zzbc.zzd) || this.zze != zzbc.zze || this.zzf != zzbc.zzf || this.zzg != zzbc.zzg || !Objects.equal(this.zzh, zzbc.zzh) || this.zzi != zzbc.zzi || this.zzj != zzbc.zzj || !Objects.equal(this.zzk, zzbc.zzk)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }
}
