package com.digitalwallet.app.view.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: AlertFragment.kt */
final /* synthetic */ class AlertFragment$onViewCreated$1 extends FunctionReferenceImpl implements Function0<Unit> {
    AlertFragment$onViewCreated$1(AlertFragment alertFragment) {
        super(0, alertFragment, AlertFragment.class, "done", "done()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ((AlertFragment) this.receiver).done();
    }
}
