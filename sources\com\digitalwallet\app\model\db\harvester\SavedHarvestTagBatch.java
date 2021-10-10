package com.digitalwallet.app.model.db.harvester;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatch;", "", "batch", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestBatch;", "(Lcom/digitalwallet/app/model/db/harvester/SavedHarvestBatch;)V", "getBatch", "()Lcom/digitalwallet/app/model/db/harvester/SavedHarvestBatch;", "setBatch", "tags", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTag;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestLocalModel.kt */
public final class SavedHarvestTagBatch {
    private SavedHarvestBatch batch;
    private List<SavedHarvestTag> tags = CollectionsKt.emptyList();

    public SavedHarvestTagBatch(SavedHarvestBatch savedHarvestBatch) {
        Intrinsics.checkNotNullParameter(savedHarvestBatch, "batch");
        this.batch = savedHarvestBatch;
    }

    public final SavedHarvestBatch getBatch() {
        return this.batch;
    }

    public final void setBatch(SavedHarvestBatch savedHarvestBatch) {
        Intrinsics.checkNotNullParameter(savedHarvestBatch, "<set-?>");
        this.batch = savedHarvestBatch;
    }

    public final List<SavedHarvestTag> getTags() {
        return this.tags;
    }

    public final void setTags(List<SavedHarvestTag> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tags = list;
    }
}
