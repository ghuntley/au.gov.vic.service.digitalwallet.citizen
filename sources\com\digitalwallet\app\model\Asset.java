package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\""}, d2 = {"Lcom/digitalwallet/app/model/Asset;", "Landroid/os/Parcelable;", "type", "", "hash", ImagesContract.URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHash", "()Ljava/lang/String;", "interpretedType", "Lcom/digitalwallet/app/model/AssetType;", "getInterpretedType$annotations", "()V", "getInterpretedType", "()Lcom/digitalwallet/app/model/AssetType;", "getType", "getUrl", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Asset.kt */
public final class Asset implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String hash;
    private final String type;
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Asset(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Asset[i];
        }
    }

    public static /* synthetic */ Asset copy$default(Asset asset, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = asset.type;
        }
        if ((i & 2) != 0) {
            str2 = asset.hash;
        }
        if ((i & 4) != 0) {
            str3 = asset.url;
        }
        return asset.copy(str, str2, str3);
    }

    public static /* synthetic */ void getInterpretedType$annotations() {
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.hash;
    }

    public final String component3() {
        return this.url;
    }

    public final Asset copy(@Json(name = "type") String str, @Json(name = "hash") String str2, @Json(name = "url") String str3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intrinsics.checkNotNullParameter(str3, ImagesContract.URL);
        return new Asset(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return Intrinsics.areEqual(this.type, asset.type) && Intrinsics.areEqual(this.hash, asset.hash) && Intrinsics.areEqual(this.url, asset.url);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hash;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.hash);
        parcel.writeString(this.url);
    }

    public Asset(@Json(name = "type") String str, @Json(name = "hash") String str2, @Json(name = "url") String str3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intrinsics.checkNotNullParameter(str3, ImagesContract.URL);
        this.type = str;
        this.hash = str2;
        this.url = str3;
    }

    public final String getType() {
        return this.type;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getUrl() {
        return this.url;
    }

    public final AssetType getInterpretedType() {
        AssetType[] values = AssetType.values();
        for (AssetType assetType : values) {
            if (Intrinsics.areEqual(assetType.getJsonName(), this.type)) {
                return assetType;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public String toString() {
        return AssetKt.urlSafeEscaping(this.hash);
    }
}
