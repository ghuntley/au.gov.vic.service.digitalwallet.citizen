package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import androidx.databinding.ObservableBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0007R\u0016\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0002\u0010\r\u0012\u0004\b\u000f\u0010\fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/ShortcutRowBaseViewModel;", "", "initiallyEditing", "", "initiallyChecked", "clickedWhenNotEditing", "Lkotlin/Function0;", "", "onCheckChanged", "(ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_checkChanged", "get_checkChanged$annotations", "()V", "Lkotlin/Unit;", "_editChanged", "get_editChanged$annotations", "checked", "Landroidx/databinding/ObservableBoolean;", "getChecked", "()Landroidx/databinding/ObservableBoolean;", "editing", "getEditing", "showDivider", "getShowDivider", "doOnClicked", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewModels.kt */
public class ShortcutRowBaseViewModel {
    private final Unit _checkChanged;
    private final Unit _editChanged;
    private final ObservableBoolean checked;
    private final Function0<Unit> clickedWhenNotEditing;
    private final ObservableBoolean editing;
    private final Function0<Unit> onCheckChanged;
    private final ObservableBoolean showDivider = new ObservableBoolean(true);

    private static /* synthetic */ void get_checkChanged$annotations() {
    }

    private static /* synthetic */ void get_editChanged$annotations() {
    }

    public ShortcutRowBaseViewModel(boolean z, boolean z2, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "clickedWhenNotEditing");
        Intrinsics.checkNotNullParameter(function02, "onCheckChanged");
        this.clickedWhenNotEditing = function0;
        this.onCheckChanged = function02;
        boolean z3 = true;
        ObservableBoolean observableBoolean = new ObservableBoolean(z);
        this.editing = observableBoolean;
        ObservableBoolean observableBoolean2 = new ObservableBoolean((!z || !z2) ? false : z3);
        this.checked = observableBoolean2;
        observableBoolean.addOnPropertyChangedCallback(new ShortcutRowBaseViewModel$_editChanged$1(this));
        this._editChanged = Unit.INSTANCE;
        observableBoolean2.addOnPropertyChangedCallback(new ShortcutRowBaseViewModel$_checkChanged$1(this));
        this._checkChanged = Unit.INSTANCE;
    }

    public final ObservableBoolean getShowDivider() {
        return this.showDivider;
    }

    public final ObservableBoolean getEditing() {
        return this.editing;
    }

    public final ObservableBoolean getChecked() {
        return this.checked;
    }

    public final void doOnClicked() {
        if (this.editing.get()) {
            ObservableBoolean observableBoolean = this.checked;
            observableBoolean.set(!observableBoolean.get());
            return;
        }
        this.clickedWhenNotEditing.invoke();
    }
}
