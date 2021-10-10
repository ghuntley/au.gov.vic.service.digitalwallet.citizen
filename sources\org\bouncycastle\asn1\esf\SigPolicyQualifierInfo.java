package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class SigPolicyQualifierInfo extends ASN1Encodable {
    private DERObjectIdentifier sigPolicyQualifierId;
    private DEREncodable sigQualifier;

    public SigPolicyQualifierInfo(ASN1Sequence aSN1Sequence) {
        this.sigPolicyQualifierId = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.sigQualifier = aSN1Sequence.getObjectAt(1);
    }

    public SigPolicyQualifierInfo(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.sigPolicyQualifierId = dERObjectIdentifier;
        this.sigQualifier = dEREncodable;
    }

    public static SigPolicyQualifierInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof SigPolicyQualifierInfo)) {
            return (SigPolicyQualifierInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SigPolicyQualifierInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in 'SigPolicyQualifierInfo' factory: " + obj.getClass().getName() + ".");
    }

    public ASN1ObjectIdentifier getSigPolicyQualifierId() {
        return new ASN1ObjectIdentifier(this.sigPolicyQualifierId.getId());
    }

    public DEREncodable getSigQualifier() {
        return this.sigQualifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.sigPolicyQualifierId);
        aSN1EncodableVector.add(this.sigQualifier);
        return new DERSequence(aSN1EncodableVector);
    }
}
