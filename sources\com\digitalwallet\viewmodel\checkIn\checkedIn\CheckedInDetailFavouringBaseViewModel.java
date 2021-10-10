package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import androidx.databinding.ObservableBoolean;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH&J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckedInDetailFavouringBaseViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckedInBaseViewModel;", "context", "Landroid/content/Context;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Landroid/content/Context;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "canFavour", "Landroidx/databinding/ObservableBoolean;", "getCanFavour", "()Landroidx/databinding/ObservableBoolean;", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "getCheckInCode", "()Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "setCheckInCode", "(Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;)V", "noInternetConnectionBanner", "getNoInternetConnectionBanner", "shouldFavour", "getShouldFavour", "wasFavoured", "", "getWasFavoured", "()Z", "setWasFavoured", "(Z)V", "addOrRemoveAFavourite", "", "onDone", "setup", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckedInBaseViewModels.kt */
public abstract class CheckedInDetailFavouringBaseViewModel extends CheckedInBaseViewModel {
    private final ObservableBoolean canFavour = new ObservableBoolean();
    private CheckInUtils.CheckInCode checkInCode;
    private final CheckInRepository checkInRepository;
    private final ObservableBoolean noInternetConnectionBanner = new ObservableBoolean();
    private final ObservableBoolean shouldFavour = new ObservableBoolean();
    private boolean wasFavoured;

    public abstract void onDone();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckedInDetailFavouringBaseViewModel(Context context, CheckInRepository checkInRepository2) {
        super(context, checkInRepository2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.checkInRepository = checkInRepository2;
    }

    /* access modifiers changed from: protected */
    public final CheckInUtils.CheckInCode getCheckInCode() {
        return this.checkInCode;
    }

    /* access modifiers changed from: protected */
    public final void setCheckInCode(CheckInUtils.CheckInCode checkInCode2) {
        this.checkInCode = checkInCode2;
    }

    public final ObservableBoolean getNoInternetConnectionBanner() {
        return this.noInternetConnectionBanner;
    }

    public final ObservableBoolean getCanFavour() {
        return this.canFavour;
    }

    /* access modifiers changed from: protected */
    public final boolean getWasFavoured() {
        return this.wasFavoured;
    }

    /* access modifiers changed from: protected */
    public final void setWasFavoured(boolean z) {
        this.wasFavoured = z;
    }

    public final ObservableBoolean getShouldFavour() {
        return this.shouldFavour;
    }

    public final void setup(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode2) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
        super.setup(checkIn);
        this.checkInCode = checkInCode2;
        this.noInternetConnectionBanner.set(this.checkInRepository.isCheckInPending(checkIn));
        boolean z = false;
        this.canFavour.set(checkInCode2 != null && checkInCode2.getCanBeFavoured());
        if (checkInCode2 != null && this.checkInRepository.getCheckInShortcuts().getFavourites().contains(checkInCode2)) {
            z = true;
        }
        this.wasFavoured = z;
        this.shouldFavour.set(z);
    }

    public final void addOrRemoveAFavourite() {
        CheckInUtils.CheckInCode checkInCode2 = this.checkInCode;
        if (checkInCode2 == null) {
            return;
        }
        if (this.shouldFavour.get()) {
            CheckInRepository.addACheckInFavouriteIfNotExists$default(this.checkInRepository, checkInCode2, null, 2, null);
        } else {
            this.checkInRepository.removeSomeCheckInFavourites(CollectionsKt.listOf(checkInCode2));
        }
    }
}
