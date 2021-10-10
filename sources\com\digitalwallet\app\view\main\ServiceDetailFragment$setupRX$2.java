package com.digitalwallet.app.view.main;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceDetailFragment.kt */
public final class ServiceDetailFragment$setupRX$2<T> implements Consumer<Boolean> {
    final /* synthetic */ ServiceDetailFragment this$0;

    ServiceDetailFragment$setupRX$2(ServiceDetailFragment serviceDetailFragment) {
        this.this$0 = serviceDetailFragment;
    }

    public final void accept(Boolean bool) {
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            this.this$0.getParentFragmentManager().popBackStack();
        }
    }
}
