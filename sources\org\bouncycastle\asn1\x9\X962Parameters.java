package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;

public class X962Parameters extends ASN1Encodable implements ASN1Choice {
    private DERObject params = null;

    public X962Parameters(DERObject dERObject) {
        this.params = dERObject;
    }

    public X962Parameters(DERObjectIdentifier dERObjectIdentifier) {
        this.params = dERObjectIdentifier;
    }

    public X962Parameters(X9ECParameters x9ECParameters) {
        this.params = x9ECParameters.getDERObject();
    }

    public static X962Parameters getInstance(Object obj) {
        if (obj == null || (obj instanceof X962Parameters)) {
            return (X962Parameters) obj;
        }
        if (obj instanceof DERObject) {
            return new X962Parameters((DERObject) obj);
        }
        throw new IllegalArgumentException("unknown object in getInstance()");
    }

    public static X962Parameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DERObject getParameters() {
        return this.params;
    }

    public boolean isImplicitlyCA() {
        return this.params instanceof ASN1Null;
    }

    public boolean isNamedCurve() {
        return this.params instanceof DERObjectIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.params;
    }
}
