package com.digitalwallet.app.api;

import com.digitalwallet.app.model.RegisterDevicePayload;
import io.reactivex.Completable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H'J\u001c\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H'¨\u0006\n"}, d2 = {"Lcom/digitalwallet/app/api/DeviceRegisterApi;", "", "registerGuestDevice", "Lio/reactivex/Completable;", "payload", "Lcom/digitalwallet/app/model/RegisterDevicePayload;", "registerLoggedInDevice", "idToken", "", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DeviceRegisterApi.kt */
public interface DeviceRegisterApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Headers({"Content-Type: application/json"})
    @POST("anonymous")
    Completable registerGuestDevice(@Body RegisterDevicePayload registerDevicePayload);

    @Headers({"Content-Type: application/json"})
    @POST("loggedin")
    Completable registerLoggedInDevice(@Header("Authorization") String str, @Body RegisterDevicePayload registerDevicePayload);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/app/api/DeviceRegisterApi$Companion;", "", "()V", "CONTENT_TYPE_JSON", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: DeviceRegisterApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String CONTENT_TYPE_JSON = "Content-Type: application/json";

        private Companion() {
        }
    }
}
