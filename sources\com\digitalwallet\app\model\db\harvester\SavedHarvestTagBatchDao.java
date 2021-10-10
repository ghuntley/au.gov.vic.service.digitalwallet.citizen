package com.digitalwallet.app.model.db.harvester;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H'¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatchDao;", "", "delete", "", "scan", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestBatch;", "deleteAll", "getAll", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatch;", "getById", "id", "", "insert", "tag", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestDao.kt */
public interface SavedHarvestTagBatchDao {
    void delete(SavedHarvestBatch savedHarvestBatch);

    void deleteAll();

    List<SavedHarvestTagBatch> getAll();

    List<SavedHarvestTagBatch> getById(long j);

    long insert(SavedHarvestBatch savedHarvestBatch);
}
