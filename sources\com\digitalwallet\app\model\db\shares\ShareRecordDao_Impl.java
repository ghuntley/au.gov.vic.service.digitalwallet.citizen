package com.digitalwallet.app.model.db.shares;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.model.db.unsecure.AssetListConverter;
import com.digitalwallet.app.model.db.unsecure.DynamicHoldingDisplayConverter;
import com.digitalwallet.app.model.db.unsecure.HoldingRecordAttributesConverter;
import java.util.ArrayList;
import java.util.List;
import net.openid.appauth.AuthorizationRequest;

public final class ShareRecordDao_Impl implements ShareRecordDao {
    private final AssetListConverter __assetListConverter = new AssetListConverter();
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ShareRecord> __deletionAdapterOfShareRecord;
    private final DynamicHoldingDisplayConverter __dynamicHoldingDisplayConverter = new DynamicHoldingDisplayConverter();
    private final HoldingRecordAttributesConverter __holdingRecordAttributesConverter = new HoldingRecordAttributesConverter();
    private final EntityInsertionAdapter<ShareRecord> __insertionAdapterOfShareRecord;

    public ShareRecordDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfShareRecord = new EntityInsertionAdapter<ShareRecord>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.shares.ShareRecordDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ShareRecord` (`id`,`licenceNumber`,`holdingTypeString`,`subTypeString`,`licenceKind`,`startDate`,`startTime`,`expiryDate`,`firstName`,`lastName`,`dateOfBirth`,`email`,`phone`,`address`,`attributes`,`dynamicDisplay`,`assets`,`receiverFirstName`,`receiverLastName`,`receiverIdentifier`,`shareTime`,`shareDate`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ShareRecord shareRecord) {
                supportSQLiteStatement.bindLong(1, (long) shareRecord.getId());
                if (shareRecord.getLicenceNumber() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, shareRecord.getLicenceNumber());
                }
                if (shareRecord.getHoldingTypeString() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, shareRecord.getHoldingTypeString());
                }
                if (shareRecord.getSubTypeString() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, shareRecord.getSubTypeString());
                }
                if (shareRecord.getLicenceKind() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, shareRecord.getLicenceKind());
                }
                if (shareRecord.getStartDate() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, shareRecord.getStartDate());
                }
                if (shareRecord.getStartTime() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, shareRecord.getStartTime());
                }
                if (shareRecord.getExpiryDate() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, shareRecord.getExpiryDate());
                }
                if (shareRecord.getFirstName() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, shareRecord.getFirstName());
                }
                if (shareRecord.getLastName() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, shareRecord.getLastName());
                }
                if (shareRecord.getDateOfBirth() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, shareRecord.getDateOfBirth());
                }
                if (shareRecord.getEmail() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, shareRecord.getEmail());
                }
                if (shareRecord.getPhone() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, shareRecord.getPhone());
                }
                if (shareRecord.getAddress() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, shareRecord.getAddress());
                }
                String json = ShareRecordDao_Impl.this.__holdingRecordAttributesConverter.toJson(shareRecord.getAttributes());
                if (json == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, json);
                }
                String json2 = ShareRecordDao_Impl.this.__dynamicHoldingDisplayConverter.toJson(shareRecord.getDynamicDisplay());
                if (json2 == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, json2);
                }
                String json3 = ShareRecordDao_Impl.this.__assetListConverter.toJson(shareRecord.getAssets());
                if (json3 == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, json3);
                }
                if (shareRecord.getReceiverFirstName() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, shareRecord.getReceiverFirstName());
                }
                if (shareRecord.getReceiverLastName() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, shareRecord.getReceiverLastName());
                }
                if (shareRecord.getReceiverIdentifier() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, shareRecord.getReceiverIdentifier());
                }
                supportSQLiteStatement.bindLong(21, shareRecord.getShareTime());
                if (shareRecord.getShareDate() == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, shareRecord.getShareDate());
                }
            }
        };
        this.__deletionAdapterOfShareRecord = new EntityDeletionOrUpdateAdapter<ShareRecord>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.shares.ShareRecordDao_Impl.AnonymousClass2 */

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `ShareRecord` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ShareRecord shareRecord) {
                supportSQLiteStatement.bindLong(1, (long) shareRecord.getId());
            }
        };
    }

    @Override // com.digitalwallet.app.model.db.shares.ShareRecordDao
    public long insert(ShareRecord shareRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfShareRecord.insertAndReturnId(shareRecord);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.shares.ShareRecordDao
    public void delete(ShareRecord shareRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfShareRecord.handle(shareRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.shares.ShareRecordDao
    public List<ShareRecord> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        int columnIndexOrThrow;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM sharerecord", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "licenceNumber");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "holdingTypeString");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "subTypeString");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "licenceKind");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "startDate");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "startTime");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "expiryDate");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "firstName");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "lastName");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "dateOfBirth");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "email");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, AuthorizationRequest.Scope.PHONE);
            roomSQLiteQuery = acquire;
            try {
                columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, AuthorizationRequest.Scope.ADDRESS);
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "attributes");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "dynamicDisplay");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, ShareHolding.assetDataKey);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "receiverFirstName");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "receiverLastName");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "receiverIdentifier");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "shareTime");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "shareDate");
                int i = columnIndexOrThrow;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i2 = query.getInt(columnIndexOrThrow2);
                    String string = query.getString(columnIndexOrThrow3);
                    String string2 = query.getString(columnIndexOrThrow4);
                    String string3 = query.getString(columnIndexOrThrow5);
                    String string4 = query.getString(columnIndexOrThrow6);
                    String string5 = query.getString(columnIndexOrThrow7);
                    String string6 = query.getString(columnIndexOrThrow8);
                    String string7 = query.getString(columnIndexOrThrow9);
                    String string8 = query.getString(columnIndexOrThrow10);
                    String string9 = query.getString(columnIndexOrThrow11);
                    String string10 = query.getString(columnIndexOrThrow12);
                    String string11 = query.getString(columnIndexOrThrow13);
                    String string12 = query.getString(columnIndexOrThrow14);
                    String string13 = query.getString(i);
                    try {
                        HoldingRecordAttributes attributes = this.__holdingRecordAttributesConverter.toAttributes(query.getString(columnIndexOrThrow15));
                        String string14 = query.getString(columnIndexOrThrow16);
                        columnIndexOrThrow16 = columnIndexOrThrow16;
                        DynamicHoldingDisplay display = this.__dynamicHoldingDisplayConverter.toDisplay(string14);
                        String string15 = query.getString(columnIndexOrThrow17);
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        List<Asset> assetList = this.__assetListConverter.toAssetList(string15);
                        String string16 = query.getString(columnIndexOrThrow18);
                        String string17 = query.getString(columnIndexOrThrow19);
                        columnIndexOrThrow18 = columnIndexOrThrow18;
                        String string18 = query.getString(columnIndexOrThrow20);
                        columnIndexOrThrow20 = columnIndexOrThrow20;
                        long j = query.getLong(columnIndexOrThrow21);
                        columnIndexOrThrow21 = columnIndexOrThrow21;
                        String string19 = query.getString(columnIndexOrThrow22);
                        columnIndexOrThrow22 = columnIndexOrThrow22;
                        arrayList.add(new ShareRecord(i2, string, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, attributes, display, assetList, string16, string17, string18, j, string19));
                        columnIndexOrThrow19 = columnIndexOrThrow19;
                        columnIndexOrThrow2 = columnIndexOrThrow2;
                        columnIndexOrThrow3 = columnIndexOrThrow3;
                        i = i;
                        columnIndexOrThrow15 = columnIndexOrThrow15;
                    } catch (Throwable th3) {
                        th = th3;
                        query.close();
                        roomSQLiteQuery.release();
                        throw th;
                    }
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th4) {
                th = th4;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}
