package com.digitalwallet.app.viewmodel.login;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.BuildConfig;
import com.digitalwallet.app.model.login.SVItem;
import com.digitalwallet.app.model.login.SVService;
import com.digitalwallet.app.model.login.SVServices;
import com.digitalwallet.app.services.SimpleAssetService;
import com.digitalwallet.app.viewmodel.svservices.SVItemViewModel;
import com.digitalwallet.app.viewmodel.svservices.TitleActionVM;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteCellViewModel;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010:\u001a\u00020%2\b\u0010;\u001a\u0004\u0018\u00010\u00132\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0006\u0010=\u001a\u00020%J\u0006\u0010>\u001a\u00020%J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u000e2\b\u0010A\u001a\u0004\u0018\u00010\u0013J\u0006\u0010B\u001a\u00020%J\u0006\u0010C\u001a\u00020%J\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u000e2\b\u0010A\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R'\u0010\"\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#j\b\u0012\u0004\u0012\u00020%`&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R'\u0010)\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#j\b\u0012\u0004\u0012\u00020%`&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R'\u0010+\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#j\b\u0012\u0004\u0012\u00020%`&¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R'\u0010-\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0$0#j\b\u0012\u0004\u0012\u00020.`&¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R'\u00100\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002010$0#j\b\u0012\u0004\u0012\u000201`&¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u001f\u00103\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010 0 0\u0017¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R'\u00106\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002010$0#j\b\u0012\u0004\u0012\u000201`&¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R'\u00108\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0$0#j\b\u0012\u0004\u0012\u00020\u000f`&¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(¨\u0006F"}, d2 = {"Lcom/digitalwallet/app/viewmodel/login/HomeServicesViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "moshi", "Lcom/squareup/moshi/Moshi;", "context", "Landroid/content/Context;", "simpleAssetService", "Lcom/digitalwallet/app/services/SimpleAssetService;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Lcom/squareup/moshi/Moshi;Landroid/content/Context;Lcom/digitalwallet/app/services/SimpleAssetService;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "cachedSVServicesFilename", "", "checkInFavourites", "", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "getCheckInRepository", "()Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "fallbackSVServices", "Lcom/digitalwallet/app/model/login/SVServices;", "getFallbackSVServices", "()Lcom/digitalwallet/app/model/login/SVServices;", "favouriteCellVMs", "Landroidx/databinding/ObservableField;", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/FavouriteCellViewModel;", "getFavouriteCellVMs", "()Landroidx/databinding/ObservableField;", "fetchLatestSVServices", "Lio/reactivex/Single;", "getFetchLatestSVServices", "()Lio/reactivex/Single;", "isCitizen", "", "()Z", "navigateToCheckInFavourites", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getNavigateToCheckInFavourites", "()Landroidx/lifecycle/MutableLiveData;", "navigateToCheckInHistory", "getNavigateToCheckInHistory", "navigateToCheckInScanner", "getNavigateToCheckInScanner", "navigateToGroupCategoriesEvent", "Lcom/digitalwallet/app/model/login/SVService;", "getNavigateToGroupCategoriesEvent", "openURLEvent", "Lcom/digitalwallet/app/model/login/SVItem;", "getOpenURLEvent", "showLogin", "kotlin.jvm.PlatformType", "getShowLogin", "startChromeEvent", "getStartChromeEvent", "toCheckInToAFavourite", "getToCheckInToAFavourite", "cleanupOldSVServicesImageCaches", "oldSVServices", "latestSVServices", "onCheckIn", "refreshCheckInFavourites", "serviceGroupVMs", "Lcom/digitalwallet/app/viewmodel/svservices/TitleActionVM;", "allSVServices", "toCheckInFavourites", "toCheckInHistory", "topCarouselVMs", "Lcom/digitalwallet/app/viewmodel/svservices/SVItemViewModel;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HomeServicesViewModel.kt */
public final class HomeServicesViewModel extends BaseViewModel {
    private final String cachedSVServicesFilename;
    private List<CheckInUtils.CheckInCode> checkInFavourites;
    private final CheckInRepository checkInRepository;
    private final Context context;
    private final SVServices fallbackSVServices;
    private final ObservableField<List<FavouriteCellViewModel>> favouriteCellVMs;
    private final Single<SVServices> fetchLatestSVServices;
    private final boolean isCitizen;
    private final Moshi moshi;
    private final MutableLiveData<ActionEvent<Unit>> navigateToCheckInFavourites;
    private final MutableLiveData<ActionEvent<Unit>> navigateToCheckInHistory;
    private final MutableLiveData<ActionEvent<Unit>> navigateToCheckInScanner;
    private final MutableLiveData<ActionEvent<SVService>> navigateToGroupCategoriesEvent;
    private final MutableLiveData<ActionEvent<SVItem>> openURLEvent;
    private final ObservableField<Boolean> showLogin;
    private final SimpleAssetService simpleAssetService;
    private final MutableLiveData<ActionEvent<SVItem>> startChromeEvent;
    private final MutableLiveData<ActionEvent<CheckInUtils.CheckInCode>> toCheckInToAFavourite;

