package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class PKIArchiveOptions extends ASN1Encodable implements ASN1Choice {
    public static final int archiveRemGenPrivKey = 2;
    public static final int encryptedPrivKey = 0;
    public static final int keyGenParameters = 1;
    private ASN1Encodable value;

    public PKIArchiveOptions(ASN1OctetString aSN1OctetString) {
        this.value = aSN1OctetString;
    }

    private PKIArchiveOptions(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Encodable;
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            aSN1Encodable = EncryptedKey.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 1) {
            aSN1Encodable = ASN1OctetString.getInstance(aSN1TaggedObject, false);
        } else if (tagNo == 2) {
            aSN1Encodable = DERBoolean.getInstance(aSN1TaggedObject, false);
        } else {
            throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
        }
        this.value = aSN1Encodable;
    }

    public PKIArchiveOptions(EncryptedKey encryptedKey) {
        this.value = encryptedKey;
    }

    public PKIArchiveOptions(boolean z) {
        this.value = new DERBoolean(z);
    }

    public static PKIArchiveOptions getInstance(Object obj) {
        if (obj instanceof PKIArchiveOptions) {
            return (PKIArchiveOptions) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new PKIArchiveOptions((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("unknown object: " + obj);
    }

    public int getType() {
        ASN1Encodable aSN1Encodable = this.value;
        if (aSN1Encodable instanceof EncryptedKey) {
            return 0;
        }
        return aSN1Encodable instanceof ASN1OctetString ? 1 : 2;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        ASN1Encodable aSN1Encodable = this.value;
        return aSN1Encodable instanceof EncryptedKey ? new DERTaggedObject(true, 0, this.value) : aSN1Encodable instanceof ASN1OctetString ? new DERTaggedObject(false, 1, this.value) : new DERTaggedObject(false, 2, this.value);
    }
}
