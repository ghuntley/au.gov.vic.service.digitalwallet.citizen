package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BEROctetStringGenerator;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.TBSCertificateStructure;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.io.Streams;
import org.bouncycastle.util.io.TeeInputStream;
import org.bouncycastle.util.io.TeeOutputStream;

/* access modifiers changed from: package-private */
public class CMSUtils {
    private static final Runtime RUNTIME = Runtime.getRuntime();

    CMSUtils() {
    }

    static InputStream attachDigestsToInputStream(Collection collection, InputStream inputStream) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            inputStream = new TeeInputStream(inputStream, new DigOutputStream((MessageDigest) it.next()));
        }
        return inputStream;
    }

    static OutputStream attachDigestsToOutputStream(Collection collection, OutputStream outputStream) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            outputStream = getSafeTeeOutputStream(outputStream, new DigOutputStream((MessageDigest) it.next()));
        }
        return outputStream;
    }

    static OutputStream attachSignersToOutputStream(Collection collection, OutputStream outputStream) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            outputStream = getSafeTeeOutputStream(outputStream, ((SignerInfoGenerator) it.next()).getCalculatingOutputStream());
        }
        return outputStream;
    }

    static OutputStream createBEROctetOutputStream(OutputStream outputStream, int i, boolean z, int i2) throws IOException {
        BEROctetStringGenerator bEROctetStringGenerator = new BEROctetStringGenerator(outputStream, i, z);
        return i2 != 0 ? bEROctetStringGenerator.getOctetOutputStream(new byte[i2]) : bEROctetStringGenerator.getOctetOutputStream();
    }

    static ASN1Set createBerSetFromList(List list) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.add((DEREncodable) it.next());
        }
        return new BERSet(aSN1EncodableVector);
    }

    static ASN1Set createDerSetFromList(List list) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.add((DEREncodable) it.next());
        }
        return new DERSet(aSN1EncodableVector);
    }

    static List getAttributeCertificatesFromStore(Store store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            for (X509AttributeCertificateHolder x509AttributeCertificateHolder : store.getMatches(null)) {
                arrayList.add(new DERTaggedObject(false, 2, x509AttributeCertificateHolder.toASN1Structure()));
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    static List getCRLsFromStore(CertStore certStore) throws CertStoreException, CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<? extends CRL> it = certStore.getCRLs(null).iterator();
            while (it.hasNext()) {
                arrayList.add(CertificateList.getInstance(ASN1Object.fromByteArray(((X509CRL) it.next()).getEncoded())));
            }
            return arrayList;
        } catch (IllegalArgumentException e) {
            throw new CMSException("error processing crls", e);
        } catch (IOException e2) {
            throw new CMSException("error processing crls", e2);
        } catch (CRLException e3) {
            throw new CMSException("error encoding crls", e3);
        }
    }

    static List getCRLsFromStore(Store store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            for (X509CRLHolder x509CRLHolder : store.getMatches(null)) {
                arrayList.add(x509CRLHolder.toASN1Structure());
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    static List getCertificatesFromStore(CertStore certStore) throws CertStoreException, CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<? extends Certificate> it = certStore.getCertificates(null).iterator();
            while (it.hasNext()) {
                arrayList.add(X509CertificateStructure.getInstance(ASN1Object.fromByteArray(((X509Certificate) it.next()).getEncoded())));
            }
            return arrayList;
        } catch (IllegalArgumentException e) {
            throw new CMSException("error processing certs", e);
        } catch (IOException e2) {
            throw new CMSException("error processing certs", e2);
        } catch (CertificateEncodingException e3) {
            throw new CMSException("error encoding certs", e3);
        }
    }

    static List getCertificatesFromStore(Store store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            for (X509CertificateHolder x509CertificateHolder : store.getMatches(null)) {
                arrayList.add(x509CertificateHolder.toASN1Structure());
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    static IssuerAndSerialNumber getIssuerAndSerialNumber(X509Certificate x509Certificate) {
        TBSCertificateStructure tBSCertificateStructure = getTBSCertificateStructure(x509Certificate);
        return new IssuerAndSerialNumber(tBSCertificateStructure.getIssuer(), tBSCertificateStructure.getSerialNumber().getValue());
    }

    static int getMaximumMemory() {
        long maxMemory = RUNTIME.maxMemory();
        if (maxMemory > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) maxMemory;
    }

    public static Provider getProvider(String str) throws NoSuchProviderException {
        if (str == null) {
            return null;
        }
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new NoSuchProviderException("provider " + str + " not found.");
    }

    static OutputStream getSafeOutputStream(OutputStream outputStream) {
        return outputStream == null ? new NullOutputStream() : outputStream;
    }

    static OutputStream getSafeTeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        return outputStream == null ? getSafeOutputStream(outputStream2) : outputStream2 == null ? getSafeOutputStream(outputStream) : new TeeOutputStream(outputStream, outputStream2);
    }

    static TBSCertificateStructure getTBSCertificateStructure(X509Certificate x509Certificate) {
        try {
            return TBSCertificateStructure.getInstance(ASN1Object.fromByteArray(x509Certificate.getTBSCertificate()));
        } catch (Exception unused) {
            throw new IllegalArgumentException("can't extract TBS structure from this cert");
        }
    }

    static ContentInfo readContentInfo(InputStream inputStream) throws CMSException {
        return readContentInfo(new ASN1InputStream(inputStream, getMaximumMemory()));
    }

    private static ContentInfo readContentInfo(ASN1InputStream aSN1InputStream) throws CMSException {
        try {
            return ContentInfo.getInstance(aSN1InputStream.readObject());
        } catch (IOException e) {
            throw new CMSException("IOException reading content.", e);
        } catch (ClassCastException e2) {
            throw new CMSException("Malformed content.", e2);
        } catch (IllegalArgumentException e3) {
            throw new CMSException("Malformed content.", e3);
        }
    }

    static ContentInfo readContentInfo(byte[] bArr) throws CMSException {
        return readContentInfo(new ASN1InputStream(bArr));
    }

    public static byte[] streamToByteArray(InputStream inputStream) throws IOException {
        return Streams.readAll(inputStream);
    }

    public static byte[] streamToByteArray(InputStream inputStream, int i) throws IOException {
        return Streams.readAllLimited(inputStream, i);
    }
}
