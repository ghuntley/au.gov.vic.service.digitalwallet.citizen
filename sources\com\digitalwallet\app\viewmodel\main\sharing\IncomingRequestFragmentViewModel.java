package com.digitalwallet.app.viewmodel.main.sharing;

import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001@B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010*\u001a\u00020+J\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0-2\n\u0010.\u001a\u00060\u0007j\u0002`/J\u000e\u00100\u001a\u00020+2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020'J\u001e\u00105\u001a\u0002062\u0006\u00104\u001a\u00020'2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u000209J\u0016\u0010:\u001a\u00020+2\u0006\u00107\u001a\u00020\u00072\u0006\u0010;\u001a\u000209J\u0006\u0010<\u001a\u00020+J\u0010\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000e0\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000e0\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00190\u00190\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006A"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/IncomingRequestFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "authorityIdentifier", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getAuthorityIdentifier", "()Landroidx/databinding/ObservableField;", "authorityName", "getAuthorityName", "centerImg", "", "getCenterImg", "centerText", "getCenterText", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "getHoldingsService", "()Lcom/digitalwallet/app/holdings/HoldingsService;", "setHoldingsService", "(Lcom/digitalwallet/app/holdings/HoldingsService;)V", "inTransition", "", "getInTransition", "localHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "sharingHint", "getSharingHint", "transactionHistoryService", "Lcom/digitalwallet/app/services/TransactionSharesService;", "getTransactionHistoryService", "()Lcom/digitalwallet/app/services/TransactionSharesService;", "setTransactionHistoryService", "(Lcom/digitalwallet/app/services/TransactionSharesService;)V", "userConsentPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/digitalwallet/app/model/HoldingResponseStatus;", "getUserConsentPublisher", "()Lio/reactivex/subjects/PublishSubject;", "dismiss", "", "fetchRequestedHolding", "Lio/reactivex/Maybe;", RequestHolding.sharingCodeKey, "Lcom/digitalwallet/app/model/SharingCode;", "onHoldingResponseError", "error", "", "onHoldingResponseSuccess", "holdingResponseStatus", "postTransaction", "Lio/reactivex/Completable;", "holdingName", "authorityDetails", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "setSharingRequestInfo", "authority", FirebaseAnalytics.Event.SHARE, "updateTransitionState", "state", "Lcom/digitalwallet/app/viewmodel/main/sharing/IncomingRequestFragmentViewModel$TransitionState;", "TransitionState", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragmentViewModel.kt */
public final class IncomingRequestFragmentViewModel extends BaseViewModel {
    private AnalyticsHelper analytics;
    private final ObservableField<String> authorityIdentifier = new ObservableField<>("");
    private final ObservableField<String> authorityName = new ObservableField<>("");
    private final ObservableField<Integer> centerImg = new ObservableField<>(Integer.valueOf((int) R.drawable.ic_card_large));
    private final ObservableField<Integer> centerText = new ObservableField<>(Integer.valueOf((int) R.string.request_incoming));
    @Inject
    public HoldingsService holdingsService;
    private final ObservableField<Boolean> inTransition = new ObservableField<>((Boolean) true);
    private SecureHolding localHolding;
    private final ObservableField<String> sharingHint = new ObservableField<>("");
    @Inject
    public TransactionSharesService transactionHistoryService;
    private final PublishSubject<HoldingResponseStatus> userConsentPublisher;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/IncomingRequestFragmentViewModel$TransitionState;", "", "(Ljava/lang/String;I)V", "INCOMING", "DENIED", "SHARED", "ERROR", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: IncomingRequestFragmentViewModel.kt */
    private enum TransitionState {
        INCOMING,
        DENIED,
        SHARED,
        ERROR
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HoldingResponseStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HoldingResponseStatus.ACCEPTED.ordinal()] = 1;
            iArr[HoldingResponseStatus.DENIED.ordinal()] = 2;
            int[] iArr2 = new int[TransitionState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[TransitionState.INCOMING.ordinal()] = 1;
            iArr2[TransitionState.SHARED.ordinal()] = 2;
            iArr2[TransitionState.DENIED.ordinal()] = 3;
            iArr2[TransitionState.ERROR.ordinal()] = 4;
        }
    }

    public static final /* synthetic */ SecureHolding access$getLocalHolding$p(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel) {
        SecureHolding secureHolding = incomingRequestFragmentViewModel.localHolding;
        if (secureHolding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localHolding");
        }
        return secureHolding;
    }

    @Inject
    public IncomingRequestFragmentViewModel(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.analytics = analyticsHelper;
        PublishSubject<HoldingResponseStatus> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.userConsentPublisher = create;
    }

    public final ObservableField<Integer> getCenterText() {
        return this.centerText;
    }

    public final ObservableField<Integer> getCenterImg() {
        return this.centerImg;
    }

    public final ObservableField<Boolean> getInTransition() {
        return this.inTransition;
    }

    public final ObservableField<String> getSharingHint() {
        return this.sharingHint;
    }

    public final ObservableField<String> getAuthorityName() {
        return this.authorityName;
    }

    public final ObservableField<String> getAuthorityIdentifier() {
        return this.authorityIdentifier;
    }

    public final PublishSubject<HoldingResponseStatus> getUserConsentPublisher() {
        return this.userConsentPublisher;
    }

    public final void share() {
        this.userConsentPublisher.onNext(HoldingResponseStatus.ACCEPTED);
    }

    public final void dismiss() {
        this.userConsentPublisher.onNext(HoldingResponseStatus.DENIED);
    }

    public final void onHoldingResponseSuccess(HoldingResponseStatus holdingResponseStatus) {
        TransitionState transitionState;
        Intrinsics.checkNotNullParameter(holdingResponseStatus, "holdingResponseStatus");
        int i = WhenMappings.$EnumSwitchMapping$0[holdingResponseStatus.ordinal()];
        if (i == 1) {
            transitionState = TransitionState.SHARED;
        } else if (i == 2) {
            transitionState = TransitionState.DENIED;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        updateTransitionState(transitionState);
    }

    public final void onHoldingResponseError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Timber.e(th);
        updateTransitionState(TransitionState.ERROR);
    }

    public final Maybe<SecureHolding> fetchRequestedHolding(String str) {
        Intrinsics.checkNotNullParameter(str, RequestHolding.sharingCodeKey);
        HoldingsService holdingsService2 = this.holdingsService;
        if (holdingsService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingsService");
        }
        Maybe<R> doOnSuccess = holdingsService2.getLocalSecureHoldings().flatMapMaybe(new IncomingRequestFragmentViewModel$fetchRequestedHolding$1(str)).doOnSuccess(new IncomingRequestFragmentViewModel$fetchRequestedHolding$2(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "holdingsService.getLocal…ess { localHolding = it }");
        return doOnSuccess;
    }

    public final Completable postTransaction(HoldingResponseStatus holdingResponseStatus, String str, HoldingRecordAttributes holdingRecordAttributes) {
        Completable completable;
        Intrinsics.checkNotNullParameter(holdingResponseStatus, "holdingResponseStatus");
        Intrinsics.checkNotNullParameter(str, "holdingName");
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "authorityDetails");
        if (holdingResponseStatus == HoldingResponseStatus.ACCEPTED) {
            TransactionSharesService transactionSharesService = this.transactionHistoryService;
            if (transactionSharesService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("transactionHistoryService");
            }
            SecureHolding secureHolding = this.localHolding;
            if (secureHolding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localHolding");
            }
            completable = transactionSharesService.storeNewShare(secureHolding, holdingRecordAttributes);
        } else {
            completable = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
        }
        TransactionSharesService transactionSharesService2 = this.transactionHistoryService;
        if (transactionSharesService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transactionHistoryService");
        }
        Completable andThen = transactionSharesService2.postNewTransaction(holdingResponseStatus, str).andThen(completable);
        Intrinsics.checkNotNullExpressionValue(andThen, "transactionHistoryServic…dThen(storageCompletable)");
        return andThen;
    }

    private final void updateTransitionState(TransitionState transitionState) {
        this.inTransition.set(true);
        int i = WhenMappings.$EnumSwitchMapping$1[transitionState.ordinal()];
        if (i == 1) {
            this.centerText.set(Integer.valueOf((int) R.string.request_incoming));
            this.centerImg.set(Integer.valueOf((int) R.drawable.ic_card_large));
        } else if (i == 2) {
            this.analytics.viewItem("Alert", "Card shared");
            this.centerText.set(Integer.valueOf((int) R.string.request_card_shared));
            this.centerImg.set(Integer.valueOf((int) R.drawable.ic_icon_success));
        } else if (i == 3) {
            this.centerText.set(Integer.valueOf((int) R.string.request_denied));
            this.centerImg.set(Integer.valueOf((int) R.drawable.ic_red_cross));
        } else if (i == 4) {
            this.analytics.viewItem("Error", "Card shared");
            this.centerText.set(Integer.valueOf((int) R.string.error_occurred));
            this.centerImg.set(Integer.valueOf((int) R.drawable.ic_red_cross));
        }
    }

    public final void setSharingRequestInfo(String str, HoldingRecordAttributes holdingRecordAttributes) {
        Intrinsics.checkNotNullParameter(str, "holdingName");
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "authority");
        ObservableField<String> observableField = this.sharingHint;
        observableField.set("Share your " + str + '?');
        ObservableField<String> observableField2 = this.authorityName;
        observableField2.set("Officer " + holdingRecordAttributes.getFirstName() + ' ' + holdingRecordAttributes.getLastName());
        ObservableField<String> observableField3 = this.authorityIdentifier;
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(holdingRecordAttributes.getIdentifier());
        observableField3.set(sb.toString());
    }

    public final HoldingsService getHoldingsService() {
        HoldingsService holdingsService2 = this.holdingsService;
        if (holdingsService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingsService");
        }
        return holdingsService2;
    }

    public final void setHoldingsService(HoldingsService holdingsService2) {
        Intrinsics.checkNotNullParameter(holdingsService2, "<set-?>");
        this.holdingsService = holdingsService2;
    }

    public final TransactionSharesService getTransactionHistoryService() {
        TransactionSharesService transactionSharesService = this.transactionHistoryService;
        if (transactionSharesService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transactionHistoryService");
        }
        return transactionSharesService;
    }

    public final void setTransactionHistoryService(TransactionSharesService transactionSharesService) {
        Intrinsics.checkNotNullParameter(transactionSharesService, "<set-?>");
        this.transactionHistoryService = transactionSharesService;
    }
}
