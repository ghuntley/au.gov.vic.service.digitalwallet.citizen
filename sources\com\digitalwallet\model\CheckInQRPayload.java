package com.digitalwallet.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/model/CheckInQRPayload;", "", "type", "", "encryptedId", "", FirebaseAnalytics.Param.LOCATION, "(ILjava/lang/String;Ljava/lang/String;)V", "getEncryptedId", "()Ljava/lang/String;", "getLocation", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInQRPayload {
    private final String encryptedId;
    private final String location;
    private final int type;

    public static /* synthetic */ CheckInQRPayload copy$default(CheckInQRPayload checkInQRPayload, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = checkInQRPayload.type;
        }
        if ((i2 & 2) != 0) {
            str = checkInQRPayload.encryptedId;
        }
        if ((i2 & 4) != 0) {
            str2 = checkInQRPayload.location;
        }
        return checkInQRPayload.copy(i, str, str2);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.encryptedId;
    }

    public final String component3() {
        return this.location;
    }

    public final CheckInQRPayload copy(@Json(name = "t") int i, @Json(name = "lid") String str, @Json(name = "ln") String str2) {
        Intrinsics.checkNotNullParameter(str, "encryptedId");
        Intrinsics.checkNotNullParameter(str2, FirebaseAnalytics.Param.LOCATION);
        return new CheckInQRPayload(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInQRPayload)) {
            return false;
        }
        CheckInQRPayload checkInQRPayload = (CheckInQRPayload) obj;
        return this.type == checkInQRPayload.type && Intrinsics.areEqual(this.encryptedId, checkInQRPayload.encryptedId) && Intrinsics.areEqual(this.location, checkInQRPayload.location);
    }

    public int hashCode() {
        int i = this.type * 31;
        String str = this.encryptedId;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.location;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "CheckInQRPayload(type=" + this.type + ", encryptedId=" + this.encryptedId + ", location=" + this.location + ")";
    }

    public CheckInQRPayload(@Json(name = "t") int i, @Json(name = "lid") String str, @Json(name = "ln") String str2) {
        Intrinsics.checkNotNullParameter(str, "encryptedId");
        Intrinsics.checkNotNullParameter(str2, FirebaseAnalytics.Param.LOCATION);
        this.type = i;
        this.encryptedId = str;
        this.location = str2;
    }

    public final int getType() {
        return this.type;
    }

    public final String getEncryptedId() {
        return this.encryptedId;
    }

    public final String getLocation() {
        return this.location;
    }
}
