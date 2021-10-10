package com.digitalwallet.app.view.main.adapter;

import android.view.View;
import com.digitalwallet.app.view.main.ServiceType;
import com.digitalwallet.app.view.main.adapter.ServiceTypeAdapter;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceTypeAdapter.kt */
public final class ServiceTypeAdapter$ServiceTypeViewHolder$bind$1 implements View.OnClickListener {
    final /* synthetic */ ServiceType $type;
    final /* synthetic */ ServiceTypeAdapter.ServiceTypeViewHolder this$0;

    ServiceTypeAdapter$ServiceTypeViewHolder$bind$1(ServiceTypeAdapter.ServiceTypeViewHolder serviceTypeViewHolder, ServiceType serviceType) {
        this.this$0 = serviceTypeViewHolder;
        this.$type = serviceType;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getSelectedTypeItemViewModel().onNext(this.$type);
    }
}
