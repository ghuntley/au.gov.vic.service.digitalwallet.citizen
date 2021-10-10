package com.digitalwallet.app.holdings;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.model.HoldingRequestRecord;
import com.digitalwallet.app.model.HoldingRequestSet;
import com.digitalwallet.app.model.HoldingSet;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import com.digitalwallet.app.oidc.model.BootstrapConfig;
import com.digitalwallet.di.ActivityScope;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

@ActivityScope
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/holdings/HoldingsApiService;", "", "configurationDocument", "Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;", "api", "Lcom/digitalwallet/app/api/HoldingsApi;", "holdingParser", "Lcom/digitalwallet/app/holdings/HoldingParser;", "appStartUp", "Lcom/digitalwallet/app/AppStartUp;", "(Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;Lcom/digitalwallet/app/api/HoldingsApi;Lcom/digitalwallet/app/holdings/HoldingParser;Lcom/digitalwallet/app/AppStartUp;)V", "fetchSecureHoldings", "Lio/reactivex/Single;", "", "Lcom/digitalwallet/app/model/SecureHolding;", "links", "", "fetchUnsecuredHoldings", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingsApiService.kt */
public final class HoldingsApiService {
    private final HoldingsApi api;
    private final AppStartUp appStartUp;
    private final ConfigurationDocument configurationDocument;
    private final HoldingParser holdingParser;

    @Inject
    public HoldingsApiService(ConfigurationDocument configurationDocument2, HoldingsApi holdingsApi, HoldingParser holdingParser2, AppStartUp appStartUp2) {
        Intrinsics.checkNotNullParameter(configurationDocument2, "configurationDocument");
        Intrinsics.checkNotNullParameter(holdingsApi, "api");
        Intrinsics.checkNotNullParameter(holdingParser2, "holdingParser");
        Intrinsics.checkNotNullParameter(appStartUp2, "appStartUp");
        this.configurationDocument = configurationDocument2;
        this.api = holdingsApi;
        this.holdingParser = holdingParser2;
        this.appStartUp = appStartUp2;
    }

    public final Single<List<UnsecuredHolding>> fetchUnsecuredHoldings() {
        Single<R> map = this.api.getUnSecureHoldings().map(HoldingsApiService$fetchUnsecuredHoldings$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "api.getUnSecureHoldings(…t.isValid }\n            }");
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.digitalwallet.app.holdings.HoldingsApiService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final Single<List<SecureHolding>> fetchSecureHoldings(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "links");
        HoldingsApi holdingsApi = this.api;
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new HoldingRequestRecord(it.next()));
        }
        Single<HoldingSet> onErrorResumeNext = holdingsApi.getSecureHoldings(new HoldingRequestSet(arrayList)).onErrorResumeNext(HoldingsApiService$fetchSecureHoldings$2.INSTANCE);
        Single<BootstrapConfig> bootstrapDocument = this.configurationDocument.getBootstrapDocument();
        KProperty1 kProperty1 = HoldingsApiService$fetchSecureHoldings$3.INSTANCE;
        if (kProperty1 != null) {
            kProperty1 = new HoldingsApiService$sam$io_reactivex_functions_Function$0(kProperty1);
        }
        Single<R> map = onErrorResumeNext.zipWith(bootstrapDocument.map((Function) kProperty1).flatMap(new HoldingsApiService$sam$io_reactivex_functions_Function$0(new HoldingsApiService$fetchSecureHoldings$4(this.configurationDocument))), new HoldingsApiService$fetchSecureHoldings$5(this)).map(new HoldingsApiService$sam$io_reactivex_functions_Function$0(new HoldingsApiService$fetchSecureHoldings$6(this.holdingParser)));
        Intrinsics.checkNotNullExpressionValue(map, "api.getSecureHoldings(Ho…ingParser::parseHoldings)");
        return map;
    }
}
