package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.SecureHolding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/digitalwallet/app/model/SecureHolding;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final /* synthetic */ class HoldingListFragment$observeSelectedHolding$1 extends FunctionReferenceImpl implements Function1<SecureHolding, Unit> {
    HoldingListFragment$observeSelectedHolding$1(HoldingListFragment holdingListFragment) {
        super(1, holdingListFragment, HoldingListFragment.class, "startCardDetailFragment", "startCardDetailFragment(Lcom/digitalwallet/app/model/SecureHolding;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SecureHolding secureHolding) {
        invoke(secureHolding);
        return Unit.INSTANCE;
    }

    public final void invoke(SecureHolding secureHolding) {
        Intrinsics.checkNotNullParameter(secureHolding, "p1");
        ((HoldingListFragment) this.receiver).startCardDetailFragment(secureHolding);
    }
}
