package com.digitalwallet.app.model.db.harvester;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.digitalwallet.app.model.db.RoomDateConverters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.openid.appauth.AuthorizationRequest;

public final class SavedHarvestTagBatchDao_Impl implements SavedHarvestTagBatchDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SavedHarvestBatch> __deletionAdapterOfSavedHarvestBatch;
    private final EntityInsertionAdapter<SavedHarvestBatch> __insertionAdapterOfSavedHarvestBatch;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final RoomDateConverters __roomDateConverters = new RoomDateConverters();

    public SavedHarvestTagBatchDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSavedHarvestBatch = new EntityInsertionAdapter<SavedHarvestBatch>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `SavedHarvestBatch` (`harvesterId`,`quotaId`,`address`,`landholderName`,`landholderContactNumber`,`consentCaptured`,`consentDateTime`,`dateOfHarvest`,`scanLatitude`,`scanLongitude`,`numFemales`,`numEasternGreyKangaroos`,`numWesternGreyKangaroos`,`numRedKangaroos`,`numPouchYoungDestroyed`,`numYoungAtFootDestroyed`,`numTaggedCarcassesLeftOnProperty`,`numTaggedCarcassesStoredForProcessor`,`comments`,`id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SavedHarvestBatch savedHarvestBatch) {
                if (savedHarvestBatch.getHarvesterId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, savedHarvestBatch.getHarvesterId());
                }
                if (savedHarvestBatch.getQuotaId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, savedHarvestBatch.getQuotaId());
                }
                if (savedHarvestBatch.getAddress() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, savedHarvestBatch.getAddress());
                }
                if (savedHarvestBatch.getLandholderName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, savedHarvestBatch.getLandholderName());
                }
                if (savedHarvestBatch.getLandholderContactNumber() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, savedHarvestBatch.getLandholderContactNumber());
                }
                supportSQLiteStatement.bindLong(6, savedHarvestBatch.getConsentCaptured() ? 1 : 0);
                String dateToTimestamp = SavedHarvestTagBatchDao_Impl.this.__roomDateConverters.dateToTimestamp(savedHarvestBatch.getConsentDateTime());
                if (dateToTimestamp == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, dateToTimestamp);
                }
                String dateToTimestamp2 = SavedHarvestTagBatchDao_Impl.this.__roomDateConverters.dateToTimestamp(savedHarvestBatch.getDateOfHarvest());
                if (dateToTimestamp2 == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, dateToTimestamp2);
                }
                if (savedHarvestBatch.getScanLatitude() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindDouble(9, savedHarvestBatch.getScanLatitude().doubleValue());
                }
                if (savedHarvestBatch.getScanLongitude() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindDouble(10, savedHarvestBatch.getScanLongitude().doubleValue());
                }
                supportSQLiteStatement.bindLong(11, (long) savedHarvestBatch.getNumFemales());
                if (savedHarvestBatch.getNumEasternGreyKangaroos() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, (long) savedHarvestBatch.getNumEasternGreyKangaroos().intValue());
                }
                supportSQLiteStatement.bindLong(13, (long) savedHarvestBatch.getNumWesternGreyKangaroos());
                if (savedHarvestBatch.getNumRedKangaroos() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, (long) savedHarvestBatch.getNumRedKangaroos().intValue());
                }
                supportSQLiteStatement.bindLong(15, (long) savedHarvestBatch.getNumPouchYoungDestroyed());
                supportSQLiteStatement.bindLong(16, (long) savedHarvestBatch.getNumYoungAtFootDestroyed());
                supportSQLiteStatement.bindLong(17, (long) savedHarvestBatch.getNumTaggedCarcassesLeftOnProperty());
                supportSQLiteStatement.bindLong(18, (long) savedHarvestBatch.getNumTaggedCarcassesStoredForProcessor());
                if (savedHarvestBatch.getComments() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, savedHarvestBatch.getComments());
                }
                if (savedHarvestBatch.getId() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindLong(20, savedHarvestBatch.getId().longValue());
                }
            }
        };
        this.__deletionAdapterOfSavedHarvestBatch = new EntityDeletionOrUpdateAdapter<SavedHarvestBatch>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao_Impl.AnonymousClass2 */

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `SavedHarvestBatch` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SavedHarvestBatch savedHarvestBatch) {
                if (savedHarvestBatch.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, savedHarvestBatch.getId().longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            /* class com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao_Impl.AnonymousClass3 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SavedHarvestBatch";
            }
        };
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao
    public long insert(SavedHarvestBatch savedHarvestBatch) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfSavedHarvestBatch.insertAndReturnId(savedHarvestBatch);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao
    public void delete(SavedHarvestBatch savedHarvestBatch) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSavedHarvestBatch.handle(savedHarvestBatch);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao
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

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02a0 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02b3 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02be A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02c3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01dd A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01e2 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0204 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0207 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0217 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x021a A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022e A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0231 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0247 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x024c A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0282 A[Catch:{ all -> 0x02f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0285 A[Catch:{ all -> 0x02f5 }] */
    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao
    public List<SavedHarvestTagBatch> getById(long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        int i;
        int i2;
        ArrayList arrayList;
        LongSparseArray<ArrayList<SavedHarvestTag>> longSparseArray;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        SavedHarvestBatch savedHarvestBatch;
        int i8;
        int i9;
        int i10;
        ArrayList<SavedHarvestTag> arrayList2;
        boolean z;
        Double d;
        Double d2;
        Integer num;
        Integer num2;
        Long l;
        int i11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SavedHarvestBatch WHERE id=?", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "harvesterId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "quotaId");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, AuthorizationRequest.Scope.ADDRESS);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "landholderName");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "landholderContactNumber");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "consentCaptured");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "consentDateTime");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "dateOfHarvest");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "scanLatitude");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "scanLongitude");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "numFemales");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "numEasternGreyKangaroos");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "numWesternGreyKangaroos");
                roomSQLiteQuery = acquire;
                try {
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "numRedKangaroos");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "numPouchYoungDestroyed");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "numYoungAtFootDestroyed");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "numTaggedCarcassesLeftOnProperty");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "numTaggedCarcassesStoredForProcessor");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "comments");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int i12 = columnIndexOrThrow13;
                    LongSparseArray<ArrayList<SavedHarvestTag>> longSparseArray2 = new LongSparseArray<>();
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow20)) {
                            long j2 = query.getLong(columnIndexOrThrow20);
                            if (longSparseArray2.get(j2) == null) {
                                i11 = columnIndexOrThrow20;
                                longSparseArray2.put(j2, new ArrayList<>());
                            } else {
                                i11 = columnIndexOrThrow20;
                            }
                            columnIndexOrThrow10 = columnIndexOrThrow10;
                            columnIndexOrThrow11 = columnIndexOrThrow11;
                            columnIndexOrThrow20 = i11;
                        }
                    }
                    int i13 = columnIndexOrThrow20;
                    int i14 = columnIndexOrThrow10;
                    int i15 = columnIndexOrThrow11;
                    query.moveToPosition(-1);
                    __fetchRelationshipSavedHarvestTagAscomDigitalwalletAppModelDbHarvesterSavedHarvestTag(longSparseArray2);
                    ArrayList arrayList3 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow) || !query.isNull(columnIndexOrThrow2) || !query.isNull(columnIndexOrThrow3) || !query.isNull(columnIndexOrThrow4) || !query.isNull(columnIndexOrThrow5) || !query.isNull(columnIndexOrThrow6) || !query.isNull(columnIndexOrThrow7) || !query.isNull(columnIndexOrThrow8) || !query.isNull(columnIndexOrThrow9)) {
                            i4 = i14;
                            i3 = i15;
                        } else {
                            i4 = i14;
                            if (query.isNull(i4)) {
                                i3 = i15;
                                if (query.isNull(i3) && query.isNull(columnIndexOrThrow12)) {
                                    arrayList = arrayList3;
                                    i7 = i12;
                                    if (query.isNull(i7)) {
                                        longSparseArray = longSparseArray2;
                                        if (query.isNull(columnIndexOrThrow14)) {
                                            columnIndexOrThrow14 = columnIndexOrThrow14;
                                            if (query.isNull(columnIndexOrThrow15)) {
                                                columnIndexOrThrow15 = columnIndexOrThrow15;
                                                if (query.isNull(columnIndexOrThrow16)) {
                                                    columnIndexOrThrow16 = columnIndexOrThrow16;
                                                    if (query.isNull(columnIndexOrThrow17)) {
                                                        columnIndexOrThrow17 = columnIndexOrThrow17;
                                                        if (query.isNull(columnIndexOrThrow18)) {
                                                            columnIndexOrThrow18 = columnIndexOrThrow18;
                                                            if (query.isNull(columnIndexOrThrow19)) {
                                                                columnIndexOrThrow19 = columnIndexOrThrow19;
                                                                i6 = i13;
                                                                if (!query.isNull(i6)) {
                                                                    String string = query.getString(columnIndexOrThrow);
                                                                    String string2 = query.getString(columnIndexOrThrow2);
                                                                    String string3 = query.getString(columnIndexOrThrow3);
                                                                    String string4 = query.getString(columnIndexOrThrow4);
                                                                    String string5 = query.getString(columnIndexOrThrow5);
                                                                    if (query.getInt(columnIndexOrThrow6) == 0) {
                                                                        i2 = columnIndexOrThrow;
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                        i2 = columnIndexOrThrow;
                                                                    }
                                                                    i = columnIndexOrThrow2;
                                                                    Date fromTimestamp = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow7));
                                                                    Date fromTimestamp2 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow8));
                                                                    if (!query.isNull(columnIndexOrThrow9)) {
                                                                        d = null;
                                                                    } else {
                                                                        d = Double.valueOf(query.getDouble(columnIndexOrThrow9));
                                                                    }
                                                                    if (!query.isNull(i4)) {
                                                                        d2 = null;
                                                                    } else {
                                                                        d2 = Double.valueOf(query.getDouble(i4));
                                                                    }
                                                                    int i16 = query.getInt(i3);
                                                                    if (!query.isNull(columnIndexOrThrow12)) {
                                                                        num = null;
                                                                    } else {
                                                                        num = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                                                                    }
                                                                    int i17 = query.getInt(i7);
                                                                    if (!query.isNull(columnIndexOrThrow14)) {
                                                                        i5 = columnIndexOrThrow15;
                                                                        num2 = null;
                                                                    } else {
                                                                        num2 = Integer.valueOf(query.getInt(columnIndexOrThrow14));
                                                                        i5 = columnIndexOrThrow15;
                                                                    }
                                                                    int i18 = query.getInt(i5);
                                                                    columnIndexOrThrow14 = columnIndexOrThrow14;
                                                                    int i19 = query.getInt(columnIndexOrThrow16);
                                                                    columnIndexOrThrow16 = columnIndexOrThrow16;
                                                                    int i20 = query.getInt(columnIndexOrThrow17);
                                                                    columnIndexOrThrow17 = columnIndexOrThrow17;
                                                                    int i21 = query.getInt(columnIndexOrThrow18);
                                                                    columnIndexOrThrow18 = columnIndexOrThrow18;
                                                                    String string6 = query.getString(columnIndexOrThrow19);
                                                                    if (!query.isNull(i6)) {
                                                                        l = null;
                                                                    } else {
                                                                        l = Long.valueOf(query.getLong(i6));
                                                                    }
                                                                    columnIndexOrThrow19 = columnIndexOrThrow19;
                                                                    savedHarvestBatch = new SavedHarvestBatch(string, string2, string3, string4, string5, z, fromTimestamp, fromTimestamp2, d, d2, i16, num, i17, num2, i18, i19, i20, i21, string6, l);
                                                                    if (!query.isNull(i6)) {
                                                                        i10 = columnIndexOrThrow12;
                                                                        i9 = i7;
                                                                        long j3 = query.getLong(i6);
                                                                        i8 = i6;
                                                                        longSparseArray2 = longSparseArray;
                                                                        arrayList2 = longSparseArray2.get(j3);
                                                                    } else {
                                                                        i10 = columnIndexOrThrow12;
                                                                        i9 = i7;
                                                                        i8 = i6;
                                                                        longSparseArray2 = longSparseArray;
                                                                        arrayList2 = null;
                                                                    }
                                                                    if (arrayList2 == null) {
                                                                        arrayList2 = new ArrayList<>();
                                                                    }
                                                                    SavedHarvestTagBatch savedHarvestTagBatch = new SavedHarvestTagBatch(savedHarvestBatch);
                                                                    savedHarvestTagBatch.setTags(arrayList2);
                                                                    arrayList.add(savedHarvestTagBatch);
                                                                    arrayList3 = arrayList;
                                                                    i14 = i4;
                                                                    columnIndexOrThrow12 = i10;
                                                                    columnIndexOrThrow = i2;
                                                                    i12 = i9;
                                                                    i13 = i8;
                                                                    columnIndexOrThrow15 = i5;
                                                                    i15 = i3;
                                                                    columnIndexOrThrow2 = i;
                                                                } else {
                                                                    i2 = columnIndexOrThrow;
                                                                    i = columnIndexOrThrow2;
                                                                    i5 = columnIndexOrThrow15;
                                                                    savedHarvestBatch = null;
                                                                    if (!query.isNull(i6)) {
                                                                    }
                                                                    if (arrayList2 == null) {
                                                                    }
                                                                    SavedHarvestTagBatch savedHarvestTagBatch2 = new SavedHarvestTagBatch(savedHarvestBatch);
                                                                    savedHarvestTagBatch2.setTags(arrayList2);
                                                                    arrayList.add(savedHarvestTagBatch2);
                                                                    arrayList3 = arrayList;
                                                                    i14 = i4;
                                                                    columnIndexOrThrow12 = i10;
                                                                    columnIndexOrThrow = i2;
                                                                    i12 = i9;
                                                                    i13 = i8;
                                                                    columnIndexOrThrow15 = i5;
                                                                    i15 = i3;
                                                                    columnIndexOrThrow2 = i;
                                                                }
                                                            } else {
                                                                columnIndexOrThrow19 = columnIndexOrThrow19;
                                                            }
                                                        } else {
                                                            columnIndexOrThrow18 = columnIndexOrThrow18;
                                                        }
                                                    } else {
                                                        columnIndexOrThrow17 = columnIndexOrThrow17;
                                                    }
                                                } else {
                                                    columnIndexOrThrow16 = columnIndexOrThrow16;
                                                }
                                            } else {
                                                columnIndexOrThrow15 = columnIndexOrThrow15;
                                            }
                                        } else {
                                            columnIndexOrThrow14 = columnIndexOrThrow14;
                                        }
                                        i6 = i13;
                                        String string7 = query.getString(columnIndexOrThrow);
                                        String string22 = query.getString(columnIndexOrThrow2);
                                        String string32 = query.getString(columnIndexOrThrow3);
                                        String string42 = query.getString(columnIndexOrThrow4);
                                        String string52 = query.getString(columnIndexOrThrow5);
                                        if (query.getInt(columnIndexOrThrow6) == 0) {
                                        }
                                        i = columnIndexOrThrow2;
                                        Date fromTimestamp3 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow7));
                                        Date fromTimestamp22 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow8));
                                        if (!query.isNull(columnIndexOrThrow9)) {
                                        }
                                        if (!query.isNull(i4)) {
                                        }
                                        int i162 = query.getInt(i3);
                                        if (!query.isNull(columnIndexOrThrow12)) {
                                        }
                                        int i172 = query.getInt(i7);
                                        if (!query.isNull(columnIndexOrThrow14)) {
                                        }
                                        int i182 = query.getInt(i5);
                                        columnIndexOrThrow14 = columnIndexOrThrow14;
                                        int i192 = query.getInt(columnIndexOrThrow16);
                                        columnIndexOrThrow16 = columnIndexOrThrow16;
                                        int i202 = query.getInt(columnIndexOrThrow17);
                                        columnIndexOrThrow17 = columnIndexOrThrow17;
                                        int i212 = query.getInt(columnIndexOrThrow18);
                                        columnIndexOrThrow18 = columnIndexOrThrow18;
                                        String string62 = query.getString(columnIndexOrThrow19);
                                        if (!query.isNull(i6)) {
                                        }
                                        columnIndexOrThrow19 = columnIndexOrThrow19;
                                        savedHarvestBatch = new SavedHarvestBatch(string7, string22, string32, string42, string52, z, fromTimestamp3, fromTimestamp22, d, d2, i162, num, i172, num2, i182, i192, i202, i212, string62, l);
                                        if (!query.isNull(i6)) {
                                        }
                                        if (arrayList2 == null) {
                                        }
                                        SavedHarvestTagBatch savedHarvestTagBatch22 = new SavedHarvestTagBatch(savedHarvestBatch);
                                        savedHarvestTagBatch22.setTags(arrayList2);
                                        arrayList.add(savedHarvestTagBatch22);
                                        arrayList3 = arrayList;
                                        i14 = i4;
                                        columnIndexOrThrow12 = i10;
                                        columnIndexOrThrow = i2;
                                        i12 = i9;
                                        i13 = i8;
                                        columnIndexOrThrow15 = i5;
                                        i15 = i3;
                                        columnIndexOrThrow2 = i;
                                    }
                                }
                            } else {
                                arrayList = arrayList3;
                                i7 = i12;
                                i3 = i15;
                            }
                            longSparseArray = longSparseArray2;
                            i6 = i13;
                            String string72 = query.getString(columnIndexOrThrow);
                            String string222 = query.getString(columnIndexOrThrow2);
                            String string322 = query.getString(columnIndexOrThrow3);
                            String string422 = query.getString(columnIndexOrThrow4);
                            String string522 = query.getString(columnIndexOrThrow5);
                            if (query.getInt(columnIndexOrThrow6) == 0) {
                            }
                            i = columnIndexOrThrow2;
                            Date fromTimestamp32 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow7));
                            Date fromTimestamp222 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow8));
                            if (!query.isNull(columnIndexOrThrow9)) {
                            }
                            if (!query.isNull(i4)) {
                            }
                            int i1622 = query.getInt(i3);
                            if (!query.isNull(columnIndexOrThrow12)) {
                            }
                            int i1722 = query.getInt(i7);
                            if (!query.isNull(columnIndexOrThrow14)) {
                            }
                            int i1822 = query.getInt(i5);
                            columnIndexOrThrow14 = columnIndexOrThrow14;
                            int i1922 = query.getInt(columnIndexOrThrow16);
                            columnIndexOrThrow16 = columnIndexOrThrow16;
                            int i2022 = query.getInt(columnIndexOrThrow17);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            int i2122 = query.getInt(columnIndexOrThrow18);
                            columnIndexOrThrow18 = columnIndexOrThrow18;
                            String string622 = query.getString(columnIndexOrThrow19);
                            if (!query.isNull(i6)) {
                            }
                            columnIndexOrThrow19 = columnIndexOrThrow19;
                            savedHarvestBatch = new SavedHarvestBatch(string72, string222, string322, string422, string522, z, fromTimestamp32, fromTimestamp222, d, d2, i1622, num, i1722, num2, i1822, i1922, i2022, i2122, string622, l);
                            if (!query.isNull(i6)) {
                            }
                            if (arrayList2 == null) {
                            }
                            SavedHarvestTagBatch savedHarvestTagBatch222 = new SavedHarvestTagBatch(savedHarvestBatch);
                            savedHarvestTagBatch222.setTags(arrayList2);
                            arrayList.add(savedHarvestTagBatch222);
                            arrayList3 = arrayList;
                            i14 = i4;
                            columnIndexOrThrow12 = i10;
                            columnIndexOrThrow = i2;
                            i12 = i9;
                            i13 = i8;
                            columnIndexOrThrow15 = i5;
                            i15 = i3;
                            columnIndexOrThrow2 = i;
                        }
                        arrayList = arrayList3;
                        i7 = i12;
                        longSparseArray = longSparseArray2;
                        i6 = i13;
                        String string722 = query.getString(columnIndexOrThrow);
                        String string2222 = query.getString(columnIndexOrThrow2);
                        String string3222 = query.getString(columnIndexOrThrow3);
                        String string4222 = query.getString(columnIndexOrThrow4);
                        String string5222 = query.getString(columnIndexOrThrow5);
                        if (query.getInt(columnIndexOrThrow6) == 0) {
                        }
                        i = columnIndexOrThrow2;
                        Date fromTimestamp322 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow7));
                        Date fromTimestamp2222 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow8));
                        if (!query.isNull(columnIndexOrThrow9)) {
                        }
                        if (!query.isNull(i4)) {
                        }
                        int i16222 = query.getInt(i3);
                        if (!query.isNull(columnIndexOrThrow12)) {
                        }
                        int i17222 = query.getInt(i7);
                        if (!query.isNull(columnIndexOrThrow14)) {
                        }
                        int i18222 = query.getInt(i5);
                        columnIndexOrThrow14 = columnIndexOrThrow14;
                        int i19222 = query.getInt(columnIndexOrThrow16);
                        columnIndexOrThrow16 = columnIndexOrThrow16;
                        int i20222 = query.getInt(columnIndexOrThrow17);
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        int i21222 = query.getInt(columnIndexOrThrow18);
                        columnIndexOrThrow18 = columnIndexOrThrow18;
                        String string6222 = query.getString(columnIndexOrThrow19);
                        if (!query.isNull(i6)) {
                        }
                        columnIndexOrThrow19 = columnIndexOrThrow19;
                        savedHarvestBatch = new SavedHarvestBatch(string722, string2222, string3222, string4222, string5222, z, fromTimestamp322, fromTimestamp2222, d, d2, i16222, num, i17222, num2, i18222, i19222, i20222, i21222, string6222, l);
                        if (!query.isNull(i6)) {
                        }
                        if (arrayList2 == null) {
                        }
                        SavedHarvestTagBatch savedHarvestTagBatch2222 = new SavedHarvestTagBatch(savedHarvestBatch);
                        savedHarvestTagBatch2222.setTags(arrayList2);
                        arrayList.add(savedHarvestTagBatch2222);
                        arrayList3 = arrayList;
                        i14 = i4;
                        columnIndexOrThrow12 = i10;
                        columnIndexOrThrow = i2;
                        i12 = i9;
                        i13 = i8;
                        columnIndexOrThrow15 = i5;
                        i15 = i3;
                        columnIndexOrThrow2 = i;
                    }
                    this.__db.setTransactionSuccessful();
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList3;
                } catch (Throwable th2) {
                    th = th2;
                    query.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                roomSQLiteQuery = acquire;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x029a A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02ad A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02b8 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02bd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d9 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01de A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01fe A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0201 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0211 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0214 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0228 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x022b A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0241 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0246 A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x027c A[Catch:{ all -> 0x02f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x027f A[Catch:{ all -> 0x02f2 }] */
    @Override // com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao
    public List<SavedHarvestTagBatch> getAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        int i;
        int i2;
        ArrayList arrayList;
        LongSparseArray<ArrayList<SavedHarvestTag>> longSparseArray;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        SavedHarvestBatch savedHarvestBatch;
        int i8;
        int i9;
        int i10;
        LongSparseArray<ArrayList<SavedHarvestTag>> longSparseArray2;
        ArrayList<SavedHarvestTag> arrayList2;
        boolean z;
        Double d;
        Double d2;
        Integer num;
        Integer num2;
        Long l;
        int i11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SavedHarvestBatch", 0);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "harvesterId");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "quotaId");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, AuthorizationRequest.Scope.ADDRESS);
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "landholderName");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "landholderContactNumber");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "consentCaptured");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "consentDateTime");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "dateOfHarvest");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "scanLatitude");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "scanLongitude");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "numFemales");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "numEasternGreyKangaroos");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "numWesternGreyKangaroos");
                roomSQLiteQuery = acquire;
                try {
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "numRedKangaroos");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "numPouchYoungDestroyed");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "numYoungAtFootDestroyed");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "numTaggedCarcassesLeftOnProperty");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "numTaggedCarcassesStoredForProcessor");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "comments");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int i12 = columnIndexOrThrow13;
                    LongSparseArray<ArrayList<SavedHarvestTag>> longSparseArray3 = new LongSparseArray<>();
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow20)) {
                            long j = query.getLong(columnIndexOrThrow20);
                            if (longSparseArray3.get(j) == null) {
                                i11 = columnIndexOrThrow20;
                                longSparseArray3.put(j, new ArrayList<>());
                            } else {
                                i11 = columnIndexOrThrow20;
                            }
                            columnIndexOrThrow9 = columnIndexOrThrow9;
                            columnIndexOrThrow10 = columnIndexOrThrow10;
                            columnIndexOrThrow20 = i11;
                        }
                    }
                    int i13 = columnIndexOrThrow20;
                    int i14 = columnIndexOrThrow9;
                    int i15 = columnIndexOrThrow10;
                    query.moveToPosition(-1);
                    __fetchRelationshipSavedHarvestTagAscomDigitalwalletAppModelDbHarvesterSavedHarvestTag(longSparseArray3);
                    ArrayList arrayList3 = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow) || !query.isNull(columnIndexOrThrow2) || !query.isNull(columnIndexOrThrow3) || !query.isNull(columnIndexOrThrow4) || !query.isNull(columnIndexOrThrow5) || !query.isNull(columnIndexOrThrow6) || !query.isNull(columnIndexOrThrow7) || !query.isNull(columnIndexOrThrow8)) {
                            i4 = i14;
                            i3 = i15;
                        } else {
                            i4 = i14;
                            if (query.isNull(i4)) {
                                i3 = i15;
                                if (query.isNull(i3) && query.isNull(columnIndexOrThrow11) && query.isNull(columnIndexOrThrow12)) {
                                    arrayList = arrayList3;
                                    i7 = i12;
                                    if (query.isNull(i7)) {
                                        longSparseArray = longSparseArray3;
                                        if (query.isNull(columnIndexOrThrow14)) {
                                            columnIndexOrThrow14 = columnIndexOrThrow14;
                                            if (query.isNull(columnIndexOrThrow15)) {
                                                columnIndexOrThrow15 = columnIndexOrThrow15;
                                                if (query.isNull(columnIndexOrThrow16)) {
                                                    columnIndexOrThrow16 = columnIndexOrThrow16;
                                                    if (query.isNull(columnIndexOrThrow17)) {
                                                        columnIndexOrThrow17 = columnIndexOrThrow17;
                                                        if (query.isNull(columnIndexOrThrow18)) {
                                                            columnIndexOrThrow18 = columnIndexOrThrow18;
                                                            if (query.isNull(columnIndexOrThrow19)) {
                                                                columnIndexOrThrow19 = columnIndexOrThrow19;
                                                                i6 = i13;
                                                                if (!query.isNull(i6)) {
                                                                    String string = query.getString(columnIndexOrThrow);
                                                                    String string2 = query.getString(columnIndexOrThrow2);
                                                                    String string3 = query.getString(columnIndexOrThrow3);
                                                                    String string4 = query.getString(columnIndexOrThrow4);
                                                                    String string5 = query.getString(columnIndexOrThrow5);
                                                                    if (query.getInt(columnIndexOrThrow6) == 0) {
                                                                        i2 = columnIndexOrThrow;
                                                                        z = true;
                                                                    } else {
                                                                        i2 = columnIndexOrThrow;
                                                                        z = false;
                                                                    }
                                                                    i = columnIndexOrThrow2;
                                                                    Date fromTimestamp = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow7));
                                                                    Date fromTimestamp2 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow8));
                                                                    if (!query.isNull(i4)) {
                                                                        d = null;
                                                                    } else {
                                                                        d = Double.valueOf(query.getDouble(i4));
                                                                    }
                                                                    if (!query.isNull(i3)) {
                                                                        d2 = null;
                                                                    } else {
                                                                        d2 = Double.valueOf(query.getDouble(i3));
                                                                    }
                                                                    int i16 = query.getInt(columnIndexOrThrow11);
                                                                    if (!query.isNull(columnIndexOrThrow12)) {
                                                                        num = null;
                                                                    } else {
                                                                        num = Integer.valueOf(query.getInt(columnIndexOrThrow12));
                                                                    }
                                                                    int i17 = query.getInt(i7);
                                                                    if (!query.isNull(columnIndexOrThrow14)) {
                                                                        i5 = columnIndexOrThrow15;
                                                                        num2 = null;
                                                                    } else {
                                                                        num2 = Integer.valueOf(query.getInt(columnIndexOrThrow14));
                                                                        i5 = columnIndexOrThrow15;
                                                                    }
                                                                    int i18 = query.getInt(i5);
                                                                    columnIndexOrThrow14 = columnIndexOrThrow14;
                                                                    int i19 = query.getInt(columnIndexOrThrow16);
                                                                    columnIndexOrThrow16 = columnIndexOrThrow16;
                                                                    int i20 = query.getInt(columnIndexOrThrow17);
                                                                    columnIndexOrThrow17 = columnIndexOrThrow17;
                                                                    int i21 = query.getInt(columnIndexOrThrow18);
                                                                    columnIndexOrThrow18 = columnIndexOrThrow18;
                                                                    String string6 = query.getString(columnIndexOrThrow19);
                                                                    if (!query.isNull(i6)) {
                                                                        l = null;
                                                                    } else {
                                                                        l = Long.valueOf(query.getLong(i6));
                                                                    }
                                                                    columnIndexOrThrow19 = columnIndexOrThrow19;
                                                                    savedHarvestBatch = new SavedHarvestBatch(string, string2, string3, string4, string5, z, fromTimestamp, fromTimestamp2, d, d2, i16, num, i17, num2, i18, i19, i20, i21, string6, l);
                                                                    if (!query.isNull(i6)) {
                                                                        i10 = columnIndexOrThrow11;
                                                                        i9 = i7;
                                                                        i8 = columnIndexOrThrow12;
                                                                        longSparseArray2 = longSparseArray;
                                                                        arrayList2 = longSparseArray2.get(query.getLong(i6));
                                                                    } else {
                                                                        i10 = columnIndexOrThrow11;
                                                                        i9 = i7;
                                                                        i8 = columnIndexOrThrow12;
                                                                        longSparseArray2 = longSparseArray;
                                                                        arrayList2 = null;
                                                                    }
                                                                    if (arrayList2 == null) {
                                                                        arrayList2 = new ArrayList<>();
                                                                    }
                                                                    SavedHarvestTagBatch savedHarvestTagBatch = new SavedHarvestTagBatch(savedHarvestBatch);
                                                                    savedHarvestTagBatch.setTags(arrayList2);
                                                                    arrayList.add(savedHarvestTagBatch);
                                                                    arrayList3 = arrayList;
                                                                    i14 = i4;
                                                                    columnIndexOrThrow11 = i10;
                                                                    columnIndexOrThrow = i2;
                                                                    i12 = i9;
                                                                    i13 = i6;
                                                                    columnIndexOrThrow15 = i5;
                                                                    i15 = i3;
                                                                    columnIndexOrThrow2 = i;
                                                                    longSparseArray3 = longSparseArray2;
                                                                    columnIndexOrThrow12 = i8;
                                                                } else {
                                                                    i2 = columnIndexOrThrow;
                                                                    i = columnIndexOrThrow2;
                                                                    i5 = columnIndexOrThrow15;
                                                                    savedHarvestBatch = null;
                                                                    if (!query.isNull(i6)) {
                                                                    }
                                                                    if (arrayList2 == null) {
                                                                    }
                                                                    SavedHarvestTagBatch savedHarvestTagBatch2 = new SavedHarvestTagBatch(savedHarvestBatch);
                                                                    savedHarvestTagBatch2.setTags(arrayList2);
                                                                    arrayList.add(savedHarvestTagBatch2);
                                                                    arrayList3 = arrayList;
                                                                    i14 = i4;
                                                                    columnIndexOrThrow11 = i10;
                                                                    columnIndexOrThrow = i2;
                                                                    i12 = i9;
                                                                    i13 = i6;
                                                                    columnIndexOrThrow15 = i5;
                                                                    i15 = i3;
                                                                    columnIndexOrThrow2 = i;
                                                                    longSparseArray3 = longSparseArray2;
                                                                    columnIndexOrThrow12 = i8;
                                                                }
                                                            } else {
                                                                columnIndexOrThrow19 = columnIndexOrThrow19;
                                                            }
                                                        } else {
                                                            columnIndexOrThrow18 = columnIndexOrThrow18;
                                                        }
                                                    } else {
                                                        columnIndexOrThrow17 = columnIndexOrThrow17;
                                                    }
                                                } else {
                                                    columnIndexOrThrow16 = columnIndexOrThrow16;
                                                }
                                            } else {
                                                columnIndexOrThrow15 = columnIndexOrThrow15;
                                            }
                                        } else {
                                            columnIndexOrThrow14 = columnIndexOrThrow14;
                                        }
                                        i6 = i13;
                                        String string7 = query.getString(columnIndexOrThrow);
                                        String string22 = query.getString(columnIndexOrThrow2);
                                        String string32 = query.getString(columnIndexOrThrow3);
                                        String string42 = query.getString(columnIndexOrThrow4);
                                        String string52 = query.getString(columnIndexOrThrow5);
                                        if (query.getInt(columnIndexOrThrow6) == 0) {
                                        }
                                        i = columnIndexOrThrow2;
                                        Date fromTimestamp3 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow7));
                                        Date fromTimestamp22 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow8));
                                        if (!query.isNull(i4)) {
                                        }
                                        if (!query.isNull(i3)) {
                                        }
                                        int i162 = query.getInt(columnIndexOrThrow11);
                                        if (!query.isNull(columnIndexOrThrow12)) {
                                        }
                                        int i172 = query.getInt(i7);
                                        if (!query.isNull(columnIndexOrThrow14)) {
                                        }
                                        int i182 = query.getInt(i5);
                                        columnIndexOrThrow14 = columnIndexOrThrow14;
                                        int i192 = query.getInt(columnIndexOrThrow16);
                                        columnIndexOrThrow16 = columnIndexOrThrow16;
                                        int i202 = query.getInt(columnIndexOrThrow17);
                                        columnIndexOrThrow17 = columnIndexOrThrow17;
                                        int i212 = query.getInt(columnIndexOrThrow18);
                                        columnIndexOrThrow18 = columnIndexOrThrow18;
                                        String string62 = query.getString(columnIndexOrThrow19);
                                        if (!query.isNull(i6)) {
                                        }
                                        columnIndexOrThrow19 = columnIndexOrThrow19;
                                        savedHarvestBatch = new SavedHarvestBatch(string7, string22, string32, string42, string52, z, fromTimestamp3, fromTimestamp22, d, d2, i162, num, i172, num2, i182, i192, i202, i212, string62, l);
                                        if (!query.isNull(i6)) {
                                        }
                                        if (arrayList2 == null) {
                                        }
                                        SavedHarvestTagBatch savedHarvestTagBatch22 = new SavedHarvestTagBatch(savedHarvestBatch);
                                        savedHarvestTagBatch22.setTags(arrayList2);
                                        arrayList.add(savedHarvestTagBatch22);
                                        arrayList3 = arrayList;
                                        i14 = i4;
                                        columnIndexOrThrow11 = i10;
                                        columnIndexOrThrow = i2;
                                        i12 = i9;
                                        i13 = i6;
                                        columnIndexOrThrow15 = i5;
                                        i15 = i3;
                                        columnIndexOrThrow2 = i;
                                        longSparseArray3 = longSparseArray2;
                                        columnIndexOrThrow12 = i8;
                                    }
                                }
                            } else {
                                arrayList = arrayList3;
                                i7 = i12;
                                i3 = i15;
                            }
                            longSparseArray = longSparseArray3;
                            i6 = i13;
                            String string72 = query.getString(columnIndexOrThrow);
                            String string222 = query.getString(columnIndexOrThrow2);
                            String string322 = query.getString(columnIndexOrThrow3);
                            String string422 = query.getString(columnIndexOrThrow4);
                            String string522 = query.getString(columnIndexOrThrow5);
                            if (query.getInt(columnIndexOrThrow6) == 0) {
                            }
                            i = columnIndexOrThrow2;
                            Date fromTimestamp32 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow7));
                            Date fromTimestamp222 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow8));
                            if (!query.isNull(i4)) {
                            }
                            if (!query.isNull(i3)) {
                            }
                            int i1622 = query.getInt(columnIndexOrThrow11);
                            if (!query.isNull(columnIndexOrThrow12)) {
                            }
                            int i1722 = query.getInt(i7);
                            if (!query.isNull(columnIndexOrThrow14)) {
                            }
                            int i1822 = query.getInt(i5);
                            columnIndexOrThrow14 = columnIndexOrThrow14;
                            int i1922 = query.getInt(columnIndexOrThrow16);
                            columnIndexOrThrow16 = columnIndexOrThrow16;
                            int i2022 = query.getInt(columnIndexOrThrow17);
                            columnIndexOrThrow17 = columnIndexOrThrow17;
                            int i2122 = query.getInt(columnIndexOrThrow18);
                            columnIndexOrThrow18 = columnIndexOrThrow18;
                            String string622 = query.getString(columnIndexOrThrow19);
                            if (!query.isNull(i6)) {
                            }
                            columnIndexOrThrow19 = columnIndexOrThrow19;
                            savedHarvestBatch = new SavedHarvestBatch(string72, string222, string322, string422, string522, z, fromTimestamp32, fromTimestamp222, d, d2, i1622, num, i1722, num2, i1822, i1922, i2022, i2122, string622, l);
                            if (!query.isNull(i6)) {
                            }
                            if (arrayList2 == null) {
                            }
                            SavedHarvestTagBatch savedHarvestTagBatch222 = new SavedHarvestTagBatch(savedHarvestBatch);
                            savedHarvestTagBatch222.setTags(arrayList2);
                            arrayList.add(savedHarvestTagBatch222);
                            arrayList3 = arrayList;
                            i14 = i4;
                            columnIndexOrThrow11 = i10;
                            columnIndexOrThrow = i2;
                            i12 = i9;
                            i13 = i6;
                            columnIndexOrThrow15 = i5;
                            i15 = i3;
                            columnIndexOrThrow2 = i;
                            longSparseArray3 = longSparseArray2;
                            columnIndexOrThrow12 = i8;
                        }
                        arrayList = arrayList3;
                        i7 = i12;
                        longSparseArray = longSparseArray3;
                        i6 = i13;
                        String string722 = query.getString(columnIndexOrThrow);
                        String string2222 = query.getString(columnIndexOrThrow2);
                        String string3222 = query.getString(columnIndexOrThrow3);
                        String string4222 = query.getString(columnIndexOrThrow4);
                        String string5222 = query.getString(columnIndexOrThrow5);
                        if (query.getInt(columnIndexOrThrow6) == 0) {
                        }
                        i = columnIndexOrThrow2;
                        Date fromTimestamp322 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow7));
                        Date fromTimestamp2222 = this.__roomDateConverters.fromTimestamp(query.getString(columnIndexOrThrow8));
                        if (!query.isNull(i4)) {
                        }
                        if (!query.isNull(i3)) {
                        }
                        int i16222 = query.getInt(columnIndexOrThrow11);
                        if (!query.isNull(columnIndexOrThrow12)) {
                        }
                        int i17222 = query.getInt(i7);
                        if (!query.isNull(columnIndexOrThrow14)) {
                        }
                        int i18222 = query.getInt(i5);
                        columnIndexOrThrow14 = columnIndexOrThrow14;
                        int i19222 = query.getInt(columnIndexOrThrow16);
                        columnIndexOrThrow16 = columnIndexOrThrow16;
                        int i20222 = query.getInt(columnIndexOrThrow17);
                        columnIndexOrThrow17 = columnIndexOrThrow17;
                        int i21222 = query.getInt(columnIndexOrThrow18);
                        columnIndexOrThrow18 = columnIndexOrThrow18;
                        String string6222 = query.getString(columnIndexOrThrow19);
                        if (!query.isNull(i6)) {
                        }
                        columnIndexOrThrow19 = columnIndexOrThrow19;
                        savedHarvestBatch = new SavedHarvestBatch(string722, string2222, string3222, string4222, string5222, z, fromTimestamp322, fromTimestamp2222, d, d2, i16222, num, i17222, num2, i18222, i19222, i20222, i21222, string6222, l);
                        if (!query.isNull(i6)) {
                        }
                        if (arrayList2 == null) {
                        }
                        SavedHarvestTagBatch savedHarvestTagBatch2222 = new SavedHarvestTagBatch(savedHarvestBatch);
                        savedHarvestTagBatch2222.setTags(arrayList2);
                        arrayList.add(savedHarvestTagBatch2222);
                        arrayList3 = arrayList;
                        i14 = i4;
                        columnIndexOrThrow11 = i10;
                        columnIndexOrThrow = i2;
                        i12 = i9;
                        i13 = i6;
                        columnIndexOrThrow15 = i5;
                        i15 = i3;
                        columnIndexOrThrow2 = i;
                        longSparseArray3 = longSparseArray2;
                        columnIndexOrThrow12 = i8;
                    }
                    this.__db.setTransactionSuccessful();
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList3;
                } catch (Throwable th2) {
                    th = th2;
                    query.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                roomSQLiteQuery = acquire;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    private void __fetchRelationshipSavedHarvestTagAscomDigitalwalletAppModelDbHarvesterSavedHarvestTag(LongSparseArray<ArrayList<SavedHarvestTag>> longSparseArray) {
        ArrayList<SavedHarvestTag> arrayList;
        if (!longSparseArray.isEmpty()) {
            if (longSparseArray.size() > 999) {
                LongSparseArray<ArrayList<SavedHarvestTag>> longSparseArray2 = new LongSparseArray<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                int size = longSparseArray.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    longSparseArray2.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
                    i++;
                    i2++;
                    if (i2 == 999) {
                        __fetchRelationshipSavedHarvestTagAscomDigitalwalletAppModelDbHarvesterSavedHarvestTag(longSparseArray2);
                        longSparseArray2 = new LongSparseArray<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                        i2 = 0;
                    }
                }
                if (i2 > 0) {
                    __fetchRelationshipSavedHarvestTagAscomDigitalwalletAppModelDbHarvesterSavedHarvestTag(longSparseArray2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `batch`,`tagNumber`,`id` FROM `SavedHarvestTag` WHERE `batch` IN (");
            int size2 = longSparseArray.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (int i4 = 0; i4 < longSparseArray.size(); i4++) {
                acquire.bindLong(i3, longSparseArray.keyAt(i4));
                i3++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "batch");
                if (columnIndex != -1) {
                    int columnIndex2 = CursorUtil.getColumnIndex(query, "batch");
                    int columnIndex3 = CursorUtil.getColumnIndex(query, "tagNumber");
                    int columnIndex4 = CursorUtil.getColumnIndex(query, "id");
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex) && (arrayList = longSparseArray.get(query.getLong(columnIndex))) != null) {
                            long j = 0;
                            long j2 = columnIndex2 == -1 ? 0 : query.getLong(columnIndex2);
                            if (columnIndex3 != -1) {
                                j = query.getLong(columnIndex3);
                            }
                            arrayList.add(new SavedHarvestTag(j2, j, (columnIndex4 != -1 && !query.isNull(columnIndex4)) ? Long.valueOf(query.getLong(columnIndex4)) : null));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }
}
