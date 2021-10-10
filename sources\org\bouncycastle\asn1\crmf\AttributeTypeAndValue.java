package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class AttributeTypeAndValue extends ASN1Encodable {
    private DERObjectIdentifier type;
    private ASN1Encodable value;

    public AttributeTypeAndValue(String str, ASN1Encodable aSN1Encodable) {
        this(new DERObjectIdentifier(str), aSN1Encodable);
    }

    private AttributeTypeAndValue(ASN1Sequence aSN1Sequence) {
        this.type = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.value = (ASN1Encodable) aSN1Sequence.getObjectAt(1);
    }

    public AttributeTypeAndValue(DERObjectIdentifier dERObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.type = dERObjectIdentifier;
        this.value = aSN1Encodable;
    }

    public static AttributeTypeAndValue getInstance(Object obj) {
        if (obj instanceof AttributeTypeAndValue) {
            return (AttributeTypeAndValue) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new AttributeTypeAndValue((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public DERObjectIdentifier getType() {
        return this.type;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.type);
        aSN1EncodableVector.add(this.value);
        return new DERSequence(aSN1EncodableVector);
    }
}
