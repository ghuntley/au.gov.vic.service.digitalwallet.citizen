package com.digitalwallet.app.model.db;

import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJobDao;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatchDao;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagDao;
import com.digitalwallet.app.model.db.scan.ScanDao;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao;
import com.digitalwallet.app.model.db.secure.SecureHoldingDao;
import com.digitalwallet.app.model.db.shares.ShareRecordDao;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHoldingDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "Landroidx/room/RoomDatabase;", "()V", "harvestJobDao", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJobDao;", "harvestTagBatchDao", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatchDao;", "harvestTagDao", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagDao;", "jwtIssuerKeysDao", "Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysDao;", "scanDao", "Lcom/digitalwallet/app/model/db/scan/ScanDao;", "securedHoldingDao", "Lcom/digitalwallet/app/model/db/secure/SecureHoldingDao;", "shareRecordDao", "Lcom/digitalwallet/app/model/db/shares/ShareRecordDao;", "unsecuredHoldingDao", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHoldingDao;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DigitalWalletDatabase.kt */
public abstract class DigitalWalletDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion(null);
    private static final DigitalWalletDatabase$Companion$migration10_11$1 migration10_11;
    private static final DigitalWalletDatabase$Companion$migration11_12$1 migration11_12;
    private static final DigitalWalletDatabase$Companion$migration12_13$1 migration12_13;
    private static final Migration migration4_5;
    private static final Migration migration5_7;
    private static final Migration migration7_8;
    private static final Migration migration8_9;
    private static final DigitalWalletDatabase$Companion$migration9_10$1 migration9_10;
    private static final Migration[] migrations;

    public abstract SavedHarvestJobDao harvestJobDao();

    public abstract SavedHarvestTagBatchDao harvestTagBatchDao();

    public abstract SavedHarvestTagDao harvestTagDao();

    public abstract JWTIssuerKeysDao jwtIssuerKeysDao();

    public abstract ScanDao scanDao();

    public abstract SecureHoldingDao securedHoldingDao();

    public abstract ShareRecordDao shareRecordDao();

    public abstract UnsecuredHoldingDao unsecuredHoldingDao();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0004\u0004\u0007\n\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/model/db/DigitalWalletDatabase$Companion;", "", "()V", "migration10_11", "com/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration10_11$1", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration10_11$1;", "migration11_12", "com/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration11_12$1", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration11_12$1;", "migration12_13", "com/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration12_13$1", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration12_13$1;", "migration4_5", "Landroidx/room/migration/Migration;", "getMigration4_5", "()Landroidx/room/migration/Migration;", "migration5_7", "getMigration5_7", "migration7_8", "getMigration7_8", "migration8_9", "getMigration8_9", "migration9_10", "com/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration9_10$1", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase$Companion$migration9_10$1;", "migrations", "", "getMigrations", "()[Landroidx/room/migration/Migration;", "[Landroidx/room/migration/Migration;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: DigitalWalletDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Migration getMigration4_5() {
            return DigitalWalletDatabase.migration4_5;
        }

        public final Migration getMigration5_7() {
            return DigitalWalletDatabase.migration5_7;
        }

        public final Migration getMigration7_8() {
            return DigitalWalletDatabase.migration7_8;
        }

        public final Migration getMigration8_9() {
            return DigitalWalletDatabase.migration8_9;
        }

        public final Migration[] getMigrations() {
            return DigitalWalletDatabase.migrations;
        }
    }

    static {
        DigitalWalletDatabase$Companion$migration4_5$1 digitalWalletDatabase$Companion$migration4_5$1 = new DigitalWalletDatabase$Companion$migration4_5$1(4, 5);
        migration4_5 = digitalWalletDatabase$Companion$migration4_5$1;
        DigitalWalletDatabase$Companion$migration5_7$1 digitalWalletDatabase$Companion$migration5_7$1 = new DigitalWalletDatabase$Companion$migration5_7$1(5, 7);
        migration5_7 = digitalWalletDatabase$Companion$migration5_7$1;
        DigitalWalletDatabase$Companion$migration7_8$1 digitalWalletDatabase$Companion$migration7_8$1 = new DigitalWalletDatabase$Companion$migration7_8$1(7, 8);
        migration7_8 = digitalWalletDatabase$Companion$migration7_8$1;
        DigitalWalletDatabase$Companion$migration8_9$1 digitalWalletDatabase$Companion$migration8_9$1 = new DigitalWalletDatabase$Companion$migration8_9$1(8, 9);
        migration8_9 = digitalWalletDatabase$Companion$migration8_9$1;
        DigitalWalletDatabase$Companion$migration9_10$1 digitalWalletDatabase$Companion$migration9_10$1 = new DigitalWalletDatabase$Companion$migration9_10$1(9, 10);
        migration9_10 = digitalWalletDatabase$Companion$migration9_10$1;
        DigitalWalletDatabase$Companion$migration10_11$1 digitalWalletDatabase$Companion$migration10_11$1 = new DigitalWalletDatabase$Companion$migration10_11$1(10, 11);
        migration10_11 = digitalWalletDatabase$Companion$migration10_11$1;
        DigitalWalletDatabase$Companion$migration11_12$1 digitalWalletDatabase$Companion$migration11_12$1 = new DigitalWalletDatabase$Companion$migration11_12$1(11, 12);
        migration11_12 = digitalWalletDatabase$Companion$migration11_12$1;
        DigitalWalletDatabase$Companion$migration12_13$1 digitalWalletDatabase$Companion$migration12_13$1 = new DigitalWalletDatabase$Companion$migration12_13$1(12, 13);
        migration12_13 = digitalWalletDatabase$Companion$migration12_13$1;
        migrations = new Migration[]{digitalWalletDatabase$Companion$migration4_5$1, digitalWalletDatabase$Companion$migration5_7$1, digitalWalletDatabase$Companion$migration7_8$1, digitalWalletDatabase$Companion$migration8_9$1, digitalWalletDatabase$Companion$migration9_10$1, digitalWalletDatabase$Companion$migration10_11$1, digitalWalletDatabase$Companion$migration11_12$1, digitalWalletDatabase$Companion$migration12_13$1};
    }
}
