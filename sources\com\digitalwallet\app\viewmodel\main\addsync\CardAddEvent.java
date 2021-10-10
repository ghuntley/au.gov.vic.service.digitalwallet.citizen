package com.digitalwallet.app.viewmodel.main.addsync;

import com.digitalwallet.app.model.HoldingType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent;", "", "()V", "CardSync", "ComingSoonHolding", "WebRequest", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent$WebRequest;", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent$ComingSoonHolding;", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent$CardSync;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CardAddEvent.kt */
public abstract class CardAddEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent$WebRequest;", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent;", "linkRes", "", "(I)V", "getLinkRes", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CardAddEvent.kt */
    public static final class WebRequest extends CardAddEvent {
        private final int linkRes;

        public static /* synthetic */ WebRequest copy$default(WebRequest webRequest, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = webRequest.linkRes;
            }
            return webRequest.copy(i);
        }

        public final int component1() {
            return this.linkRes;
        }

        public final WebRequest copy(int i) {
            return new WebRequest(i);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof WebRequest) && this.linkRes == ((WebRequest) obj).linkRes;
            }
            return true;
        }

        public int hashCode() {
            return this.linkRes;
        }

        public String toString() {
            return "WebRequest(linkRes=" + this.linkRes + ")";
        }

        public WebRequest(int i) {
            super(null);
            this.linkRes = i;
        }

        public final int getLinkRes() {
            return this.linkRes;
        }
    }

    private CardAddEvent() {
    }

    public /* synthetic */ CardAddEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent$ComingSoonHolding;", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent;", "holdingType", "Lcom/digitalwallet/app/model/HoldingType;", "(Lcom/digitalwallet/app/model/HoldingType;)V", "getHoldingType", "()Lcom/digitalwallet/app/model/HoldingType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CardAddEvent.kt */
    public static final class ComingSoonHolding extends CardAddEvent {
        private final HoldingType holdingType;

        public static /* synthetic */ ComingSoonHolding copy$default(ComingSoonHolding comingSoonHolding, HoldingType holdingType2, int i, Object obj) {
            if ((i & 1) != 0) {
                holdingType2 = comingSoonHolding.holdingType;
            }
            return comingSoonHolding.copy(holdingType2);
        }

        public final HoldingType component1() {
            return this.holdingType;
        }

        public final ComingSoonHolding copy(HoldingType holdingType2) {
            Intrinsics.checkNotNullParameter(holdingType2, "holdingType");
            return new ComingSoonHolding(holdingType2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof ComingSoonHolding) && Intrinsics.areEqual(this.holdingType, ((ComingSoonHolding) obj).holdingType);
            }
            return true;
        }

        public int hashCode() {
            HoldingType holdingType2 = this.holdingType;
            if (holdingType2 != null) {
                return holdingType2.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "ComingSoonHolding(holdingType=" + this.holdingType + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ComingSoonHolding(HoldingType holdingType2) {
            super(null);
            Intrinsics.checkNotNullParameter(holdingType2, "holdingType");
            this.holdingType = holdingType2;
        }

        public final HoldingType getHoldingType() {
            return this.holdingType;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent$CardSync;", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddEvent;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CardAddEvent.kt */
    public static final class CardSync extends CardAddEvent {
        public static final CardSync INSTANCE = new CardSync();

        private CardSync() {
            super(null);
        }
    }
}
