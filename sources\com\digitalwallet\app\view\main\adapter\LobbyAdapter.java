package com.digitalwallet.app.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.connection.NamedDevice;
import com.digitalwallet.app.databinding.ItemLobbyMemberBinding;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyMemberView;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyMemberViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B/\u0012 \u0010\u0003\u001a\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004j\u0002`\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J(\u0010\u0017\u001a\u00020\u00102 \u0010\u0003\u001a\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004j\u0002`\tR(\u0010\u0003\u001a\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004j\u0002`\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/LobbyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/LobbyAdapter$LobbyAdapterViewHolder;", "lobby", "Lkotlin/Pair;", "", "Lcom/digitalwallet/app/model/SharingCode;", "", "Lcom/digitalwallet/app/connection/NamedDevice;", "Lcom/digitalwallet/app/connection/Lobby;", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyMemberView;", "(Lkotlin/Pair;Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyMemberView;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "LobbyAdapterViewHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LobbyAdapter.kt */
public final class LobbyAdapter extends RecyclerView.Adapter<LobbyAdapterViewHolder> {
    private Pair<String, ? extends List<NamedDevice>> lobby;
    private final LobbyMemberView view;

    public LobbyAdapter(Pair<String, ? extends List<NamedDevice>> pair, LobbyMemberView lobbyMemberView) {
        Intrinsics.checkNotNullParameter(pair, "lobby");
        Intrinsics.checkNotNullParameter(lobbyMemberView, Promotion.ACTION_VIEW);
        this.lobby = pair;
        this.view = lobbyMemberView;
    }

    public final void update(Pair<String, ? extends List<NamedDevice>> pair) {
        Intrinsics.checkNotNullParameter(pair, "lobby");
        this.lobby = pair;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LobbyAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemLobbyMemberBinding inflate = ItemLobbyMemberBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ItemLobbyMemberBinding.i…(inflater, parent, false)");
        return new LobbyAdapterViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ((List) this.lobby.getSecond()).size();
    }

    public void onBindViewHolder(LobbyAdapterViewHolder lobbyAdapterViewHolder, int i) {
        Intrinsics.checkNotNullParameter(lobbyAdapterViewHolder, "holder");
        lobbyAdapterViewHolder.bind(new LobbyMemberViewModel(this.lobby.getFirst(), (NamedDevice) ((List) this.lobby.getSecond()).get(i), this.view));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/LobbyAdapter$LobbyAdapterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/ItemLobbyMemberBinding;", "(Lcom/digitalwallet/app/view/main/adapter/LobbyAdapter;Lcom/digitalwallet/app/databinding/ItemLobbyMemberBinding;)V", "bind", "", "vm", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyMemberViewModel;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyAdapter.kt */
    public final class LobbyAdapterViewHolder extends RecyclerView.ViewHolder {
        private final ItemLobbyMemberBinding binding;
        final /* synthetic */ LobbyAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LobbyAdapterViewHolder(LobbyAdapter lobbyAdapter, ItemLobbyMemberBinding itemLobbyMemberBinding) {
            super(itemLobbyMemberBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemLobbyMemberBinding, "binding");
            this.this$0 = lobbyAdapter;
            this.binding = itemLobbyMemberBinding;
        }

        public final void bind(LobbyMemberViewModel lobbyMemberViewModel) {
            Intrinsics.checkNotNullParameter(lobbyMemberViewModel, "vm");
            this.binding.setVm(lobbyMemberViewModel);
        }
    }
}
