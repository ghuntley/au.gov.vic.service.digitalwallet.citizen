package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class PBKDF2Params extends ASN1Encodable {
    DERInteger iterationCount;
    DERInteger keyLength;
    ASN1OctetString octStr;

    public PBKDF2Params(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.octStr = (ASN1OctetString) objects.nextElement();
        this.iterationCount = (DERInteger) objects.nextElement();
        this.keyLength = objects.hasMoreElements() ? (DERInteger) objects.nextElement() : null;
    }

    public PBKDF2Params(byte[] bArr, int i) {
        this.octStr = new DEROctetString(bArr);
        this.iterationCount = new DERInteger(i);
    }

    public static PBKDF2Params getInstance(Object obj) {
        if (obj instanceof PBKDF2Params) {
            return (PBKDF2Params) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PBKDF2Params((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public BigInteger getIterationCount() {
        return this.iterationCount.getValue();
    }

    public BigInteger getKeyLength() {
        DERInteger dERInteger = this.keyLength;
        if (dERInteger != null) {
            return dERInteger.getValue();
        }
        return null;
    }

    public byte[] getSalt() {
        return this.octStr.getOctets();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.octStr);
        aSN1EncodableVector.add(this.iterationCount);
        DERInteger dERInteger = this.keyLength;
        if (dERInteger != null) {
            aSN1EncodableVector.add(dERInteger);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
