package com.nimbusds.jose;

public class KeySourceException extends JOSEException {
    public KeySourceException(String str) {
        super(str);
    }

    public KeySourceException(String str, Throwable th) {
        super(str, th);
    }
}
