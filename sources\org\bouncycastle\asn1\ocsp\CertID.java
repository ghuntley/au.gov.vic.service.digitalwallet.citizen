package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertID extends ASN1Encodable {
    AlgorithmIdentifier hashAlgorithm;
    ASN1OctetString issuerKeyHash;
    ASN1OctetString issuerNameHash;
    DERInteger serialNumber;

    public CertID(ASN1Sequence aSN1Sequence) {
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.issuerNameHash = (ASN1OctetString) aSN1Sequence.getObjectAt(1);
        this.issuerKeyHash = (ASN1OctetString) aSN1Sequence.getObjectAt(2);
        this.serialNumber = (DERInteger) aSN1Sequence.getObjectAt(3);
    }

    public CertID(AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, DERInteger dERInteger) {
        this.hashAlgorithm = algorithmIdentifier;
        this.issuerNameHash = aSN1OctetString;
        this.issuerKeyHash = aSN1OctetString2;
        this.serialNumber = dERInteger;
    }

    public static CertID getInstance(Object obj) {
        if (obj == null || (obj instanceof CertID)) {
            return (CertID) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertID((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static CertID getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public ASN1OctetString getIssuerKeyHash() {
        return this.issuerKeyHash;
    }

    public ASN1OctetString getIssuerNameHash() {
        return this.issuerNameHash;
    }

    public DERInteger getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.hashAlgorithm);
        aSN1EncodableVector.add(this.issuerNameHash);
        aSN1EncodableVector.add(this.issuerKeyHash);
        aSN1EncodableVector.add(this.serialNumber);
        return new DERSequence(aSN1EncodableVector);
    }
}
