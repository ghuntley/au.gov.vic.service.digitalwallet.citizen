package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.DERInteger;

public class CRLNumber extends DERInteger {
    public CRLNumber(BigInteger bigInteger) {
        super(bigInteger);
    }

    public BigInteger getCRLNumber() {
        return getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.DERInteger
    public String toString() {
        return "CRLNumber: " + getCRLNumber();
    }
}
