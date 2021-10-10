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
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u001a\u0010\u001b\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u001c\u001a\u00020\bR'\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R'\u0010\u000e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0006j\b\u0012\u0004\u0012\u00020\r`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR'\u0010\u0010\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0006j\b\u0012\u0004\u0012\u00020\r`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R'\u0010\u0017\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0016`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInEditPersonInputViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "cancelEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getCancelEvent", "()Landroidx/lifecycle/MutableLiveData;", "dependantCheckIn", "Lcom/digitalwallet/model/DependantCheckIn;", "dependantDeletedEvent", "getDependantDeletedEvent", "dependantEditedEvent", "getDependantEditedEvent", "isEditingPrimaryPerson", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "primaryPersonCheckIn", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "primaryPersonEditedEvent", "getPrimaryPersonEditedEvent", "cancel", "deleteDependant", "setup", "update", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInEditPersonInputViewModel.kt */
public final class CheckInEditPersonInputViewModel extends CheckInInputBaseViewModel {
    private final MutableLiveData<ActionEvent<Unit>> cancelEvent = new MutableLiveData<>();
    private final CheckInRepository checkInRepository;
    private DependantCheckIn dependantCheckIn;
    private final MutableLiveData<ActionEvent<DependantCheckIn>> dependantDeletedEvent = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<DependantCheckIn>> dependantEditedEvent = new MutableLiveData<>();
    private final ObservableBoolean isEditingPrimaryPerson = new ObservableBoolean();
    private PrimaryPersonCheckIn primaryPersonCheckIn;
    private final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> primaryPersonEditedEvent = new MutableLiveData<>();

    @Inject
    public CheckInEditPersonInputViewModel(CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.checkInRepository = checkInRepository2;
    }

    public final ObservableBoolean isEditingPrimaryPerson() {
        return this.isEditingPrimaryPerson;
    }

    public final MutableLiveData<ActionEvent<Unit>> getCancelEvent() {
        return this.cancelEvent;
    }

    public final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> getPrimaryPersonEditedEvent() {
        return this.primaryPersonEditedEvent;
    }

    public final MutableLiveData<ActionEvent<DependantCheckIn>> getDependantEditedEvent() {
        return this.dependantEditedEvent;
    }

    public final MutableLiveData<ActionEvent<DependantCheckIn>> getDependantDeletedEvent() {
        return this.dependantDeletedEvent;
    }

    public final void setup(PrimaryPersonCheckIn primaryPersonCheckIn2, DependantCheckIn dependantCheckIn2) {
        boolean z = true;
        boolean z2 = false;
        if (primaryPersonCheckIn2 != null) {
            if (dependantCheckIn2 == null) {
                z2 = true;
            }
            if (z2) {
                this.isEditingPrimaryPerson.set(true);
                this.primaryPersonCheckIn = primaryPersonCheckIn2;
                CheckIn checkInPayload = primaryPersonCheckIn2.getCheckInPayload();
                getFirstName().set(checkInPayload.getFirstName());
                getLastName().set(checkInPayload.getLastName());
                getPhoneNumber().set(checkInPayload.getPhoneNumber());
                getRequirePhoneNumber().set(true);
                getCheckInCode().set(primaryPersonCheckIn2.getCheckInCode());
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        if (dependantCheckIn2 == null) {
            z = false;
        }
        if (z) {
            this.isEditingPrimaryPerson.set(false);
            this.dependantCheckIn = dependantCheckIn2;
            CheckInGuest guestPayload = dependantCheckIn2.getGuestPayload();
            getFirstName().set(guestPayload.getFirstName());
            getLastName().set(guestPayload.getLastName());
            getPhoneNumber().set(guestPayload.getPhoneNumber());
            getRequirePhoneNumber().set(false);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void cancel() {
        ActionEventKt.post(this.cancelEvent);
    }

    public final void deleteDependant() {
        if (!this.isEditingPrimaryPerson.get()) {
            DependantCheckIn dependantCheckIn2 = this.dependantCheckIn;
            if (dependantCheckIn2 != null) {
                this.checkInRepository.deleteACheckInDependantIfExists(dependantCheckIn2);
                ActionEventKt.postEvent(this.dependantDeletedEvent, dependantCheckIn2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void update() {
        Pair<CheckIn, CheckInUtils.CheckInCode> checkInInfo = super.getCheckInInfo();
        if (checkInInfo != null) {
            CheckIn component1 = checkInInfo.component1();
            PrimaryPersonCheckIn primaryPersonCheckIn2 = this.primaryPersonCheckIn;
            if (primaryPersonCheckIn2 != null) {
                PrimaryPersonCheckIn primaryPersonCheckIn3 = new PrimaryPersonCheckIn(component1, primaryPersonCheckIn2.getCheckInCode(), primaryPersonCheckIn2.getShouldSave());
                if (primaryPersonCheckIn2.getShouldSave()) {
                    this.checkInRepository.storeCheckInUserDetail(component1);
                }
                ActionEventKt.postEvent(this.primaryPersonEditedEvent, primaryPersonCheckIn3);
            }
            DependantCheckIn dependantCheckIn2 = this.dependantCheckIn;
            if (dependantCheckIn2 != null) {
                DependantCheckIn dependantCheckIn3 = new DependantCheckIn(new CheckInGuest(component1.getFirstName(), component1.getLastName(), component1.getPhoneNumber()), dependantCheckIn2.getInternalId(), dependantCheckIn2.getShouldSave());
                if (dependantCheckIn2.getShouldSave()) {
                    this.checkInRepository.storeOrUpdateACheckInDependant(dependantCheckIn3);
                }
                ActionEventKt.postEvent(this.dependantEditedEvent, dependantCheckIn3);
            }
        }
    }
}
