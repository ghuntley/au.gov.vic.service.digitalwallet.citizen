package com.digitalwallet.app.model;

import androidx.core.os.EnvironmentCompat;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/model/DurationType;", "", "remoteName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "shouldNotifyExpiry", "", "getShouldNotifyExpiry", "()Z", "DAY_3", "DAY_28", "YEAR_1", "YEAR_3", "UNKNOWN", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public enum DurationType {
    DAY_3("3-day"),
    DAY_28("28-day"),
    YEAR_1("1-year"),
    YEAR_3("3-year"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);
    
    public static final Companion Companion = new Companion(null);
    private final String remoteName;

    private DurationType(String str) {
        this.remoteName = str;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/DurationType$Companion;", "", "()V", "fromLicenceKind", "Lcom/digitalwallet/app/model/DurationType;", "licenceKind", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Holding.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DurationType fromLicenceKind(String str) {
            DurationType durationType;
            Intrinsics.checkNotNullParameter(str, "licenceKind");
            DurationType[] values = DurationType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    durationType = null;
                    break;
                }
                durationType = values[i];
                String str2 = durationType.remoteName;
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (Intrinsics.areEqual(str2, lowerCase)) {
                    break;
                }
                i++;
            }
            return durationType != null ? durationType : DurationType.UNKNOWN;
        }
    }

    public final boolean getShouldNotifyExpiry() {
        return !CollectionsKt.listOf((Object[]) new DurationType[]{DAY_3, UNKNOWN}).contains(this);
    }
}
