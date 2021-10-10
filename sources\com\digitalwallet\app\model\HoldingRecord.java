package com.digitalwallet.app.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/model/HoldingRecord;", "", "link", "", ResponseTypeValues.TOKEN, "(Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingRecord {
    private final String link;
    private final String token;

    public static /* synthetic */ HoldingRecord copy$default(HoldingRecord holdingRecord, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = holdingRecord.link;
        }
        if ((i & 2) != 0) {
            str2 = holdingRecord.token;
        }
        return holdingRecord.copy(str, str2);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.token;
    }

    public final HoldingRecord copy(@Json(name = "link") String str, @Json(name = "token") String str2) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(str2, ResponseTypeValues.TOKEN);
        return new HoldingRecord(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HoldingRecord)) {
            return false;
        }
        HoldingRecord holdingRecord = (HoldingRecord) obj;
        return Intrinsics.areEqual(this.link, holdingRecord.link) && Intrinsics.areEqual(this.token, holdingRecord.token);
    }

    public int hashCode() {
        String str = this.link;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.token;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "HoldingRecord(link=" + this.link + ", token=" + this.token + ")";
    }

    public HoldingRecord(@Json(name = "link") String str, @Json(name = "token") String str2) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(str2, ResponseTypeValues.TOKEN);
        this.link = str;
        this.token = str2;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getToken() {
        return this.token;
    }
}
