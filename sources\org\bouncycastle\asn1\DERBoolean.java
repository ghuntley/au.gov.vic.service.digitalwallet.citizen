package org.bouncycastle.asn1;

import java.io.IOException;

public class DERBoolean extends ASN1Object {
    public static final DERBoolean FALSE = new DERBoolean(false);
    public static final DERBoolean TRUE = new DERBoolean(true);
    byte value;

    public DERBoolean(boolean z) {
        this.value = z ? (byte) -1 : 0;
    }

    public DERBoolean(byte[] bArr) {
        if (bArr.length == 1) {
            this.value = bArr[0];
            return;
        }
        throw new IllegalArgumentException("byte value should have 1 byte in it");
    }

    public static DERBoolean getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBoolean)) {
            return (DERBoolean) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERBoolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DERBoolean)) ? getInstance(object) : new DERBoolean(((ASN1OctetString) object).getOctets());
    }

    public static DERBoolean getInstance(boolean z) {
        return z ? TRUE : FALSE;
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean asn1Equals(DERObject dERObject) {
        return dERObject != null && (dERObject instanceof DERBoolean) && this.value == ((DERBoolean) dERObject).value;
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(1, new byte[]{this.value});
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.value;
    }

    public boolean isTrue() {
        return this.value != 0;
    }

    public String toString() {
        return this.value != 0 ? "TRUE" : "FALSE";
    }
}
