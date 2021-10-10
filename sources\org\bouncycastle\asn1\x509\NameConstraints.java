package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class NameConstraints extends ASN1Encodable {
    private ASN1Sequence excluded;
    private ASN1Sequence permitted;

    public NameConstraints(Vector vector, Vector vector2) {
        if (vector != null) {
            this.permitted = createSequence(vector);
        }
        if (vector2 != null) {
            this.excluded = createSequence(vector2);
        }
    }

    public NameConstraints(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.permitted = ASN1Sequence.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.excluded = ASN1Sequence.getInstance(instance, false);
            }
        }
    }

    private DERSequence createSequence(Vector vector) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector.add((GeneralSubtree) elements.nextElement());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ASN1Sequence getExcludedSubtrees() {
        return this.excluded;
    }

    public ASN1Sequence getPermittedSubtrees() {
        return this.permitted;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.permitted != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.permitted));
        }
        if (this.excluded != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.excluded));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
