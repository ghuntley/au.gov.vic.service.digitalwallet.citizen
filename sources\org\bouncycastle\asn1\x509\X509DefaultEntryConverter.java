package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;

public class X509DefaultEntryConverter extends X509NameEntryConverter {
    @Override // org.bouncycastle.asn1.x509.X509NameEntryConverter
    public DERObject getConvertedValue(DERObjectIdentifier dERObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return (dERObjectIdentifier.equals(X509Name.EmailAddress) || dERObjectIdentifier.equals(X509Name.DC)) ? new DERIA5String(str) : dERObjectIdentifier.equals(X509Name.DATE_OF_BIRTH) ? new DERGeneralizedTime(str) : (dERObjectIdentifier.equals(X509Name.C) || dERObjectIdentifier.equals(X509Name.SN) || dERObjectIdentifier.equals(X509Name.DN_QUALIFIER) || dERObjectIdentifier.equals(X509Name.TELEPHONE_NUMBER)) ? new DERPrintableString(str) : new DERUTF8String(str);
        }
        try {
            return convertHexEncoded(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + dERObjectIdentifier.getId());
        }
    }
}
