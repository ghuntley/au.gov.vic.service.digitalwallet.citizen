package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;

public class V2AttributeCertificateInfoGenerator {
    private ASN1EncodableVector attributes = new ASN1EncodableVector();
    private DERGeneralizedTime endDate;
    private X509Extensions extensions;
    private Holder holder;
    private AttCertIssuer issuer;
    private DERBitString issuerUniqueID;
    private DERInteger serialNumber;
    private AlgorithmIdentifier signature;
    private DERGeneralizedTime startDate;
    private DERInteger version = new DERInteger(1);

    public void addAttribute(String str, ASN1Encodable aSN1Encodable) {
        this.attributes.add(new Attribute(new DERObjectIdentifier(str), new DERSet(aSN1Encodable)));
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }

    public AttributeCertificateInfo generateAttributeCertificateInfo() {
        if (this.serialNumber == null || this.signature == null || this.issuer == null || this.startDate == null || this.endDate == null || this.holder == null || this.attributes == null) {
            throw new IllegalStateException("not all mandatory fields set in V2 AttributeCertificateInfo generator");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.holder);
        aSN1EncodableVector.add(this.issuer);
        aSN1EncodableVector.add(this.signature);
        aSN1EncodableVector.add(this.serialNumber);
        aSN1EncodableVector.add(new AttCertValidityPeriod(this.startDate, this.endDate));
        aSN1EncodableVector.add(new DERSequence(this.attributes));
        DERBitString dERBitString = this.issuerUniqueID;
        if (dERBitString != null) {
            aSN1EncodableVector.add(dERBitString);
        }
        X509Extensions x509Extensions = this.extensions;
        if (x509Extensions != null) {
            aSN1EncodableVector.add(x509Extensions);
        }
        return new AttributeCertificateInfo(new DERSequence(aSN1EncodableVector));
    }

    public void setEndDate(DERGeneralizedTime dERGeneralizedTime) {
        this.endDate = dERGeneralizedTime;
    }

    public void setExtensions(X509Extensions x509Extensions) {
        this.extensions = x509Extensions;
    }

    public void setHolder(Holder holder2) {
        this.holder = holder2;
    }

    public void setIssuer(AttCertIssuer attCertIssuer) {
        this.issuer = attCertIssuer;
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

    public void setStartDate(DERGeneralizedTime dERGeneralizedTime) {
        this.startDate = dERGeneralizedTime;
    }
}
