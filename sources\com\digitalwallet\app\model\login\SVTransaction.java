package com.digitalwallet.app.model.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Lcom/digitalwallet/app/model/login/SVTransaction;", "Landroid/os/Parcelable;", "id", "", MessageBundle.TITLE_ENTRY, ImagesContract.URL, "openExternally", "", "order", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getId", "()Ljava/lang/String;", "getOpenExternally", "()Z", "getOrder", "()I", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVServices.kt */
public final class SVTransaction implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String id;
    private final boolean openExternally;
    private final int order;
    private final String title;
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SVTransaction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new SVTransaction[i];
        }
    }

    public static /* synthetic */ SVTransaction copy$default(SVTransaction sVTransaction, String str, String str2, String str3, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sVTransaction.id;
        }
        if ((i2 & 2) != 0) {
            str2 = sVTransaction.title;
        }
        if ((i2 & 4) != 0) {
            str3 = sVTransaction.url;
        }
        if ((i2 & 8) != 0) {
            z = sVTransaction.openExternally;
        }
        if ((i2 & 16) != 0) {
            i = sVTransaction.order;
        }
        return sVTransaction.copy(str, str2, str3, z, i);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.url;
    }

    public final boolean component4() {
        return this.openExternally;
    }

    public final int component5() {
        return this.order;
    }

    public final SVTransaction copy(String str, String str2, String str3, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str3, ImagesContract.URL);
        return new SVTransaction(str, str2, str3, z, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SVTransaction)) {
            return false;
        }
        SVTransaction sVTransaction = (SVTransaction) obj;
        return Intrinsics.areEqual(this.id, sVTransaction.id) && Intrinsics.areEqual(this.title, sVTransaction.title) && Intrinsics.areEqual(this.url, sVTransaction.url) && this.openExternally == sVTransaction.openExternally && this.order == sVTransaction.order;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
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
        return "SVTransaction(id=" + this.id + ", title=" + this.title + ", url=" + this.url + ", openExternally=" + this.openExternally + ", order=" + this.order + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeInt(this.openExternally ? 1 : 0);
        parcel.writeInt(this.order);
    }

    public SVTransaction(String str, String str2, String str3, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str3, ImagesContract.URL);
        this.id = str;
        this.title = str2;
        this.url = str3;
        this.openExternally = z;
        this.order = i;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getOpenExternally() {
        return this.openExternally;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }
}
