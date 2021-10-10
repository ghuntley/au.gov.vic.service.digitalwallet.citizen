package com.digitalwallet.app.model.db.harvester;

import android.os.AsyncTask;
import android.os.Looper;
import com.digitalwallet.utilities.AsyncHelper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "it", "Lio/reactivex/SingleEmitter;", "kotlin.jvm.PlatformType", "subscribe", "com/digitalwallet/utilities/StandardHelperKt$databaseOp$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class HarvestModel$saveBatch$$inlined$databaseOp$1<T> implements SingleOnSubscribe<T> {
    final /* synthetic */ String $comments$inlined;
    final /* synthetic */ Date $date$inlined;
    final /* synthetic */ SavedHarvestJob $job$inlined;
    final /* synthetic */ int $numEasternGreyKangaroos$inlined;
    final /* synthetic */ int $numFemales$inlined;
    final /* synthetic */ int $numPouchYoungDestroyed$inlined;
    final /* synthetic */ Integer $numRedKangaroos$inlined;
    final /* synthetic */ int $numTaggedCarcassesLeftOnProperty$inlined;
    final /* synthetic */ int $numTaggedCarcassesStoredForProcessor$inlined;
    final /* synthetic */ int $numWesternGreyKangaroos$inlined;
    final /* synthetic */ int $numYoungAtFootDestroyed$inlined;
    final /* synthetic */ Double $scanLatitude$inlined;
    final /* synthetic */ Double $scanLongitude$inlined;
    final /* synthetic */ List $tags$inlined;
    final /* synthetic */ HarvestModel this$0;

    public HarvestModel$saveBatch$$inlined$databaseOp$1(HarvestModel harvestModel, SavedHarvestJob savedHarvestJob, Date date, Double d, Double d2, int i, int i2, int i3, Integer num, int i4, int i5, int i6, int i7, String str, List list) {
        this.this$0 = harvestModel;
        this.$job$inlined = savedHarvestJob;
        this.$date$inlined = date;
        this.$scanLatitude$inlined = d;
        this.$scanLongitude$inlined = d2;
        this.$numFemales$inlined = i;
        this.$numEasternGreyKangaroos$inlined = i2;
        this.$numWesternGreyKangaroos$inlined = i3;
        this.$numRedKangaroos$inlined = num;
        this.$numPouchYoungDestroyed$inlined = i4;
        this.$numYoungAtFootDestroyed$inlined = i5;
        this.$numTaggedCarcassesLeftOnProperty$inlined = i6;
        this.$numTaggedCarcassesStoredForProcessor$inlined = i7;
        this.$comments$inlined = str;
        this.$tags$inlined = list;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<T> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        AsyncHelper.Companion companion = AsyncHelper.Companion;
        new AsyncTask<Void, Void, Void>(this) {
            /* class com.digitalwallet.app.model.db.harvester.HarvestModel$saveBatch$$inlined$databaseOp$1.AnonymousClass1 */
            final /* synthetic */ HarvestModel$saveBatch$$inlined$databaseOp$1 this$0;

            {
                this.this$0 = r1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.reactivex.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                Intrinsics.checkNotNullParameter(voidArr, "params");
                try {
                    SingleEmitter singleEmitter = singleEmitter;
                    Looper mainLooper = Looper.getMainLooper();
                    Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
                    if (!mainLooper.isCurrentThread()) {
                        SavedHarvestBatch savedHarvestBatch = new SavedHarvestBatch(this.this$0.$job$inlined.getAgencyIdentifier(), this.this$0.$job$inlined.getQuotaId(), this.this$0.$job$inlined.getHarvestAddress(), this.this$0.$job$inlined.getLandholderName(), this.this$0.$job$inlined.getLandholderContactNumber(), true, this.this$0.$job$inlined.getConsentDateTime(), this.this$0.$date$inlined, this.this$0.$scanLatitude$inlined, this.this$0.$scanLongitude$inlined, this.this$0.$numFemales$inlined, Integer.valueOf(this.this$0.$numEasternGreyKangaroos$inlined), this.this$0.$numWesternGreyKangaroos$inlined, this.this$0.$numRedKangaroos$inlined, this.this$0.$numPouchYoungDestroyed$inlined, this.this$0.$numYoungAtFootDestroyed$inlined, this.this$0.$numTaggedCarcassesLeftOnProperty$inlined, this.this$0.$numTaggedCarcassesStoredForProcessor$inlined, this.this$0.$comments$inlined, null, 524288, null);
                        savedHarvestBatch.setId(Long.valueOf(this.this$0.this$0.database.harvestTagBatchDao().insert(savedHarvestBatch)));
                        Long id = savedHarvestBatch.getId();
                        Intrinsics.checkNotNull(id);
                        if (id.longValue() > 0) {
                            for (T t : this.this$0.$tags$inlined) {
                                long longValue = t.longValue();
                                Long id2 = savedHarvestBatch.getId();
                                Intrinsics.checkNotNull(id2);
                                this.this$0.this$0.database.harvestTagDao().insert(new SavedHarvestTag(id2.longValue(), longValue, null, 4, null));
                            }
                            singleEmitter.onSuccess(savedHarvestBatch);
                            return null;
                        }
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    throw new IllegalStateException("Check failed.".toString());
                } catch (Throwable th) {
                    singleEmitter.onError(th);
                    return null;
                }
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
}
