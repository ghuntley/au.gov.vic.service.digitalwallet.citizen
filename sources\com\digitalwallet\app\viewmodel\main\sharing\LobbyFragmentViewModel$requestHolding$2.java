package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.connection.BLEClient;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: LobbyFragmentViewModel.kt */
public final class LobbyFragmentViewModel$requestHolding$2<T> implements Consumer<Throwable> {
    final /* synthetic */ LobbyFragmentViewModel this$0;

    LobbyFragmentViewModel$requestHolding$2(LobbyFragmentViewModel lobbyFragmentViewModel) {
        this.this$0 = lobbyFragmentViewModel;
    }

    public final void accept(Throwable th) {
        Timber.e(th);
        if (th instanceof BLEClient.HandshakeConnectionError) {
            this.this$0.changeState(new LobbyViewState.DisconnectError());
            return;
        }
        LobbyFragmentViewModel lobbyFragmentViewModel = this.this$0;
        Intrinsics.checkNotNullExpressionValue(th, "error");
        lobbyFragmentViewModel.changeState(new LobbyViewState.RequestError(th));
    }
}
