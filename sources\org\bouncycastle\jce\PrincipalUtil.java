package org.bouncycastle.jce;

import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.TBSCertificateStructure;

public class PrincipalUtil {
    public static X509Principal getIssuerX509Principal(X509CRL x509crl) throws CRLException {
        try {
            return new X509Principal(TBSCertList.getInstance(ASN1Object.fromByteArray(x509crl.getTBSCertList())).getIssuer());
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public static X509Principal getIssuerX509Principal(X509Certificate x509Certificate) throws CertificateEncodingException {
        try {
            return new X509Principal(TBSCertificateStructure.getInstance(ASN1Object.fromByteArray(x509Certificate.getTBSCertificate())).getIssuer());
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public static X509Principal getSubjectX509Principal(X509Certificate x509Certificate) throws CertificateEncodingException {
        try {
            return new X509Principal(TBSCertificateStructure.getInstance(ASN1Object.fromByteArray(x509Certificate.getTBSCertificate())).getSubject());
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }
}
