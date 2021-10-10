package com.nimbusds.jose.crypto.factories;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.KeyTypeException;
import com.nimbusds.jose.crypto.AESDecrypter;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.ECDHDecrypter;
import com.nimbusds.jose.crypto.PasswordBasedDecrypter;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.jca.JWEJCAContext;
import com.nimbusds.jose.proc.JWEDecrypterFactory;
import java.security.Key;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DefaultJWEDecrypterFactory implements JWEDecrypterFactory {
    public static final Set<JWEAlgorithm> SUPPORTED_ALGORITHMS;
    public static final Set<EncryptionMethod> SUPPORTED_ENCRYPTION_METHODS;
    private final JWEJCAContext jcaContext = new JWEJCAContext();

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(RSADecrypter.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(ECDHDecrypter.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(DirectDecrypter.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(AESDecrypter.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(PasswordBasedDecrypter.SUPPORTED_ALGORITHMS);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.addAll(RSADecrypter.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(ECDHDecrypter.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(DirectDecrypter.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(AESDecrypter.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(PasswordBasedDecrypter.SUPPORTED_ENCRYPTION_METHODS);
        SUPPORTED_ENCRYPTION_METHODS = Collections.unmodifiableSet(linkedHashSet2);
    }

    @Override // com.nimbusds.jose.JWEProvider
    public Set<JWEAlgorithm> supportedJWEAlgorithms() {
        return SUPPORTED_ALGORITHMS;
    }

    @Override // com.nimbusds.jose.JWEProvider
    public Set<EncryptionMethod> supportedEncryptionMethods() {
        return SUPPORTED_ENCRYPTION_METHODS;
    }

    @Override // com.nimbusds.jose.jca.JCAAware
    public JWEJCAContext getJCAContext() {
        return this.jcaContext;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v29, resolved type: com.nimbusds.jose.crypto.DirectDecrypter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nimbusds.jose.proc.JWEDecrypterFactory
    public JWEDecrypter createJWEDecrypter(JWEHeader jWEHeader, Key key) throws JOSEException {
        JWEDecrypter jWEDecrypter;
        AESDecrypter aESDecrypter;
        if (!RSADecrypter.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) || !RSADecrypter.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
            if (!ECDHDecrypter.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) || !ECDHDecrypter.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
                if (!DirectDecrypter.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) || !DirectDecrypter.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
                    if (!AESDecrypter.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) || !AESDecrypter.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
                        if (!PasswordBasedDecrypter.SUPPORTED_ALGORITHMS.contains(jWEHeader.getAlgorithm()) || !PasswordBasedDecrypter.SUPPORTED_ENCRYPTION_METHODS.contains(jWEHeader.getEncryptionMethod())) {
                            throw new JOSEException("Unsupported JWE algorithm or encryption method");
                        } else if (key instanceof SecretKey) {
                            jWEDecrypter = new PasswordBasedDecrypter(key.getEncoded());
                        } else {
                            throw new KeyTypeException(SecretKey.class);
                        }
                    } else if (key instanceof SecretKey) {
                        AESDecrypter aESDecrypter2 = new AESDecrypter((SecretKey) key);
                        boolean contains = aESDecrypter2.supportedJWEAlgorithms().contains(jWEHeader.getAlgorithm());
                        aESDecrypter = aESDecrypter2;
                        if (!contains) {
                            throw new KeyLengthException(jWEHeader.getAlgorithm());
                        }
                    } else {
                        throw new KeyTypeException(SecretKey.class);
                    }
                } else if (key instanceof SecretKey) {
                    DirectDecrypter directDecrypter = new DirectDecrypter((SecretKey) key);
                    boolean contains2 = directDecrypter.supportedEncryptionMethods().contains(jWEHeader.getEncryptionMethod());
                    aESDecrypter = directDecrypter;
                    if (!contains2) {
                        throw new KeyLengthException(jWEHeader.getEncryptionMethod().cekBitLength(), jWEHeader.getEncryptionMethod());
                    }
                } else {
                    throw new KeyTypeException(SecretKey.class);
                }
                jWEDecrypter = aESDecrypter;
            } else if (key instanceof ECPrivateKey) {
                jWEDecrypter = new ECDHDecrypter((ECPrivateKey) key);
            } else {
                throw new KeyTypeException(ECPrivateKey.class);
            }
        } else if (key instanceof RSAPrivateKey) {
            jWEDecrypter = new RSADecrypter((RSAPrivateKey) key);
        } else {
            throw new KeyTypeException(RSAPrivateKey.class);
        }
        ((JWEJCAContext) jWEDecrypter.getJCAContext()).setSecureRandom(this.jcaContext.getSecureRandom());
        ((JWEJCAContext) jWEDecrypter.getJCAContext()).setProvider(this.jcaContext.getProvider());
        ((JWEJCAContext) jWEDecrypter.getJCAContext()).setKeyEncryptionProvider(this.jcaContext.getKeyEncryptionProvider());
        ((JWEJCAContext) jWEDecrypter.getJCAContext()).setMACProvider(this.jcaContext.getMACProvider());
        ((JWEJCAContext) jWEDecrypter.getJCAContext()).setContentEncryptionProvider(this.jcaContext.getContentEncryptionProvider());
        return jWEDecrypter;
    }
}
