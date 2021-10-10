package com.digitalwallet.app.model.db.harvester;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH'¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJobDao;", "", "delete", "", "id", "", "deleteAll", "", "get", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "agencyIdentifier", "", "getById", "insert", "job", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestDao.kt */
public interface SavedHarvestJobDao {
    int delete(long j);

    void deleteAll();

    List<SavedHarvestJob> get(String str);

    List<SavedHarvestJob> getById(long j);

    long insert(SavedHarvestJob savedHarvestJob);
}
