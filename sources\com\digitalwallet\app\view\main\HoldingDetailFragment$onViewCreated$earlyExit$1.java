package com.digitalwallet.app.view.main;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
final class HoldingDetailFragment$onViewCreated$earlyExit$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HoldingDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HoldingDetailFragment$onViewCreated$earlyExit$1(HoldingDetailFragment holdingDetailFragment) {
        super(0);
        this.this$0 = holdingDetailFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Timber.w("unable to parse holding from " + this.this$0.getArguments(), new Object[0]);
        this.this$0.getParentFragmentManager().popBackStackImmediate();
    }
}
