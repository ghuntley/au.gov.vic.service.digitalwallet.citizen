package org.bouncycastle.cms;

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
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.AuthenticatedData;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.util.io.TeeOutputStream;

public class CMSAuthenticatedDataStreamGenerator extends CMSAuthenticatedGenerator {
    private boolean berEncodeRecipientSet;
    private int bufferSize;
    private MacCalculator macCalculator;

    /* access modifiers changed from: private */
    public class CmsAuthenticatedDataOutputStream extends OutputStream {
        private BERSequenceGenerator cGen;
        private ASN1ObjectIdentifier contentType;
        private OutputStream dataStream;
        private DigestCalculator digestCalculator;
        private BERSequenceGenerator eiGen;
        private BERSequenceGenerator envGen;
        private MacCalculator macCalculator;

        public CmsAuthenticatedDataOutputStream(MacCalculator macCalculator2, DigestCalculator digestCalculator2, ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this.macCalculator = macCalculator2;
            this.digestCalculator = digestCalculator2;
            this.contentType = aSN1ObjectIdentifier;
            this.dataStream = outputStream;
            this.cGen = bERSequenceGenerator;
            this.envGen = bERSequenceGenerator2;
            this.eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Map map;
            this.dataStream.close();
            this.eiGen.close();
            DigestCalculator digestCalculator2 = this.digestCalculator;
            if (digestCalculator2 != null) {
                map = Collections.unmodifiableMap(CMSAuthenticatedDataStreamGenerator.this.getBaseParameters(this.contentType, digestCalculator2.getAlgorithmIdentifier(), this.digestCalculator.getDigest()));
                if (CMSAuthenticatedDataStreamGenerator.this.authGen == null) {
                    CMSAuthenticatedDataStreamGenerator.this.authGen = new DefaultAuthenticatedAttributeTableGenerator();
                }
                DERSet dERSet = new DERSet(CMSAuthenticatedDataStreamGenerator.this.authGen.getAttributes(map).toASN1EncodableVector());
                OutputStream outputStream = this.macCalculator.getOutputStream();
                outputStream.write(dERSet.getDEREncoded());
                outputStream.close();
                this.envGen.addObject(new DERTaggedObject(false, 2, dERSet));
            } else {
                map = Collections.unmodifiableMap(new HashMap());
            }
            this.envGen.addObject(new DEROctetString(this.macCalculator.getMac()));
            if (CMSAuthenticatedDataStreamGenerator.this.unauthGen != null) {
                this.envGen.addObject(new DERTaggedObject(false, 3, new BERSet(CMSAuthenticatedDataStreamGenerator.this.unauthGen.getAttributes(map).toASN1EncodableVector())));
            }
            this.envGen.close();
            this.cGen.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.dataStream.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.dataStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.dataStream.write(bArr, i, i2);
        }
    }

    /* access modifiers changed from: private */
    public class OldCmsAuthenticatedDataOutputStream extends OutputStream {
        private BERSequenceGenerator cGen;
        private OutputStream dataStream;
        private BERSequenceGenerator eiGen;
        private BERSequenceGenerator envGen;
        private Mac mac;

        public OldCmsAuthenticatedDataOutputStream(OutputStream outputStream, Mac mac2, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this.dataStream = outputStream;
            this.mac = mac2;
            this.cGen = bERSequenceGenerator;
            this.envGen = bERSequenceGenerator2;
            this.eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.dataStream.close();
            this.eiGen.close();
            this.envGen.addObject(new DEROctetString(this.mac.doFinal()));
            this.envGen.close();
            this.cGen.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.dataStream.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.dataStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.dataStream.write(bArr, i, i2);
        }
    }

    public CMSAuthenticatedDataStreamGenerator() {
    }

    public CMSAuthenticatedDataStreamGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    private OutputStream open(OutputStream outputStream, String str, KeyGenerator keyGenerator, Provider provider) throws NoSuchAlgorithmException, CMSException {
        Provider provider2 = keyGenerator.getProvider();
        SecretKey generateKey = keyGenerator.generateKey();
        AlgorithmParameterSpec generateParameterSpec = generateParameterSpec(str, generateKey, provider2);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
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
        return open(outputStream, str, generateKey, generateParameterSpec, aSN1EncodableVector, provider2);
    }

