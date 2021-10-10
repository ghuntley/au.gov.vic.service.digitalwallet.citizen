package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1TaggedObject extends ASN1Object implements ASN1TaggedObjectParser {
    boolean empty;
    boolean explicit;
    DEREncodable obj;
    int tagNo;

    public ASN1TaggedObject(int i, DEREncodable dEREncodable) {
        this.empty = false;
        this.explicit = true;
        this.obj = null;
        this.explicit = true;
        this.tagNo = i;
        this.obj = dEREncodable;
    }

    public ASN1TaggedObject(boolean z, int i, DEREncodable dEREncodable) {
        this.empty = false;
        this.explicit = true;
        this.obj = null;
        if (dEREncodable instanceof ASN1Choice) {
            this.explicit = true;
        } else {
            this.explicit = z;
        }
        this.tagNo = i;
        this.obj = dEREncodable;
    }

    public static ASN1TaggedObject getInstance(Object obj2) {
        if (obj2 == null || (obj2 instanceof ASN1TaggedObject)) {
            return (ASN1TaggedObject) obj2;
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj2.getClass().getName());
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return (ASN1TaggedObject) aSN1TaggedObject.getObject();
        }
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof ASN1TaggedObject)) {
            return false;
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) dERObject;
        if (this.tagNo != aSN1TaggedObject.tagNo || this.empty != aSN1TaggedObject.empty || this.explicit != aSN1TaggedObject.explicit) {
            return false;
        }
        DEREncodable dEREncodable = this.obj;
        return dEREncodable == null ? aSN1TaggedObject.obj == null : dEREncodable.getDERObject().equals(aSN1TaggedObject.obj.getDERObject());
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public abstract void encode(DEROutputStream dEROutputStream) throws IOException;

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public DERObject getLoadedObject() {
        return getDERObject();
    }

    public DERObject getObject() {
        DEREncodable dEREncodable = this.obj;
        if (dEREncodable != null) {
            return dEREncodable.getDERObject();
        }
        return null;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public DEREncodable getObjectParser(int i, boolean z) {
        if (i == 4) {
            return ASN1OctetString.getInstance(this, z).parser();
        }
        if (i == 16) {
            return ASN1Sequence.getInstance(this, z).parser();
        }
        if (i == 17) {
            return ASN1Set.getInstance(this, z).parser();
        }
        if (z) {
            return getObject();
        }
        throw new RuntimeException("implicit tagging not implemented for tag: " + i);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this.tagNo;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int i = this.tagNo;
        DEREncodable dEREncodable = this.obj;
        return dEREncodable != null ? i ^ dEREncodable.hashCode() : i;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isExplicit() {
        return this.explicit;
    }

    public String toString() {
        return "[" + this.tagNo + "]" + this.obj;
    }
}
