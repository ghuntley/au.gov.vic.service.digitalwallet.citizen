package com.digitalwallet.view.checkIn.checkInInput;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.view.util.ViewUtilsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "Lcom/digitalwallet/model/DependantCheckIn;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInAddDependantInputFragment.kt */
public final class CheckInAddDependantInputFragment$observeUniqueEvents$2 extends Lambda implements Function1<Pair<? extends PrimaryPersonCheckIn, ? extends DependantCheckIn>, Unit> {
    final /* synthetic */ CheckInAddDependantInputFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInAddDependantInputFragment$observeUniqueEvents$2(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
        super(1);
        this.this$0 = checkInAddDependantInputFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends PrimaryPersonCheckIn, ? extends DependantCheckIn> pair) {
        invoke((Pair<PrimaryPersonCheckIn, DependantCheckIn>) pair);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<PrimaryPersonCheckIn, DependantCheckIn> pair) {
        T t;
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        PrimaryPersonCheckIn component1 = pair.component1();
        DependantCheckIn component2 = pair.component2();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "parentFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof CheckInSummaryFragment) {
                break;
            }
        }
        if (!(t instanceof CheckInSummaryFragment)) {
            t = null;
        }
        T t2 = t;
        if (t2 != null) {
            t2.getViewModel().appendADependant(component2, true);
            this.this$0.goBack();
            return;
        }
        CheckInSummaryFragment createFragment = CheckInSummaryFragment.Companion.createFragment(component1, component2, true);
        FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this.this$0);
        FragmentTransaction beginTransaction = parentFragmentManager2.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, createFragment, Reflection.getOrCreateKotlinClass(CheckInSummaryFragment.class).getSimpleName()).addToBackStack(null).commit();
    }
}
