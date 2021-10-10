package com.nimbusds.jwt.proc;

import com.nimbusds.jwt.JWTClaimsSet;

@Deprecated
public interface JWTClaimsVerifier {
    @Deprecated
    void verify(JWTClaimsSet jWTClaimsSet) throws BadJWTException;
}
