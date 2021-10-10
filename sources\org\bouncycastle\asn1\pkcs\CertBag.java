package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CertBag extends ASN1Encodable {
    DERObjectIdentifier certId;
    DERObject certValue;
    ASN1Sequence seq;

    public CertBag(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
        this.certId = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.certValue = ((DERTaggedObject) aSN1Sequence.getObjectAt(1)).getObject();
    }

    public CertBag(DERObjectIdentifier dERObjectIdentifier, DERObject dERObject) {
        this.certId = dERObjectIdentifier;
        this.certValue = dERObject;
    }

    public DERObjectIdentifier getCertId() {
        return this.certId;
    }

    public DERObject getCertValue() {
        return this.certValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certId);
        aSN1EncodableVector.add(new DERTaggedObject(0, this.certValue));
        return new DERSequence(aSN1EncodableVector);
    }
}
