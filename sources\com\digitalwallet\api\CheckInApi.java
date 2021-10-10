package com.digitalwallet.api;

import com.digitalwallet.model.CheckInSubmissionPayload;
import io.reactivex.Completable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/digitalwallet/api/CheckInApi;", "", "postCheckIn", "Lio/reactivex/Completable;", "apiKey", "", "payload", "Lcom/digitalwallet/model/CheckInSubmissionPayload;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInApi.kt */
public interface CheckInApi {
    @Headers({"content-type: application/json"})
    @POST("visits")
    Completable postCheckIn(@Header("X-API-KEY") String str, @Body CheckInSubmissionPayload checkInSubmissionPayload);
}
