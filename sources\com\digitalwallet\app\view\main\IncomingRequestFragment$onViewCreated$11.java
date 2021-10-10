package com.digitalwallet.app.view.main;

import android.os.Handler;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragment.kt */
final class IncomingRequestFragment$onViewCreated$11<T> implements Consumer<Throwable> {
    final /* synthetic */ IncomingRequestFragment this$0;

    IncomingRequestFragment$onViewCreated$11(IncomingRequestFragment incomingRequestFragment) {
        this.this$0 = incomingRequestFragment;
    }

    public final void accept(Throwable th) {
        IncomingRequestFragmentViewModel viewModel = this.this$0.getViewModel();
        Intrinsics.checkNotNullExpressionValue(th, "it");
        viewModel.onHoldingResponseError(th);
        new Handler().postDelayed(new Runnable(this) {
            /* class com.digitalwallet.app.view.main.IncomingRequestFragment$onViewCreated$11.AnonymousClass1 */
            final /* synthetic */ IncomingRequestFragment$onViewCreated$11 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.this$0.getParentFragmentManager().popBackStackImmediate();
            }
        }, 2000);
    }
}
