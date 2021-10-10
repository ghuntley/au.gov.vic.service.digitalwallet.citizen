package org.bouncycastle.crypto.tls;

import java.io.IOException;

public class LegacyTlsAuthentication implements TlsAuthentication {
    protected CertificateVerifyer verifyer;

    public LegacyTlsAuthentication(CertificateVerifyer certificateVerifyer) {
        this.verifyer = certificateVerifyer;
    }

    @Override // org.bouncycastle.crypto.tls.TlsAuthentication
    public TlsCredentials getClientCredentials(CertificateRequest certificateRequest) throws IOException {
        return null;
    }

    @Override // org.bouncycastle.crypto.tls.TlsAuthentication
    public void notifyServerCertificate(Certificate certificate) throws IOException {
        if (!this.verifyer.isValid(certificate.getCerts())) {
            throw new TlsFatalAlert(90);
        }
    }
}
