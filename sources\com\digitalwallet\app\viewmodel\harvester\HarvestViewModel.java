package com.digitalwallet.app.viewmodel.harvester;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/viewmodel/harvester/HarvestViewModel;", "", "database", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "(Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;)V", "getDatabase", "()Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestViewModel.kt */
public final class HarvestViewModel {
    private final DigitalWalletDatabase database;

    @Inject
    public HarvestViewModel(DigitalWalletDatabase digitalWalletDatabase) {
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "database");
        this.database = digitalWalletDatabase;
    }

    public final DigitalWalletDatabase getDatabase() {
        return this.database;
    }
}
