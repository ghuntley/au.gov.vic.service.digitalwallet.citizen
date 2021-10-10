package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AttributeCertificate;

public class SignerAttribute extends ASN1Encodable {
    private AttributeCertificate certifiedAttributes;
    private ASN1Sequence claimedAttributes;

    private SignerAttribute(Object obj) {
        DERTaggedObject dERTaggedObject = (DERTaggedObject) ((ASN1Sequence) obj).getObjectAt(0);
        if (dERTaggedObject.getTagNo() == 0) {
            this.claimedAttributes = ASN1Sequence.getInstance(dERTaggedObject, true);
        } else if (dERTaggedObject.getTagNo() == 1) {
            this.certifiedAttributes = AttributeCertificate.getInstance(dERTaggedObject);
        } else {
            throw new IllegalArgumentException("illegal tag.");
        }
    }

    public SignerAttribute(ASN1Sequence aSN1Sequence) {
        this.claimedAttributes = aSN1Sequence;
    }

    public SignerAttribute(AttributeCertificate attributeCertificate) {
        this.certifiedAttributes = attributeCertificate;
    }

    public static SignerAttribute getInstance(Object obj) {
        if (obj == null || (obj instanceof SignerAttribute)) {
            return (SignerAttribute) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SignerAttribute(obj);
        }
        throw new IllegalArgumentException("unknown object in 'SignerAttribute' factory: " + obj.getClass().getName() + ".");
    }

    public AttributeCertificate getCertifiedAttributes() {
        return this.certifiedAttributes;
    }

    public ASN1Sequence getClaimedAttributes() {
        return this.claimedAttributes;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.claimedAttributes != null ? new DERTaggedObject(0, this.claimedAttributes) : new DERTaggedObject(1, this.certifiedAttributes));
        return new DERSequence(aSN1EncodableVector);
    }
}
