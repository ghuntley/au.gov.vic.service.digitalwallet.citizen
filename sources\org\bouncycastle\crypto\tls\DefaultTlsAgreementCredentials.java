package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class DefaultTlsAgreementCredentials implements TlsAgreementCredentials {
    protected BasicAgreement basicAgreement;
    protected Certificate clientCert;
    protected AsymmetricKeyParameter clientPrivateKey;

    public DefaultTlsAgreementCredentials(Certificate certificate, AsymmetricKeyParameter asymmetricKeyParameter) {
        BasicAgreement eCDHBasicAgreement;
        if (certificate == null) {
            throw new IllegalArgumentException("'clientCertificate' cannot be null");
        } else if (certificate.certs.length == 0) {
            throw new IllegalArgumentException("'clientCertificate' cannot be empty");
        } else if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("'clientPrivateKey' cannot be null");
        } else if (asymmetricKeyParameter.isPrivate()) {
            if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
                eCDHBasicAgreement = new DHBasicAgreement();
            } else if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
                eCDHBasicAgreement = new ECDHBasicAgreement();
            } else {
                throw new IllegalArgumentException("'clientPrivateKey' type not supported: " + asymmetricKeyParameter.getClass().getName());
            }
            this.basicAgreement = eCDHBasicAgreement;
            this.clientCert = certificate;
            this.clientPrivateKey = asymmetricKeyParameter;
        } else {
            throw new IllegalArgumentException("'clientPrivateKey' must be private");
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsAgreementCredentials
    public byte[] generateAgreement(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.basicAgreement.init(this.clientPrivateKey);
        return BigIntegers.asUnsignedByteArray(this.basicAgreement.calculateAgreement(asymmetricKeyParameter));
    }

    @Override // org.bouncycastle.crypto.tls.TlsCredentials
    public Certificate getCertificate() {
        return this.clientCert;
    }
}
