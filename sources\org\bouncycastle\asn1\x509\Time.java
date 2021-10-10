package org.bouncycastle.asn1.x509;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERUTCTime;

public class Time extends ASN1Encodable implements ASN1Choice {
    DERObject time;

    public Time(Date date) {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int parseInt = Integer.parseInt(str.substring(0, 4));
        this.time = (parseInt < 1950 || parseInt > 2049) ? new DERGeneralizedTime(str) : new DERUTCTime(str.substring(2));
    }

    public Time(DERObject dERObject) {
        if ((dERObject instanceof DERUTCTime) || (dERObject instanceof DERGeneralizedTime)) {
            this.time = dERObject;
            return;
        }
        throw new IllegalArgumentException("unknown object passed to Time");
    }

    public static Time getInstance(Object obj) {
        if (obj == null || (obj instanceof Time)) {
            return (Time) obj;
        }
        if (obj instanceof DERUTCTime) {
            return new Time((DERUTCTime) obj);
        }
        if (obj instanceof DERGeneralizedTime) {
            return new Time((DERGeneralizedTime) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static Time getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public Date getDate() {
        try {
            DERObject dERObject = this.time;
            return dERObject instanceof DERUTCTime ? ((DERUTCTime) dERObject).getAdjustedDate() : ((DERGeneralizedTime) dERObject).getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("invalid date string: " + e.getMessage());
        }
    }

    public String getTime() {
        DERObject dERObject = this.time;
        return dERObject instanceof DERUTCTime ? ((DERUTCTime) dERObject).getAdjustedTime() : ((DERGeneralizedTime) dERObject).getTime();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.time;
    }

    public String toString() {
        return getTime();
    }
}
