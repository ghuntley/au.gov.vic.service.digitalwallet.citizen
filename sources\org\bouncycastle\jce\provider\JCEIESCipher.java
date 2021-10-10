package org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHPrivateKey;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.agreement.DHBasicAgreement;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.engines.IESEngine;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.IESKey;
import org.bouncycastle.jce.provider.asymmetric.ec.ECUtil;
import org.bouncycastle.jce.spec.IESParameterSpec;

public class JCEIESCipher extends WrapCipherSpi {
    private Class[] availableSpecs = {IESParameterSpec.class};
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private IESEngine cipher;
    private AlgorithmParameters engineParam = null;
    private IESParameterSpec engineParams = null;
    private int state = -1;

    public static class BrokenECIES extends JCEIESCipher {
        public BrokenECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new BrokenKDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class BrokenIES extends JCEIESCipher {
        public BrokenIES() {
            super(new IESEngine(new DHBasicAgreement(), new BrokenKDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class ECIES extends JCEIESCipher {
        public ECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class IES extends JCEIESCipher {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public JCEIESCipher(IESEngine iESEngine) {
        this.cipher = iESEngine;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        if (i2 != 0) {
            this.buffer.write(bArr, i, i2);
        }
        try {
            byte[] byteArray = this.buffer.toByteArray();
            this.buffer.reset();
            byte[] processBlock = this.cipher.processBlock(byteArray, 0, byteArray.length);
            System.arraycopy(processBlock, 0, bArr2, i3, processBlock.length);
            return processBlock.length;
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (i2 != 0) {
            this.buffer.write(bArr, i, i2);
        }
        try {
            byte[] byteArray = this.buffer.toByteArray();
            this.buffer.reset();
            return this.cipher.processBlock(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.jce.provider.WrapCipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.jce.provider.WrapCipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public int engineGetKeySize(Key key) {
        BigInteger d;
        if (key instanceof IESKey) {
            IESKey iESKey = (IESKey) key;
            if (iESKey.getPrivate() instanceof DHPrivateKey) {
                d = ((DHPrivateKey) iESKey.getPrivate()).getX();
            } else if (iESKey.getPrivate() instanceof ECPrivateKey) {
                d = ((ECPrivateKey) iESKey.getPrivate()).getD();
            } else {
                throw new IllegalArgumentException("not an IE key!");
            }
            return d.bitLength();
        }
        throw new IllegalArgumentException("must be passed IE key");
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.jce.provider.WrapCipherSpi
    public int engineGetOutputSize(int i) {
        int i2 = this.state;
        if (i2 == 1 || i2 == 3) {
            return this.buffer.size() + i + 20;
        }
        if (i2 == 2 || i2 == 4) {
            return (this.buffer.size() + i) - 20;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.jce.provider.WrapCipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParam == null && this.engineParams != null) {
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("IES", BouncyCastleProvider.PROVIDER_NAME);
                this.engineParam = instance;
                instance.init(this.engineParams);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParam;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.availableSpecs;
                if (i2 == clsArr.length) {
                    break;
                }
                try {
                    algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i2]);
                    break;
                } catch (Exception unused) {
                    i2++;
                }
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        this.engineParam = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (i == 1 || i == 3) {
            try {
                engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
                return;
            } catch (InvalidAlgorithmParameterException unused) {
            }
        }
        throw new IllegalArgumentException("can't handle null parameter spec in IES");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AsymmetricKeyParameter asymmetricKeyParameter;
        AsymmetricKeyParameter asymmetricKeyParameter2;
        if (key instanceof IESKey) {
            if (algorithmParameterSpec == null && (i == 1 || i == 3)) {
                byte[] bArr = new byte[16];
                byte[] bArr2 = new byte[16];
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                secureRandom.nextBytes(bArr);
                secureRandom.nextBytes(bArr2);
                algorithmParameterSpec = new IESParameterSpec(bArr, bArr2, 128);
            } else if (!(algorithmParameterSpec instanceof IESParameterSpec)) {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
            IESKey iESKey = (IESKey) key;
            if (iESKey.getPublic() instanceof ECPublicKey) {
                asymmetricKeyParameter = ECUtil.generatePublicKeyParameter(iESKey.getPublic());
                asymmetricKeyParameter2 = ECUtil.generatePrivateKeyParameter(iESKey.getPrivate());
            } else {
                asymmetricKeyParameter = DHUtil.generatePublicKeyParameter(iESKey.getPublic());
                asymmetricKeyParameter2 = DHUtil.generatePrivateKeyParameter(iESKey.getPrivate());
            }
            IESParameterSpec iESParameterSpec = (IESParameterSpec) algorithmParameterSpec;
            this.engineParams = iESParameterSpec;
            IESParameters iESParameters = new IESParameters(iESParameterSpec.getDerivationV(), this.engineParams.getEncodingV(), this.engineParams.getMacKeySize());
            this.state = i;
            this.buffer.reset();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            System.out.println("eeek!");
                            return;
                        }
                    }
                }
                this.cipher.init(false, asymmetricKeyParameter2, asymmetricKeyParameter, iESParameters);
                return;
            }
            this.cipher.init(true, asymmetricKeyParameter2, asymmetricKeyParameter, iESParameters);
            return;
        }
        throw new InvalidKeyException("must be passed IES key");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public void engineSetMode(String str) {
        throw new IllegalArgumentException("can't support mode " + str);
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException(str + " unavailable with RSA.");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi, org.bouncycastle.jce.provider.WrapCipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.buffer.write(bArr, i, i2);
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.jce.provider.WrapCipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
        return null;
    }
}
