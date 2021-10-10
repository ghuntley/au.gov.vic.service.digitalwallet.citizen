package com.digitalwallet.app.model.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.digitalwallet.app.model.InitHandshakeData;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao_Impl;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao_Impl;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao_Impl;
import com.digitalwallet.app.model.db.scan.ScanDao;
import com.digitalwallet.app.model.db.scan.ScanDao_Impl;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao_Impl;
import com.digitalwallet.app.model.db.secure.SecureHoldingDao;
import com.digitalwallet.app.model.db.secure.SecureHoldingDao_Impl;
import com.digitalwallet.app.model.db.shares.ShareRecordDao;
import com.digitalwallet.app.model.db.shares.ShareRecordDao_Impl;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao_Impl;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.HashSet;
import net.openid.appauth.AuthorizationRequest;

public final class DigitalWalletDatabase_Impl extends DigitalWalletDatabase {
    private volatile JWTIssuerKeysDao _jWTIssuerKeysDao;
    private volatile SavedHarvestJobDao _savedHarvestJobDao;
    private volatile SavedHarvestTagBatchDao _savedHarvestTagBatchDao;
    private volatile SavedHarvestTagDao _savedHarvestTagDao;
    private volatile ScanDao _scanDao;
    private volatile SecureHoldingDao _secureHoldingDao;
    private volatile ShareRecordDao _shareRecordDao;
    private volatile UnsecuredHoldingDao _unsecuredHoldingDao;

