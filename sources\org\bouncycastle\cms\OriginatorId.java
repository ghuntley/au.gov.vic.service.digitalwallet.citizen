package org.bouncycastle.cms;

import java.security.cert.X509CertSelector;
import org.bouncycastle.util.Arrays;

/* access modifiers changed from: package-private */
public class OriginatorId extends X509CertSelector {
    OriginatorId() {
    }

    private boolean equalsObj(Object obj, Object obj2) {
        return obj != null ? obj.equals(obj2) : obj2 == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OriginatorId)) {
            return false;
        }
        OriginatorId originatorId = (OriginatorId) obj;
        return Arrays.areEqual(getSubjectKeyIdentifier(), originatorId.getSubjectKeyIdentifier()) && equalsObj(getSerialNumber(), originatorId.getSerialNumber()) && equalsObj(getIssuerAsString(), originatorId.getIssuerAsString());
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(getSubjectKeyIdentifier());
        if (getSerialNumber() != null) {
            hashCode ^= getSerialNumber().hashCode();
        }
        return getIssuerAsString() != null ? hashCode ^ getIssuerAsString().hashCode() : hashCode;
    }
}
