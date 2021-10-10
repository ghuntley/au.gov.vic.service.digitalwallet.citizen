package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.Header;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEHeader;
import java.util.Collections;
import java.util.Set;

public class CriticalHeaderParamsDeferral {
    private Set<String> deferredParams = Collections.emptySet();

    public Set<String> getProcessedCriticalHeaderParams() {
        return Collections.emptySet();
    }

    public Set<String> getDeferredCriticalHeaderParams() {
        return Collections.unmodifiableSet(this.deferredParams);
    }

    public void setDeferredCriticalHeaderParams(Set<String> set) {
        if (set == null) {
            this.deferredParams = Collections.emptySet();
        } else {
            this.deferredParams = set;
        }
    }

    public boolean headerPasses(Header header) {
        Set<String> criticalParams = header.getCriticalParams();
        if (criticalParams == null || criticalParams.isEmpty()) {
            return true;
        }
        Set<String> set = this.deferredParams;
        if (set == null || !set.containsAll(criticalParams)) {
            return false;
        }
        return true;
    }

    public void ensureHeaderPasses(JWEHeader jWEHeader) throws JOSEException {
        if (!headerPasses(jWEHeader)) {
            throw new JOSEException("Unsupported critical header parameter(s)");
        }
    }
}
