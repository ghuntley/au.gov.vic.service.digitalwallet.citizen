package com.digitalwallet.app.viewmodel.main;

import dagger.internal.Factory;

public final class AccountSettingsFragmentViewModel_Factory implements Factory<AccountSettingsFragmentViewModel> {
    private static final AccountSettingsFragmentViewModel_Factory INSTANCE = new AccountSettingsFragmentViewModel_Factory();

    @Override // javax.inject.Provider
    public AccountSettingsFragmentViewModel get() {
        return new AccountSettingsFragmentViewModel();
    }

    public static AccountSettingsFragmentViewModel_Factory create() {
        return INSTANCE;
    }

    public static AccountSettingsFragmentViewModel newInstance() {
        return new AccountSettingsFragmentViewModel();
    }
}
