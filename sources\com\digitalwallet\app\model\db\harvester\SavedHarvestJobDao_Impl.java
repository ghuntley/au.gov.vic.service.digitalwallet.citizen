package com.digitalwallet.app.model.db.harvester;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.digitalwallet.app.model.db.RoomDateConverters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class SavedHarvestJobDao_Impl implements SavedHarvestJobDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SavedHarvestJob> __insertionAdapterOfSavedHarvestJob;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final RoomDateConverters __roomDateConverters = new RoomDateConverters();

    public SavedHarvestJobDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSavedHarvestJob = new EntityInsertionAdapter<SavedHarvestJob>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `SavedHarvestJob` (`agencyIdentifier`,`consentDateTime`,`quotaId`,`harvestAddress`,`landholderName`,`landholderContactNumber`,`id`) VALUES (?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SavedHarvestJob savedHarvestJob) {
                if (savedHarvestJob.getAgencyIdentifier() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, savedHarvestJob.getAgencyIdentifier());
                }
                String dateToTimestamp = SavedHarvestJobDao_Impl.this.__roomDateConverters.dateToTimestamp(savedHarvestJob.getConsentDateTime());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, dateToTimestamp);
                }
                if (savedHarvestJob.getQuotaId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, savedHarvestJob.getQuotaId());
                }
                if (savedHarvestJob.getHarvestAddress() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, savedHarvestJob.getHarvestAddress());
                }
                if (savedHarvestJob.getLandholderName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, savedHarvestJob.getLandholderName());
                }
                if (savedHarvestJob.getLandholderContactNumber() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, savedHarvestJob.getLandholderContactNumber());
                }
                if (savedHarvestJob.getId() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, savedHarvestJob.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SavedHarvestJob";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao_Impl.AnonymousClass3 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SavedHarvestJob WHERE id=?";
            }
        };
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao
    public long insert(SavedHarvestJob savedHarvestJob) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfSavedHarvestJob.insertAndReturnId(savedHarvestJob);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao
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

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao
    public int delete(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao
    public List<SavedHarvestJob> get(String str) {
        Long l;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SavedHarvestJob WHERE agencyIdentifier=? ORDER BY id ASC", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "agencyIdentifier");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "consentDateTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "quotaId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "harvestAddress");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "landholderName");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "landholderContactNumber");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow);
                Date fromTimestamp = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow2));
                String string2 = query.getString(columnIndexOrThrow3);
                String string3 = query.getString(columnIndexOrThrow4);
                String string4 = query.getString(columnIndexOrThrow5);
                String string5 = query.getString(columnIndexOrThrow6);
                if (query.isNull(columnIndexOrThrow7)) {
                    l = null;
                } else {
                    l = Long.valueOf(query.getLong(columnIndexOrThrow7));
                }
                arrayList.add(new SavedHarvestJob(string, fromTimestamp, string2, string3, string4, string5, l));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao
    public List<SavedHarvestJob> getById(long j) {
        Long l;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SavedHarvestJob WHERE id=?", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "agencyIdentifier");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "consentDateTime");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "quotaId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "harvestAddress");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "landholderName");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "landholderContactNumber");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow);
                Date fromTimestamp = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow2));
                String string2 = query.getString(columnIndexOrThrow3);
                String string3 = query.getString(columnIndexOrThrow4);
                String string4 = query.getString(columnIndexOrThrow5);
                String string5 = query.getString(columnIndexOrThrow6);
                if (query.isNull(columnIndexOrThrow7)) {
                    l = null;
                } else {
                    l = Long.valueOf(query.getLong(columnIndexOrThrow7));
                }
                arrayList.add(new SavedHarvestJob(string, fromTimestamp, string2, string3, string4, string5, l));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
