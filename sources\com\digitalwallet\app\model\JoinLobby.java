package com.digitalwallet.app.model;

import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/model/JoinLobby;", "Lcom/digitalwallet/app/model/MPContent;", "holdingType", "Lcom/digitalwallet/app/model/HoldingType;", "name", "", "(Lcom/digitalwallet/app/model/HoldingType;Ljava/lang/String;)V", "getHoldingType", "()Lcom/digitalwallet/app/model/HoldingType;", "getName", "()Ljava/lang/String;", "typeString", "getTypeString", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "asMap", "", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class JoinLobby extends MPContent {
    public static final Companion Companion = new Companion(null);
    public static final String holdingTypeKey = "holdingType";
    public static final String nameKey = "name";
    private final HoldingType holdingType;
    private final String name;
    private final String typeString;
    private final MPTypeToken typeToken = MPTypeToken.JOIN_LOBBY;

    public static /* synthetic */ JoinLobby copy$default(JoinLobby joinLobby, HoldingType holdingType2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            holdingType2 = joinLobby.holdingType;
        }
        if ((i & 2) != 0) {
            str = joinLobby.name;
        }
        return joinLobby.copy(holdingType2, str);
    }

    public final HoldingType component1() {
        return this.holdingType;
    }

    public final String component2() {
        return this.name;
    }

    public final JoinLobby copy(HoldingType holdingType2, String str) {
        Intrinsics.checkNotNullParameter(holdingType2, "holdingType");
        Intrinsics.checkNotNullParameter(str, "name");
        return new JoinLobby(holdingType2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JoinLobby)) {
            return false;
        }
        JoinLobby joinLobby = (JoinLobby) obj;
        return Intrinsics.areEqual(this.holdingType, joinLobby.holdingType) && Intrinsics.areEqual(this.name, joinLobby.name);
    }

    public int hashCode() {
        HoldingType holdingType2 = this.holdingType;
        int i = 0;
        int hashCode = (holdingType2 != null ? holdingType2.hashCode() : 0) * 31;
        String str = this.name;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "JoinLobby(holdingType=" + this.holdingType + ", name=" + this.name + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/model/JoinLobby$Companion;", "", "()V", "holdingTypeKey", "", "nameKey", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JoinLobby(HoldingType holdingType2, String str) {
        super(null);
        Intrinsics.checkNotNullParameter(holdingType2, "holdingType");
        Intrinsics.checkNotNullParameter(str, "name");
        this.holdingType = holdingType2;
        this.name = str;
        String name2 = MPTypeToken.JOIN_LOBBY.name();
        Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.typeString = lowerCase;
    }

    public final HoldingType getHoldingType() {
        return this.holdingType;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.digitalwallet.app.model.MPType
    public MPTypeToken getTypeToken() {
        return this.typeToken;
    }

    @Override // com.digitalwallet.app.model.MPType
    public Map<String, Object> asMap() {
        String name2 = this.holdingType.name();
        Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
        String upperCase = name2.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        return MapsKt.mapOf(TuplesKt.to("holdingType", upperCase), TuplesKt.to("name", this.name));
    }

    @Override // com.digitalwallet.app.model.MPContent
    public String getTypeString() {
        return this.typeString;
    }
}
