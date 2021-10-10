package com.digitalwallet.app.viewmodel.main.addsync;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "mappedCards", "", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardDetailItem;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardSyncViewModel.kt */
public final class CardSyncViewModel$refreshHoldings$4<T> implements Consumer<List<? extends CardDetailItem>> {
    final /* synthetic */ CardSyncViewModel this$0;

    CardSyncViewModel$refreshHoldings$4(CardSyncViewModel cardSyncViewModel) {
        this.this$0 = cardSyncViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends CardDetailItem> list) {
        accept((List<CardDetailItem>) list);
    }

    public final void accept(List<CardDetailItem> list) {
        CardSyncViewState cardSyncViewState;
        this.this$0.getCardSyncList().setValue(list);
        this.this$0.updateHasAnyCardSelected();
        MutableLiveData<CardSyncViewState> viewState = this.this$0.getViewState();
        Intrinsics.checkNotNullExpressionValue(list, "mappedCards");
        if (!list.isEmpty()) {
            cardSyncViewState = CardSyncViewState.HOLDINGS;
        } else {
            cardSyncViewState = CardSyncViewState.NO_HOLDINGS;
        }
        viewState.setValue(cardSyncViewState);
    }
}
