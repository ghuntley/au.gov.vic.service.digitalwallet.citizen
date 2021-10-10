package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class PollRepContent extends ASN1Encodable {
    private DERInteger certReqId;
    private DERInteger checkAfter;
    private PKIFreeText reason;

    private PollRepContent(ASN1Sequence aSN1Sequence) {
        this.certReqId = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.checkAfter = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.reason = PKIFreeText.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public static PollRepContent getInstance(Object obj) {
        if (obj instanceof PollRepContent) {
            return (PollRepContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PollRepContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public DERInteger getCertReqId() {
        return this.certReqId;
    }

    public DERInteger getCheckAfter() {
        return this.checkAfter;
    }

    public PKIFreeText getReason() {
        return this.reason;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certReqId);
        aSN1EncodableVector.add(this.checkAfter);
        PKIFreeText pKIFreeText = this.reason;
        if (pKIFreeText != null) {
            aSN1EncodableVector.add(pKIFreeText);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
