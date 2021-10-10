package com.digitalwallet.app.model.db.unsecure;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.digitalwallet.app.model.ShareHolding;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;

public final class UnsecuredHoldingDao_Impl implements UnsecuredHoldingDao {
    private final AssetListConverter __assetListConverter = new AssetListConverter();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<UnsecuredHoldingRoom> __deletionAdapterOfUnsecuredHoldingRoom;
    private final DynamicHoldingDisplayConverter __dynamicHoldingDisplayConverter = new DynamicHoldingDisplayConverter();
    private final EntityInsertionAdapter<UnsecuredHoldingRoom> __insertionAdapterOfUnsecuredHoldingRoom;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<UnsecuredHoldingRoom> __updateAdapterOfUnsecuredHoldingRoom;

    public UnsecuredHoldingDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUnsecuredHoldingRoom = new EntityInsertionAdapter<UnsecuredHoldingRoom>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `UnsecuredHolding` (`id`,`link`,`holdingTypeInt`,`shouldUpdate`,`display`,`assets`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UnsecuredHoldingRoom unsecuredHoldingRoom) {
                if (unsecuredHoldingRoom.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, (long) unsecuredHoldingRoom.getId().intValue());
                }
                if (unsecuredHoldingRoom.getLink() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, unsecuredHoldingRoom.getLink());
                }
                supportSQLiteStatement.bindLong(3, (long) unsecuredHoldingRoom.getHoldingTypeInt());
                supportSQLiteStatement.bindLong(4, unsecuredHoldingRoom.getShouldUpdate() ? 1 : 0);
                String json = UnsecuredHoldingDao_Impl.this.__dynamicHoldingDisplayConverter.toJson(unsecuredHoldingRoom.getDisplay());
                if (json == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, json);
                }
                String json2 = UnsecuredHoldingDao_Impl.this.__assetListConverter.toJson(unsecuredHoldingRoom.getAssets());
                if (json2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, json2);
                }
            }
        };
        this.__deletionAdapterOfUnsecuredHoldingRoom = new EntityDeletionOrUpdateAdapter<UnsecuredHoldingRoom>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao_Impl.AnonymousClass2 */

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `UnsecuredHolding` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UnsecuredHoldingRoom unsecuredHoldingRoom) {
                if (unsecuredHoldingRoom.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, (long) unsecuredHoldingRoom.getId().intValue());
                }
            }
        };
        this.__updateAdapterOfUnsecuredHoldingRoom = new EntityDeletionOrUpdateAdapter<UnsecuredHoldingRoom>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao_Impl.AnonymousClass3 */

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `UnsecuredHolding` SET `id` = ?,`link` = ?,`holdingTypeInt` = ?,`shouldUpdate` = ?,`display` = ?,`assets` = ? WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UnsecuredHoldingRoom unsecuredHoldingRoom) {
                if (unsecuredHoldingRoom.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, (long) unsecuredHoldingRoom.getId().intValue());
                }
                if (unsecuredHoldingRoom.getLink() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, unsecuredHoldingRoom.getLink());
                }
                supportSQLiteStatement.bindLong(3, (long) unsecuredHoldingRoom.getHoldingTypeInt());
                supportSQLiteStatement.bindLong(4, unsecuredHoldingRoom.getShouldUpdate() ? 1 : 0);
                String json = UnsecuredHoldingDao_Impl.this.__dynamicHoldingDisplayConverter.toJson(unsecuredHoldingRoom.getDisplay());
                if (json == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, json);
                }
                String json2 = UnsecuredHoldingDao_Impl.this.__assetListConverter.toJson(unsecuredHoldingRoom.getAssets());
                if (json2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, json2);
                }
                if (unsecuredHoldingRoom.getId() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, (long) unsecuredHoldingRoom.getId().intValue());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            /* class com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao_Impl.AnonymousClass4 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM unsecuredholding";
            }
        };
    }

    @Override // com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao
    public void insertAll(UnsecuredHoldingRoom... unsecuredHoldingRoomArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfUnsecuredHoldingRoom.insert(unsecuredHoldingRoomArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao
    public void delete(UnsecuredHoldingRoom unsecuredHoldingRoom) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfUnsecuredHoldingRoom.handle(unsecuredHoldingRoom);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao
    public void updateAll(UnsecuredHoldingRoom... unsecuredHoldingRoomArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfUnsecuredHoldingRoom.handleMultiple(unsecuredHoldingRoomArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao
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

    @Override // com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao
    public List<UnsecuredHoldingRoom> getAll() {
        Integer num;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM unsecuredholding", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "link");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "holdingTypeInt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "shouldUpdate");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ShareHolding.assetDataKey);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                UnsecuredHoldingRoom unsecuredHoldingRoom = new UnsecuredHoldingRoom();
                if (query.isNull(columnIndexOrThrow)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(columnIndexOrThrow));
                }
                unsecuredHoldingRoom.setId(num);
                unsecuredHoldingRoom.setLink(query.getString(columnIndexOrThrow2));
                unsecuredHoldingRoom.setHoldingTypeInt(query.getInt(columnIndexOrThrow3));
                unsecuredHoldingRoom.setShouldUpdate(query.getInt(columnIndexOrThrow4) != 0);
                unsecuredHoldingRoom.setDisplay(this.__dynamicHoldingDisplayConverter.toDisplay(query.getString(columnIndexOrThrow5)));
                unsecuredHoldingRoom.setAssets(this.__assetListConverter.toAssetList(query.getString(columnIndexOrThrow6)));
                arrayList.add(unsecuredHoldingRoom);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao
    public UnsecuredHoldingRoom findById(int i) {
        boolean z = true;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM unsecuredholding WHERE id LIKE ? LIMIT 1", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        UnsecuredHoldingRoom unsecuredHoldingRoom = null;
        Integer num = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "link");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "holdingTypeInt");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "shouldUpdate");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, ShareHolding.assetDataKey);
            if (query.moveToFirst()) {
                UnsecuredHoldingRoom unsecuredHoldingRoom2 = new UnsecuredHoldingRoom();
                if (!query.isNull(columnIndexOrThrow)) {
                    num = Integer.valueOf(query.getInt(columnIndexOrThrow));
                }
                unsecuredHoldingRoom2.setId(num);
                unsecuredHoldingRoom2.setLink(query.getString(columnIndexOrThrow2));
                unsecuredHoldingRoom2.setHoldingTypeInt(query.getInt(columnIndexOrThrow3));
                if (query.getInt(columnIndexOrThrow4) == 0) {
                    z = false;
                }
                unsecuredHoldingRoom2.setShouldUpdate(z);
                unsecuredHoldingRoom2.setDisplay(this.__dynamicHoldingDisplayConverter.toDisplay(query.getString(columnIndexOrThrow5)));
                unsecuredHoldingRoom2.setAssets(this.__assetListConverter.toAssetList(query.getString(columnIndexOrThrow6)));
                unsecuredHoldingRoom = unsecuredHoldingRoom2;
            }
            return unsecuredHoldingRoom;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
