package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.connection.HoldingRequestState;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "requestState", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: LobbyFragmentViewModel.kt */
public final class LobbyFragmentViewModel$watchRequestState$1<T> implements Consumer<HoldingRequestState> {
    final /* synthetic */ LobbyFragmentViewModel this$0;

    LobbyFragmentViewModel$watchRequestState$1(LobbyFragmentViewModel lobbyFragmentViewModel) {
        this.this$0 = lobbyFragmentViewModel;
    }

    public final void accept(HoldingRequestState holdingRequestState) {
        if (holdingRequestState instanceof HoldingRequestState.Terminated) {
            this.this$0.changeState(new LobbyViewState.RequestError(((HoldingRequestState.Terminated) holdingRequestState).getError()));
        } else if (holdingRequestState instanceof HoldingRequestState.Disconnected) {
            this.this$0.changeState(new LobbyViewState.DisconnectError());
        } else if (holdingRequestState instanceof HoldingRequestState.Received) {
            this.this$0.holdingReceived(((HoldingRequestState.Received) holdingRequestState).getSharedHolding());
        } else {
            LobbyFragmentViewModel lobbyFragmentViewModel = this.this$0;
            Intrinsics.checkNotNullExpressionValue(holdingRequestState, "requestState");
            lobbyFragmentViewModel.changeState(new LobbyViewState.RequestingHolding(holdingRequestState));
        }
    }
}