    public final CheckInRepository getCheckInRepository() {
        return this.checkInRepository;
    }

    @Inject
    public HomeServicesViewModel(Moshi moshi2, Context context2, SimpleAssetService simpleAssetService2, CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(simpleAssetService2, "simpleAssetService");
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.moshi = moshi2;
        this.context = context2;
        this.simpleAssetService = simpleAssetService2;
        this.checkInRepository = checkInRepository2;
        this.isCitizen = ServerTypeKt.getAppType() == AppType.CITIZEN;
        this.showLogin = new ObservableField<>((Boolean) false);
        this.checkInFavourites = CollectionsKt.emptyList();
        this.favouriteCellVMs = new ObservableField<>(CollectionsKt.emptyList());
        this.navigateToCheckInScanner = new MutableLiveData<>();
        this.navigateToCheckInFavourites = new MutableLiveData<>();
        this.navigateToCheckInHistory = new MutableLiveData<>();
        this.toCheckInToAFavourite = new MutableLiveData<>();
        this.startChromeEvent = new MutableLiveData<>();
        this.openURLEvent = new MutableLiveData<>();
        this.navigateToGroupCategoriesEvent = new MutableLiveData<>();
        this.cachedSVServicesFilename = "sv_services_cache";
        Object obj = null;
        try {
            String readText$default = FilesKt.readText$default(SimpleAssetService.access$getFile(simpleAssetService2, "sv_services_cache"), null, 1, null);
            JsonAdapter adapter = SimpleAssetService.access$getMoshi$p(simpleAssetService2).adapter(SVServices.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            obj = adapter.fromJson(readText$default);
        } catch (Exception unused) {
        }
        SVServices sVServices = (SVServices) obj;
        this.fallbackSVServices = sVServices == null ? (SVServices) new HomeServicesViewModel$fallbackSVServices$1(this).invoke() : sVServices;
        Single create = Single.create(new HomeServicesViewModel$$special$$inlined$getModelFromUrl$app_citizenProdRelease$1(this.simpleAssetService, BuildConfig.SV_SERVICES_CONFIG_FILE));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …vices!!)\n        })\n    }");
        Single<SVServices> doOnSuccess = create.doOnSuccess(new HomeServicesViewModel$fetchLatestSVServices$1(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "simpleAssetService\n     …rvices, it)\n            }");
        this.fetchLatestSVServices = doOnSuccess;
    }

    public final boolean isCitizen() {
        return this.isCitizen;
    }

    public final ObservableField<Boolean> getShowLogin() {
        return this.showLogin;
    }

    public final ObservableField<List<FavouriteCellViewModel>> getFavouriteCellVMs() {
        return this.favouriteCellVMs;
    }

    public final MutableLiveData<ActionEvent<Unit>> getNavigateToCheckInScanner() {
        return this.navigateToCheckInScanner;
    }

    public final MutableLiveData<ActionEvent<Unit>> getNavigateToCheckInFavourites() {
        return this.navigateToCheckInFavourites;
    }

    public final MutableLiveData<ActionEvent<Unit>> getNavigateToCheckInHistory() {
        return this.navigateToCheckInHistory;
    }

    public final MutableLiveData<ActionEvent<CheckInUtils.CheckInCode>> getToCheckInToAFavourite() {
        return this.toCheckInToAFavourite;
    }

    public final void refreshCheckInFavourites() {
        List<CheckInUtils.CheckInCode> take = CollectionsKt.take(this.checkInRepository.getCheckInShortcuts().getFavourites(), 6);
        if (!Intrinsics.areEqual(this.checkInFavourites, take)) {
            this.checkInFavourites = take;
            ObservableField<List<FavouriteCellViewModel>> observableField = this.favouriteCellVMs;
            List<CheckInUtils.CheckInCode> list = take;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(new FavouriteCellViewModel(t, new HomeServicesViewModel$refreshCheckInFavourites$$inlined$map$lambda$1(t, this)));
            }
            observableField.set(arrayList);
        }
    }

    public final void onCheckIn() {
        ActionEventKt.post(this.navigateToCheckInScanner);
    }

    public final void toCheckInFavourites() {
        ActionEventKt.post(this.navigateToCheckInFavourites);
    }

    public final void toCheckInHistory() {
        ActionEventKt.post(this.navigateToCheckInHistory);
    }

    public final MutableLiveData<ActionEvent<SVItem>> getStartChromeEvent() {
        return this.startChromeEvent;
    }

    public final MutableLiveData<ActionEvent<SVItem>> getOpenURLEvent() {
        return this.openURLEvent;
    }

    public final MutableLiveData<ActionEvent<SVService>> getNavigateToGroupCategoriesEvent() {
        return this.navigateToGroupCategoriesEvent;
    }

    public final SVServices getFallbackSVServices() {
        return this.fallbackSVServices;
    }

    public final Single<SVServices> getFetchLatestSVServices() {
        return this.fetchLatestSVServices;
    }

    public final List<SVItemViewModel> topCarouselVMs(SVServices sVServices) {
        List<SVItem> sortedCarouselItems;
        if (sVServices == null || (sortedCarouselItems = sVServices.getSortedCarouselItems()) == null) {
            return CollectionsKt.emptyList();
        }
        List<SVItem> list = sortedCarouselItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new SVItemViewModel(t, this.simpleAssetService, new HomeServicesViewModel$topCarouselVMs$$inlined$map$lambda$1(t, this)));
        }
        return arrayList;
    }

    public final List<TitleActionVM> serviceGroupVMs(SVServices sVServices) {
        List<SVService> sortedServiceGroups;
        if (sVServices == null || (sortedServiceGroups = sVServices.getSortedServiceGroups()) == null) {
            return CollectionsKt.emptyList();
        }
        List<SVService> list = sortedServiceGroups;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            HomeServicesViewModel$serviceGroupVMs$$inlined$map$lambda$1 homeServicesViewModel$serviceGroupVMs$$inlined$map$lambda$1 = new HomeServicesViewModel$serviceGroupVMs$$inlined$map$lambda$1(t, this);
            String title = t.getTitle();
            if (title == null) {
                title = "";
            }
            arrayList.add(new TitleActionVM(title, false, homeServicesViewModel$serviceGroupVMs$$inlined$map$lambda$1));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void cleanupOldSVServicesImageCaches(SVServices sVServices, SVServices sVServices2) {
        List<String> allImageUrlCacheNames;
        if (!(sVServices == null || (allImageUrlCacheNames = sVServices.getAllImageUrlCacheNames()) == null)) {
            ArrayList<String> arrayList = new ArrayList();
            for (T t : allImageUrlCacheNames) {
                if (!sVServices2.getAllImageUrlCacheNames().contains(t)) {
                    arrayList.add(t);
                }
            }
            for (String str : arrayList) {
                this.simpleAssetService.deleteFile(str);
            }
        }
    }
}
