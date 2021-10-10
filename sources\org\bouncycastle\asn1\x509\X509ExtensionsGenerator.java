package org.bouncycastle.asn1.x509;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;

public class X509ExtensionsGenerator {
    private Vector extOrdering = new Vector();
    private Hashtable extensions = new Hashtable();

    public void addExtension(DERObjectIdentifier dERObjectIdentifier, boolean z, DEREncodable dEREncodable) {
        try {
            addExtension(dERObjectIdentifier, z, dEREncodable.getDERObject().getEncoded(ASN1Encodable.DER));
        } catch (IOException e) {
            throw new IllegalArgumentException("error encoding value: " + e);
        }
    }

    public void addExtension(DERObjectIdentifier dERObjectIdentifier, boolean z, byte[] bArr) {
        if (!this.extensions.containsKey(dERObjectIdentifier)) {
            this.extOrdering.addElement(dERObjectIdentifier);
            this.extensions.put(dERObjectIdentifier, new X509Extension(z, new DEROctetString(bArr)));
            return;
        }
        throw new IllegalArgumentException("extension " + dERObjectIdentifier + " already added");
    }

    public X509Extensions generate() {
        return new X509Extensions(this.extOrdering, this.extensions);
    }

    public boolean isEmpty() {
        return this.extOrdering.isEmpty();
    }

    public void reset() {
        this.extensions = new Hashtable();
        this.extOrdering = new Vector();
    }
}
