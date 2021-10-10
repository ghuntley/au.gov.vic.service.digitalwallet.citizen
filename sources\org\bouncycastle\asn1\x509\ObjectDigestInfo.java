package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class ObjectDigestInfo extends ASN1Encodable {
    public static final int otherObjectDigest = 2;
    public static final int publicKey = 0;
    public static final int publicKeyCert = 1;
    AlgorithmIdentifier digestAlgorithm;
    DEREnumerated digestedObjectType;
    DERBitString objectDigest;
    DERObjectIdentifier otherObjectTypeID;

    public ObjectDigestInfo(int i, String str, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.digestedObjectType = new DEREnumerated(i);
        if (i == 2) {
            this.otherObjectTypeID = new DERObjectIdentifier(str);
        }
        this.digestAlgorithm = algorithmIdentifier;
        this.objectDigest = new DERBitString(bArr);
    }

    private ObjectDigestInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() > 4 || aSN1Sequence.size() < 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        int i = 0;
        this.digestedObjectType = DEREnumerated.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 4) {
            this.otherObjectTypeID = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            i = 1;
        }
        this.digestAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 1));
        this.objectDigest = DERBitString.getInstance(aSN1Sequence.getObjectAt(i + 2));
    }

    public static ObjectDigestInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof ObjectDigestInfo)) {
            return (ObjectDigestInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ObjectDigestInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ObjectDigestInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public DEREnumerated getDigestedObjectType() {
        return this.digestedObjectType;
    }

    public DERBitString getObjectDigest() {
        return this.objectDigest;
    }

    public DERObjectIdentifier getOtherObjectTypeID() {
        return this.otherObjectTypeID;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.digestedObjectType);
        DERObjectIdentifier dERObjectIdentifier = this.otherObjectTypeID;
        if (dERObjectIdentifier != null) {
            aSN1EncodableVector.add(dERObjectIdentifier);
        }
        aSN1EncodableVector.add(this.digestAlgorithm);
        aSN1EncodableVector.add(this.objectDigest);
        return new DERSequence(aSN1EncodableVector);
    }
}
