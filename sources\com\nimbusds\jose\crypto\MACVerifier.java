package com.nimbusds.jose.crypto;

import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.HMAC;
import com.nimbusds.jose.crypto.impl.MACProvider;
import com.nimbusds.jose.crypto.utils.ConstantTimeUtils;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class MACVerifier extends MACProvider implements JWSVerifier, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy;

    public MACVerifier(byte[] bArr) throws JOSEException {
        this(bArr, (Set<String>) null);
    }

    public MACVerifier(String str) throws JOSEException {
        this(str.getBytes(StandardCharset.UTF_8));
    }

    public MACVerifier(SecretKey secretKey) throws JOSEException {
        this(secretKey.getEncoded());
    }

    public MACVerifier(OctetSequenceKey octetSequenceKey) throws JOSEException {
        this(octetSequenceKey.toByteArray());
    }

    public MACVerifier(OctetSequenceKey octetSequenceKey, Set<String> set) throws JOSEException {
        this(octetSequenceKey.toByteArray(), set);
    }

    public MACVerifier(byte[] bArr, Set<String> set) throws JOSEException {
        super(bArr, SUPPORTED_ALGORITHMS);
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getProcessedCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getDeferredCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.JWSVerifier
    public boolean verify(JWSHeader jWSHeader, byte[] bArr, Base64URL base64URL) throws JOSEException {
        if (!this.critPolicy.headerPasses(jWSHeader)) {
            return false;
        }
        return ConstantTimeUtils.areEqual(HMAC.compute(getJCAAlgorithmName(jWSHeader.getAlgorithm()), getSecret(), bArr, getJCAContext().getProvider()), base64URL.decode());
    }
}
