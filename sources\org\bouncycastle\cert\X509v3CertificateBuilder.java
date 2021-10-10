package org.bouncycastle.cert;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.asn1.x509.V3TBSCertificateGenerator;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509ExtensionsGenerator;
import org.bouncycastle.operator.ContentSigner;

public class X509v3CertificateBuilder {
    private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();
    private V3TBSCertificateGenerator tbsGen;

    public X509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        V3TBSCertificateGenerator v3TBSCertificateGenerator = new V3TBSCertificateGenerator();
        this.tbsGen = v3TBSCertificateGenerator;
        v3TBSCertificateGenerator.setSerialNumber(new DERInteger(bigInteger));
        this.tbsGen.setIssuer(x500Name);
        this.tbsGen.setStartDate(new Time(date));
        this.tbsGen.setEndDate(new Time(date2));
        this.tbsGen.setSubject(x500Name2);
        this.tbsGen.setSubjectPublicKeyInfo(subjectPublicKeyInfo);
    }

    public X509v3CertificateBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        this.extGenerator.addExtension(aSN1ObjectIdentifier, z, aSN1Encodable);
        return this;
    }

    public X509CertificateHolder build(ContentSigner contentSigner) {
        this.tbsGen.setSignature(contentSigner.getAlgorithmIdentifier());
        if (!this.extGenerator.isEmpty()) {
            this.tbsGen.setExtensions(this.extGenerator.generate());
        }
        return CertUtils.generateFullCert(contentSigner, this.tbsGen.generateTBSCertificate());
    }

    public X509v3CertificateBuilder copyAndAddExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, X509CertificateHolder x509CertificateHolder) {
        X509Extension extension = x509CertificateHolder.toASN1Structure().getTBSCertificate().getExtensions().getExtension(aSN1ObjectIdentifier);
        if (extension != null) {
            this.extGenerator.addExtension(aSN1ObjectIdentifier, z, extension.getValue().getOctets());
            return this;
        }
        throw new NullPointerException("extension " + aSN1ObjectIdentifier + " not present");
    }

    public X509v3CertificateBuilder setIssuerUniqueID(boolean[] zArr) {
        this.tbsGen.setIssuerUniqueID(CertUtils.booleanToBitString(zArr));
        return this;
    }

    public X509v3CertificateBuilder setSubjectUniqueID(boolean[] zArr) {
        this.tbsGen.setSubjectUniqueID(CertUtils.booleanToBitString(zArr));
        return this;
    }
}
