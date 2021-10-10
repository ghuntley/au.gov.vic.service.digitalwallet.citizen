package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class SigPolicyQualifiers extends ASN1Encodable {
    ASN1Sequence qualifiers;

    public SigPolicyQualifiers(ASN1Sequence aSN1Sequence) {
        this.qualifiers = aSN1Sequence;
    }

    public SigPolicyQualifiers(SigPolicyQualifierInfo[] sigPolicyQualifierInfoArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (SigPolicyQualifierInfo sigPolicyQualifierInfo : sigPolicyQualifierInfoArr) {
            aSN1EncodableVector.add(sigPolicyQualifierInfo);
        }
        this.qualifiers = new DERSequence(aSN1EncodableVector);
    }

    public static SigPolicyQualifiers getInstance(Object obj) {
        if (obj instanceof SigPolicyQualifiers) {
            return (SigPolicyQualifiers) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SigPolicyQualifiers((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in 'SigPolicyQualifiers' factory: " + obj.getClass().getName() + ".");
    }

    public SigPolicyQualifierInfo getStringAt(int i) {
        return SigPolicyQualifierInfo.getInstance(this.qualifiers.getObjectAt(i));
    }

    public int size() {
        return this.qualifiers.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.qualifiers;
    }
}
