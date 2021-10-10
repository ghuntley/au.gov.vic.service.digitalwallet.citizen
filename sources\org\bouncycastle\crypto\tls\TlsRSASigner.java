package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.GenericSigner;

class TlsRSASigner implements TlsSigner {
    TlsRSASigner() {
    }

    @Override // org.bouncycastle.crypto.tls.TlsSigner
    public byte[] calculateRawSignature(SecureRandom secureRandom, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) throws CryptoException {
        GenericSigner genericSigner = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new NullDigest());
        genericSigner.init(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        genericSigner.update(bArr, 0, bArr.length);
        return genericSigner.generateSignature();
    }

    @Override // org.bouncycastle.crypto.tls.TlsSigner
    public Signer createVerifyer(AsymmetricKeyParameter asymmetricKeyParameter) {
        GenericSigner genericSigner = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new CombinedHash());
        genericSigner.init(false, asymmetricKeyParameter);
        return genericSigner;
    }

    @Override // org.bouncycastle.crypto.tls.TlsSigner
    public boolean isValidPublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        return (asymmetricKeyParameter instanceof RSAKeyParameters) && !asymmetricKeyParameter.isPrivate();
    }
}
