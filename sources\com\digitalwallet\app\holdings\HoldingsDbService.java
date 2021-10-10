package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.secure.DigitalWalletSecuredStore;
import com.digitalwallet.app.model.db.secure.EncryptedSecureHoldings;
import com.digitalwallet.app.model.db.secure.SecuredDWTable;
import com.digitalwallet.app.model.db.secure.SecuredData;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.app.model.db.unsecure.UnsecuredStore;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0011J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\r0\u0011J\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/holdings/HoldingsDbService;", "", "securedStore", "Lcom/digitalwallet/app/model/db/secure/DigitalWalletSecuredStore;", "unsecuredStore", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredStore;", "(Lcom/digitalwallet/app/model/db/secure/DigitalWalletSecuredStore;Lcom/digitalwallet/app/model/db/unsecure/UnsecuredStore;)V", "clearSecuredHoldings", "Lio/reactivex/Completable;", "encryptHoldings", "", "Lcom/digitalwallet/app/model/db/secure/EncryptedSecureHoldings;", "holdings", "", "Lcom/digitalwallet/app/model/SecureHolding;", "(Ljava/util/List;)[Lcom/digitalwallet/app/model/db/secure/EncryptedSecureHoldings;", "getSecureHoldings", "Lio/reactivex/Single;", "getUnsecuredHoldings", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "storeSecureHoldings", "storeUnsecuredHoldings", "remoteHoldings", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingsDbService.kt */
public final class HoldingsDbService {
    private final DigitalWalletSecuredStore securedStore;
    private final UnsecuredStore unsecuredStore;

    @Inject
    public HoldingsDbService(DigitalWalletSecuredStore digitalWalletSecuredStore, UnsecuredStore unsecuredStore2) {
        Intrinsics.checkNotNullParameter(digitalWalletSecuredStore, "securedStore");
        Intrinsics.checkNotNullParameter(unsecuredStore2, "unsecuredStore");
        this.securedStore = digitalWalletSecuredStore;
        this.unsecuredStore = unsecuredStore2;
    }

    public final Single<List<SecureHolding>> getSecureHoldings() {
        Single<R> map = this.securedStore.getAll(SecuredDWTable.SecuredHoldings).map(HoldingsDbService$getSecureHoldings$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "securedStore.getAll(from…) }\n                    }");
        return map;
    }

    public final Single<List<UnsecuredHolding>> getUnsecuredHoldings() {
        return this.unsecuredStore.getAll();
    }

    public final Completable storeSecureHoldings(List<SecureHolding> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        Completable deleteAll = this.securedStore.deleteAll();
        DigitalWalletSecuredStore digitalWalletSecuredStore = this.securedStore;
        EncryptedSecureHoldings[] encryptHoldings = encryptHoldings(list);
        Completable andThen = deleteAll.andThen(digitalWalletSecuredStore.addAll((SecuredData[]) Arrays.copyOf(encryptHoldings, encryptHoldings.length), SecuredDWTable.SecuredHoldings));
        Intrinsics.checkNotNullExpressionValue(andThen, "securedStore.deleteAll()…DWTable.SecuredHoldings))");
        return andThen;
    }

    public final Completable storeUnsecuredHoldings(List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "remoteHoldings");
        Completable flatMapCompletable = this.unsecuredStore.getAll().flatMapCompletable(new HoldingsDbService$storeUnsecuredHoldings$1(this, list));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "unsecuredStore.getAll()\n…e))\n                    }");
        return flatMapCompletable;
    }

    public final Completable clearSecuredHoldings() {
        return this.securedStore.deleteAll();
    }

    private final EncryptedSecureHoldings[] encryptHoldings(List<SecureHolding> list) {
        List<SecureHolding> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            SecuredData secureData = it.next().toSecureData();
            Objects.requireNonNull(secureData, "null cannot be cast to non-null type com.digitalwallet.app.model.db.secure.EncryptedSecureHoldings");
            arrayList.add((EncryptedSecureHoldings) secureData);
        }
        Object[] array = arrayList.toArray(new EncryptedSecureHoldings[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (EncryptedSecureHoldings[]) array;
    }
}
