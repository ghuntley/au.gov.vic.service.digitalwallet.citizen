package org.bouncycastle.ocsp;

public class OCSPException extends Exception {
    Exception e;

    public OCSPException(String str) {
        super(str);
    }

    public OCSPException(String str, Exception exc) {
        super(str);
        this.e = exc;
    }

    public Throwable getCause() {
        return this.e;
    }

    public Exception getUnderlyingException() {
        return this.e;
    }
}
