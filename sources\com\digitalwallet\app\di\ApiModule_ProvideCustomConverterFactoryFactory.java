package com.digitalwallet.app.di;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Converter;

public final class ApiModule_ProvideCustomConverterFactoryFactory implements Factory<Converter.Factory> {
    private final ApiModule module;
    private final Provider<Moshi> moshiProvider;

    public ApiModule_ProvideCustomConverterFactoryFactory(ApiModule apiModule, Provider<Moshi> provider) {
        this.module = apiModule;
        this.moshiProvider = provider;
    }

    @Override // javax.inject.Provider
    public Converter.Factory get() {
        return provideCustomConverterFactory(this.module, this.moshiProvider.get());
    }

    public static ApiModule_ProvideCustomConverterFactoryFactory create(ApiModule apiModule, Provider<Moshi> provider) {
        return new ApiModule_ProvideCustomConverterFactoryFactory(apiModule, provider);
    }

    public static Converter.Factory provideCustomConverterFactory(ApiModule apiModule, Moshi moshi) {
        return (Converter.Factory) Preconditions.checkNotNull(apiModule.provideCustomConverterFactory(moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
