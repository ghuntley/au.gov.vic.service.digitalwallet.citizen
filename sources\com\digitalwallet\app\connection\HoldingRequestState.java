package com.digitalwallet.app.connection;

import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.ShareHolding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/connection/HoldingRequestState;", "", "()V", "Disconnected", "Handshaking", "Received", "Receiving", "Requesting", "Terminated", "WaitingForResponse", "Lcom/digitalwallet/app/connection/HoldingRequestState$Handshaking;", "Lcom/digitalwallet/app/connection/HoldingRequestState$Requesting;", "Lcom/digitalwallet/app/connection/HoldingRequestState$WaitingForResponse;", "Lcom/digitalwallet/app/connection/HoldingRequestState$Receiving;", "Lcom/digitalwallet/app/connection/HoldingRequestState$Received;", "Lcom/digitalwallet/app/connection/HoldingRequestState$Terminated;", "Lcom/digitalwallet/app/connection/HoldingRequestState$Disconnected;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingRequestState.kt */
public abstract class HoldingRequestState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/connection/HoldingRequestState$Handshaking;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingRequestState.kt */
    public static final class Handshaking extends HoldingRequestState {
        public Handshaking() {
            super(null);
        }
    }

    private HoldingRequestState() {
    }

    public /* synthetic */ HoldingRequestState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/connection/HoldingRequestState$Requesting;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingRequestState.kt */
    public static final class Requesting extends HoldingRequestState {
        public Requesting() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/connection/HoldingRequestState$WaitingForResponse;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingRequestState.kt */
    public static final class WaitingForResponse extends HoldingRequestState {
        public WaitingForResponse() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/connection/HoldingRequestState$Receiving;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingRequestState.kt */
    public static final class Receiving extends HoldingRequestState {
        public Receiving() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/digitalwallet/app/connection/HoldingRequestState$Received;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "sharedHolding", "Lcom/digitalwallet/app/model/P2PMessage;", "Lcom/digitalwallet/app/model/ShareHolding;", "(Lcom/digitalwallet/app/model/P2PMessage;)V", "getSharedHolding", "()Lcom/digitalwallet/app/model/P2PMessage;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingRequestState.kt */
    public static final class Received extends HoldingRequestState {
        private final P2PMessage<ShareHolding> sharedHolding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Received(P2PMessage<ShareHolding> p2PMessage) {
            super(null);
            Intrinsics.checkNotNullParameter(p2PMessage, "sharedHolding");
            this.sharedHolding = p2PMessage;
        }

        public final P2PMessage<ShareHolding> getSharedHolding() {
            return this.sharedHolding;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/connection/HoldingRequestState$Terminated;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingRequestState.kt */
    public static final class Terminated extends HoldingRequestState {
        private final Throwable error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Terminated(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.error = th;
        }

        public final Throwable getError() {
            return this.error;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/connection/HoldingRequestState$Disconnected;", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingRequestState.kt */
    public static final class Disconnected extends HoldingRequestState {
        public Disconnected() {
            super(null);
        }
    }
}
