package com.digitalwallet.view.checkIn.checkInInput;

import android.view.LayoutInflater;
import androidx.databinding.Observable;
import com.digitalwallet.databinding.FragmentCheckInSummaryBinding;
import com.digitalwallet.databinding.ItemCheckInPersonRowBinding;
import com.digitalwallet.viewmodel.checkIn.checkInInput.PersonRowViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/digitalwallet/view/checkIn/checkInInput/CheckInSummaryFragment$setupViews$3", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSummaryFragment.kt */
public final class CheckInSummaryFragment$setupViews$3 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ CheckInSummaryFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CheckInSummaryFragment$setupViews$3(CheckInSummaryFragment checkInSummaryFragment) {
        this.this$0 = checkInSummaryFragment;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        ((FragmentCheckInSummaryBinding) this.this$0.getBinding()).dependantList.removeAllViews();
        List<PersonRowViewModel> list = this.this$0.getViewModel().getDependantRowVMs().get();
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ItemCheckInPersonRowBinding inflate = ItemCheckInPersonRowBinding.inflate(LayoutInflater.from(this.this$0.getContext()), ((FragmentCheckInSummaryBinding) this.this$0.getBinding()).dependantList, true);
                Intrinsics.checkNotNullExpressionValue(inflate, "ItemCheckInPersonRowBind…ding.dependantList, true)");
                inflate.setVm(it.next());
            }
        }
    }
}
