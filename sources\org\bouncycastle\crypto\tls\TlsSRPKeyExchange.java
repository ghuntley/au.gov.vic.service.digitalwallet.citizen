package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.bouncycastle.crypto.agreement.srp.SRP6Util;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.io.SignerInputStream;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.BigIntegers;

class TlsSRPKeyExchange implements TlsKeyExchange {
    protected BigInteger B = null;
    protected TlsClientContext context;
    protected byte[] identity;
    protected int keyExchange;
    protected byte[] password;
    protected byte[] s = null;
    protected AsymmetricKeyParameter serverPublicKey = null;
    protected SRP6Client srpClient = new SRP6Client();
    protected TlsSigner tlsSigner;

    TlsSRPKeyExchange(TlsClientContext tlsClientContext, int i, byte[] bArr, byte[] bArr2) {
        TlsSigner tlsSigner2 = null;
        switch (i) {
            case 21:
                break;
            case 22:
                tlsSigner2 = new TlsDSSSigner();
                break;
            case 23:
                tlsSigner2 = new TlsRSASigner();
                break;
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.tlsSigner = tlsSigner2;
        this.context = tlsClientContext;
        this.keyExchange = i;
        this.identity = bArr;
        this.password = bArr2;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.srpClient.generateClientCredentials(this.s, this.identity, this.password));
        TlsUtils.writeUint24(asUnsignedByteArray.length + 2, outputStream);
        TlsUtils.writeOpaque16(asUnsignedByteArray, outputStream);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        try {
            return BigIntegers.asUnsignedByteArray(this.srpClient.calculateSecret(this.B));
        } catch (CryptoException unused) {
            throw new TlsFatalAlert(47);
        }
    }

    /* access modifiers changed from: protected */
    public Signer initSigner(TlsSigner tlsSigner2, SecurityParameters securityParameters) {
        Signer createVerifyer = tlsSigner2.createVerifyer(this.serverPublicKey);
        createVerifyer.update(securityParameters.clientRandom, 0, securityParameters.clientRandom.length);
        createVerifyer.update(securityParameters.serverRandom, 0, securityParameters.serverRandom.length);
        return createVerifyer;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        throw new TlsFatalAlert(80);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) throws IOException {
        if (this.tlsSigner != null) {
            X509CertificateStructure x509CertificateStructure = certificate.certs[0];
            try {
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(x509CertificateStructure.getSubjectPublicKeyInfo());
                this.serverPublicKey = createKey;
                if (this.tlsSigner.isValidPublicKey(createKey)) {
                    TlsUtils.validateKeyUsage(x509CertificateStructure, 128);
                    return;
                }
                throw new TlsFatalAlert(46);
            } catch (RuntimeException unused) {
                throw new TlsFatalAlert(43);
            }
        } else {
            throw new TlsFatalAlert(10);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        InputStream inputStream2;
        Signer signer;
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        TlsSigner tlsSigner2 = this.tlsSigner;
        if (tlsSigner2 != null) {
            signer = initSigner(tlsSigner2, securityParameters);
            inputStream2 = new SignerInputStream(inputStream, signer);
        } else {
            signer = null;
            inputStream2 = inputStream;
        }
        byte[] readOpaque16 = TlsUtils.readOpaque16(inputStream2);
        byte[] readOpaque162 = TlsUtils.readOpaque16(inputStream2);
        byte[] readOpaque8 = TlsUtils.readOpaque8(inputStream2);
        byte[] readOpaque163 = TlsUtils.readOpaque16(inputStream2);
        if (signer == null || signer.verifySignature(TlsUtils.readOpaque16(inputStream))) {
            BigInteger bigInteger = new BigInteger(1, readOpaque16);
            BigInteger bigInteger2 = new BigInteger(1, readOpaque162);
            this.s = readOpaque8;
            try {
                this.B = SRP6Util.validatePublicValue(bigInteger, new BigInteger(1, readOpaque163));
                this.srpClient.init(bigInteger, bigInteger2, new SHA1Digest(), this.context.getSecureRandom());
            } catch (CryptoException unused) {
                throw new TlsFatalAlert(47);
            }
        } else {
            throw new TlsFatalAlert(42);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipClientCredentials() throws IOException {
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipServerCertificate() throws IOException {
        if (this.tlsSigner != null) {
            throw new TlsFatalAlert(10);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipServerKeyExchange() throws IOException {
        throw new TlsFatalAlert(10);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        throw new TlsFatalAlert(10);
    }
}
