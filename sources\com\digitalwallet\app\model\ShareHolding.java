package com.digitalwallet.app.model;

import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.nimbusds.jwt.SignedJWT;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/digitalwallet/app/model/ShareHolding;", "Lcom/digitalwallet/app/model/MPContent;", "holdingResponseStatus", "Lcom/digitalwallet/app/model/HoldingResponseStatus;", HoldingExpiryPublisher.HOLDING_KEY, "Lcom/nimbusds/jwt/SignedJWT;", "assetData", "", "", "(Lcom/digitalwallet/app/model/HoldingResponseStatus;Lcom/nimbusds/jwt/SignedJWT;Ljava/util/List;)V", "getAssetData", "()Ljava/util/List;", "getHolding", "()Lcom/nimbusds/jwt/SignedJWT;", "getHoldingResponseStatus", "()Lcom/digitalwallet/app/model/HoldingResponseStatus;", "typeString", "", "getTypeString", "()Ljava/lang/String;", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "asMap", "", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class ShareHolding extends MPContent {
    public static final Companion Companion = new Companion(null);
    public static final String assetDataKey = "assets";
    public static final String holdingKey = "holdingJWS";
    public static final String holdingResponseKey = "status";
    private final List<byte[]> assetData;
    private final SignedJWT holding;
    private final HoldingResponseStatus holdingResponseStatus;
    private final String typeString;
    private final MPTypeToken typeToken = MPTypeToken.HOLDING_RESPONSE;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.ShareHolding */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShareHolding copy$default(ShareHolding shareHolding, HoldingResponseStatus holdingResponseStatus2, SignedJWT signedJWT, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            holdingResponseStatus2 = shareHolding.holdingResponseStatus;
        }
        if ((i & 2) != 0) {
            signedJWT = shareHolding.holding;
        }
        if ((i & 4) != 0) {
            list = shareHolding.assetData;
        }
        return shareHolding.copy(holdingResponseStatus2, signedJWT, list);
    }

    public final HoldingResponseStatus component1() {
        return this.holdingResponseStatus;
    }

    public final SignedJWT component2() {
        return this.holding;
    }

    public final List<byte[]> component3() {
        return this.assetData;
    }

    public final ShareHolding copy(HoldingResponseStatus holdingResponseStatus2, SignedJWT signedJWT, List<byte[]> list) {
        Intrinsics.checkNotNullParameter(holdingResponseStatus2, "holdingResponseStatus");
        return new ShareHolding(holdingResponseStatus2, signedJWT, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareHolding)) {
            return false;
        }
        ShareHolding shareHolding = (ShareHolding) obj;
        return Intrinsics.areEqual(this.holdingResponseStatus, shareHolding.holdingResponseStatus) && Intrinsics.areEqual(this.holding, shareHolding.holding) && Intrinsics.areEqual(this.assetData, shareHolding.assetData);
    }

    public int hashCode() {
        HoldingResponseStatus holdingResponseStatus2 = this.holdingResponseStatus;
        int i = 0;
        int hashCode = (holdingResponseStatus2 != null ? holdingResponseStatus2.hashCode() : 0) * 31;
        SignedJWT signedJWT = this.holding;
        int hashCode2 = (hashCode + (signedJWT != null ? signedJWT.hashCode() : 0)) * 31;
        List<byte[]> list = this.assetData;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ShareHolding(holdingResponseStatus=" + this.holdingResponseStatus + ", holding=" + this.holding + ", assetData=" + this.assetData + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/ShareHolding$Companion;", "", "()V", "assetDataKey", "", "holdingKey", "holdingResponseKey", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareHolding(HoldingResponseStatus holdingResponseStatus2, SignedJWT signedJWT, List<byte[]> list) {
        super(null);
        Intrinsics.checkNotNullParameter(holdingResponseStatus2, "holdingResponseStatus");
        this.holdingResponseStatus = holdingResponseStatus2;
        this.holding = signedJWT;
        this.assetData = list;
        String mPTypeToken = MPTypeToken.HOLDING_RESPONSE.toString();
        Objects.requireNonNull(mPTypeToken, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = mPTypeToken.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.typeString = lowerCase;
    }

    public final List<byte[]> getAssetData() {
        return this.assetData;
    }

    public final SignedJWT getHolding() {
        return this.holding;
    }

    public final HoldingResponseStatus getHoldingResponseStatus() {
        return this.holdingResponseStatus;
    }

    @Override // com.digitalwallet.app.model.MPType
    public MPTypeToken getTypeToken() {
        return this.typeToken;
    }

    @Override // com.digitalwallet.app.model.MPContent
    public String getTypeString() {
        return this.typeString;
    }

    @Override // com.digitalwallet.app.model.MPType
    public Map<String, Object> asMap() {
        String name = this.holdingResponseStatus.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return MapsKt.mapOf(TuplesKt.to(holdingKey, this.holding), TuplesKt.to(assetDataKey, this.assetData), TuplesKt.to("status", lowerCase));
    }
}
