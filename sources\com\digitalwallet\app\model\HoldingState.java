package com.digitalwallet.app.model;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/model/HoldingState;", "", "(Ljava/lang/String;I)V", "ACTIVE", "EXPIRING_SOON", "EXPIRED", "RECENTLY_EXPIRED", "NOT_YET_ACTIVE", "COMING_SOON", "PROVISIONAL", "CURRENT", "CANCELLED", DebugCoroutineInfoKt.SUSPENDED, "VALID", "AUTHORISED", "DEAUTHORISED", "UNKNOWN", "INTERNAL", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public enum HoldingState {
    ACTIVE,
    EXPIRING_SOON,
    EXPIRED,
    RECENTLY_EXPIRED,
    NOT_YET_ACTIVE,
    COMING_SOON,
    PROVISIONAL,
    CURRENT,
    CANCELLED,
    SUSPENDED,
    VALID,
    AUTHORISED,
    DEAUTHORISED,
    UNKNOWN,
    INTERNAL;
    
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/HoldingState$Companion;", "", "()V", "fromStateString", "Lcom/digitalwallet/app/model/HoldingState;", "state", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Holding.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HoldingState fromStateString(String str) {
            Intrinsics.checkNotNullParameter(str, "state");
            String str2 = str;
            StringBuilder sb = new StringBuilder();
            int length = str2.length();
            for (int i = 0; i < length; i++) {
                char charAt = str2.charAt(i);
                if (charAt != '-') {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
            Objects.requireNonNull(sb2, "null cannot be cast to non-null type java.lang.String");
            String upperCase = sb2.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
            HoldingState holdingState = HoldingState.UNKNOWN;
            try {
                holdingState = HoldingState.valueOf(upperCase);
            } catch (Throwable unused) {
            }
            return holdingState;
        }
    }
}
