package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class RSASSAPSSparams extends ASN1Encodable {
    public static final AlgorithmIdentifier DEFAULT_HASH_ALGORITHM;
    public static final AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION;
    public static final DERInteger DEFAULT_SALT_LENGTH = new DERInteger(20);
    public static final DERInteger DEFAULT_TRAILER_FIELD = new DERInteger(1);
    private AlgorithmIdentifier hashAlgorithm;
    private AlgorithmIdentifier maskGenAlgorithm;
    private DERInteger saltLength;
    private DERInteger trailerField;

    static {
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, new DERNull());
        DEFAULT_HASH_ALGORITHM = algorithmIdentifier;
        DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, algorithmIdentifier);
    }

    public RSASSAPSSparams() {
        this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        this.maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        this.saltLength = DEFAULT_SALT_LENGTH;
        this.trailerField = DEFAULT_TRAILER_FIELD;
    }

    public RSASSAPSSparams(ASN1Sequence aSN1Sequence) {
        this.hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        this.maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        this.saltLength = DEFAULT_SALT_LENGTH;
        this.trailerField = DEFAULT_TRAILER_FIELD;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.hashAlgorithm = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 1) {
                this.maskGenAlgorithm = AlgorithmIdentifier.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 2) {
                this.saltLength = DERInteger.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 3) {
                this.trailerField = DERInteger.getInstance(aSN1TaggedObject, true);
            } else {
                throw new IllegalArgumentException("unknown tag");
            }
        }
    }

    public RSASSAPSSparams(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, DERInteger dERInteger, DERInteger dERInteger2) {
        this.hashAlgorithm = algorithmIdentifier;
        this.maskGenAlgorithm = algorithmIdentifier2;
        this.saltLength = dERInteger;
        this.trailerField = dERInteger2;
    }

    public static RSASSAPSSparams getInstance(Object obj) {
        if (obj == null || (obj instanceof RSASSAPSSparams)) {
            return (RSASSAPSSparams) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RSASSAPSSparams((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public AlgorithmIdentifier getMaskGenAlgorithm() {
        return this.maskGenAlgorithm;
    }

    public DERInteger getSaltLength() {
        return this.saltLength;
    }

    public DERInteger getTrailerField() {
        return this.trailerField;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (!this.hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.hashAlgorithm));
        }
        if (!this.maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.maskGenAlgorithm));
        }
        if (!this.saltLength.equals(DEFAULT_SALT_LENGTH)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, this.saltLength));
        }
        if (!this.trailerField.equals(DEFAULT_TRAILER_FIELD)) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 3, this.trailerField));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
