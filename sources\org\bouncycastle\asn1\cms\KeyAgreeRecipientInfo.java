package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KeyAgreeRecipientInfo extends ASN1Encodable {
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private OriginatorIdentifierOrKey originator;
    private ASN1Sequence recipientEncryptedKeys;
    private ASN1OctetString ukm;
    private DERInteger version;

    public KeyAgreeRecipientInfo(ASN1Sequence aSN1Sequence) {
        this.version = (DERInteger) aSN1Sequence.getObjectAt(0);
        this.originator = OriginatorIdentifierOrKey.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
        int i = 2;
        if (aSN1Sequence.getObjectAt(2) instanceof ASN1TaggedObject) {
            this.ukm = ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(2), true);
            i = 3;
        }
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        this.recipientEncryptedKeys = (ASN1Sequence) aSN1Sequence.getObjectAt(i + 1);
    }

    public KeyAgreeRecipientInfo(OriginatorIdentifierOrKey originatorIdentifierOrKey, ASN1OctetString aSN1OctetString, AlgorithmIdentifier algorithmIdentifier, ASN1Sequence aSN1Sequence) {
        this.version = new DERInteger(3);
        this.originator = originatorIdentifierOrKey;
        this.ukm = aSN1OctetString;
        this.keyEncryptionAlgorithm = algorithmIdentifier;
        this.recipientEncryptedKeys = aSN1Sequence;
    }

    public static KeyAgreeRecipientInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof KeyAgreeRecipientInfo)) {
            return (KeyAgreeRecipientInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new KeyAgreeRecipientInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Illegal object in KeyAgreeRecipientInfo: " + obj.getClass().getName());
    }

    public static KeyAgreeRecipientInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public OriginatorIdentifierOrKey getOriginator() {
        return this.originator;
    }

    public ASN1Sequence getRecipientEncryptedKeys() {
        return this.recipientEncryptedKeys;
    }

    public ASN1OctetString getUserKeyingMaterial() {
        return this.ukm;
    }

    public DERInteger getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.originator));
        if (this.ukm != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.ukm));
        }
        aSN1EncodableVector.add(this.keyEncryptionAlgorithm);
        aSN1EncodableVector.add(this.recipientEncryptedKeys);
        return new DERSequence(aSN1EncodableVector);
    }
}
