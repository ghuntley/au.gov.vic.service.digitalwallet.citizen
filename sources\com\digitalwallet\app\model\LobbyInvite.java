package com.digitalwallet.app.model;

import com.nimbusds.jwt.SignedJWT;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/digitalwallet/app/model/LobbyInvite;", "Lcom/digitalwallet/app/model/MPContent;", "holdingType", "Lcom/digitalwallet/app/model/HoldingType;", "identity", "Lcom/nimbusds/jwt/SignedJWT;", "(Lcom/digitalwallet/app/model/HoldingType;Lcom/nimbusds/jwt/SignedJWT;)V", "getHoldingType", "()Lcom/digitalwallet/app/model/HoldingType;", "getIdentity", "()Lcom/nimbusds/jwt/SignedJWT;", "typeString", "", "getTypeString", "()Ljava/lang/String;", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "asMap", "", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class LobbyInvite extends MPContent {
    public static final Companion Companion = new Companion(null);
    public static final String holdingTypeKey = "holdingType";
    public static final String identityKey = "requesterJWS";
    private final HoldingType holdingType;
    private final SignedJWT identity;
    private final String typeString;
    private final MPTypeToken typeToken = MPTypeToken.INVITE_LOBBY;

    public static /* synthetic */ LobbyInvite copy$default(LobbyInvite lobbyInvite, HoldingType holdingType2, SignedJWT signedJWT, int i, Object obj) {
        if ((i & 1) != 0) {
            holdingType2 = lobbyInvite.holdingType;
        }
        if ((i & 2) != 0) {
            signedJWT = lobbyInvite.identity;
        }
        return lobbyInvite.copy(holdingType2, signedJWT);
    }

    public final HoldingType component1() {
        return this.holdingType;
    }

    public final SignedJWT component2() {
        return this.identity;
    }

    public final LobbyInvite copy(HoldingType holdingType2, SignedJWT signedJWT) {
        Intrinsics.checkNotNullParameter(holdingType2, "holdingType");
        return new LobbyInvite(holdingType2, signedJWT);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LobbyInvite)) {
            return false;
        }
        LobbyInvite lobbyInvite = (LobbyInvite) obj;
        return Intrinsics.areEqual(this.holdingType, lobbyInvite.holdingType) && Intrinsics.areEqual(this.identity, lobbyInvite.identity);
    }

    public int hashCode() {
        HoldingType holdingType2 = this.holdingType;
        int i = 0;
        int hashCode = (holdingType2 != null ? holdingType2.hashCode() : 0) * 31;
        SignedJWT signedJWT = this.identity;
        if (signedJWT != null) {
            i = signedJWT.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LobbyInvite(holdingType=" + this.holdingType + ", identity=" + this.identity + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/model/LobbyInvite$Companion;", "", "()V", "holdingTypeKey", "", "identityKey", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LobbyInvite(HoldingType holdingType2, SignedJWT signedJWT) {
        super(null);
        Intrinsics.checkNotNullParameter(holdingType2, "holdingType");
        this.holdingType = holdingType2;
        this.identity = signedJWT;
        String name = MPTypeToken.INVITE_LOBBY.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.typeString = lowerCase;
    }

    public final HoldingType getHoldingType() {
        return this.holdingType;
    }

    public final SignedJWT getIdentity() {
        return this.identity;
    }

    @Override // com.digitalwallet.app.model.MPType
    public MPTypeToken getTypeToken() {
        return this.typeToken;
    }

    @Override // com.digitalwallet.app.model.MPType
    public Map<String, Object> asMap() {
        Pair[] pairArr = new Pair[2];
        String name = this.holdingType.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String upperCase = name.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        pairArr[0] = TuplesKt.to("holdingType", upperCase);
        SignedJWT signedJWT = this.identity;
        pairArr[1] = TuplesKt.to("requesterJWS", signedJWT != null ? signedJWT.serialize() : null);
        return MapsKt.mapOf(pairArr);
    }

    @Override // com.digitalwallet.app.model.MPContent
    public String getTypeString() {
        return this.typeString;
    }
}
