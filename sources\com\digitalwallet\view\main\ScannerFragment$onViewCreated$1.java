package com.digitalwallet.view.main;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/databinding/ViewDataBinding;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScannerFragment.kt */
public final class ScannerFragment$onViewCreated$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScannerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScannerFragment$onViewCreated$1(ScannerFragment scannerFragment) {
        super(0);
        this.this$0 = scannerFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Object unused = this.this$0.initializeCamera();
    }
}
