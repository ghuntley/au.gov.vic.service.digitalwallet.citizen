package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Store;
import org.bouncycastle.x509.NoSuchStoreException;
import org.bouncycastle.x509.X509Store;

public class CMSSignedData {
    private static final CMSSignedHelper HELPER = CMSSignedHelper.INSTANCE;
    X509Store attributeStore;
    X509Store certificateStore;
    ContentInfo contentInfo;
    X509Store crlStore;
    private Map hashes;
    CMSProcessable signedContent;
    SignedData signedData;
    SignerInformationStore signerInfoStore;

    public CMSSignedData(InputStream inputStream) throws CMSException {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public CMSSignedData(Map map, ContentInfo contentInfo2) {
        this.hashes = map;
        this.contentInfo = contentInfo2;
        this.signedData = SignedData.getInstance(contentInfo2.getContent());
    }

    public CMSSignedData(Map map, byte[] bArr) throws CMSException {
        this(map, CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(ContentInfo contentInfo2) {
        this.contentInfo = contentInfo2;
        SignedData instance = SignedData.getInstance(contentInfo2.getContent());
        this.signedData = instance;
        this.signedContent = instance.getEncapContentInfo().getContent() != null ? new CMSProcessableByteArray(((ASN1OctetString) this.signedData.getEncapContentInfo().getContent()).getOctets()) : null;
    }

    public CMSSignedData(CMSProcessable cMSProcessable, InputStream inputStream) throws CMSException {
        this(cMSProcessable, CMSUtils.readContentInfo((InputStream) new ASN1InputStream(inputStream)));
    }

    public CMSSignedData(CMSProcessable cMSProcessable, ContentInfo contentInfo2) {
        this.signedContent = cMSProcessable;
        this.contentInfo = contentInfo2;
        this.signedData = SignedData.getInstance(contentInfo2.getContent());
    }

    public CMSSignedData(CMSProcessable cMSProcessable, byte[] bArr) throws CMSException {
        this(cMSProcessable, CMSUtils.readContentInfo(bArr));
    }

    private CMSSignedData(CMSSignedData cMSSignedData) {
        this.signedData = cMSSignedData.signedData;
        this.contentInfo = cMSSignedData.contentInfo;
        this.signedContent = cMSSignedData.signedContent;
        this.signerInfoStore = cMSSignedData.signerInfoStore;
    }

    public CMSSignedData(byte[] bArr) throws CMSException {
        this(CMSUtils.readContentInfo(bArr));
    }

    public static CMSSignedData replaceCertificatesAndCRLs(CMSSignedData cMSSignedData, CertStore certStore) throws CMSException {
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        try {
            ASN1Set createBerSetFromList = CMSUtils.createBerSetFromList(CMSUtils.getCertificatesFromStore(certStore));
            ASN1Set aSN1Set = createBerSetFromList.size() != 0 ? createBerSetFromList : null;
            try {
                ASN1Set createBerSetFromList2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(certStore));
                cMSSignedData2.signedData = new SignedData(cMSSignedData.signedData.getDigestAlgorithms(), cMSSignedData.signedData.getEncapContentInfo(), aSN1Set, createBerSetFromList2.size() != 0 ? createBerSetFromList2 : null, cMSSignedData.signedData.getSignerInfos());
                cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
                return cMSSignedData2;
            } catch (CertStoreException e) {
                throw new CMSException("error getting crls from certStore", e);
            }
        } catch (CertStoreException e2) {
            throw new CMSException("error getting certs from certStore", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    public static CMSSignedData replaceCertificatesAndCRLs(CMSSignedData cMSSignedData, Store store, Store store2, Store store3) throws CMSException {
        ASN1Set aSN1Set;
        ASN1Set aSN1Set2;
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        if (!(store == null && store2 == null)) {
            ArrayList arrayList = new ArrayList();
            if (store != null) {
                arrayList.addAll(CMSUtils.getCertificatesFromStore(store));
            }
            if (store2 != null) {
                arrayList.addAll(CMSUtils.getAttributeCertificatesFromStore(store2));
            }
            ASN1Set createBerSetFromList = CMSUtils.createBerSetFromList(arrayList);
            if (createBerSetFromList.size() != 0) {
                aSN1Set = createBerSetFromList;
                if (store3 != null) {
                    ASN1Set createBerSetFromList2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(store3));
                    if (createBerSetFromList2.size() != 0) {
                        aSN1Set2 = createBerSetFromList2;
                        cMSSignedData2.signedData = new SignedData(cMSSignedData.signedData.getDigestAlgorithms(), cMSSignedData.signedData.getEncapContentInfo(), aSN1Set, aSN1Set2, cMSSignedData.signedData.getSignerInfos());
                        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
                        return cMSSignedData2;
                    }
                }
                aSN1Set2 = null;
                cMSSignedData2.signedData = new SignedData(cMSSignedData.signedData.getDigestAlgorithms(), cMSSignedData.signedData.getEncapContentInfo(), aSN1Set, aSN1Set2, cMSSignedData.signedData.getSignerInfos());
                cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
                return cMSSignedData2;
            }
        }
        aSN1Set = null;
        if (store3 != null) {
        }
        aSN1Set2 = null;
        cMSSignedData2.signedData = new SignedData(cMSSignedData.signedData.getDigestAlgorithms(), cMSSignedData.signedData.getEncapContentInfo(), aSN1Set, aSN1Set2, cMSSignedData.signedData.getSignerInfos());
        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
        return cMSSignedData2;
    }

    public static CMSSignedData replaceSigners(CMSSignedData cMSSignedData, SignerInformationStore signerInformationStore) {
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        cMSSignedData2.signerInfoStore = signerInformationStore;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (SignerInformation signerInformation : signerInformationStore.getSigners()) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(signerInformation.getDigestAlgorithmID()));
            aSN1EncodableVector2.add(signerInformation.toSignerInfo());
        }
        DERSet dERSet = new DERSet(aSN1EncodableVector);
        DERSet dERSet2 = new DERSet(aSN1EncodableVector2);
        ASN1Sequence aSN1Sequence = (ASN1Sequence) cMSSignedData.signedData.getDERObject();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        aSN1EncodableVector3.add(aSN1Sequence.getObjectAt(0));
        aSN1EncodableVector3.add(dERSet);
        for (int i = 2; i != aSN1Sequence.size() - 1; i++) {
            aSN1EncodableVector3.add(aSN1Sequence.getObjectAt(i));
        }
        aSN1EncodableVector3.add(dERSet2);
        cMSSignedData2.signedData = SignedData.getInstance(new BERSequence(aSN1EncodableVector3));
        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
        return cMSSignedData2;
    }

    public Store getAttributeCertificates() {
        ASN1Set certificates = this.signedData.getCertificates();
        if (certificates == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(certificates.size());
        Enumeration objects = certificates.getObjects();
        while (objects.hasMoreElements()) {
            DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
            if (dERObject instanceof ASN1TaggedObject) {
                arrayList.add(new X509AttributeCertificateHolder(AttributeCertificate.getInstance(((ASN1TaggedObject) dERObject).getObject())));
            }
        }
        return new CollectionStore(arrayList);
    }

    public X509Store getAttributeCertificates(String str, String str2) throws NoSuchStoreException, NoSuchProviderException, CMSException {
        return getAttributeCertificates(str, CMSUtils.getProvider(str2));
    }

    public X509Store getAttributeCertificates(String str, Provider provider) throws NoSuchStoreException, CMSException {
        if (this.attributeStore == null) {
            this.attributeStore = HELPER.createAttributeStore(str, provider, this.signedData.getCertificates());
        }
        return this.attributeStore;
    }

    public Store getCRLs() {
        ASN1Set cRLs = this.signedData.getCRLs();
        if (cRLs == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(cRLs.size());
        Enumeration objects = cRLs.getObjects();
        while (objects.hasMoreElements()) {
            DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
            if (dERObject instanceof ASN1Sequence) {
                arrayList.add(CertificateList.getInstance(dERObject));
            }
        }
        return new CollectionStore(arrayList);
    }

    public X509Store getCRLs(String str, String str2) throws NoSuchStoreException, NoSuchProviderException, CMSException {
        return getCRLs(str, CMSUtils.getProvider(str2));
    }

    public X509Store getCRLs(String str, Provider provider) throws NoSuchStoreException, CMSException {
        if (this.crlStore == null) {
            this.crlStore = HELPER.createCRLsStore(str, provider, this.signedData.getCRLs());
        }
        return this.crlStore;
    }

    public Store getCertificates() {
        ASN1Set certificates = this.signedData.getCertificates();
        if (certificates == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(certificates.size());
        Enumeration objects = certificates.getObjects();
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
        if (this.certificateStore == null) {
            this.certificateStore = HELPER.createCertificateStore(str, provider, this.signedData.getCertificates());
        }
        return this.certificateStore;
    }

    public CertStore getCertificatesAndCRLs(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return getCertificatesAndCRLs(str, CMSUtils.getProvider(str2));
    }

    public CertStore getCertificatesAndCRLs(String str, Provider provider) throws NoSuchAlgorithmException, CMSException {
        return HELPER.createCertStore(str, provider, this.signedData.getCertificates(), this.signedData.getCRLs());
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public byte[] getEncoded() throws IOException {
        return this.contentInfo.getEncoded();
    }

    public CMSProcessable getSignedContent() {
        return this.signedContent;
    }

    public String getSignedContentTypeOID() {
        return this.signedData.getEncapContentInfo().getContentType().getId();
    }

    public SignerInformationStore getSignerInfos() {
        if (this.signerInfoStore == null) {
            ASN1Set signerInfos = this.signedData.getSignerInfos();
            ArrayList arrayList = new ArrayList();
            DefaultSignatureAlgorithmIdentifierFinder defaultSignatureAlgorithmIdentifierFinder = new DefaultSignatureAlgorithmIdentifierFinder();
            for (int i = 0; i != signerInfos.size(); i++) {
                SignerInfo instance = SignerInfo.getInstance(signerInfos.getObjectAt(i));
                ASN1ObjectIdentifier contentType = this.signedData.getEncapContentInfo().getContentType();
                Map map = this.hashes;
                arrayList.add(map == null ? new SignerInformation(instance, contentType, this.signedContent, null, defaultSignatureAlgorithmIdentifierFinder) : new SignerInformation(instance, contentType, null, new BaseDigestCalculator((byte[]) map.get(instance.getDigestAlgorithm().getAlgorithm().getId())), defaultSignatureAlgorithmIdentifierFinder));
            }
            this.signerInfoStore = new SignerInformationStore(arrayList);
        }
        return this.signerInfoStore;
    }

    public int getVersion() {
        return this.signedData.getVersion().getValue().intValue();
    }
}
