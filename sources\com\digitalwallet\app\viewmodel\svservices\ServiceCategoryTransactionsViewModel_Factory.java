package com.digitalwallet.app.viewmodel.svservices;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ServiceCategoryTransactionsViewModel_Factory implements Factory<ServiceCategoryTransactionsViewModel> {
    private final Provider<Context> contextProvider;

    public ServiceCategoryTransactionsViewModel_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public ServiceCategoryTransactionsViewModel get() {
        return new ServiceCategoryTransactionsViewModel(this.contextProvider.get());
    }

    public static ServiceCategoryTransactionsViewModel_Factory create(Provider<Context> provider) {
        return new ServiceCategoryTransactionsViewModel_Factory(provider);
    }

    public static ServiceCategoryTransactionsViewModel newInstance(Context context) {
        return new ServiceCategoryTransactionsViewModel(context);
    }
}
