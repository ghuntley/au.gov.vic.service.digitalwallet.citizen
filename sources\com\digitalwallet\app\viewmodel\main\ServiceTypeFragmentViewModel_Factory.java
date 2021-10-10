package com.digitalwallet.app.viewmodel.main;

import dagger.internal.Factory;

public final class ServiceTypeFragmentViewModel_Factory implements Factory<ServiceTypeFragmentViewModel> {
    private static final ServiceTypeFragmentViewModel_Factory INSTANCE = new ServiceTypeFragmentViewModel_Factory();

    @Override // javax.inject.Provider
    public ServiceTypeFragmentViewModel get() {
        return new ServiceTypeFragmentViewModel();
    }

    public static ServiceTypeFragmentViewModel_Factory create() {
        return INSTANCE;
    }

    public static ServiceTypeFragmentViewModel newInstance() {
        return new ServiceTypeFragmentViewModel();
    }
}
