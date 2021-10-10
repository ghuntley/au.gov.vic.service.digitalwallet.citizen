package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ASN1Encodable implements DEREncodable {
    public static final String BER = "BER";
    public static final String DER = "DER";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DEREncodable)) {
            return false;
        }
        return toASN1Object().equals(((DEREncodable) obj).getDERObject());
    }

    public byte[] getDEREncoded() {
        try {
            return getEncoded(DER);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // org.bouncycastle.asn1.DEREncodable
    public DERObject getDERObject() {
        return toASN1Object();
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ASN1OutputStream(byteArrayOutputStream).writeObject(this);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getEncoded(String str) throws IOException {
        if (!str.equals(DER)) {
            return getEncoded();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DEROutputStream(byteArrayOutputStream).writeObject(this);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return toASN1Object().hashCode();
    }

    public abstract DERObject toASN1Object();
}
