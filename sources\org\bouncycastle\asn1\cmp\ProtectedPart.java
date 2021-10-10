package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class ProtectedPart extends ASN1Encodable {
    private PKIBody body;
    private PKIHeader header;

    private ProtectedPart(ASN1Sequence aSN1Sequence) {
        this.header = PKIHeader.getInstance(aSN1Sequence.getObjectAt(0));
        this.body = PKIBody.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public ProtectedPart(PKIHeader pKIHeader, PKIBody pKIBody) {
        this.header = pKIHeader;
        this.body = pKIBody;
    }

    public static ProtectedPart getInstance(Object obj) {
        if (obj instanceof ProtectedPart) {
            return (ProtectedPart) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ProtectedPart((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public PKIBody getBody() {
        return this.body;
    }

    public PKIHeader getHeader() {
        return this.header;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.header);
        aSN1EncodableVector.add(this.body);
        return new DERSequence(aSN1EncodableVector);
    }
}
