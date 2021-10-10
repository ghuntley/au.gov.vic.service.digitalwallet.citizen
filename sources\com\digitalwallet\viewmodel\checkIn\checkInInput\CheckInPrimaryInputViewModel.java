package com.digitalwallet.viewmodel.checkIn.checkInInput;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.ResponseTypeValues;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0006\u0010!\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR?\u0010\u000e\u001a0\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\t0\bj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR'\u0010\u0013\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006\""}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInPrimaryInputViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "navigateToAddDependant", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getNavigateToAddDependant", "()Landroidx/lifecycle/MutableLiveData;", "navigateToSubmitting", "Lkotlin/Pair;", "Lcom/digitalwallet/model/CheckIn;", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "getNavigateToSubmitting", "navigateToSummary", "getNavigateToSummary", "shouldSavePrimaryPerson", "Landroidx/databinding/ObservableBoolean;", "getShouldSavePrimaryPerson", "()Landroidx/databinding/ObservableBoolean;", "showBack", "getShowBack", "onCheckIn", "", "setup", ResponseTypeValues.CODE, "storeOrDeletePrimaryDetails", "checkIn", "toAddDependants", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInPrimaryInputViewModel.kt */
public final class CheckInPrimaryInputViewModel extends CheckInInputBaseViewModel {
    private final AnalyticsHelper analytics;
    private final CheckInRepository checkInRepository;
    private final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> navigateToAddDependant = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Pair<CheckIn, CheckInUtils.CheckInCode>>> navigateToSubmitting = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> navigateToSummary = new MutableLiveData<>();
    private final ObservableBoolean shouldSavePrimaryPerson = new ObservableBoolean(false);
    private final ObservableBoolean showBack = new ObservableBoolean(false);

    @Inject
    public CheckInPrimaryInputViewModel(CheckInRepository checkInRepository2, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.checkInRepository = checkInRepository2;
        this.analytics = analyticsHelper;
    }

    public final ObservableBoolean getShowBack() {
        return this.showBack;
    }

    public final ObservableBoolean getShouldSavePrimaryPerson() {
        return this.shouldSavePrimaryPerson;
    }

    public final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> getNavigateToAddDependant() {
        return this.navigateToAddDependant;
    }

    public final MutableLiveData<ActionEvent<PrimaryPersonCheckIn>> getNavigateToSummary() {
        return this.navigateToSummary;
    }

    public final MutableLiveData<ActionEvent<Pair<CheckIn, CheckInUtils.CheckInCode>>> getNavigateToSubmitting() {
        return this.navigateToSubmitting;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        if ((r0 == null || kotlin.text.StringsKt.isBlank(r0)) == false) goto L_0x007f;
     */
    public final void setup(CheckInUtils.CheckInCode checkInCode) {
        Intrinsics.checkNotNullParameter(checkInCode, ResponseTypeValues.CODE);
        getCheckInCode().set(checkInCode);
        getFirstName().set(this.checkInRepository.getStoredFirstName());
        getLastName().set(this.checkInRepository.getStoredLastName());
        getPhoneNumber().set(this.checkInRepository.getStoredPhoneNumber());
        ObservableBoolean observableBoolean = this.shouldSavePrimaryPerson;
        String str = getFirstName().get();
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            String str2 = getLastName().get();
            if (str2 == null || StringsKt.isBlank(str2)) {
                String str3 = getPhoneNumber().get();
            }
        }
        z = true;
        observableBoolean.set(z);
    }

    public final void toAddDependants() {
        Pair<CheckIn, CheckInUtils.CheckInCode> checkInInfo = super.getCheckInInfo();
        if (checkInInfo != null) {
            CheckIn component1 = checkInInfo.component1();
            storeOrDeletePrimaryDetails(component1);
            PrimaryPersonCheckIn primaryPersonCheckIn = new PrimaryPersonCheckIn(component1, checkInInfo.component2(), this.shouldSavePrimaryPerson.get());
            if (this.checkInRepository.getSavedDependants().isEmpty()) {
                ActionEventKt.postEvent(this.navigateToAddDependant, primaryPersonCheckIn);
            } else {
                ActionEventKt.postEvent(this.navigateToSummary, primaryPersonCheckIn);
            }
        }
    }

    public final void onCheckIn() {
        AnalyticsHelper.selectContent$default(this.analytics, "Button click - Check in to this location", null, 2, null);
        Pair<CheckIn, CheckInUtils.CheckInCode> checkInInfo = super.getCheckInInfo();
        if (checkInInfo != null) {
            CheckIn component1 = checkInInfo.component1();
            storeOrDeletePrimaryDetails(component1);
            ActionEventKt.postEvent(this.navigateToSubmitting, TuplesKt.to(component1, checkInInfo.component2()));
        }
    }

    private final void storeOrDeletePrimaryDetails(CheckIn checkIn) {
        if (this.shouldSavePrimaryPerson.get()) {
            AnalyticsHelper.selectContent$default(this.analytics, "Switch selected - Save my details for next time", null, 2, null);
            this.checkInRepository.storeCheckInUserDetail(checkIn);
            return;
        }
        AnalyticsHelper.selectContent$default(this.analytics, "Switch selected - Don't save my details", null, 2, null);
        this.checkInRepository.clearCheckInUserDetail();
    }
}
