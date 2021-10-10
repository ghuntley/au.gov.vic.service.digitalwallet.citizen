package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragment.kt */
final class IncomingRequestFragment$onViewCreated$4<T> implements Consumer<SecureHolding> {
    final /* synthetic */ IncomingRequestFragment this$0;

    IncomingRequestFragment$onViewCreated$4(IncomingRequestFragment incomingRequestFragment) {
        this.this$0 = incomingRequestFragment;
    }

    public final void accept(SecureHolding secureHolding) {
        IncomingRequestFragment incomingRequestFragment = this.this$0;
        incomingRequestFragment.holdingName = secureHolding.holdingTypeName(incomingRequestFragment.getContext());
        this.this$0.getViewModel().setSharingRequestInfo(this.this$0.holdingName, IncomingRequestFragment.access$getAuthorityHolding$p(this.this$0));
        IncomingRequestFragment incomingRequestFragment2 = this.this$0;
        Intrinsics.checkNotNullExpressionValue(secureHolding, "it");
        incomingRequestFragment2.bindHoldingView(secureHolding);
        this.this$0.getViewModel().getInTransition().set(false);
    }
}
