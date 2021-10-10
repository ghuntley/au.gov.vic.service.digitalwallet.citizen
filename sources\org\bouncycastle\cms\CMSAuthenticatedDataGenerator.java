package org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Collections;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.BERConstructedOctetString;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.AuthenticatedData;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.io.TeeOutputStream;

public class CMSAuthenticatedDataGenerator extends CMSAuthenticatedGenerator {
    public CMSAuthenticatedDataGenerator() {
    }

    public CMSAuthenticatedDataGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    private CMSAuthenticatedData generate(CMSProcessable cMSProcessable, String str, KeyGenerator keyGenerator, Provider provider) throws NoSuchAlgorithmException, CMSException {
        Provider provider2 = keyGenerator.getProvider();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        try {
            Mac mac = CMSEnvelopedHelper.INSTANCE.getMac(str, provider2);
            SecretKey generateKey = keyGenerator.generateKey();
            AlgorithmParameterSpec generateParameterSpec = generateParameterSpec(str, generateKey, provider2);
            mac.init(generateKey, generateParameterSpec);
            AlgorithmIdentifier algorithmIdentifier = getAlgorithmIdentifier(str, generateParameterSpec, provider2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TeeOutputStream teeOutputStream = new TeeOutputStream(byteArrayOutputStream, new MacOutputStream(mac));
            cMSProcessable.write(teeOutputStream);
            teeOutputStream.close();
            byteArrayOutputStream.close();
            BERConstructedOctetString bERConstructedOctetString = new BERConstructedOctetString(byteArrayOutputStream.toByteArray());
            DEROctetString dEROctetString = new DEROctetString(mac.doFinal());
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
            return new CMSAuthenticatedData(new ContentInfo(CMSObjectIdentifiers.authenticatedData, new AuthenticatedData(null, new DERSet(aSN1EncodableVector), algorithmIdentifier, null, new ContentInfo(CMSObjectIdentifiers.data, bERConstructedOctetString), null, dEROctetString, null)));
        } catch (InvalidKeyException e3) {
            throw new CMSException("key invalid in message.", e3);
        } catch (NoSuchPaddingException e4) {
            throw new CMSException("required padding not supported.", e4);
        } catch (InvalidAlgorithmParameterException e5) {
            throw new CMSException("algorithm parameters invalid.", e5);
        } catch (IOException e6) {
            throw new CMSException("exception decoding algorithm parameters.", e6);
        } catch (InvalidParameterSpecException e7) {
            throw new CMSException("exception setting up parameters.", e7);
        }
    }

    public CMSAuthenticatedData generate(CMSProcessable cMSProcessable, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate(cMSProcessable, str, CMSUtils.getProvider(str2));
    }

    public CMSAuthenticatedData generate(CMSProcessable cMSProcessable, String str, Provider provider) throws NoSuchAlgorithmException, CMSException {
        KeyGenerator createSymmetricKeyGenerator = CMSEnvelopedHelper.INSTANCE.createSymmetricKeyGenerator(str, provider);
        createSymmetricKeyGenerator.init(this.rand);
        return generate(cMSProcessable, str, createSymmetricKeyGenerator, provider);
    }

    public CMSAuthenticatedData generate(CMSTypedData cMSTypedData, MacCalculator macCalculator) throws CMSException {
        return generate(cMSTypedData, macCalculator, (DigestCalculator) null);
    }

    public CMSAuthenticatedData generate(CMSTypedData cMSTypedData, MacCalculator macCalculator, final DigestCalculator digestCalculator) throws CMSException {
        AuthenticatedData authenticatedData;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (RecipientInfoGenerator recipientInfoGenerator : this.recipientInfoGenerators) {
            aSN1EncodableVector.add(recipientInfoGenerator.generate(macCalculator.getKey()));
        }
        BERSet bERSet = null;
        if (digestCalculator != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                TeeOutputStream teeOutputStream = new TeeOutputStream(digestCalculator.getOutputStream(), byteArrayOutputStream);
                cMSTypedData.write(teeOutputStream);
                teeOutputStream.close();
                BERConstructedOctetString bERConstructedOctetString = new BERConstructedOctetString(byteArrayOutputStream.toByteArray());
                Map baseParameters = getBaseParameters(cMSTypedData.getContentType(), digestCalculator.getAlgorithmIdentifier(), digestCalculator.getDigest());
                if (this.authGen == null) {
                    this.authGen = new DefaultAuthenticatedAttributeTableGenerator();
                }
                DERSet dERSet = new DERSet(this.authGen.getAttributes(Collections.unmodifiableMap(baseParameters)).toASN1EncodableVector());
                try {
                    OutputStream outputStream = macCalculator.getOutputStream();
                    outputStream.write(dERSet.getDEREncoded());
                    outputStream.close();
                    DEROctetString dEROctetString = new DEROctetString(macCalculator.getMac());
                    if (this.unauthGen != null) {
                        bERSet = new BERSet(this.unauthGen.getAttributes(Collections.unmodifiableMap(baseParameters)).toASN1EncodableVector());
                    }
                    authenticatedData = new AuthenticatedData(null, new DERSet(aSN1EncodableVector), macCalculator.getAlgorithmIdentifier(), digestCalculator.getAlgorithmIdentifier(), new ContentInfo(CMSObjectIdentifiers.data, bERConstructedOctetString), dERSet, dEROctetString, bERSet);
                } catch (IOException e) {
                    throw new CMSException("exception decoding algorithm parameters.", e);
                }
            } catch (IOException e2) {
                throw new CMSException("unable to perform digest calculation: " + e2.getMessage(), e2);
            }
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                TeeOutputStream teeOutputStream2 = new TeeOutputStream(byteArrayOutputStream2, macCalculator.getOutputStream());
                cMSTypedData.write(teeOutputStream2);
                teeOutputStream2.close();
                BERConstructedOctetString bERConstructedOctetString2 = new BERConstructedOctetString(byteArrayOutputStream2.toByteArray());
                DEROctetString dEROctetString2 = new DEROctetString(macCalculator.getMac());
                if (this.unauthGen != null) {
                    bERSet = new BERSet(this.unauthGen.getAttributes(Collections.EMPTY_MAP).toASN1EncodableVector());
                }
                authenticatedData = new AuthenticatedData(null, new DERSet(aSN1EncodableVector), macCalculator.getAlgorithmIdentifier(), null, new ContentInfo(CMSObjectIdentifiers.data, bERConstructedOctetString2), null, dEROctetString2, bERSet);
            } catch (IOException e3) {
                throw new CMSException("exception decoding algorithm parameters.", e3);
            }
        }
        return new CMSAuthenticatedData(new ContentInfo(CMSObjectIdentifiers.authenticatedData, authenticatedData), new DigestCalculatorProvider() {
            /* class org.bouncycastle.cms.CMSAuthenticatedDataGenerator.AnonymousClass1 */

            @Override // org.bouncycastle.operator.DigestCalculatorProvider
            public DigestCalculator get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                return digestCalculator;
            }
        });
    }
}
