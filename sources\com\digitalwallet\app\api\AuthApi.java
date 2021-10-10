package com.digitalwallet.app.api;

import com.digitalwallet.app.oidc.model.Profile;
import com.digitalwallet.app.oidc.model.Tokens;
import com.google.android.gms.common.internal.ImagesContract;
import io.reactivex.Single;
import kotlin.Metadata;
import net.openid.appauth.ResponseTypeValues;
import okhttp3.FormBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/digitalwallet/app/api/AuthApi;", "", "getProfile", "Lio/reactivex/Single;", "Lcom/digitalwallet/app/oidc/model/Profile;", ImagesContract.URL, "", ResponseTypeValues.TOKEN, "getTokens", "Lcom/digitalwallet/app/oidc/model/Tokens;", "formBody", "Lokhttp3/FormBody;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AuthApi.kt */
public interface AuthApi {
    @GET
    Single<Profile> getProfile(@Url String str, @Header("Authorization") String str2);

    @POST
    Single<Tokens> getTokens(@Url String str, @Body FormBody formBody);
}
