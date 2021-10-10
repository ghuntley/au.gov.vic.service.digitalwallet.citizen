package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;

public class ContentIdentifier extends ASN1Encodable {
    ASN1OctetString value;

    public ContentIdentifier(ASN1OctetString aSN1OctetString) {
        this.value = aSN1OctetString;
    }

    public ContentIdentifier(byte[] bArr) {
        this(new DEROctetString(bArr));
    }

    public static ContentIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ContentIdentifier)) {
            return (ContentIdentifier) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new ContentIdentifier((ASN1OctetString) obj);
        }
        throw new IllegalArgumentException("unknown object in 'ContentIdentifier' factory : " + obj.getClass().getName() + ".");
    }

    public ASN1OctetString getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.value;
    }
}
