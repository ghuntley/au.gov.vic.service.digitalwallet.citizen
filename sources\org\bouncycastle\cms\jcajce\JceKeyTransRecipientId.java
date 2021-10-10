package org.bouncycastle.cms.jcajce;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cms.KeyTransRecipientId;

public class JceKeyTransRecipientId extends KeyTransRecipientId {
    public JceKeyTransRecipientId(X509Certificate x509Certificate) {
        this(x509Certificate.getIssuerX500Principal(), x509Certificate.getSerialNumber());
    }

    public JceKeyTransRecipientId(X500Principal x500Principal, BigInteger bigInteger) {
        super(X500Name.getInstance(x500Principal.getEncoded()), bigInteger);
    }
}
