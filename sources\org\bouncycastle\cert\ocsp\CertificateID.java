package org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class CertificateID {
    public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    private final CertID id;

    public CertificateID(CertID certID) {
        if (certID != null) {
            this.id = certID;
            return;
        }
        throw new IllegalArgumentException("'id' cannot be null");
    }

    public CertificateID(DigestCalculator digestCalculator, X509CertificateHolder x509CertificateHolder, BigInteger bigInteger) throws OCSPException {
        this.id = createCertID(digestCalculator, x509CertificateHolder, new DERInteger(bigInteger));
    }

    private static CertID createCertID(DigestCalculator digestCalculator, X509CertificateHolder x509CertificateHolder, DERInteger dERInteger) throws OCSPException {
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(x509CertificateHolder.toASN1Structure().getSubject().getDEREncoded());
            outputStream.close();
            DEROctetString dEROctetString = new DEROctetString(digestCalculator.getDigest());
            SubjectPublicKeyInfo subjectPublicKeyInfo = x509CertificateHolder.getSubjectPublicKeyInfo();
            OutputStream outputStream2 = digestCalculator.getOutputStream();
            outputStream2.write(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            outputStream2.close();
            return new CertID(digestCalculator.getAlgorithmIdentifier(), dEROctetString, new DEROctetString(digestCalculator.getDigest()), dERInteger);
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }

    public static CertificateID deriveCertificateID(CertificateID certificateID, BigInteger bigInteger) {
        return new CertificateID(new CertID(certificateID.id.getHashAlgorithm(), certificateID.id.getIssuerNameHash(), certificateID.id.getIssuerKeyHash(), new DERInteger(bigInteger)));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CertificateID)) {
            return false;
        }
        return this.id.getDERObject().equals(((CertificateID) obj).id.getDERObject());
    }

    public ASN1ObjectIdentifier getHashAlgOID() {
        return this.id.getHashAlgorithm().getAlgorithm();
    }

    public byte[] getIssuerKeyHash() {
        return this.id.getIssuerKeyHash().getOctets();
    }

    public byte[] getIssuerNameHash() {
        return this.id.getIssuerNameHash().getOctets();
    }

    public BigInteger getSerialNumber() {
        return this.id.getSerialNumber().getValue();
    }

    public int hashCode() {
        return this.id.getDERObject().hashCode();
    }

    public boolean matchesIssuer(X509CertificateHolder x509CertificateHolder, DigestCalculatorProvider digestCalculatorProvider) throws OCSPException {
        try {
            return createCertID(digestCalculatorProvider.get(this.id.getHashAlgorithm()), x509CertificateHolder, this.id.getSerialNumber()).equals(this.id);
        } catch (OperatorCreationException e) {
            throw new OCSPException("unable to create digest calculator: " + e.getMessage(), e);
        }
    }

    public CertID toASN1Object() {
        return this.id;
    }
}
