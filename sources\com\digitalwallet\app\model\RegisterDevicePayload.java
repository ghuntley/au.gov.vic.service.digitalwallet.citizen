package com.digitalwallet.app.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/model/RegisterDevicePayload;", "", "devicetoken", "", "appid", "deviceid", "deviceInfo", "Lcom/digitalwallet/app/model/DeviceInfo;", "channeltype", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/digitalwallet/app/model/DeviceInfo;Ljava/lang/String;)V", "getAppid", "()Ljava/lang/String;", "getChanneltype", "getDeviceInfo", "()Lcom/digitalwallet/app/model/DeviceInfo;", "getDeviceid", "getDevicetoken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RegisterDevicePayload.kt */
public final class RegisterDevicePayload {
    private final String appid;
    private final String channeltype;
    private final DeviceInfo deviceInfo;
    private final String deviceid;
    private final String devicetoken;

    public static /* synthetic */ RegisterDevicePayload copy$default(RegisterDevicePayload registerDevicePayload, String str, String str2, String str3, DeviceInfo deviceInfo2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registerDevicePayload.devicetoken;
        }
        if ((i & 2) != 0) {
            str2 = registerDevicePayload.appid;
        }
        if ((i & 4) != 0) {
            str3 = registerDevicePayload.deviceid;
        }
        if ((i & 8) != 0) {
            deviceInfo2 = registerDevicePayload.deviceInfo;
        }
        if ((i & 16) != 0) {
            str4 = registerDevicePayload.channeltype;
        }
        return registerDevicePayload.copy(str, str2, str3, deviceInfo2, str4);
    }

    public final String component1() {
        return this.devicetoken;
    }

    public final String component2() {
        return this.appid;
    }

    public final String component3() {
        return this.deviceid;
    }

    public final DeviceInfo component4() {
        return this.deviceInfo;
    }

    public final String component5() {
        return this.channeltype;
    }

    public final RegisterDevicePayload copy(String str, String str2, String str3, DeviceInfo deviceInfo2, String str4) {
        Intrinsics.checkNotNullParameter(str, "devicetoken");
        Intrinsics.checkNotNullParameter(str2, "appid");
        Intrinsics.checkNotNullParameter(str3, "deviceid");
        Intrinsics.checkNotNullParameter(deviceInfo2, "deviceInfo");
        Intrinsics.checkNotNullParameter(str4, "channeltype");
        return new RegisterDevicePayload(str, str2, str3, deviceInfo2, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterDevicePayload)) {
            return false;
        }
        RegisterDevicePayload registerDevicePayload = (RegisterDevicePayload) obj;
        return Intrinsics.areEqual(this.devicetoken, registerDevicePayload.devicetoken) && Intrinsics.areEqual(this.appid, registerDevicePayload.appid) && Intrinsics.areEqual(this.deviceid, registerDevicePayload.deviceid) && Intrinsics.areEqual(this.deviceInfo, registerDevicePayload.deviceInfo) && Intrinsics.areEqual(this.channeltype, registerDevicePayload.channeltype);
    }

    public int hashCode() {
        String str = this.devicetoken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.appid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.deviceid;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        DeviceInfo deviceInfo2 = this.deviceInfo;
        int hashCode4 = (hashCode3 + (deviceInfo2 != null ? deviceInfo2.hashCode() : 0)) * 31;
        String str4 = this.channeltype;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "RegisterDevicePayload(devicetoken=" + this.devicetoken + ", appid=" + this.appid + ", deviceid=" + this.deviceid + ", deviceInfo=" + this.deviceInfo + ", channeltype=" + this.channeltype + ")";
    }

    public RegisterDevicePayload(String str, String str2, String str3, DeviceInfo deviceInfo2, String str4) {
        Intrinsics.checkNotNullParameter(str, "devicetoken");
        Intrinsics.checkNotNullParameter(str2, "appid");
        Intrinsics.checkNotNullParameter(str3, "deviceid");
        Intrinsics.checkNotNullParameter(deviceInfo2, "deviceInfo");
        Intrinsics.checkNotNullParameter(str4, "channeltype");
        this.devicetoken = str;
        this.appid = str2;
        this.deviceid = str3;
        this.deviceInfo = deviceInfo2;
        this.channeltype = str4;
    }

    public final String getDevicetoken() {
        return this.devicetoken;
    }

    public final String getAppid() {
        return this.appid;
    }

    public final String getDeviceid() {
        return this.deviceid;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final String getChanneltype() {
        return this.channeltype;
    }
}
