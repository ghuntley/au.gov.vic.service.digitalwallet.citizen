package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.BigIntegers;

/* access modifiers changed from: package-private */
public class TlsDHKeyExchange implements TlsKeyExchange {
    protected static final BigInteger ONE = BigInteger.valueOf(1);
    protected static final BigInteger TWO = BigInteger.valueOf(2);
    protected TlsAgreementCredentials agreementCredentials;
    protected TlsClientContext context;
    protected DHPrivateKeyParameters dhAgreeClientPrivateKey = null;
    protected DHPublicKeyParameters dhAgreeServerPublicKey = null;
    protected int keyExchange;
    protected AsymmetricKeyParameter serverPublicKey = null;
    protected TlsSigner tlsSigner;

    TlsDHKeyExchange(TlsClientContext tlsClientContext, int i) {
        TlsSigner tlsSigner2 = null;
        if (i == 3) {
            tlsSigner2 = new TlsDSSSigner();
        } else if (i == 5) {
            tlsSigner2 = new TlsRSASigner();
        } else if (!(i == 7 || i == 9)) {
            throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.tlsSigner = tlsSigner2;
        this.context = tlsClientContext;
        this.keyExchange = i;
    }

    /* access modifiers changed from: protected */
    public boolean areCompatibleParameters(DHParameters dHParameters, DHParameters dHParameters2) {
        return dHParameters.getP().equals(dHParameters2.getP()) && dHParameters.getG().equals(dHParameters2.getG());
    }

    /* access modifiers changed from: protected */
    public byte[] calculateDHBasicAgreement(DHPublicKeyParameters dHPublicKeyParameters, DHPrivateKeyParameters dHPrivateKeyParameters) {
        DHBasicAgreement dHBasicAgreement = new DHBasicAgreement();
        dHBasicAgreement.init(this.dhAgreeClientPrivateKey);
        return BigIntegers.asUnsignedByteArray(dHBasicAgreement.calculateAgreement(this.dhAgreeServerPublicKey));
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        if (this.agreementCredentials != null) {
            TlsUtils.writeUint24(0, outputStream);
        } else {
            generateEphemeralClientKeyExchange(this.dhAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    /* access modifiers changed from: protected */
    public AsymmetricCipherKeyPair generateDHKeyPair(DHParameters dHParameters) {
        DHBasicKeyPairGenerator dHBasicKeyPairGenerator = new DHBasicKeyPairGenerator();
        dHBasicKeyPairGenerator.init(new DHKeyGenerationParameters(this.context.getSecureRandom(), dHParameters));
        return dHBasicKeyPairGenerator.generateKeyPair();
    }

    /* access modifiers changed from: protected */
    public void generateEphemeralClientKeyExchange(DHParameters dHParameters, OutputStream outputStream) throws IOException {
        AsymmetricCipherKeyPair generateDHKeyPair = generateDHKeyPair(dHParameters);
        this.dhAgreeClientPrivateKey = (DHPrivateKeyParameters) generateDHKeyPair.getPrivate();
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(((DHPublicKeyParameters) generateDHKeyPair.getPublic()).getY());
        TlsUtils.writeUint24(asUnsignedByteArray.length + 2, outputStream);
        TlsUtils.writeOpaque16(asUnsignedByteArray, outputStream);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        return tlsAgreementCredentials != null ? tlsAgreementCredentials.generateAgreement(this.dhAgreeServerPublicKey) : calculateDHBasicAgreement(this.dhAgreeServerPublicKey, this.dhAgreeClientPrivateKey);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (tlsCredentials instanceof TlsAgreementCredentials) {
            this.agreementCredentials = (TlsAgreementCredentials) tlsCredentials;
        } else if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert(80);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) throws IOException {
        int i;
        X509CertificateStructure x509CertificateStructure = certificate.certs[0];
        try {
            AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(x509CertificateStructure.getSubjectPublicKeyInfo());
            this.serverPublicKey = createKey;
            TlsSigner tlsSigner2 = this.tlsSigner;
            if (tlsSigner2 == null) {
                try {
                    this.dhAgreeServerPublicKey = validateDHPublicKey((DHPublicKeyParameters) createKey);
                    i = 8;
                } catch (ClassCastException unused) {
                    throw new TlsFatalAlert(46);
                }
            } else if (tlsSigner2.isValidPublicKey(createKey)) {
                i = 128;
            } else {
                throw new TlsFatalAlert(46);
            }
            TlsUtils.validateKeyUsage(x509CertificateStructure, i);
        } catch (RuntimeException unused2) {
            throw new TlsFatalAlert(43);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        throw new TlsFatalAlert(10);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipClientCredentials() throws IOException {
        this.agreementCredentials = null;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipServerCertificate() throws IOException {
        throw new TlsFatalAlert(10);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipServerKeyExchange() throws IOException {
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        short[] certificateTypes = certificateRequest.getCertificateTypes();
        for (short s : certificateTypes) {
            if (s != 1 && s != 2 && s != 3 && s != 4 && s != 64) {
                throw new TlsFatalAlert(47);
            }
        }
    }

    /* access modifiers changed from: protected */
    public DHPublicKeyParameters validateDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) throws IOException {
        BigInteger y = dHPublicKeyParameters.getY();
        DHParameters parameters = dHPublicKeyParameters.getParameters();
        BigInteger p = parameters.getP();
        BigInteger g = parameters.getG();
        if (p.isProbablePrime(2)) {
            BigInteger bigInteger = TWO;
            if (g.compareTo(bigInteger) < 0 || g.compareTo(p.subtract(bigInteger)) > 0) {
                throw new TlsFatalAlert(47);
            } else if (y.compareTo(bigInteger) >= 0 && y.compareTo(p.subtract(ONE)) <= 0) {
                return dHPublicKeyParameters;
            } else {
                throw new TlsFatalAlert(47);
            }
        } else {
            throw new TlsFatalAlert(47);
        }
    }
}
