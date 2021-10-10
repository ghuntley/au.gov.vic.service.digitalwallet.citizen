package com.digitalwallet.app.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.databinding.ItemAttributeDetailBinding;
import com.digitalwallet.app.model.AttributeDetailItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/AttributeDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/AttributeDetailsAdapter$ShareDetailViewHolder;", "shareDetails", "", "Lcom/digitalwallet/app/model/AttributeDetailItem;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ShareDetailViewHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AttributeDetailsAdapter.kt */
public final class AttributeDetailsAdapter extends RecyclerView.Adapter<ShareDetailViewHolder> {
    private final List<AttributeDetailItem> shareDetails;

    public AttributeDetailsAdapter(List<AttributeDetailItem> list) {
        Intrinsics.checkNotNullParameter(list, "shareDetails");
        this.shareDetails = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ShareDetailViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemAttributeDetailBinding inflate = ItemAttributeDetailBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ItemAttributeDetailBindi…tInflater, parent, false)");
        return new ShareDetailViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.shareDetails.size();
    }

    public void onBindViewHolder(ShareDetailViewHolder shareDetailViewHolder, int i) {
        Intrinsics.checkNotNullParameter(shareDetailViewHolder, "holder");
        shareDetailViewHolder.bind(this.shareDetails.get(i));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/AttributeDetailsAdapter$ShareDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/ItemAttributeDetailBinding;", "(Lcom/digitalwallet/app/view/main/adapter/AttributeDetailsAdapter;Lcom/digitalwallet/app/databinding/ItemAttributeDetailBinding;)V", "getBinding", "()Lcom/digitalwallet/app/databinding/ItemAttributeDetailBinding;", "bind", "", "item", "Lcom/digitalwallet/app/model/AttributeDetailItem;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AttributeDetailsAdapter.kt */
    public final class ShareDetailViewHolder extends RecyclerView.ViewHolder {
        private final ItemAttributeDetailBinding binding;
        final /* synthetic */ AttributeDetailsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShareDetailViewHolder(AttributeDetailsAdapter attributeDetailsAdapter, ItemAttributeDetailBinding itemAttributeDetailBinding) {
            super(itemAttributeDetailBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemAttributeDetailBinding, "binding");
            this.this$0 = attributeDetailsAdapter;
            this.binding = itemAttributeDetailBinding;
        }

        public final ItemAttributeDetailBinding getBinding() {
            return this.binding;
        }

        public final void bind(AttributeDetailItem attributeDetailItem) {
            Intrinsics.checkNotNullParameter(attributeDetailItem, "item");
            this.binding.setVm(attributeDetailItem);
        }
    }
}
