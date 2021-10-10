package com.nimbusds.jose.proc;

public class BadJWSException extends BadJOSEException {
    public BadJWSException(String str) {
        super(str);
    }

    public BadJWSException(String str, Throwable th) {
        super(str, th);
    }
}
