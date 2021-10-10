package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class DefaultTlsSignerCredentials implements TlsSignerCredentials {
    protected Certificate clientCert;
    protected AsymmetricKeyParameter clientPrivateKey;
    protected TlsSigner clientSigner;
    protected TlsClientContext context;

    public DefaultTlsSignerCredentials(TlsClientContext tlsClientContext, Certificate certificate, AsymmetricKeyParameter asymmetricKeyParameter) {
        TlsSigner tlsECDSASigner;
        if (certificate == null) {
            throw new IllegalArgumentException("'clientCertificate' cannot be null");
        } else if (certificate.certs.length == 0) {
            throw new IllegalArgumentException("'clientCertificate' cannot be empty");
        } else if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("'clientPrivateKey' cannot be null");
        } else if (asymmetricKeyParameter.isPrivate()) {
            if (asymmetricKeyParameter instanceof RSAKeyParameters) {
                tlsECDSASigner = new TlsRSASigner();
            } else if (asymmetricKeyParameter instanceof DSAPrivateKeyParameters) {
                tlsECDSASigner = new TlsDSSSigner();
            } else if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
                tlsECDSASigner = new TlsECDSASigner();
            } else {
                throw new IllegalArgumentException("'clientPrivateKey' type not supported: " + asymmetricKeyParameter.getClass().getName());
            }
            this.clientSigner = tlsECDSASigner;
            this.context = tlsClientContext;
            this.clientCert = certificate;
            this.clientPrivateKey = asymmetricKeyParameter;
        } else {
            throw new IllegalArgumentException("'clientPrivateKey' must be private");
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsSignerCredentials
    public byte[] generateCertificateSignature(byte[] bArr) throws IOException {
        try {
            return this.clientSigner.calculateRawSignature(this.context.getSecureRandom(), this.clientPrivateKey, bArr);
        } catch (CryptoException unused) {
            throw new TlsFatalAlert(80);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsCredentials
    public Certificate getCertificate() {
        return this.clientCert;
    }
}
