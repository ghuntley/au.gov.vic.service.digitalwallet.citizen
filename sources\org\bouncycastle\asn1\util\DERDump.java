package org.bouncycastle.asn1.util;

import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;

public class DERDump extends ASN1Dump {
    public static String dumpAsString(DEREncodable dEREncodable) {
        StringBuffer stringBuffer = new StringBuffer();
        _dumpAsString("", false, dEREncodable.getDERObject(), stringBuffer);
        return stringBuffer.toString();
    }

    public static String dumpAsString(DERObject dERObject) {
        StringBuffer stringBuffer = new StringBuffer();
        _dumpAsString("", false, dERObject, stringBuffer);
        return stringBuffer.toString();
    }
}
