package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import kotlin.UByte;
import net.openid.appauth.AuthState;

public class DERGeneralizedTime extends ASN1Object {
    String time;

    public DERGeneralizedTime(String str) {
        this.time = str;
        try {
            getDate();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    public DERGeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = simpleDateFormat.format(date);
    }

    DERGeneralizedTime(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & UByte.MAX_VALUE);
        }
        this.time = new String(cArr);
    }

    private String calculateGMTOffset() {
        String str;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = "+";
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * 1000)) / AuthState.EXPIRY_TIME_TOLERANCE_MS;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(getDate())) {
                i += str.equals("+") ? 1 : -1;
            }
        } catch (ParseException unused) {
        }
        return "GMT" + str + convert(i) + ":" + convert(i2);
    }

    private String convert(int i) {
        if (i >= 10) {
            return Integer.toString(i);
        }
        return "0" + i;
    }

    public static DERGeneralizedTime getInstance(Object obj) {
        if (obj == null || (obj instanceof DERGeneralizedTime)) {
            return (DERGeneralizedTime) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERGeneralizedTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DERGeneralizedTime)) ? getInstance(object) : new DERGeneralizedTime(((ASN1OctetString) object).getOctets());
    }

    private byte[] getOctets() {
        char[] charArray = this.time.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i = 0; i != charArray.length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    private boolean hasFractionalSeconds() {
        return this.time.indexOf(46) == 14;
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.ASN1Object
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERGeneralizedTime)) {
            return false;
        }
        return this.time.equals(((DERGeneralizedTime) dERObject).time);
    }

    /* access modifiers changed from: package-private */
    @Override // org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(24, getOctets());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    public Date getDate() throws ParseException {
        SimpleDateFormat simpleDateFormat;
        String str;
        StringBuilder sb;
        SimpleTimeZone simpleTimeZone;
        String str2 = this.time;
        if (str2.endsWith("Z")) {
            simpleDateFormat = hasFractionalSeconds() ? new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'") : new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            simpleTimeZone = new SimpleTimeZone(0, "Z");
        } else if (this.time.indexOf(45) > 0 || this.time.indexOf(43) > 0) {
            str2 = getTime();
            simpleDateFormat = hasFractionalSeconds() ? new SimpleDateFormat("yyyyMMddHHmmss.SSSz") : new SimpleDateFormat("yyyyMMddHHmmssz");
            simpleTimeZone = new SimpleTimeZone(0, "Z");
        } else {
            simpleDateFormat = hasFractionalSeconds() ? new SimpleDateFormat("yyyyMMddHHmmss.SSS") : new SimpleDateFormat("yyyyMMddHHmmss");
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
            if (hasFractionalSeconds()) {
                String substring = str2.substring(14);
                int i = 1;
                while (i < substring.length() && '0' <= (r7 = substring.charAt(i)) && r7 <= '9') {
                    i++;
                }
                int i2 = i - 1;
                if (i2 > 3) {
                    str = substring.substring(0, 4) + substring.substring(i);
                    sb = new StringBuilder();
                } else if (i2 == 1) {
                    str = substring.substring(0, i) + "00" + substring.substring(i);
                    sb = new StringBuilder();
                } else if (i2 == 2) {
                    str = substring.substring(0, i) + "0" + substring.substring(i);
                    sb = new StringBuilder();
                }
                sb.append(str2.substring(0, 14));
                sb.append(str);
                str2 = sb.toString();
            }
            return simpleDateFormat.parse(str2);
        }
        simpleDateFormat.setTimeZone(simpleTimeZone);
        if (hasFractionalSeconds()) {
        }
        return simpleDateFormat.parse(str2);
    }

    public String getTime() {
        String str = this.time;
        if (str.charAt(str.length() - 1) == 'Z') {
            StringBuilder sb = new StringBuilder();
            String str2 = this.time;
            sb.append(str2.substring(0, str2.length() - 1));
            sb.append("GMT+00:00");
            return sb.toString();
        }
        int length = this.time.length() - 5;
        char charAt = this.time.charAt(length);
        if (charAt == '-' || charAt == '+') {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.time.substring(0, length));
            sb2.append("GMT");
            int i = length + 3;
            sb2.append(this.time.substring(length, i));
            sb2.append(":");
            sb2.append(this.time.substring(i));
            return sb2.toString();
        }
        int length2 = this.time.length() - 3;
        char charAt2 = this.time.charAt(length2);
        if (charAt2 == '-' || charAt2 == '+') {
            return this.time.substring(0, length2) + "GMT" + this.time.substring(length2) + ":00";
        }
        return this.time + calculateGMTOffset();
    }

    public String getTimeString() {
        return this.time;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable, org.bouncycastle.asn1.DERObject, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.time.hashCode();
    }
}
