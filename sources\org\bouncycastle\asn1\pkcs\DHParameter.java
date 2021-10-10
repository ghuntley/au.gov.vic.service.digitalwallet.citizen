package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class DHParameter extends ASN1Encodable {
    DERInteger g;
    DERInteger l;
    DERInteger p;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.p = new DERInteger(bigInteger);
        this.g = new DERInteger(bigInteger2);
        this.l = i != 0 ? new DERInteger(i) : null;
    }

    public DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.p = (DERInteger) objects.nextElement();
        this.g = (DERInteger) objects.nextElement();
        this.l = objects.hasMoreElements() ? (DERInteger) objects.nextElement() : null;
    }

    public BigInteger getG() {
        return this.g.getPositiveValue();
    }

    public BigInteger getL() {
        DERInteger dERInteger = this.l;
        if (dERInteger == null) {
            return null;
        }
        return dERInteger.getPositiveValue();
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.p);
        aSN1EncodableVector.add(this.g);
        if (getL() != null) {
            aSN1EncodableVector.add(this.l);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
