package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class UserNotice extends ASN1Encodable {
    private DisplayText explicitText;
    private NoticeReference noticeRef;

    public UserNotice(ASN1Sequence aSN1Sequence) {
        DEREncodable objectAt;
        if (aSN1Sequence.size() == 2) {
            this.noticeRef = NoticeReference.getInstance(aSN1Sequence.getObjectAt(0));
            objectAt = aSN1Sequence.getObjectAt(1);
        } else if (aSN1Sequence.size() == 1) {
            boolean z = aSN1Sequence.getObjectAt(0).getDERObject() instanceof ASN1Sequence;
            objectAt = aSN1Sequence.getObjectAt(0);
            if (z) {
                this.noticeRef = NoticeReference.getInstance(objectAt);
                return;
            }
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.explicitText = DisplayText.getInstance(objectAt);
    }

    public UserNotice(NoticeReference noticeReference, String str) {
        this.noticeRef = noticeReference;
        this.explicitText = new DisplayText(str);
    }

    public UserNotice(NoticeReference noticeReference, DisplayText displayText) {
        this.noticeRef = noticeReference;
        this.explicitText = displayText;
    }

    public DisplayText getExplicitText() {
        return this.explicitText;
    }

    public NoticeReference getNoticeRef() {
        return this.noticeRef;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
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
