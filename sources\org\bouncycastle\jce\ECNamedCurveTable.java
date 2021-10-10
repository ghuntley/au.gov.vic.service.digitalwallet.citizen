package org.bouncycastle.jce;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

public class ECNamedCurveTable {
    private static void addEnumeration(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }

    public static Enumeration getNames() {
        Vector vector = new Vector();
        addEnumeration(vector, X962NamedCurves.getNames());
        addEnumeration(vector, SECNamedCurves.getNames());
        addEnumeration(vector, NISTNamedCurves.getNames());
        addEnumeration(vector, TeleTrusTNamedCurves.getNames());
        return vector.elements();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r0 = org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves.getByName(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = org.bouncycastle.asn1.sec.SECNamedCurves.getByName(r8);
     */
    public static ECNamedCurveParameterSpec getParameterSpec(String str) {
        X9ECParameters byName = X962NamedCurves.getByName(str);
        if (byName == null) {
            try {
                byName = X962NamedCurves.getByOID(new DERObjectIdentifier(str));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (byName == null && byName == null) {
            try {
                byName = SECNamedCurves.getByOID(new DERObjectIdentifier(str));
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (byName == null && byName == null) {
            try {
                byName = TeleTrusTNamedCurves.getByOID(new DERObjectIdentifier(str));
            } catch (IllegalArgumentException unused3) {
            }
        }
        if (byName == null) {
            byName = NISTNamedCurves.getByName(str);
        }
        if (byName == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(str, byName.getCurve(), byName.getG(), byName.getN(), byName.getH(), byName.getSeed());
    }
}
