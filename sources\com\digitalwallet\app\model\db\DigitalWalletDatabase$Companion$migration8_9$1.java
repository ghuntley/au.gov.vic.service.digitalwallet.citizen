package com.digitalwallet.app.model.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration8_9$1", "Landroidx/room/migration/Migration;", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DigitalWalletDatabase.kt */
public final class DigitalWalletDatabase$Companion$migration8_9$1 extends Migration {
    DigitalWalletDatabase$Companion$migration8_9$1(int i, int i2) {
        super(i, i2);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SavedHarvestJob` (`agencyIdentifier` TEXT NOT NULL, `consentDateTime` TEXT NOT NULL, `quotaId` TEXT NOT NULL, `harvestAddress` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SavedHarvestBatch` (`harvesterId` TEXT NOT NULL, `quotaId` TEXT NOT NULL, `address` TEXT NOT NULL, `consentCaptured` INTEGER NOT NULL, `consentDateTime` TEXT NOT NULL, `dateOfHarvest` TEXT NOT NULL, `scanLatitude` REAL, `scanLongitude` REAL, `numFemales` INTEGER NOT NULL, `numWesternGreyKangaroos` INTEGER NOT NULL, `numPouchYoungDestroyed` INTEGER NOT NULL, `numYoungAtFootDestroyed` INTEGER NOT NULL, `numTaggedCarcassesLeftOnProperty` INTEGER NOT NULL, `numTaggedCarcassesStoredForProcessor` INTEGER NOT NULL, `comments` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SavedHarvestTag` (`batch` INTEGER NOT NULL, `tagNumber` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT)");
    }
}
