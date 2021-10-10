package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509Name;

public class IssuerAndSerialNumber extends ASN1Encodable {
    private X500Name name;
    private DERInteger serialNumber;

    public IssuerAndSerialNumber(ASN1Sequence aSN1Sequence) {
        this.name = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.serialNumber = (DERInteger) aSN1Sequence.getObjectAt(1);
    }

    public IssuerAndSerialNumber(X500Name x500Name, BigInteger bigInteger) {
        this.name = x500Name;
        this.serialNumber = new DERInteger(bigInteger);
    }

    public IssuerAndSerialNumber(X509Name x509Name, BigInteger bigInteger) {
        this.name = X500Name.getInstance(x509Name);
        this.serialNumber = new DERInteger(bigInteger);
    }

    public IssuerAndSerialNumber(X509Name x509Name, DERInteger dERInteger) {
        this.name = X500Name.getInstance(x509Name);
        this.serialNumber = dERInteger;
    }

    public static IssuerAndSerialNumber getInstance(Object obj) {
        if (obj instanceof IssuerAndSerialNumber) {
            return (IssuerAndSerialNumber) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new IssuerAndSerialNumber((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Illegal object in IssuerAndSerialNumber: " + obj.getClass().getName());
    }

    public X500Name getName() {
        return this.name;
    }

    public DERInteger getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.name);
        aSN1EncodableVector.add(this.serialNumber);
        return new DERSequence(aSN1EncodableVector);
    }
}
