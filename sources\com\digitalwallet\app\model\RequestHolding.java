package com.digitalwallet.app.model;

import com.nimbusds.jwt.SignedJWT;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0016J\r\u0010\u0015\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J#\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/digitalwallet/app/model/RequestHolding;", "Lcom/digitalwallet/app/model/MPContent;", RequestHolding.sharingCodeKey, "", "Lcom/digitalwallet/app/model/SharingCode;", "identity", "Lcom/nimbusds/jwt/SignedJWT;", "(Ljava/lang/String;Lcom/nimbusds/jwt/SignedJWT;)V", "getIdentity", "()Lcom/nimbusds/jwt/SignedJWT;", "getSharingCode", "()Ljava/lang/String;", "typeString", "getTypeString", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "asMap", "", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class RequestHolding extends MPContent {
    public static final Companion Companion = new Companion(null);
    public static final String identityKey = "requesterJWS";
    public static final String sharingCodeKey = "sharingCode";
    private final SignedJWT identity;
    private final String sharingCode;
    private final String typeString;
    private final MPTypeToken typeToken = MPTypeToken.HOLDING_REQUEST;

    public static /* synthetic */ RequestHolding copy$default(RequestHolding requestHolding, String str, SignedJWT signedJWT, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestHolding.sharingCode;
        }
        if ((i & 2) != 0) {
            signedJWT = requestHolding.identity;
        }
        return requestHolding.copy(str, signedJWT);
    }

    public final String component1() {
        return this.sharingCode;
    }

    public final SignedJWT component2() {
        return this.identity;
    }

    public final RequestHolding copy(String str, SignedJWT signedJWT) {
        Intrinsics.checkNotNullParameter(str, sharingCodeKey);
        return new RequestHolding(str, signedJWT);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestHolding)) {
            return false;
        }
        RequestHolding requestHolding = (RequestHolding) obj;
        return Intrinsics.areEqual(this.sharingCode, requestHolding.sharingCode) && Intrinsics.areEqual(this.identity, requestHolding.identity);
    }

    public int hashCode() {
        String str = this.sharingCode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        SignedJWT signedJWT = this.identity;
        if (signedJWT != null) {
            i = signedJWT.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RequestHolding(sharingCode=" + this.sharingCode + ", identity=" + this.identity + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/model/RequestHolding$Companion;", "", "()V", "identityKey", "", "sharingCodeKey", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestHolding(String str, SignedJWT signedJWT) {
        super(null);
        Intrinsics.checkNotNullParameter(str, sharingCodeKey);
        this.sharingCode = str;
        this.identity = signedJWT;
        String name = MPTypeToken.HOLDING_REQUEST.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.typeString = lowerCase;
    }

    public final SignedJWT getIdentity() {
        return this.identity;
    }

    public final String getSharingCode() {
        return this.sharingCode;
    }

    @Override // com.digitalwallet.app.model.MPContent
    public String getTypeString() {
        return this.typeString;
    }

    @Override // com.digitalwallet.app.model.MPType
    public MPTypeToken getTypeToken() {
        return this.typeToken;
    }

    @Override // com.digitalwallet.app.model.MPType
    public Map<String, Object> asMap() {
        return MapsKt.mapOf(TuplesKt.to(sharingCodeKey, this.sharingCode), TuplesKt.to("requesterJWS", this.identity));
    }
}
