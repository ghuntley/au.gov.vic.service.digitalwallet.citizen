package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/HoldingResponseStatus;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragment.kt */
final class IncomingRequestFragment$onViewCreated$7<T> implements Consumer<HoldingResponseStatus> {
    final /* synthetic */ IncomingRequestFragment this$0;

    IncomingRequestFragment$onViewCreated$7(IncomingRequestFragment incomingRequestFragment) {
        this.this$0 = incomingRequestFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.digitalwallet.app.view.main.IncomingRequestFragment$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void accept(HoldingResponseStatus holdingResponseStatus) {
        CompositeDisposable compositeDisposable = this.this$0.disposables;
        IncomingRequestFragmentViewModel viewModel = this.this$0.getViewModel();
        Intrinsics.checkNotNullExpressionValue(holdingResponseStatus, "it");
        Completable subscribeOn = viewModel.postTransaction(holdingResponseStatus, this.this$0.holdingName, IncomingRequestFragment.access$getAuthorityHolding$p(this.this$0)).subscribeOn(Schedulers.io());
        AnonymousClass1 r1 = AnonymousClass1.INSTANCE;
        if (r1 != null) {
            r1 = new IncomingRequestFragment$sam$io_reactivex_functions_Consumer$0(r1);
        }
        compositeDisposable.add(subscribeOn.doOnError((Consumer) r1).subscribe());
    }
}
