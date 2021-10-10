package com.nimbusds.jose.util;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public abstract class AbstractRestrictedResourceRetriever implements RestrictedResourceRetriever {
    private int connectTimeout;
    private int readTimeout;
    private int sizeLimit;

    public AbstractRestrictedResourceRetriever(int i, int i2, int i3) {
        setConnectTimeout(i);
        setReadTimeout(i2);
        setSizeLimit(i3);
    }

    @Override // com.nimbusds.jose.util.RestrictedResourceRetriever
    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    @Override // com.nimbusds.jose.util.RestrictedResourceRetriever
    public void setConnectTimeout(int i) {
        if (i >= 0) {
            this.connectTimeout = i;
            return;
        }
        throw new IllegalArgumentException("The connect timeout must not be negative");
    }

    @Override // com.nimbusds.jose.util.RestrictedResourceRetriever
    public int getReadTimeout() {
        return this.readTimeout;
    }

    @Override // com.nimbusds.jose.util.RestrictedResourceRetriever
    public void setReadTimeout(int i) {
        if (i >= 0) {
            this.readTimeout = i;
            return;
        }
        throw new IllegalArgumentException("The read timeout must not be negative");
    }

    @Override // com.nimbusds.jose.util.RestrictedResourceRetriever
    public int getSizeLimit() {
        return this.sizeLimit;
    }

    @Override // com.nimbusds.jose.util.RestrictedResourceRetriever
    public void setSizeLimit(int i) {
        if (i >= 0) {
            this.sizeLimit = i;
            return;
        }
        throw new IllegalArgumentException("The size limit must not be negative");
    }
}
