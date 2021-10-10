package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.BigIntegers;

/* access modifiers changed from: package-private */
public class TlsECDHKeyExchange implements TlsKeyExchange {
    protected TlsAgreementCredentials agreementCredentials;
    protected TlsClientContext context;
    protected ECPrivateKeyParameters ecAgreeClientPrivateKey = null;
    protected ECPublicKeyParameters ecAgreeServerPublicKey;
    protected int keyExchange;
    protected AsymmetricKeyParameter serverPublicKey;
    protected TlsSigner tlsSigner;

    TlsECDHKeyExchange(TlsClientContext tlsClientContext, int i) {
        TlsSigner tlsSigner2 = null;
        switch (i) {
            case 16:
            case 18:
                break;
            case 17:
                tlsSigner2 = new TlsECDSASigner();
                break;
            case 19:
                tlsSigner2 = new TlsRSASigner();
                break;
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.tlsSigner = tlsSigner2;
        this.context = tlsClientContext;
        this.keyExchange = i;
    }

    /* access modifiers changed from: protected */
    public boolean areOnSameCurve(ECDomainParameters eCDomainParameters, ECDomainParameters eCDomainParameters2) {
        return eCDomainParameters.getCurve().equals(eCDomainParameters2.getCurve()) && eCDomainParameters.getG().equals(eCDomainParameters2.getG()) && eCDomainParameters.getN().equals(eCDomainParameters2.getN()) && eCDomainParameters.getH().equals(eCDomainParameters2.getH());
    }

    /* access modifiers changed from: protected */
    public byte[] calculateECDHBasicAgreement(ECPublicKeyParameters eCPublicKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters) {
        ECDHBasicAgreement eCDHBasicAgreement = new ECDHBasicAgreement();
        eCDHBasicAgreement.init(eCPrivateKeyParameters);
        return BigIntegers.asUnsignedByteArray(eCDHBasicAgreement.calculateAgreement(eCPublicKeyParameters));
    }

    /* access modifiers changed from: protected */
    public byte[] externalizeKey(ECPublicKeyParameters eCPublicKeyParameters) throws IOException {
        return eCPublicKeyParameters.getQ().getEncoded();
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        if (this.agreementCredentials != null) {
            TlsUtils.writeUint24(0, outputStream);
        } else {
            generateEphemeralClientKeyExchange(this.ecAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    /* access modifiers changed from: protected */
    public AsymmetricCipherKeyPair generateECKeyPair(ECDomainParameters eCDomainParameters) {
        ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
        eCKeyPairGenerator.init(new ECKeyGenerationParameters(eCDomainParameters, this.context.getSecureRandom()));
        return eCKeyPairGenerator.generateKeyPair();
    }

    /* access modifiers changed from: protected */
    public void generateEphemeralClientKeyExchange(ECDomainParameters eCDomainParameters, OutputStream outputStream) throws IOException {
        AsymmetricCipherKeyPair generateECKeyPair = generateECKeyPair(eCDomainParameters);
        this.ecAgreeClientPrivateKey = (ECPrivateKeyParameters) generateECKeyPair.getPrivate();
        byte[] externalizeKey = externalizeKey((ECPublicKeyParameters) generateECKeyPair.getPublic());
        TlsUtils.writeUint24(externalizeKey.length + 1, outputStream);
        TlsUtils.writeOpaque8(externalizeKey, outputStream);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        return tlsAgreementCredentials != null ? tlsAgreementCredentials.generateAgreement(this.ecAgreeServerPublicKey) : calculateECDHBasicAgreement(this.ecAgreeServerPublicKey, this.ecAgreeClientPrivateKey);
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
                    this.ecAgreeServerPublicKey = validateECPublicKey((ECPublicKeyParameters) createKey);
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
            if (!(s == 1 || s == 2)) {
                switch (s) {
                    default:
                        throw new TlsFatalAlert(47);
                    case 64:
                    case 65:
                    case 66:
                        break;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ECPublicKeyParameters validateECPublicKey(ECPublicKeyParameters eCPublicKeyParameters) throws IOException {
        return eCPublicKeyParameters;
    }
}
