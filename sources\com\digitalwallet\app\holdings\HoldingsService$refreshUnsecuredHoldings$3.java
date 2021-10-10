package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.utilities.RetrofitHelper;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$refreshUnsecuredHoldings$3<T> implements Consumer<List<? extends UnsecuredHolding>> {
    final /* synthetic */ boolean $canWrite;
    final /* synthetic */ HoldingsService this$0;

    HoldingsService$refreshUnsecuredHoldings$3(HoldingsService holdingsService, boolean z) {
        this.this$0 = holdingsService;
        this.$canWrite = z;
    }

    public final void accept(List<? extends UnsecuredHolding> list) {
        if (this.$canWrite) {
            HoldingsService holdingsService = this.this$0;
            Intrinsics.checkNotNullExpressionValue(list, "it");
            holdingsService.storeUnsecuredHoldings(list).subscribeOn(Schedulers.io()).doOnError(new HoldingsService$sam$io_reactivex_functions_Consumer$0(new Function1<Throwable, Unit>(RetrofitHelper.Companion) {
                /* class com.digitalwallet.app.holdings.HoldingsService$refreshUnsecuredHoldings$3.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke(th);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "p1");
                    ((RetrofitHelper.Companion) this.receiver).filterHttpException(th);
                }
            })).onErrorComplete().subscribe();
        }
    }
}
