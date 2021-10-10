package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTCTime;
import org.bouncycastle.asn1.x500.X500Name;

public class V3TBSCertificateGenerator {
    private boolean altNamePresentAndCritical;
    Time endDate;
    X509Extensions extensions;
    X509Name issuer;
    private DERBitString issuerUniqueID;
    DERInteger serialNumber;
    AlgorithmIdentifier signature;
    Time startDate;
    X509Name subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    private DERBitString subjectUniqueID;
    DERTaggedObject version = new DERTaggedObject(0, new DERInteger(2));

    public TBSCertificateStructure generateTBSCertificate() {
        if (this.serialNumber == null || this.signature == null || this.issuer == null || this.startDate == null || this.endDate == null || ((this.subject == null && !this.altNamePresentAndCritical) || this.subjectPublicKeyInfo == null)) {
            throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.serialNumber);
        aSN1EncodableVector.add(this.signature);
        aSN1EncodableVector.add(this.issuer);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(this.startDate);
        aSN1EncodableVector2.add(this.endDate);
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        DEREncodable dEREncodable = this.subject;
        if (dEREncodable == null) {
            dEREncodable = new DERSequence();
        }
        aSN1EncodableVector.add(dEREncodable);
        aSN1EncodableVector.add(this.subjectPublicKeyInfo);
        if (this.issuerUniqueID != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.issuerUniqueID));
        }
        if (this.subjectUniqueID != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, this.subjectUniqueID));
        }
        if (this.extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(3, this.extensions));
        }
        return new TBSCertificateStructure(new DERSequence(aSN1EncodableVector));
    }

    public void setEndDate(DERUTCTime dERUTCTime) {
        this.endDate = new Time(dERUTCTime);
    }

    public void setEndDate(Time time) {
        this.endDate = time;
    }

    public void setExtensions(X509Extensions x509Extensions) {
        X509Extension extension;
        this.extensions = x509Extensions;
        if (x509Extensions != null && (extension = x509Extensions.getExtension(X509Extensions.SubjectAlternativeName)) != null && extension.isCritical()) {
            this.altNamePresentAndCritical = true;
        }
    }

    public void setIssuer(X500Name x500Name) {
        this.issuer = X509Name.getInstance(x500Name.getDERObject());
    }

    public void setIssuer(X509Name x509Name) {
        this.issuer = x509Name;
    }

    public void setIssuerUniqueID(DERBitString dERBitString) {
        this.issuerUniqueID = dERBitString;
    }

    public void setSerialNumber(DERInteger dERInteger) {
        this.serialNumber = dERInteger;
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.signature = algorithmIdentifier;
    }

    public void setStartDate(DERUTCTime dERUTCTime) {
        this.startDate = new Time(dERUTCTime);
    }

    public void setStartDate(Time time) {
        this.startDate = time;
    }

    public void setSubject(X500Name x500Name) {
        this.subject = X509Name.getInstance(x500Name.getDERObject());
    }

    public void setSubject(X509Name x509Name) {
        this.subject = x509Name;
    }

    public void setSubjectPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo2) {
        this.subjectPublicKeyInfo = subjectPublicKeyInfo2;
    }

    public void setSubjectUniqueID(DERBitString dERBitString) {
        this.subjectUniqueID = dERBitString;
    }
}
