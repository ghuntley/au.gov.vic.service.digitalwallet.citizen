package org.bouncycastle.asn1.x9;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class DHDomainParameters extends ASN1Encodable {
    private DERInteger g;
    private DERInteger j;
    private DERInteger p;
    private DERInteger q;
    private DHValidationParms validationParms;

    private DHDomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.p = DERInteger.getInstance(objects.nextElement());
        this.g = DERInteger.getInstance(objects.nextElement());
        this.q = DERInteger.getInstance(objects.nextElement());
        DEREncodable next = getNext(objects);
        if (next != null && (next instanceof DERInteger)) {
            this.j = DERInteger.getInstance(next);
            next = getNext(objects);
        }
        if (next != null) {
            this.validationParms = DHValidationParms.getInstance(next.getDERObject());
        }
    }

    public DHDomainParameters(DERInteger dERInteger, DERInteger dERInteger2, DERInteger dERInteger3, DERInteger dERInteger4, DHValidationParms dHValidationParms) {
        if (dERInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        } else if (dERInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        } else if (dERInteger3 != null) {
            this.p = dERInteger;
            this.g = dERInteger2;
            this.q = dERInteger3;
            this.j = dERInteger4;
            this.validationParms = dHValidationParms;
        } else {
            throw new IllegalArgumentException("'q' cannot be null");
        }
    }

    public static DHDomainParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof DHDomainParameters)) {
            return (DHDomainParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DHDomainParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid DHDomainParameters: " + obj.getClass().getName());
    }

    public static DHDomainParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    private static DEREncodable getNext(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (DEREncodable) enumeration.nextElement();
        }
        return null;
    }

    public DERInteger getG() {
        return this.g;
    }

    public DERInteger getJ() {
        return this.j;
    }

    public DERInteger getP() {
        return this.p;
    }

    public DERInteger getQ() {
        return this.q;
    }

    public DHValidationParms getValidationParms() {
        return this.validationParms;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.p);
        aSN1EncodableVector.add(this.g);
        aSN1EncodableVector.add(this.q);
        DERInteger dERInteger = this.j;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        DHValidationParms dHValidationParms = this.validationParms;
        if (dHValidationParms != null) {
            aSN1EncodableVector.add(dHValidationParms);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
