package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class PolicyQualifierInfo extends ASN1Encodable {
    private DERObjectIdentifier policyQualifierId;
    private DEREncodable qualifier;

    public PolicyQualifierInfo(String str) {
        this.policyQualifierId = PolicyQualifierId.id_qt_cps;
        this.qualifier = new DERIA5String(str);
    }

    public PolicyQualifierInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.policyQualifierId = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.qualifier = aSN1Sequence.getObjectAt(1);
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public PolicyQualifierInfo(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.policyQualifierId = dERObjectIdentifier;
        this.qualifier = dEREncodable;
    }

    public static PolicyQualifierInfo getInstance(Object obj) {
        if (obj instanceof PolicyQualifierInfo) {
            return (PolicyQualifierInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PolicyQualifierInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in getInstance.");
    }

    public DERObjectIdentifier getPolicyQualifierId() {
        return this.policyQualifierId;
    }

    public DEREncodable getQualifier() {
        return this.qualifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.policyQualifierId);
        aSN1EncodableVector.add(this.qualifier);
        return new DERSequence(aSN1EncodableVector);
    }
}
