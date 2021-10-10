package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1Object extends DERObject {
    public static ASN1Object fromByteArray(byte[] bArr) throws IOException {
        try {
            return (ASN1Object) new ASN1InputStream(bArr).readObject();
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean asn1Equals(DERObject dERObject);

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.DERObject
    public abstract void encode(DEROutputStream dEROutputStream) throws IOException;

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DEREncodable) && asn1Equals(((DEREncodable) obj).getDERObject());
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject
    public abstract int hashCode();
}
