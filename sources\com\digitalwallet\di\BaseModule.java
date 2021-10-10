package com.digitalwallet.di;

import android.app.Application;
import android.content.Context;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.api.CheckInApi;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInSharedPreferences;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0007J0\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0007J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0016\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0018H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/digitalwallet/di/BaseModule;", "", "application", "Lcom/digitalwallet/DigitalWalletApplication;", "(Lcom/digitalwallet/DigitalWalletApplication;)V", "bindContext", "Landroid/content/Context;", "Landroid/app/Application;", "provideAnalytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "context", "provideApplication", "provideCheckInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "moshi", "Lcom/squareup/moshi/Moshi;", "checkInApi", "Lcom/digitalwallet/api/CheckInApi;", "sharedPreferences", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInSharedPreferences;", "analytics", "provideCheckInSharedPreferences", "provideDigitalWalletApplication", "provideIOScheduler", "Lio/reactivex/Scheduler;", "provideMainThread", "provideScannerViewService", "Lcom/digitalwallet/services/ScannerViewService;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module(includes = {BaseViewModelModule.class, BaseSupportFragmentModule.class, BaseApiModule.class})
/* compiled from: BaseModule.kt */
public class BaseModule {
    private final DigitalWalletApplication application;

    public BaseModule(DigitalWalletApplication digitalWalletApplication) {
        Intrinsics.checkNotNullParameter(digitalWalletApplication, "application");
        this.application = digitalWalletApplication;
    }

    @Provides
    @Singleton
    public final Context bindContext(Application application2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        Context applicationContext = application2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
        return applicationContext;
    }

    @Provides
    @Singleton
    public final Application provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    public final DigitalWalletApplication provideDigitalWalletApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    public final AnalyticsHelper provideAnalytics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AnalyticsHelper(context);
    }

    @Provides
    @Singleton
    public final ScannerViewService provideScannerViewService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScannerViewService(context);
    }

    @Provides
    @Singleton
    public final CheckInSharedPreferences provideCheckInSharedPreferences(Context context, Moshi moshi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        return new CheckInSharedPreferences(context, moshi);
    }

    @Provides
    @Singleton
    public final CheckInRepository provideCheckInRepository(Context context, Moshi moshi, CheckInApi checkInApi, CheckInSharedPreferences checkInSharedPreferences, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(checkInApi, "checkInApi");
        Intrinsics.checkNotNullParameter(checkInSharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        return new CheckInRepository(context, moshi, checkInApi, checkInSharedPreferences, analyticsHelper);
    }

    @Provides
    @Singleton
    @Named("SCHEDULER_IO")
    public final Scheduler provideIOScheduler() {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "Schedulers.io()");
        return io2;
    }

    @Provides
    @Named("SCHEDULER_MAIN_THREAD")
    public final Scheduler provideMainThread() {
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "AndroidSchedulers.mainThread()");
        return mainThread;
    }
}
