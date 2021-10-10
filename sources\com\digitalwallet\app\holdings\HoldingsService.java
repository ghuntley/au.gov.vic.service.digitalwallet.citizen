package com.digitalwallet.app.holdings;

import android.content.Context;
import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.SubType;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.di.ActivityScope;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.RetrofitHelper;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@ActivityScope
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J.\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016H\u0002J\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015J>\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\"\u001a\u00020\u00172\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fH\u0002J*\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00162\b\b\u0002\u0010&\u001a\u00020'J&\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00160\u00152\b\b\u0002\u0010)\u001a\u00020'2\b\b\u0002\u0010&\u001a\u00020'J\u0014\u0010*\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016J.\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016J$\u0010-\u001a\u00020\u00122\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016H\u0002J\u0014\u0010/\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/digitalwallet/app/holdings/HoldingsService;", "", "context", "Landroid/content/Context;", "apiService", "Lcom/digitalwallet/app/holdings/HoldingsApiService;", "dbService", "Lcom/digitalwallet/app/holdings/HoldingsDbService;", "authUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "assetService", "Lcom/digitalwallet/app/services/AssetService;", "moshi", "Lcom/squareup/moshi/Moshi;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Landroid/content/Context;Lcom/digitalwallet/app/holdings/HoldingsApiService;Lcom/digitalwallet/app/holdings/HoldingsDbService;Lcom/digitalwallet/app/oidc/AuthenticationUtility;Lcom/digitalwallet/app/services/AssetService;Lcom/squareup/moshi/Moshi;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "cleanUpAssets", "Lio/reactivex/Completable;", "deleteHoldingExpiryNotifications", "downloadAssets", "Lio/reactivex/Single;", "", "Lcom/digitalwallet/app/model/SecureHolding;", "synced", "stored", "fetchSecureHoldings", "holdings", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "getLocalSecureHoldings", "preloadAsset", "", "Lio/reactivex/Observable;", "Lcom/digitalwallet/app/model/Asset;", HoldingExpiryPublisher.HOLDING_KEY, "list", "refreshSecureHoldings", "unsecuredHoldings", "failFast", "", "refreshUnsecuredHoldings", "canWrite", "scheduleHoldingExpiryNotifications", "storeAndCleanUp", "securedHoldings", "storeSecureHoldings", "secureHoldings", "storeUnsecuredHoldings", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService {
    private final AnalyticsHelper analytics;
    private final HoldingsApiService apiService;
    private final AssetService assetService;
    private final AuthenticationUtility authUtility;
    private final Context context;
    private final HoldingsDbService dbService;
    private final Moshi moshi;

    @Inject
    public HoldingsService(Context context2, HoldingsApiService holdingsApiService, HoldingsDbService holdingsDbService, AuthenticationUtility authenticationUtility, AssetService assetService2, Moshi moshi2, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(holdingsApiService, "apiService");
        Intrinsics.checkNotNullParameter(holdingsDbService, "dbService");
        Intrinsics.checkNotNullParameter(authenticationUtility, "authUtility");
        Intrinsics.checkNotNullParameter(assetService2, "assetService");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.context = context2;
        this.apiService = holdingsApiService;
        this.dbService = holdingsDbService;
        this.authUtility = authenticationUtility;
        this.assetService = assetService2;
        this.moshi = moshi2;
        this.analytics = analyticsHelper;
    }

    private final Single<List<SecureHolding>> fetchSecureHoldings(List<? extends UnsecuredHolding> list) {
        HoldingsApiService holdingsApiService = this.apiService;
        List<? extends UnsecuredHolding> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getLink());
        }
        return holdingsApiService.fetchSecureHoldings(arrayList);
    }

    public final Single<List<SecureHolding>> getLocalSecureHoldings() {
        return this.dbService.getSecureHoldings();
    }

    public final Completable storeUnsecuredHoldings(List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        return this.dbService.storeUnsecuredHoldings(list);
    }

    private final Completable storeSecureHoldings(List<SecureHolding> list, List<? extends UnsecuredHolding> list2) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            UnsecuredHolding unsecuredHolding = (UnsecuredHolding) SequencesKt.firstOrNull(SequencesKt.filter(CollectionsKt.asSequence(list2), new HoldingsService$storeSecureHoldings$1$unsecuredHolding$1(t2)));
            if (unsecuredHolding != null) {
                Integer id = unsecuredHolding.getId();
                if (id == null) {
                    id = t2.getUnsecuredId();
                }
                t2.setUnsecuredId(id);
            }
            if (unsecuredHolding != null) {
                arrayList.add(t);
            }
        }
        return this.dbService.storeSecureHoldings(arrayList);
    }

    public static /* synthetic */ Single refreshUnsecuredHoldings$default(HoldingsService holdingsService, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = holdingsService.authUtility.cardSyncPreferencesSet();
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return holdingsService.refreshUnsecuredHoldings(z, z2);
    }

    public final Single<List<UnsecuredHolding>> refreshUnsecuredHoldings(boolean z, boolean z2) {
        Single<R> doOnSuccess = this.apiService.fetchUnsecuredHoldings().zipWith(this.dbService.getUnsecuredHoldings(), new HoldingsService$refreshUnsecuredHoldings$1(this)).map(HoldingsService$refreshUnsecuredHoldings$2.INSTANCE).doOnSuccess(new HoldingsService$refreshUnsecuredHoldings$3(this, z));
        if (!z2) {
            doOnSuccess = doOnSuccess.onErrorResumeNext(new HoldingsService$refreshUnsecuredHoldings$$inlined$letIf$lambda$1(this));
        }
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "apiService.fetchUnsecure…          }\n            }");
        return doOnSuccess;
    }

    public static /* synthetic */ Single refreshSecureHoldings$default(HoldingsService holdingsService, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return holdingsService.refreshSecureHoldings(list, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v80, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v18, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v19, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v20, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v21, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v23, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v24, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v25, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v26, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v27, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v28, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r3v29, types: [com.digitalwallet.app.holdings.HoldingsService$sam$io_reactivex_functions_Function$0] */
    /* JADX WARNING: Unknown variable types count: 13 */
    public final Single<List<SecureHolding>> refreshSecureHoldings(List<? extends UnsecuredHolding> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "unsecuredHoldings");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t.getShouldUpdate()) {
                arrayList.add(t);
            }
        }
        List<UnsecuredHolding> invoke = TestHolding.Companion.getSolarUnsecured().mockIf(false, this.moshi).invoke(TestHolding.Companion.getAmbulanceVictoriaUnsecured().mockIf(false, this.moshi).invoke(TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_PYROTECHNICIANS_LICENCE).mockIf(false, this.moshi).invoke(TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_HIGH_CONSEQUENCE_DANGEROUS_GOODS_PERMIT).mockIf(false, this.moshi).invoke(TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_EXPLOSIVES_DRIVER_LICENCE).mockIf(false, this.moshi).invoke(TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_DANGEROUS_GOODS_LICENCE).mockIf(false, this.moshi).invoke(TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_BLASTING_EXPLOSIVES_LICENCE).mockIf(false, this.moshi).invoke(TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_HIGH_RISK_LICENCE).mockIf(false, this.moshi).invoke(TestHolding.Companion.worksafeWithoutPhotoUnsecured(SubType.WORKSAFE_CONSTRUCTION_INDUCTION_WHITE_CARD).mockIf(false, this.moshi).invoke(TestHolding.Companion.getWwcUnsecured().mockIf(false, this.moshi).invoke(TestHolding.Companion.getKangarooHarvesterUnsecured().mockIf(false, this.moshi).invoke(TestHoldingTemlatesKt.mockAllAuthorityUnsecuredTestTemplatesIfAuthorityAnd(false, this.moshi).invoke(TestHoldingTemlatesKt.mockAllCitizenUnsecuredTestTemplatesIfCitizenAnd(false, this.moshi).invoke(arrayList)))))))))))));
        if (!invoke.isEmpty()) {
            Single<List<SecureHolding>> fetchSecureHoldings = fetchSecureHoldings(invoke);
            Function1<List<SecureHolding>, List<SecureHolding>> mockAllCitizenSecureTestTemplatesIfCitizenAnd = TestHoldingTemlatesKt.mockAllCitizenSecureTestTemplatesIfCitizenAnd(false, this.moshi);
            if (mockAllCitizenSecureTestTemplatesIfCitizenAnd != null) {
                mockAllCitizenSecureTestTemplatesIfCitizenAnd = new HoldingsService$sam$io_reactivex_functions_Function$0(mockAllCitizenSecureTestTemplatesIfCitizenAnd);
            }
            Single<R> map = fetchSecureHoldings.map((Function) mockAllCitizenSecureTestTemplatesIfCitizenAnd);
            Function1<List<SecureHolding>, List<SecureHolding>> mockAllAuthoritySecureTestTemplatesIfAuthorityAnd = TestHoldingTemlatesKt.mockAllAuthoritySecureTestTemplatesIfAuthorityAnd(false, this.moshi);
            if (mockAllAuthoritySecureTestTemplatesIfAuthorityAnd != null) {
                mockAllAuthoritySecureTestTemplatesIfAuthorityAnd = new HoldingsService$sam$io_reactivex_functions_Function$0(mockAllAuthoritySecureTestTemplatesIfAuthorityAnd);
            }
            Single<R> map2 = map.map((Function) mockAllAuthoritySecureTestTemplatesIfAuthorityAnd);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf = TestHolding.Companion.getKangarooHarvesterSecure().mockIf(false, this.moshi);
            if (mockIf != null) {
                mockIf = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf);
            }
            Single<R> map3 = map2.map((Function) mockIf);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf2 = TestHolding.Companion.getWwcSecure().mockIf(false, this.moshi);
            if (mockIf2 != null) {
                mockIf2 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf2);
            }
            Single<R> map4 = map3.map((Function) mockIf2);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf3 = TestHolding.Companion.worksafeWithoutPhotoSecure(SubType.WORKSAFE_CONSTRUCTION_INDUCTION_WHITE_CARD).mockIf(false, this.moshi);
            if (mockIf3 != null) {
                mockIf3 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf3);
            }
            Single<R> map5 = map4.map((Function) mockIf3);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf4 = TestHolding.Companion.worksafeSecure(SubType.WORKSAFE_HIGH_RISK_LICENCE).mockIf(false, this.moshi);
            if (mockIf4 != null) {
                mockIf4 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf4);
            }
            Single<R> map6 = map5.map((Function) mockIf4);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf5 = TestHolding.Companion.worksafeSecure(SubType.WORKSAFE_BLASTING_EXPLOSIVES_LICENCE).mockIf(false, this.moshi);
            if (mockIf5 != null) {
                mockIf5 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf5);
            }
            Single<R> map7 = map6.map((Function) mockIf5);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf6 = TestHolding.Companion.worksafeSecure(SubType.WORKSAFE_DANGEROUS_GOODS_LICENCE).mockIf(false, this.moshi);
            if (mockIf6 != null) {
                mockIf6 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf6);
            }
            Single<R> map8 = map7.map((Function) mockIf6);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf7 = TestHolding.Companion.worksafeSecure(SubType.WORKSAFE_EXPLOSIVES_DRIVER_LICENCE).mockIf(false, this.moshi);
            if (mockIf7 != null) {
                mockIf7 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf7);
            }
            Single<R> map9 = map8.map((Function) mockIf7);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf8 = TestHolding.Companion.worksafeSecure(SubType.WORKSAFE_HIGH_CONSEQUENCE_DANGEROUS_GOODS_PERMIT).mockIf(false, this.moshi);
            if (mockIf8 != null) {
                mockIf8 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf8);
            }
            Single<R> map10 = map9.map((Function) mockIf8);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf9 = TestHolding.Companion.worksafeSecure(SubType.WORKSAFE_PYROTECHNICIANS_LICENCE).mockIf(false, this.moshi);
            if (mockIf9 != null) {
                mockIf9 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf9);
            }
            Single<R> map11 = map10.map((Function) mockIf9);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf10 = TestHolding.Companion.getAmbulanceVictoriaSecure().mockIf(false, this.moshi);
            if (mockIf10 != null) {
                mockIf10 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf10);
            }
            Single<R> map12 = map11.map((Function) mockIf10);
            Function1<List<? extends SecureHolding>, List<SecureHolding>> mockIf11 = TestHolding.Companion.getSolarSecure().mockIf(false, this.moshi);
            if (mockIf11 != null) {
                mockIf11 = new HoldingsService$sam$io_reactivex_functions_Function$0(mockIf11);
            }
            Single<R> doOnError = map12.map((Function) mockIf11).map(HoldingsService$refreshSecureHoldings$1.INSTANCE).zipWith(getLocalSecureHoldings(), HoldingsService$refreshSecureHoldings$2.INSTANCE).flatMap(new HoldingsService$refreshSecureHoldings$3(this)).flatMap(new HoldingsService$refreshSecureHoldings$4(this, invoke)).doOnError(new HoldingsService$refreshSecureHoldings$5(this));
            if (!z) {
                doOnError = doOnError.onErrorResumeNext(new HoldingsService$refreshSecureHoldings$$inlined$letIf$lambda$1(this));
            }
            Intrinsics.checkNotNullExpressionValue(doOnError, "fetchSecureHoldings(filt…ngs() }\n                }");
            return doOnError;
        }
        Single<List<SecureHolding>> single = this.dbService.clearSecuredHoldings().toSingle(HoldingsService$refreshSecureHoldings$7.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(single, "dbService.clearSecuredHo…tyList<SecureHolding>() }");
        return single;
    }

    public final Single<List<SecureHolding>> downloadAssets(List<SecureHolding> list, List<SecureHolding> list2) {
        Intrinsics.checkNotNullParameter(list, "synced");
        Intrinsics.checkNotNullParameter(list2, "stored");
        ArrayList<SecureHolding> arrayList = new ArrayList();
        for (T t : list) {
            if (t.getHoldingElements().getSupported()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (SecureHolding secureHolding : arrayList) {
            arrayList2 = preloadAsset(list2, secureHolding, arrayList2);
        }
        Single<List<SecureHolding>> map = Observable.merge(arrayList2).reduce(0, HoldingsService$downloadAssets$4.INSTANCE).map(new HoldingsService$downloadAssets$5(list));
        Intrinsics.checkNotNullExpressionValue(map, "synced\n            .filt…          .map { synced }");
        return map;
    }

    private final List<Observable<Asset>> preloadAsset(List<SecureHolding> list, SecureHolding secureHolding, List<Observable<Asset>> list2) {
        T t;
        T t2;
        List<Asset> assets;
        T t3;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getLink(), secureHolding.getLink())) {
                break;
            }
        }
        T t4 = t;
        List<Asset> assets2 = secureHolding.getAssets();
        if (assets2 != null) {
            ArrayList<Asset> arrayList = new ArrayList();
            for (T t5 : assets2) {
                T t6 = t5;
                if (t4 == null || (assets = t4.getAssets()) == null) {
                    t2 = null;
                } else {
                    Iterator<T> it2 = assets.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t3 = null;
                            break;
                        }
                        t3 = it2.next();
                        if (Intrinsics.areEqual(t6.getHash(), t3.getHash())) {
                            break;
                        }
                    }
                    t2 = t3;
                }
                if (t2 == null) {
                    arrayList.add(t5);
                }
            }
            for (Asset asset : arrayList) {
                Observable<Asset> observable = this.assetService.getBinaryFromNetworkCached(asset, 20).toObservable();
                Intrinsics.checkNotNullExpressionValue(observable, "retrieve.toObservable()");
                list2.add(observable);
            }
        }
        return list2;
    }

    public final Single<List<SecureHolding>> storeAndCleanUp(List<SecureHolding> list, List<? extends UnsecuredHolding> list2) {
        Intrinsics.checkNotNullParameter(list, "securedHoldings");
        Intrinsics.checkNotNullParameter(list2, "unsecuredHoldings");
        Single<List<SecureHolding>> single = this.dbService.clearSecuredHoldings().andThen(storeSecureHoldings(list, list2)).andThen(cleanUpAssets()).doOnError(new HoldingsService$sam$io_reactivex_functions_Consumer$0(new HoldingsService$storeAndCleanUp$1(RetrofitHelper.Companion))).toSingle(new HoldingsService$storeAndCleanUp$2(list));
        Intrinsics.checkNotNullExpressionValue(single, "dbService\n            .c…ingle { securedHoldings }");
        return single;
    }

    private final Completable cleanUpAssets() {
        Completable ignoreElement = getLocalSecureHoldings().observeOn(Schedulers.io()).map(new HoldingsService$cleanUpAssets$1(this)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "getLocalSecureHoldings()…         .ignoreElement()");
        return ignoreElement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.digitalwallet.app.holdings.HoldingsService$sam$i$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final Completable scheduleHoldingExpiryNotifications(List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            if (t2.getShouldUpdate() && t2.getShouldNotify()) {
                arrayList.add(t);
            }
        }
        ArrayList<UnsecuredHolding> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (UnsecuredHolding unsecuredHolding : arrayList2) {
            Completable scheduleNotification$app_citizenProdRelease = HoldingExpiryPublisher.Companion.scheduleNotification$app_citizenProdRelease(this.context, unsecuredHolding);
            HoldingsService$scheduleHoldingExpiryNotifications$2$1 holdingsService$scheduleHoldingExpiryNotifications$2$1 = HoldingsService$scheduleHoldingExpiryNotifications$2$1.INSTANCE;
            if (holdingsService$scheduleHoldingExpiryNotifications$2$1 != null) {
                holdingsService$scheduleHoldingExpiryNotifications$2$1 = new HoldingsService$sam$i$io_reactivex_functions_Consumer$0(holdingsService$scheduleHoldingExpiryNotifications$2$1);
            }
            arrayList3.add(scheduleNotification$app_citizenProdRelease.doOnError((Consumer) holdingsService$scheduleHoldingExpiryNotifications$2$1).onErrorComplete());
        }
        Completable concat = Completable.concat(arrayList3);
        Intrinsics.checkNotNullExpressionValue(concat, "Completable.concat(holdi…hole pipe.\n            })");
        return concat;
    }

    public final Completable deleteHoldingExpiryNotifications() {
        return HoldingExpiryPublisher.Companion.deleteNotificationChannel$app_citizenProdRelease(this.context);
    }
}
