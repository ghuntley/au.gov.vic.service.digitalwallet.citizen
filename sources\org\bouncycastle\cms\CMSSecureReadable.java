package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.security.Provider;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* access modifiers changed from: package-private */
public interface CMSSecureReadable {
    AlgorithmIdentifier getAlgorithm();

    Object getCryptoObject();

    InputStream getInputStream() throws IOException, CMSException;

    CMSReadable getReadable(SecretKey secretKey, Provider provider) throws CMSException;
}
