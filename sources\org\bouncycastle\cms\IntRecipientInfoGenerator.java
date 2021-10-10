package org.bouncycastle.cms;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.cms.RecipientInfo;

/* access modifiers changed from: package-private */
public interface IntRecipientInfoGenerator {
    RecipientInfo generate(SecretKey secretKey, SecureRandom secureRandom, Provider provider) throws GeneralSecurityException;
}
