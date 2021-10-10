package com.digitalwallet.app.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.ItemRecentShareBinding;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/SharesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/SharesAdapter$SharesViewHolder;", "shares", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "(Ljava/util/List;)V", "selectedSharePublisher", "Lio/reactivex/subjects/PublishSubject;", "getSelectedSharePublisher", "()Lio/reactivex/subjects/PublishSubject;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SharesViewHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SharesAdapter.kt */
public final class SharesAdapter extends RecyclerView.Adapter<SharesViewHolder> {
    private final PublishSubject<ShareRecord> selectedSharePublisher;
    private final List<ShareRecord> shares;

    public SharesAdapter(List<ShareRecord> list) {
        Intrinsics.checkNotNullParameter(list, "shares");
        this.shares = list;
        PublishSubject<ShareRecord> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.selectedSharePublisher = create;
    }

    public final PublishSubject<ShareRecord> getSelectedSharePublisher() {
        return this.selectedSharePublisher;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SharesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemRecentShareBinding itemRecentShareBinding = (ItemRecentShareBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_recent_share, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(itemRecentShareBinding, "binding");
        return new SharesViewHolder(this, itemRecentShareBinding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.shares.size();
    }

    public void onBindViewHolder(SharesViewHolder sharesViewHolder, int i) {
        Intrinsics.checkNotNullParameter(sharesViewHolder, "holder");
        sharesViewHolder.bind(this.shares.get(i));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/SharesAdapter$SharesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/ItemRecentShareBinding;", "(Lcom/digitalwallet/app/view/main/adapter/SharesAdapter;Lcom/digitalwallet/app/databinding/ItemRecentShareBinding;)V", "getBinding", "()Lcom/digitalwallet/app/databinding/ItemRecentShareBinding;", "bind", "", "item", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SharesAdapter.kt */
    public final class SharesViewHolder extends RecyclerView.ViewHolder {
        private final ItemRecentShareBinding binding;
        final /* synthetic */ SharesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SharesViewHolder(SharesAdapter sharesAdapter, ItemRecentShareBinding itemRecentShareBinding) {
            super(itemRecentShareBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemRecentShareBinding, "binding");
            this.this$0 = sharesAdapter;
            this.binding = itemRecentShareBinding;
        }

        public final ItemRecentShareBinding getBinding() {
            return this.binding;
        }

        public final void bind(ShareRecord shareRecord) {
            Intrinsics.checkNotNullParameter(shareRecord, "item");
            this.binding.setVm(shareRecord);
            this.binding.getRoot().setOnClickListener(new SharesAdapter$SharesViewHolder$bind$1(this, shareRecord));
            this.binding.executePendingBindings();
        }
    }
}
