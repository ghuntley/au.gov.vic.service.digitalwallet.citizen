package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme extends AlgorithmIdentifier {
    EncryptionScheme(ASN1Sequence aSN1Sequence) {
        this((DERObjectIdentifier) aSN1Sequence.getObjectAt(0), aSN1Sequence.getObjectAt(1));
    }

    public EncryptionScheme(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        super(dERObjectIdentifier, dEREncodable);
    }

    public static final AlgorithmIdentifier getInstance(Object obj) {
        if (obj instanceof EncryptionScheme) {
            return (EncryptionScheme) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new EncryptionScheme((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DEREncodable
    public DERObject getDERObject() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(getObjectId());
        aSN1EncodableVector.add(getParameters());
        return new DERSequence(aSN1EncodableVector);
    }

    public DERObject getObject() {
        return (DERObject) getParameters();
    }
}
