package com.digitalwallet.di;

import android.app.Application;
import android.content.Context;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.api.CheckInApi;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.squareup.moshi.Moshi;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Component(modules = {AndroidInjectionModule.class, BaseModule.class})
@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H'J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/di/BaseComponent;", "", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "application", "Landroid/app/Application;", "checkInApi", "Lcom/digitalwallet/api/CheckInApi;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "context", "Landroid/content/Context;", "digitalWalletApplication", "Lcom/digitalwallet/DigitalWalletApplication;", "httpCache", "Lokhttp3/Cache;", "inject", "", "baseApp", "moshi", "Lcom/squareup/moshi/Moshi;", "okHttpClient", "Lokhttp3/OkHttpClient;", "remoteConfigService", "Lcom/digitalwallet/services/RemoteConfigService;", "scannerViewService", "Lcom/digitalwallet/services/ScannerViewService;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BaseComponent.kt */
public interface BaseComponent {
    AnalyticsHelper analytics();

    Application application();

    CheckInApi checkInApi();

    CheckInRepository checkInRepository();

    Context context();

    DigitalWalletApplication digitalWalletApplication();

    Cache httpCache();

    void inject(DigitalWalletApplication digitalWalletApplication);

    Moshi moshi();

    @Named("NoInterceptor")
    OkHttpClient okHttpClient();

    RemoteConfigService remoteConfigService();

    ScannerViewService scannerViewService();
}
