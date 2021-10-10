package com.digitalwallet.app.model.db.harvester;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/HarvestTag;", "", "tagNumber", "", "(J)V", "getTagNumber", "()J", "setTagNumber", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestApiModel.kt */
public final class HarvestTag {
    private long tagNumber;

    public static /* synthetic */ HarvestTag copy$default(HarvestTag harvestTag, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = harvestTag.tagNumber;
        }
        return harvestTag.copy(j);
    }

    public final long component1() {
        return this.tagNumber;
    }

    public final HarvestTag copy(long j) {
        return new HarvestTag(j);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof HarvestTag) && this.tagNumber == ((HarvestTag) obj).tagNumber;
        }
        return true;
    }

    public int hashCode() {
        return HarvestTag$$ExternalSynthetic0.m0(this.tagNumber);
    }

    public String toString() {
        return "HarvestTag(tagNumber=" + this.tagNumber + ")";
    }

    public HarvestTag(long j) {
        this.tagNumber = j;
    }

    public final long getTagNumber() {
        return this.tagNumber;
    }

    public final void setTagNumber(long j) {
        this.tagNumber = j;
    }
}
