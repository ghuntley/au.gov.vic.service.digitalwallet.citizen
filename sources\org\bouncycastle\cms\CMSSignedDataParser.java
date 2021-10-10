package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Generator;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.BERSetParser;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfoParser;
import org.bouncycastle.asn1.cms.SignedDataParser;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.io.Streams;
import org.bouncycastle.x509.NoSuchStoreException;
import org.bouncycastle.x509.X509Store;

public class CMSSignedDataParser extends CMSContentInfoParser {
    private static final CMSSignedHelper HELPER = CMSSignedHelper.INSTANCE;
    private X509Store _attributeStore;
    private ASN1Set _certSet;
    private CertStore _certStore;
    private X509Store _certificateStore;
    private ASN1Set _crlSet;
    private X509Store _crlStore;
    private Map _digests;
    private boolean _isCertCrlParsed;
    private CMSTypedStream _signedContent;
    private ASN1ObjectIdentifier _signedContentType;
    private SignedDataParser _signedData;
    private SignerInformationStore _signerInfoStore;

    public CMSSignedDataParser(InputStream inputStream) throws CMSException {
        this((CMSTypedStream) null, inputStream);
    }

    public CMSSignedDataParser(CMSTypedStream cMSTypedStream, InputStream inputStream) throws CMSException {
        super(inputStream);
        try {
            this._signedContent = cMSTypedStream;
            this._signedData = SignedDataParser.getInstance(this._contentInfo.getContent(16));
            this._digests = new HashMap();
            ASN1SetParser digestAlgorithms = this._signedData.getDigestAlgorithms();
            while (true) {
                DEREncodable readObject = digestAlgorithms.readObject();
                if (readObject == null) {
                    break;
                }
                AlgorithmIdentifier instance = AlgorithmIdentifier.getInstance(readObject.getDERObject());
                try {
                    CMSSignedHelper cMSSignedHelper = HELPER;
                    String digestAlgName = cMSSignedHelper.getDigestAlgName(instance.getObjectId().toString());
                    this._digests.put(digestAlgName, cMSSignedHelper.getDigestInstance(digestAlgName, null));
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            ContentInfoParser encapContentInfo = this._signedData.getEncapContentInfo();
            ASN1OctetStringParser aSN1OctetStringParser = (ASN1OctetStringParser) encapContentInfo.getContent(4);
            if (aSN1OctetStringParser != null) {
                CMSTypedStream cMSTypedStream2 = new CMSTypedStream(encapContentInfo.getContentType().getId(), aSN1OctetStringParser.getOctetStream());
                if (this._signedContent == null) {
                    this._signedContent = cMSTypedStream2;
                } else {
                    cMSTypedStream2.drain();
                }
            }
            this._signedContentType = cMSTypedStream == null ? encapContentInfo.getContentType() : this._signedContent.getContentType();
            if (this._digests.isEmpty()) {
                throw new CMSException("no digests could be created for message.");
            }
        } catch (IOException e) {
            throw new CMSException("io exception: " + e.getMessage(), e);
        }
    }

    public CMSSignedDataParser(CMSTypedStream cMSTypedStream, byte[] bArr) throws CMSException {
        this(cMSTypedStream, new ByteArrayInputStream(bArr));
    }

    public CMSSignedDataParser(byte[] bArr) throws CMSException {
        this(new ByteArrayInputStream(bArr));
    }

    private static ASN1Set getASN1Set(ASN1SetParser aSN1SetParser) {
        if (aSN1SetParser == null) {
            return null;
        }
        return ASN1Set.getInstance(aSN1SetParser.getDERObject());
    }

    private static void pipeEncapsulatedOctetString(ContentInfoParser contentInfoParser, OutputStream outputStream) throws IOException {
        ASN1OctetStringParser aSN1OctetStringParser = (ASN1OctetStringParser) contentInfoParser.getContent(4);
        if (aSN1OctetStringParser != null) {
            pipeOctetString(aSN1OctetStringParser, outputStream);
        }
    }

    private static void pipeOctetString(ASN1OctetStringParser aSN1OctetStringParser, OutputStream outputStream) throws IOException {
        OutputStream createBEROctetOutputStream = CMSUtils.createBEROctetOutputStream(outputStream, 0, true, 0);
        Streams.pipeAll(aSN1OctetStringParser.getOctetStream(), createBEROctetOutputStream);
        createBEROctetOutputStream.close();
    }

    private void populateCertCrlSets() throws CMSException {
        if (!this._isCertCrlParsed) {
            this._isCertCrlParsed = true;
            try {
                this._certSet = getASN1Set(this._signedData.getCertificates());
                this._crlSet = getASN1Set(this._signedData.getCrls());
            } catch (IOException e) {
                throw new CMSException("problem parsing cert/crl sets", e);
            }
        }
    }

    public static OutputStream replaceCertificatesAndCRLs(InputStream inputStream, CertStore certStore, OutputStream outputStream) throws CMSException, IOException {
        SignedDataParser instance = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser) new ASN1StreamParser(inputStream, CMSUtils.getMaximumMemory()).readObject()).getContent(16));
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject(CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject(instance.getVersion());
        bERSequenceGenerator2.getRawOutputStream().write(instance.getDigestAlgorithms().getDERObject().getEncoded());
        ContentInfoParser encapContentInfo = instance.getEncapContentInfo();
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject(encapContentInfo.getContentType());
        pipeEncapsulatedOctetString(encapContentInfo, bERSequenceGenerator3.getRawOutputStream());
        bERSequenceGenerator3.close();
        getASN1Set(instance.getCertificates());
        getASN1Set(instance.getCrls());
        try {
            ASN1Set createBerSetFromList = CMSUtils.createBerSetFromList(CMSUtils.getCertificatesFromStore(certStore));
            if (createBerSetFromList.size() > 0) {
                bERSequenceGenerator2.getRawOutputStream().write(new DERTaggedObject(false, 0, createBerSetFromList).getEncoded());
            }
            try {
                ASN1Set createBerSetFromList2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(certStore));
                if (createBerSetFromList2.size() > 0) {
                    bERSequenceGenerator2.getRawOutputStream().write(new DERTaggedObject(false, 1, createBerSetFromList2).getEncoded());
                }
                bERSequenceGenerator2.getRawOutputStream().write(instance.getSignerInfos().getDERObject().getEncoded());
                bERSequenceGenerator2.close();
                bERSequenceGenerator.close();
                return outputStream;
            } catch (CertStoreException e) {
                throw new CMSException("error getting crls from certStore", e);
            }
        } catch (CertStoreException e2) {
            throw new CMSException("error getting certs from certStore", e2);
        }
    }

    public static OutputStream replaceCertificatesAndCRLs(InputStream inputStream, Store store, Store store2, Store store3, OutputStream outputStream) throws CMSException, IOException {
        SignedDataParser instance = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser) new ASN1StreamParser(inputStream, CMSUtils.getMaximumMemory()).readObject()).getContent(16));
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject(CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject(instance.getVersion());
        bERSequenceGenerator2.getRawOutputStream().write(instance.getDigestAlgorithms().getDERObject().getEncoded());
        ContentInfoParser encapContentInfo = instance.getEncapContentInfo();
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject(encapContentInfo.getContentType());
        pipeEncapsulatedOctetString(encapContentInfo, bERSequenceGenerator3.getRawOutputStream());
        bERSequenceGenerator3.close();
        getASN1Set(instance.getCertificates());
        getASN1Set(instance.getCrls());
        if (!(store == null && store3 == null)) {
            ArrayList arrayList = new ArrayList();
            if (store != null) {
                arrayList.addAll(CMSUtils.getCertificatesFromStore(store));
            }
            if (store3 != null) {
                arrayList.addAll(CMSUtils.getAttributeCertificatesFromStore(store3));
            }
            ASN1Set createBerSetFromList = CMSUtils.createBerSetFromList(arrayList);
            if (createBerSetFromList.size() > 0) {
                bERSequenceGenerator2.getRawOutputStream().write(new DERTaggedObject(false, 0, createBerSetFromList).getEncoded());
            }
        }
        if (store2 != null) {
            ASN1Set createBerSetFromList2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(store2));
            if (createBerSetFromList2.size() > 0) {
                bERSequenceGenerator2.getRawOutputStream().write(new DERTaggedObject(false, 1, createBerSetFromList2).getEncoded());
            }
        }
        bERSequenceGenerator2.getRawOutputStream().write(instance.getSignerInfos().getDERObject().getEncoded());
        bERSequenceGenerator2.close();
        bERSequenceGenerator.close();
        return outputStream;
    }

    public static OutputStream replaceSigners(InputStream inputStream, SignerInformationStore signerInformationStore, OutputStream outputStream) throws CMSException, IOException {
        SignedDataParser instance = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser) new ASN1StreamParser(inputStream, CMSUtils.getMaximumMemory()).readObject()).getContent(16));
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject(CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject(instance.getVersion());
        instance.getDigestAlgorithms().getDERObject();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (SignerInformation signerInformation : signerInformationStore.getSigners()) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(signerInformation.getDigestAlgorithmID()));
        }
        bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
        ContentInfoParser encapContentInfo = instance.getEncapContentInfo();
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject(encapContentInfo.getContentType());
        pipeEncapsulatedOctetString(encapContentInfo, bERSequenceGenerator3.getRawOutputStream());
        bERSequenceGenerator3.close();
        writeSetToGeneratorTagged(bERSequenceGenerator2, instance.getCertificates(), 0);
        writeSetToGeneratorTagged(bERSequenceGenerator2, instance.getCrls(), 1);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (SignerInformation signerInformation2 : signerInformationStore.getSigners()) {
            aSN1EncodableVector2.add(signerInformation2.toSignerInfo());
        }
        bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector2).getEncoded());
        bERSequenceGenerator2.close();
        bERSequenceGenerator.close();
        return outputStream;
    }

    private static void writeSetToGeneratorTagged(ASN1Generator aSN1Generator, ASN1SetParser aSN1SetParser, int i) throws IOException {
        ASN1Set aSN1Set = getASN1Set(aSN1SetParser);
        if (aSN1Set != null) {
            aSN1Generator.getRawOutputStream().write((aSN1SetParser instanceof BERSetParser ? new BERTaggedObject(false, i, aSN1Set) : new DERTaggedObject(false, i, aSN1Set)).getEncoded());
        }
    }

    public Store getAttributeCertificates() throws CMSException {
        populateCertCrlSets();
        ASN1Set aSN1Set = this._certSet;
        if (aSN1Set == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(aSN1Set.size());
        Enumeration objects = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
            if (dERObject instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) dERObject;
                if (aSN1TaggedObject.getTagNo() == 2) {
                    arrayList.add(new X509AttributeCertificateHolder(AttributeCertificate.getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, false))));
                }
            }
        }
        return new CollectionStore(arrayList);
    }

    public X509Store getAttributeCertificates(String str, String str2) throws NoSuchStoreException, NoSuchProviderException, CMSException {
        return getAttributeCertificates(str, CMSUtils.getProvider(str2));
    }

    public X509Store getAttributeCertificates(String str, Provider provider) throws NoSuchStoreException, CMSException {
        if (this._attributeStore == null) {
            populateCertCrlSets();
            this._attributeStore = HELPER.createAttributeStore(str, provider, this._certSet);
        }
        return this._attributeStore;
    }

    public Store getCRLs() throws CMSException {
        populateCertCrlSets();
        ASN1Set aSN1Set = this._crlSet;
        if (aSN1Set == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(aSN1Set.size());
        Enumeration objects = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
            if (dERObject instanceof ASN1Sequence) {
                arrayList.add(new X509CRLHolder(CertificateList.getInstance(dERObject)));
            }
        }
        return new CollectionStore(arrayList);
    }

    public X509Store getCRLs(String str, String str2) throws NoSuchStoreException, NoSuchProviderException, CMSException {
        return getCRLs(str, CMSUtils.getProvider(str2));
    }

    public X509Store getCRLs(String str, Provider provider) throws NoSuchStoreException, CMSException {
        if (this._crlStore == null) {
            populateCertCrlSets();
            this._crlStore = HELPER.createCRLsStore(str, provider, this._crlSet);
        }
        return this._crlStore;
    }

    public Store getCertificates() throws CMSException {
        populateCertCrlSets();
        ASN1Set aSN1Set = this._certSet;
        if (aSN1Set == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(aSN1Set.size());
        Enumeration objects = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
            if (dERObject instanceof ASN1Sequence) {
                arrayList.add(new X509CertificateHolder(X509CertificateStructure.getInstance(dERObject)));
            }
        }
        return new CollectionStore(arrayList);
    }

    public X509Store getCertificates(String str, String str2) throws NoSuchStoreException, NoSuchProviderException, CMSException {
        return getCertificates(str, CMSUtils.getProvider(str2));
    }

    public X509Store getCertificates(String str, Provider provider) throws NoSuchStoreException, CMSException {
        if (this._certificateStore == null) {
            populateCertCrlSets();
            this._certificateStore = HELPER.createCertificateStore(str, provider, this._certSet);
        }
        return this._certificateStore;
    }

    public CertStore getCertificatesAndCRLs(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return getCertificatesAndCRLs(str, CMSUtils.getProvider(str2));
    }

    public CertStore getCertificatesAndCRLs(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        populateCertCrlSets();
        return HELPER.createCertStore(str, provider, this._certSet, this._crlSet);
    }

    public CMSTypedStream getSignedContent() {
        if (this._signedContent == null) {
            return null;
        }
        return new CMSTypedStream(this._signedContent.getContentType(), CMSUtils.attachDigestsToInputStream(this._digests.values(), this._signedContent.getContentStream()));
    }

    public String getSignedContentTypeOID() {
        return this._signedContentType.getId();
    }

    public SignerInformationStore getSignerInfos() throws CMSException {
        if (this._signerInfoStore == null) {
            populateCertCrlSets();
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            for (Object obj : this._digests.keySet()) {
                hashMap.put(obj, ((MessageDigest) this._digests.get(obj)).digest());
            }
            try {
                ASN1SetParser signerInfos = this._signedData.getSignerInfos();
                DefaultSignatureAlgorithmIdentifierFinder defaultSignatureAlgorithmIdentifierFinder = new DefaultSignatureAlgorithmIdentifierFinder();
                while (true) {
                    DEREncodable readObject = signerInfos.readObject();
                    if (readObject == null) {
                        break;
                    }
                    SignerInfo instance = SignerInfo.getInstance(readObject.getDERObject());
                    arrayList.add(new SignerInformation(instance, this._signedContentType, null, new BaseDigestCalculator((byte[]) hashMap.get(HELPER.getDigestAlgName(instance.getDigestAlgorithm().getAlgorithm().getId()))), defaultSignatureAlgorithmIdentifierFinder));
                }
                this._signerInfoStore = new SignerInformationStore(arrayList);
            } catch (IOException e) {
                throw new CMSException("io exception: " + e.getMessage(), e);
            }
        }
        return this._signerInfoStore;
    }

    public int getVersion() {
        return this._signedData.getVersion().getValue().intValue();
    }
}
