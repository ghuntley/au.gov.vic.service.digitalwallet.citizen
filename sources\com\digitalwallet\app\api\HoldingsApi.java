package com.digitalwallet.app.api;

import com.digitalwallet.app.model.HoldingRequestSet;
import com.digitalwallet.app.model.HoldingSet;
import com.digitalwallet.app.model.UnsecuredHoldingSet;
import com.digitalwallet.app.model.db.harvester.HarvestBatch;
import com.digitalwallet.app.model.transaction.TransactionHistory;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H'J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH'J\u0012\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'J\u0012\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0013\u001a\u00020\bH'¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/api/HoldingsApi;", "", "getSecureHoldings", "Lio/reactivex/Single;", "Lcom/digitalwallet/app/model/HoldingSet;", "requestedHoldings", "Lcom/digitalwallet/app/model/HoldingRequestSet;", "getTransactionHistory", "Lcom/digitalwallet/app/model/transaction/TransactionHistory;", "getUnSecureHoldings", "Lcom/digitalwallet/app/model/UnsecuredHoldingSet;", "postEligibilityScan", "Lio/reactivex/Completable;", "scanResult", "", "postHarvestBatch", "harvestBatch", "Lcom/digitalwallet/app/model/db/harvester/HarvestBatch;", "postNewTransactions", "history", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingsApi.kt */
public interface HoldingsApi {
    @Headers({"Content-type: application/json; charset=utf-8", "Accept: application/json"})
    @POST("users/me/holdings/offlineTokens")
    Single<HoldingSet> getSecureHoldings(@Body HoldingRequestSet holdingRequestSet);

    @GET("users/me/transactions")
    Single<TransactionHistory> getTransactionHistory();

    @Headers({"Accept: application/json"})
    @GET("users/me/holdings")
    Single<UnsecuredHoldingSet> getUnSecureHoldings();

    @Headers({"content-type: text/csv"})
    @POST("users/me/barcodeScans")
    Completable postEligibilityScan(@Body String str);

    @Headers({"content-type: application/json"})
    @POST("jobs/create")
    Completable postHarvestBatch(@Body HarvestBatch harvestBatch);

    @Headers({"Content-type: application/json; charset=utf-8", "Accept: application/json"})
    @POST("users/me/transactions")
    Completable postNewTransactions(@Body TransactionHistory transactionHistory);
}
