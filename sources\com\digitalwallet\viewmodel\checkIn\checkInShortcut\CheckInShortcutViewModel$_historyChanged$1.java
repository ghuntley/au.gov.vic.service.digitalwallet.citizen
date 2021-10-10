package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import androidx.databinding.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel$_historyChanged$1", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInShortcutViewModel.kt */
public final class CheckInShortcutViewModel$_historyChanged$1 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ CheckInShortcutViewModel this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CheckInShortcutViewModel$_historyChanged$1(CheckInShortcutViewModel checkInShortcutViewModel) {
        this.this$0 = checkInShortcutViewModel;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        CheckInShortcutViewModel checkInShortcutViewModel = this.this$0;
        List list = (List) checkInShortcutViewModel.history.get();
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        checkInShortcutViewModel.setHistoryToRowVMs(list);
    }
}
