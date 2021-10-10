package com.digitalwallet.app.view.main.adapter;

import android.view.View;
import com.digitalwallet.app.view.main.ServiceDetailType;
import com.digitalwallet.app.view.main.adapter.ServiceDetailAdapter;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceDetailAdapter.kt */
public final class ServiceDetailAdapter$ServiceDetailViewHolder$bind$1 implements View.OnClickListener {
    final /* synthetic */ ServiceDetailType $type;
    final /* synthetic */ ServiceDetailAdapter.ServiceDetailViewHolder this$0;

    ServiceDetailAdapter$ServiceDetailViewHolder$bind$1(ServiceDetailAdapter.ServiceDetailViewHolder serviceDetailViewHolder, ServiceDetailType serviceDetailType) {
        this.this$0 = serviceDetailViewHolder;
        this.$type = serviceDetailType;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getSelectedDetailItemViewModel().onNext(this.$type);
    }
}
