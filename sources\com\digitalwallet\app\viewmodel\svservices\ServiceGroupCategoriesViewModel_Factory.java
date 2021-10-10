package com.digitalwallet.app.viewmodel.svservices;

import dagger.internal.Factory;

public final class ServiceGroupCategoriesViewModel_Factory implements Factory<ServiceGroupCategoriesViewModel> {
    private static final ServiceGroupCategoriesViewModel_Factory INSTANCE = new ServiceGroupCategoriesViewModel_Factory();

    @Override // javax.inject.Provider
    public ServiceGroupCategoriesViewModel get() {
        return new ServiceGroupCategoriesViewModel();
    }

    public static ServiceGroupCategoriesViewModel_Factory create() {
        return INSTANCE;
    }

    public static ServiceGroupCategoriesViewModel newInstance() {
        return new ServiceGroupCategoriesViewModel();
    }
}
