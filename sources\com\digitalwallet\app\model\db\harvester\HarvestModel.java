package com.digitalwallet.app.model.db.harvester;

import android.os.AsyncTask;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.utilities.AsyncHelper;
import io.reactivex.Single;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rJ\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000e0\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00152\b\b\u0002\u0010&\u001a\u00020'¢\u0006\u0002\u0010(J6\u0010)\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/HarvestModel;", "", "database", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "(Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;)V", "deleteBatch", "", "batch", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestBatch;", "deleteJob", "id", "", "getBatch", "Lio/reactivex/Single;", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatch;", "getBatches", "getJobById", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "getJobs", "agencyIdentifier", "", "saveBatch", "job", "tags", "scanLatitude", "", "scanLongitude", "numFemales", "", "numEasternGreyKangaroos", "numWesternGreyKangaroos", "numRedKangaroos", "numPouchYoungDestroyed", "numYoungAtFootDestroyed", "numTaggedCarcassesLeftOnProperty", "numTaggedCarcassesStoredForProcessor", "comments", "date", "Ljava/util/Date;", "(Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;IIILjava/lang/Integer;IIIILjava/lang/String;Ljava/util/Date;)Lio/reactivex/Single;", "saveJob", "consentDateTime", "quotaId", AuthorizationRequest.Scope.ADDRESS, "landholderName", "landholderContactNumber", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestModel.kt */
public final class HarvestModel {
    private final DigitalWalletDatabase database;

    @Inject
    public HarvestModel(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "database");
        this.database = digitalWalletDatabase;
    }

    public static /* synthetic */ Single saveBatch$default(HarvestModel harvestModel, SavedHarvestJob savedHarvestJob, List list, Double d, Double d2, int i, int i2, int i3, Integer num, int i4, int i5, int i6, int i7, String str, Date date, int i8, Object obj) {
        return harvestModel.saveBatch(savedHarvestJob, list, d, d2, i, i2, i3, num, i4, i5, i6, i7, str, (i8 & 8192) != 0 ? new Date() : date);
    }

    public final Single<List<SavedHarvestJob>> getJobs(String str) {
        Intrinsics.checkNotNullParameter(str, "agencyIdentifier");
        Single<List<SavedHarvestJob>> create = Single.create(new HarvestModel$getJobs$$inlined$databaseOp$1(this, str));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create {\n        …        }\n        }\n    }");
        return create;
    }

    public final Single<SavedHarvestJob> getJobById(long j) {
        Single<SavedHarvestJob> create = Single.create(new HarvestModel$getJobById$$inlined$databaseOp$1(this, j));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create {\n        …        }\n        }\n    }");
        return create;
    }

    public final void saveJob(String str, Date date, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "agencyIdentifier");
        Intrinsics.checkNotNullParameter(date, "consentDateTime");
        Intrinsics.checkNotNullParameter(str2, "quotaId");
        Intrinsics.checkNotNullParameter(str3, AuthorizationRequest.Scope.ADDRESS);
        Intrinsics.checkNotNullParameter(str4, "landholderName");
        Intrinsics.checkNotNullParameter(str5, "landholderContactNumber");
        AsyncHelper.Companion companion = AsyncHelper.Companion;
        new HarvestModel$saveJob$$inlined$backgroundSerial$1(this, str, date, str2, str3, str4, str5).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public final Single<List<SavedHarvestTagBatch>> getBatches() {
        Single<List<SavedHarvestTagBatch>> create = Single.create(new HarvestModel$getBatches$$inlined$databaseOp$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create {\n        …        }\n        }\n    }");
        return create;
    }

    public final Single<List<SavedHarvestTagBatch>> getBatch(long j) {
        Single<List<SavedHarvestTagBatch>> create = Single.create(new HarvestModel$getBatch$$inlined$databaseOp$1(this, j));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create {\n        …        }\n        }\n    }");
        return create;
    }

    public final Single<SavedHarvestBatch> saveBatch(SavedHarvestJob savedHarvestJob, List<Long> list, Double d, Double d2, int i, int i2, int i3, Integer num, int i4, int i5, int i6, int i7, String str, Date date) {
        Intrinsics.checkNotNullParameter(savedHarvestJob, "job");
        Intrinsics.checkNotNullParameter(list, "tags");
        Intrinsics.checkNotNullParameter(str, "comments");
        Intrinsics.checkNotNullParameter(date, "date");
        Single<SavedHarvestBatch> create = Single.create(new HarvestModel$saveBatch$$inlined$databaseOp$1(this, savedHarvestJob, date, d, d2, i, i2, i3, num, i4, i5, i6, i7, str, list));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create {\n        …        }\n        }\n    }");
        return create;
    }

    public final void deleteJob(long j) {
        AsyncHelper.Companion companion = AsyncHelper.Companion;
        new HarvestModel$deleteJob$$inlined$backgroundSerial$1(this, j).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public final void deleteBatch(SavedHarvestBatch savedHarvestBatch) {
        Intrinsics.checkNotNullParameter(savedHarvestBatch, "batch");
        AsyncHelper.Companion companion = AsyncHelper.Companion;
        new HarvestModel$deleteBatch$$inlined$backgroundSerial$1(this, savedHarvestBatch).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
}
