package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.model.db.unsecure.AssetListConverter;
import com.digitalwallet.di.ActivityScope;
import com.google.firebase.messaging.Constants;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.ECDSAVerifier;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jwt.SignedJWT;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@ActivityScope
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/holdings/HoldingParser;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "getIssuerPublicKey", "Ljava/security/interfaces/ECPublicKey;", "kid", "", "set", "Lcom/nimbusds/jose/jwk/JWKSet;", "parseHolding", "Lcom/digitalwallet/app/model/SecureHolding;", HoldingExpiryPublisher.HOLDING_KEY, "Lcom/nimbusds/jwt/SignedJWT;", "parseHoldings", "", "holdings", "validate", "", "verifySubjectPublicKey", "getJWK", "Lcom/nimbusds/jose/jwk/JWK;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingParser.kt */
public final class HoldingParser {
    private final Moshi moshi;

    @Inject
    public HoldingParser(Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    public final List<SecureHolding> parseHoldings(List<? extends SignedJWT> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SecureHolding parseHolding = parseHolding(it.next());
            if (parseHolding != null) {
                arrayList.add(parseHolding);
            }
        }
        return arrayList;
    }

    public final SecureHolding parseHolding(SignedJWT signedJWT) {
        DynamicHoldingDisplay dynamicHoldingDisplay;
        Intrinsics.checkNotNullParameter(signedJWT, HoldingExpiryPublisher.HOLDING_KEY);
        String serialize = signedJWT.serialize();
        JSONObject jSONObject = signedJWT.getPayload().toJSONObject();
        String str = (String) jSONObject.get("sub");
        String str2 = null;
        if (str != null) {
            Object obj = jSONObject.get("attributes");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type net.minidev.json.JSONObject");
            String jSONObject2 = ((JSONObject) obj).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "(json[\"attributes\"] as JSONObject).toString()");
            JsonAdapter adapter = this.moshi.adapter(HoldingRecordAttributes.class);
            Intrinsics.checkNotNullExpressionValue(adapter, "this.adapter(T::class.java)");
            HoldingRecordAttributes holdingRecordAttributes = (HoldingRecordAttributes) adapter.fromJson(jSONObject2);
            if (holdingRecordAttributes != null) {
                Intrinsics.checkNotNullExpressionValue(holdingRecordAttributes, "moshi.adapter<HoldingRec…           ?: return null");
                Object obj2 = jSONObject.get(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                if (!(obj2 instanceof JSONObject)) {
                    obj2 = null;
                }
                JSONObject jSONObject3 = (JSONObject) obj2;
                String jSONObject4 = jSONObject3 != null ? jSONObject3.toString() : null;
                if (jSONObject4 != null) {
                    JsonAdapter adapter2 = this.moshi.adapter(DynamicHoldingDisplay.class);
                    Intrinsics.checkNotNullExpressionValue(adapter2, "this.adapter(T::class.java)");
                    dynamicHoldingDisplay = (DynamicHoldingDisplay) adapter2.fromJson(jSONObject4);
                } else {
                    dynamicHoldingDisplay = null;
                }
                Object obj3 = jSONObject.get(ShareHolding.assetDataKey);
                if (!(obj3 instanceof JSONArray)) {
                    obj3 = null;
                }
                JSONArray jSONArray = (JSONArray) obj3;
                AssetListConverter assetListConverter = new AssetListConverter();
                if (jSONArray != null) {
                    str2 = jSONArray.toString();
                }
                List<Asset> assetList = assetListConverter.toAssetList(str2);
                Intrinsics.checkNotNullExpressionValue(serialize, "jws");
                return new SecureHolding(str, holdingRecordAttributes, serialize, dynamicHoldingDisplay, assetList, null, 32, null);
            }
        }
        return null;
    }

    public final boolean validate(SignedJWT signedJWT, JWKSet jWKSet) {
        Intrinsics.checkNotNullParameter(signedJWT, HoldingExpiryPublisher.HOLDING_KEY);
        Intrinsics.checkNotNullParameter(jWKSet, "set");
        JWSHeader header = signedJWT.getHeader();
        Intrinsics.checkNotNullExpressionValue(header, "holding.header");
        String keyID = header.getKeyID();
        if (keyID != null) {
            return signedJWT.verify(new ECDSAVerifier(getIssuerPublicKey(keyID, jWKSet))) && verifySubjectPublicKey(signedJWT);
        }
        throw new Exception("Kid Field Missing In Jwt HEADER");
    }

    private final ECPublicKey getIssuerPublicKey(String str, JWKSet jWKSet) {
        ECPublicKey eCPublicKey;
        JWK keyByKeyId = jWKSet.getKeyByKeyId(str);
        if (keyByKeyId != null) {
            if (!(keyByKeyId instanceof ECKey)) {
                keyByKeyId = null;
            }
            ECKey eCKey = (ECKey) keyByKeyId;
            if (eCKey != null && (eCPublicKey = eCKey.toECPublicKey()) != null) {
                return eCPublicKey;
            }
            throw new Exception("Unexpected Key Type In Jwk Set");
        }
        throw new Exception("No Signing Keys Match Supplied Kid");
    }

    private final boolean verifySubjectPublicKey(SignedJWT signedJWT) {
        JWK jwk = getJWK(signedJWT);
        ECPublicKey eCPublicKey = null;
        if (!(jwk instanceof ECKey)) {
            jwk = null;
        }
        ECKey eCKey = (ECKey) jwk;
        if (eCKey != null) {
            eCPublicKey = eCKey.toECPublicKey();
        }
        return eCPublicKey instanceof ECPublicKey;
    }

    private final JWK getJWK(SignedJWT signedJWT) {
        Object obj = signedJWT.getPayload().toJSONObject().get("cnf");
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Map map = (Map) obj;
        boolean z = true;
        if (map.size() != 1) {
            z = false;
        }
        if (z) {
            JWK parse = JWK.parse(String.valueOf(map.get("jwk")));
            Intrinsics.checkNotNullExpressionValue(parse, "JWK.parse(cnf[\"jwk\"].toString())");
            return parse;
        }
        throw new IllegalStateException("Incorrect Key Count For Subject Jwk Set".toString());
    }
}
