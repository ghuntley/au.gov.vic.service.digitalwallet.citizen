package com.nimbusds.jose.proc;

public class BadJWEException extends BadJOSEException {
    public BadJWEException(String str) {
        super(str);
    }

    public BadJWEException(String str, Throwable th) {
        super(str, th);
    }
}
