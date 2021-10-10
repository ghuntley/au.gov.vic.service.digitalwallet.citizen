package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECCurve;

public class X9Curve extends ASN1Encodable implements X9ObjectIdentifiers {
    private ECCurve curve;
    private DERObjectIdentifier fieldIdentifier = null;
    private byte[] seed;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    public X9Curve(X9FieldID x9FieldID, ASN1Sequence aSN1Sequence) {
        int i;
        int i2;
        int i3;
        ECCurve f2m;
        DERObjectIdentifier identifier = x9FieldID.getIdentifier();
        this.fieldIdentifier = identifier;
        if (identifier.equals(prime_field)) {
            BigInteger value = ((DERInteger) x9FieldID.getParameters()).getValue();
            f2m = new ECCurve.Fp(value, new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        } else {
            if (this.fieldIdentifier.equals(characteristic_two_field)) {
                DERSequence dERSequence = (DERSequence) x9FieldID.getParameters();
                int intValue = ((DERInteger) dERSequence.getObjectAt(0)).getValue().intValue();
                boolean equals = ((DERObjectIdentifier) dERSequence.getObjectAt(1)).equals(tpBasis);
                DEREncodable objectAt = dERSequence.getObjectAt(2);
                if (equals) {
                    i = ((DERInteger) objectAt).getValue().intValue();
                    i3 = 0;
                    i2 = 0;
                } else {
                    DERSequence dERSequence2 = (DERSequence) objectAt;
                    int intValue2 = ((DERInteger) dERSequence2.getObjectAt(0)).getValue().intValue();
                    int intValue3 = ((DERInteger) dERSequence2.getObjectAt(1)).getValue().intValue();
                    i2 = ((DERInteger) dERSequence2.getObjectAt(2)).getValue().intValue();
                    i = intValue2;
                    i3 = intValue3;
                }
                f2m = new ECCurve.F2m(intValue, i, i3, i2, new X9FieldElement(intValue, i, i3, i2, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(intValue, i, i3, i2, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
            }
            if (aSN1Sequence.size() != 3) {
                this.seed = ((DERBitString) aSN1Sequence.getObjectAt(2)).getBytes();
                return;
            }
            return;
        }
        this.curve = f2m;
        if (aSN1Sequence.size() != 3) {
        }
    }

    public X9Curve(ECCurve eCCurve) {
        this.curve = eCCurve;
        this.seed = null;
        setFieldIdentifier();
    }

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.curve = eCCurve;
        this.seed = bArr;
        setFieldIdentifier();
    }

    private void setFieldIdentifier() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ECCurve eCCurve = this.curve;
        if (eCCurve instanceof ECCurve.Fp) {
            aSN1ObjectIdentifier = prime_field;
        } else if (eCCurve instanceof ECCurve.F2m) {
            aSN1ObjectIdentifier = characteristic_two_field;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        this.fieldIdentifier = aSN1ObjectIdentifier;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0060  */
    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        X9FieldElement x9FieldElement;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.fieldIdentifier.equals(prime_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).getDERObject());
            x9FieldElement = new X9FieldElement(this.curve.getB());
        } else {
            if (this.fieldIdentifier.equals(characteristic_two_field)) {
                aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).getDERObject());
                x9FieldElement = new X9FieldElement(this.curve.getB());
            }
            if (this.seed != null) {
                aSN1EncodableVector.add(new DERBitString(this.seed));
            }
            return new DERSequence(aSN1EncodableVector);
        }
        aSN1EncodableVector.add(x9FieldElement.getDERObject());
        if (this.seed != null) {
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
