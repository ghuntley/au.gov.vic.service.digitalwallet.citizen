package com.digitalwallet.app.model.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/digitalwallet/app/model/login/DevicePrintScreen;", "Landroid/os/Parcelable;", "screenWidth", "", "screenHeight", "screenColourDepth", "(III)V", "getScreenColourDepth", "()I", "getScreenHeight", "getScreenWidth", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountPayloads.kt */
public final class DevicePrintScreen implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final int screenColourDepth;
    private final int screenHeight;
    private final int screenWidth;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DevicePrintScreen(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DevicePrintScreen[i];
        }
    }

    public static /* synthetic */ DevicePrintScreen copy$default(DevicePrintScreen devicePrintScreen, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = devicePrintScreen.screenWidth;
        }
        if ((i4 & 2) != 0) {
            i2 = devicePrintScreen.screenHeight;
        }
        if ((i4 & 4) != 0) {
            i3 = devicePrintScreen.screenColourDepth;
        }
        return devicePrintScreen.copy(i, i2, i3);
    }

    public final int component1() {
        return this.screenWidth;
    }

    public final int component2() {
        return this.screenHeight;
    }

    public final int component3() {
        return this.screenColourDepth;
    }

    public final DevicePrintScreen copy(int i, int i2, int i3) {
        return new DevicePrintScreen(i, i2, i3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DevicePrintScreen)) {
            return false;
        }
        DevicePrintScreen devicePrintScreen = (DevicePrintScreen) obj;
        return this.screenWidth == devicePrintScreen.screenWidth && this.screenHeight == devicePrintScreen.screenHeight && this.screenColourDepth == devicePrintScreen.screenColourDepth;
    }

    public int hashCode() {
        return (((this.screenWidth * 31) + this.screenHeight) * 31) + this.screenColourDepth;
    }

    public String toString() {
        return "DevicePrintScreen(screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", screenColourDepth=" + this.screenColourDepth + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.screenWidth);
        parcel.writeInt(this.screenHeight);
        parcel.writeInt(this.screenColourDepth);
    }

    public DevicePrintScreen(int i, int i2, int i3) {
        this.screenWidth = i;
        this.screenHeight = i2;
        this.screenColourDepth = i3;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getScreenColourDepth() {
        return this.screenColourDepth;
    }
}
