package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class ASN1OutputStream extends DEROutputStream {
    public ASN1OutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.bouncycastle.asn1.DEROutputStream
    public void writeObject(Object obj) throws IOException {
        DERObject dERObject;
        if (obj == null) {
            writeNull();
            return;
        }
        if (obj instanceof DERObject) {
            dERObject = (DERObject) obj;
        } else if (obj instanceof DEREncodable) {
            dERObject = ((DEREncodable) obj).getDERObject();
        } else {
            throw new IOException("object not ASN1Encodable");
        }
        dERObject.encode(this);
    }
}
