package org.bouncycastle.cms;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CMSAuthenticatedGenerator extends CMSEnvelopedGenerator {
    protected CMSAttributeTableGenerator authGen;
    protected CMSAttributeTableGenerator unauthGen;

    public CMSAuthenticatedGenerator() {
    }

    public CMSAuthenticatedGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec generateParameterSpec(String str, SecretKey secretKey, Provider provider) throws CMSException {
        try {
            if (!str.equals(RC2_CBC)) {
                return CMSEnvelopedHelper.INSTANCE.createAlgorithmParameterGenerator(str, provider).generateParameters().getParameterSpec(IvParameterSpec.class);
            }
            byte[] bArr = new byte[8];
            this.rand.nextBytes(bArr);
            return new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public AlgorithmIdentifier getAlgorithmIdentifier(String str, AlgorithmParameterSpec algorithmParameterSpec, Provider provider) throws IOException, NoSuchAlgorithmException, InvalidParameterSpecException {
        AlgorithmParameters createAlgorithmParameters = CMSEnvelopedHelper.INSTANCE.createAlgorithmParameters(str, provider);
        createAlgorithmParameters.init(algorithmParameterSpec);
        return getAlgorithmIdentifier(str, createAlgorithmParameters);
    }

    /* access modifiers changed from: protected */
    public Map getBaseParameters(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(CMSAttributeTableGenerator.CONTENT_TYPE, dERObjectIdentifier);
        hashMap.put(CMSAttributeTableGenerator.DIGEST_ALGORITHM_IDENTIFIER, algorithmIdentifier);
        hashMap.put(CMSAttributeTableGenerator.DIGEST, bArr.clone());
        return hashMap;
    }

    public void setAuthenticatedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.authGen = cMSAttributeTableGenerator;
    }

    public void setUnauthenticatedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.unauthGen = cMSAttributeTableGenerator;
    }
}
