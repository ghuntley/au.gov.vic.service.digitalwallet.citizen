package com.digitalwallet.view.checkIn.checkedIn;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInHistoryDetailFragment.kt */
public final class CheckInHistoryDetailFragment$observerEvents$1 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ CheckInHistoryDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInHistoryDetailFragment$observerEvents$1(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
        super(1);
        this.this$0 = checkInHistoryDetailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke(unit);
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        this.this$0.getParentFragmentManager().popBackStack();
    }
}
