package com.digitalwallet.app.model.db.secure;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class JWTIssuerKeysDao_Impl implements JWTIssuerKeysDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<JWTIssuerKeys> __insertionAdapterOfJWTIssuerKeys;
    private final JWKSetConverter __jWKSetConverter = new JWKSetConverter();
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public JWTIssuerKeysDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfJWTIssuerKeys = new EntityInsertionAdapter<JWTIssuerKeys>(roomDatabase) {
            /* class com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `JWTIssuerKeys` (`id`,`issuerKeys`) VALUES (nullif(?, 0),?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, JWTIssuerKeys jWTIssuerKeys) {
                supportSQLiteStatement.bindLong(1, (long) jWTIssuerKeys.getId());
                String json = JWTIssuerKeysDao_Impl.this.__jWKSetConverter.toJson(jWTIssuerKeys.getIssuerKeys());
                if (json == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, json);
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            /* class com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM JWTIssuerKeys";
            }
        };
    }

    @Override // com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao
    public void insert(JWTIssuerKeys jWTIssuerKeys) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfJWTIssuerKeys.insert(jWTIssuerKeys);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao
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

    @Override // com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao
    public List<JWTIssuerKeys> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM JWTIssuerKeys", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "issuerKeys");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new JWTIssuerKeys(query.getInt(columnIndexOrThrow), this.__jWKSetConverter.toJWKSet(query.getString(columnIndexOrThrow2))));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
