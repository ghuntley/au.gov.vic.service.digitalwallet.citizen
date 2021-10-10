package org.bouncycastle.asn1.tsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.cms.ContentInfo;

public class TimeStampResp extends ASN1Encodable {
    PKIStatusInfo pkiStatusInfo;
    ContentInfo timeStampToken;

    public TimeStampResp(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.pkiStatusInfo = PKIStatusInfo.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.timeStampToken = ContentInfo.getInstance(objects.nextElement());
        }
    }

    public TimeStampResp(PKIStatusInfo pKIStatusInfo, ContentInfo contentInfo) {
        this.pkiStatusInfo = pKIStatusInfo;
        this.timeStampToken = contentInfo;
    }

    public static TimeStampResp getInstance(Object obj) {
        if (obj == null || (obj instanceof TimeStampResp)) {
            return (TimeStampResp) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new TimeStampResp((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in 'TimeStampResp' factory : " + obj.getClass().getName() + ".");
    }

    public PKIStatusInfo getStatus() {
        return this.pkiStatusInfo;
    }

    public ContentInfo getTimeStampToken() {
        return this.timeStampToken;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.pkiStatusInfo);
        ContentInfo contentInfo = this.timeStampToken;
        if (contentInfo != null) {
            aSN1EncodableVector.add(contentInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
