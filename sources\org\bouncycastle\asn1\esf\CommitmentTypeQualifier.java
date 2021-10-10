package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class CommitmentTypeQualifier extends ASN1Encodable {
    private DERObjectIdentifier commitmentTypeIdentifier;
    private DEREncodable qualifier;

    public CommitmentTypeQualifier(ASN1Sequence aSN1Sequence) {
        this.commitmentTypeIdentifier = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        if (aSN1Sequence.size() > 1) {
            this.qualifier = aSN1Sequence.getObjectAt(1);
        }
    }

    public CommitmentTypeQualifier(DERObjectIdentifier dERObjectIdentifier) {
        this(dERObjectIdentifier, null);
    }

    public CommitmentTypeQualifier(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.commitmentTypeIdentifier = dERObjectIdentifier;
        this.qualifier = dEREncodable;
    }

    public static CommitmentTypeQualifier getInstance(Object obj) {
        if ((obj instanceof CommitmentTypeQualifier) || obj == null) {
            return (CommitmentTypeQualifier) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CommitmentTypeQualifier((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in getInstance.");
    }

    public DERObjectIdentifier getCommitmentTypeIdentifier() {
        return this.commitmentTypeIdentifier;
    }

    public DEREncodable getQualifier() {
        return this.qualifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.commitmentTypeIdentifier);
        DEREncodable dEREncodable = this.qualifier;
        if (dEREncodable != null) {
            aSN1EncodableVector.add(dEREncodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
