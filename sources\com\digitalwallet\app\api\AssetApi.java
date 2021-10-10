package com.digitalwallet.app.api;

import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/api/AssetApi;", "", "getAsset", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "fullUrl", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AssetApi.kt */
public interface AssetApi {
    @Streaming
    @GET
    Call<ResponseBody> getAsset(@Url String str);
}
