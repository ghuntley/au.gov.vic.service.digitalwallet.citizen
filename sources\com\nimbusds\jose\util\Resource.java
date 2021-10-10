package com.nimbusds.jose.util;

import net.jcip.annotations.Immutable;

@Immutable
public class Resource {
    private final String content;
    private final String contentType;

    public Resource(String str, String str2) {
        if (str != null) {
            this.content = str;
            this.contentType = str2;
            return;
        }
        throw new IllegalArgumentException("The resource content must not be null");
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }
}
