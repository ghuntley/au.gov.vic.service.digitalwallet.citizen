package com.digitalwallet.viewmodel.checkIn;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001e\u001a\u00020\u0016J\u0006\u0010\u001f\u001a\u00020\u0016J\u0006\u0010 \u001a\u00020\u0016R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR'\u0010\u0013\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0016`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R'\u0010\u001a\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0016`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000b¨\u0006!"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/CheckInOverviewViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "checkInItem", "Landroidx/lifecycle/LiveData;", "Lcom/digitalwallet/model/CheckIn;", "getCheckInItem", "()Landroidx/lifecycle/LiveData;", "checkInTime", "", "getCheckInTime", "checkedInText", "getCheckedInText", "isCheckInInfoVisible", "", "navigateToCheckInScanner", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getNavigateToCheckInScanner", "()Landroidx/lifecycle/MutableLiveData;", "navigateToHelpUrl", "getNavigateToHelpUrl", "noInternetConnectionBanner", "getNoInternetConnectionBanner", "onCheckIn", "onInfo", "refreshCheckInHistory", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInOverviewViewModel.kt */
public final class CheckInOverviewViewModel extends BaseViewModel {
    private final LiveData<CheckIn> checkInItem;
    private final CheckInRepository checkInRepository;
    private final LiveData<String> checkInTime;
    private final LiveData<String> checkedInText;
    private final LiveData<Boolean> isCheckInInfoVisible;
    private final MutableLiveData<ActionEvent<Unit>> navigateToCheckInScanner = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> navigateToHelpUrl = new MutableLiveData<>();
    private final LiveData<Boolean> noInternetConnectionBanner;

    @Inject
    public CheckInOverviewViewModel(Context context, CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.checkInRepository = checkInRepository2;
        LiveData<CheckIn> map = Transformations.map(checkInRepository2.m7getActiveCheckIn(), CheckInOverviewViewModel$checkInItem$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "Transformations.map(chec…eckIn) {\n        it\n    }");
        this.checkInItem = map;
        LiveData<String> map2 = Transformations.map(map, CheckInOverviewViewModel$checkInTime$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map2, "Transformations.map(chec…ing(date)\n        }\n    }");
        this.checkInTime = map2;
        LiveData<String> map3 = Transformations.map(map, new CheckInOverviewViewModel$checkedInText$1(context));
        Intrinsics.checkNotNullExpressionValue(map3, "Transformations.map(chec…estCount)\n        }\n    }");
        this.checkedInText = map3;
        LiveData<Boolean> map4 = Transformations.map(map, new CheckInOverviewViewModel$noInternetConnectionBanner$1(this));
        Intrinsics.checkNotNullExpressionValue(map4, "Transformations.map(chec…InPending) ?: false\n    }");
        this.noInternetConnectionBanner = map4;
        LiveData<Boolean> map5 = Transformations.map(map, CheckInOverviewViewModel$isCheckInInfoVisible$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map5, "Transformations.map(chec…\n        it != null\n    }");
        this.isCheckInInfoVisible = map5;
    }

    public final MutableLiveData<ActionEvent<Unit>> getNavigateToCheckInScanner() {
        return this.navigateToCheckInScanner;
    }

    public final MutableLiveData<ActionEvent<Unit>> getNavigateToHelpUrl() {
        return this.navigateToHelpUrl;
    }

    public final LiveData<CheckIn> getCheckInItem() {
        return this.checkInItem;
    }

    public final LiveData<String> getCheckInTime() {
        return this.checkInTime;
    }

    public final LiveData<String> getCheckedInText() {
        return this.checkedInText;
    }

    public final LiveData<Boolean> getNoInternetConnectionBanner() {
        return this.noInternetConnectionBanner;
    }

    public final LiveData<Boolean> isCheckInInfoVisible() {
        return this.isCheckInInfoVisible;
    }

    public final void onInfo() {
        ActionEventKt.post(this.navigateToHelpUrl);
    }

    public final void onCheckIn() {
        ActionEventKt.post(this.navigateToCheckInScanner);
    }

    public final void refreshCheckInHistory() {
        this.checkInRepository.refreshActiveCheckIn();
    }
}
