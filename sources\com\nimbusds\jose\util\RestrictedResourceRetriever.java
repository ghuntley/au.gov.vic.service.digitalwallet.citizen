package com.nimbusds.jose.util;

public interface RestrictedResourceRetriever extends ResourceRetriever {
    int getConnectTimeout();

    int getReadTimeout();

    int getSizeLimit();

    void setConnectTimeout(int i);

    void setReadTimeout(int i);

    void setSizeLimit(int i);
}
