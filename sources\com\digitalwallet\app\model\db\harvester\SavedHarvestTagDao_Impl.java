package com.digitalwallet.app.model.db.harvester;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class SavedHarvestTagDao_Impl implements SavedHarvestTagDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SavedHarvestTag> __deletionAdapterOfSavedHarvestTag;
    private final EntityInsertionAdapter<SavedHarvestTag> __insertionAdapterOfSavedHarvestTag;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public SavedHarvestTagDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSavedHarvestTag = new EntityInsertionAdapter<SavedHarvestTag>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `SavedHarvestTag` (`batch`,`tagNumber`,`id`) VALUES (?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SavedHarvestTag savedHarvestTag) {
                supportSQLiteStatement.bindLong(1, savedHarvestTag.getBatch());
                supportSQLiteStatement.bindLong(2, savedHarvestTag.getTagNumber());
                if (savedHarvestTag.getId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, savedHarvestTag.getId().longValue());
                }
            }
        };
        this.__deletionAdapterOfSavedHarvestTag = new EntityDeletionOrUpdateAdapter<SavedHarvestTag>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao_Impl.AnonymousClass2 */

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `SavedHarvestTag` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SavedHarvestTag savedHarvestTag) {
                if (savedHarvestTag.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, savedHarvestTag.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao_Impl.AnonymousClass3 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SavedHarvestTag";
            }
        };
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao
    public long insert(SavedHarvestTag savedHarvestTag) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfSavedHarvestTag.insertAndReturnId(savedHarvestTag);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao
    public void delete(SavedHarvestTag savedHarvestTag) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSavedHarvestTag.handle(savedHarvestTag);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao
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

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao
    public List<SavedHarvestTag> getAll() {
        Long l;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SavedHarvestTag", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "batch");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "tagNumber");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j = query.getLong(columnIndexOrThrow);
                long j2 = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    l = null;
                } else {
                    l = Long.valueOf(query.getLong(columnIndexOrThrow3));
                }
                arrayList.add(new SavedHarvestTag(j, j2, l));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
