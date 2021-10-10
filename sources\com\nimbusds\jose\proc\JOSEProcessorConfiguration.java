package com.nimbusds.jose.proc;

import com.nimbusds.jose.proc.SecurityContext;

public interface JOSEProcessorConfiguration<C extends SecurityContext> {
    JWEDecrypterFactory getJWEDecrypterFactory();

    JWEKeySelector<C> getJWEKeySelector();

    JOSEObjectTypeVerifier<C> getJWETypeVerifier();

    JWSKeySelector<C> getJWSKeySelector();

    JOSEObjectTypeVerifier<C> getJWSTypeVerifier();

    JWSVerifierFactory getJWSVerifierFactory();

    void setJWEDecrypterFactory(JWEDecrypterFactory jWEDecrypterFactory);

    void setJWEKeySelector(JWEKeySelector<C> jWEKeySelector);

    void setJWETypeVerifier(JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier);

    void setJWSKeySelector(JWSKeySelector<C> jWSKeySelector);

    void setJWSTypeVerifier(JOSEObjectTypeVerifier<C> jOSEObjectTypeVerifier);

    void setJWSVerifierFactory(JWSVerifierFactory jWSVerifierFactory);
}
