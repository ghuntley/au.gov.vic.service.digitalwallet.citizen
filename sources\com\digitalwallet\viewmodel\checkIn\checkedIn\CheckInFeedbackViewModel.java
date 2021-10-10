package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0010\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckedInBaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "showFeedbackSuccess", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getShowFeedbackSuccess", "()Landroidx/lifecycle/MutableLiveData;", "skip", "getSkip", "onSkip", "provideBadFeedback", "provideGoodFeedback", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInFeedbackViewModel.kt */
public final class CheckInFeedbackViewModel extends CheckedInBaseViewModel {
    private final AnalyticsHelper analytics;
    private final MutableLiveData<ActionEvent<Unit>> showFeedbackSuccess = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> skip = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CheckInFeedbackViewModel(Context context, CheckInRepository checkInRepository, AnalyticsHelper analyticsHelper) {
        super(context, checkInRepository);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checkInRepository, "checkInRepository");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.analytics = analyticsHelper;
    }

    public final MutableLiveData<ActionEvent<Unit>> getSkip() {
        return this.skip;
    }

    public final MutableLiveData<ActionEvent<Unit>> getShowFeedbackSuccess() {
        return this.showFeedbackSuccess;
    }

    public final void provideGoodFeedback() {
        AnalyticsHelper.selectContent$default(this.analytics, "Button click - Check in feedback - Good", null, 2, null);
        ActionEventKt.post(this.showFeedbackSuccess);
    }

    public final void provideBadFeedback() {
        AnalyticsHelper.selectContent$default(this.analytics, "Button click - Check in feedback - Bad", null, 2, null);
        ActionEventKt.post(this.showFeedbackSuccess);
    }

    public final void onSkip() {
        AnalyticsHelper.selectContent$default(this.analytics, "Button click - Check in feedback - Skip", null, 2, null);
        ActionEventKt.post(this.skip);
    }
}
