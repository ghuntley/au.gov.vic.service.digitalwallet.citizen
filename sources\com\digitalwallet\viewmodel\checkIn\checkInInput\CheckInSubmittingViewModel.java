package com.digitalwallet.viewmodel.checkIn.checkInInput;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0016\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R'\u0010\n\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R?\u0010\u0011\u001a0\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00120\f0\u000bj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R'\u0010\u0015\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\f0\u000bj\b\u0012\u0004\u0012\u00020\u0016`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R'\u0010\u0018\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\f0\u000bj\b\u0012\u0004\u0012\u00020\u0016`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSubmittingViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "isInstantApp", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "loadingSpinnerVisible", "getLoadingSpinnerVisible", "navigateToFeedback", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "Lcom/digitalwallet/model/CheckIn;", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getNavigateToFeedback", "()Landroidx/lifecycle/MutableLiveData;", "navigateToSuccess", "Lkotlin/Pair;", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "getNavigateToSuccess", "showPopUpOfNetworkIssue", "", "getShowPopUpOfNetworkIssue", "showPopUpOfNoInternetConnection", "getShowPopUpOfNoInternetConnection", "doOnCheckInSuccess", "checkInPayload", "checkInCode", "submitCheckInInfo", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSubmittingViewModel.kt */
public final class CheckInSubmittingViewModel extends BaseViewModel {
    private final CheckInRepository checkInRepository;
    private final ObservableBoolean isInstantApp = new ObservableBoolean(false);
    private final ObservableBoolean loadingSpinnerVisible = new ObservableBoolean(false);
    private final MutableLiveData<ActionEvent<CheckIn>> navigateToFeedback = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Pair<CheckIn, CheckInUtils.CheckInCode>>> navigateToSuccess = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> showPopUpOfNetworkIssue = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> showPopUpOfNoInternetConnection = new MutableLiveData<>();

    @Inject
    public CheckInSubmittingViewModel(CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.checkInRepository = checkInRepository2;
    }

    public final ObservableBoolean isInstantApp() {
        return this.isInstantApp;
    }

    public final ObservableBoolean getLoadingSpinnerVisible() {
        return this.loadingSpinnerVisible;
    }

    public final MutableLiveData<ActionEvent<CheckIn>> getNavigateToFeedback() {
        return this.navigateToFeedback;
    }

    public final MutableLiveData<ActionEvent<Pair<CheckIn, CheckInUtils.CheckInCode>>> getNavigateToSuccess() {
        return this.navigateToSuccess;
    }

    public final MutableLiveData<ActionEvent<Unit>> getShowPopUpOfNetworkIssue() {
        return this.showPopUpOfNetworkIssue;
    }

    public final MutableLiveData<ActionEvent<Unit>> getShowPopUpOfNoInternetConnection() {
        return this.showPopUpOfNoInternetConnection;
    }

    public final void submitCheckInInfo(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInPayload");
        Intrinsics.checkNotNullParameter(checkInCode, "checkInCode");
        this.checkInRepository.addPendingCheckIn(checkIn);
        this.loadingSpinnerVisible.set(true);
        getCompositeDisposable().add(this.checkInRepository.uploadCheckIns().observeOn(AndroidSchedulers.mainThread()).doFinally(new CheckInSubmittingViewModel$submitCheckInInfo$1(this)).subscribe(new CheckInSubmittingViewModel$submitCheckInInfo$2(this, checkIn, checkInCode), new CheckInSubmittingViewModel$submitCheckInInfo$3(this, checkIn, checkInCode)));
    }

    /* access modifiers changed from: private */
    public final void doOnCheckInSuccess(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
        CheckIn copy$default = CheckIn.copy$default(checkIn, null, null, null, null, null, null, null, null, 255, null);
        copy$default.setLocationName(checkInCode.getLocation());
        this.checkInRepository.addACheckInHistoryIfNotExists(copy$default, checkInCode);
        if (!this.isInstantApp.get()) {
            ActionEventKt.postEvent(this.navigateToSuccess, TuplesKt.to(copy$default, checkInCode));
        } else if (this.checkInRepository.rememberHasCheckedIn()) {
            ActionEventKt.postEvent(this.navigateToSuccess, TuplesKt.to(copy$default, checkInCode));
        } else {
            ActionEventKt.postEvent(this.navigateToFeedback, copy$default);
        }
    }
}
