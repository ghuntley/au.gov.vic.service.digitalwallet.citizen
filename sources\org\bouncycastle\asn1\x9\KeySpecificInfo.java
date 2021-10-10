package org.bouncycastle.asn1.x9;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class KeySpecificInfo extends ASN1Encodable {
    private DERObjectIdentifier algorithm;
    private ASN1OctetString counter;

    public KeySpecificInfo(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.algorithm = (DERObjectIdentifier) objects.nextElement();
        this.counter = (ASN1OctetString) objects.nextElement();
    }

    public KeySpecificInfo(DERObjectIdentifier dERObjectIdentifier, ASN1OctetString aSN1OctetString) {
        this.algorithm = dERObjectIdentifier;
        this.counter = aSN1OctetString;
    }

    public DERObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public ASN1OctetString getCounter() {
        return this.counter;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.algorithm);
        aSN1EncodableVector.add(this.counter);
        return new DERSequence(aSN1EncodableVector);
    }
}
