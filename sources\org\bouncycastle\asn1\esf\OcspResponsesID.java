package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class OcspResponsesID extends ASN1Encodable {
    private OcspIdentifier ocspIdentifier;
    private OtherHash ocspRepHash;

    private OcspResponsesID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        this.ocspIdentifier = OcspIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.ocspRepHash = OtherHash.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public OcspResponsesID(OcspIdentifier ocspIdentifier2) {
        this(ocspIdentifier2, null);
    }

    public OcspResponsesID(OcspIdentifier ocspIdentifier2, OtherHash otherHash) {
        this.ocspIdentifier = ocspIdentifier2;
        this.ocspRepHash = otherHash;
    }

    public static OcspResponsesID getInstance(Object obj) {
        if (obj instanceof OcspResponsesID) {
            return (OcspResponsesID) obj;
        }
        if (obj != null) {
            return new OcspResponsesID(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance");
    }

    public OcspIdentifier getOcspIdentifier() {
        return this.ocspIdentifier;
    }

    public OtherHash getOcspRepHash() {
        return this.ocspRepHash;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.ocspIdentifier);
        OtherHash otherHash = this.ocspRepHash;
        if (otherHash != null) {
            aSN1EncodableVector.add(otherHash);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
