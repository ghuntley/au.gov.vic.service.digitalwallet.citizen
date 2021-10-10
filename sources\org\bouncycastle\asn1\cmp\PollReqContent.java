package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;

public class PollReqContent extends ASN1Encodable {
    private ASN1Sequence content;

    private PollReqContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static PollReqContent getInstance(Object obj) {
        if (obj instanceof PollReqContent) {
            return (PollReqContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PollReqContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    private DERInteger[] seqenceToDERIntegerArray(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        DERInteger[] dERIntegerArr = new DERInteger[size];
        for (int i = 0; i != size; i++) {
            dERIntegerArr[i] = DERInteger.getInstance(aSN1Sequence.getObjectAt(i));
        }
        return dERIntegerArr;
    }

    public DERInteger[][] getCertReqIds() {
        int size = this.content.size();
        DERInteger[][] dERIntegerArr = new DERInteger[size][];
        for (int i = 0; i != size; i++) {
            dERIntegerArr[i] = seqenceToDERIntegerArray((ASN1Sequence) this.content.getObjectAt(i));
        }
        return dERIntegerArr;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.content;
    }
}
