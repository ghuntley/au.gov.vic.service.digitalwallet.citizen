package com.digitalwallet.app.model.db.scan;

import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J!\u0010\u000b\u001a\u00020\u00032\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\r\"\u00020\u0005H'¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/model/db/scan/ScanDao;", "", "delete", "", "scan", "Lcom/digitalwallet/app/model/db/scan/Scan;", "deleteAll", "getAll", "", "getAllUnposted", "insert", "update", "scans", "", "([Lcom/digitalwallet/app/model/db/scan/Scan;)V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScanDao.kt */
public interface ScanDao {
    void delete(Scan scan);

    void deleteAll();

    List<Scan> getAll();

    List<Scan> getAllUnposted();

    void insert(Scan scan);

    void update(Scan scan);

    void update(Scan... scanArr);
}
