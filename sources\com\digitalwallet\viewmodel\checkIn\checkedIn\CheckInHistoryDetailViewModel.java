package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\nJ\b\u0010\u000f\u001a\u00020\nH\u0016R'\u0010\u0007\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInHistoryDetailViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckedInDetailFavouringBaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "backEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getBackEvent", "()Landroidx/lifecycle/MutableLiveData;", "onBack", "onDone", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInHistoryDetailViewModel.kt */
public final class CheckInHistoryDetailViewModel extends CheckedInDetailFavouringBaseViewModel {
    private final MutableLiveData<ActionEvent<Unit>> backEvent = new MutableLiveData<>();

    @Override // com.digitalwallet.viewmodel.checkIn.checkedIn.CheckedInDetailFavouringBaseViewModel
    public void onDone() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CheckInHistoryDetailViewModel(Context context, CheckInRepository checkInRepository) {
        super(context, checkInRepository);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checkInRepository, "checkInRepository");
    }

    public final MutableLiveData<ActionEvent<Unit>> getBackEvent() {
        return this.backEvent;
    }

    public final void onBack() {
        ActionEventKt.post(this.backEvent);
    }
}
