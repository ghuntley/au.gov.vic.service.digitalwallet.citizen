package com.digitalwallet.app.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/model/HoldingRequestRecord;", "", "link", "", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingRequestRecord {
    private final String link;

    public static /* synthetic */ HoldingRequestRecord copy$default(HoldingRequestRecord holdingRequestRecord, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = holdingRequestRecord.link;
        }
        return holdingRequestRecord.copy(str);
    }

    public final String component1() {
        return this.link;
    }

    public final HoldingRequestRecord copy(@Json(name = "link") String str) {
        Intrinsics.checkNotNullParameter(str, "link");
        return new HoldingRequestRecord(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof HoldingRequestRecord) && Intrinsics.areEqual(this.link, ((HoldingRequestRecord) obj).link);
        }
        return true;
    }

    public int hashCode() {
        String str = this.link;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "HoldingRequestRecord(link=" + this.link + ")";
    }

    public HoldingRequestRecord(@Json(name = "link") String str) {
        Intrinsics.checkNotNullParameter(str, "link");
        this.link = str;
    }

    public final String getLink() {
        return this.link;
    }
}
