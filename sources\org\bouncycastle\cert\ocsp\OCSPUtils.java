package org.bouncycastle.cert.ocsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.cert.X509CertificateHolder;

class OCSPUtils {
    static final X509CertificateHolder[] EMPTY_CERTS = new X509CertificateHolder[0];
    static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());

    OCSPUtils() {
    }

    static Date extractDate(DERGeneralizedTime dERGeneralizedTime) {
        try {
            return dERGeneralizedTime.getDate();
        } catch (Exception e) {
            throw new IllegalStateException("exception processing GeneralizedTime: " + e.getMessage());
        }
    }

    static Set getCriticalExtensionOIDs(X509Extensions x509Extensions) {
        return x509Extensions == null ? EMPTY_SET : Collections.unmodifiableSet(new HashSet(Arrays.asList(x509Extensions.getCriticalExtensionOIDs())));
    }

    static List getExtensionOIDs(X509Extensions x509Extensions) {
        return x509Extensions == null ? EMPTY_LIST : Collections.unmodifiableList(Arrays.asList(x509Extensions.getExtensionOIDs()));
    }

    static Set getNonCriticalExtensionOIDs(X509Extensions x509Extensions) {
        return x509Extensions == null ? EMPTY_SET : Collections.unmodifiableSet(new HashSet(Arrays.asList(x509Extensions.getNonCriticalExtensionOIDs())));
    }
}
