package com.digitalwallet.app.model.db.secure;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.digitalwallet.app.model.InitHandshakeData;
import java.util.ArrayList;
import java.util.List;

public final class SecureHoldingDao_Impl implements SecureHoldingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<EncryptedSecureHoldings> __deletionAdapterOfEncryptedSecureHoldings;
    private final EntityInsertionAdapter<EncryptedSecureHoldings> __insertionAdapterOfEncryptedSecureHoldings;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public SecureHoldingDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfEncryptedSecureHoldings = new EntityInsertionAdapter<EncryptedSecureHoldings>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.secure.SecureHoldingDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `EncryptedSecureHoldings` (`id`,`iv`,`encryptedData`) VALUES (nullif(?, 0),?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, EncryptedSecureHoldings encryptedSecureHoldings) {
                supportSQLiteStatement.bindLong(1, (long) encryptedSecureHoldings.getId());
                if (encryptedSecureHoldings.getIv() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindBlob(2, encryptedSecureHoldings.getIv());
                }
                if (encryptedSecureHoldings.getEncryptedData() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindBlob(3, encryptedSecureHoldings.getEncryptedData());
                }
            }
        };
        this.__deletionAdapterOfEncryptedSecureHoldings = new EntityDeletionOrUpdateAdapter<EncryptedSecureHoldings>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.secure.SecureHoldingDao_Impl.AnonymousClass2 */

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `EncryptedSecureHoldings` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, EncryptedSecureHoldings encryptedSecureHoldings) {
                supportSQLiteStatement.bindLong(1, (long) encryptedSecureHoldings.getId());
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            /* class com.digitalwallet.app.model.db.secure.SecureHoldingDao_Impl.AnonymousClass3 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM encryptedsecureholdings";
            }
        };
    }

    @Override // com.digitalwallet.app.model.db.secure.SecureHoldingDao
    public void insertAll(EncryptedSecureHoldings... encryptedSecureHoldingsArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEncryptedSecureHoldings.insert(encryptedSecureHoldingsArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.secure.SecureHoldingDao
    public void delete(EncryptedSecureHoldings encryptedSecureHoldings) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfEncryptedSecureHoldings.handle(encryptedSecureHoldings);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.secure.SecureHoldingDao
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

    @Override // com.digitalwallet.app.model.db.secure.SecureHoldingDao
    public List<EncryptedSecureHoldings> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM encryptedsecureholdings", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, InitHandshakeData.ivKey);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "encryptedData");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new EncryptedSecureHoldings(query.getInt(columnIndexOrThrow), query.getBlob(columnIndexOrThrow2), query.getBlob(columnIndexOrThrow3)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.digitalwallet.app.model.db.secure.SecureHoldingDao
    public EncryptedSecureHoldings findById(int i) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM encryptedsecureholdings WHERE id LIKE ? LIMIT 1", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        EncryptedSecureHoldings encryptedSecureHoldings = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, InitHandshakeData.ivKey);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "encryptedData");
            if (query.moveToFirst()) {
                encryptedSecureHoldings = new EncryptedSecureHoldings(query.getInt(columnIndexOrThrow), query.getBlob(columnIndexOrThrow2), query.getBlob(columnIndexOrThrow3));
            }
            return encryptedSecureHoldings;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
