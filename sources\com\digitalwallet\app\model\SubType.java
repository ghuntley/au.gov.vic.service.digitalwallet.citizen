package com.digitalwallet.app.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/model/SubType;", "", "remoteName", "", "displayName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getRemoteName", "FISHING_LICENCE", "DEFAULT_LICENCE", "AMBULANCE_MEMBERSHIP", "AUTHORITY", "WWC_VOLUNTEER", "WORKSAFE_CONSTRUCTION_INDUCTION_WHITE_CARD", "WORKSAFE_HIGH_RISK_LICENCE", "WORKSAFE_PYROTECHNICIANS_LICENCE", "WORKSAFE_DANGEROUS_GOODS_LICENCE", "WORKSAFE_BLASTING_EXPLOSIVES_LICENCE", "WORKSAFE_EXPLOSIVES_DRIVER_LICENCE", "WORKSAFE_HIGH_CONSEQUENCE_DANGEROUS_GOODS_PERMIT", "KANGAROO_HARVESTER", "UNKNOWN", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public enum SubType {
    FISHING_LICENCE("FISHING_LICENCE", null, 2, null),
    DEFAULT_LICENCE("LICENCE", null, 2, null),
    AMBULANCE_MEMBERSHIP("AMBULANCE_MEMBERSHIP", null, 2, null),
    AUTHORITY("AUTHORITY", null, 2, null),
    WWC_VOLUNTEER("WWC_VOLUNTEER", "Volunteer"),
    WORKSAFE_CONSTRUCTION_INDUCTION_WHITE_CARD("CONSTRUCTION_INDUCTION_WHITE_CARD", "Construction Induction (White Card)"),
    WORKSAFE_HIGH_RISK_LICENCE("HIGH_RISK_WORK_LICENCE", "High Risk Work Licence"),
    WORKSAFE_PYROTECHNICIANS_LICENCE("PYROTECHNICIANS_LICENCE", "Pyrotechnicians Licence"),
    WORKSAFE_DANGEROUS_GOODS_LICENCE("DANGEROUS_GOODS_LICENCE", "Dangerous Goods Licence"),
    WORKSAFE_BLASTING_EXPLOSIVES_LICENCE("BLASTING_EXPLOSIVES_LICENCE", "Blasting Explosives Licence"),
    WORKSAFE_EXPLOSIVES_DRIVER_LICENCE("EXPLOSIVES_DRIVER_LICENCE", "Explosives Driver Licence"),
    WORKSAFE_HIGH_CONSEQUENCE_DANGEROUS_GOODS_PERMIT("HIGH_CONSEQUENCE_DANGEROUS_GOODS_PERMIT", "High Consequence Dangerous Goods Permit"),
    KANGAROO_HARVESTER("LICENCE", null, 2, null),
    UNKNOWN(AttributeDetailItem.NOT_AVAILABLE, null, 2, null);
    
    public static final Companion Companion = new Companion(null);
    private static final ClosedRange<SubType> worksafeTypes;
    private final String displayName;
    private final String remoteName;

    private SubType(String str, String str2) {
        this.remoteName = str;
        this.displayName = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ SubType(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getRemoteName() {
        return this.remoteName;
    }

    static {
        SubType subType;
        SubType subType2;
        worksafeTypes = RangesKt.rangeTo(subType, subType2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/model/SubType$Companion;", "", "()V", "worksafeTypes", "Lkotlin/ranges/ClosedRange;", "Lcom/digitalwallet/app/model/SubType;", "getWorksafeTypes", "()Lkotlin/ranges/ClosedRange;", "fromString", "subType", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Holding.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubType fromString(String str) {
            SubType subType;
            Intrinsics.checkNotNullParameter(str, "subType");
            SubType[] values = SubType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    subType = null;
                    break;
                }
                subType = values[i];
                if (Intrinsics.areEqual(subType.getRemoteName(), str)) {
                    break;
                }
                i++;
            }
            return subType != null ? subType : SubType.UNKNOWN;
        }

        public final ClosedRange<SubType> getWorksafeTypes() {
            return SubType.worksafeTypes;
        }
    }
}
