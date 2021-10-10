package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.X509CertificateStructure;

public class CMPCertificate extends ASN1Encodable implements ASN1Choice {
    private AttributeCertificate x509v2AttrCert;
    private X509CertificateStructure x509v3PKCert;

    public CMPCertificate(AttributeCertificate attributeCertificate) {
        this.x509v2AttrCert = attributeCertificate;
    }

    public CMPCertificate(X509CertificateStructure x509CertificateStructure) {
        if (x509CertificateStructure.getVersion() == 3) {
            this.x509v3PKCert = x509CertificateStructure;
            return;
        }
        throw new IllegalArgumentException("only version 3 certificates allowed");
    }

    public static CMPCertificate getInstance(Object obj) {
        if (obj instanceof CMPCertificate) {
            return (CMPCertificate) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CMPCertificate(X509CertificateStructure.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CMPCertificate(AttributeCertificate.getInstance(((ASN1TaggedObject) obj).getObject()));
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public AttributeCertificate getX509v2AttrCert() {
        return this.x509v2AttrCert;
    }

    public X509CertificateStructure getX509v3PKCert() {
        return this.x509v3PKCert;
    }

    public boolean isX509v3PKCert() {
        return this.x509v3PKCert != null;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.x509v2AttrCert != null ? new DERTaggedObject(true, 1, this.x509v2AttrCert) : this.x509v3PKCert.toASN1Object();
    }
}
