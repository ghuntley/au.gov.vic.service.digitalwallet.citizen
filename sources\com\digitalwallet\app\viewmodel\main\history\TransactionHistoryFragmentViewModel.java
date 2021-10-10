package com.digitalwallet.app.viewmodel.main.history;

import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u001a0\u001a0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000eR\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u001a0\u001a0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u001f\u0010\u001e\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u001a0\u001a0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000eR\u001f\u0010 \u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u001a0\u001a0\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000eR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/history/TransactionHistoryFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "errorText", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getErrorText", "()Landroidx/databinding/ObservableField;", "formattedTransactionHistoryList", "Lio/reactivex/subjects/BehaviorSubject;", "", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "getFormattedTransactionHistoryList", "()Lio/reactivex/subjects/BehaviorSubject;", "noTransactionText", "getNoTransactionText", "retryButtonText", "getRetryButtonText", "showErrorMsgView", "", "getShowErrorMsgView", "showHistoryList", "getShowHistoryList", "showLoadingHUD", "getShowLoadingHUD", "showNoTransactionView", "getShowNoTransactionView", "transactionSharesService", "Lcom/digitalwallet/app/services/TransactionSharesService;", "getTransactionSharesService", "()Lcom/digitalwallet/app/services/TransactionSharesService;", "setTransactionSharesService", "(Lcom/digitalwallet/app/services/TransactionSharesService;)V", "requestTransactionHistory", "", "showErrorState", "error", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TransactionHistoryFragmentViewModel.kt */
public final class TransactionHistoryFragmentViewModel extends BaseViewModel {
    private AnalyticsHelper analytics;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ObservableField<Integer> errorText = new ObservableField<>(Integer.valueOf((int) R.string.error_occurred_alt));
    private final BehaviorSubject<List<TransactionHistoryItem>> formattedTransactionHistoryList;
    private final ObservableField<Integer> noTransactionText = new ObservableField<>(Integer.valueOf((int) R.string.share_no_history));
    private final ObservableField<Integer> retryButtonText = new ObservableField<>(Integer.valueOf((int) R.string.try_again_RES_2114650510));
    private final ObservableField<Boolean> showErrorMsgView = new ObservableField<>((Boolean) false);
    private final ObservableField<Boolean> showHistoryList = new ObservableField<>((Boolean) false);
    private final ObservableField<Boolean> showLoadingHUD = new ObservableField<>((Boolean) true);
    private final ObservableField<Boolean> showNoTransactionView = new ObservableField<>((Boolean) false);
    @Inject
    public TransactionSharesService transactionSharesService;

    @Inject
    public TransactionHistoryFragmentViewModel(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.analytics = analyticsHelper;
        BehaviorSubject<List<TransactionHistoryItem>> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorSubject.create()");
        this.formattedTransactionHistoryList = create;
    }

    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public final ObservableField<Boolean> getShowHistoryList() {
        return this.showHistoryList;
    }

    public final ObservableField<Boolean> getShowLoadingHUD() {
        return this.showLoadingHUD;
    }

    public final ObservableField<Boolean> getShowNoTransactionView() {
        return this.showNoTransactionView;
    }

    public final ObservableField<Integer> getNoTransactionText() {
        return this.noTransactionText;
    }

    public final ObservableField<Boolean> getShowErrorMsgView() {
        return this.showErrorMsgView;
    }

    public final ObservableField<Integer> getErrorText() {
        return this.errorText;
    }

    public final ObservableField<Integer> getRetryButtonText() {
        return this.retryButtonText;
    }

    public final BehaviorSubject<List<TransactionHistoryItem>> getFormattedTransactionHistoryList() {
        return this.formattedTransactionHistoryList;
    }

    public final void requestTransactionHistory() {
        this.showLoadingHUD.set(true);
        this.showHistoryList.set(false);
        this.showNoTransactionView.set(false);
        this.showErrorMsgView.set(false);
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable[] disposableArr = new Disposable[1];
        TransactionSharesService transactionSharesService2 = this.transactionSharesService;
        if (transactionSharesService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transactionSharesService");
        }
        disposableArr[0] = transactionSharesService2.getTransactionHistory().doOnSuccess(new TransactionHistoryFragmentViewModel$requestTransactionHistory$1(this)).map(TransactionHistoryFragmentViewModel$requestTransactionHistory$2.INSTANCE).subscribe(new TransactionHistoryFragmentViewModel$sam$io_reactivex_functions_Consumer$0(new TransactionHistoryFragmentViewModel$requestTransactionHistory$3(this.formattedTransactionHistoryList)), new TransactionHistoryFragmentViewModel$sam$io_reactivex_functions_Consumer$0(new TransactionHistoryFragmentViewModel$requestTransactionHistory$4(this)));
        compositeDisposable.addAll(disposableArr);
    }

    /* access modifiers changed from: private */
    public final void showErrorState(Throwable th) {
        this.analytics.viewItem("Error", "Table load failed - Services history");
        Timber.e(th);
        this.showErrorMsgView.set(true);
        this.showLoadingHUD.set(false);
    }

    public final TransactionSharesService getTransactionSharesService() {
        TransactionSharesService transactionSharesService2 = this.transactionSharesService;
        if (transactionSharesService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transactionSharesService");
        }
        return transactionSharesService2;
    }

    public final void setTransactionSharesService(TransactionSharesService transactionSharesService2) {
        Intrinsics.checkNotNullParameter(transactionSharesService2, "<set-?>");
        this.transactionSharesService = transactionSharesService2;
    }
}
