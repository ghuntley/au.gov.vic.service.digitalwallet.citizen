package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;

/* access modifiers changed from: package-private */
public class TlsClientContextImpl implements TlsClientContext {
    private SecureRandom secureRandom;
    private SecurityParameters securityParameters;
    private Object userObject = null;

    TlsClientContextImpl(SecureRandom secureRandom2, SecurityParameters securityParameters2) {
        this.secureRandom = secureRandom2;
        this.securityParameters = securityParameters2;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClientContext
    public SecureRandom getSecureRandom() {
        return this.secureRandom;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClientContext
    public SecurityParameters getSecurityParameters() {
        return this.securityParameters;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClientContext
    public Object getUserObject() {
        return this.userObject;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClientContext
    public void setUserObject(Object obj) {
        this.userObject = obj;
    }
}
