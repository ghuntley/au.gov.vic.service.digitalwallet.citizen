package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class PBEParameter extends ASN1Encodable {
    DERInteger iterations;
    ASN1OctetString salt;

    public PBEParameter(ASN1Sequence aSN1Sequence) {
        this.salt = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        this.iterations = (DERInteger) aSN1Sequence.getObjectAt(1);
    }

    public PBEParameter(byte[] bArr, int i) {
        if (bArr.length == 8) {
            this.salt = new DEROctetString(bArr);
            this.iterations = new DERInteger(i);
            return;
        }
        throw new IllegalArgumentException("salt length must be 8");
    }

    public static PBEParameter getInstance(Object obj) {
        if (obj instanceof PBEParameter) {
            return (PBEParameter) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PBEParameter((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public BigInteger getIterationCount() {
        return this.iterations.getValue();
    }

    public byte[] getSalt() {
        return this.salt.getOctets();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.salt);
        aSN1EncodableVector.add(this.iterations);
        return new DERSequence(aSN1EncodableVector);
    }
}
