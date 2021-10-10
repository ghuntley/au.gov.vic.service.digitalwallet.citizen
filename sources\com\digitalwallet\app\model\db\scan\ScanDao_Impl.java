package com.digitalwallet.app.model.db.scan;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;

public final class ScanDao_Impl implements ScanDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<Scan> __deletionAdapterOfScan;
    private final EntityInsertionAdapter<Scan> __insertionAdapterOfScan;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<Scan> __updateAdapterOfScan;

    public ScanDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfScan = new EntityInsertionAdapter<Scan>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.scan.ScanDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Scan` (`content`,`date`,`posted`) VALUES (?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Scan scan) {
                if (scan.getContent() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, scan.getContent());
                }
                if (scan.getDate() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, scan.getDate());
                }
                supportSQLiteStatement.bindLong(3, scan.getPosted() ? 1 : 0);
            }
        };
        this.__deletionAdapterOfScan = new EntityDeletionOrUpdateAdapter<Scan>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.scan.ScanDao_Impl.AnonymousClass2 */

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `Scan` WHERE `content` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Scan scan) {
                if (scan.getContent() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, scan.getContent());
                }
            }
        };
        this.__updateAdapterOfScan = new EntityDeletionOrUpdateAdapter<Scan>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.scan.ScanDao_Impl.AnonymousClass3 */

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `Scan` SET `content` = ?,`date` = ?,`posted` = ? WHERE `content` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Scan scan) {
                if (scan.getContent() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, scan.getContent());
                }
                if (scan.getDate() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, scan.getDate());
                }
                supportSQLiteStatement.bindLong(3, scan.getPosted() ? 1 : 0);
                if (scan.getContent() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, scan.getContent());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            /* class com.digitalwallet.app.model.db.scan.ScanDao_Impl.AnonymousClass4 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM Scan";
            }
        };
    }

    @Override // com.digitalwallet.app.model.db.scan.ScanDao
    public void insert(Scan scan) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfScan.insert(scan);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.scan.ScanDao
    public void delete(Scan scan) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfScan.handle(scan);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.scan.ScanDao
    public void update(Scan scan) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfScan.handle(scan);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.scan.ScanDao
    public void update(Scan... scanArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfScan.handleMultiple(scanArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.scan.ScanDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    @Override // com.digitalwallet.app.model.db.scan.ScanDao
    public List<Scan> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Scan", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Param.CONTENT);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "date");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "posted");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new Scan(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3) != 0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.digitalwallet.app.model.db.scan.ScanDao
    public List<Scan> getAllUnposted() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Scan WHERE posted = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Param.CONTENT);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "date");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "posted");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new Scan(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3) != 0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
