package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/model/KangarooHarvesterQuota;", "Landroid/os/Parcelable;", "quotaId", "", "zoneName", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuotaId", "()Ljava/lang/String;", "getZoneName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class KangarooHarvesterQuota implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String quotaId;
    private final String zoneName;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new KangarooHarvesterQuota(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new KangarooHarvesterQuota[i];
        }
    }

    public KangarooHarvesterQuota() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ KangarooHarvesterQuota copy$default(KangarooHarvesterQuota kangarooHarvesterQuota, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kangarooHarvesterQuota.quotaId;
        }
        if ((i & 2) != 0) {
            str2 = kangarooHarvesterQuota.zoneName;
        }
        return kangarooHarvesterQuota.copy(str, str2);
    }

    public final String component1() {
        return this.quotaId;
    }

    public final String component2() {
        return this.zoneName;
    }

    public final KangarooHarvesterQuota copy(@Json(name = "quotaId") String str, @Json(name = "zoneName") String str2) {
        Intrinsics.checkNotNullParameter(str, "quotaId");
        Intrinsics.checkNotNullParameter(str2, "zoneName");
        return new KangarooHarvesterQuota(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KangarooHarvesterQuota)) {
            return false;
        }
        KangarooHarvesterQuota kangarooHarvesterQuota = (KangarooHarvesterQuota) obj;
        return Intrinsics.areEqual(this.quotaId, kangarooHarvesterQuota.quotaId) && Intrinsics.areEqual(this.zoneName, kangarooHarvesterQuota.zoneName);
    }

    public int hashCode() {
        String str = this.quotaId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.zoneName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "KangarooHarvesterQuota(quotaId=" + this.quotaId + ", zoneName=" + this.zoneName + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.quotaId);
        parcel.writeString(this.zoneName);
    }

    public KangarooHarvesterQuota(@Json(name = "quotaId") String str, @Json(name = "zoneName") String str2) {
        Intrinsics.checkNotNullParameter(str, "quotaId");
        Intrinsics.checkNotNullParameter(str2, "zoneName");
        this.quotaId = str;
        this.zoneName = str2;
    }

    public final String getQuotaId() {
        return this.quotaId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KangarooHarvesterQuota(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getZoneName() {
        return this.zoneName;
    }
}
