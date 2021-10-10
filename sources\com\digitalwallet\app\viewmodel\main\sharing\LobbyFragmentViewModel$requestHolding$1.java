package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.connection.HoldingRequestState;
import com.digitalwallet.app.connection.NamedDevice;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "holdings", "", "Lcom/digitalwallet/app/model/SecureHolding;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: LobbyFragmentViewModel.kt */
public final class LobbyFragmentViewModel$requestHolding$1<T, R> implements Function<List<? extends SecureHolding>, CompletableSource> {
    final /* synthetic */ NamedDevice $member;
    final /* synthetic */ String $sharingCode;
    final /* synthetic */ LobbyFragmentViewModel this$0;

    LobbyFragmentViewModel$requestHolding$1(LobbyFragmentViewModel lobbyFragmentViewModel, String str, NamedDevice namedDevice) {
        this.this$0 = lobbyFragmentViewModel;
        this.$sharingCode = str;
        this.$member = namedDevice;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ CompletableSource apply(List<? extends SecureHolding> list) {
        return apply((List<SecureHolding>) list);
    }

    public final CompletableSource apply(List<SecureHolding> list) {
        T t;
        Intrinsics.checkNotNullParameter(list, "holdings");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getAttributes().getSharingCode(), this.$sharingCode)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            this.this$0.analytics.selectContent("Authority - Request", t2.holdingTypeName(this.this$0.getView().getContext()));
            this.this$0.changeState(new LobbyViewState.RequestingHolding(new HoldingRequestState.Handshaking()));
            Pair<Completable, PublishRelay<HoldingRequestState>> requestHolding = this.this$0.getBleClient().requestHolding(this.$member.getDevice());
            this.this$0.watchRequestState(requestHolding.getSecond());
            Completable first = requestHolding.getFirst();
            if (first != null) {
                return first;
            }
        }
        throw new IllegalStateException("No holding with matching sharingCode found. Can't make a request".toString());
    }
}
