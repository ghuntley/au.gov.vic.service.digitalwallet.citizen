package com.digitalwallet.app.viewmodel.main;

import dagger.internal.Factory;

public final class ServiceDetailFragmentViewModel_Factory implements Factory<ServiceDetailFragmentViewModel> {
    private static final ServiceDetailFragmentViewModel_Factory INSTANCE = new ServiceDetailFragmentViewModel_Factory();

    @Override // javax.inject.Provider
    public ServiceDetailFragmentViewModel get() {
        return new ServiceDetailFragmentViewModel();
    }

    public static ServiceDetailFragmentViewModel_Factory create() {
        return INSTANCE;
    }

    public static ServiceDetailFragmentViewModel newInstance() {
        return new ServiceDetailFragmentViewModel();
    }
}
