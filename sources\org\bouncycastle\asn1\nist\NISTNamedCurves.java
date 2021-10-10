package org.bouncycastle.asn1.nist;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.util.Strings;

public class NISTNamedCurves {
    static final Hashtable names = new Hashtable();
    static final Hashtable objIds = new Hashtable();

    static {
        defineCurve("B-571", SECObjectIdentifiers.sect571r1);
        defineCurve("B-409", SECObjectIdentifiers.sect409r1);
        defineCurve("B-283", SECObjectIdentifiers.sect283r1);
        defineCurve("B-233", SECObjectIdentifiers.sect233r1);
        defineCurve("B-163", SECObjectIdentifiers.sect163r2);
        defineCurve("P-521", SECObjectIdentifiers.secp521r1);
        defineCurve("P-384", SECObjectIdentifiers.secp384r1);
        defineCurve("P-256", SECObjectIdentifiers.secp256r1);
        defineCurve("P-224", SECObjectIdentifiers.secp224r1);
        defineCurve("P-192", SECObjectIdentifiers.secp192r1);
    }

    static void defineCurve(String str, DERObjectIdentifier dERObjectIdentifier) {
        objIds.put(str, dERObjectIdentifier);
        names.put(dERObjectIdentifier, str);
    }

    public static X9ECParameters getByName(String str) {
        DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) objIds.get(Strings.toUpperCase(str));
        if (dERObjectIdentifier != null) {
            return getByOID(dERObjectIdentifier);
        }
        return null;
    }

    public static X9ECParameters getByOID(DERObjectIdentifier dERObjectIdentifier) {
        return SECNamedCurves.getByOID(dERObjectIdentifier);
    }

    public static String getName(DERObjectIdentifier dERObjectIdentifier) {
        return (String) names.get(dERObjectIdentifier);
    }

    public static Enumeration getNames() {
        return objIds.keys();
    }

    public static DERObjectIdentifier getOID(String str) {
        return (DERObjectIdentifier) objIds.get(Strings.toUpperCase(str));
    }
}
