package com.digitalwallet.app.model.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/model/login/DevicePrintFonts;", "Landroid/os/Parcelable;", "installedFonts", "", "(Ljava/lang/String;)V", "getInstalledFonts", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountPayloads.kt */
public final class DevicePrintFonts implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String installedFonts;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DevicePrintFonts(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DevicePrintFonts[i];
        }
    }

    public static /* synthetic */ DevicePrintFonts copy$default(DevicePrintFonts devicePrintFonts, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = devicePrintFonts.installedFonts;
        }
        return devicePrintFonts.copy(str);
    }

    public final String component1() {
        return this.installedFonts;
    }

    public final DevicePrintFonts copy(String str) {
        Intrinsics.checkNotNullParameter(str, "installedFonts");
        return new DevicePrintFonts(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DevicePrintFonts) && Intrinsics.areEqual(this.installedFonts, ((DevicePrintFonts) obj).installedFonts);
        }
        return true;
    }

    public int hashCode() {
        String str = this.installedFonts;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "DevicePrintFonts(installedFonts=" + this.installedFonts + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.installedFonts);
    }

    public DevicePrintFonts(String str) {
        Intrinsics.checkNotNullParameter(str, "installedFonts");
        this.installedFonts = str;
    }

    public final String getInstalledFonts() {
        return this.installedFonts;
    }
}
