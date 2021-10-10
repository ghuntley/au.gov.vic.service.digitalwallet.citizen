package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackSuccessViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckedInBaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "skipped", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getSkipped", "()Landroidx/databinding/ObservableField;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInFeedbackSuccessViewModel.kt */
public final class CheckInFeedbackSuccessViewModel extends CheckedInBaseViewModel {
    private final ObservableField<Boolean> skipped = new ObservableField<>((Boolean) false);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CheckInFeedbackSuccessViewModel(Context context, CheckInRepository checkInRepository) {
        super(context, checkInRepository);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checkInRepository, "checkInRepository");
    }

    public final ObservableField<Boolean> getSkipped() {
        return this.skipped;
    }
}
