package org.bouncycastle.asn1;

import java.io.IOException;

public class DEROctetString extends ASN1OctetString {
    public DEROctetString(DEREncodable dEREncodable) {
        super(dEREncodable);
    }

    public DEROctetString(byte[] bArr) {
        super(bArr);
    }

    static void encode(DEROutputStream dEROutputStream, byte[] bArr) throws IOException {
        dEROutputStream.writeEncoded(4, bArr);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1OctetString, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(4, this.string);
    }
}
