package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class PKIPublicationInfo extends ASN1Encodable {
    private DERInteger action;
    private ASN1Sequence pubInfos;

    private PKIPublicationInfo(ASN1Sequence aSN1Sequence) {
        this.action = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.pubInfos = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static PKIPublicationInfo getInstance(Object obj) {
        if (obj instanceof PKIPublicationInfo) {
            return (PKIPublicationInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PKIPublicationInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public DERInteger getAction() {
        return this.action;
    }

    public SinglePubInfo[] getPubInfos() {
        ASN1Sequence aSN1Sequence = this.pubInfos;
        if (aSN1Sequence == null) {
            return null;
        }
        int size = aSN1Sequence.size();
        SinglePubInfo[] singlePubInfoArr = new SinglePubInfo[size];
        for (int i = 0; i != size; i++) {
            singlePubInfoArr[i] = SinglePubInfo.getInstance(this.pubInfos.getObjectAt(i));
        }
        return singlePubInfoArr;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.action);
        aSN1EncodableVector.add(this.pubInfos);
        return new DERSequence(aSN1EncodableVector);
    }
}
