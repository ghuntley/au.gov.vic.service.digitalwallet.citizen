package com.digitalwallet.view.checkIn.checkInInput;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/digitalwallet/model/CheckIn;", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInSummaryFragment.kt */
public final class CheckInSummaryFragment$observeEvents$4 extends Lambda implements Function1<Pair<? extends CheckIn, ? extends CheckInUtils.CheckInCode>, Unit> {
    final /* synthetic */ CheckInSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInSummaryFragment$observeEvents$4(CheckInSummaryFragment checkInSummaryFragment) {
        super(1);
        this.this$0 = checkInSummaryFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends CheckIn, ? extends CheckInUtils.CheckInCode> pair) {
        invoke((Pair<CheckIn, CheckInUtils.CheckInCode>) pair);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<CheckIn, CheckInUtils.CheckInCode> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        CheckInSubmittingFragment createFragment = CheckInSubmittingFragment.Companion.createFragment(pair.component1(), pair.component2());
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
        String simpleName = Reflection.getOrCreateKotlinClass(CheckInSubmittingFragment.class).getSimpleName();
        beginTransaction.add(containerId, createFragment, simpleName).addToBackStack(simpleName).commit();
    }
}
