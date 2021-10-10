package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.services.ScannerDataService;
import com.digitalwallet.services.ScannerViewService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class EligibilityScannerFragmentViewModel_Factory implements Factory<EligibilityScannerFragmentViewModel> {
    private final Provider<ScannerDataService> dataServiceProvider;
    private final Provider<ScannerViewService> viewServiceProvider;

    public EligibilityScannerFragmentViewModel_Factory(Provider<ScannerViewService> provider, Provider<ScannerDataService> provider2) {
        this.viewServiceProvider = provider;
        this.dataServiceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public EligibilityScannerFragmentViewModel get() {
        return new EligibilityScannerFragmentViewModel(this.viewServiceProvider.get(), this.dataServiceProvider.get());
    }

    public static EligibilityScannerFragmentViewModel_Factory create(Provider<ScannerViewService> provider, Provider<ScannerDataService> provider2) {
        return new EligibilityScannerFragmentViewModel_Factory(provider, provider2);
    }

    public static EligibilityScannerFragmentViewModel newInstance(ScannerViewService scannerViewService, ScannerDataService scannerDataService) {
        return new EligibilityScannerFragmentViewModel(scannerViewService, scannerDataService);
    }
}
