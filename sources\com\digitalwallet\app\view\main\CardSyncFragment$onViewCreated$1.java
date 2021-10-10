package com.digitalwallet.app.view.main;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.digitalwallet.app.view.main.CardSyncFragment;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardSyncViewState;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardSyncFragment.kt */
final class CardSyncFragment$onViewCreated$1<T> implements Observer<CardSyncViewState> {
    final /* synthetic */ CardSyncFragment this$0;

    CardSyncFragment$onViewCreated$1(CardSyncFragment cardSyncFragment) {
        this.this$0 = cardSyncFragment;
    }

    public final void onChanged(CardSyncViewState cardSyncViewState) {
        if (cardSyncViewState != null) {
            int i = CardSyncFragment.WhenMappings.$EnumSwitchMapping$0[cardSyncViewState.ordinal()];
            if (i == 1) {
                CardSyncViewModel viewModel = this.this$0.getViewModel();
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNull(context);
                Intrinsics.checkNotNullExpressionValue(context, "context!!");
                viewModel.refreshHoldings(context);
            } else if (i == 2) {
                this.this$0.finishUp();
            } else if (i == 3) {
                this.this$0.getAnalytics().viewItem("Error", "Table load failed - Holdings select");
            }
        }
    }
}