    public OutputStream open(OutputStream outputStream, String str, int i, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException, IOException {
        return open(outputStream, str, i, CMSUtils.getProvider(str2));
    }

    public OutputStream open(OutputStream outputStream, String str, int i, Provider provider) throws NoSuchAlgorithmException, CMSException, IOException {
        KeyGenerator createSymmetricKeyGenerator = CMSEnvelopedHelper.INSTANCE.createSymmetricKeyGenerator(str, provider);
        createSymmetricKeyGenerator.init(i, this.rand);
        return open(outputStream, str, createSymmetricKeyGenerator, provider);
    }

    public OutputStream open(OutputStream outputStream, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException, IOException {
        return open(outputStream, str, CMSUtils.getProvider(str2));
    }

    public OutputStream open(OutputStream outputStream, String str, Provider provider) throws NoSuchAlgorithmException, CMSException, IOException {
        KeyGenerator createSymmetricKeyGenerator = CMSEnvelopedHelper.INSTANCE.createSymmetricKeyGenerator(str, provider);
        createSymmetricKeyGenerator.init(this.rand);
        return open(outputStream, str, createSymmetricKeyGenerator, provider);
    }

    /* access modifiers changed from: protected */
    public OutputStream open(OutputStream outputStream, String str, SecretKey secretKey, AlgorithmParameterSpec algorithmParameterSpec, ASN1EncodableVector aSN1EncodableVector, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return open(outputStream, str, secretKey, algorithmParameterSpec, aSN1EncodableVector, CMSUtils.getProvider(str2));
    }

    /* access modifiers changed from: protected */
    public OutputStream open(OutputStream outputStream, String str, SecretKey secretKey, AlgorithmParameterSpec algorithmParameterSpec, ASN1EncodableVector aSN1EncodableVector, Provider provider) throws NoSuchAlgorithmException, CMSException {
        try {
            BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
            bERSequenceGenerator.addObject(CMSObjectIdentifiers.authenticatedData);
            BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
            bERSequenceGenerator2.addObject(new DERInteger(AuthenticatedData.calculateVersion(null)));
            if (this.berEncodeRecipientSet) {
                bERSequenceGenerator2.getRawOutputStream().write(new BERSet(aSN1EncodableVector).getEncoded());
            } else {
                bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
            }
            Mac mac = CMSEnvelopedHelper.INSTANCE.getMac(str, provider);
            mac.init(secretKey, algorithmParameterSpec);
            bERSequenceGenerator2.getRawOutputStream().write(getAlgorithmIdentifier(str, algorithmParameterSpec, provider).getEncoded());
            BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
            bERSequenceGenerator3.addObject(CMSObjectIdentifiers.data);
            return new OldCmsAuthenticatedDataOutputStream(new TeeOutputStream(CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this.bufferSize), new MacOutputStream(mac)), mac, bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
        } catch (InvalidKeyException e) {
            throw new CMSException("key invalid in message.", e);
        } catch (NoSuchPaddingException e2) {
            throw new CMSException("required padding not supported.", e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new CMSException("algorithm parameter invalid.", e3);
        } catch (InvalidParameterSpecException e4) {
            throw new CMSException("algorithm parameter spec invalid.", e4);
        } catch (IOException e5) {
            throw new CMSException("exception decoding algorithm parameters.", e5);
        }
    }

    public OutputStream open(OutputStream outputStream, MacCalculator macCalculator2) throws CMSException {
        return open(CMSObjectIdentifiers.data, outputStream, macCalculator2);
    }

    public OutputStream open(OutputStream outputStream, MacCalculator macCalculator2, DigestCalculator digestCalculator) throws CMSException {
        return open(CMSObjectIdentifiers.data, outputStream, macCalculator2, digestCalculator);
    }

    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, MacCalculator macCalculator2) throws CMSException {
        return open(aSN1ObjectIdentifier, outputStream, macCalculator2, (DigestCalculator) null);
    }

    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, MacCalculator macCalculator2, DigestCalculator digestCalculator) throws CMSException {
        this.macCalculator = macCalculator2;
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (RecipientInfoGenerator recipientInfoGenerator : this.recipientInfoGenerators) {
                aSN1EncodableVector.add(recipientInfoGenerator.generate(macCalculator2.getKey()));
            }
            BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
            bERSequenceGenerator.addObject(CMSObjectIdentifiers.authenticatedData);
            BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
            bERSequenceGenerator2.addObject(new DERInteger(AuthenticatedData.calculateVersion(null)));
            if (this.berEncodeRecipientSet) {
                bERSequenceGenerator2.getRawOutputStream().write(new BERSet(aSN1EncodableVector).getEncoded());
            } else {
                bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
            }
            bERSequenceGenerator2.getRawOutputStream().write(macCalculator2.getAlgorithmIdentifier().getEncoded());
            if (digestCalculator != null) {
                bERSequenceGenerator2.addObject(new DERTaggedObject(false, 1, digestCalculator.getAlgorithmIdentifier()));
            }
            BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
            bERSequenceGenerator3.addObject(aSN1ObjectIdentifier);
            OutputStream createBEROctetOutputStream = CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this.bufferSize);
            return new CmsAuthenticatedDataOutputStream(macCalculator2, digestCalculator, aSN1ObjectIdentifier, digestCalculator != null ? new TeeOutputStream(createBEROctetOutputStream, digestCalculator.getOutputStream()) : new TeeOutputStream(createBEROctetOutputStream, macCalculator2.getOutputStream()), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
        } catch (IOException e) {
            throw new CMSException("exception decoding algorithm parameters.", e);
        }
    }

    public void setBEREncodeRecipients(boolean z) {
        this.berEncodeRecipientSet = z;
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }
}
