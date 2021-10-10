package com.digitalwallet.app.di;

import com.nimbusds.jose.jwk.JWKSet;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Converter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/nimbusds/jose/jwk/JWKSet;", "kotlin.jvm.PlatformType", "response", "Lokhttp3/ResponseBody;", "convert"}, k = 3, mv = {1, 4, 0})
/* compiled from: ApiModule.kt */
final class ApiModule$provideCustomConverterFactory$1$responseBodyConverter$1<F, T> implements Converter<ResponseBody, JWKSet> {
    public static final ApiModule$provideCustomConverterFactory$1$responseBodyConverter$1 INSTANCE = new ApiModule$provideCustomConverterFactory$1$responseBodyConverter$1();

    ApiModule$provideCustomConverterFactory$1$responseBodyConverter$1() {
    }

    public final JWKSet convert(ResponseBody responseBody) {
        return JWKSet.load(responseBody.byteStream());
    }
}
