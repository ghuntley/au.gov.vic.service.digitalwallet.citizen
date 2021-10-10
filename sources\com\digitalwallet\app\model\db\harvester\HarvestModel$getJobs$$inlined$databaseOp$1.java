package com.digitalwallet.app.model.db.harvester;

import android.os.AsyncTask;
import com.digitalwallet.utilities.AsyncHelper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "it", "Lio/reactivex/SingleEmitter;", "kotlin.jvm.PlatformType", "subscribe", "com/digitalwallet/utilities/StandardHelperKt$databaseOp$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: StandardHelper.kt */
public final class HarvestModel$getJobs$$inlined$databaseOp$1<T> implements SingleOnSubscribe<T> {
    final /* synthetic */ String $agencyIdentifier$inlined;
    final /* synthetic */ HarvestModel this$0;

    public HarvestModel$getJobs$$inlined$databaseOp$1(HarvestModel harvestModel, String str) {
        this.this$0 = harvestModel;
        this.$agencyIdentifier$inlined = str;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<T> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        AsyncHelper.Companion companion = AsyncHelper.Companion;
        new AsyncTask<Void, Void, Void>(this) {
            /* class com.digitalwallet.app.model.db.harvester.HarvestModel$getJobs$$inlined$databaseOp$1.AnonymousClass1 */
            final /* synthetic */ HarvestModel$getJobs$$inlined$databaseOp$1 this$0;

            {
                this.this$0 = r1;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                Intrinsics.checkNotNullParameter(voidArr, "params");
                try {
                    singleEmitter.onSuccess(this.this$0.this$0.database.harvestJobDao().get(this.this$0.$agencyIdentifier$inlined));
                    return null;
                } catch (Throwable th) {
                    singleEmitter.onError(th);
                    return null;
                }
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
}
