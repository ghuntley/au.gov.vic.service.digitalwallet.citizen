package com.digitalwallet.view.checkIn.checkInInput;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.view.util.ViewUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/model/DependantCheckIn;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInSummaryFragment.kt */
public final class CheckInSummaryFragment$observeEvents$3 extends Lambda implements Function1<DependantCheckIn, Unit> {
    final /* synthetic */ CheckInSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInSummaryFragment$observeEvents$3(CheckInSummaryFragment checkInSummaryFragment) {
        super(1);
        this.this$0 = checkInSummaryFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DependantCheckIn dependantCheckIn) {
        invoke(dependantCheckIn);
        return Unit.INSTANCE;
    }

    public final void invoke(DependantCheckIn dependantCheckIn) {
        Intrinsics.checkNotNullParameter(dependantCheckIn, "it");
        CheckInEditPersonInputFragment createFragment = CheckInEditPersonInputFragment.Companion.createFragment(dependantCheckIn);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this.this$0);
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(CheckInEditPersonInputFragment.class).getSimpleName();
        beginTransaction.add(containerId, createFragment, simpleName).addToBackStack(simpleName).commit();
    }
}
