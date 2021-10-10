package com.digitalwallet.app.view.main;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final /* synthetic */ class HoldingListFragment$startCitizenFragment$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    HoldingListFragment$startCitizenFragment$1(HoldingListFragment holdingListFragment) {
        super(0, holdingListFragment, HoldingListFragment.class, "refreshHoldings", "refreshHoldings()Z", 0);
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return ((HoldingListFragment) this.receiver).refreshHoldings();
    }
}
