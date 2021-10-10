package com.digitalwallet.view.checkIn.checkInInput;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.view.util.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInPrimaryInputFragment.kt */
public final class CheckInPrimaryInputFragment$observeUniqueEvents$2 extends Lambda implements Function1<PrimaryPersonCheckIn, Unit> {
    final /* synthetic */ CheckInPrimaryInputFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInPrimaryInputFragment$observeUniqueEvents$2(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
        super(1);
        this.this$0 = checkInPrimaryInputFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PrimaryPersonCheckIn primaryPersonCheckIn) {
        invoke(primaryPersonCheckIn);
        return Unit.INSTANCE;
    }

    public final void invoke(PrimaryPersonCheckIn primaryPersonCheckIn) {
        Intrinsics.checkNotNullParameter(primaryPersonCheckIn, "it");
        CheckInSummaryFragment createFragment = CheckInSummaryFragment.Companion.createFragment(primaryPersonCheckIn, null, true);
        this.this$0.setNavigatingAway(true);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this.this$0);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, createFragment, Reflection.getOrCreateKotlinClass(CheckInSummaryFragment.class).getSimpleName()).addToBackStack(null).commit();
    }
}
