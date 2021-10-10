package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.SignerIdentifier;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;

public class CMSSignedDataStreamGenerator extends CMSSignedGenerator {
    private int _bufferSize;
    private List _messageDigests = new ArrayList();
    private List _signerInfs = new ArrayList();

    /* access modifiers changed from: private */
    public class CmsSignedDataOutputStream extends OutputStream {
        private ASN1ObjectIdentifier _contentOID;
        private BERSequenceGenerator _eiGen;
        private OutputStream _out;
        private BERSequenceGenerator _sGen;
        private BERSequenceGenerator _sigGen;

        public CmsSignedDataOutputStream(OutputStream outputStream, ASN1ObjectIdentifier aSN1ObjectIdentifier, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this._out = outputStream;
            this._contentOID = aSN1ObjectIdentifier;
            this._sGen = bERSequenceGenerator;
            this._sigGen = bERSequenceGenerator2;
            this._eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this._out.close();
            this._eiGen.close();
            CMSSignedDataStreamGenerator.this.digests.clear();
            if (CMSSignedDataStreamGenerator.this.certs.size() != 0) {
                this._sigGen.getRawOutputStream().write(new BERTaggedObject(false, 0, CMSUtils.createBerSetFromList(CMSSignedDataStreamGenerator.this.certs)).getEncoded());
            }
            if (CMSSignedDataStreamGenerator.this.crls.size() != 0) {
                this._sigGen.getRawOutputStream().write(new BERTaggedObject(false, 1, CMSUtils.createBerSetFromList(CMSSignedDataStreamGenerator.this.crls)).getEncoded());
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (DigestAndSignerInfoGeneratorHolder digestAndSignerInfoGeneratorHolder : CMSSignedDataStreamGenerator.this._signerInfs) {
                byte[] digest = digestAndSignerInfoGeneratorHolder.digest.digest();
                CMSSignedDataStreamGenerator.this.digests.put(digestAndSignerInfoGeneratorHolder.digestOID, digest.clone());
                aSN1EncodableVector.add(digestAndSignerInfoGeneratorHolder.signerInf.generate(this._contentOID, digestAndSignerInfoGeneratorHolder.getDigestAlgorithm(), digest));
            }
            for (SignerInfoGenerator signerInfoGenerator : CMSSignedDataStreamGenerator.this.signerGens) {
                try {
                    aSN1EncodableVector.add(signerInfoGenerator.generate(this._contentOID));
                    CMSSignedDataStreamGenerator.this.digests.put(signerInfoGenerator.getDigestAlgorithm().getAlgorithm().getId(), signerInfoGenerator.getCalculatedDigest());
                } catch (CMSException e) {
                    throw new CMSStreamException("exception generating signers: " + e.getMessage(), e);
                }
            }
            for (SignerInformation signerInformation : CMSSignedDataStreamGenerator.this._signers) {
                aSN1EncodableVector.add(signerInformation.toSignerInfo());
            }
            this._sigGen.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
            this._sigGen.close();
            this._sGen.close();
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

    /* access modifiers changed from: private */
    public class DigestAndSignerInfoGeneratorHolder {
        MessageDigest digest;
        String digestOID;
        SignerIntInfoGenerator signerInf;

        DigestAndSignerInfoGeneratorHolder(SignerIntInfoGenerator signerIntInfoGenerator, MessageDigest messageDigest, String str) {
            this.signerInf = signerIntInfoGenerator;
            this.digest = messageDigest;
            this.digestOID = str;
        }

        /* access modifiers changed from: package-private */
        public AlgorithmIdentifier getDigestAlgorithm() {
            return new AlgorithmIdentifier(new DERObjectIdentifier(this.digestOID), DERNull.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public class SignerIntInfoGeneratorImpl implements SignerIntInfoGenerator {
        private final String _encName;
        private final String _encOID;
        private final CMSAttributeTableGenerator _sAttr;
        private final Signature _sig;
        private final SignerIdentifier _signerIdentifier;
        private final CMSAttributeTableGenerator _unsAttr;

        SignerIntInfoGeneratorImpl(PrivateKey privateKey, SignerIdentifier signerIdentifier, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, Provider provider, SecureRandom secureRandom) throws NoSuchAlgorithmException, InvalidKeyException {
            CMSSignedHelper cMSSignedHelper;
            this._signerIdentifier = signerIdentifier;
            this._encOID = str2;
            this._sAttr = cMSAttributeTableGenerator;
            this._unsAttr = cMSAttributeTableGenerator2;
            String encryptionAlgName = CMSSignedHelper.INSTANCE.getEncryptionAlgName(str2);
            this._encName = encryptionAlgName;
            String str3 = CMSSignedHelper.INSTANCE.getDigestAlgName(str) + "with" + encryptionAlgName;
            if (cMSAttributeTableGenerator == null) {
                str3 = "RSA";
                if (!encryptionAlgName.equals(str3)) {
                    if (encryptionAlgName.equals("DSA")) {
                        cMSSignedHelper = CMSSignedHelper.INSTANCE;
                        str3 = "NONEwithDSA";
                        this._sig = cMSSignedHelper.getSignatureInstance(str3, provider);
                        this._sig.initSign(privateKey, secureRandom);
                    }
                    throw new NoSuchAlgorithmException("algorithm: " + encryptionAlgName + " not supported in base signatures.");
                }
            }
            cMSSignedHelper = CMSSignedHelper.INSTANCE;
            this._sig = cMSSignedHelper.getSignatureInstance(str3, provider);
            this._sig.initSign(privateKey, secureRandom);
        }

        @Override // org.bouncycastle.cms.SignerIntInfoGenerator
        public SignerInfo generate(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws CMSStreamException {
            ASN1Set aSN1Set;
            byte[] bArr2;
            try {
                ASN1Set aSN1Set2 = null;
                if (this._sAttr != null) {
                    AttributeTable attributes = this._sAttr.getAttributes(Collections.unmodifiableMap(CMSSignedDataStreamGenerator.this.getBaseParameters(dERObjectIdentifier, algorithmIdentifier, bArr)));
                    if (!(dERObjectIdentifier != null || attributes == null || attributes.get(CMSAttributes.contentType) == null)) {
                        Hashtable hashtable = attributes.toHashtable();
                        hashtable.remove(CMSAttributes.contentType);
                        attributes = new AttributeTable(hashtable);
                    }
                    ASN1Set attributeSet = CMSSignedDataStreamGenerator.this.getAttributeSet(attributes);
                    bArr2 = attributeSet.getEncoded(ASN1Encodable.DER);
                    aSN1Set = attributeSet;
                } else {
                    bArr2 = this._encName.equals("RSA") ? new DigestInfo(algorithmIdentifier, bArr).getEncoded(ASN1Encodable.DER) : bArr;
                    aSN1Set = null;
                }
                this._sig.update(bArr2);
                byte[] sign = this._sig.sign();
                if (this._unsAttr != null) {
                    Map baseParameters = CMSSignedDataStreamGenerator.this.getBaseParameters(dERObjectIdentifier, algorithmIdentifier, bArr);
                    baseParameters.put(CMSAttributeTableGenerator.SIGNATURE, sign.clone());
                    aSN1Set2 = CMSSignedDataStreamGenerator.this.getAttributeSet(this._unsAttr.getAttributes(Collections.unmodifiableMap(baseParameters)));
                }
                return new SignerInfo(this._signerIdentifier, algorithmIdentifier, aSN1Set, CMSSignedDataStreamGenerator.this.getEncAlgorithmIdentifier(this._encOID, this._sig), new DEROctetString(sign), aSN1Set2);
            } catch (IOException e) {
                throw new CMSStreamException("encoding error.", e);
            } catch (SignatureException e2) {
                throw new CMSStreamException("error creating signature.", e2);
            }
        }
    }

    public CMSSignedDataStreamGenerator() {
    }

    public CMSSignedDataStreamGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    private DERInteger calculateVersion(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.certs != null) {
            z3 = false;
            z2 = false;
            z = false;
            for (Object obj : this.certs) {
                if (obj instanceof ASN1TaggedObject) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
                    if (aSN1TaggedObject.getTagNo() == 1) {
                        z2 = true;
                    } else if (aSN1TaggedObject.getTagNo() == 2) {
                        z = true;
                    } else if (aSN1TaggedObject.getTagNo() == 3) {
                        z3 = true;
                    }
                }
            }
        } else {
            z3 = false;
            z2 = false;
            z = false;
        }
        if (z3) {
            return new DERInteger(5);
        }
        if (this.crls != null) {
            for (Object obj2 : this.crls) {
                if (obj2 instanceof ASN1TaggedObject) {
                    z4 = true;
                }
            }
        }
        return z4 ? new DERInteger(5) : z ? new DERInteger(4) : z2 ? new DERInteger(3) : checkForVersion3(this._signers) ? new DERInteger(3) : !CMSObjectIdentifiers.data.equals(aSN1ObjectIdentifier) ? new DERInteger(3) : new DERInteger(1);
    }

    private boolean checkForVersion3(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (SignerInfo.getInstance(((SignerInformation) it.next()).toSignerInfo()).getVersion().getValue().intValue() == 3) {
                return true;
            }
        }
        return false;
    }

    private void doAddSigner(PrivateKey privateKey, SignerIdentifier signerIdentifier, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, Provider provider, Provider provider2) throws NoSuchAlgorithmException, InvalidKeyException {
        MessageDigest digestInstance = CMSSignedHelper.INSTANCE.getDigestInstance(CMSSignedHelper.INSTANCE.getDigestAlgName(str2), provider2);
        this._signerInfs.add(new DigestAndSignerInfoGeneratorHolder(new SignerIntInfoGeneratorImpl(privateKey, signerIdentifier, str2, str, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, provider, this.rand), digestInstance, str2));
        this._messageDigests.add(digestInstance);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, CMSUtils.getProvider(str2));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, String str3) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, str2, CMSUtils.getProvider(str3));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, str2, new DefaultSignedAttributeTableGenerator(), (CMSAttributeTableGenerator) null, provider);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, AttributeTable attributeTable, AttributeTable attributeTable2, String str3) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, str2, attributeTable, attributeTable2, CMSUtils.getProvider(str3));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, AttributeTable attributeTable, AttributeTable attributeTable2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, str2, new DefaultSignedAttributeTableGenerator(attributeTable), new SimpleAttributeTableGenerator(attributeTable2), provider);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, String str3) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, str2, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, CMSUtils.getProvider(str3));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        doAddSigner(privateKey, getSignerIdentifier(x509Certificate), str, str2, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, provider, provider);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, Provider provider, Provider provider2) throws NoSuchAlgorithmException, InvalidKeyException {
        doAddSigner(privateKey, getSignerIdentifier(x509Certificate), str, str2, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, provider, provider2);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, new DefaultSignedAttributeTableGenerator(), (CMSAttributeTableGenerator) null, provider);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, AttributeTable attributeTable, AttributeTable attributeTable2, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, attributeTable, attributeTable2, CMSUtils.getProvider(str2));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, AttributeTable attributeTable, AttributeTable attributeTable2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, new DefaultSignedAttributeTableGenerator(attributeTable), new SimpleAttributeTableGenerator(attributeTable2), provider);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, str, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, CMSUtils.getProvider(str2));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        addSigner(privateKey, x509Certificate, getEncOID(privateKey, str), str, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, provider);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, bArr, str, CMSUtils.getProvider(str2));
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2, String str3) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, bArr, str, str2, CMSUtils.getProvider(str3));
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, bArr, str, str2, new DefaultSignedAttributeTableGenerator(), (CMSAttributeTableGenerator) null, provider);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, String str3) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, bArr, str, str2, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, CMSUtils.getProvider(str3));
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        doAddSigner(privateKey, getSignerIdentifier(bArr), str, str2, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, provider, provider);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, String str2, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, Provider provider, Provider provider2) throws NoSuchAlgorithmException, InvalidKeyException {
        doAddSigner(privateKey, getSignerIdentifier(bArr), str, str2, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, provider, provider2);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, bArr, str, new DefaultSignedAttributeTableGenerator(), (CMSAttributeTableGenerator) null, provider);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, AttributeTable attributeTable, AttributeTable attributeTable2, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, bArr, str, attributeTable, attributeTable2, CMSUtils.getProvider(str2));
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, AttributeTable attributeTable, AttributeTable attributeTable2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        addSigner(privateKey, bArr, str, new DefaultSignedAttributeTableGenerator(attributeTable), new SimpleAttributeTableGenerator(attributeTable2), provider);
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        addSigner(privateKey, bArr, str, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, CMSUtils.getProvider(str2));
    }

    public void addSigner(PrivateKey privateKey, byte[] bArr, String str, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        addSigner(privateKey, bArr, getEncOID(privateKey, str), str, cMSAttributeTableGenerator, cMSAttributeTableGenerator2, provider);
    }

    /* access modifiers changed from: package-private */
    public void generate(OutputStream outputStream, String str, boolean z, OutputStream outputStream2, CMSProcessable cMSProcessable) throws CMSException, IOException {
        OutputStream open = open(outputStream, str, z, outputStream2);
        if (cMSProcessable != null) {
            cMSProcessable.write(open);
        }
        open.close();
    }

    public OutputStream open(OutputStream outputStream) throws IOException {
        return open(outputStream, false);
    }

    public OutputStream open(OutputStream outputStream, String str, boolean z) throws IOException {
        return open(outputStream, str, z, (OutputStream) null);
    }

    public OutputStream open(OutputStream outputStream, String str, boolean z, OutputStream outputStream2) throws IOException {
        return open(new ASN1ObjectIdentifier(str), outputStream, z, outputStream2);
    }

    public OutputStream open(OutputStream outputStream, boolean z) throws IOException {
        return open(CMSObjectIdentifiers.data, outputStream, z);
    }

    public OutputStream open(OutputStream outputStream, boolean z, OutputStream outputStream2) throws IOException {
        return open(CMSObjectIdentifiers.data, outputStream, z, outputStream2);
    }

    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, boolean z) throws IOException {
        return open(aSN1ObjectIdentifier, outputStream, z, (OutputStream) null);
    }

    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, boolean z, OutputStream outputStream2) throws IOException {
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject(CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject(calculateVersion(aSN1ObjectIdentifier));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (SignerInformation signerInformation : this._signers) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(signerInformation.getDigestAlgorithmID()));
        }
        for (DigestAndSignerInfoGeneratorHolder digestAndSignerInfoGeneratorHolder : this._signerInfs) {
            aSN1EncodableVector.add(digestAndSignerInfoGeneratorHolder.getDigestAlgorithm());
        }
        for (SignerInfoGenerator signerInfoGenerator : this.signerGens) {
            aSN1EncodableVector.add(signerInfoGenerator.getDigestAlgorithm());
        }
        bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject(aSN1ObjectIdentifier);
        return new CmsSignedDataOutputStream(CMSUtils.attachSignersToOutputStream(this.signerGens, CMSUtils.attachDigestsToOutputStream(this._messageDigests, CMSUtils.getSafeTeeOutputStream(outputStream2, z ? CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, true, this._bufferSize) : null))), aSN1ObjectIdentifier, bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
    }

    public void setBufferSize(int i) {
        this._bufferSize = i;
    }
}
