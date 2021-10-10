package com.digitalwallet.app.view.main;

import android.os.Handler;
import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/digitalwallet/app/model/HoldingResponseStatus;", "Lcom/digitalwallet/app/model/ShareHolding;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragment.kt */
final class IncomingRequestFragment$onViewCreated$10<T> implements Consumer<Pair<? extends HoldingResponseStatus, ? extends ShareHolding>> {
    final /* synthetic */ IncomingRequestFragment this$0;

    IncomingRequestFragment$onViewCreated$10(IncomingRequestFragment incomingRequestFragment) {
        this.this$0 = incomingRequestFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Pair<? extends HoldingResponseStatus, ? extends ShareHolding> pair) {
        accept((Pair<? extends HoldingResponseStatus, ShareHolding>) pair);
    }

    public final void accept(Pair<? extends HoldingResponseStatus, ShareHolding> pair) {
        IncomingRequestFragmentViewModel viewModel = this.this$0.getViewModel();
        Object first = pair.getFirst();
        Intrinsics.checkNotNullExpressionValue(first, "it.first");
        viewModel.onHoldingResponseSuccess((HoldingResponseStatus) first);
        new Handler().postDelayed(new Runnable(this) {
            /* class com.digitalwallet.app.view.main.IncomingRequestFragment$onViewCreated$10.AnonymousClass1 */
            final /* synthetic */ IncomingRequestFragment$onViewCreated$10 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.this$0.getParentFragmentManager().popBackStackImmediate();
            }
        }, 2000);
    }
}
