package org.bouncycastle.asn1;

public class ASN1ObjectIdentifier extends DERObjectIdentifier {
    public ASN1ObjectIdentifier(String str) {
        super(str);
    }

    ASN1ObjectIdentifier(byte[] bArr) {
        super(bArr);
    }

    public ASN1ObjectIdentifier branch(String str) {
        return new ASN1ObjectIdentifier(getId() + "." + str);
    }
}
