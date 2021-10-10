package com.digitalwallet.app.view.main;

import com.digitalwallet.app.connection.BLEClient;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: LobbyFragment.kt */
public final class LobbyFragment$scan$2<T> implements Consumer<Throwable> {
    final /* synthetic */ LobbyFragment this$0;

    LobbyFragment$scan$2(LobbyFragment lobbyFragment) {
        this.this$0 = lobbyFragment;
    }

    public final void accept(Throwable th) {
        try {
            Intrinsics.checkNotNullExpressionValue(th, "error");
            throw th;
        } catch (BLEClient.ImmediateScanFail unused) {
            this.this$0.getViewModel().changeState(new LobbyViewState.ScanError());
        } catch (Throwable th2) {
            this.this$0.getViewModel().changeState(new LobbyViewState.Error(th2));
        }
    }
}
