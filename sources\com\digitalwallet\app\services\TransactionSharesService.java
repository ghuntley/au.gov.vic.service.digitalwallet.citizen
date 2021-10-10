package com.digitalwallet.app.services;

import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.model.db.shares.ShareRecordStore;
import com.digitalwallet.app.model.transaction.TransactionHistory;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import com.digitalwallet.app.model.transaction.TransactionStatusType;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.DateFormattingHelper;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/services/TransactionSharesService;", "", "api", "Lcom/digitalwallet/app/api/HoldingsApi;", "shareStore", "Lcom/digitalwallet/app/model/db/shares/ShareRecordStore;", "(Lcom/digitalwallet/app/api/HoldingsApi;Lcom/digitalwallet/app/model/db/shares/ShareRecordStore;)V", "getShares", "Lio/reactivex/Single;", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "getTransactionHistory", "Lcom/digitalwallet/app/model/transaction/TransactionHistory;", "getTransactionStatusFromHoldingResponse", "Lcom/digitalwallet/app/model/transaction/TransactionStatusType;", "status", "Lcom/digitalwallet/app/model/HoldingResponseStatus;", "postNewTransaction", "Lio/reactivex/Completable;", "holdingName", "", "storeNewShare", "sender", "Lcom/digitalwallet/app/model/SecureHolding;", "receiver", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "shareRecord", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TransactionSharesService.kt */
public final class TransactionSharesService {
    private final HoldingsApi api;
    private final ShareRecordStore shareStore;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HoldingResponseStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HoldingResponseStatus.ACCEPTED.ordinal()] = 1;
            iArr[HoldingResponseStatus.DENIED.ordinal()] = 2;
            int[] iArr2 = new int[AppType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AppType.AUTHORITY.ordinal()] = 1;
            iArr2[AppType.CITIZEN.ordinal()] = 2;
        }
    }

    @Inject
    public TransactionSharesService(HoldingsApi holdingsApi, ShareRecordStore shareRecordStore) {
        Intrinsics.checkNotNullParameter(holdingsApi, "api");
        Intrinsics.checkNotNullParameter(shareRecordStore, "shareStore");
        this.api = holdingsApi;
        this.shareStore = shareRecordStore;
    }

    public final Single<TransactionHistory> getTransactionHistory() {
        return this.api.getTransactionHistory();
    }

    private final TransactionStatusType getTransactionStatusFromHoldingResponse(HoldingResponseStatus holdingResponseStatus) {
        int i = WhenMappings.$EnumSwitchMapping$0[holdingResponseStatus.ordinal()];
        if (i == 1) {
            return TransactionStatusType.SHARED_WITH_AUTHORITY;
        }
        if (i == 2) {
            return TransactionStatusType.DENIED_TO_AUTHORITY;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Completable postNewTransaction(HoldingResponseStatus holdingResponseStatus, String str) {
        Intrinsics.checkNotNullParameter(holdingResponseStatus, "status");
        Intrinsics.checkNotNullParameter(str, "holdingName");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        Completable flatMapCompletable = Single.just(new TransactionHistoryItem(uuid, DateFormattingHelper.INSTANCE.getCurrentTimeInISO8601(), str, null, getTransactionStatusFromHoldingResponse(holdingResponseStatus).getDisplayName(), false, null, 104, null)).map(TransactionSharesService$postNewTransaction$1.INSTANCE).flatMapCompletable(new TransactionSharesService$sam$io_reactivex_functions_Function$0(new TransactionSharesService$postNewTransaction$2(this.api)));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Single.just(TransactionH…api::postNewTransactions)");
        return flatMapCompletable;
    }

    public final Single<List<ShareRecord>> getShares() {
        Single<R> map = this.shareStore.getAll().doOnSuccess(new TransactionSharesService$getShares$1(this)).map(TransactionSharesService$getShares$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "shareStore.getAll()\n    …  }\n                    }");
        return map;
    }

    public final Completable storeNewShare(ShareRecord shareRecord) {
        Intrinsics.checkNotNullParameter(shareRecord, "shareRecord");
        return this.shareStore.addRecord(shareRecord);
    }

    public final Completable storeNewShare(SecureHolding secureHolding, HoldingRecordAttributes holdingRecordAttributes) {
        Intrinsics.checkNotNullParameter(secureHolding, "sender");
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "receiver");
        Completable flatMapCompletable = Single.just(new ShareRecord(secureHolding.getAttributes(), secureHolding.getDynamicDisplay(), secureHolding.getAssets(), holdingRecordAttributes)).flatMapCompletable(new TransactionSharesService$sam$io_reactivex_functions_Function$0(new TransactionSharesService$storeNewShare$1(this.shareStore)));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "Single.just(ShareRecord(…le(shareStore::addRecord)");
        return flatMapCompletable;
    }
}
