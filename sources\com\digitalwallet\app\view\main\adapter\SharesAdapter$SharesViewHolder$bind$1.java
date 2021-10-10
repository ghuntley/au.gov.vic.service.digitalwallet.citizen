package com.digitalwallet.app.view.main.adapter;

import android.view.View;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.view.main.adapter.SharesAdapter;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: SharesAdapter.kt */
public final class SharesAdapter$SharesViewHolder$bind$1 implements View.OnClickListener {
    final /* synthetic */ ShareRecord $item;
    final /* synthetic */ SharesAdapter.SharesViewHolder this$0;

    SharesAdapter$SharesViewHolder$bind$1(SharesAdapter.SharesViewHolder sharesViewHolder, ShareRecord shareRecord) {
        this.this$0 = sharesViewHolder;
        this.$item = shareRecord;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getSelectedSharePublisher().onNext(this.$item);
    }
}
