package com.digitalwallet.app.viewmodel.main;

import android.content.Context;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AccountDetailsFragmentViewModel_Factory implements Factory<AccountDetailsFragmentViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<AuthenticationUtility> authUtilityProvider;
    private final Provider<Context> contextProvider;
    private final Provider<TransactionSharesService> transactionSharesServiceProvider;

    public AccountDetailsFragmentViewModel_Factory(Provider<Context> provider, Provider<TransactionSharesService> provider2, Provider<AnalyticsHelper> provider3, Provider<AuthenticationUtility> provider4) {
        this.contextProvider = provider;
        this.transactionSharesServiceProvider = provider2;
        this.analyticsProvider = provider3;
        this.authUtilityProvider = provider4;
    }

    @Override // javax.inject.Provider
    public AccountDetailsFragmentViewModel get() {
        AccountDetailsFragmentViewModel accountDetailsFragmentViewModel = new AccountDetailsFragmentViewModel(this.contextProvider.get(), this.transactionSharesServiceProvider.get(), this.analyticsProvider.get());
        AccountDetailsFragmentViewModel_MembersInjector.injectAuthUtility(accountDetailsFragmentViewModel, this.authUtilityProvider.get());
        return accountDetailsFragmentViewModel;
    }

    public static AccountDetailsFragmentViewModel_Factory create(Provider<Context> provider, Provider<TransactionSharesService> provider2, Provider<AnalyticsHelper> provider3, Provider<AuthenticationUtility> provider4) {
        return new AccountDetailsFragmentViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static AccountDetailsFragmentViewModel newInstance(Context context, TransactionSharesService transactionSharesService, AnalyticsHelper analyticsHelper) {
        return new AccountDetailsFragmentViewModel(context, transactionSharesService, analyticsHelper);
    }
}
