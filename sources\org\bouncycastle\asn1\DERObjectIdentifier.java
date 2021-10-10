package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public class DERObjectIdentifier extends ASN1Object {
    String identifier;

    public DERObjectIdentifier(String str) {
        if (isValidIdentifier(str)) {
            this.identifier = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    DERObjectIdentifier(byte[] bArr) {
        BigInteger bigInteger;
        long j;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        boolean z = true;
        int i2 = 0;
        long j2 = 0;
        BigInteger bigInteger2 = null;
        while (i2 != bArr.length) {
            int i3 = bArr[i2] & UByte.MAX_VALUE;
            if (j2 < 36028797018963968L) {
                j2 = (j2 * 128) + ((long) (i3 & 127));
                if ((i3 & 128) == 0) {
                    if (z) {
                        int i4 = ((int) j2) / 40;
                        if (i4 != 0) {
                            if (i4 != i) {
                                stringBuffer.append('2');
                                j = 80;
                            } else {
                                stringBuffer.append('1');
                                j = 40;
                            }
                            j2 -= j;
                        } else {
                            stringBuffer.append('0');
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    bigInteger = bigInteger2;
                } else {
                    bigInteger = bigInteger2;
                    i2++;
                    bigInteger2 = bigInteger;
                    i = 1;
                }
            } else {
                bigInteger = (bigInteger2 == null ? BigInteger.valueOf(j2) : bigInteger2).shiftLeft(7).or(BigInteger.valueOf((long) (i3 & 127)));
                if ((i3 & 128) == 0) {
                    stringBuffer.append('.');
                    stringBuffer.append(bigInteger);
                    bigInteger = null;
                } else {
                    i2++;
                    bigInteger2 = bigInteger;
                    i = 1;
                }
            }
            j2 = 0;
            i2++;
            bigInteger2 = bigInteger;
            i = 1;
        }
        this.identifier = stringBuffer.toString();
    }

    public static DERObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof DERObjectIdentifier)) {
            return (DERObjectIdentifier) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DERObjectIdentifier)) ? getInstance(object) : new ASN1ObjectIdentifier(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
    }

    private static boolean isValidIdentifier(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        boolean z = false;
        for (int length = str.length() - 1; length >= 2; length--) {
            char charAt2 = str.charAt(length);
            if ('0' <= charAt2 && charAt2 <= '9') {
                z = true;
            } else if (charAt2 != '.' || !z) {
                return false;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void writeField(OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        outputStream.write(bArr, i, 9 - i);
    }

    private void writeField(OutputStream outputStream, BigInteger bigInteger) throws IOException {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            outputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & ByteCompanionObject.MAX_VALUE);
        outputStream.write(bArr);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((DERObjectIdentifier) dERObject).identifier);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream2 = new DEROutputStream(byteArrayOutputStream);
        long parseInt = (long) ((Integer.parseInt(oIDTokenizer.nextToken()) * 40) + Integer.parseInt(oIDTokenizer.nextToken()));
        while (true) {
            writeField(byteArrayOutputStream, parseInt);
            while (oIDTokenizer.hasMoreTokens()) {
                String nextToken = oIDTokenizer.nextToken();
                if (nextToken.length() < 18) {
                    parseInt = Long.parseLong(nextToken);
                } else {
                    writeField(byteArrayOutputStream, new BigInteger(nextToken));
                }
            }
            dEROutputStream2.close();
            dEROutputStream.writeEncoded(6, byteArrayOutputStream.toByteArray());
            return;
        }
    }

    public String getId() {
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    public String toString() {
        return getId();
    }
}
