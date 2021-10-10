package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001cB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011J\b\u0010\u001b\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00110\u00110\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckedInDetailFavouringBaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "finishCheckInFlow", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel$FinishCheckInFlowType;", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getFinishCheckInFlow", "()Landroidx/lifecycle/MutableLiveData;", "hasCheckedIn", "", "getHasCheckedIn", "()Z", "isInstantApp", "Landroidx/databinding/ObservableField;", "kotlin.jvm.PlatformType", "()Landroidx/databinding/ObservableField;", "onClose", "", "isBack", "onDone", "FinishCheckInFlowType", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSuccessViewModel.kt */
public final class CheckInSuccessViewModel extends CheckedInDetailFavouringBaseViewModel {
    private final AnalyticsHelper analytics;
    private final MutableLiveData<ActionEvent<FinishCheckInFlowType>> finishCheckInFlow;
    private final boolean hasCheckedIn;
    private final ObservableField<Boolean> isInstantApp = new ObservableField<>((Boolean) false);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel$FinishCheckInFlowType;", "", "(Ljava/lang/String;I)V", "WITH_FAVOURITE_ADDED", "WITH_FAVOURITE_REMOVED", "NO_FAVOURITE_CHANGE", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInSuccessViewModel.kt */
    public enum FinishCheckInFlowType {
        WITH_FAVOURITE_ADDED,
        WITH_FAVOURITE_REMOVED,
        NO_FAVOURITE_CHANGE
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CheckInSuccessViewModel(Context context, CheckInRepository checkInRepository, AnalyticsHelper analyticsHelper) {
        super(context, checkInRepository);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checkInRepository, "checkInRepository");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.analytics = analyticsHelper;
        this.hasCheckedIn = checkInRepository.rememberHasCheckedIn();
        this.finishCheckInFlow = new MutableLiveData<>();
    }

    public final ObservableField<Boolean> isInstantApp() {
        return this.isInstantApp;
    }

    public final boolean getHasCheckedIn() {
        return this.hasCheckedIn;
    }

    public final MutableLiveData<ActionEvent<FinishCheckInFlowType>> getFinishCheckInFlow() {
        return this.finishCheckInFlow;
    }

    public static /* synthetic */ void onClose$default(CheckInSuccessViewModel checkInSuccessViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        checkInSuccessViewModel.onClose(z);
    }

    public final void onClose(boolean z) {
        FinishCheckInFlowType finishCheckInFlowType;
        if (z) {
            AnalyticsHelper.selectContent$default(this.analytics, "Button click - Back on check-in success", null, 2, null);
        } else {
            AnalyticsHelper.selectContent$default(this.analytics, "Button click - Done on check-in success", null, 2, null);
        }
        addOrRemoveAFavourite();
        MutableLiveData<ActionEvent<FinishCheckInFlowType>> mutableLiveData = this.finishCheckInFlow;
        boolean z2 = getShouldFavour().get();
        if (z2 == getWasFavoured()) {
            finishCheckInFlowType = FinishCheckInFlowType.NO_FAVOURITE_CHANGE;
        } else if (z2) {
            finishCheckInFlowType = FinishCheckInFlowType.WITH_FAVOURITE_ADDED;
        } else if (!z2) {
            finishCheckInFlowType = FinishCheckInFlowType.WITH_FAVOURITE_REMOVED;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ActionEventKt.postEvent(mutableLiveData, finishCheckInFlowType);
    }

    @Override // com.digitalwallet.viewmodel.checkIn.checkedIn.CheckedInDetailFavouringBaseViewModel
    public void onDone() {
        onClose(false);
    }
}
