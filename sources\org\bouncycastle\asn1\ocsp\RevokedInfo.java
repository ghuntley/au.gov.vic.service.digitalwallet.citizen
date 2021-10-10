package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.CRLReason;

public class RevokedInfo extends ASN1Encodable {
    private CRLReason revocationReason;
    private DERGeneralizedTime revocationTime;

    public RevokedInfo(ASN1Sequence aSN1Sequence) {
        this.revocationTime = (DERGeneralizedTime) aSN1Sequence.getObjectAt(0);
        if (aSN1Sequence.size() > 1) {
            this.revocationReason = new CRLReason(DEREnumerated.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true));
        }
    }

    public RevokedInfo(DERGeneralizedTime dERGeneralizedTime, CRLReason cRLReason) {
        this.revocationTime = dERGeneralizedTime;
        this.revocationReason = cRLReason;
    }

    public static RevokedInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof RevokedInfo)) {
            return (RevokedInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RevokedInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static RevokedInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public CRLReason getRevocationReason() {
        return this.revocationReason;
    }

    public DERGeneralizedTime getRevocationTime() {
        return this.revocationTime;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.revocationTime);
        if (this.revocationReason != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.revocationReason));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
