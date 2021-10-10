package com.digitalwallet.viewmodel.checkIn.checkInInput;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.CheckInGuest;
import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\bJ\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\bR'\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR?\u0010\u0010\u001a0\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u00070\u0006j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInAddDependantInputViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "cancelEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getCancelEvent", "()Landroidx/lifecycle/MutableLiveData;", "fullScreenMode", "Landroidx/databinding/ObservableBoolean;", "getFullScreenMode", "()Landroidx/databinding/ObservableBoolean;", "navigateToSummary", "Lkotlin/Pair;", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "Lcom/digitalwallet/model/DependantCheckIn;", "getNavigateToSummary", "newDependantId", "", "primaryPersonCheckIn", "shouldSaveDependant", "getShouldSaveDependant", "cancel", "setup", "", "toContinue", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInAddDependantInputViewModel.kt */
public final class CheckInAddDependantInputViewModel extends CheckInInputBaseViewModel {
    private final MutableLiveData<ActionEvent<Unit>> cancelEvent;
    private final CheckInRepository checkInRepository;
    private final ObservableBoolean fullScreenMode = new ObservableBoolean();
    private final MutableLiveData<ActionEvent<Pair<PrimaryPersonCheckIn, DependantCheckIn>>> navigateToSummary;
    private final String newDependantId;
    private PrimaryPersonCheckIn primaryPersonCheckIn;
    private final ObservableBoolean shouldSaveDependant = new ObservableBoolean(false);

    @Inject
    public CheckInAddDependantInputViewModel(CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.checkInRepository = checkInRepository2;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        this.newDependantId = uuid;
        this.cancelEvent = new MutableLiveData<>();
        this.navigateToSummary = new MutableLiveData<>();
    }

    public final ObservableBoolean getFullScreenMode() {
        return this.fullScreenMode;
    }

    public final ObservableBoolean getShouldSaveDependant() {
        return this.shouldSaveDependant;
    }

    public final MutableLiveData<ActionEvent<Unit>> getCancelEvent() {
        return this.cancelEvent;
    }

    public final MutableLiveData<ActionEvent<Pair<PrimaryPersonCheckIn, DependantCheckIn>>> getNavigateToSummary() {
        return this.navigateToSummary;
    }

    public final void setup(PrimaryPersonCheckIn primaryPersonCheckIn2, boolean z) {
        Intrinsics.checkNotNullParameter(primaryPersonCheckIn2, "primaryPersonCheckIn");
        getCheckInCode().set(primaryPersonCheckIn2.getCheckInCode());
        getRequirePhoneNumber().set(false);
        this.primaryPersonCheckIn = primaryPersonCheckIn2;
        this.fullScreenMode.set(z);
    }

    public final void cancel() {
        ActionEventKt.post(this.cancelEvent);
    }

    public final void toContinue() {
        Pair<CheckIn, CheckInUtils.CheckInCode> checkInInfo = super.getCheckInInfo();
        if (checkInInfo != null) {
            CheckIn component1 = checkInInfo.component1();
            DependantCheckIn dependantCheckIn = new DependantCheckIn(new CheckInGuest(component1.getFirstName(), component1.getLastName(), component1.getPhoneNumber()), this.newDependantId, this.shouldSaveDependant.get());
            if (this.shouldSaveDependant.get()) {
                this.checkInRepository.storeOrUpdateACheckInDependant(dependantCheckIn);
            } else {
                this.checkInRepository.deleteACheckInDependantIfExists(dependantCheckIn);
            }
            MutableLiveData<ActionEvent<Pair<PrimaryPersonCheckIn, DependantCheckIn>>> mutableLiveData = this.navigateToSummary;
            PrimaryPersonCheckIn primaryPersonCheckIn2 = this.primaryPersonCheckIn;
            if (primaryPersonCheckIn2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryPersonCheckIn");
            }
            ActionEventKt.postEvent(mutableLiveData, TuplesKt.to(primaryPersonCheckIn2, dependantCheckIn));
        }
    }
}
