package org.bouncycastle.asn1;

import java.io.IOException;
import kotlin.UByte;

public class DERBMPString extends ASN1Object implements DERString {
    String string;

    public DERBMPString(String str) {
        this.string = str;
    }

    public DERBMPString(byte[] bArr) {
        int length = bArr.length / 2;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            int i2 = i * 2;
            cArr[i] = (char) ((bArr[i2 + 1] & UByte.MAX_VALUE) | (bArr[i2] << 8));
        }
        this.string = new String(cArr);
    }

    public static DERBMPString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBMPString)) {
            return (DERBMPString) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERBMPString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DERBMPString)) ? getInstance(object) : new DERBMPString(ASN1OctetString.getInstance(object).getOctets());
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERBMPString)) {
            return false;
        }
        return getString().equals(((DERBMPString) dERObject).getString());
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        char[] charArray = this.string.toCharArray();
        byte[] bArr = new byte[(charArray.length * 2)];
        for (int i = 0; i != charArray.length; i++) {
            int i2 = i * 2;
            bArr[i2] = (byte) (charArray[i] >> '\b');
            bArr[i2 + 1] = (byte) charArray[i];
        }
        dEROutputStream.writeEncoded(30, bArr);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public String getString() {
        return this.string;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return getString().hashCode();
    }

    public String toString() {
        return this.string;
    }
}
