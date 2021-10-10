package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.jcajce.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.NamedJcaJceHelper;
import org.bouncycastle.jcajce.ProviderJcaJceHelper;
import org.bouncycastle.jcajce.io.MacOutputStream;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;

public class JceCMSMacCalculatorBuilder {
    private EnvelopedDataHelper helper;
    private final int keySize;
    private final ASN1ObjectIdentifier macOID;
    private MacOutputStream macOutputStream;
    private SecureRandom random;

    private class CMSOutputEncryptor implements MacCalculator {
        private AlgorithmIdentifier algorithmIdentifier;
        private SecretKey encKey;
        private Mac mac;
        private SecureRandom random;

        CMSOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, SecureRandom secureRandom) throws CMSException {
            KeyGenerator createKeyGenerator = JceCMSMacCalculatorBuilder.this.helper.createKeyGenerator(aSN1ObjectIdentifier);
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            this.random = secureRandom;
            if (i < 0) {
                createKeyGenerator.init(secureRandom);
            } else {
                createKeyGenerator.init(i, secureRandom);
            }
            SecretKey generateKey = createKeyGenerator.generateKey();
            this.encKey = generateKey;
            this.algorithmIdentifier = JceCMSMacCalculatorBuilder.this.helper.getAlgorithmIdentifier(aSN1ObjectIdentifier, generateParameterSpec(aSN1ObjectIdentifier, generateKey));
            this.mac = JceCMSMacCalculatorBuilder.this.helper.createContentMac(this.encKey, this.algorithmIdentifier);
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec generateParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey) throws CMSException {
            try {
                if (!aSN1ObjectIdentifier.equals(PKCSObjectIdentifiers.RC2_CBC)) {
                    return JceCMSMacCalculatorBuilder.this.helper.createAlgorithmParameterGenerator(aSN1ObjectIdentifier).generateParameters().getParameterSpec(IvParameterSpec.class);
                }
                byte[] bArr = new byte[8];
                this.random.nextBytes(bArr);
                return new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr);
            } catch (GeneralSecurityException unused) {
                return null;
            }
        }

        @Override // org.bouncycastle.operator.MacCalculator
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        @Override // org.bouncycastle.operator.MacCalculator
        public GenericKey getKey() {
            return new GenericKey(this.encKey);
        }

        @Override // org.bouncycastle.operator.MacCalculator
        public byte[] getMac() {
            return this.mac.doFinal();
        }

        @Override // org.bouncycastle.operator.MacCalculator
        public OutputStream getOutputStream() {
            return new MacOutputStream(this.mac);
        }
    }

    public JceCMSMacCalculatorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, -1);
    }

    public JceCMSMacCalculatorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        this.helper = new EnvelopedDataHelper(new DefaultJcaJceHelper());
        this.macOID = aSN1ObjectIdentifier;
        this.keySize = i;
    }

    public MacCalculator build() throws CMSException {
        return new CMSOutputEncryptor(this.macOID, this.keySize, this.random);
    }

    public JceCMSMacCalculatorBuilder setProvider(String str) {
        this.helper = new EnvelopedDataHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceCMSMacCalculatorBuilder setProvider(Provider provider) {
        this.helper = new EnvelopedDataHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JceCMSMacCalculatorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
