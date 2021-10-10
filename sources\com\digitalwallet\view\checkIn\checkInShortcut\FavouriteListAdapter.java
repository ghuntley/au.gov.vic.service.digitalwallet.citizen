package com.digitalwallet.view.checkIn.checkInShortcut;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.databinding.ItemCheckInFavouriteRowBinding;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteRowViewModel;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0014\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/FavouriteListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/view/checkIn/checkInShortcut/FavouriteListAdapter$FavouriteRowViewHolder;", "favourites", "", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/FavouriteRowViewModel;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "(Ljava/util/List;Landroidx/recyclerview/widget/ItemTouchHelper;)V", "getItemCount", "", "moveItem", Constants.MessagePayloadKeys.FROM, "to", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateFavouriteList", "newList", "", "FavouriteRowViewHolder", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewAdapters.kt */
public final class FavouriteListAdapter extends RecyclerView.Adapter<FavouriteRowViewHolder> {
    private final List<FavouriteRowViewModel> favourites;
    private final ItemTouchHelper itemTouchHelper;

    public FavouriteListAdapter(List<FavouriteRowViewModel> list, ItemTouchHelper itemTouchHelper2) {
        Intrinsics.checkNotNullParameter(list, "favourites");
        Intrinsics.checkNotNullParameter(itemTouchHelper2, "itemTouchHelper");
        this.favourites = list;
        this.itemTouchHelper = itemTouchHelper2;
    }

    public final void updateFavouriteList(List<FavouriteRowViewModel> list) {
        ObservableBoolean showDivider;
        Intrinsics.checkNotNullParameter(list, "newList");
        this.favourites.clear();
        List<FavouriteRowViewModel> list2 = this.favourites;
        FavouriteRowViewModel favouriteRowViewModel = (FavouriteRowViewModel) CollectionsKt.lastOrNull((List) list);
        if (!(favouriteRowViewModel == null || (showDivider = favouriteRowViewModel.getShowDivider()) == null)) {
            showDivider.set(false);
        }
        Unit unit = Unit.INSTANCE;
        list2.addAll(list);
        notifyDataSetChanged();
    }

    public final FavouriteRowViewModel moveItem(int i, int i2) {
        FavouriteRowViewModel remove = this.favourites.remove(i);
        this.favourites.add(i2, remove);
        notifyItemMoved(i, i2);
        return remove;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FavouriteRowViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemCheckInFavouriteRowBinding inflate = ItemCheckInFavouriteRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ItemCheckInFavouriteRowB…tInflater, parent, false)");
        return new FavouriteRowViewHolder(inflate, this.itemTouchHelper);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.favourites.size();
    }

    public void onBindViewHolder(FavouriteRowViewHolder favouriteRowViewHolder, int i) {
        Intrinsics.checkNotNullParameter(favouriteRowViewHolder, "holder");
        favouriteRowViewHolder.bind(this.favourites.get(i));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/FavouriteListAdapter$FavouriteRowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/databinding/ItemCheckInFavouriteRowBinding;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "(Lcom/digitalwallet/databinding/ItemCheckInFavouriteRowBinding;Landroidx/recyclerview/widget/ItemTouchHelper;)V", "bind", "", "item", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/FavouriteRowViewModel;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ShortcutItemViewAdapters.kt */
    public static final class FavouriteRowViewHolder extends RecyclerView.ViewHolder {
        private final ItemCheckInFavouriteRowBinding binding;
        private final ItemTouchHelper itemTouchHelper;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FavouriteRowViewHolder(ItemCheckInFavouriteRowBinding itemCheckInFavouriteRowBinding, ItemTouchHelper itemTouchHelper2) {
            super(itemCheckInFavouriteRowBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemCheckInFavouriteRowBinding, "binding");
            Intrinsics.checkNotNullParameter(itemTouchHelper2, "itemTouchHelper");
            this.binding = itemCheckInFavouriteRowBinding;
            this.itemTouchHelper = itemTouchHelper2;
        }

        public final void bind(FavouriteRowViewModel favouriteRowViewModel) {
            Intrinsics.checkNotNullParameter(favouriteRowViewModel, "item");
            this.binding.setVm(favouriteRowViewModel);
            this.binding.endIcon.setOnTouchListener(new FavouriteListAdapter$FavouriteRowViewHolder$bind$1(this, favouriteRowViewModel));
        }
    }
}
