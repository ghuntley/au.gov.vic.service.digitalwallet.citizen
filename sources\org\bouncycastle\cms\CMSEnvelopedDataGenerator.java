package org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.BERConstructedOctetString;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EncryptedContentInfo;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;

public class CMSEnvelopedDataGenerator extends CMSEnvelopedGenerator {
    public CMSEnvelopedDataGenerator() {
    }

    public CMSEnvelopedDataGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    private CMSEnvelopedData doGenerate(CMSTypedData cMSTypedData, OutputEncryptor outputEncryptor) throws CMSException {
        if (this.oldRecipientInfoGenerators.isEmpty()) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                OutputStream outputStream = outputEncryptor.getOutputStream(byteArrayOutputStream);
                cMSTypedData.write(outputStream);
                outputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                AlgorithmIdentifier algorithmIdentifier = outputEncryptor.getAlgorithmIdentifier();
                BERConstructedOctetString bERConstructedOctetString = new BERConstructedOctetString(byteArray);
                GenericKey key = outputEncryptor.getKey();
                for (RecipientInfoGenerator recipientInfoGenerator : this.recipientInfoGenerators) {
                    aSN1EncodableVector.add(recipientInfoGenerator.generate(key));
                }
                return new CMSEnvelopedData(new ContentInfo(CMSObjectIdentifiers.envelopedData, new EnvelopedData(null, new DERSet(aSN1EncodableVector), new EncryptedContentInfo(cMSTypedData.getContentType(), algorithmIdentifier, bERConstructedOctetString), this.unprotectedAttributeGenerator != null ? new BERSet(this.unprotectedAttributeGenerator.getAttributes(new HashMap()).toASN1EncodableVector()) : null)));
            } catch (IOException unused) {
                throw new CMSException("");
            }
        } else {
            throw new IllegalStateException("can only use addRecipientGenerator() with this method");
        }
    }

    private CMSEnvelopedData generate(CMSProcessable cMSProcessable, String str, KeyGenerator keyGenerator, Provider provider) throws NoSuchAlgorithmException, CMSException {
        Provider provider2 = keyGenerator.getProvider();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        try {
            Cipher createSymmetricCipher = CMSEnvelopedHelper.INSTANCE.createSymmetricCipher(str, provider2);
            SecretKey generateKey = keyGenerator.generateKey();
            AlgorithmParameters generateParameters = generateParameters(str, generateKey, provider2);
            createSymmetricCipher.init(1, generateKey, generateParameters, this.rand);
            if (generateParameters == null) {
                generateParameters = createSymmetricCipher.getParameters();
            }
            AlgorithmIdentifier algorithmIdentifier = getAlgorithmIdentifier(str, generateParameters);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, createSymmetricCipher);
            cMSProcessable.write(cipherOutputStream);
            cipherOutputStream.close();
            BERConstructedOctetString bERConstructedOctetString = new BERConstructedOctetString(byteArrayOutputStream.toByteArray());
            for (IntRecipientInfoGenerator intRecipientInfoGenerator : this.oldRecipientInfoGenerators) {
                try {
                    aSN1EncodableVector.add(intRecipientInfoGenerator.generate(generateKey, this.rand, provider));
                } catch (InvalidKeyException e) {
                    throw new CMSException("key inappropriate for algorithm.", e);
                } catch (GeneralSecurityException e2) {
                    throw new CMSException("error making encrypted content.", e2);
                }
            }
            for (RecipientInfoGenerator recipientInfoGenerator : this.recipientInfoGenerators) {
                aSN1EncodableVector.add(recipientInfoGenerator.generate(new GenericKey(generateKey)));
            }
            return new CMSEnvelopedData(new ContentInfo(CMSObjectIdentifiers.envelopedData, new EnvelopedData(null, new DERSet(aSN1EncodableVector), cMSProcessable instanceof CMSTypedData ? new EncryptedContentInfo(((CMSTypedData) cMSProcessable).getContentType(), algorithmIdentifier, bERConstructedOctetString) : new EncryptedContentInfo(CMSObjectIdentifiers.data, algorithmIdentifier, bERConstructedOctetString), this.unprotectedAttributeGenerator != null ? new BERSet(this.unprotectedAttributeGenerator.getAttributes(new HashMap()).toASN1EncodableVector()) : null)));
        } catch (InvalidKeyException e3) {
            throw new CMSException("key invalid in message.", e3);
        } catch (NoSuchPaddingException e4) {
            throw new CMSException("required padding not supported.", e4);
        } catch (InvalidAlgorithmParameterException e5) {
            throw new CMSException("algorithm parameters invalid.", e5);
        } catch (IOException e6) {
            throw new CMSException("exception decoding algorithm parameters.", e6);
        }
    }

    public CMSEnvelopedData generate(CMSProcessable cMSProcessable, String str, int i, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate(cMSProcessable, str, i, CMSUtils.getProvider(str2));
    }

    public CMSEnvelopedData generate(CMSProcessable cMSProcessable, String str, int i, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        KeyGenerator createSymmetricKeyGenerator = CMSEnvelopedHelper.INSTANCE.createSymmetricKeyGenerator(str, provider);
        createSymmetricKeyGenerator.init(i, this.rand);
        return generate(cMSProcessable, str, createSymmetricKeyGenerator, provider);
    }

    public CMSEnvelopedData generate(CMSProcessable cMSProcessable, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate(cMSProcessable, str, CMSUtils.getProvider(str2));
    }

    public CMSEnvelopedData generate(CMSProcessable cMSProcessable, String str, Provider provider) throws NoSuchAlgorithmException, CMSException {
        KeyGenerator createSymmetricKeyGenerator = CMSEnvelopedHelper.INSTANCE.createSymmetricKeyGenerator(str, provider);
        createSymmetricKeyGenerator.init(this.rand);
        return generate(cMSProcessable, str, createSymmetricKeyGenerator, provider);
    }

    public CMSEnvelopedData generate(CMSTypedData cMSTypedData, OutputEncryptor outputEncryptor) throws CMSException {
        return doGenerate(cMSTypedData, outputEncryptor);
    }
}
