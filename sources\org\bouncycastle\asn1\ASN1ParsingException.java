package org.bouncycastle.asn1;

public class ASN1ParsingException extends IllegalStateException {
    private Throwable cause;

    ASN1ParsingException(String str) {
        super(str);
    }

    ASN1ParsingException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
