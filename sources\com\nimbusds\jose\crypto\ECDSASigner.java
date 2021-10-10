package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.ECDSA;
import com.nimbusds.jose.crypto.impl.ECDSAProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.util.Base64URL;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPrivateKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class ECDSASigner extends ECDSAProvider implements JWSSigner {
    private final PrivateKey privateKey;

    public ECDSASigner(ECPrivateKey eCPrivateKey) throws JOSEException {
        super(ECDSA.resolveAlgorithm(eCPrivateKey));
        this.privateKey = eCPrivateKey;
    }

    public ECDSASigner(PrivateKey privateKey2, Curve curve) throws JOSEException {
        super(ECDSA.resolveAlgorithm(curve));
        if ("EC".equalsIgnoreCase(privateKey2.getAlgorithm())) {
            this.privateKey = privateKey2;
            return;
        }
        throw new IllegalArgumentException("The private key algorithm must be EC");
    }

    public ECDSASigner(ECKey eCKey) throws JOSEException {
        super(ECDSA.resolveAlgorithm(eCKey.getCurve()));
        if (eCKey.isPrivate()) {
            this.privateKey = eCKey.toPrivateKey();
            return;
        }
        throw new JOSEException("The EC JWK doesn't contain a private part");
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    @Override // com.nimbusds.jose.JWSSigner
    public Base64URL sign(JWSHeader jWSHeader, byte[] bArr) throws JOSEException {
        JWSAlgorithm algorithm = jWSHeader.getAlgorithm();
        if (supportedJWSAlgorithms().contains(algorithm)) {
            try {
                Signature signerAndVerifier = ECDSA.getSignerAndVerifier(algorithm, getJCAContext().getProvider());
                signerAndVerifier.initSign(this.privateKey, getJCAContext().getSecureRandom());
                signerAndVerifier.update(bArr);
                return Base64URL.encode(ECDSA.transcodeSignatureToConcat(signerAndVerifier.sign(), ECDSA.getSignatureByteArrayLength(jWSHeader.getAlgorithm())));
            } catch (InvalidKeyException | SignatureException e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } else {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWSAlgorithm(algorithm, supportedJWSAlgorithms()));
        }
    }
}
