package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class NoticeReference extends ASN1Encodable {
    private ASN1Sequence noticeNumbers;
    private DisplayText organization;

    public NoticeReference(int i, String str, ASN1Sequence aSN1Sequence) {
        this.organization = new DisplayText(i, str);
        this.noticeNumbers = aSN1Sequence;
    }

    public NoticeReference(String str, Vector vector) {
        this.organization = new DisplayText(str);
        Object elementAt = vector.elementAt(0);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (elementAt instanceof Integer) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                aSN1EncodableVector.add(new DERInteger(((Integer) elements.nextElement()).intValue()));
            }
        }
        this.noticeNumbers = new DERSequence(aSN1EncodableVector);
    }

    public NoticeReference(String str, ASN1Sequence aSN1Sequence) {
        this.organization = new DisplayText(str);
        this.noticeNumbers = aSN1Sequence;
    }

    public NoticeReference(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.organization = DisplayText.getInstance(aSN1Sequence.getObjectAt(0));
            this.noticeNumbers = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public static NoticeReference getInstance(Object obj) {
        if (obj instanceof NoticeReference) {
            return (NoticeReference) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new NoticeReference((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in getInstance.");
    }

    public ASN1Sequence getNoticeNumbers() {
        return this.noticeNumbers;
    }

    public DisplayText getOrganization() {
        return this.organization;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.organization);
        aSN1EncodableVector.add(this.noticeNumbers);
        return new DERSequence(aSN1EncodableVector);
    }
}
