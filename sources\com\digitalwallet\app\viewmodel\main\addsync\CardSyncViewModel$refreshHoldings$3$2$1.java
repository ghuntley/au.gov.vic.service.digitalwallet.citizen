package com.digitalwallet.app.viewmodel.main.addsync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardSyncViewModel.kt */
final /* synthetic */ class CardSyncViewModel$refreshHoldings$3$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    CardSyncViewModel$refreshHoldings$3$2$1(CardSyncViewModel cardSyncViewModel) {
        super(0, cardSyncViewModel, CardSyncViewModel.class, "updateHasAnyCardSelected", "updateHasAnyCardSelected()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ((CardSyncViewModel) this.receiver).updateHasAnyCardSelected();
    }
}
