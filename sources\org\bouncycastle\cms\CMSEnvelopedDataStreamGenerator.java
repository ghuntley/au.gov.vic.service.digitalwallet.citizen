package org.bouncycastle.cms;

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
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;

public class CMSEnvelopedDataStreamGenerator extends CMSEnvelopedGenerator {
    private boolean _berEncodeRecipientSet;
    private int _bufferSize;
    private Object _originatorInfo = null;
    private Object _unprotectedAttributes = null;

    /* access modifiers changed from: private */
    public class CmsEnvelopedDataOutputStream extends OutputStream {
        private BERSequenceGenerator _cGen;
        private BERSequenceGenerator _eiGen;
        private BERSequenceGenerator _envGen;
        private OutputStream _out;

        public CmsEnvelopedDataOutputStream(OutputStream outputStream, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this._out = outputStream;
            this._cGen = bERSequenceGenerator;
            this._envGen = bERSequenceGenerator2;
            this._eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this._out.close();
            this._eiGen.close();
            if (CMSEnvelopedDataStreamGenerator.this.unprotectedAttributeGenerator != null) {
                this._envGen.addObject(new DERTaggedObject(false, 1, new BERSet(CMSEnvelopedDataStreamGenerator.this.unprotectedAttributeGenerator.getAttributes(new HashMap()).toASN1EncodableVector())));
            }
            this._envGen.close();
            this._cGen.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this._out.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this._out.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this._out.write(bArr, i, i2);
        }
    }

    public CMSEnvelopedDataStreamGenerator() {
    }

    public CMSEnvelopedDataStreamGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    private OutputStream doOpen(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, OutputEncryptor outputEncryptor) throws IOException, CMSException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GenericKey key = outputEncryptor.getKey();
        for (RecipientInfoGenerator recipientInfoGenerator : this.recipientInfoGenerators) {
            aSN1EncodableVector.add(recipientInfoGenerator.generate(key));
        }
        return open(aSN1ObjectIdentifier, outputStream, aSN1EncodableVector, outputEncryptor);
    }

    private DERInteger getVersion() {
        return (this._originatorInfo == null && this._unprotectedAttributes == null) ? new DERInteger(0) : new DERInteger(2);
    }

    private OutputStream open(OutputStream outputStream, String str, KeyGenerator keyGenerator, Provider provider) throws NoSuchAlgorithmException, CMSException {
        Provider provider2 = keyGenerator.getProvider();
        SecretKey generateKey = keyGenerator.generateKey();
        AlgorithmParameters generateParameters = generateParameters(str, generateKey, provider2);
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
        return open(outputStream, str, generateKey, generateParameters, aSN1EncodableVector, provider2);
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
    public OutputStream open(OutputStream outputStream, String str, SecretKey secretKey, AlgorithmParameters algorithmParameters, ASN1EncodableVector aSN1EncodableVector, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return open(outputStream, str, secretKey, algorithmParameters, aSN1EncodableVector, CMSUtils.getProvider(str2));
    }

    /* access modifiers changed from: protected */
    public OutputStream open(OutputStream outputStream, String str, SecretKey secretKey, AlgorithmParameters algorithmParameters, ASN1EncodableVector aSN1EncodableVector, Provider provider) throws NoSuchAlgorithmException, CMSException {
        try {
            BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
            bERSequenceGenerator.addObject(CMSObjectIdentifiers.envelopedData);
            BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
            bERSequenceGenerator2.addObject(getVersion());
            if (this._berEncodeRecipientSet) {
                bERSequenceGenerator2.getRawOutputStream().write(new BERSet(aSN1EncodableVector).getEncoded());
            } else {
                bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
            }
            BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
            bERSequenceGenerator3.addObject(CMSObjectIdentifiers.data);
            Cipher createSymmetricCipher = CMSEnvelopedHelper.INSTANCE.createSymmetricCipher(str, provider);
            createSymmetricCipher.init(1, secretKey, algorithmParameters, this.rand);
            if (algorithmParameters == null) {
                algorithmParameters = createSymmetricCipher.getParameters();
            }
            bERSequenceGenerator3.getRawOutputStream().write(getAlgorithmIdentifier(str, algorithmParameters).getEncoded());
            return new CmsEnvelopedDataOutputStream(new CipherOutputStream(CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this._bufferSize), createSymmetricCipher), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
        } catch (InvalidKeyException e) {
            throw new CMSException("key invalid in message.", e);
        } catch (NoSuchPaddingException e2) {
            throw new CMSException("required padding not supported.", e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new CMSException("algorithm parameters invalid.", e3);
        } catch (IOException e4) {
            throw new CMSException("exception decoding algorithm parameters.", e4);
        }
    }

    /* access modifiers changed from: protected */
    public OutputStream open(OutputStream outputStream, ASN1EncodableVector aSN1EncodableVector, OutputEncryptor outputEncryptor) throws CMSException {
        try {
            BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
            bERSequenceGenerator.addObject(CMSObjectIdentifiers.envelopedData);
            BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
            bERSequenceGenerator2.addObject(getVersion());
            if (this._berEncodeRecipientSet) {
                bERSequenceGenerator2.getRawOutputStream().write(new BERSet(aSN1EncodableVector).getEncoded());
            } else {
                bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
            }
            BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
            bERSequenceGenerator3.addObject(CMSObjectIdentifiers.data);
            bERSequenceGenerator3.getRawOutputStream().write(outputEncryptor.getAlgorithmIdentifier().getEncoded());
            return new CmsEnvelopedDataOutputStream(outputEncryptor.getOutputStream(CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this._bufferSize)), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
        } catch (IOException e) {
            throw new CMSException("exception decoding algorithm parameters.", e);
        }
    }

    public OutputStream open(OutputStream outputStream, OutputEncryptor outputEncryptor) throws CMSException, IOException {
        return doOpen(new ASN1ObjectIdentifier(CMSObjectIdentifiers.data.getId()), outputStream, outputEncryptor);
    }

    /* access modifiers changed from: protected */
    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, ASN1EncodableVector aSN1EncodableVector, OutputEncryptor outputEncryptor) throws IOException {
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject(CMSObjectIdentifiers.envelopedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject(getVersion());
        if (this._berEncodeRecipientSet) {
            bERSequenceGenerator2.getRawOutputStream().write(new BERSet(aSN1EncodableVector).getEncoded());
        } else {
            bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
        }
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject(aSN1ObjectIdentifier);
        bERSequenceGenerator3.getRawOutputStream().write(outputEncryptor.getAlgorithmIdentifier().getEncoded());
        return new CmsEnvelopedDataOutputStream(outputEncryptor.getOutputStream(CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this._bufferSize)), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
    }

    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, OutputEncryptor outputEncryptor) throws CMSException, IOException {
        return doOpen(aSN1ObjectIdentifier, outputStream, outputEncryptor);
    }

    public void setBEREncodeRecipients(boolean z) {
        this._berEncodeRecipientSet = z;
    }

    public void setBufferSize(int i) {
        this._bufferSize = i;
    }
}
