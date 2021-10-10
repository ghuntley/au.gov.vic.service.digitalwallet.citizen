package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.KeyConverter;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.Key;
import java.security.PublicKey;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class JWSVerificationKeySelector<C extends SecurityContext> extends AbstractJWKSelectorWithSource<C> implements JWSKeySelector<C> {
    private final JWSAlgorithm jwsAlg;

    @Override // com.nimbusds.jose.proc.AbstractJWKSelectorWithSource
    public /* bridge */ /* synthetic */ JWKSource getJWKSource() {
        return super.getJWKSource();
    }

    public JWSVerificationKeySelector(JWSAlgorithm jWSAlgorithm, JWKSource<C> jWKSource) {
        super(jWKSource);
        if (jWSAlgorithm != null) {
            this.jwsAlg = jWSAlgorithm;
            return;
        }
        throw new IllegalArgumentException("The JWS algorithm must not be null");
    }

    public JWSAlgorithm getExpectedJWSAlgorithm() {
        return this.jwsAlg;
    }

    /* access modifiers changed from: protected */
    public JWKMatcher createJWKMatcher(JWSHeader jWSHeader) {
        if (!getExpectedJWSAlgorithm().equals(jWSHeader.getAlgorithm())) {
            return null;
        }
        return JWKMatcher.forJWSHeader(jWSHeader);
    }

    @Override // com.nimbusds.jose.proc.JWSKeySelector
    public List<Key> selectJWSKeys(JWSHeader jWSHeader, C c) throws KeySourceException {
        if (!this.jwsAlg.equals(jWSHeader.getAlgorithm())) {
            return Collections.emptyList();
        }
        JWKMatcher createJWKMatcher = createJWKMatcher(jWSHeader);
        if (createJWKMatcher == null) {
            return Collections.emptyList();
        }
        List<JWK> list = getJWKSource().get(new JWKSelector(createJWKMatcher), c);
        LinkedList linkedList = new LinkedList();
        for (Key key : KeyConverter.toJavaKeys(list)) {
            if ((key instanceof PublicKey) || (key instanceof SecretKey)) {
                linkedList.add(key);
            }
        }
        return linkedList;
    }
}
