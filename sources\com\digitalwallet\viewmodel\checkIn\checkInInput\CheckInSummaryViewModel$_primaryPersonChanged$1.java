package com.digitalwallet.viewmodel.checkIn.checkInInput;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSummaryViewModel$_primaryPersonChanged$1", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSummaryViewModel.kt */
public final class CheckInSummaryViewModel$_primaryPersonChanged$1 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ CheckInSummaryViewModel this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CheckInSummaryViewModel$_primaryPersonChanged$1(CheckInSummaryViewModel checkInSummaryViewModel) {
        this.this$0 = checkInSummaryViewModel;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        PrimaryPersonCheckIn primaryPersonCheckIn = (PrimaryPersonCheckIn) this.this$0.primaryPersonCheckIn.get();
        String str = null;
        CheckIn checkInPayload = primaryPersonCheckIn != null ? primaryPersonCheckIn.getCheckInPayload() : null;
        ObservableField<PersonRowViewModel> primaryPersonRowVM = this.this$0.getPrimaryPersonRowVM();
        String firstName = checkInPayload != null ? checkInPayload.getFirstName() : null;
        String lastName = checkInPayload != null ? checkInPayload.getLastName() : null;
        if (checkInPayload != null) {
            str = checkInPayload.getPhoneNumber();
        }
        primaryPersonRowVM.set(new PersonRowViewModel(false, true, firstName, lastName, str, CheckInSummaryViewModel$_primaryPersonChanged$1$onPropertyChanged$1.INSTANCE, new CheckInSummaryViewModel$_primaryPersonChanged$1$onPropertyChanged$2(this, primaryPersonCheckIn)));
    }
}
