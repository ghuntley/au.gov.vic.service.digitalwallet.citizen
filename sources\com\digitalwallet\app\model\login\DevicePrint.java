package com.digitalwallet.app.model.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\t\u00108\u001a\u000209HÖ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u000209HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\u0019\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u000209HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006E"}, d2 = {"Lcom/digitalwallet/app/model/login/DevicePrint;", "Landroid/os/Parcelable;", "deviceId", "", "screen", "Lcom/digitalwallet/app/model/login/DevicePrintScreen;", "timezone", "Lcom/digitalwallet/app/model/login/DevicePrintTimezone;", "plugins", "Lcom/digitalwallet/app/model/login/DevicePrintPlugins;", "fonts", "Lcom/digitalwallet/app/model/login/DevicePrintFonts;", "userAgent", "appName", "appCodeName", "appVersion", "platform", "product", "productSub", "vendor", "language", "(Ljava/lang/String;Lcom/digitalwallet/app/model/login/DevicePrintScreen;Lcom/digitalwallet/app/model/login/DevicePrintTimezone;Lcom/digitalwallet/app/model/login/DevicePrintPlugins;Lcom/digitalwallet/app/model/login/DevicePrintFonts;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppCodeName", "()Ljava/lang/String;", "getAppName", "getAppVersion", "getDeviceId", "getFonts", "()Lcom/digitalwallet/app/model/login/DevicePrintFonts;", "getLanguage", "getPlatform", "getPlugins", "()Lcom/digitalwallet/app/model/login/DevicePrintPlugins;", "getProduct", "getProductSub", "getScreen", "()Lcom/digitalwallet/app/model/login/DevicePrintScreen;", "getTimezone", "()Lcom/digitalwallet/app/model/login/DevicePrintTimezone;", "getUserAgent", "getVendor", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountPayloads.kt */
public final class DevicePrint implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String appCodeName;
    private final String appName;
    private final String appVersion;
    private final String deviceId;
    private final DevicePrintFonts fonts;
    private final String language;
    private final String platform;
    private final DevicePrintPlugins plugins;
    private final String product;
    private final String productSub;
    private final DevicePrintScreen screen;
    private final DevicePrintTimezone timezone;
    private final String userAgent;
    private final String vendor;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DevicePrint(parcel.readString(), (DevicePrintScreen) DevicePrintScreen.CREATOR.createFromParcel(parcel), (DevicePrintTimezone) DevicePrintTimezone.CREATOR.createFromParcel(parcel), (DevicePrintPlugins) DevicePrintPlugins.CREATOR.createFromParcel(parcel), (DevicePrintFonts) DevicePrintFonts.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DevicePrint[i];
        }
    }

    public static /* synthetic */ DevicePrint copy$default(DevicePrint devicePrint, String str, DevicePrintScreen devicePrintScreen, DevicePrintTimezone devicePrintTimezone, DevicePrintPlugins devicePrintPlugins, DevicePrintFonts devicePrintFonts, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        return devicePrint.copy((i & 1) != 0 ? devicePrint.deviceId : str, (i & 2) != 0 ? devicePrint.screen : devicePrintScreen, (i & 4) != 0 ? devicePrint.timezone : devicePrintTimezone, (i & 8) != 0 ? devicePrint.plugins : devicePrintPlugins, (i & 16) != 0 ? devicePrint.fonts : devicePrintFonts, (i & 32) != 0 ? devicePrint.userAgent : str2, (i & 64) != 0 ? devicePrint.appName : str3, (i & 128) != 0 ? devicePrint.appCodeName : str4, (i & 256) != 0 ? devicePrint.appVersion : str5, (i & 512) != 0 ? devicePrint.platform : str6, (i & 1024) != 0 ? devicePrint.product : str7, (i & 2048) != 0 ? devicePrint.productSub : str8, (i & 4096) != 0 ? devicePrint.vendor : str9, (i & 8192) != 0 ? devicePrint.language : str10);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component10() {
        return this.platform;
    }

    public final String component11() {
        return this.product;
    }

    public final String component12() {
        return this.productSub;
    }

    public final String component13() {
        return this.vendor;
    }

    public final String component14() {
        return this.language;
    }

    public final DevicePrintScreen component2() {
        return this.screen;
    }

    public final DevicePrintTimezone component3() {
        return this.timezone;
    }

    public final DevicePrintPlugins component4() {
        return this.plugins;
    }

    public final DevicePrintFonts component5() {
        return this.fonts;
    }

    public final String component6() {
        return this.userAgent;
    }

    public final String component7() {
        return this.appName;
    }

    public final String component8() {
        return this.appCodeName;
    }

    public final String component9() {
        return this.appVersion;
    }

    public final DevicePrint copy(String str, DevicePrintScreen devicePrintScreen, DevicePrintTimezone devicePrintTimezone, DevicePrintPlugins devicePrintPlugins, DevicePrintFonts devicePrintFonts, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(devicePrintScreen, "screen");
        Intrinsics.checkNotNullParameter(devicePrintTimezone, "timezone");
        Intrinsics.checkNotNullParameter(devicePrintPlugins, "plugins");
        Intrinsics.checkNotNullParameter(devicePrintFonts, "fonts");
        Intrinsics.checkNotNullParameter(str2, "userAgent");
        Intrinsics.checkNotNullParameter(str3, "appName");
        Intrinsics.checkNotNullParameter(str4, "appCodeName");
        Intrinsics.checkNotNullParameter(str5, "appVersion");
        Intrinsics.checkNotNullParameter(str6, "platform");
        Intrinsics.checkNotNullParameter(str7, "product");
        Intrinsics.checkNotNullParameter(str8, "productSub");
        Intrinsics.checkNotNullParameter(str9, "vendor");
        Intrinsics.checkNotNullParameter(str10, "language");
        return new DevicePrint(str, devicePrintScreen, devicePrintTimezone, devicePrintPlugins, devicePrintFonts, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DevicePrint)) {
            return false;
        }
        DevicePrint devicePrint = (DevicePrint) obj;
        return Intrinsics.areEqual(this.deviceId, devicePrint.deviceId) && Intrinsics.areEqual(this.screen, devicePrint.screen) && Intrinsics.areEqual(this.timezone, devicePrint.timezone) && Intrinsics.areEqual(this.plugins, devicePrint.plugins) && Intrinsics.areEqual(this.fonts, devicePrint.fonts) && Intrinsics.areEqual(this.userAgent, devicePrint.userAgent) && Intrinsics.areEqual(this.appName, devicePrint.appName) && Intrinsics.areEqual(this.appCodeName, devicePrint.appCodeName) && Intrinsics.areEqual(this.appVersion, devicePrint.appVersion) && Intrinsics.areEqual(this.platform, devicePrint.platform) && Intrinsics.areEqual(this.product, devicePrint.product) && Intrinsics.areEqual(this.productSub, devicePrint.productSub) && Intrinsics.areEqual(this.vendor, devicePrint.vendor) && Intrinsics.areEqual(this.language, devicePrint.language);
    }

    public int hashCode() {
        String str = this.deviceId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DevicePrintScreen devicePrintScreen = this.screen;
        int hashCode2 = (hashCode + (devicePrintScreen != null ? devicePrintScreen.hashCode() : 0)) * 31;
        DevicePrintTimezone devicePrintTimezone = this.timezone;
        int hashCode3 = (hashCode2 + (devicePrintTimezone != null ? devicePrintTimezone.hashCode() : 0)) * 31;
        DevicePrintPlugins devicePrintPlugins = this.plugins;
        int hashCode4 = (hashCode3 + (devicePrintPlugins != null ? devicePrintPlugins.hashCode() : 0)) * 31;
        DevicePrintFonts devicePrintFonts = this.fonts;
        int hashCode5 = (hashCode4 + (devicePrintFonts != null ? devicePrintFonts.hashCode() : 0)) * 31;
        String str2 = this.userAgent;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.appName;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.appCodeName;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.appVersion;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.platform;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.product;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.productSub;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.vendor;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.language;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return hashCode13 + i;
    }

    public String toString() {
        return "DevicePrint(deviceId=" + this.deviceId + ", screen=" + this.screen + ", timezone=" + this.timezone + ", plugins=" + this.plugins + ", fonts=" + this.fonts + ", userAgent=" + this.userAgent + ", appName=" + this.appName + ", appCodeName=" + this.appCodeName + ", appVersion=" + this.appVersion + ", platform=" + this.platform + ", product=" + this.product + ", productSub=" + this.productSub + ", vendor=" + this.vendor + ", language=" + this.language + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.deviceId);
        this.screen.writeToParcel(parcel, 0);
        this.timezone.writeToParcel(parcel, 0);
        this.plugins.writeToParcel(parcel, 0);
        this.fonts.writeToParcel(parcel, 0);
        parcel.writeString(this.userAgent);
        parcel.writeString(this.appName);
        parcel.writeString(this.appCodeName);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.platform);
        parcel.writeString(this.product);
        parcel.writeString(this.productSub);
        parcel.writeString(this.vendor);
        parcel.writeString(this.language);
    }

    public DevicePrint(String str, DevicePrintScreen devicePrintScreen, DevicePrintTimezone devicePrintTimezone, DevicePrintPlugins devicePrintPlugins, DevicePrintFonts devicePrintFonts, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str, "deviceId");
        Intrinsics.checkNotNullParameter(devicePrintScreen, "screen");
        Intrinsics.checkNotNullParameter(devicePrintTimezone, "timezone");
        Intrinsics.checkNotNullParameter(devicePrintPlugins, "plugins");
        Intrinsics.checkNotNullParameter(devicePrintFonts, "fonts");
        Intrinsics.checkNotNullParameter(str2, "userAgent");
        Intrinsics.checkNotNullParameter(str3, "appName");
        Intrinsics.checkNotNullParameter(str4, "appCodeName");
        Intrinsics.checkNotNullParameter(str5, "appVersion");
        Intrinsics.checkNotNullParameter(str6, "platform");
        Intrinsics.checkNotNullParameter(str7, "product");
        Intrinsics.checkNotNullParameter(str8, "productSub");
        Intrinsics.checkNotNullParameter(str9, "vendor");
        Intrinsics.checkNotNullParameter(str10, "language");
        this.deviceId = str;
        this.screen = devicePrintScreen;
        this.timezone = devicePrintTimezone;
        this.plugins = devicePrintPlugins;
        this.fonts = devicePrintFonts;
        this.userAgent = str2;
        this.appName = str3;
        this.appCodeName = str4;
        this.appVersion = str5;
        this.platform = str6;
        this.product = str7;
        this.productSub = str8;
        this.vendor = str9;
        this.language = str10;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final DevicePrintScreen getScreen() {
        return this.screen;
    }

    public final DevicePrintTimezone getTimezone() {
        return this.timezone;
    }

    public final DevicePrintPlugins getPlugins() {
        return this.plugins;
    }

    public final DevicePrintFonts getFonts() {
        return this.fonts;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppCodeName() {
        return this.appCodeName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getProduct() {
        return this.product;
    }

    public final String getProductSub() {
        return this.productSub;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final String getLanguage() {
        return this.language;
    }
}
