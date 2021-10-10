package com.digitalwallet.app.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/model/HoldingRequestSet;", "", "records", "", "Lcom/digitalwallet/app/model/HoldingRequestRecord;", "(Ljava/util/List;)V", "getRecords", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingRequestSet {
    private final List<HoldingRequestRecord> records;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.HoldingRequestSet */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HoldingRequestSet copy$default(HoldingRequestSet holdingRequestSet, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = holdingRequestSet.records;
        }
        return holdingRequestSet.copy(list);
    }

    public final List<HoldingRequestRecord> component1() {
        return this.records;
    }

    public final HoldingRequestSet copy(@Json(name = "records") List<HoldingRequestRecord> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        return new HoldingRequestSet(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof HoldingRequestSet) && Intrinsics.areEqual(this.records, ((HoldingRequestSet) obj).records);
        }
        return true;
    }

    public int hashCode() {
        List<HoldingRequestRecord> list = this.records;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "HoldingRequestSet(records=" + this.records + ")";
    }

    public HoldingRequestSet(@Json(name = "records") List<HoldingRequestRecord> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        this.records = list;
    }

    public final List<HoldingRequestRecord> getRecords() {
        return this.records;
    }
}
