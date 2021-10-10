package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedData extends ASN1Encodable {
    DERObjectIdentifier bagId;
    DERObject bagValue;
    ASN1Sequence data;

    public EncryptedData(ASN1Sequence aSN1Sequence) {
        if (((DERInteger) aSN1Sequence.getObjectAt(0)).getValue().intValue() == 0) {
            this.data = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
            return;
        }
        throw new IllegalArgumentException("sequence not version 0");
    }

    public EncryptedData(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, DEREncodable dEREncodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(dERObjectIdentifier);
        aSN1EncodableVector.add(algorithmIdentifier.getDERObject());
        aSN1EncodableVector.add(new BERTaggedObject(false, 0, dEREncodable));
        this.data = new BERSequence(aSN1EncodableVector);
    }

    public static EncryptedData getInstance(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedData) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new EncryptedData((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public ASN1OctetString getContent() {
        if (this.data.size() == 3) {
            return ASN1OctetString.getInstance((DERTaggedObject) this.data.getObjectAt(2), false);
        }
        return null;
    }

    public DERObjectIdentifier getContentType() {
        return (DERObjectIdentifier) this.data.getObjectAt(0);
    }

    public AlgorithmIdentifier getEncryptionAlgorithm() {
        return AlgorithmIdentifier.getInstance(this.data.getObjectAt(1));
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(0));
        aSN1EncodableVector.add(this.data);
        return new BERSequence(aSN1EncodableVector);
    }
}
