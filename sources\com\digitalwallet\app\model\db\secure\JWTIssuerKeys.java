package com.digitalwallet.app.model.db.secure;

import com.nimbusds.jose.jwk.JWKSet;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeys;", "", "id", "", "issuerKeys", "Lcom/nimbusds/jose/jwk/JWKSet;", "(ILcom/nimbusds/jose/jwk/JWKSet;)V", "getId", "()I", "getIssuerKeys", "()Lcom/nimbusds/jose/jwk/JWKSet;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: JWTIssuerKeys.kt */
public final class JWTIssuerKeys {
    private final int id;
    private final JWKSet issuerKeys;

    public JWTIssuerKeys(int i, JWKSet jWKSet) {
        this.id = i;
        this.issuerKeys = jWKSet;
    }

    public final int getId() {
        return this.id;
    }

    public final JWKSet getIssuerKeys() {
        return this.issuerKeys;
    }
}
