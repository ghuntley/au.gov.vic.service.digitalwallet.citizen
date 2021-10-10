package com.digitalwallet.app.di;

import com.nimbusds.jose.jwk.JWKSet;
import com.squareup.moshi.Moshi;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u0003\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/digitalwallet/app/di/ApiModule$provideCustomConverterFactory$1", "Lretrofit2/Converter$Factory;", "responseBodyConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ApiModule.kt */
public final class ApiModule$provideCustomConverterFactory$1 extends Converter.Factory {
    final /* synthetic */ Moshi $moshi;

    ApiModule$provideCustomConverterFactory$1(Moshi moshi) {
        this.$moshi = moshi;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotationArr, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (Intrinsics.areEqual(type, JWKSet.class)) {
            return ApiModule$provideCustomConverterFactory$1$responseBodyConverter$1.INSTANCE;
        }
        return MoshiConverterFactory.create(this.$moshi).responseBodyConverter(type, annotationArr, retrofit);
    }
}
