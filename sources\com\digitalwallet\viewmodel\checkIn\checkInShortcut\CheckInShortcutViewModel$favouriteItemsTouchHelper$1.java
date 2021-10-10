package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/ItemTouchHelper;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInShortcutViewModel.kt */
public final class CheckInShortcutViewModel$favouriteItemsTouchHelper$1 extends Lambda implements Function0<ItemTouchHelper> {
    final /* synthetic */ CheckInShortcutViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInShortcutViewModel$favouriteItemsTouchHelper$1(CheckInShortcutViewModel checkInShortcutViewModel) {
        super(0);
        this.this$0 = checkInShortcutViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final ItemTouchHelper invoke() {
        return new ItemTouchHelper(new CheckInShortcutViewModel$favouriteItemsTouchHelper$1$simpleItemTouchCallback$1(this, 3, 0));
    }
}
