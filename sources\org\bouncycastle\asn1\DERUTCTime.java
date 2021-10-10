package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import kotlin.UByte;

public class DERUTCTime extends ASN1Object {
    String time;

    public DERUTCTime(String str) {
        this.time = str;
        try {
            getDate();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    public DERUTCTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = simpleDateFormat.format(date);
    }

    DERUTCTime(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & UByte.MAX_VALUE);
        }
        this.time = new String(cArr);
    }

    public static DERUTCTime getInstance(Object obj) {
        if (obj == null || (obj instanceof DERUTCTime)) {
            return (DERUTCTime) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERUTCTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DERUTCTime)) ? getInstance(object) : new DERUTCTime(((ASN1OctetString) object).getOctets());
    }

    private byte[] getOctets() {
        char[] charArray = this.time.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i = 0; i != charArray.length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERUTCTime)) {
            return false;
        }
        return this.time.equals(((DERUTCTime) dERObject).time);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(23, getOctets());
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat.parse(getAdjustedTime());
    }

    public String getAdjustedTime() {
        StringBuilder sb;
        String str;
        String time2 = getTime();
        if (time2.charAt(0) < '5') {
            sb = new StringBuilder();
            str = "20";
        } else {
            sb = new StringBuilder();
            str = "19";
        }
        sb.append(str);
        sb.append(time2);
        return sb.toString();
    }

    public Date getDate() throws ParseException {
        return new SimpleDateFormat("yyMMddHHmmssz").parse(getTime());
    }

    public String getTime() {
        StringBuilder sb;
        String substring;
        if (this.time.indexOf(45) >= 0 || this.time.indexOf(43) >= 0) {
            int indexOf = this.time.indexOf(45);
            if (indexOf < 0) {
                indexOf = this.time.indexOf(43);
            }
            String str = this.time;
            if (indexOf == str.length() - 3) {
                str = str + "00";
            }
            if (indexOf == 10) {
                sb = new StringBuilder();
                sb.append(str.substring(0, 10));
                sb.append("00GMT");
                sb.append(str.substring(10, 13));
                sb.append(":");
                substring = str.substring(13, 15);
            } else {
                sb = new StringBuilder();
                sb.append(str.substring(0, 12));
                sb.append("GMT");
                sb.append(str.substring(12, 15));
                sb.append(":");
                substring = str.substring(15, 17);
            }
        } else if (this.time.length() == 11) {
            sb = new StringBuilder();
            sb.append(this.time.substring(0, 10));
            substring = "00GMT+00:00";
        } else {
            sb = new StringBuilder();
            sb.append(this.time.substring(0, 12));
            substring = "GMT+00:00";
        }
        sb.append(substring);
        return sb.toString();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.time.hashCode();
    }

    public String toString() {
        return this.time;
    }
}
