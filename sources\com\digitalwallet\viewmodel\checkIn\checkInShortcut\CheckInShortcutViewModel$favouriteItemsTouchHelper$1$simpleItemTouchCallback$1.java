package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.view.checkIn.checkInShortcut.FavouriteListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel$favouriteItemsTouchHelper$1$simpleItemTouchCallback$1", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "onMove", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "target", "onSwiped", "", "direction", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInShortcutViewModel.kt */
public final class CheckInShortcutViewModel$favouriteItemsTouchHelper$1$simpleItemTouchCallback$1 extends ItemTouchHelper.SimpleCallback {
    final /* synthetic */ CheckInShortcutViewModel$favouriteItemsTouchHelper$1 this$0;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInShortcutViewModel$favouriteItemsTouchHelper$1$simpleItemTouchCallback$1(CheckInShortcutViewModel$favouriteItemsTouchHelper$1 checkInShortcutViewModel$favouriteItemsTouchHelper$1, int i, int i2) {
        super(i, i2);
        this.this$0 = checkInShortcutViewModel$favouriteItemsTouchHelper$1;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        FavouriteRowViewModel moveItem;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, "target");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (!(adapter instanceof FavouriteListAdapter)) {
            adapter = null;
        }
        FavouriteListAdapter favouriteListAdapter = (FavouriteListAdapter) adapter;
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        if (favouriteListAdapter == null || (moveItem = favouriteListAdapter.moveItem(adapterPosition, adapterPosition2)) == null) {
            return true;
        }
        this.this$0.this$0.reorderAFavourite(moveItem.getFavourite(), adapterPosition2);
        return true;
    }
}
