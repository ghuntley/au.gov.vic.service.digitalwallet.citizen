package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.KeyType;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import java.net.URL;
import java.security.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JWSAlgorithmFamilyJWSKeySelector<C extends SecurityContext> extends AbstractJWKSelectorWithSource<C> implements JWSKeySelector<C> {
    private final Map<JWSAlgorithm, JWSKeySelector<C>> selectors = new HashMap();

    @Override // com.nimbusds.jose.proc.AbstractJWKSelectorWithSource
    public /* bridge */ /* synthetic */ JWKSource getJWKSource() {
        return super.getJWKSource();
    }

    public JWSAlgorithmFamilyJWSKeySelector(JWSAlgorithm.Family family, JWKSource<C> jWKSource) {
        super(jWKSource);
        if (family != null) {
            Iterator it = family.iterator();
            while (it.hasNext()) {
                JWSAlgorithm jWSAlgorithm = (JWSAlgorithm) it.next();
                this.selectors.put(jWSAlgorithm, new JWSVerificationKeySelector(jWSAlgorithm, jWKSource));
            }
            return;
        }
        throw new IllegalArgumentException("JWS algorithm family must not be null");
    }

    @Override // com.nimbusds.jose.proc.JWSKeySelector
    public List<? extends Key> selectJWSKeys(JWSHeader jWSHeader, C c) throws KeySourceException {
        JWSKeySelector<C> jWSKeySelector = this.selectors.get(jWSHeader.getAlgorithm());
        if (jWSKeySelector == null) {
            return Collections.emptyList();
        }
        return jWSKeySelector.selectJWSKeys(jWSHeader, c);
    }

    public static <C extends SecurityContext> JWSAlgorithmFamilyJWSKeySelector<C> fromJWKSetURL(URL url) throws KeySourceException {
        return fromJWKSource(new RemoteJWKSet(url));
    }

    public static <C extends SecurityContext> JWSAlgorithmFamilyJWSKeySelector<C> fromJWKSource(JWKSource<C> jWKSource) throws KeySourceException {
        for (JWK jwk : jWKSource.get(new JWKSelector(new JWKMatcher.Builder().publicOnly(true).keyUses(KeyUse.SIGNATURE, null).keyTypes(KeyType.RSA, KeyType.EC).build()), null)) {
            if (KeyType.RSA.equals(jwk.getKeyType())) {
                return new JWSAlgorithmFamilyJWSKeySelector<>(JWSAlgorithm.Family.RSA, jWKSource);
            }
            if (KeyType.EC.equals(jwk.getKeyType())) {
                return new JWSAlgorithmFamilyJWSKeySelector<>(JWSAlgorithm.Family.EC, jWKSource);
            }
        }
        throw new KeySourceException("Couldn't retrieve JWKs");
    }
}
