package com.digitalwallet.app.view.main;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/view/main/ServiceType;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceTypeFragment.kt */
public final class ServiceTypeFragment$setupRX$1<T> implements Consumer<ServiceType> {
    final /* synthetic */ ServiceTypeFragment this$0;

    ServiceTypeFragment$setupRX$1(ServiceTypeFragment serviceTypeFragment) {
        this.this$0 = serviceTypeFragment;
    }

    public final void accept(ServiceType serviceType) {
        this.this$0.getAnalytics().selectContent("Select service", serviceType.name());
        ServiceTypeFragment serviceTypeFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(serviceType, "it");
        serviceTypeFragment.startServiceDetailFragment(serviceType);
    }
}
