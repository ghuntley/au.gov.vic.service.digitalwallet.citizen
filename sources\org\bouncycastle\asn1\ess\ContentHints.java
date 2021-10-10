package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

public class ContentHints extends ASN1Encodable {
    private DERUTF8String contentDescription;
    private DERObjectIdentifier contentType;

    private ContentHints(ASN1Sequence aSN1Sequence) {
        int i = 0;
        DEREncodable objectAt = aSN1Sequence.getObjectAt(0);
        if (objectAt.getDERObject() instanceof DERUTF8String) {
            this.contentDescription = DERUTF8String.getInstance(objectAt);
            i = 1;
        }
        this.contentType = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
    }

    public ContentHints(DERObjectIdentifier dERObjectIdentifier) {
        this.contentType = dERObjectIdentifier;
        this.contentDescription = null;
    }

    public ContentHints(DERObjectIdentifier dERObjectIdentifier, DERUTF8String dERUTF8String) {
        this.contentType = dERObjectIdentifier;
        this.contentDescription = dERUTF8String;
    }

    public static ContentHints getInstance(Object obj) {
        if (obj == null || (obj instanceof ContentHints)) {
            return (ContentHints) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ContentHints((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in 'ContentHints' factory : " + obj.getClass().getName() + ".");
    }

    public DERUTF8String getContentDescription() {
        return this.contentDescription;
    }

    public DERObjectIdentifier getContentType() {
        return this.contentType;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERUTF8String dERUTF8String = this.contentDescription;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        aSN1EncodableVector.add(this.contentType);
        return new DERSequence(aSN1EncodableVector);
    }
}