    /* access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(13) {
            /* class com.digitalwallet.app.model.db.DigitalWalletDatabase_Impl.AnonymousClass1 */

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `EncryptedSecureHoldings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `iv` BLOB NOT NULL, `encryptedData` BLOB NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `JWTIssuerKeys` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `issuerKeys` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UnsecuredHolding` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `link` TEXT NOT NULL, `holdingTypeInt` INTEGER NOT NULL, `shouldUpdate` INTEGER NOT NULL, `display` TEXT, `assets` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ShareRecord` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `licenceNumber` TEXT NOT NULL, `holdingTypeString` TEXT NOT NULL, `subTypeString` TEXT NOT NULL, `licenceKind` TEXT NOT NULL, `startDate` TEXT NOT NULL, `startTime` TEXT NOT NULL, `expiryDate` TEXT NOT NULL, `firstName` TEXT NOT NULL, `lastName` TEXT NOT NULL, `dateOfBirth` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT, `address` TEXT, `attributes` TEXT NOT NULL, `dynamicDisplay` TEXT, `assets` TEXT, `receiverFirstName` TEXT, `receiverLastName` TEXT, `receiverIdentifier` TEXT, `shareTime` INTEGER NOT NULL, `shareDate` TEXT NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Scan` (`content` TEXT NOT NULL, `date` TEXT, `posted` INTEGER NOT NULL, PRIMARY KEY(`content`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SavedHarvestJob` (`agencyIdentifier` TEXT NOT NULL, `consentDateTime` TEXT NOT NULL, `quotaId` TEXT NOT NULL, `harvestAddress` TEXT NOT NULL, `landholderName` TEXT DEFAULT null, `landholderContactNumber` TEXT DEFAULT null, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SavedHarvestBatch` (`harvesterId` TEXT NOT NULL, `quotaId` TEXT NOT NULL, `address` TEXT NOT NULL, `landholderName` TEXT DEFAULT null, `landholderContactNumber` TEXT DEFAULT null, `consentCaptured` INTEGER NOT NULL, `consentDateTime` TEXT NOT NULL, `dateOfHarvest` TEXT NOT NULL, `scanLatitude` REAL, `scanLongitude` REAL, `numFemales` INTEGER NOT NULL, `numEasternGreyKangaroos` INTEGER DEFAULT null, `numWesternGreyKangaroos` INTEGER NOT NULL, `numRedKangaroos` INTEGER DEFAULT null, `numPouchYoungDestroyed` INTEGER NOT NULL, `numYoungAtFootDestroyed` INTEGER NOT NULL, `numTaggedCarcassesLeftOnProperty` INTEGER NOT NULL, `numTaggedCarcassesStoredForProcessor` INTEGER NOT NULL, `comments` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SavedHarvestTag` (`batch` INTEGER NOT NULL, `tagNumber` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '49bbb85221ff17ac53a1730bb71abdcf')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `EncryptedSecureHoldings`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `JWTIssuerKeys`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UnsecuredHolding`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ShareRecord`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Scan`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SavedHarvestJob`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SavedHarvestBatch`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SavedHarvestTag`");
                if (DigitalWalletDatabase_Impl.this.mCallbacks != null) {
                    int size = DigitalWalletDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DigitalWalletDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (DigitalWalletDatabase_Impl.this.mCallbacks != null) {
                    int size = DigitalWalletDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DigitalWalletDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                DigitalWalletDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                DigitalWalletDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (DigitalWalletDatabase_Impl.this.mCallbacks != null) {
                    int size = DigitalWalletDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DigitalWalletDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap.put(InitHandshakeData.ivKey, new TableInfo.Column(InitHandshakeData.ivKey, "BLOB", true, 0, null, 1));
                hashMap.put("encryptedData", new TableInfo.Column("encryptedData", "BLOB", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("EncryptedSecureHoldings", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "EncryptedSecureHoldings");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "EncryptedSecureHoldings(com.digitalwallet.app.model.db.secure.EncryptedSecureHoldings).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(2);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap2.put("issuerKeys", new TableInfo.Column("issuerKeys", "TEXT", false, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("JWTIssuerKeys", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "JWTIssuerKeys");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "JWTIssuerKeys(com.digitalwallet.app.model.db.secure.JWTIssuerKeys).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(6);
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap3.put("link", new TableInfo.Column("link", "TEXT", true, 0, null, 1));
                hashMap3.put("holdingTypeInt", new TableInfo.Column("holdingTypeInt", "INTEGER", true, 0, null, 1));
                hashMap3.put("shouldUpdate", new TableInfo.Column("shouldUpdate", "INTEGER", true, 0, null, 1));
                hashMap3.put(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, new TableInfo.Column(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "TEXT", false, 0, null, 1));
                hashMap3.put(ShareHolding.assetDataKey, new TableInfo.Column(ShareHolding.assetDataKey, "TEXT", false, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("UnsecuredHolding", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "UnsecuredHolding");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "UnsecuredHolding(com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingRoom).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(22);
                hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap4.put("licenceNumber", new TableInfo.Column("licenceNumber", "TEXT", true, 0, null, 1));
                hashMap4.put("holdingTypeString", new TableInfo.Column("holdingTypeString", "TEXT", true, 0, null, 1));
                hashMap4.put("subTypeString", new TableInfo.Column("subTypeString", "TEXT", true, 0, null, 1));
                hashMap4.put("licenceKind", new TableInfo.Column("licenceKind", "TEXT", true, 0, null, 1));
                hashMap4.put("startDate", new TableInfo.Column("startDate", "TEXT", true, 0, null, 1));
                hashMap4.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, null, 1));
                hashMap4.put("expiryDate", new TableInfo.Column("expiryDate", "TEXT", true, 0, null, 1));
                hashMap4.put("firstName", new TableInfo.Column("firstName", "TEXT", true, 0, null, 1));
                hashMap4.put("lastName", new TableInfo.Column("lastName", "TEXT", true, 0, null, 1));
                hashMap4.put("dateOfBirth", new TableInfo.Column("dateOfBirth", "TEXT", true, 0, null, 1));
                hashMap4.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, 1));
                hashMap4.put(AuthorizationRequest.Scope.PHONE, new TableInfo.Column(AuthorizationRequest.Scope.PHONE, "TEXT", false, 0, null, 1));
                hashMap4.put(AuthorizationRequest.Scope.ADDRESS, new TableInfo.Column(AuthorizationRequest.Scope.ADDRESS, "TEXT", false, 0, null, 1));
                hashMap4.put("attributes", new TableInfo.Column("attributes", "TEXT", true, 0, null, 1));
                hashMap4.put("dynamicDisplay", new TableInfo.Column("dynamicDisplay", "TEXT", false, 0, null, 1));
                hashMap4.put(ShareHolding.assetDataKey, new TableInfo.Column(ShareHolding.assetDataKey, "TEXT", false, 0, null, 1));
                hashMap4.put("receiverFirstName", new TableInfo.Column("receiverFirstName", "TEXT", false, 0, null, 1));
                hashMap4.put("receiverLastName", new TableInfo.Column("receiverLastName", "TEXT", false, 0, null, 1));
                hashMap4.put("receiverIdentifier", new TableInfo.Column("receiverIdentifier", "TEXT", false, 0, null, 1));
                hashMap4.put("shareTime", new TableInfo.Column("shareTime", "INTEGER", true, 0, null, 1));
                hashMap4.put("shareDate", new TableInfo.Column("shareDate", "TEXT", true, 0, null, 1));
                TableInfo tableInfo4 = new TableInfo("ShareRecord", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "ShareRecord");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "ShareRecord(com.digitalwallet.app.model.db.shares.ShareRecord).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(3);
                hashMap5.put(FirebaseAnalytics.Param.CONTENT, new TableInfo.Column(FirebaseAnalytics.Param.CONTENT, "TEXT", true, 1, null, 1));
                hashMap5.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, 1));
                hashMap5.put("posted", new TableInfo.Column("posted", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("Scan", hashMap5, new HashSet(0), new HashSet(0));
                TableInfo read5 = TableInfo.read(supportSQLiteDatabase, "Scan");
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "Scan(com.digitalwallet.app.model.db.scan.Scan).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(7);
                hashMap6.put("agencyIdentifier", new TableInfo.Column("agencyIdentifier", "TEXT", true, 0, null, 1));
                hashMap6.put("consentDateTime", new TableInfo.Column("consentDateTime", "TEXT", true, 0, null, 1));
                hashMap6.put("quotaId", new TableInfo.Column("quotaId", "TEXT", true, 0, null, 1));
                hashMap6.put("harvestAddress", new TableInfo.Column("harvestAddress", "TEXT", true, 0, null, 1));
                hashMap6.put("landholderName", new TableInfo.Column("landholderName", "TEXT", false, 0, "null", 1));
                hashMap6.put("landholderContactNumber", new TableInfo.Column("landholderContactNumber", "TEXT", false, 0, "null", 1));
                hashMap6.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, 1));
                TableInfo tableInfo6 = new TableInfo("SavedHarvestJob", hashMap6, new HashSet(0), new HashSet(0));
                TableInfo read6 = TableInfo.read(supportSQLiteDatabase, "SavedHarvestJob");
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "SavedHarvestJob(com.digitalwallet.app.model.db.harvester.SavedHarvestJob).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(20);
                hashMap7.put("harvesterId", new TableInfo.Column("harvesterId", "TEXT", true, 0, null, 1));
                hashMap7.put("quotaId", new TableInfo.Column("quotaId", "TEXT", true, 0, null, 1));
                hashMap7.put(AuthorizationRequest.Scope.ADDRESS, new TableInfo.Column(AuthorizationRequest.Scope.ADDRESS, "TEXT", true, 0, null, 1));
                hashMap7.put("landholderName", new TableInfo.Column("landholderName", "TEXT", false, 0, "null", 1));
                hashMap7.put("landholderContactNumber", new TableInfo.Column("landholderContactNumber", "TEXT", false, 0, "null", 1));
                hashMap7.put("consentCaptured", new TableInfo.Column("consentCaptured", "INTEGER", true, 0, null, 1));
                hashMap7.put("consentDateTime", new TableInfo.Column("consentDateTime", "TEXT", true, 0, null, 1));
                hashMap7.put("dateOfHarvest", new TableInfo.Column("dateOfHarvest", "TEXT", true, 0, null, 1));
                hashMap7.put("scanLatitude", new TableInfo.Column("scanLatitude", "REAL", false, 0, null, 1));
                hashMap7.put("scanLongitude", new TableInfo.Column("scanLongitude", "REAL", false, 0, null, 1));
                hashMap7.put("numFemales", new TableInfo.Column("numFemales", "INTEGER", true, 0, null, 1));
                hashMap7.put("numEasternGreyKangaroos", new TableInfo.Column("numEasternGreyKangaroos", "INTEGER", false, 0, "null", 1));
                hashMap7.put("numWesternGreyKangaroos", new TableInfo.Column("numWesternGreyKangaroos", "INTEGER", true, 0, null, 1));
                hashMap7.put("numRedKangaroos", new TableInfo.Column("numRedKangaroos", "INTEGER", false, 0, "null", 1));
                hashMap7.put("numPouchYoungDestroyed", new TableInfo.Column("numPouchYoungDestroyed", "INTEGER", true, 0, null, 1));
                hashMap7.put("numYoungAtFootDestroyed", new TableInfo.Column("numYoungAtFootDestroyed", "INTEGER", true, 0, null, 1));
                hashMap7.put("numTaggedCarcassesLeftOnProperty", new TableInfo.Column("numTaggedCarcassesLeftOnProperty", "INTEGER", true, 0, null, 1));
                hashMap7.put("numTaggedCarcassesStoredForProcessor", new TableInfo.Column("numTaggedCarcassesStoredForProcessor", "INTEGER", true, 0, null, 1));
                hashMap7.put("comments", new TableInfo.Column("comments", "TEXT", false, 0, null, 1));
                hashMap7.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, 1));
                TableInfo tableInfo7 = new TableInfo("SavedHarvestBatch", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo read7 = TableInfo.read(supportSQLiteDatabase, "SavedHarvestBatch");
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "SavedHarvestBatch(com.digitalwallet.app.model.db.harvester.SavedHarvestBatch).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                HashMap hashMap8 = new HashMap(3);
                hashMap8.put("batch", new TableInfo.Column("batch", "INTEGER", true, 0, null, 1));
                hashMap8.put("tagNumber", new TableInfo.Column("tagNumber", "INTEGER", true, 0, null, 1));
                hashMap8.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, 1));
                TableInfo tableInfo8 = new TableInfo("SavedHarvestTag", hashMap8, new HashSet(0), new HashSet(0));
                TableInfo read8 = TableInfo.read(supportSQLiteDatabase, "SavedHarvestTag");
                if (tableInfo8.equals(read8)) {
                    return new RoomOpenHelper.ValidationResult(true, null);
                }
                return new RoomOpenHelper.ValidationResult(false, "SavedHarvestTag(com.digitalwallet.app.model.db.harvester.SavedHarvestTag).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
            }
        }, "49bbb85221ff17ac53a1730bb71abdcf", "95f65377c9d9a05604ed1e5455c451a6")).build());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "EncryptedSecureHoldings", "JWTIssuerKeys", "UnsecuredHolding", "ShareRecord", "Scan", "SavedHarvestJob", "SavedHarvestBatch", "SavedHarvestTag");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `EncryptedSecureHoldings`");
            writableDatabase.execSQL("DELETE FROM `JWTIssuerKeys`");
            writableDatabase.execSQL("DELETE FROM `UnsecuredHolding`");
            writableDatabase.execSQL("DELETE FROM `ShareRecord`");
            writableDatabase.execSQL("DELETE FROM `Scan`");
            writableDatabase.execSQL("DELETE FROM `SavedHarvestJob`");
            writableDatabase.execSQL("DELETE FROM `SavedHarvestBatch`");
            writableDatabase.execSQL("DELETE FROM `SavedHarvestTag`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // com.digitalwallet.app.model.db.DigitalWalletDatabase
    public SecureHoldingDao securedHoldingDao() {
        SecureHoldingDao secureHoldingDao;
        if (this._secureHoldingDao != null) {
            return this._secureHoldingDao;
        }
        synchronized (this) {
            if (this._secureHoldingDao == null) {
                this._secureHoldingDao = new SecureHoldingDao_Impl(this);
            }
            secureHoldingDao = this._secureHoldingDao;
        }
        return secureHoldingDao;
    }

    @Override // com.digitalwallet.app.model.db.DigitalWalletDatabase
    public JWTIssuerKeysDao jwtIssuerKeysDao() {
        JWTIssuerKeysDao jWTIssuerKeysDao;
        if (this._jWTIssuerKeysDao != null) {
            return this._jWTIssuerKeysDao;
        }
        synchronized (this) {
            if (this._jWTIssuerKeysDao == null) {
                this._jWTIssuerKeysDao = new JWTIssuerKeysDao_Impl(this);
            }
            jWTIssuerKeysDao = this._jWTIssuerKeysDao;
        }
        return jWTIssuerKeysDao;
    }

    @Override // com.digitalwallet.app.model.db.DigitalWalletDatabase
    public UnsecuredHoldingDao unsecuredHoldingDao() {
        UnsecuredHoldingDao unsecuredHoldingDao;
        if (this._unsecuredHoldingDao != null) {
            return this._unsecuredHoldingDao;
        }
        synchronized (this) {
            if (this._unsecuredHoldingDao == null) {
                this._unsecuredHoldingDao = new UnsecuredHoldingDao_Impl(this);
            }
            unsecuredHoldingDao = this._unsecuredHoldingDao;
        }
        return unsecuredHoldingDao;
    }

    @Override // com.digitalwallet.app.model.db.DigitalWalletDatabase
    public ShareRecordDao shareRecordDao() {
        ShareRecordDao shareRecordDao;
        if (this._shareRecordDao != null) {
            return this._shareRecordDao;
        }
        synchronized (this) {
            if (this._shareRecordDao == null) {
                this._shareRecordDao = new ShareRecordDao_Impl(this);
            }
            shareRecordDao = this._shareRecordDao;
        }
        return shareRecordDao;
    }

    @Override // com.digitalwallet.app.model.db.DigitalWalletDatabase
    public ScanDao scanDao() {
        ScanDao scanDao;
        if (this._scanDao != null) {
            return this._scanDao;
        }
        synchronized (this) {
            if (this._scanDao == null) {
                this._scanDao = new ScanDao_Impl(this);
            }
            scanDao = this._scanDao;
        }
        return scanDao;
    }

    @Override // com.digitalwallet.app.model.db.DigitalWalletDatabase
    public SavedHarvestJobDao harvestJobDao() {
        SavedHarvestJobDao savedHarvestJobDao;
        if (this._savedHarvestJobDao != null) {
            return this._savedHarvestJobDao;
        }
        synchronized (this) {
            if (this._savedHarvestJobDao == null) {
                this._savedHarvestJobDao = new SavedHarvestJobDao_Impl(this);
            }
            savedHarvestJobDao = this._savedHarvestJobDao;
        }
        return savedHarvestJobDao;
    }

    @Override // com.digitalwallet.app.model.db.DigitalWalletDatabase
    public SavedHarvestTagDao harvestTagDao() {
        SavedHarvestTagDao savedHarvestTagDao;
        if (this._savedHarvestTagDao != null) {
            return this._savedHarvestTagDao;
        }
        synchronized (this) {
            if (this._savedHarvestTagDao == null) {
                this._savedHarvestTagDao = new SavedHarvestTagDao_Impl(this);
            }
            savedHarvestTagDao = this._savedHarvestTagDao;
        }
        return savedHarvestTagDao;
    }

    @Override // com.digitalwallet.app.model.db.DigitalWalletDatabase
    public SavedHarvestTagBatchDao harvestTagBatchDao() {
        SavedHarvestTagBatchDao savedHarvestTagBatchDao;
        if (this._savedHarvestTagBatchDao != null) {
            return this._savedHarvestTagBatchDao;
        }
        synchronized (this) {
            if (this._savedHarvestTagBatchDao == null) {
                this._savedHarvestTagBatchDao = new SavedHarvestTagBatchDao_Impl(this);
            }
            savedHarvestTagBatchDao = this._savedHarvestTagBatchDao;
        }
        return savedHarvestTagBatchDao;
    }
}
