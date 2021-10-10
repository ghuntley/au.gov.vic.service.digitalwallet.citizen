package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.Key;
import java.util.List;

public interface JWEKeySelector<C extends SecurityContext> {
    List<? extends Key> selectJWEKeys(JWEHeader jWEHeader, C c) throws KeySourceException;
}
