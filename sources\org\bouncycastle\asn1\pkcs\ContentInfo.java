package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERTaggedObject;

public class ContentInfo extends ASN1Encodable implements PKCSObjectIdentifiers {
    private DEREncodable content;
    private DERObjectIdentifier contentType;

    public ContentInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.contentType = (DERObjectIdentifier) objects.nextElement();
        if (objects.hasMoreElements()) {
            this.content = ((DERTaggedObject) objects.nextElement()).getObject();
        }
    }

    public ContentInfo(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.contentType = dERObjectIdentifier;
        this.content = dEREncodable;
    }

    public static ContentInfo getInstance(Object obj) {
        if (obj instanceof ContentInfo) {
            return (ContentInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ContentInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public DEREncodable getContent() {
        return this.content;
    }

    public DERObjectIdentifier getContentType() {
        return this.contentType;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.contentType);
        if (this.content != null) {
            aSN1EncodableVector.add(new BERTaggedObject(0, this.content));
        }
        return new BERSequence(aSN1EncodableVector);
    }
}
