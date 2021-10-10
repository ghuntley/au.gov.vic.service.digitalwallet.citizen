package com.digitalwallet.app.model.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\nHÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006)"}, d2 = {"Lcom/digitalwallet/app/model/login/SVItem;", "Landroid/os/Parcelable;", "id", "", "image", "imageUrl", ImagesContract.URL, "openExternally", "", "order", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "cacheNameForImageUrl", "getCacheNameForImageUrl", "()Ljava/lang/String;", "getId", "getImage", "getImageUrl", "getOpenExternally", "()Z", "getOrder", "()I", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVServices.kt */
public final class SVItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String cacheNameForImageUrl;
    private final String id;
    private final String image;
    private final String imageUrl;
    private final boolean openExternally;
    private final int order;
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SVItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new SVItem[i];
        }
    }

    public static /* synthetic */ SVItem copy$default(SVItem sVItem, String str, String str2, String str3, String str4, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sVItem.id;
        }
        if ((i2 & 2) != 0) {
            str2 = sVItem.image;
        }
        if ((i2 & 4) != 0) {
            str3 = sVItem.imageUrl;
        }
        if ((i2 & 8) != 0) {
            str4 = sVItem.url;
        }
        if ((i2 & 16) != 0) {
            z = sVItem.openExternally;
        }
        if ((i2 & 32) != 0) {
            i = sVItem.order;
        }
        return sVItem.copy(str, str2, str3, str4, z, i);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.image;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final String component4() {
        return this.url;
    }

    public final boolean component5() {
        return this.openExternally;
    }

    public final int component6() {
        return this.order;
    }

    public final SVItem copy(String str, String str2, String str3, String str4, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str4, ImagesContract.URL);
        return new SVItem(str, str2, str3, str4, z, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SVItem)) {
            return false;
        }
        SVItem sVItem = (SVItem) obj;
        return Intrinsics.areEqual(this.id, sVItem.id) && Intrinsics.areEqual(this.image, sVItem.image) && Intrinsics.areEqual(this.imageUrl, sVItem.imageUrl) && Intrinsics.areEqual(this.url, sVItem.url) && this.openExternally == sVItem.openExternally && this.order == sVItem.order;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.image;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.imageUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.url;
        if (str4 != null) {
            i = str4.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.openExternally;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return ((i2 + i3) * 31) + this.order;
    }

    public String toString() {
        return "SVItem(id=" + this.id + ", image=" + this.image + ", imageUrl=" + this.imageUrl + ", url=" + this.url + ", openExternally=" + this.openExternally + ", order=" + this.order + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.image);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.url);
        parcel.writeInt(this.openExternally ? 1 : 0);
        parcel.writeInt(this.order);
    }

    public SVItem(String str, String str2, String str3, String str4, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str4, ImagesContract.URL);
        this.id = str;
        this.image = str2;
        this.imageUrl = str3;
        this.url = str4;
        this.openExternally = z;
        this.order = i;
        this.cacheNameForImageUrl = str3 != null ? String.valueOf(str3.hashCode()) : null;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getOpenExternally() {
        return this.openExternally;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getCacheNameForImageUrl() {
        return this.cacheNameForImageUrl;
    }
}
