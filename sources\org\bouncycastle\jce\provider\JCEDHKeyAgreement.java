package org.bouncycastle.jce.provider;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.util.Strings;
import org.objectweb.asm.Opcodes;

public class JCEDHKeyAgreement extends KeyAgreementSpi {
    private static final Hashtable algorithms;
    private BigInteger g;
    private BigInteger p;
    private BigInteger result;
    private BigInteger x;

    static {
        Hashtable hashtable = new Hashtable();
        algorithms = hashtable;
        Integer num = new Integer(64);
        Integer num2 = new Integer((int) Opcodes.CHECKCAST);
        Integer num3 = new Integer(128);
        Integer num4 = new Integer(256);
        hashtable.put("DES", num);
        hashtable.put("DESEDE", num2);
        hashtable.put("BLOWFISH", num3);
        hashtable.put("AES", num4);
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            if (!dHPublicKey.getParams().getG().equals(this.g) || !dHPublicKey.getParams().getP().equals(this.p)) {
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            } else if (z) {
                this.result = dHPublicKey.getY().modPow(this.x, this.p);
                return null;
            } else {
                BigInteger modPow = dHPublicKey.getY().modPow(this.x, this.p);
                this.result = modPow;
                return new JCEDHPublicKey(modPow, dHPublicKey.getParams());
            }
        } else {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        if (this.x != null) {
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            if (bArr.length - i >= bigIntToBytes.length) {
                System.arraycopy(bigIntToBytes, 0, bArr, i, bigIntToBytes.length);
                return bigIntToBytes.length;
            }
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        if (this.x != null) {
            String upperCase = Strings.toUpperCase(str);
            byte[] bigIntToBytes = bigIntToBytes(this.result);
            Hashtable hashtable = algorithms;
            if (!hashtable.containsKey(upperCase)) {
                return new SecretKeySpec(bigIntToBytes, str);
            }
            int intValue = ((Integer) hashtable.get(upperCase)).intValue() / 8;
            byte[] bArr = new byte[intValue];
            System.arraycopy(bigIntToBytes, 0, bArr, 0, intValue);
            if (upperCase.startsWith("DES")) {
                DESParameters.setOddParity(bArr);
            }
            return new SecretKeySpec(bArr, str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.x != null) {
            return bigIntToBytes(this.result);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.p = dHPrivateKey.getParams().getP();
            this.g = dHPrivateKey.getParams().getG();
            BigInteger x2 = dHPrivateKey.getX();
            this.result = x2;
            this.x = x2;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        DHParameterSpec dHParameterSpec;
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec == null) {
                this.p = dHPrivateKey.getParams().getP();
                dHParameterSpec = dHPrivateKey.getParams();
            } else if (algorithmParameterSpec instanceof DHParameterSpec) {
                dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.p = dHParameterSpec.getP();
            } else {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            this.g = dHParameterSpec.getG();
            BigInteger x2 = dHPrivateKey.getX();
            this.result = x2;
            this.x = x2;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }
}
