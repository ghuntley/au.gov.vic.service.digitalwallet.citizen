package org.bouncycastle.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Attribute;

public class X509Attribute extends ASN1Encodable {
    Attribute attr;

    public X509Attribute(String str, ASN1Encodable aSN1Encodable) {
        this.attr = new Attribute(new DERObjectIdentifier(str), new DERSet(aSN1Encodable));
    }

    public X509Attribute(String str, ASN1EncodableVector aSN1EncodableVector) {
        this.attr = new Attribute(new DERObjectIdentifier(str), new DERSet(aSN1EncodableVector));
    }

    X509Attribute(ASN1Encodable aSN1Encodable) {
        this.attr = Attribute.getInstance(aSN1Encodable);
    }

    public String getOID() {
        return this.attr.getAttrType().getId();
    }

    public ASN1Encodable[] getValues() {
        ASN1Set attrValues = this.attr.getAttrValues();
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[attrValues.size()];
        for (int i = 0; i != attrValues.size(); i++) {
            aSN1EncodableArr[i] = (ASN1Encodable) attrValues.getObjectAt(i);
        }
        return aSN1EncodableArr;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.attr.toASN1Object();
    }
}
