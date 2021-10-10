package com.digitalwallet.app.di;

import android.app.Application;
import android.content.Context;
import com.digitalwallet.app.BuildConfig;
import com.digitalwallet.app.api.AssetApi;
import com.digitalwallet.app.api.AuthApi;
import com.digitalwallet.app.api.ConfigApi;
import com.digitalwallet.app.api.DeviceRegisterApi;
import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.api.UserApi;
import com.digitalwallet.app.connection.BLEUtil;
import com.digitalwallet.app.oidc.OIDCRequestHandler;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.services.BluetoothEventsService;
import com.digitalwallet.app.services.SimpleAssetService;
import com.digitalwallet.di.ActivityScope;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ&\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u001a\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\b\u0010!\u001a\u00020 H\u0007J\u001a\u0010\"\u001a\u00020#2\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010$\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010)\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010+\u001a\u00020,2\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\f\u0010-\u001a\u00020.*\u00020.H\u0002¨\u0006/"}, d2 = {"Lcom/digitalwallet/app/di/ApiModule;", "", "()V", "makeStandardApi", "Lretrofit2/Retrofit$Builder;", "kotlin.jvm.PlatformType", "builder", "okHttpClient", "Lokhttp3/OkHttpClient;", "moshi", "Lcom/squareup/moshi/Moshi;", "converterFactory", "Lretrofit2/Converter$Factory;", "provideApiHttp", "cache", "Lokhttp3/Cache;", "oidcRequestHandler", "Lcom/digitalwallet/app/oidc/OIDCRequestHandler;", "provideAssetApi", "Lcom/digitalwallet/app/api/AssetApi;", "provideAssetService", "Lcom/digitalwallet/app/services/AssetService;", "context", "Landroid/content/Context;", "assetApi", "provideAuthApi", "Lcom/digitalwallet/app/api/AuthApi;", "provideBLEUtil", "Lcom/digitalwallet/app/connection/BLEUtil;", "application", "Landroid/app/Application;", "bluetoothEventsService", "Lcom/digitalwallet/app/services/BluetoothEventsService;", "provideBluetoothEventsService", "provideConfigApi", "Lcom/digitalwallet/app/api/ConfigApi;", "provideCustomConverterFactory", "provideDeviceRegisterApi", "Lcom/digitalwallet/app/api/DeviceRegisterApi;", "provideHoldingsApi", "Lcom/digitalwallet/app/api/HoldingsApi;", "provideSimpleAssetService", "Lcom/digitalwallet/app/services/SimpleAssetService;", "provideUserApi", "Lcom/digitalwallet/app/api/UserApi;", "logIfDebug", "Lokhttp3/OkHttpClient$Builder;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: ApiModule.kt */
public final class ApiModule {
    @Provides
    @ActivityScope
    public final OkHttpClient provideApiHttp(Cache cache, OIDCRequestHandler oIDCRequestHandler) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(oIDCRequestHandler, "oidcRequestHandler");
        OkHttpClient.Builder cache2 = new OkHttpClient.Builder().addInterceptor(oIDCRequestHandler).cache(cache);
        Intrinsics.checkNotNullExpressionValue(cache2, "OkHttpClient.Builder()\n …            .cache(cache)");
        OkHttpClient build = logIfDebug(cache2).build();
        Intrinsics.checkNotNullExpressionValue(build, "OkHttpClient.Builder()\n …ug()\n            .build()");
        return build;
    }

    @Provides
    @ActivityScope
    public final Converter.Factory provideCustomConverterFactory(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        return new ApiModule$provideCustomConverterFactory$1(moshi);
    }

    public final Retrofit.Builder makeStandardApi(Retrofit.Builder builder, OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        MoshiConverterFactory create = MoshiConverterFactory.create(moshi);
        Intrinsics.checkNotNullExpressionValue(create, "MoshiConverterFactory.create(moshi)");
        return makeStandardApi(builder, okHttpClient, create);
    }

    public final Retrofit.Builder makeStandardApi(Retrofit.Builder builder, OkHttpClient okHttpClient, Converter.Factory factory) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(factory, "converterFactory");
        return builder.client(okHttpClient).addConverterFactory(factory).addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()));
    }

    @Provides
    @ActivityScope
    public final ConfigApi provideConfigApi(@Named("NoInterceptor") OkHttpClient okHttpClient, Converter.Factory factory) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(factory, "converterFactory");
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(BuildConfig.CONFIGURATION_DOCUMENT_URL);
        Intrinsics.checkNotNullExpressionValue(baseUrl, "it");
        Object create = makeStandardApi(baseUrl, okHttpClient, factory).build().create(ConfigApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Retrofit.Builder()\n     …te(ConfigApi::class.java)");
        return (ConfigApi) create;
    }

    @Provides
    @ActivityScope
    public final AuthApi provideAuthApi(@Named("NoInterceptor") OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(OIDCRequestHandler.apiPrefix);
        Intrinsics.checkNotNullExpressionValue(baseUrl, "it");
        Object create = makeStandardApi(baseUrl, okHttpClient, moshi).build().create(AuthApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Retrofit.Builder()\n     …eate(AuthApi::class.java)");
        return (AuthApi) create;
    }

    @Provides
    @ActivityScope
    public final UserApi provideUserApi(@Named("NoInterceptor") OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(BuildConfig.USER_API_BASE);
        Intrinsics.checkNotNullExpressionValue(baseUrl, "it");
        Object create = makeStandardApi(baseUrl, okHttpClient, moshi).build().create(UserApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Retrofit.Builder()\n     …eate(UserApi::class.java)");
        return (UserApi) create;
    }

    @Provides
    @ActivityScope
    public final HoldingsApi provideHoldingsApi(OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(OIDCRequestHandler.apiPrefix);
        Intrinsics.checkNotNullExpressionValue(baseUrl, "it");
        Object create = makeStandardApi(baseUrl, okHttpClient, moshi).build().create(HoldingsApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Retrofit.Builder()\n     …(HoldingsApi::class.java)");
        return (HoldingsApi) create;
    }

    @Provides
    @ActivityScope
    public final DeviceRegisterApi provideDeviceRegisterApi(OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(BuildConfig.DEVICE_REG_API_BASE);
        Intrinsics.checkNotNullExpressionValue(baseUrl, "it");
        Object create = makeStandardApi(baseUrl, okHttpClient, moshi).build().create(DeviceRegisterApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Retrofit.Builder()\n     …eRegisterApi::class.java)");
        return (DeviceRegisterApi) create;
    }

    @Provides
    @ActivityScope
    public final AssetApi provideAssetApi(OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(OIDCRequestHandler.apiPrefix);
        Intrinsics.checkNotNullExpressionValue(baseUrl, "it");
        Object create = makeStandardApi(baseUrl, okHttpClient, moshi).build().create(AssetApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Retrofit.Builder()\n     …ate(AssetApi::class.java)");
        return (AssetApi) create;
    }

    @Provides
    @ActivityScope
    public final AssetService provideAssetService(Context context, AssetApi assetApi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetApi, "assetApi");
        return new AssetService(context, assetApi);
    }

    @Provides
    @ActivityScope
    public final SimpleAssetService provideSimpleAssetService(Context context, AssetApi assetApi, Moshi moshi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetApi, "assetApi");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        return new SimpleAssetService(context, assetApi, moshi);
    }

    @Provides
    @ActivityScope
    public final BluetoothEventsService provideBluetoothEventsService() {
        return new BluetoothEventsService();
    }

    @Provides
    @ActivityScope
    public final BLEUtil provideBLEUtil(Application application, BluetoothEventsService bluetoothEventsService) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(bluetoothEventsService, "bluetoothEventsService");
        return new BLEUtil(application, bluetoothEventsService);
    }

    private final OkHttpClient.Builder logIfDebug(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        Unit unit = Unit.INSTANCE;
        OkHttpClient.Builder addInterceptor = builder.addInterceptor(httpLoggingInterceptor);
        Intrinsics.checkNotNullExpressionValue(addInterceptor, "addInterceptor(HttpLoggi…tor.Level.NONE\n        })");
        return addInterceptor;
    }
}
