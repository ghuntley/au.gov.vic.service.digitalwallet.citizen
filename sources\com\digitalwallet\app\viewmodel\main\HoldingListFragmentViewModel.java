package com.digitalwallet.app.viewmodel.main;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.services.BluetoothEventsService;
import com.digitalwallet.app.view.util.CardListScreenState;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.util.SpannableTextKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import io.reactivex.Flowable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001f\u0010#\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001f\u0010%\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u00060"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/HoldingListFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "holdingService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "bluetoothEventsService", "Lcom/digitalwallet/app/services/BluetoothEventsService;", "(Landroid/content/Context;Lcom/digitalwallet/app/holdings/HoldingsService;Lcom/digitalwallet/app/services/BluetoothEventsService;)V", "bluetoothServiceRunning", "Landroidx/databinding/ObservableBoolean;", "getBluetoothServiceRunning", "()Landroidx/databinding/ObservableBoolean;", "downloadExistingHoldingsDescription", "Landroid/text/SpannableStringBuilder;", "getDownloadExistingHoldingsDescription", "()Landroid/text/SpannableStringBuilder;", "hasHoldings", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getHasHoldings", "()Landroidx/databinding/ObservableField;", "isCitizen", "()Z", "moreInfoAboutCardsDescription", "getMoreInfoAboutCardsDescription", "sharesRequest", "Lio/reactivex/subjects/PublishSubject;", "getSharesRequest", "()Lio/reactivex/subjects/PublishSubject;", "sharingTitle", "", "getSharingTitle", "()I", "showLoadingHUD", "getShowLoadingHUD", "showRecyclerView", "getShowRecyclerView", "requestAllSecureHoldings", "Lio/reactivex/Flowable;", "", "Lcom/digitalwallet/app/model/SecureHolding;", "setScreenState", "", "cardListScreenState", "Lcom/digitalwallet/app/view/util/CardListScreenState;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingListFragmentViewModel.kt */
public final class HoldingListFragmentViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion(null);
    private static final List<SecureHolding> DEFAULT_NO_HOLDINGS = CollectionsKt.listOf(new SecureHolding(null, new HoldingRecordAttributes(null, null, null, null, "LICENCE", HoldingType.ADD_A_CARD.name(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217679, null), null, null, null, null, 61, null));
    private final BluetoothEventsService bluetoothEventsService;
    private final SpannableStringBuilder downloadExistingHoldingsDescription;
    private final ObservableField<Boolean> hasHoldings;
    private final HoldingsService holdingService;
    private final boolean isCitizen;
    private final SpannableStringBuilder moreInfoAboutCardsDescription;
    private final PublishSubject<Boolean> sharesRequest;
    private final int sharingTitle;
    private final ObservableField<Boolean> showLoadingHUD = new ObservableField<>((Boolean) true);
    private final ObservableField<Boolean> showRecyclerView = new ObservableField<>((Boolean) false);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AppType.CITIZEN.ordinal()] = 1;
            iArr[AppType.AUTHORITY.ordinal()] = 2;
        }
    }

    @Inject
    public HoldingListFragmentViewModel(Context context, HoldingsService holdingsService, BluetoothEventsService bluetoothEventsService2) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holdingsService, "holdingService");
        Intrinsics.checkNotNullParameter(bluetoothEventsService2, "bluetoothEventsService");
        this.holdingService = holdingsService;
        this.bluetoothEventsService = bluetoothEventsService2;
        boolean z = false;
        PublishSubject<Boolean> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.sharesRequest = create;
        this.isCitizen = ServerTypeKt.getAppType() == AppType.CITIZEN ? true : z;
        int i2 = WhenMappings.$EnumSwitchMapping$0[ServerTypeKt.getAppType().ordinal()];
        if (i2 == 1) {
            i = R.string.list_drawer_title_citizen;
        } else if (i2 == 2) {
            i = R.string.list_drawer_title_authority;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.sharingTitle = i;
        this.hasHoldings = new ObservableField<>((Boolean) false);
        this.downloadExistingHoldingsDescription = SpannableTextKt.getDWStyleSpannableStringBuilder(context, R.string.download_existing_holdings, R.string.tap_here, HoldingListFragmentViewModel$downloadExistingHoldingsDescription$1.INSTANCE);
        this.moreInfoAboutCardsDescription = SpannableTextKt.getDWStyleSpannableStringBuilder(context, R.string.more_info_about_cards, R.string.tap_here, HoldingListFragmentViewModel$moreInfoAboutCardsDescription$1.INSTANCE);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/HoldingListFragmentViewModel$Companion;", "", "()V", "DEFAULT_NO_HOLDINGS", "", "Lcom/digitalwallet/app/model/SecureHolding;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingListFragmentViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final ObservableField<Boolean> getShowRecyclerView() {
        return this.showRecyclerView;
    }

    public final ObservableField<Boolean> getShowLoadingHUD() {
        return this.showLoadingHUD;
    }

    public final PublishSubject<Boolean> getSharesRequest() {
        return this.sharesRequest;
    }

    public final boolean isCitizen() {
        return this.isCitizen;
    }

    public final int getSharingTitle() {
        return this.sharingTitle;
    }

    public final ObservableField<Boolean> getHasHoldings() {
        return this.hasHoldings;
    }

    public final ObservableBoolean getBluetoothServiceRunning() {
        return this.bluetoothEventsService.getServiceRunning();
    }

    public final SpannableStringBuilder getDownloadExistingHoldingsDescription() {
        return this.downloadExistingHoldingsDescription;
    }

    public final SpannableStringBuilder getMoreInfoAboutCardsDescription() {
        return this.moreInfoAboutCardsDescription;
    }

    public final Flowable<List<SecureHolding>> requestAllSecureHoldings() {
        Flowable<R> map = this.holdingService.getLocalSecureHoldings().mergeWith(HoldingsService.refreshUnsecuredHoldings$default(this.holdingService, false, false, 3, null).flatMap(new HoldingListFragmentViewModel$requestAllSecureHoldings$1(this))).doOnNext(new HoldingListFragmentViewModel$requestAllSecureHoldings$2(this)).map(HoldingListFragmentViewModel$requestAllSecureHoldings$3.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "holdingService.getLocalS…{ DEFAULT_NO_HOLDINGS } }");
        return map;
    }

    public final void setScreenState(CardListScreenState cardListScreenState) {
        Intrinsics.checkNotNullParameter(cardListScreenState, "cardListScreenState");
        if (Intrinsics.areEqual(cardListScreenState, CardListScreenState.Loading.INSTANCE)) {
            this.showLoadingHUD.set(true);
            this.showRecyclerView.set(false);
        } else if (Intrinsics.areEqual(cardListScreenState, CardListScreenState.ShowCardList.INSTANCE)) {
            this.showLoadingHUD.set(false);
            this.showRecyclerView.set(true);
        }
    }
}
