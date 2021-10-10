package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.connection.HoldingRequestState;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.ShareHolding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002\u0001\n\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "", "()V", "equals", "", "other", "DisconnectError", "Error", "FoundUser", "NoneFound", "ReceivedHolding", "RequestDenied", "RequestError", "RequestingHolding", "ScanError", "Searching", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$Searching;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$FoundUser;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$RequestingHolding;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$ReceivedHolding;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$RequestError;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$RequestDenied;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$DisconnectError;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$Error;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$ScanError;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$NoneFound;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LobbyViewState.kt */
public abstract class LobbyViewState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$Searching;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class Searching extends LobbyViewState {
        public Searching() {
            super(null);
        }
    }

    private LobbyViewState() {
    }

    public /* synthetic */ LobbyViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$FoundUser;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class FoundUser extends LobbyViewState {
        public FoundUser() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$RequestingHolding;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "requestState", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "(Lcom/digitalwallet/app/connection/HoldingRequestState;)V", "getRequestState", "()Lcom/digitalwallet/app/connection/HoldingRequestState;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class RequestingHolding extends LobbyViewState {
        private final HoldingRequestState requestState;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RequestingHolding(HoldingRequestState holdingRequestState) {
            super(null);
            Intrinsics.checkNotNullParameter(holdingRequestState, "requestState");
            this.requestState = holdingRequestState;
        }

        public final HoldingRequestState getRequestState() {
            return this.requestState;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$ReceivedHolding;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "sharedHolding", "Lcom/digitalwallet/app/model/P2PMessage;", "Lcom/digitalwallet/app/model/ShareHolding;", "(Lcom/digitalwallet/app/model/P2PMessage;)V", "getSharedHolding", "()Lcom/digitalwallet/app/model/P2PMessage;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class ReceivedHolding extends LobbyViewState {
        private final P2PMessage<ShareHolding> sharedHolding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReceivedHolding(P2PMessage<ShareHolding> p2PMessage) {
            super(null);
            Intrinsics.checkNotNullParameter(p2PMessage, "sharedHolding");
            this.sharedHolding = p2PMessage;
        }

        public final P2PMessage<ShareHolding> getSharedHolding() {
            return this.sharedHolding;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$RequestError;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class RequestError extends LobbyViewState {
        private final Throwable error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RequestError(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.error = th;
        }

        public final Throwable getError() {
            return this.error;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$RequestDenied;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class RequestDenied extends LobbyViewState {
        public RequestDenied() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$DisconnectError;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class DisconnectError extends LobbyViewState {
        public DisconnectError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$Error;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class Error extends LobbyViewState {
        private final Throwable error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.error = th;
        }

        public final Throwable getError() {
            return this.error;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$ScanError;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class ScanError extends LobbyViewState {
        public ScanError() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState$NoneFound;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyViewState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyViewState.kt */
    public static final class NoneFound extends LobbyViewState {
        public NoneFound() {
            super(null);
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = null;
        if (this instanceof RequestingHolding) {
            if (!(obj instanceof RequestingHolding)) {
                obj = null;
            }
            RequestingHolding requestingHolding = (RequestingHolding) obj;
            if (requestingHolding != null) {
                obj2 = requestingHolding.getRequestState();
            }
            return Intrinsics.areEqual(obj2, ((RequestingHolding) this).getRequestState());
        } else if (this instanceof ReceivedHolding) {
            if (!(obj instanceof ReceivedHolding)) {
                obj = null;
            }
            ReceivedHolding receivedHolding = (ReceivedHolding) obj;
            if (receivedHolding != null) {
                obj2 = receivedHolding.getSharedHolding();
            }
            return Intrinsics.areEqual(obj2, ((ReceivedHolding) this).getSharedHolding());
        } else if (!(this instanceof Error)) {
            return false;
        } else {
            if (!(obj instanceof Error)) {
                obj = null;
            }
            Error error = (Error) obj;
            if (error != null) {
                obj2 = error.getError();
            }
            return Intrinsics.areEqual(obj2, ((Error) this).getError());
        }
    }
}
