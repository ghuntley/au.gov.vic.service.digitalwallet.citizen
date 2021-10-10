package com.digitalwallet.app.services;

import android.content.Context;
import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.model.db.harvester.HarvestModel;
import com.digitalwallet.app.utilities.DebugHelperKt;
import com.digitalwallet.app.viewmodel.main.SettingOption;
import com.digitalwallet.utilities.ServerTypeKt;
import io.reactivex.Completable;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/services/HarvestDataService;", "", "holdingsApi", "Lcom/digitalwallet/app/api/HoldingsApi;", "harvestModel", "Lcom/digitalwallet/app/model/db/harvester/HarvestModel;", "context", "Landroid/content/Context;", "(Lcom/digitalwallet/app/api/HoldingsApi;Lcom/digitalwallet/app/model/db/harvester/HarvestModel;Landroid/content/Context;)V", "sendHarvest", "Lio/reactivex/Completable;", "id", "", "sendOtherHarvests", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestDataService.kt */
public final class HarvestDataService {
    private final Context context;
    private final HarvestModel harvestModel;
    private final HoldingsApi holdingsApi;

    @Inject
    public HarvestDataService(HoldingsApi holdingsApi2, HarvestModel harvestModel2, Context context2) {
        Intrinsics.checkNotNullParameter(holdingsApi2, "holdingsApi");
        Intrinsics.checkNotNullParameter(harvestModel2, "harvestModel");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.holdingsApi = holdingsApi2;
        this.harvestModel = harvestModel2;
        this.context = context2;
    }

    public final Completable sendHarvest(long j) {
        if (ServerTypeKt.isInternal(ServerTypeKt.getServerType()) && DebugHelperKt.debugOptionActivated(this.context, SettingOption.HarvestMockSucceed.name())) {
            Completable delay = Completable.complete().delay(2, TimeUnit.SECONDS);
            Intrinsics.checkNotNullExpressionValue(delay, "Completable.complete().delay(2, TimeUnit.SECONDS)");
            return delay;
        } else if (!ServerTypeKt.isInternal(ServerTypeKt.getServerType()) || !DebugHelperKt.debugOptionActivated(this.context, SettingOption.HarvestMockFail.name())) {
            Completable timeout = this.harvestModel.getBatch(j).flatMapCompletable(new HarvestDataService$sendHarvest$1(this)).timeout(10, TimeUnit.SECONDS);
            Intrinsics.checkNotNullExpressionValue(timeout, "harvestModel.getBatch(id…out(10, TimeUnit.SECONDS)");
            return timeout;
        } else {
            Completable delay2 = Completable.error(new UnknownHostException()).delay(2, TimeUnit.SECONDS);
            Intrinsics.checkNotNullExpressionValue(delay2, "Completable.error(Unknow…elay(2, TimeUnit.SECONDS)");
            return delay2;
        }
    }

    public final Completable sendOtherHarvests() {
        Completable flatMapCompletable = this.harvestModel.getBatches().flatMapCompletable(new HarvestDataService$sendOtherHarvests$1(this));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "harvestModel.getBatches(…Error(list)\n            }");
        return flatMapCompletable;
    }
}
