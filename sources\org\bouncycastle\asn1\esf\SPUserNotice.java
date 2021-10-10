package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.DisplayText;
import org.bouncycastle.asn1.x509.NoticeReference;

public class SPUserNotice {
    private DisplayText explicitText;
    private NoticeReference noticeRef;

    public SPUserNotice(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            DEREncodable dEREncodable = (DEREncodable) objects.nextElement();
            if (dEREncodable instanceof NoticeReference) {
                this.noticeRef = NoticeReference.getInstance(dEREncodable);
            } else if (dEREncodable instanceof DisplayText) {
                this.explicitText = DisplayText.getInstance(dEREncodable);
            } else {
                throw new IllegalArgumentException("Invalid element in 'SPUserNotice'.");
            }
        }
    }

    public SPUserNotice(NoticeReference noticeReference, DisplayText displayText) {
        this.noticeRef = noticeReference;
        this.explicitText = displayText;
    }

    public static SPUserNotice getInstance(Object obj) {
        if (obj == null || (obj instanceof SPUserNotice)) {
            return (SPUserNotice) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SPUserNotice((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in 'SPUserNotice' factory : " + obj.getClass().getName() + ".");
    }

    public DisplayText getExplicitText() {
        return this.explicitText;
    }

    public NoticeReference getNoticeRef() {
        return this.noticeRef;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        NoticeReference noticeReference = this.noticeRef;
        if (noticeReference != null) {
            aSN1EncodableVector.add(noticeReference);
        }
        DisplayText displayText = this.explicitText;
        if (displayText != null) {
            aSN1EncodableVector.add(displayText);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
