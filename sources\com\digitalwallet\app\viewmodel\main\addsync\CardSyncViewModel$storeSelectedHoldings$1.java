package com.digitalwallet.app.viewmodel.main.addsync;

import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardSyncViewModel.kt */
public final class CardSyncViewModel$storeSelectedHoldings$1<T> implements Consumer<List<? extends SecureHolding>> {
    final /* synthetic */ CardSyncViewModel this$0;

    CardSyncViewModel$storeSelectedHoldings$1(CardSyncViewModel cardSyncViewModel) {
        this.this$0 = cardSyncViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends SecureHolding> list) {
        accept((List<SecureHolding>) list);
    }

    public final void accept(List<SecureHolding> list) {
        this.this$0.getViewState().setValue(CardSyncViewState.COMPLETE);
    }
}
