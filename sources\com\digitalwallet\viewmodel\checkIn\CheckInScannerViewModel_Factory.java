package com.digitalwallet.viewmodel.checkIn;

import android.content.Context;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class CheckInScannerViewModel_Factory implements Factory<CheckInScannerViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<ScannerViewService> viewServiceProvider;

    public CheckInScannerViewModel_Factory(Provider<ScannerViewService> provider, Provider<Moshi> provider2, Provider<OkHttpClient> provider3, Provider<Context> provider4, Provider<AnalyticsHelper> provider5) {
        this.viewServiceProvider = provider;
        this.moshiProvider = provider2;
        this.okHttpClientProvider = provider3;
        this.contextProvider = provider4;
        this.analyticsProvider = provider5;
    }

    @Override // javax.inject.Provider
    public CheckInScannerViewModel get() {
        return new CheckInScannerViewModel(this.viewServiceProvider.get(), this.moshiProvider.get(), this.okHttpClientProvider.get(), this.contextProvider.get(), this.analyticsProvider.get());
    }

    public static CheckInScannerViewModel_Factory create(Provider<ScannerViewService> provider, Provider<Moshi> provider2, Provider<OkHttpClient> provider3, Provider<Context> provider4, Provider<AnalyticsHelper> provider5) {
        return new CheckInScannerViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CheckInScannerViewModel newInstance(ScannerViewService scannerViewService, Moshi moshi, OkHttpClient okHttpClient, Context context, AnalyticsHelper analyticsHelper) {
        return new CheckInScannerViewModel(scannerViewService, moshi, okHttpClient, context, analyticsHelper);
    }
}
