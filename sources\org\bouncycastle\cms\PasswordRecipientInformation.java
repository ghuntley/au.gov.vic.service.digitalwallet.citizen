package org.bouncycastle.cms;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.objectweb.asm.Opcodes;

public class PasswordRecipientInformation extends RecipientInformation {
    static Map BLOCKSIZES;
    static Map KEYSIZES = new HashMap();
    private PasswordRecipientInfo info;

    static {
        HashMap hashMap = new HashMap();
        BLOCKSIZES = hashMap;
        hashMap.put(CMSAlgorithm.DES_EDE3_CBC, new Integer(8));
        BLOCKSIZES.put(CMSAlgorithm.AES128_CBC, new Integer(16));
        BLOCKSIZES.put(CMSAlgorithm.AES192_CBC, new Integer(16));
        BLOCKSIZES.put(CMSAlgorithm.AES256_CBC, new Integer(16));
        KEYSIZES.put(CMSAlgorithm.DES_EDE3_CBC, new Integer((int) Opcodes.CHECKCAST));
        KEYSIZES.put(CMSAlgorithm.AES128_CBC, new Integer(128));
        KEYSIZES.put(CMSAlgorithm.AES192_CBC, new Integer((int) Opcodes.CHECKCAST));
        KEYSIZES.put(CMSAlgorithm.AES256_CBC, new Integer(256));
    }

    PasswordRecipientInformation(PasswordRecipientInfo passwordRecipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        super(passwordRecipientInfo.getKeyEncryptionAlgorithm(), algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        this.info = passwordRecipientInfo;
        this.rid = new PasswordRecipientId();
    }

    @Override // org.bouncycastle.cms.RecipientInformation
    public CMSTypedStream getContentStream(Key key, String str) throws CMSException, NoSuchProviderException {
        return getContentStream(key, CMSUtils.getProvider(str));
    }

    @Override // org.bouncycastle.cms.RecipientInformation
    public CMSTypedStream getContentStream(Key key, Provider provider) throws CMSException {
        try {
            CMSEnvelopedHelper cMSEnvelopedHelper = CMSEnvelopedHelper.INSTANCE;
            ASN1Sequence aSN1Sequence = (ASN1Sequence) AlgorithmIdentifier.getInstance(this.info.getKeyEncryptionAlgorithm()).getParameters();
            String id = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0)).getId();
            Cipher createSymmetricCipher = cMSEnvelopedHelper.createSymmetricCipher(cMSEnvelopedHelper.getRFC3211WrapperName(id), provider);
            createSymmetricCipher.init(4, new SecretKeySpec(((CMSPBEKey) key).getEncoded(id), id), new IvParameterSpec(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets()));
            return getContentFromSessionKey(createSymmetricCipher.unwrap(this.info.getEncryptedKey().getOctets(), getContentAlgorithmName(), 3), provider);
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find algorithm.", e);
        } catch (InvalidKeyException e2) {
            throw new CMSException("key invalid in message.", e2);
        } catch (NoSuchPaddingException e3) {
            throw new CMSException("required padding not supported.", e3);
        } catch (InvalidAlgorithmParameterException e4) {
            throw new CMSException("invalid iv.", e4);
        }
    }

    public String getKeyDerivationAlgOID() {
        if (this.info.getKeyDerivationAlgorithm() != null) {
            return this.info.getKeyDerivationAlgorithm().getObjectId().getId();
        }
        return null;
    }

    public AlgorithmParameters getKeyDerivationAlgParameters(String str) throws NoSuchProviderException {
        return getKeyDerivationAlgParameters(CMSUtils.getProvider(str));
    }

    public AlgorithmParameters getKeyDerivationAlgParameters(Provider provider) {
        DEREncodable parameters;
        try {
            if (this.info.getKeyDerivationAlgorithm() == null || (parameters = this.info.getKeyDerivationAlgorithm().getParameters()) == null) {
                return null;
            }
            AlgorithmParameters instance = AlgorithmParameters.getInstance(this.info.getKeyDerivationAlgorithm().getObjectId().toString(), provider);
            instance.init(parameters.getDERObject().getEncoded());
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public byte[] getKeyDerivationAlgParams() {
        DEREncodable parameters;
        try {
            if (this.info.getKeyDerivationAlgorithm() == null || (parameters = this.info.getKeyDerivationAlgorithm().getParameters()) == null) {
                return null;
            }
            return parameters.getDERObject().getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient recipient) throws CMSException, IOException {
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator;
        PasswordRecipient passwordRecipient = (PasswordRecipient) recipient;
        AlgorithmIdentifier instance = AlgorithmIdentifier.getInstance(this.info.getKeyEncryptionAlgorithm());
        DERObjectIdentifier instance2 = DERObjectIdentifier.getInstance(((ASN1Sequence) instance.getParameters()).getObjectAt(0));
        PBKDF2Params instance3 = PBKDF2Params.getInstance(this.info.getKeyDerivationAlgorithm().getParameters());
        int intValue = ((Integer) KEYSIZES.get(instance2)).intValue();
        if (passwordRecipient.getPasswordConversionScheme() == 0) {
            pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator();
            pKCS5S2ParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes(passwordRecipient.getPassword()), instance3.getSalt(), instance3.getIterationCount().intValue());
        } else {
            pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator();
            pKCS5S2ParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(passwordRecipient.getPassword()), instance3.getSalt(), instance3.getIterationCount().intValue());
        }
        return passwordRecipient.getRecipientOperator(AlgorithmIdentifier.getInstance(instance.getParameters()), this.messageAlgorithm, ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(intValue)).getKey(), this.info.getEncryptedKey().getOctets());
    }
}
