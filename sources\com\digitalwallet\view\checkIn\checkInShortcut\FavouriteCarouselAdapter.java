package com.digitalwallet.view.checkIn.checkInShortcut;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.databinding.ItemCheckInFavouriteCellBinding;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteCellViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/FavouriteCarouselAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/view/checkIn/checkInShortcut/FavouriteCarouselAdapter$FavouriteCellViewHolder;", "favourites", "", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/FavouriteCellViewModel;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateFavouriteCarousel", "newCells", "", "FavouriteCellViewHolder", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewAdapters.kt */
public final class FavouriteCarouselAdapter extends RecyclerView.Adapter<FavouriteCellViewHolder> {
    private final List<FavouriteCellViewModel> favourites;

    public FavouriteCarouselAdapter(List<FavouriteCellViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "favourites");
        this.favourites = list;
    }

    public final void updateFavouriteCarousel(List<FavouriteCellViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "newCells");
        this.favourites.clear();
        this.favourites.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FavouriteCellViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemCheckInFavouriteCellBinding inflate = ItemCheckInFavouriteCellBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ItemCheckInFavouriteCell…tInflater, parent, false)");
        return new FavouriteCellViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.favourites.size();
    }

    public void onBindViewHolder(FavouriteCellViewHolder favouriteCellViewHolder, int i) {
        Intrinsics.checkNotNullParameter(favouriteCellViewHolder, "holder");
        favouriteCellViewHolder.bind(this.favourites.get(i));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/FavouriteCarouselAdapter$FavouriteCellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/databinding/ItemCheckInFavouriteCellBinding;", "(Lcom/digitalwallet/databinding/ItemCheckInFavouriteCellBinding;)V", "bind", "", "item", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/FavouriteCellViewModel;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ShortcutItemViewAdapters.kt */
    public static final class FavouriteCellViewHolder extends RecyclerView.ViewHolder {
        private final ItemCheckInFavouriteCellBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FavouriteCellViewHolder(ItemCheckInFavouriteCellBinding itemCheckInFavouriteCellBinding) {
            super(itemCheckInFavouriteCellBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemCheckInFavouriteCellBinding, "binding");
            this.binding = itemCheckInFavouriteCellBinding;
        }

        public final void bind(FavouriteCellViewModel favouriteCellViewModel) {
            Intrinsics.checkNotNullParameter(favouriteCellViewModel, "item");
            this.binding.setVm(favouriteCellViewModel);
        }
    }
}
