package org.bouncycastle.openpgp;

public class PGPException extends Exception {
    Exception underlying;

    public PGPException(String str) {
        super(str);
    }

    public PGPException(String str, Exception exc) {
        super(str);
        this.underlying = exc;
    }

    public Throwable getCause() {
        return this.underlying;
    }

    public Exception getUnderlyingException() {
        return this.underlying;
    }
}
