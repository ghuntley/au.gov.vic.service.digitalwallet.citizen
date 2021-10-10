package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class InfoTypeAndValue extends ASN1Encodable {
    private DERObjectIdentifier infoType;
    private ASN1Encodable infoValue;

    private InfoTypeAndValue(ASN1Sequence aSN1Sequence) {
        this.infoType = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.infoValue = (ASN1Encodable) aSN1Sequence.getObjectAt(1);
        }
    }

    public InfoTypeAndValue(DERObjectIdentifier dERObjectIdentifier) {
        this.infoType = dERObjectIdentifier;
        this.infoValue = null;
    }

    public InfoTypeAndValue(DERObjectIdentifier dERObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.infoType = dERObjectIdentifier;
        this.infoValue = aSN1Encodable;
    }

    public static InfoTypeAndValue getInstance(Object obj) {
        if (obj instanceof InfoTypeAndValue) {
            return (InfoTypeAndValue) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new InfoTypeAndValue((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public DERObjectIdentifier getInfoType() {
        return this.infoType;
    }

    public ASN1Encodable getInfoValue() {
        return this.infoValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.infoType);
        ASN1Encodable aSN1Encodable = this.infoValue;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(aSN1Encodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
