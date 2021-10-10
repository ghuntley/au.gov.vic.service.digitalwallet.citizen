package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;

public abstract class DefaultTlsClient implements TlsClient {
    protected TlsCipherFactory cipherFactory;
    protected TlsClientContext context;
    protected int selectedCipherSuite;
    protected int selectedCompressionMethod;

    public DefaultTlsClient() {
        this(new DefaultTlsCipherFactory());
    }

    public DefaultTlsClient(TlsCipherFactory tlsCipherFactory) {
        this.cipherFactory = tlsCipherFactory;
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createDHEKeyExchange(int i) {
        return new TlsDHEKeyExchange(this.context, i);
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createDHKeyExchange(int i) {
        return new TlsDHKeyExchange(this.context, i);
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createECDHEKeyExchange(int i) {
        return new TlsECDHEKeyExchange(this.context, i);
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createECDHKeyExchange(int i) {
        return new TlsECDHKeyExchange(this.context, i);
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createRSAKeyExchange() {
        return new TlsRSAKeyExchange(this.context);
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public TlsCipher getCipher() throws IOException {
        TlsCipherFactory tlsCipherFactory;
        TlsClientContext tlsClientContext;
        int i;
        int i2 = this.selectedCipherSuite;
        if (!(i2 == 10 || i2 == 13 || i2 == 16 || i2 == 19 || i2 == 22)) {
            switch (i2) {
                default:
                    switch (i2) {
                        default:
                            switch (i2) {
                                case CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA:
                                    break;
                                case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA:
                                    break;
                                case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA:
                                    break;
                                default:
                                    switch (i2) {
                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA:
                                            break;
                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA:
                                            break;
                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA:
                                            break;
                                        default:
                                            switch (i2) {
                                                case CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA:
                                                    break;
                                                case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA:
                                                    break;
                                                case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA:
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA:
                                                            break;
                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA:
                                                            break;
                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA:
                                                            break;
                                                        default:
                                                            throw new TlsFatalAlert(80);
                                                    }
                                            }
                                    }
                            }
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            tlsCipherFactory = this.cipherFactory;
                            tlsClientContext = this.context;
                            i = 9;
                            break;
                    }
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                    tlsCipherFactory = this.cipherFactory;
                    tlsClientContext = this.context;
                    i = 8;
                    break;
            }
            return tlsCipherFactory.createCipher(tlsClientContext, i, 2);
        }
        tlsCipherFactory = this.cipherFactory;
        tlsClientContext = this.context;
        i = 7;
        return tlsCipherFactory.createCipher(tlsClientContext, i, 2);
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public int[] getCipherSuites() {
        return new int[]{57, 56, 51, 50, 22, 19, 53, 47, 10};
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public Hashtable getClientExtensions() {
        return null;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public TlsCompression getCompression() throws IOException {
        if (this.selectedCompressionMethod == 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert(80);
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public short[] getCompressionMethods() {
        return new short[]{0};
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public TlsKeyExchange getKeyExchange() throws IOException {
        int i = this.selectedCipherSuite;
        if (i != 10) {
            if (i != 13) {
                if (i != 16) {
                    if (i != 19) {
                        if (i != 22) {
                            switch (i) {
                                case 47:
                                    break;
                                case 48:
                                    break;
                                case 49:
                                    break;
                                case 50:
                                    break;
                                case 51:
                                    break;
                                default:
                                    switch (i) {
                                        case 53:
                                            break;
                                        case 54:
                                            break;
                                        case 55:
                                            break;
                                        case 56:
                                            break;
                                        case 57:
                                            break;
                                        default:
                                            switch (i) {
                                                case CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA:
                                                case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA:
                                                case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA:
                                                    return createECDHKeyExchange(16);
                                                default:
                                                    switch (i) {
                                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA:
                                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA:
                                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA:
                                                            return createECDHEKeyExchange(17);
                                                        default:
                                                            switch (i) {
                                                                case CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA:
                                                                case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA:
                                                                case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA:
                                                                    return createECDHKeyExchange(18);
                                                                default:
                                                                    switch (i) {
                                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA:
                                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA:
                                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA:
                                                                            return createECDHEKeyExchange(19);
                                                                        default:
                                                                            throw new TlsFatalAlert(80);
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                        }
                        return createDHEKeyExchange(5);
                    }
                    return createDHEKeyExchange(3);
                }
                return createDHKeyExchange(9);
            }
            return createDHKeyExchange(7);
        }
        return createRSAKeyExchange();
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifySecureRenegotiation(boolean z) throws IOException {
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifySelectedCipherSuite(int i) {
        this.selectedCipherSuite = i;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifySelectedCompressionMethod(short s) {
        this.selectedCompressionMethod = s;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifySessionID(byte[] bArr) {
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void processServerExtensions(Hashtable hashtable) {
    }
}
