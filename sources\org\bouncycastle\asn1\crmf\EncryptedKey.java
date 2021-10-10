package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.EnvelopedData;

public class EncryptedKey extends ASN1Encodable implements ASN1Choice {
    private EncryptedValue encryptedValue;
    private EnvelopedData envelopedData;

    public EncryptedKey(EnvelopedData envelopedData2) {
        this.envelopedData = envelopedData2;
    }

    public EncryptedKey(EncryptedValue encryptedValue2) {
        this.encryptedValue = encryptedValue2;
    }

    public static EncryptedKey getInstance(Object obj) {
        return obj instanceof EncryptedKey ? (EncryptedKey) obj : obj instanceof ASN1TaggedObject ? new EncryptedKey(EnvelopedData.getInstance((ASN1TaggedObject) obj, false)) : obj instanceof EncryptedValue ? new EncryptedKey((EncryptedValue) obj) : new EncryptedKey(EncryptedValue.getInstance(obj));
    }

    public ASN1Encodable getValue() {
        EncryptedValue encryptedValue2 = this.encryptedValue;
        return encryptedValue2 != null ? encryptedValue2 : this.envelopedData;
    }

    public boolean isEncryptedValue() {
        return this.encryptedValue != null;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        EncryptedValue encryptedValue2 = this.encryptedValue;
        return encryptedValue2 != null ? encryptedValue2.toASN1Object() : new DERTaggedObject(false, 0, this.envelopedData);
    }
}
