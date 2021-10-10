package org.bouncycastle.asn1;

import java.util.Vector;

public class ASN1EncodableVector extends DEREncodableVector {
    Vector v = new Vector();

    @Override // org.bouncycastle.asn1.DEREncodableVector
    public void add(DEREncodable dEREncodable) {
        this.v.addElement(dEREncodable);
    }

    @Override // org.bouncycastle.asn1.DEREncodableVector
    public DEREncodable get(int i) {
        return (DEREncodable) this.v.elementAt(i);
    }

    @Override // org.bouncycastle.asn1.DEREncodableVector
    public int size() {
        return this.v.size();
    }
}
