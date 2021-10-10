package com.digitalwallet.app.api;

import com.digitalwallet.app.model.login.RegisterUserRequestPayload;
import com.digitalwallet.app.model.login.RegisterUserResponsePayload;
import com.digitalwallet.app.model.login.RegistrationLoginRequestPayload;
import com.digitalwallet.app.model.login.VerifyOTPRequestPayload;
import com.digitalwallet.app.model.login.VerifyOTPResponsePayload;
import com.digitalwallet.app.oidc.model.Tokens;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u000bH'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u000eH'J\u001c\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/api/UserApi;", "", "confirmOtp", "Lio/reactivex/Single;", "Lcom/digitalwallet/app/model/login/VerifyOTPResponsePayload;", "transId", "", "requestPayload", "Lcom/digitalwallet/app/model/login/VerifyOTPRequestPayload;", "registerUser", "Lcom/digitalwallet/app/model/login/RegisterUserResponsePayload;", "Lcom/digitalwallet/app/model/login/RegisterUserRequestPayload;", "registrationLogin", "Lcom/digitalwallet/app/oidc/model/Tokens;", "Lcom/digitalwallet/app/model/login/RegistrationLoginRequestPayload;", "resendOtp", "Lio/reactivex/Completable;", "otpSessionID", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UserApi.kt */
public interface UserApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Headers({"Content-Type: application/json"})
    @POST("register/otpConfirm")
    Single<VerifyOTPResponsePayload> confirmOtp(@Header("X-TransactionID") String str, @Body VerifyOTPRequestPayload verifyOTPRequestPayload);

    @Headers({"Content-Type: application/json"})
    @POST("register")
    Single<RegisterUserResponsePayload> registerUser(@Header("X-TransactionID") String str, @Body RegisterUserRequestPayload registerUserRequestPayload);

    @Headers({"Content-Type: application/json"})
    @POST("register/userLogin")
    Single<Tokens> registrationLogin(@Header("X-TransactionID") String str, @Body RegistrationLoginRequestPayload registrationLoginRequestPayload);

    @Headers({"Content-Type: application/json"})
    @POST("register/otpResend/{otpSessionID}")
    Completable resendOtp(@Path("otpSessionID") String str, @Header("X-TransactionID") String str2);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/api/UserApi$Companion;", "", "()V", "CONTENT_TYPE_JSON", "", "OTP_SESSION_ID", "X_TRANS_ID", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UserApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String CONTENT_TYPE_JSON = "Content-Type: application/json";
        private static final String OTP_SESSION_ID = "otpSessionID";
        private static final String X_TRANS_ID = "X-TransactionID";

        private Companion() {
        }
    }
}
