package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragmentViewModel.kt */
public final class IncomingRequestFragmentViewModel$fetchRequestedHolding$2<T> implements Consumer<SecureHolding> {
    final /* synthetic */ IncomingRequestFragmentViewModel this$0;

    IncomingRequestFragmentViewModel$fetchRequestedHolding$2(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel) {
        this.this$0 = incomingRequestFragmentViewModel;
    }

    public final void accept(SecureHolding secureHolding) {
        IncomingRequestFragmentViewModel incomingRequestFragmentViewModel = this.this$0;
        Intrinsics.checkNotNullExpressionValue(secureHolding, "it");
        incomingRequestFragmentViewModel.localHolding = secureHolding;
    }
}
