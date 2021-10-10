package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class GOST3410PublicKeyAlgParameters extends ASN1Encodable {
    private DERObjectIdentifier digestParamSet;
    private DERObjectIdentifier encryptionParamSet;
    private DERObjectIdentifier publicKeyParamSet;

    public GOST3410PublicKeyAlgParameters(ASN1Sequence aSN1Sequence) {
        this.publicKeyParamSet = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.digestParamSet = (DERObjectIdentifier) aSN1Sequence.getObjectAt(1);
        if (aSN1Sequence.size() > 2) {
            this.encryptionParamSet = (DERObjectIdentifier) aSN1Sequence.getObjectAt(2);
        }
    }

    public GOST3410PublicKeyAlgParameters(DERObjectIdentifier dERObjectIdentifier, DERObjectIdentifier dERObjectIdentifier2) {
        this.publicKeyParamSet = dERObjectIdentifier;
        this.digestParamSet = dERObjectIdentifier2;
        this.encryptionParamSet = null;
    }

    public GOST3410PublicKeyAlgParameters(DERObjectIdentifier dERObjectIdentifier, DERObjectIdentifier dERObjectIdentifier2, DERObjectIdentifier dERObjectIdentifier3) {
        this.publicKeyParamSet = dERObjectIdentifier;
        this.digestParamSet = dERObjectIdentifier2;
        this.encryptionParamSet = dERObjectIdentifier3;
    }

    public static GOST3410PublicKeyAlgParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof GOST3410PublicKeyAlgParameters)) {
            return (GOST3410PublicKeyAlgParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new GOST3410PublicKeyAlgParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public static GOST3410PublicKeyAlgParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DERObjectIdentifier getDigestParamSet() {
        return this.digestParamSet;
    }

    public DERObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public DERObjectIdentifier getPublicKeyParamSet() {
        return this.publicKeyParamSet;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.publicKeyParamSet);
        aSN1EncodableVector.add(this.digestParamSet);
        DERObjectIdentifier dERObjectIdentifier = this.encryptionParamSet;
        if (dERObjectIdentifier != null) {
            aSN1EncodableVector.add(dERObjectIdentifier);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
