package com.digitalwallet.viewmodel.checkIn.checkInInput;

import androidx.databinding.Observable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/digitalwallet/viewmodel/checkIn/checkInInput/PersonRowViewModel$_checkChanged$1", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSummaryViewModel.kt */
public final class PersonRowViewModel$_checkChanged$1 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ PersonRowViewModel this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    PersonRowViewModel$_checkChanged$1(PersonRowViewModel personRowViewModel) {
        this.this$0 = personRowViewModel;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        this.this$0.onCheckChanged.invoke();
    }
}
