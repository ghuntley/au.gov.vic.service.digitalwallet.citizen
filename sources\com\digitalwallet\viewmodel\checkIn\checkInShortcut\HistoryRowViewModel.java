package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import android.content.res.Resources;
import androidx.databinding.ObservableBoolean;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.model.CheckInGuest;
import com.digitalwallet.utilities.DateFormattingHelper;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÂ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÂ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÂ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÂ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÂ\u0003JQ\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0013HÖ\u0001J\u000e\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0000J\t\u0010'\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/HistoryRowViewModel;", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/ShortcutRowBaseViewModel;", "history", "Lcom/digitalwallet/model/CheckIn;", "resources", "Landroid/content/res/Resources;", "initiallyEditing", "", "initiallyChecked", "clickedWhenNotEditing", "Lkotlin/Function0;", "", "onCheckChanged", "(Lcom/digitalwallet/model/CheckIn;Landroid/content/res/Resources;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "briefInfoDisplay", "", "getBriefInfoDisplay", "()Ljava/lang/String;", "guestCount", "", "getGuestCount", "()I", "getHistory", "()Lcom/digitalwallet/model/CheckIn;", "isActiveCheckIn", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "isSameDayAs", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewModels.kt */
public final class HistoryRowViewModel extends ShortcutRowBaseViewModel {
    private final String briefInfoDisplay;
    private final Function0<Unit> clickedWhenNotEditing;
    private final int guestCount;
    private final CheckIn history;
    private final boolean initiallyChecked;
    private final boolean initiallyEditing;
    private final ObservableBoolean isActiveCheckIn = new ObservableBoolean(false);
    private final Function0<Unit> onCheckChanged;
    private final Resources resources;

    private final Resources component2() {
        return this.resources;
    }

    private final boolean component3() {
        return this.initiallyEditing;
    }

    private final boolean component4() {
        return this.initiallyChecked;
    }

    private final Function0<Unit> component5() {
        return this.clickedWhenNotEditing;
    }

    private final Function0<Unit> component6() {
        return this.onCheckChanged;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.digitalwallet.viewmodel.checkIn.checkInShortcut.HistoryRowViewModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HistoryRowViewModel copy$default(HistoryRowViewModel historyRowViewModel, CheckIn checkIn, Resources resources2, boolean z, boolean z2, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            checkIn = historyRowViewModel.history;
        }
        if ((i & 2) != 0) {
            resources2 = historyRowViewModel.resources;
        }
        if ((i & 4) != 0) {
            z = historyRowViewModel.initiallyEditing;
        }
        if ((i & 8) != 0) {
            z2 = historyRowViewModel.initiallyChecked;
        }
        if ((i & 16) != 0) {
            function0 = historyRowViewModel.clickedWhenNotEditing;
        }
        if ((i & 32) != 0) {
            function02 = historyRowViewModel.onCheckChanged;
        }
        return historyRowViewModel.copy(checkIn, resources2, z, z2, function0, function02);
    }

    public final CheckIn component1() {
        return this.history;
    }

    public final HistoryRowViewModel copy(CheckIn checkIn, Resources resources2, boolean z, boolean z2, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(checkIn, "history");
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(function0, "clickedWhenNotEditing");
        Intrinsics.checkNotNullParameter(function02, "onCheckChanged");
        return new HistoryRowViewModel(checkIn, resources2, z, z2, function0, function02);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoryRowViewModel)) {
            return false;
        }
        HistoryRowViewModel historyRowViewModel = (HistoryRowViewModel) obj;
        return Intrinsics.areEqual(this.history, historyRowViewModel.history) && Intrinsics.areEqual(this.resources, historyRowViewModel.resources) && this.initiallyEditing == historyRowViewModel.initiallyEditing && this.initiallyChecked == historyRowViewModel.initiallyChecked && Intrinsics.areEqual(this.clickedWhenNotEditing, historyRowViewModel.clickedWhenNotEditing) && Intrinsics.areEqual(this.onCheckChanged, historyRowViewModel.onCheckChanged);
    }

    public int hashCode() {
        CheckIn checkIn = this.history;
        int i = 0;
        int hashCode = (checkIn != null ? checkIn.hashCode() : 0) * 31;
        Resources resources2 = this.resources;
        int hashCode2 = (hashCode + (resources2 != null ? resources2.hashCode() : 0)) * 31;
        boolean z = this.initiallyEditing;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode2 + i3) * 31;
        boolean z2 = this.initiallyChecked;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i7 = (i6 + i2) * 31;
        Function0<Unit> function0 = this.clickedWhenNotEditing;
        int hashCode3 = (i7 + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0<Unit> function02 = this.onCheckChanged;
        if (function02 != null) {
            i = function02.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "HistoryRowViewModel(history=" + this.history + ", resources=" + this.resources + ", initiallyEditing=" + this.initiallyEditing + ", initiallyChecked=" + this.initiallyChecked + ", clickedWhenNotEditing=" + this.clickedWhenNotEditing + ", onCheckChanged=" + this.onCheckChanged + ")";
    }

    public final CheckIn getHistory() {
        return this.history;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HistoryRowViewModel(CheckIn checkIn, Resources resources2, boolean z, boolean z2, Function0<Unit> function0, Function0<Unit> function02) {
        super(z, z2, function0, function02);
        Intrinsics.checkNotNullParameter(checkIn, "history");
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(function0, "clickedWhenNotEditing");
        Intrinsics.checkNotNullParameter(function02, "onCheckChanged");
        this.history = checkIn;
        this.resources = resources2;
        this.initiallyEditing = z;
        this.initiallyChecked = z2;
        this.clickedWhenNotEditing = function0;
        this.onCheckChanged = function02;
        int i = 0;
        List<CheckInGuest> guests = checkIn.getGuests();
        this.guestCount = guests != null ? guests.size() : i;
        this.briefInfoDisplay = (String) new HistoryRowViewModel$briefInfoDisplay$1(this).invoke();
    }

    public final ObservableBoolean isActiveCheckIn() {
        return this.isActiveCheckIn;
    }

    public final int getGuestCount() {
        return this.guestCount;
    }

    public final String getBriefInfoDisplay() {
        return this.briefInfoDisplay;
    }

    public final boolean isSameDayAs(HistoryRowViewModel historyRowViewModel) {
        Date date;
        Intrinsics.checkNotNullParameter(historyRowViewModel, "other");
        Date date2 = this.history.getDate();
        if (date2 == null || (date = historyRowViewModel.history.getDate()) == null) {
            return false;
        }
        return DateFormattingHelper.INSTANCE.isSameDay(date2, date);
    }
}
