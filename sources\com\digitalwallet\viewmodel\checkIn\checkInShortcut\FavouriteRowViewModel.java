package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÂ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bHÂ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bHÂ\u0003JG\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/FavouriteRowViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/ShortcutRowBaseViewModel;", "favourite", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "initiallyEditing", "", "initiallyChecked", "clickedWhenNotEditing", "Lkotlin/Function0;", "", "onCheckChanged", "(Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getFavourite", "()Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewModels.kt */
public final class FavouriteRowViewModel extends ShortcutRowBaseViewModel {
    private final Function0<Unit> clickedWhenNotEditing;
    private final CheckInUtils.CheckInCode favourite;
    private final boolean initiallyChecked;
    private final boolean initiallyEditing;
    private final Function0<Unit> onCheckChanged;

    private final boolean component2() {
        return this.initiallyEditing;
    }

    private final boolean component3() {
        return this.initiallyChecked;
    }

    private final Function0<Unit> component4() {
        return this.clickedWhenNotEditing;
    }

    private final Function0<Unit> component5() {
        return this.onCheckChanged;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteRowViewModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FavouriteRowViewModel copy$default(FavouriteRowViewModel favouriteRowViewModel, CheckInUtils.CheckInCode checkInCode, boolean z, boolean z2, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            checkInCode = favouriteRowViewModel.favourite;
        }
        if ((i & 2) != 0) {
            z = favouriteRowViewModel.initiallyEditing;
        }
        if ((i & 4) != 0) {
            z2 = favouriteRowViewModel.initiallyChecked;
        }
        if ((i & 8) != 0) {
            function0 = favouriteRowViewModel.clickedWhenNotEditing;
        }
        if ((i & 16) != 0) {
            function02 = favouriteRowViewModel.onCheckChanged;
        }
        return favouriteRowViewModel.copy(checkInCode, z, z2, function0, function02);
    }

    public final CheckInUtils.CheckInCode component1() {
        return this.favourite;
    }

    public final FavouriteRowViewModel copy(CheckInUtils.CheckInCode checkInCode, boolean z, boolean z2, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(checkInCode, "favourite");
        Intrinsics.checkNotNullParameter(function0, "clickedWhenNotEditing");
        Intrinsics.checkNotNullParameter(function02, "onCheckChanged");
        return new FavouriteRowViewModel(checkInCode, z, z2, function0, function02);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FavouriteRowViewModel)) {
            return false;
        }
        FavouriteRowViewModel favouriteRowViewModel = (FavouriteRowViewModel) obj;
        return Intrinsics.areEqual(this.favourite, favouriteRowViewModel.favourite) && this.initiallyEditing == favouriteRowViewModel.initiallyEditing && this.initiallyChecked == favouriteRowViewModel.initiallyChecked && Intrinsics.areEqual(this.clickedWhenNotEditing, favouriteRowViewModel.clickedWhenNotEditing) && Intrinsics.areEqual(this.onCheckChanged, favouriteRowViewModel.onCheckChanged);
    }

    public int hashCode() {
        CheckInUtils.CheckInCode checkInCode = this.favourite;
        int i = 0;
        int hashCode = (checkInCode != null ? checkInCode.hashCode() : 0) * 31;
        boolean z = this.initiallyEditing;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode + i3) * 31;
        boolean z2 = this.initiallyChecked;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i7 = (i6 + i2) * 31;
        Function0<Unit> function0 = this.clickedWhenNotEditing;
        int hashCode2 = (i7 + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0<Unit> function02 = this.onCheckChanged;
        if (function02 != null) {
            i = function02.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "FavouriteRowViewModel(favourite=" + this.favourite + ", initiallyEditing=" + this.initiallyEditing + ", initiallyChecked=" + this.initiallyChecked + ", clickedWhenNotEditing=" + this.clickedWhenNotEditing + ", onCheckChanged=" + this.onCheckChanged + ")";
    }

    public final CheckInUtils.CheckInCode getFavourite() {
        return this.favourite;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavouriteRowViewModel(CheckInUtils.CheckInCode checkInCode, boolean z, boolean z2, Function0<Unit> function0, Function0<Unit> function02) {
        super(z, z2, function0, function02);
        Intrinsics.checkNotNullParameter(checkInCode, "favourite");
        Intrinsics.checkNotNullParameter(function0, "clickedWhenNotEditing");
        Intrinsics.checkNotNullParameter(function02, "onCheckChanged");
        this.favourite = checkInCode;
        this.initiallyEditing = z;
        this.initiallyChecked = z2;
        this.clickedWhenNotEditing = function0;
        this.onCheckChanged = function02;
    }
}
