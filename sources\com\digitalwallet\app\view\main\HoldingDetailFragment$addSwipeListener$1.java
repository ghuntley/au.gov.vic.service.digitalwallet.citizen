package com.digitalwallet.app.view.main;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "flip", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
public final class HoldingDetailFragment$addSwipeListener$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ HoldingDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HoldingDetailFragment$addSwipeListener$1(HoldingDetailFragment holdingDetailFragment) {
        super(1);
        this.this$0 = holdingDetailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.this$0.flipCard(z);
    }
}
