package com.digitalwallet.app.model.db.unsecure;

import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0006J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u000fJ\u001f\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/db/unsecure/UnsecuredStore;", "", "holdingDao", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHoldingDao;", "(Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHoldingDao;)V", "addAll", "Lio/reactivex/Completable;", "item", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "([Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;)Lio/reactivex/Completable;", "delete", HoldingExpiryPublisher.HOLDING_KEY, "deleteAll", "get", "Lio/reactivex/Single;", "id", "", "getAll", "", "updateAll", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnsecuredStore.kt */
public final class UnsecuredStore {
    private final UnsecuredHoldingDao holdingDao;

    @Inject
    public UnsecuredStore(UnsecuredHoldingDao unsecuredHoldingDao) {
        Intrinsics.checkNotNullParameter(unsecuredHoldingDao, "holdingDao");
        this.holdingDao = unsecuredHoldingDao;
    }

    public final Completable delete(UnsecuredHolding unsecuredHolding) {
        Intrinsics.checkNotNullParameter(unsecuredHolding, HoldingExpiryPublisher.HOLDING_KEY);
        Completable fromCallable = Completable.fromCallable(new UnsecuredStore$delete$1(this, unsecuredHolding));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…dingRoom(holding)\n    ) }");
        return fromCallable;
    }

    public final Completable deleteAll() {
        Completable fromCallable = Completable.fromCallable(new UnsecuredStore$deleteAll$1(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable… holdingDao.deleteAll() }");
        return fromCallable;
    }

    public final Single<UnsecuredHolding> get(int i) {
        Single<UnsecuredHolding> fromCallable = Single.fromCallable(new UnsecuredStore$get$1(this, i));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable { holdingDao.findById(id) }");
        return fromCallable;
    }

    public final Single<List<UnsecuredHolding>> getAll() {
        Single<List<UnsecuredHolding>> fromCallable = Single.fromCallable(new UnsecuredStore$getAll$1(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable { holdingDao.getAll() }");
        return fromCallable;
    }

    public final Completable addAll(UnsecuredHolding... unsecuredHoldingArr) {
        Intrinsics.checkNotNullParameter(unsecuredHoldingArr, "item");
        if (unsecuredHoldingArr != null) {
            ArrayList arrayList = new ArrayList(unsecuredHoldingArr.length);
            for (UnsecuredHolding unsecuredHolding : unsecuredHoldingArr) {
                arrayList.add(new UnsecuredHoldingRoom(unsecuredHolding));
            }
            Object[] array = arrayList.toArray(new UnsecuredHoldingRoom[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Completable fromCallable = Completable.fromCallable(new UnsecuredStore$addAll$1(this, (UnsecuredHoldingRoom[]) array));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…nsertAll(*roomHoldings) }");
            return fromCallable;
        }
        throw new IllegalArgumentException("Unable to intake UnsecuredHoldings as array.");
    }

    public final Completable updateAll(UnsecuredHolding... unsecuredHoldingArr) {
        Intrinsics.checkNotNullParameter(unsecuredHoldingArr, "item");
        if (unsecuredHoldingArr != null) {
            ArrayList arrayList = new ArrayList(unsecuredHoldingArr.length);
            for (UnsecuredHolding unsecuredHolding : unsecuredHoldingArr) {
                arrayList.add(new UnsecuredHoldingRoom(unsecuredHolding));
            }
            Object[] array = arrayList.toArray(new UnsecuredHoldingRoom[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Completable fromCallable = Completable.fromCallable(new UnsecuredStore$updateAll$1(this, (UnsecuredHoldingRoom[]) array));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…pdateAll(*roomHoldings) }");
            return fromCallable;
        }
        throw new IllegalArgumentException("Unable to intake UnsecuredHoldings as array.");
    }
}
