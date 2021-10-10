package org.bouncycastle.cms.bc;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.KeyTransRecipientInfoGenerator;
import org.bouncycastle.operator.bc.BcAsymmetricKeyWrapper;

public abstract class BcKeyTransRecipientInfoGenerator extends KeyTransRecipientInfoGenerator {
    public BcKeyTransRecipientInfoGenerator(X509CertificateHolder x509CertificateHolder, BcAsymmetricKeyWrapper bcAsymmetricKeyWrapper) {
        super(x509CertificateHolder.getIssuerAndSerialNumber(), bcAsymmetricKeyWrapper);
    }

    public BcKeyTransRecipientInfoGenerator(byte[] bArr, BcAsymmetricKeyWrapper bcAsymmetricKeyWrapper) {
        super(bArr, bcAsymmetricKeyWrapper);
    }
}
