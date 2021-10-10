package com.digitalwallet.app.model.db.shares;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\n"}, d2 = {"Lcom/digitalwallet/app/model/db/shares/ShareRecordDao;", "", "delete", "", "record", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "getAll", "", "insert", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShareRecordDao.kt */
public interface ShareRecordDao {
    void delete(ShareRecord shareRecord);

    List<ShareRecord> getAll();

    long insert(ShareRecord shareRecord);
}
