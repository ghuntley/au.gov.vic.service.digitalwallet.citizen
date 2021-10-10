package com.digitalwallet.app.model.db.harvester;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTag;", "", "batch", "", "tagNumber", "id", "(JJLjava/lang/Long;)V", "getBatch", "()J", "setBatch", "(J)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTagNumber", "setTagNumber", "component1", "component2", "component3", "copy", "(JJLjava/lang/Long;)Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTag;", "equals", "", "other", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestLocalModel.kt */
public final class SavedHarvestTag {
    private long batch;
    private Long id;
    private long tagNumber;

    public static /* synthetic */ SavedHarvestTag copy$default(SavedHarvestTag savedHarvestTag, long j, long j2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = savedHarvestTag.batch;
        }
        if ((i & 2) != 0) {
            j2 = savedHarvestTag.tagNumber;
        }
        if ((i & 4) != 0) {
            l = savedHarvestTag.id;
        }
        return savedHarvestTag.copy(j, j2, l);
    }

    public final long component1() {
        return this.batch;
    }

    public final long component2() {
        return this.tagNumber;
    }

    public final Long component3() {
        return this.id;
    }

    public final SavedHarvestTag copy(long j, long j2, Long l) {
        return new SavedHarvestTag(j, j2, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SavedHarvestTag)) {
            return false;
        }
        SavedHarvestTag savedHarvestTag = (SavedHarvestTag) obj;
        return this.batch == savedHarvestTag.batch && this.tagNumber == savedHarvestTag.tagNumber && Intrinsics.areEqual(this.id, savedHarvestTag.id);
    }

    public int hashCode() {
        int m0 = ((HarvestTag$$ExternalSynthetic0.m0(this.batch) * 31) + HarvestTag$$ExternalSynthetic0.m0(this.tagNumber)) * 31;
        Long l = this.id;
        return m0 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "SavedHarvestTag(batch=" + this.batch + ", tagNumber=" + this.tagNumber + ", id=" + this.id + ")";
    }

    public SavedHarvestTag(long j, long j2, Long l) {
        this.batch = j;
        this.tagNumber = j2;
        this.id = l;
    }

    public final long getBatch() {
        return this.batch;
    }

    public final void setBatch(long j) {
        this.batch = j;
    }

    public final long getTagNumber() {
        return this.tagNumber;
    }

    public final void setTagNumber(long j) {
        this.tagNumber = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SavedHarvestTag(long j, long j2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? null : l);
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long l) {
        this.id = l;
    }
}
