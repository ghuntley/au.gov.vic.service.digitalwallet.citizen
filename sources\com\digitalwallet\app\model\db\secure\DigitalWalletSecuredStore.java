package com.digitalwallet.app.model.db.secure;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.google.firebase.messaging.Constants;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0006\u0010\u000f\u001a\u00020\u0006J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00150\u00112\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/model/db/secure/DigitalWalletSecuredStore;", "Lcom/digitalwallet/app/model/db/secure/SecureStore;", "database", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "(Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;)V", "addAll", "Lio/reactivex/Completable;", "item", "", "Lcom/digitalwallet/app/model/db/secure/SecuredData;", "to", "Lcom/digitalwallet/app/model/db/secure/SecuredDWTable;", "([Lcom/digitalwallet/app/model/db/secure/SecuredData;Lcom/digitalwallet/app/model/db/secure/SecuredDWTable;)Lio/reactivex/Completable;", "delete", Constants.MessagePayloadKeys.FROM, "deleteAll", "get", "Lio/reactivex/Single;", "id", "", "getAll", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SecuredStore.kt */
public final class DigitalWalletSecuredStore implements SecureStore {
    private final DigitalWalletDatabase database;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[SecuredDWTable.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[SecuredDWTable.SecuredHoldings.ordinal()] = 1;
            int[] iArr2 = new int[SecuredDWTable.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[SecuredDWTable.SecuredHoldings.ordinal()] = 1;
            int[] iArr3 = new int[SecuredDWTable.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[SecuredDWTable.SecuredHoldings.ordinal()] = 1;
            int[] iArr4 = new int[SecuredDWTable.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[SecuredDWTable.SecuredHoldings.ordinal()] = 1;
        }
    }

    @Inject
    public DigitalWalletSecuredStore(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "database");
        this.database = digitalWalletDatabase;
    }

    @Override // com.digitalwallet.app.model.db.secure.SecureStore
    public Completable addAll(SecuredData[] securedDataArr, SecuredDWTable securedDWTable) {
        Intrinsics.checkNotNullParameter(securedDataArr, "item");
        Intrinsics.checkNotNullParameter(securedDWTable, "to");
        if (WhenMappings.$EnumSwitchMapping$0[securedDWTable.ordinal()] == 1) {
            if (((EncryptedSecureHoldings[]) (!(securedDataArr instanceof EncryptedSecureHoldings[]) ? null : securedDataArr)) != null) {
                Completable fromCallable = Completable.fromCallable(new DigitalWalletSecuredStore$addAll$1(this, securedDataArr));
                Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…gDao().insertAll(*item) }");
                return fromCallable;
            }
            throw new IllegalArgumentException("SecuredData type must match its table");
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.digitalwallet.app.model.db.secure.SecureStore
    public Completable delete(SecuredData securedData, SecuredDWTable securedDWTable) {
        Intrinsics.checkNotNullParameter(securedData, "item");
        Intrinsics.checkNotNullParameter(securedDWTable, Constants.MessagePayloadKeys.FROM);
        if (WhenMappings.$EnumSwitchMapping$1[securedDWTable.ordinal()] == 1) {
            Completable fromCallable = Completable.fromCallable(new DigitalWalletSecuredStore$delete$1(this, securedData));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…SecureHoldings)\n        }");
            return fromCallable;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.digitalwallet.app.model.db.secure.SecureStore
    public Single<SecuredData> get(int i, SecuredDWTable securedDWTable) {
        Intrinsics.checkNotNullParameter(securedDWTable, Constants.MessagePayloadKeys.FROM);
        if (WhenMappings.$EnumSwitchMapping$2[securedDWTable.ordinal()] == 1) {
            Single<SecuredData> fromCallable = Single.fromCallable(new DigitalWalletSecuredStore$get$1(this, i));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable { da…ldingDao().findById(id) }");
            return fromCallable;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.digitalwallet.app.model.db.secure.SecureStore
    public Single<List<SecuredData>> getAll(SecuredDWTable securedDWTable) {
        Intrinsics.checkNotNullParameter(securedDWTable, Constants.MessagePayloadKeys.FROM);
        if (WhenMappings.$EnumSwitchMapping$3[securedDWTable.ordinal()] == 1) {
            Single<List<SecuredData>> fromCallable = Single.fromCallable(new DigitalWalletSecuredStore$getAll$1(this));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable { da…edHoldingDao().getAll() }");
            return fromCallable;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Completable deleteAll() {
        Completable fromCallable = Completable.fromCallable(new DigitalWalletSecuredStore$deleteAll$1(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…oldingDao().deleteAll() }");
        return fromCallable;
    }
}
