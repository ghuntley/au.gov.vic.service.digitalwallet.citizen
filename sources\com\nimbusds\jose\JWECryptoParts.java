package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import net.jcip.annotations.Immutable;

@Immutable
public final class JWECryptoParts {
    private final Base64URL authenticationTag;
    private final Base64URL cipherText;
    private final Base64URL encryptedKey;
    private final JWEHeader header;
    private final Base64URL iv;

    public JWECryptoParts(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) {
        this(null, base64URL, base64URL2, base64URL3, base64URL4);
    }

    public JWECryptoParts(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) {
        this.header = jWEHeader;
        this.encryptedKey = base64URL;
        this.iv = base64URL2;
        if (base64URL3 != null) {
            this.cipherText = base64URL3;
            this.authenticationTag = base64URL4;
            return;
        }
        throw new IllegalArgumentException("The cipher text must not be null");
    }

    public JWEHeader getHeader() {
        return this.header;
    }

    public Base64URL getEncryptedKey() {
        return this.encryptedKey;
    }

    public Base64URL getInitializationVector() {
        return this.iv;
    }

    public Base64URL getCipherText() {
        return this.cipherText;
    }

    public Base64URL getAuthenticationTag() {
        return this.authenticationTag;
    }
}
