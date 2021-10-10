package com.digitalwallet.app.viewmodel.login;

import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/digitalwallet/app/viewmodel/login/RegisterSuccessViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "createPasscodeEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getCreatePasscodeEvent", "()Landroidx/lifecycle/MutableLiveData;", "createAPasscode", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RegisterSuccessViewModel.kt */
public final class RegisterSuccessViewModel extends BaseViewModel {
    private final AnalyticsHelper analytics;
    private final MutableLiveData<ActionEvent<Unit>> createPasscodeEvent = new MutableLiveData<>();

    @Inject
    public RegisterSuccessViewModel(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.analytics = analyticsHelper;
    }

    public final MutableLiveData<ActionEvent<Unit>> getCreatePasscodeEvent() {
        return this.createPasscodeEvent;
    }

    public final void createAPasscode() {
        AnalyticsHelper.selectContent$default(this.analytics, "Button click - Registration successful screen - Create a passcode", null, 2, null);
        ActionEventKt.post(this.createPasscodeEvent);
    }
}
