package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class X9ECParameters extends ASN1Encodable implements X9ObjectIdentifiers {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private ECCurve curve;
    private X9FieldID fieldID;
    private ECPoint g;
    private BigInteger h;
    private BigInteger n;
    private byte[] seed;

    public X9ECParameters(ASN1Sequence aSN1Sequence) {
        if (!(aSN1Sequence.getObjectAt(0) instanceof DERInteger) || !((DERInteger) aSN1Sequence.getObjectAt(0)).getValue().equals(ONE)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        X9Curve x9Curve = new X9Curve(new X9FieldID((ASN1Sequence) aSN1Sequence.getObjectAt(1)), (ASN1Sequence) aSN1Sequence.getObjectAt(2));
        ECCurve curve2 = x9Curve.getCurve();
        this.curve = curve2;
        this.g = new X9ECPoint(curve2, (ASN1OctetString) aSN1Sequence.getObjectAt(3)).getPoint();
        this.n = ((DERInteger) aSN1Sequence.getObjectAt(4)).getValue();
        this.seed = x9Curve.getSeed();
        if (aSN1Sequence.size() == 6) {
            this.h = ((DERInteger) aSN1Sequence.getObjectAt(5)).getValue();
        }
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, ONE, null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        X9FieldID x9FieldID;
        this.curve = eCCurve;
        this.g = eCPoint;
        this.n = bigInteger;
        this.h = bigInteger2;
        this.seed = bArr;
        if (eCCurve instanceof ECCurve.Fp) {
            x9FieldID = new X9FieldID(((ECCurve.Fp) eCCurve).getQ());
        } else if (eCCurve instanceof ECCurve.F2m) {
            ECCurve.F2m f2m = (ECCurve.F2m) eCCurve;
            x9FieldID = new X9FieldID(f2m.getM(), f2m.getK1(), f2m.getK2(), f2m.getK3());
        } else {
            return;
        }
        this.fieldID = x9FieldID;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.g;
    }

    public BigInteger getH() {
        BigInteger bigInteger = this.h;
        return bigInteger == null ? ONE : bigInteger;
    }

    public BigInteger getN() {
        return this.n;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(1));
        aSN1EncodableVector.add(this.fieldID);
        aSN1EncodableVector.add(new X9Curve(this.curve, this.seed));
        aSN1EncodableVector.add(new X9ECPoint(this.g));
        aSN1EncodableVector.add(new DERInteger(this.n));
        BigInteger bigInteger = this.h;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new DERInteger(bigInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
