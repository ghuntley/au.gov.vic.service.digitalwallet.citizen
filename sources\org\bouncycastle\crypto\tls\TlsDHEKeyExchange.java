package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.io.SignerInputStream;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;

class TlsDHEKeyExchange extends TlsDHKeyExchange {
    TlsDHEKeyExchange(TlsClientContext tlsClientContext, int i) {
        super(tlsClientContext, i);
    }

    /* access modifiers changed from: protected */
    public Signer initSigner(TlsSigner tlsSigner, SecurityParameters securityParameters) {
        Signer createVerifyer = tlsSigner.createVerifyer(this.serverPublicKey);
        createVerifyer.update(securityParameters.clientRandom, 0, securityParameters.clientRandom.length);
        createVerifyer.update(securityParameters.serverRandom, 0, securityParameters.serverRandom.length);
        return createVerifyer;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange, org.bouncycastle.crypto.tls.TlsDHKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        Signer initSigner = initSigner(this.tlsSigner, this.context.getSecurityParameters());
        SignerInputStream signerInputStream = new SignerInputStream(inputStream, initSigner);
        byte[] readOpaque16 = TlsUtils.readOpaque16(signerInputStream);
        byte[] readOpaque162 = TlsUtils.readOpaque16(signerInputStream);
        byte[] readOpaque163 = TlsUtils.readOpaque16(signerInputStream);
        if (initSigner.verifySignature(TlsUtils.readOpaque16(inputStream))) {
            this.dhAgreeServerPublicKey = validateDHPublicKey(new DHPublicKeyParameters(new BigInteger(1, readOpaque163), new DHParameters(new BigInteger(1, readOpaque16), new BigInteger(1, readOpaque162))));
            return;
        }
        throw new TlsFatalAlert(42);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange, org.bouncycastle.crypto.tls.TlsDHKeyExchange
    public void skipServerKeyExchange() throws IOException {
        throw new TlsFatalAlert(10);
    }
}
