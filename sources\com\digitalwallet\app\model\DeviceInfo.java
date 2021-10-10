package com.digitalwallet.app.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/digitalwallet/app/model/DeviceInfo;", "", "AppVersion", "", "Locale", "Make", "Model", "ModelVersion", "Platform", "PlatformVersion", "Timezone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getLocale", "getMake", "getModel", "getModelVersion", "getPlatform", "getPlatformVersion", "getTimezone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RegisterDevicePayload.kt */
public final class DeviceInfo {
    private final String AppVersion;
    private final String Locale;
    private final String Make;
    private final String Model;
    private final String ModelVersion;
    private final String Platform;
    private final String PlatformVersion;
    private final String Timezone;

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo deviceInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        return deviceInfo.copy((i & 1) != 0 ? deviceInfo.AppVersion : str, (i & 2) != 0 ? deviceInfo.Locale : str2, (i & 4) != 0 ? deviceInfo.Make : str3, (i & 8) != 0 ? deviceInfo.Model : str4, (i & 16) != 0 ? deviceInfo.ModelVersion : str5, (i & 32) != 0 ? deviceInfo.Platform : str6, (i & 64) != 0 ? deviceInfo.PlatformVersion : str7, (i & 128) != 0 ? deviceInfo.Timezone : str8);
    }

    public final String component1() {
        return this.AppVersion;
    }

    public final String component2() {
        return this.Locale;
    }

    public final String component3() {
        return this.Make;
    }

    public final String component4() {
        return this.Model;
    }

    public final String component5() {
        return this.ModelVersion;
    }

    public final String component6() {
        return this.Platform;
    }

    public final String component7() {
        return this.PlatformVersion;
    }

    public final String component8() {
        return this.Timezone;
    }

    public final DeviceInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "AppVersion");
        Intrinsics.checkNotNullParameter(str2, "Locale");
        Intrinsics.checkNotNullParameter(str3, "Make");
        Intrinsics.checkNotNullParameter(str4, "Model");
        Intrinsics.checkNotNullParameter(str5, "ModelVersion");
        Intrinsics.checkNotNullParameter(str6, "Platform");
        Intrinsics.checkNotNullParameter(str7, "PlatformVersion");
        Intrinsics.checkNotNullParameter(str8, "Timezone");
        return new DeviceInfo(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.areEqual(this.AppVersion, deviceInfo.AppVersion) && Intrinsics.areEqual(this.Locale, deviceInfo.Locale) && Intrinsics.areEqual(this.Make, deviceInfo.Make) && Intrinsics.areEqual(this.Model, deviceInfo.Model) && Intrinsics.areEqual(this.ModelVersion, deviceInfo.ModelVersion) && Intrinsics.areEqual(this.Platform, deviceInfo.Platform) && Intrinsics.areEqual(this.PlatformVersion, deviceInfo.PlatformVersion) && Intrinsics.areEqual(this.Timezone, deviceInfo.Timezone);
    }

    public int hashCode() {
        String str = this.AppVersion;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.Locale;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Make;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Model;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.ModelVersion;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.Platform;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.PlatformVersion;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.Timezone;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "DeviceInfo(AppVersion=" + this.AppVersion + ", Locale=" + this.Locale + ", Make=" + this.Make + ", Model=" + this.Model + ", ModelVersion=" + this.ModelVersion + ", Platform=" + this.Platform + ", PlatformVersion=" + this.PlatformVersion + ", Timezone=" + this.Timezone + ")";
    }

    public DeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "AppVersion");
        Intrinsics.checkNotNullParameter(str2, "Locale");
        Intrinsics.checkNotNullParameter(str3, "Make");
        Intrinsics.checkNotNullParameter(str4, "Model");
        Intrinsics.checkNotNullParameter(str5, "ModelVersion");
        Intrinsics.checkNotNullParameter(str6, "Platform");
        Intrinsics.checkNotNullParameter(str7, "PlatformVersion");
        Intrinsics.checkNotNullParameter(str8, "Timezone");
        this.AppVersion = str;
        this.Locale = str2;
        this.Make = str3;
        this.Model = str4;
        this.ModelVersion = str5;
        this.Platform = str6;
        this.PlatformVersion = str7;
        this.Timezone = str8;
    }

    public final String getAppVersion() {
        return this.AppVersion;
    }

    public final String getLocale() {
        return this.Locale;
    }

    public final String getMake() {
        return this.Make;
    }

    public final String getModel() {
        return this.Model;
    }

    public final String getModelVersion() {
        return this.ModelVersion;
    }

    public final String getPlatform() {
        return this.Platform;
    }

    public final String getPlatformVersion() {
        return this.PlatformVersion;
    }

    public final String getTimezone() {
        return this.Timezone;
    }
}
