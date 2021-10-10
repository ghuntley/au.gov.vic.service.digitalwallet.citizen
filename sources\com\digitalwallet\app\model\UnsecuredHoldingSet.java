package com.digitalwallet.app.model;

import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/UnsecuredHoldingSet;", "", "totalRecords", "", "records", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "(ILjava/util/List;)V", "getRecords", "()Ljava/util/List;", "getTotalRecords", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class UnsecuredHoldingSet {
    private final List<UnsecuredHolding> records;
    private final int totalRecords;

    public UnsecuredHoldingSet() {
        this(0, null, 3, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.UnsecuredHoldingSet */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnsecuredHoldingSet copy$default(UnsecuredHoldingSet unsecuredHoldingSet, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = unsecuredHoldingSet.totalRecords;
        }
        if ((i2 & 2) != 0) {
            list = unsecuredHoldingSet.records;
        }
        return unsecuredHoldingSet.copy(i, list);
    }

    public final int component1() {
        return this.totalRecords;
    }

    public final List<UnsecuredHolding> component2() {
        return this.records;
    }

    public final UnsecuredHoldingSet copy(@Json(name = "totalRecords") int i, @Json(name = "records") List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        return new UnsecuredHoldingSet(i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnsecuredHoldingSet)) {
            return false;
        }
        UnsecuredHoldingSet unsecuredHoldingSet = (UnsecuredHoldingSet) obj;
        return this.totalRecords == unsecuredHoldingSet.totalRecords && Intrinsics.areEqual(this.records, unsecuredHoldingSet.records);
    }

    public int hashCode() {
        int i = this.totalRecords * 31;
        List<UnsecuredHolding> list = this.records;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "UnsecuredHoldingSet(totalRecords=" + this.totalRecords + ", records=" + this.records + ")";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.digitalwallet.app.model.db.unsecure.UnsecuredHolding> */
    /* JADX WARN: Multi-variable type inference failed */
    public UnsecuredHoldingSet(@Json(name = "totalRecords") int i, @Json(name = "records") List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        this.totalRecords = i;
        this.records = list;
    }

    public final int getTotalRecords() {
        return this.totalRecords;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnsecuredHoldingSet(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<UnsecuredHolding> getRecords() {
        return this.records;
    }
}
