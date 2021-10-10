package org.bouncycastle.jce.provider;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class JCEPBEKey implements PBEKey {
    String algorithm;
    int digest;
    int ivSize;
    int keySize;
    DERObjectIdentifier oid;
    CipherParameters param;
    PBEKeySpec pbeKeySpec;
    boolean tryWrong = false;
    int type;

    public JCEPBEKey(String str, DERObjectIdentifier dERObjectIdentifier, int i, int i2, int i3, int i4, PBEKeySpec pBEKeySpec, CipherParameters cipherParameters) {
        this.algorithm = str;
        this.oid = dERObjectIdentifier;
        this.type = i;
        this.digest = i2;
        this.keySize = i3;
        this.ivSize = i4;
        this.pbeKeySpec = pBEKeySpec;
        this.param = cipherParameters;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    /* access modifiers changed from: package-private */
    public int getDigest() {
        return this.digest;
    }

    public byte[] getEncoded() {
        CipherParameters cipherParameters = this.param;
        if (cipherParameters == null) {
            return this.type == 2 ? PBEParametersGenerator.PKCS12PasswordToBytes(this.pbeKeySpec.getPassword()) : PBEParametersGenerator.PKCS5PasswordToBytes(this.pbeKeySpec.getPassword());
        }
        if (cipherParameters instanceof ParametersWithIV) {
            cipherParameters = ((ParametersWithIV) cipherParameters).getParameters();
        }
        return ((KeyParameter) cipherParameters).getKey();
    }

    public String getFormat() {
        return "RAW";
    }

    public int getIterationCount() {
        return this.pbeKeySpec.getIterationCount();
    }

    /* access modifiers changed from: package-private */
    public int getIvSize() {
        return this.ivSize;
    }

    /* access modifiers changed from: package-private */
    public int getKeySize() {
        return this.keySize;
    }

    public DERObjectIdentifier getOID() {
        return this.oid;
    }

    /* access modifiers changed from: package-private */
    public CipherParameters getParam() {
        return this.param;
    }

    public char[] getPassword() {
        return this.pbeKeySpec.getPassword();
    }

    public byte[] getSalt() {
        return this.pbeKeySpec.getSalt();
    }

    /* access modifiers changed from: package-private */
    public int getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public void setTryWrongPKCS12Zero(boolean z) {
        this.tryWrong = z;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldTryWrongPKCS12() {
        return this.tryWrong;
    }
}
