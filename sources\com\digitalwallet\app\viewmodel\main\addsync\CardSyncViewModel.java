package com.digitalwallet.app.viewmodel.main.addsync;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.holdings.TestHolding;
import com.digitalwallet.app.holdings.TestHoldingTemlatesKt;
import com.digitalwallet.app.model.SubType;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.squareup.moshi.Moshi;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0019J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\rH\u0002J\b\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006&"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/addsync/CardSyncViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "moshi", "Lcom/squareup/moshi/Moshi;", "assetService", "Lcom/digitalwallet/app/services/AssetService;", "authenticationService", "Lcom/digitalwallet/app/oidc/AuthenticationService;", "(Lcom/digitalwallet/app/holdings/HoldingsService;Lcom/squareup/moshi/Moshi;Lcom/digitalwallet/app/services/AssetService;Lcom/digitalwallet/app/oidc/AuthenticationService;)V", "cardSyncList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardDetailItem;", "getCardSyncList", "()Landroidx/lifecycle/MutableLiveData;", "hasAnyCardSelected", "Landroidx/databinding/ObservableBoolean;", "getHasAnyCardSelected", "()Landroidx/databinding/ObservableBoolean;", "viewState", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardSyncViewState;", "getViewState", "performPrimaryBtnAction", "", "performSecondaryBtnAction", "refreshHoldings", "context", "Landroid/content/Context;", "setAutoSyncAndNickname", "showErrorState", "error", "", "storeSelectedHoldings", "holdings", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "updateHasAnyCardSelected", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CardSyncViewModel.kt */
public final class CardSyncViewModel extends BaseViewModel {
    private final AssetService assetService;
    private final AuthenticationService authenticationService;
    private final MutableLiveData<List<CardDetailItem>> cardSyncList = new MutableLiveData<>();
    private final ObservableBoolean hasAnyCardSelected = new ObservableBoolean(false);
    private final HoldingsService holdingsService;
    private final Moshi moshi;
    private final MutableLiveData<CardSyncViewState> viewState;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardSyncViewState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CardSyncViewState.HOLDINGS.ordinal()] = 1;
            iArr[CardSyncViewState.NO_HOLDINGS.ordinal()] = 2;
        }
    }

    @Inject
    public CardSyncViewModel(HoldingsService holdingsService2, Moshi moshi2, AssetService assetService2, AuthenticationService authenticationService2) {
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(assetService2, "assetService");
        Intrinsics.checkNotNullParameter(authenticationService2, "authenticationService");
        this.holdingsService = holdingsService2;
        this.moshi = moshi2;
        this.assetService = assetService2;
        this.authenticationService = authenticationService2;
        MutableLiveData<CardSyncViewState> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(CardSyncViewState.UPDATE_REQUESTED);
        Unit unit = Unit.INSTANCE;
        this.viewState = mutableLiveData;
    }

    public final MutableLiveData<CardSyncViewState> getViewState() {
        return this.viewState;
    }

    public final MutableLiveData<List<CardDetailItem>> getCardSyncList() {
        return this.cardSyncList;
    }

    public final void setAutoSyncAndNickname() {
        this.authenticationService.setAutoSyncAndNickname();
    }

    public final void performPrimaryBtnAction() {
        CardSyncViewState value = this.viewState.getValue();
        if (value != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i == 1) {
                List<CardDetailItem> value2 = this.cardSyncList.getValue();
                if (value2 != null) {
                    Intrinsics.checkNotNullExpressionValue(value2, "it");
                    List<CardDetailItem> list = value2;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getHolding());
                    }
                    storeSelectedHoldings(arrayList);
                    return;
                }
                return;
            } else if (i == 2) {
                this.viewState.setValue(CardSyncViewState.COMPLETE);
                return;
            }
        }
        Timber.w("Primary Button did not expect " + this.viewState.getValue() + " state", new Object[0]);
    }

    public final void performSecondaryBtnAction() {
        this.viewState.setValue(CardSyncViewState.UPDATE_REQUESTED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v67, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v18, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v19, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v20, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v21, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v22, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v23, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v24, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v25, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v26, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v27, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v28, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARN: Type inference failed for: r4v29, types: [com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$sam$io_reactivex_functions_Function$0] */
    /* JADX WARNING: Unknown variable types count: 13 */
    public final void refreshHoldings(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewState.setValue(CardSyncViewState.LOADING);
        CompositeDisposable compositeDisposable = getCompositeDisposable();
        Single<List<UnsecuredHolding>> refreshUnsecuredHoldings = this.holdingsService.refreshUnsecuredHoldings(false, true);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockAllCitizenUnsecuredTestTemplatesIfCitizenAnd = TestHoldingTemlatesKt.mockAllCitizenUnsecuredTestTemplatesIfCitizenAnd(false, this.moshi);
        if (mockAllCitizenUnsecuredTestTemplatesIfCitizenAnd != null) {
            mockAllCitizenUnsecuredTestTemplatesIfCitizenAnd = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockAllCitizenUnsecuredTestTemplatesIfCitizenAnd);
        }
        Single<R> map = refreshUnsecuredHoldings.map((Function) mockAllCitizenUnsecuredTestTemplatesIfCitizenAnd);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockAllAuthorityUnsecuredTestTemplatesIfAuthorityAnd = TestHoldingTemlatesKt.mockAllAuthorityUnsecuredTestTemplatesIfAuthorityAnd(false, this.moshi);
        if (mockAllAuthorityUnsecuredTestTemplatesIfAuthorityAnd != null) {
            mockAllAuthorityUnsecuredTestTemplatesIfAuthorityAnd = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockAllAuthorityUnsecuredTestTemplatesIfAuthorityAnd);
        }
        Single<R> map2 = map.map((Function) mockAllAuthorityUnsecuredTestTemplatesIfAuthorityAnd);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf = TestHolding.Companion.getKangarooHarvesterUnsecured().mockIf(false, this.moshi);
        if (mockIf != null) {
            mockIf = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf);
        }
        Single<R> map3 = map2.map((Function) mockIf);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf2 = TestHolding.Companion.getWwcUnsecured().mockIf(false, this.moshi);
        if (mockIf2 != null) {
            mockIf2 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf2);
        }
        Single<R> map4 = map3.map((Function) mockIf2);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf3 = TestHolding.Companion.worksafeWithoutPhotoUnsecured(SubType.WORKSAFE_CONSTRUCTION_INDUCTION_WHITE_CARD).mockIf(false, this.moshi);
        if (mockIf3 != null) {
            mockIf3 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf3);
        }
        Single<R> map5 = map4.map((Function) mockIf3);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf4 = TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_HIGH_RISK_LICENCE).mockIf(false, this.moshi);
        if (mockIf4 != null) {
            mockIf4 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf4);
        }
        Single<R> map6 = map5.map((Function) mockIf4);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf5 = TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_BLASTING_EXPLOSIVES_LICENCE).mockIf(false, this.moshi);
        if (mockIf5 != null) {
            mockIf5 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf5);
        }
        Single<R> map7 = map6.map((Function) mockIf5);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf6 = TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_DANGEROUS_GOODS_LICENCE).mockIf(false, this.moshi);
        if (mockIf6 != null) {
            mockIf6 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf6);
        }
        Single<R> map8 = map7.map((Function) mockIf6);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf7 = TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_EXPLOSIVES_DRIVER_LICENCE).mockIf(false, this.moshi);
        if (mockIf7 != null) {
            mockIf7 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf7);
        }
        Single<R> map9 = map8.map((Function) mockIf7);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf8 = TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_HIGH_CONSEQUENCE_DANGEROUS_GOODS_PERMIT).mockIf(false, this.moshi);
        if (mockIf8 != null) {
            mockIf8 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf8);
        }
        Single<R> map10 = map9.map((Function) mockIf8);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf9 = TestHolding.Companion.worksafeUnsecured(SubType.WORKSAFE_PYROTECHNICIANS_LICENCE).mockIf(false, this.moshi);
        if (mockIf9 != null) {
            mockIf9 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf9);
        }
        Single<R> map11 = map10.map((Function) mockIf9);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf10 = TestHolding.Companion.getAmbulanceVictoriaUnsecured().mockIf(false, this.moshi);
        if (mockIf10 != null) {
            mockIf10 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf10);
        }
        Single<R> map12 = map11.map((Function) mockIf10);
        Function1<List<? extends UnsecuredHolding>, List<UnsecuredHolding>> mockIf11 = TestHolding.Companion.getSolarUnsecured().mockIf(false, this.moshi);
        if (mockIf11 != null) {
            mockIf11 = new CardSyncViewModel$sam$io_reactivex_functions_Function$0(mockIf11);
        }
        compositeDisposable.add(map12.map((Function) mockIf11).zipWith(this.holdingsService.getLocalSecureHoldings(), CardSyncViewModel$refreshHoldings$1.INSTANCE).flatMap(new CardSyncViewModel$refreshHoldings$2(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new CardSyncViewModel$refreshHoldings$3(this, context)).subscribe(new CardSyncViewModel$refreshHoldings$4(this), new CardSyncViewModel$sam$io_reactivex_functions_Consumer$0(new CardSyncViewModel$refreshHoldings$5(this))));
    }

    public final ObservableBoolean getHasAnyCardSelected() {
        return this.hasAnyCardSelected;
    }

    /* access modifiers changed from: private */
    public final void updateHasAnyCardSelected() {
        ObservableBoolean observableBoolean = this.hasAnyCardSelected;
        List<CardDetailItem> value = this.cardSyncList.getValue();
        CardDetailItem cardDetailItem = null;
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (next.getShouldUpdate().get()) {
                    cardDetailItem = next;
                    break;
                }
            }
            cardDetailItem = cardDetailItem;
        }
        observableBoolean.set(cardDetailItem != null);
    }

    private final void storeSelectedHoldings(List<? extends UnsecuredHolding> list) {
        this.viewState.setValue(CardSyncViewState.STORING);
        getCompositeDisposable().addAll(this.holdingsService.storeUnsecuredHoldings(list).subscribeOn(Schedulers.io()).andThen(this.holdingsService.refreshSecureHoldings(list, true)).observeOn(AndroidSchedulers.mainThread()).subscribe(new CardSyncViewModel$storeSelectedHoldings$1(this), new CardSyncViewModel$sam$io_reactivex_functions_Consumer$0(new CardSyncViewModel$storeSelectedHoldings$2(this))), this.holdingsService.scheduleHoldingExpiryNotifications(list).subscribe());
    }

    /* access modifiers changed from: private */
    public final void showErrorState(Throwable th) {
        Timber.e(th);
        this.viewState.setValue(CardSyncViewState.ERROR);
    }
}
