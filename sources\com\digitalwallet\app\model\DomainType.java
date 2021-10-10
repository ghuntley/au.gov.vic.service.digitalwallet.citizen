package com.digitalwallet.app.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/model/DomainType;", "", "(Ljava/lang/String;I)V", "holdingType", "Lcom/digitalwallet/app/model/HoldingType;", "getHoldingType$app_citizenProdRelease", "()Lcom/digitalwallet/app/model/HoldingType;", "FISHERIES", "SOLAR_INSTALLATION", "WORKSAFE_HOLDING", "DJPR", "ADD_A_CARD", "UNKNOWN", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public enum DomainType {
    FISHERIES,
    SOLAR_INSTALLATION,
    WORKSAFE_HOLDING,
    DJPR,
    ADD_A_CARD,
    UNKNOWN;
    
    public static final Companion Companion = new Companion(null);
    private static final Map<DomainType, HoldingType> domainToHolding;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/DomainType$Companion;", "", "()V", "domainToHolding", "", "Lcom/digitalwallet/app/model/DomainType;", "Lcom/digitalwallet/app/model/HoldingType;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Holding.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        DomainType domainType;
        DomainType domainType2;
        DomainType domainType3;
        DomainType domainType4;
        DomainType domainType5;
        domainToHolding = MapsKt.mapOf(TuplesKt.to(domainType, HoldingType.FISHING_LICENCE), TuplesKt.to(domainType2, HoldingType.SOLAR_INSTALLER), TuplesKt.to(domainType4, HoldingType.KANGAROO_HARVESTER), TuplesKt.to(domainType5, HoldingType.ADD_A_CARD), TuplesKt.to(domainType3, HoldingType.WORKSAFE_LICENCE));
    }

    public final HoldingType getHoldingType$app_citizenProdRelease() {
        HoldingType holdingType = domainToHolding.get(this);
        return holdingType != null ? holdingType : HoldingType.UNKNOWN;
    }
}
