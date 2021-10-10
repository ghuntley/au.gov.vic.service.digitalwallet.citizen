package com.nimbusds.jose.proc;

public class BadJOSEException extends Exception {
    public BadJOSEException(String str) {
        super(str);
    }

    public BadJOSEException(String str, Throwable th) {
        super(str, th);
    }
}
