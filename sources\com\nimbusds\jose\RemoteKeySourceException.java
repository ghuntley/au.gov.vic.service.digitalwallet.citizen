package com.nimbusds.jose;

public class RemoteKeySourceException extends KeySourceException {
    public RemoteKeySourceException(String str, Throwable th) {
        super(str, th);
    }
}
