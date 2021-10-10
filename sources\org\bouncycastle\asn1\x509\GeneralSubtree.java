package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class GeneralSubtree extends ASN1Encodable {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private GeneralName base;
    private DERInteger maximum;
    private DERInteger minimum;

    public GeneralSubtree(ASN1Sequence aSN1Sequence) {
        ASN1TaggedObject aSN1TaggedObject;
        this.base = GeneralName.getInstance(aSN1Sequence.getObjectAt(0));
        int size = aSN1Sequence.size();
        if (size != 1) {
            if (size == 2) {
                aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.minimum = DERInteger.getInstance(aSN1TaggedObject, false);
                    return;
                } else if (tagNo != 1) {
                    throw new IllegalArgumentException("Bad tag number: " + aSN1TaggedObject.getTagNo());
                }
            } else if (size == 3) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
                if (instance.getTagNo() == 0) {
                    this.minimum = DERInteger.getInstance(instance, false);
                    aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2));
                    if (aSN1TaggedObject.getTagNo() != 1) {
                        throw new IllegalArgumentException("Bad tag number for 'maximum': " + aSN1TaggedObject.getTagNo());
                    }
                } else {
                    throw new IllegalArgumentException("Bad tag number for 'minimum': " + instance.getTagNo());
                }
            } else {
                throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
            }
            this.maximum = DERInteger.getInstance(aSN1TaggedObject, false);
        }
    }

    public GeneralSubtree(GeneralName generalName) {
        this(generalName, null, null);
    }

    public GeneralSubtree(GeneralName generalName, BigInteger bigInteger, BigInteger bigInteger2) {
        this.base = generalName;
        if (bigInteger2 != null) {
            this.maximum = new DERInteger(bigInteger2);
        }
        this.minimum = bigInteger == null ? null : new DERInteger(bigInteger);
    }

    public static GeneralSubtree getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof GeneralSubtree ? (GeneralSubtree) obj : new GeneralSubtree(ASN1Sequence.getInstance(obj));
    }

    public static GeneralSubtree getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new GeneralSubtree(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralName getBase() {
        return this.base;
    }

    public BigInteger getMaximum() {
        DERInteger dERInteger = this.maximum;
        if (dERInteger == null) {
            return null;
        }
        return dERInteger.getValue();
    }

    public BigInteger getMinimum() {
        DERInteger dERInteger = this.minimum;
        return dERInteger == null ? ZERO : dERInteger.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.base);
        DERInteger dERInteger = this.minimum;
        if (dERInteger != null && !dERInteger.getValue().equals(ZERO)) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, this.minimum));
        }
        if (this.maximum != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, this.maximum));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
