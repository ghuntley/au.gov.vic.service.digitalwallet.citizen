package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003J#\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0006\u0010\r\u001a\u00020\u0006J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/FavouriteCellViewModel;", "", "favourite", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "onClick", "Lkotlin/Function0;", "", "(Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;Lkotlin/jvm/functions/Function0;)V", "getFavourite", "()Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "component1", "component2", "copy", "doOnClicked", "equals", "", "other", "hashCode", "", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewModels.kt */
public final class FavouriteCellViewModel {
    private final CheckInUtils.CheckInCode favourite;
    private final Function0<Unit> onClick;

    private final Function0<Unit> component2() {
        return this.onClick;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteCellViewModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FavouriteCellViewModel copy$default(FavouriteCellViewModel favouriteCellViewModel, CheckInUtils.CheckInCode checkInCode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            checkInCode = favouriteCellViewModel.favourite;
        }
        if ((i & 2) != 0) {
            function0 = favouriteCellViewModel.onClick;
        }
        return favouriteCellViewModel.copy(checkInCode, function0);
    }

    public final CheckInUtils.CheckInCode component1() {
        return this.favourite;
    }

    public final FavouriteCellViewModel copy(CheckInUtils.CheckInCode checkInCode, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(checkInCode, "favourite");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return new FavouriteCellViewModel(checkInCode, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FavouriteCellViewModel)) {
            return false;
        }
        FavouriteCellViewModel favouriteCellViewModel = (FavouriteCellViewModel) obj;
        return Intrinsics.areEqual(this.favourite, favouriteCellViewModel.favourite) && Intrinsics.areEqual(this.onClick, favouriteCellViewModel.onClick);
    }

    public int hashCode() {
        CheckInUtils.CheckInCode checkInCode = this.favourite;
        int i = 0;
        int hashCode = (checkInCode != null ? checkInCode.hashCode() : 0) * 31;
        Function0<Unit> function0 = this.onClick;
        if (function0 != null) {
            i = function0.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "FavouriteCellViewModel(favourite=" + this.favourite + ", onClick=" + this.onClick + ")";
    }

    public FavouriteCellViewModel(CheckInUtils.CheckInCode checkInCode, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(checkInCode, "favourite");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.favourite = checkInCode;
        this.onClick = function0;
    }

    public final CheckInUtils.CheckInCode getFavourite() {
        return this.favourite;
    }

    public final void doOnClicked() {
        this.onClick.invoke();
    }
}
