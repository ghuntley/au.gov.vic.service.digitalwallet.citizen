package com.digitalwallet.app.di;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.harvester.HarvestModel;
import com.digitalwallet.app.model.db.scan.ScanDao;
import com.digitalwallet.app.model.db.secure.DigitalWalletSecuredStore;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao;
import com.digitalwallet.app.model.db.secure.SecureHoldingDao;
import com.digitalwallet.app.model.db.secure.SecureStore;
import com.digitalwallet.app.model.db.shares.ShareRecordStore;
import com.digitalwallet.app.model.db.unsecure.UnsecuredStore;
import com.digitalwallet.di.ActivityScope;
import dagger.Module;
import dagger.Provides;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/di/DatabaseModule;", "", "()V", "provideDigitalWalletDatabase", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "context", "Landroid/content/Context;", "provideHarvestModel", "Lcom/digitalwallet/app/model/db/harvester/HarvestModel;", "db", "provideJWTIssuerKeysDao", "Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysDao;", "provideScanDao", "Lcom/digitalwallet/app/model/db/scan/ScanDao;", "provideSecureHoldingDao", "Lcom/digitalwallet/app/model/db/secure/SecureHoldingDao;", "provideShareRecordStore", "Lcom/digitalwallet/app/model/db/shares/ShareRecordStore;", "provideUnSecureHoldingStore", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredStore;", "secureStore", "Lcom/digitalwallet/app/model/db/secure/SecureStore;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: DatabaseModule.kt */
public final class DatabaseModule {
    @Provides
    @ActivityScope
    public final DigitalWalletDatabase provideDigitalWalletDatabase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RoomDatabase.Builder databaseBuilder = Room.databaseBuilder(context, DigitalWalletDatabase.class, "secured-database");
        Migration[] migrations = DigitalWalletDatabase.Companion.getMigrations();
        RoomDatabase build = databaseBuilder.addMigrations((Migration[]) Arrays.copyOf(migrations, migrations.length)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Room\n            .databa…tion\n            .build()");
        return (DigitalWalletDatabase) build;
    }

    @Provides
    @ActivityScope
    public final SecureHoldingDao provideSecureHoldingDao(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "db");
        return digitalWalletDatabase.securedHoldingDao();
    }

    @Provides
    @ActivityScope
    public final SecureStore secureStore(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "db");
        return new DigitalWalletSecuredStore(digitalWalletDatabase);
    }

    @Provides
    @ActivityScope
    public final JWTIssuerKeysDao provideJWTIssuerKeysDao(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "db");
        return digitalWalletDatabase.jwtIssuerKeysDao();
    }

    @Provides
    @ActivityScope
    public final UnsecuredStore provideUnSecureHoldingStore(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "db");
        return new UnsecuredStore(digitalWalletDatabase.unsecuredHoldingDao());
    }

    @Provides
    @ActivityScope
    public final ShareRecordStore provideShareRecordStore(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "db");
        return new ShareRecordStore(digitalWalletDatabase.shareRecordDao());
    }

    @Provides
    @ActivityScope
    public final ScanDao provideScanDao(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "db");
        return digitalWalletDatabase.scanDao();
    }

    @Provides
    @ActivityScope
    public final HarvestModel provideHarvestModel(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "db");
        return new HarvestModel(digitalWalletDatabase);
    }
}
