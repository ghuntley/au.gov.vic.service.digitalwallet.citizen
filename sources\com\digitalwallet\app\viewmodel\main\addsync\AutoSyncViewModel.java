package com.digitalwallet.app.viewmodel.main.addsync;

import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/addsync/AutoSyncViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "authUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "autoSyncEnabled", "Landroidx/lifecycle/MutableLiveData;", "", "getAutoSyncEnabled", "()Landroidx/lifecycle/MutableLiveData;", "automaticClicked", "", "manualClicked", "updateStatus", "shouldUpdate", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AutoSyncViewModel.kt */
public final class AutoSyncViewModel extends BaseViewModel {
    private final AuthenticationUtility authUtility;
    private final MutableLiveData<Boolean> autoSyncEnabled = new MutableLiveData<>();

    @Inject
    public AutoSyncViewModel(AuthenticationUtility authenticationUtility) {
        Intrinsics.checkNotNullParameter(authenticationUtility, "authUtility");
        this.authUtility = authenticationUtility;
    }

    public final MutableLiveData<Boolean> getAutoSyncEnabled() {
        return this.autoSyncEnabled;
    }

    public final void automaticClicked() {
        updateStatus(true);
    }

    public final void manualClicked() {
        updateStatus(false);
    }

    private final void updateStatus(boolean z) {
        this.authUtility.setAutoUpdateState(z);
        this.autoSyncEnabled.setValue(Boolean.valueOf(z));
    }
}
