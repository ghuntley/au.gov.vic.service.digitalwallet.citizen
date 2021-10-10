package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.NotificationType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "com/digitalwallet/app/view/main/HoldingDetailFragment$bindNotificationBanner$1$1$1", "com/digitalwallet/app/view/main/HoldingDetailFragment$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
public final class HoldingDetailFragment$bindNotificationBanner$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isHoldingExpired$inlined;
    final /* synthetic */ NotificationType $notificationType$inlined;
    final /* synthetic */ HoldingDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HoldingDetailFragment$bindNotificationBanner$$inlined$apply$lambda$1(HoldingDetailFragment holdingDetailFragment, NotificationType notificationType, boolean z) {
        super(0);
        this.this$0 = holdingDetailFragment;
        this.$notificationType$inlined = notificationType;
        this.$isHoldingExpired$inlined = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        HoldingDetailFragment holdingDetailFragment = this.this$0;
        holdingDetailFragment.visitUrl(holdingDetailFragment.getSecureHolding());
    }
}
