package com.digitalwallet.app.viewmodel.main.sharing;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.connection.BLEClient;
import com.digitalwallet.app.connection.HoldingRequestState;
import com.digitalwallet.app.connection.NamedDevice;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.RetrofitHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxrelay2.PublishRelay;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jwt.SignedJWT;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u000200J\u001c\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0006\u0010;\u001a\u000203J\u0016\u0010<\u001a\u0002032\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0002J\u000e\u0010@\u001a\u00020A2\u0006\u0010/\u001a\u000200J\u0018\u0010B\u001a\u0002032\u0006\u00107\u001a\u0002082\u0006\u0010C\u001a\u00020DH\u0002J\u001a\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Dj\u0002`G2\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u000203J\u000e\u0010K\u001a\u00020A2\u0006\u0010/\u001a\u000200J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u000206H\u0002J\u001a\u0010N\u001a\u0002032\u0010\u0010O\u001a\f\u0012\u0004\u0012\u00020Q0Pj\u0002`RH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001f\u0010#\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001f\u0010%\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001f\u0010'\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001f\u0010/\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u000100000\u0014¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0018¨\u0006S"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "holdingParser", "Lcom/digitalwallet/app/holdings/HoldingParser;", "assetService", "Lcom/digitalwallet/app/services/AssetService;", "transactionHistoryService", "Lcom/digitalwallet/app/services/TransactionSharesService;", "appStartUp", "Lcom/digitalwallet/app/AppStartUp;", "bleClient", "Lcom/digitalwallet/app/connection/BLEClient;", "(Lcom/digitalwallet/utilities/AnalyticsHelper;Lcom/digitalwallet/app/holdings/HoldingsService;Lcom/digitalwallet/app/holdings/HoldingParser;Lcom/digitalwallet/app/services/AssetService;Lcom/digitalwallet/app/services/TransactionSharesService;Lcom/digitalwallet/app/AppStartUp;Lcom/digitalwallet/app/connection/BLEClient;)V", "getBleClient", "()Lcom/digitalwallet/app/connection/BLEClient;", "btnText", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getBtnText", "()Landroidx/databinding/ObservableField;", "requestListener", "Lio/reactivex/disposables/Disposable;", "getRequestListener", "()Lio/reactivex/disposables/Disposable;", "setRequestListener", "(Lio/reactivex/disposables/Disposable;)V", "showBtn", "Landroidx/databinding/ObservableBoolean;", "getShowBtn", "()Landroidx/databinding/ObservableBoolean;", "subtitleText", "getSubtitleText", "titleImg", "getTitleImg", "titleText", "getTitleText", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentView;", "getView", "()Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentView;", "setView", "(Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentView;)V", "viewState", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "getViewState", "changeState", "", "state", "getRecord", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "status", "Lcom/digitalwallet/app/model/HoldingResponseStatus;", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "handleBtnPress", "holdingReceived", FirebaseAnalytics.Event.SHARE, "Lcom/digitalwallet/app/model/P2PMessage;", "Lcom/digitalwallet/app/model/ShareHolding;", "isLoading", "", "postTransaction", "holdingName", "", "requestHolding", RequestHolding.sharingCodeKey, "Lcom/digitalwallet/app/model/SharingCode;", "member", "Lcom/digitalwallet/app/connection/NamedDevice;", "scan", "showUsers", "storeShareRecord", "record", "watchRequestState", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "Lcom/digitalwallet/app/connection/HoldingRequestListener;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LobbyFragmentViewModel.kt */
public final class LobbyFragmentViewModel extends BaseViewModel {
    private final AnalyticsHelper analytics;
    private AppStartUp appStartUp;
    private final AssetService assetService;
    private final BLEClient bleClient;
    private final ObservableField<Integer> btnText = new ObservableField<>(Integer.valueOf((int) R.string.request_cancel));
    private final HoldingParser holdingParser;
    private final HoldingsService holdingsService;
    private Disposable requestListener;
    private final ObservableBoolean showBtn = new ObservableBoolean(true);
    private final ObservableField<Integer> subtitleText = new ObservableField<>(Integer.valueOf((int) R.string.request_searching_subtitle));
    private final ObservableField<Integer> titleImg = new ObservableField<>((Integer) 0);
    private final ObservableField<Integer> titleText = new ObservableField<>(Integer.valueOf((int) R.string.request_searching));
    private TransactionSharesService transactionHistoryService;
    public LobbyFragmentView view;
    private final ObservableField<LobbyViewState> viewState = new ObservableField<>(new LobbyViewState.Searching());

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HoldingResponseStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HoldingResponseStatus.DENIED.ordinal()] = 1;
            iArr[HoldingResponseStatus.ACCEPTED.ordinal()] = 2;
            int[] iArr2 = new int[HoldingResponseStatus.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[HoldingResponseStatus.ACCEPTED.ordinal()] = 1;
            iArr2[HoldingResponseStatus.DENIED.ordinal()] = 2;
        }
    }

    public final BLEClient getBleClient() {
        return this.bleClient;
    }

    @Inject
    public LobbyFragmentViewModel(AnalyticsHelper analyticsHelper, HoldingsService holdingsService2, HoldingParser holdingParser2, AssetService assetService2, TransactionSharesService transactionSharesService, AppStartUp appStartUp2, BLEClient bLEClient) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        Intrinsics.checkNotNullParameter(holdingParser2, "holdingParser");
        Intrinsics.checkNotNullParameter(assetService2, "assetService");
        Intrinsics.checkNotNullParameter(transactionSharesService, "transactionHistoryService");
        Intrinsics.checkNotNullParameter(appStartUp2, "appStartUp");
        Intrinsics.checkNotNullParameter(bLEClient, "bleClient");
        this.analytics = analyticsHelper;
        this.holdingsService = holdingsService2;
        this.holdingParser = holdingParser2;
        this.assetService = assetService2;
        this.transactionHistoryService = transactionSharesService;
        this.appStartUp = appStartUp2;
        this.bleClient = bLEClient;
    }

    public final LobbyFragmentView getView() {
        LobbyFragmentView lobbyFragmentView = this.view;
        if (lobbyFragmentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        return lobbyFragmentView;
    }

    public final void setView(LobbyFragmentView lobbyFragmentView) {
        Intrinsics.checkNotNullParameter(lobbyFragmentView, "<set-?>");
        this.view = lobbyFragmentView;
    }

    public final ObservableField<LobbyViewState> getViewState() {
        return this.viewState;
    }

    public final ObservableField<Integer> getTitleText() {
        return this.titleText;
    }

    public final ObservableField<Integer> getTitleImg() {
        return this.titleImg;
    }

    public final ObservableField<Integer> getSubtitleText() {
        return this.subtitleText;
    }

    public final ObservableField<Integer> getBtnText() {
        return this.btnText;
    }

    public final ObservableBoolean getShowBtn() {
        return this.showBtn;
    }

    public final boolean isLoading(LobbyViewState lobbyViewState) {
        Intrinsics.checkNotNullParameter(lobbyViewState, "viewState");
        return RequestElementsKt.getElements(lobbyViewState).isLoading();
    }

    public final boolean showUsers(LobbyViewState lobbyViewState) {
        Intrinsics.checkNotNullParameter(lobbyViewState, "viewState");
        return lobbyViewState instanceof LobbyViewState.FoundUser;
    }

    public final Disposable getRequestListener() {
        return this.requestListener;
    }

    public final void setRequestListener(Disposable disposable) {
        this.requestListener = disposable;
    }

    public final void handleBtnPress() {
        LobbyViewState lobbyViewState = this.viewState.get();
        if (lobbyViewState instanceof LobbyViewState.RequestDenied) {
            LobbyFragmentView lobbyFragmentView = this.view;
            if (lobbyFragmentView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
            }
            lobbyFragmentView.retryRequested();
        } else if (lobbyViewState instanceof LobbyViewState.NoneFound) {
            LobbyFragmentView lobbyFragmentView2 = this.view;
            if (lobbyFragmentView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
            }
            lobbyFragmentView2.retryScan();
        } else {
            LobbyFragmentView lobbyFragmentView3 = this.view;
            if (lobbyFragmentView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
            }
            lobbyFragmentView3.requestCancelled();
        }
    }

    public final void scan() {
        LobbyFragmentView lobbyFragmentView = this.view;
        if (lobbyFragmentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        lobbyFragmentView.retryScan();
    }

    public final void requestHolding(String str, NamedDevice namedDevice) {
        Intrinsics.checkNotNullParameter(str, RequestHolding.sharingCodeKey);
        Intrinsics.checkNotNullParameter(namedDevice, "member");
        Disposable subscribe = this.holdingsService.getLocalSecureHoldings().subscribeOn(Schedulers.io()).flatMapCompletable(new LobbyFragmentViewModel$requestHolding$1(this, str, namedDevice)).subscribeOn(AndroidSchedulers.mainThread()).doOnError(new LobbyFragmentViewModel$requestHolding$2(this)).subscribe();
        if (subscribe != null) {
            getCompositeDisposable().add(subscribe);
        }
    }

    /* access modifiers changed from: private */
    public final void watchRequestState(PublishRelay<HoldingRequestState> publishRelay) {
        Disposable disposable = this.requestListener;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable subscribe = publishRelay.subscribe(new LobbyFragmentViewModel$watchRequestState$1(this), new LobbyFragmentViewModel$watchRequestState$2(this));
        getCompositeDisposable().add(subscribe);
        Unit unit = Unit.INSTANCE;
        this.requestListener = subscribe;
    }

    /* access modifiers changed from: private */
    public final void holdingReceived(P2PMessage<ShareHolding> p2PMessage) {
        LobbyFragmentViewModel$holdingReceived$doFinally$1 lobbyFragmentViewModel$holdingReceived$doFinally$1 = new LobbyFragmentViewModel$holdingReceived$doFinally$1(this, p2PMessage);
        ShareHolding contents = p2PMessage.getBody().getContents();
        HoldingResponseStatus holdingResponseStatus = contents.getHoldingResponseStatus();
        if (holdingResponseStatus == HoldingResponseStatus.DENIED) {
            lobbyFragmentViewModel$holdingReceived$doFinally$1.invoke(holdingResponseStatus, (Object) null);
            return;
        }
        SignedJWT holding = contents.getHolding();
        if (holding != null) {
            try {
                JWKSet issuerKeys = this.appStartUp.getIssuerKeys();
                if (issuerKeys == null) {
                    throw new Exception("No issuerKeys.");
                } else if (this.holdingParser.validate(holding, issuerKeys)) {
                    SecureHolding parseHolding = this.holdingParser.parseHolding(holding);
                    List<byte[]> assetData = contents.getAssetData();
                    if (assetData != null) {
                        AssetService assetService2 = this.assetService;
                        for (byte[] bArr : assetData) {
                            assetService2.storeAssetData(bArr);
                        }
                    }
                    lobbyFragmentViewModel$holdingReceived$doFinally$1.invoke((Object) holdingResponseStatus, (Object) parseHolding);
                } else {
                    throw new Exception("Invalid holding.");
                }
            } catch (Exception unused) {
                lobbyFragmentViewModel$holdingReceived$doFinally$1.invoke(holdingResponseStatus, (Object) null);
            }
        } else {
            lobbyFragmentViewModel$holdingReceived$doFinally$1.invoke(holdingResponseStatus, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final ShareRecord getRecord(HoldingResponseStatus holdingResponseStatus, SecureHolding secureHolding) {
        int i = WhenMappings.$EnumSwitchMapping$1[holdingResponseStatus.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        } else if (secureHolding != null) {
            return new ShareRecord(secureHolding.getAttributes(), secureHolding.getDynamicDisplay(), secureHolding.getAssets());
        } else {
            return null;
        }
    }

    public final void changeState(LobbyViewState lobbyViewState) {
        Intrinsics.checkNotNullParameter(lobbyViewState, "state");
        LobbyViewState lobbyViewState2 = this.viewState.get();
        boolean z = false;
        if (!(lobbyViewState2 != null ? lobbyViewState2.equals(lobbyViewState) : false)) {
            this.viewState.set(lobbyViewState);
            StateElements elements = RequestElementsKt.getElements(lobbyViewState);
            int btnText2 = elements.getBtnText() == 0 ? R.string.empty_string_RES_2114650224 : elements.getBtnText();
            this.titleText.set(Integer.valueOf(elements.getTitle()));
            this.subtitleText.set(elements.getSubtitle().invoke(lobbyViewState));
            this.titleImg.set(Integer.valueOf(elements.getTitleImg()));
            this.btnText.set(Integer.valueOf(btnText2));
            ObservableBoolean observableBoolean = this.showBtn;
            if (elements.getBtnText() != 0) {
                z = true;
            }
            observableBoolean.set(z);
            if (lobbyViewState instanceof LobbyViewState.ReceivedHolding) {
                AnalyticsHelper.addCount$default(this.analytics, "authority_accepted", 1, null, 4, null);
            } else if (lobbyViewState instanceof LobbyViewState.RequestDenied) {
                AnalyticsHelper.addCount$default(this.analytics, "authority_rejected", 1, null, 4, null);
            } else if (lobbyViewState instanceof LobbyViewState.ScanError) {
                this.analytics.viewItem("Error", "Bluetooth error");
            } else if (lobbyViewState instanceof LobbyViewState.RequestError) {
                Timber.e(((LobbyViewState.RequestError) lobbyViewState).getError());
                this.analytics.viewItem("Error", "Request holding");
            } else if (lobbyViewState instanceof LobbyViewState.Error) {
                Timber.e(((LobbyViewState.Error) lobbyViewState).getError());
                this.analytics.viewItem("Error", "Request holding");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void postTransaction(HoldingResponseStatus holdingResponseStatus, String str) {
        getCompositeDisposable().add(this.transactionHistoryService.postNewTransaction(holdingResponseStatus, str).subscribeOn(Schedulers.io()).doOnError(new LobbyFragmentViewModel$sam$io_reactivex_functions_Consumer$0(new LobbyFragmentViewModel$postTransaction$1(RetrofitHelper.Companion))).onErrorComplete().subscribe());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel$sam$io_reactivex_functions_Consumer$0] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void storeShareRecord(ShareRecord shareRecord) {
        Completable subscribeOn = this.transactionHistoryService.storeNewShare(shareRecord).subscribeOn(Schedulers.io());
        LobbyFragmentViewModel$storeShareRecord$1 lobbyFragmentViewModel$storeShareRecord$1 = LobbyFragmentViewModel$storeShareRecord$1.INSTANCE;
        if (lobbyFragmentViewModel$storeShareRecord$1 != null) {
            lobbyFragmentViewModel$storeShareRecord$1 = new LobbyFragmentViewModel$sam$io_reactivex_functions_Consumer$0(lobbyFragmentViewModel$storeShareRecord$1);
        }
        getCompositeDisposable().add(subscribeOn.doOnError((Consumer) lobbyFragmentViewModel$storeShareRecord$1).onErrorComplete().subscribe());
    }
}
