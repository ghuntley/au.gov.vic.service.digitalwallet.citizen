package com.digitalwallet.di;

import android.app.Application;
import com.digitalwallet.BuildConfig;
import com.digitalwallet.api.CheckInApi;
import com.digitalwallet.model.db.DateAdapter;
import com.digitalwallet.services.RemoteConfigService;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import java.util.Locale;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\nH\u0007J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000eH\u0007J\u001a\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0017H\u0002¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/di/BaseApiModule;", "", "()V", "makeStandardApi", "Lretrofit2/Retrofit$Builder;", "kotlin.jvm.PlatformType", "builder", "okHttpClient", "Lokhttp3/OkHttpClient;", "moshi", "Lcom/squareup/moshi/Moshi;", "provideCheckInApi", "Lcom/digitalwallet/api/CheckInApi;", "provideHttpCache", "Lokhttp3/Cache;", "application", "Landroid/app/Application;", "provideMoshi", "provideOkHttp", "cache", "provideRemoteConfigService", "Lcom/digitalwallet/services/RemoteConfigService;", "logIfDebug", "Lokhttp3/OkHttpClient$Builder;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: BaseApiModule.kt */
public final class BaseApiModule {
    @Provides
    @Singleton
    public final Cache provideHttpCache(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        return new Cache(application.getCacheDir(), 10485760);
    }

    @Provides
    @Singleton
    @Named("NoInterceptor")
    public final OkHttpClient provideOkHttp(Cache cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        OkHttpClient.Builder cache2 = new OkHttpClient.Builder().cache(cache);
        Intrinsics.checkNotNullExpressionValue(cache2, "OkHttpClient.Builder()\n            .cache(cache)");
        OkHttpClient build = logIfDebug(cache2).build();
        Intrinsics.checkNotNullExpressionValue(build, "OkHttpClient.Builder()\n …ug()\n            .build()");
        return build;
    }

    @Provides
    @Singleton
    public final Moshi provideMoshi() {
        Moshi.Builder builder = new Moshi.Builder();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
        Moshi build = builder.add(new DateAdapter(locale)).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Moshi.Builder()\n        …y())\n            .build()");
        return build;
    }

    @Provides
    @Singleton
    public final CheckInApi provideCheckInApi(@Named("NoInterceptor") OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Retrofit.Builder baseUrl = new Retrofit.Builder().baseUrl(BuildConfig.CHECK_IN_BASE_URL);
        Intrinsics.checkNotNullExpressionValue(baseUrl, "it");
        Object create = makeStandardApi(baseUrl, okHttpClient, moshi).build().create(CheckInApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "Retrofit.Builder()\n     …e(CheckInApi::class.java)");
        return (CheckInApi) create;
    }

    @Provides
    @Singleton
    public final RemoteConfigService provideRemoteConfigService(@Named("NoInterceptor") OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        return new RemoteConfigService(okHttpClient, moshi);
    }

    public final Retrofit.Builder makeStandardApi(Retrofit.Builder builder, OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        return builder.client(okHttpClient).addConverterFactory(MoshiConverterFactory.create(moshi)).addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()));
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
