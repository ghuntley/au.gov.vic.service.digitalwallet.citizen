package com.digitalwallet.app.view.main;

import com.digitalwallet.app.connection.NamedDevice;
import com.digitalwallet.utilities.AnalyticsHelper;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "devices", "", "Lcom/digitalwallet/app/connection/NamedDevice;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: LobbyFragment.kt */
public final class LobbyFragment$scan$1<T> implements Consumer<List<? extends NamedDevice>> {
    final /* synthetic */ LobbyFragment this$0;

    LobbyFragment$scan$1(LobbyFragment lobbyFragment) {
        this.this$0 = lobbyFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends NamedDevice> list) {
        accept((List<NamedDevice>) list);
    }

    public final void accept(List<NamedDevice> list) {
        Intrinsics.checkNotNullExpressionValue(list, "devices");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t.getDetails().getHoldingFlags().contains(LobbyFragment.access$getSharingCode$p(this.this$0))) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            AnalyticsHelper.addCount$default(this.this$0.getAnalytics(), "authority_no_devices", 1, null, 4, null);
        }
        LobbyFragment lobbyFragment = this.this$0;
        lobbyFragment.setLobby(new Pair(LobbyFragment.access$getSharingCode$p(lobbyFragment), arrayList2));
    }
}
