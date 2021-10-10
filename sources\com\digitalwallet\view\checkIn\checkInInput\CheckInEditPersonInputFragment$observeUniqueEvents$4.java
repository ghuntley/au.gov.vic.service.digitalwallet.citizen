package com.digitalwallet.view.checkIn.checkInInput;

import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/model/DependantCheckIn;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInEditPersonInputFragment.kt */
public final class CheckInEditPersonInputFragment$observeUniqueEvents$4 extends Lambda implements Function1<DependantCheckIn, Unit> {
    final /* synthetic */ CheckInSummaryFragment $checkInSummaryFragment;
    final /* synthetic */ CheckInEditPersonInputFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInEditPersonInputFragment$observeUniqueEvents$4(CheckInEditPersonInputFragment checkInEditPersonInputFragment, CheckInSummaryFragment checkInSummaryFragment) {
        super(1);
        this.this$0 = checkInEditPersonInputFragment;
        this.$checkInSummaryFragment = checkInSummaryFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DependantCheckIn dependantCheckIn) {
        invoke(dependantCheckIn);
        return Unit.INSTANCE;
    }

    public final void invoke(DependantCheckIn dependantCheckIn) {
        CheckInSummaryViewModel viewModel;
        Intrinsics.checkNotNullParameter(dependantCheckIn, "it");
        CheckInSummaryFragment checkInSummaryFragment = this.$checkInSummaryFragment;
        if (!(checkInSummaryFragment == null || (viewModel = checkInSummaryFragment.getViewModel()) == null)) {
            viewModel.deleteADependant(dependantCheckIn);
        }
        this.this$0.goBack();
    }
}
