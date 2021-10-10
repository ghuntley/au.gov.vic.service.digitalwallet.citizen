package com.digitalwallet.app.viewmodel.main;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.AttributeDetailItem;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.model.Profile;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.app.view.util.AccountDetailsScreenState;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.util.SpannableTextKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00100\u001a\u000201J\b\u00102\u001a\u000203H\u0002J\u0006\u00104\u001a\u000201J\b\u00105\u001a\u000201H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0\u001e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00066"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/AccountDetailsFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "transactionSharesService", "Lcom/digitalwallet/app/services/TransactionSharesService;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Landroid/content/Context;Lcom/digitalwallet/app/services/TransactionSharesService;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "authUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "getAuthUtility", "()Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "setAuthUtility", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "email", "", "errorTransHistory", "Landroidx/databinding/ObservableBoolean;", "getErrorTransHistory", "()Landroidx/databinding/ObservableBoolean;", "fullName", "isCitizen", "", "()Z", "loadingTransHistory", "getLoadingTransHistory", "screenState", "Landroidx/databinding/ObservableField;", "Lcom/digitalwallet/app/view/util/AccountDetailsScreenState;", "getScreenState", "()Landroidx/databinding/ObservableField;", "transHistoryErrorDescription", "Landroid/text/SpannableStringBuilder;", "getTransHistoryErrorDescription", "()Landroid/text/SpannableStringBuilder;", "transHistoryItems", "", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "getTransHistoryItems", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/viewmodel/main/AccountDetailsView;", "getView", "()Lcom/digitalwallet/app/viewmodel/main/AccountDetailsView;", "setView", "(Lcom/digitalwallet/app/viewmodel/main/AccountDetailsView;)V", "edit", "", "populateUserProfile", "", "reload", "requestTransactionHistory", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragmentViewModel.kt */
public final class AccountDetailsFragmentViewModel extends BaseViewModel {
    private final AnalyticsHelper analytics;
    @Inject
    public AuthenticationUtility authUtility;
    private final CompositeDisposable disposables;
    private String email;
    private final ObservableBoolean errorTransHistory;
    private String fullName;
    private final boolean isCitizen;
    private final ObservableBoolean loadingTransHistory;
    private final ObservableField<AccountDetailsScreenState> screenState;
    private final SpannableStringBuilder transHistoryErrorDescription;
    private final ObservableField<List<TransactionHistoryItem>> transHistoryItems;
    private final TransactionSharesService transactionSharesService;
    public AccountDetailsView view;

    @Inject
    public AccountDetailsFragmentViewModel(Context context, TransactionSharesService transactionSharesService2, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(transactionSharesService2, "transactionSharesService");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.transactionSharesService = transactionSharesService2;
        this.analytics = analyticsHelper;
        this.isCitizen = ServerTypeKt.getAppType() == AppType.CITIZEN;
        this.screenState = new ObservableField<>(AccountDetailsScreenState.LOADING);
        this.fullName = "";
        this.email = "";
        this.disposables = new CompositeDisposable();
        this.transHistoryErrorDescription = SpannableTextKt.getDWStyleSpannableStringBuilder(context, R.string.user_error_transaction_history, R.string.tap_to_retry, new AccountDetailsFragmentViewModel$transHistoryErrorDescription$1(this));
        this.loadingTransHistory = new ObservableBoolean(false);
        this.errorTransHistory = new ObservableBoolean(false);
        this.transHistoryItems = new ObservableField<>(CollectionsKt.emptyList());
    }

    public final boolean isCitizen() {
        return this.isCitizen;
    }

    public final AuthenticationUtility getAuthUtility() {
        AuthenticationUtility authenticationUtility = this.authUtility;
        if (authenticationUtility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authUtility");
        }
        return authenticationUtility;
    }

    public final void setAuthUtility(AuthenticationUtility authenticationUtility) {
        Intrinsics.checkNotNullParameter(authenticationUtility, "<set-?>");
        this.authUtility = authenticationUtility;
    }

    public final AccountDetailsView getView() {
        AccountDetailsView accountDetailsView = this.view;
        if (accountDetailsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        return accountDetailsView;
    }

    public final void setView(AccountDetailsView accountDetailsView) {
        Intrinsics.checkNotNullParameter(accountDetailsView, "<set-?>");
        this.view = accountDetailsView;
    }

    public final ObservableField<AccountDetailsScreenState> getScreenState() {
        return this.screenState;
    }

    private final Object populateUserProfile() {
        AuthenticationUtility authenticationUtility = this.authUtility;
        if (authenticationUtility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authUtility");
        }
        Profile profile = authenticationUtility.getProfile();
        if (profile != null) {
            this.fullName = profile.getName();
            String email2 = profile.getEmail();
            if (email2.length() == 0) {
                email2 = profile.getSub();
            }
            this.email = email2;
            if (profile != null) {
                return profile;
            }
        }
        Timber.w("No profile details set", new Object[0]);
        return Unit.INSTANCE;
    }

    public final void edit() {
        AnalyticsHelper.selectContent$default(this.analytics, "Edit account details", null, 2, null);
        AccountDetailsView accountDetailsView = this.view;
        if (accountDetailsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        accountDetailsView.edit();
    }

    public final void reload() {
        try {
            populateUserProfile();
            this.screenState.set(AccountDetailsScreenState.SHOW_ATTRIBUTES);
            List<AttributeDetailItem> mutableListOf = CollectionsKt.mutableListOf(new AttributeDetailItem((int) R.string.user_full_name, this.fullName), new AttributeDetailItem((int) R.string.user_email, this.email));
            if (this.isCitizen) {
                AuthenticationUtility authenticationUtility = this.authUtility;
                if (authenticationUtility == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authUtility");
                }
                mutableListOf.add(new AttributeDetailItem((int) R.string.user_nickname, authenticationUtility.getNickname()));
            }
            AccountDetailsView accountDetailsView = this.view;
            if (accountDetailsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
            }
            accountDetailsView.updateList(mutableListOf);
            requestTransactionHistory();
        } catch (Exception e) {
            Timber.e(e);
            this.analytics.viewItem("Error", "Table load failed - Account details");
            this.screenState.set(AccountDetailsScreenState.ERROR);
        }
    }

    public final SpannableStringBuilder getTransHistoryErrorDescription() {
        return this.transHistoryErrorDescription;
    }

    public final ObservableBoolean getLoadingTransHistory() {
        return this.loadingTransHistory;
    }

    public final ObservableBoolean getErrorTransHistory() {
        return this.errorTransHistory;
    }

    public final ObservableField<List<TransactionHistoryItem>> getTransHistoryItems() {
        return this.transHistoryItems;
    }

    /* access modifiers changed from: private */
    public final void requestTransactionHistory() {
        this.loadingTransHistory.set(true);
        this.disposables.add(this.transactionSharesService.getTransactionHistory().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(AccountDetailsFragmentViewModel$requestTransactionHistory$1.INSTANCE).subscribe(new AccountDetailsFragmentViewModel$requestTransactionHistory$2(this), new AccountDetailsFragmentViewModel$requestTransactionHistory$3(this)));
    }
}
