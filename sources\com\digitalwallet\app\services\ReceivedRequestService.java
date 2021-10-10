package com.digitalwallet.app.services;

import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.di.ActivityScope;
import io.reactivex.Maybe;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ActivityScope
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/services/ReceivedRequestService;", "", "()V", "_requestsReceived", "", "Ljava/util/UUID;", "Lcom/digitalwallet/app/model/RequestHolding;", "requestsReceived", "", "getRequestsReceived", "()Ljava/util/Map;", "clear", "", "handleRequest", "Lio/reactivex/Maybe;", "Lcom/digitalwallet/app/model/P2PMessage;", "incoming", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ReceivedRequestService.kt */
public final class ReceivedRequestService {
    private final Map<UUID, RequestHolding> _requestsReceived = new LinkedHashMap();

    public final Maybe<P2PMessage<RequestHolding>> handleRequest(P2PMessage<RequestHolding> p2PMessage) {
        Maybe<P2PMessage<RequestHolding>> empty;
        Intrinsics.checkNotNullParameter(p2PMessage, "incoming");
        if (this._requestsReceived.get(p2PMessage.getHeader().getMessageID()) != null && (empty = Maybe.empty()) != null) {
            return empty;
        }
        this._requestsReceived.put(p2PMessage.getHeader().getMessageID(), p2PMessage.getBody().getContents());
        Maybe<P2PMessage<RequestHolding>> just = Maybe.just(p2PMessage);
        Intrinsics.checkNotNullExpressionValue(just, "run {\n                  …ng)\n                    }");
        return just;
    }

    public final void clear() {
        this._requestsReceived.clear();
    }

    public final Map<UUID, RequestHolding> getRequestsReceived() {
        return this._requestsReceived;
    }
}
