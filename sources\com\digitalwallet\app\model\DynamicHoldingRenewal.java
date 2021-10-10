package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/app/model/DynamicHoldingRenewal;", "Landroid/os/Parcelable;", "period", "", ImagesContract.URL, "", "(ILjava/lang/String;)V", "getPeriod", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class DynamicHoldingRenewal implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final int period;
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DynamicHoldingRenewal(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DynamicHoldingRenewal[i];
        }
    }

    public static /* synthetic */ DynamicHoldingRenewal copy$default(DynamicHoldingRenewal dynamicHoldingRenewal, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dynamicHoldingRenewal.period;
        }
        if ((i2 & 2) != 0) {
            str = dynamicHoldingRenewal.url;
        }
        return dynamicHoldingRenewal.copy(i, str);
    }

    public final int component1() {
        return this.period;
    }

    public final String component2() {
        return this.url;
    }

    public final DynamicHoldingRenewal copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
        return new DynamicHoldingRenewal(i, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicHoldingRenewal)) {
            return false;
        }
        DynamicHoldingRenewal dynamicHoldingRenewal = (DynamicHoldingRenewal) obj;
        return this.period == dynamicHoldingRenewal.period && Intrinsics.areEqual(this.url, dynamicHoldingRenewal.url);
    }

    public int hashCode() {
        int i = this.period * 31;
        String str = this.url;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DynamicHoldingRenewal(period=" + this.period + ", url=" + this.url + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.period);
        parcel.writeString(this.url);
    }

    public DynamicHoldingRenewal(int i, String str) {
        Intrinsics.checkNotNullParameter(str, ImagesContract.URL);
        this.period = i;
        this.url = str;
    }

    public final int getPeriod() {
        return this.period;
    }

    public final String getUrl() {
        return this.url;
    }
}
