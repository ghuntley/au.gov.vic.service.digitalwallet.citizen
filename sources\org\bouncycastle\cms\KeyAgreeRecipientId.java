package org.bouncycastle.cms;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.util.Arrays;

public class KeyAgreeRecipientId extends RecipientId {
    private X500Name issuer;
    private BigInteger serialNumber;
    private byte[] subjectKeyId;

    public KeyAgreeRecipientId(X500Name x500Name, BigInteger bigInteger) {
        super(2);
        this.issuer = x500Name;
        this.serialNumber = bigInteger;
        try {
            setIssuer(x500Name.getDEREncoded());
            setSerialNumber(bigInteger);
        } catch (IOException e) {
            throw new IllegalArgumentException("invalid issuer: " + e.getMessage());
        }
    }

    public KeyAgreeRecipientId(byte[] bArr) {
        super(2);
        super.setSubjectKeyIdentifier(new DEROctetString(bArr).getDEREncoded());
        this.subjectKeyId = bArr;
    }

    private boolean equalsObj(Object obj, Object obj2) {
        return obj != null ? obj.equals(obj2) : obj2 == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof KeyAgreeRecipientId)) {
            return false;
        }
        KeyAgreeRecipientId keyAgreeRecipientId = (KeyAgreeRecipientId) obj;
        return Arrays.areEqual(this.subjectKeyId, keyAgreeRecipientId.subjectKeyId) && equalsObj(this.serialNumber, keyAgreeRecipientId.serialNumber) && equalsObj(this.issuer, keyAgreeRecipientId.issuer);
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.subjectKeyId);
        BigInteger bigInteger = this.serialNumber;
        if (bigInteger != null) {
            hashCode ^= bigInteger.hashCode();
        }
        X500Name x500Name = this.issuer;
        return x500Name != null ? hashCode ^ x500Name.hashCode() : hashCode;
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object obj) {
        if (obj instanceof X509CertificateHolder) {
            X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
            if (getSerialNumber() != null) {
                IssuerAndSerialNumber issuerAndSerialNumber = x509CertificateHolder.getIssuerAndSerialNumber();
                return issuerAndSerialNumber.getName().equals(this.issuer) && issuerAndSerialNumber.getSerialNumber().getValue().equals(getSerialNumber());
            } else if (getSubjectKeyIdentifier() != null) {
                X509Extension extension = x509CertificateHolder.getExtension(X509Extension.subjectKeyIdentifier);
                if (extension == null) {
                    SHA1Digest sHA1Digest = new SHA1Digest();
                    byte[] bArr = new byte[sHA1Digest.getDigestSize()];
                    byte[] dEREncoded = x509CertificateHolder.getSubjectPublicKeyInfo().getDEREncoded();
                    sHA1Digest.update(dEREncoded, 0, dEREncoded.length);
                    sHA1Digest.doFinal(bArr, 0);
                    return Arrays.areEqual(this.subjectKeyId, bArr);
                }
                return Arrays.areEqual(this.subjectKeyId, ASN1OctetString.getInstance(extension.getParsedValue()).getOctets());
            }
        } else if (obj instanceof byte[]) {
            return Arrays.areEqual(this.subjectKeyId, (byte[]) obj);
        } else {
            if (obj instanceof KeyAgreeRecipientInformation) {
                return ((KeyAgreeRecipientInformation) obj).getRID().equals(this);
            }
        }
        return false;
    }
}
