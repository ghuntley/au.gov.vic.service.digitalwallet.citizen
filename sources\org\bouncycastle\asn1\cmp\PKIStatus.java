package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;

public class PKIStatus extends ASN1Encodable {
    public static final int GRANTED = 0;
    public static final int GRANTED_WITH_MODS = 1;
    public static final int KEY_UPDATE_WARNING = 6;
    public static final int REJECTION = 2;
    public static final int REVOCATION_NOTIFICATION = 5;
    public static final int REVOCATION_WARNING = 4;
    public static final int WAITING = 3;
    public static final PKIStatus granted = new PKIStatus(0);
    public static final PKIStatus grantedWithMods = new PKIStatus(1);
    public static final PKIStatus keyUpdateWaiting = new PKIStatus(6);
    public static final PKIStatus rejection = new PKIStatus(2);
    public static final PKIStatus revocationNotification = new PKIStatus(5);
    public static final PKIStatus revocationWarning = new PKIStatus(4);
    public static final PKIStatus waiting = new PKIStatus(3);
    private DERInteger value;

    private PKIStatus(int i) {
        this(new DERInteger(i));
    }

    private PKIStatus(DERInteger dERInteger) {
        this.value = dERInteger;
    }

    public static PKIStatus getInstance(Object obj) {
        if (obj instanceof PKIStatus) {
            return (PKIStatus) obj;
        }
        if (obj instanceof DERInteger) {
            return new PKIStatus((DERInteger) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public DERObject toASN1Object() {
        return this.value;
    }
}
