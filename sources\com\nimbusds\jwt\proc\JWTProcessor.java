package com.nimbusds.jwt.proc;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.SignedJWT;
import java.text.ParseException;

public interface JWTProcessor<C extends SecurityContext> {
    JWTClaimsSet process(EncryptedJWT encryptedJWT, C c) throws BadJOSEException, JOSEException;

    JWTClaimsSet process(JWT jwt, C c) throws BadJOSEException, JOSEException;

    JWTClaimsSet process(PlainJWT plainJWT, C c) throws BadJOSEException, JOSEException;

    JWTClaimsSet process(SignedJWT signedJWT, C c) throws BadJOSEException, JOSEException;

    JWTClaimsSet process(String str, C c) throws ParseException, BadJOSEException, JOSEException;
}
