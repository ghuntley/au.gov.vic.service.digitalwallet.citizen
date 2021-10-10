package com.digitalwallet.app.model.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration5_7$1", "Landroidx/room/migration/Migration;", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DigitalWalletDatabase.kt */
public final class DigitalWalletDatabase$Companion$migration5_7$1 extends Migration {
    DigitalWalletDatabase$Companion$migration5_7$1(int i, int i2) {
        super(i, i2);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Scan2`");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Scan2` (`content` TEXT NOT NULL, `date` TEXT, `posted` INTEGER NOT NULL, PRIMARY KEY(`content`))");
        supportSQLiteDatabase.execSQL("REPLACE INTO `Scan2` (`content`, `posted`, `date`) SELECT `content`, `posted`, NULL AS `date` FROM `Scan`");
        supportSQLiteDatabase.execSQL("DROP TABLE `Scan`");
        supportSQLiteDatabase.execSQL("ALTER TABLE `Scan2` RENAME TO `Scan`");
    }
}
