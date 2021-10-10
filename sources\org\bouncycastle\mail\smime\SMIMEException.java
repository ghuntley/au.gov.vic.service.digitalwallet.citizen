package org.bouncycastle.mail.smime;

public class SMIMEException extends Exception {
    Exception e;

    public SMIMEException(String str) {
        super(str);
    }

    public SMIMEException(String str, Exception exc) {
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
