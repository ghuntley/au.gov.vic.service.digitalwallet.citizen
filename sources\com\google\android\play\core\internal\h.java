package com.google.android.play.core.internal;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* access modifiers changed from: package-private */
public class h extends X509Certificate {
    private final X509Certificate a;

    public h(X509Certificate x509Certificate) {
        this.a = x509Certificate;
    }

    @Override // java.security.cert.X509Certificate
    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.a.checkValidity();
    }

    @Override // java.security.cert.X509Certificate
    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.a.checkValidity(date);
    }

    public final int getBasicConstraints() {
        return this.a.getBasicConstraints();
    }

    @Override // java.security.cert.X509Extension
    public final Set<String> getCriticalExtensionOIDs() {
        return this.a.getCriticalExtensionOIDs();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.a.getEncoded();
    }

    public final byte[] getExtensionValue(String str) {
        return this.a.getExtensionValue(str);
    }

    public final Principal getIssuerDN() {
        return this.a.getIssuerDN();
    }

    public final boolean[] getIssuerUniqueID() {
        return this.a.getIssuerUniqueID();
    }

    public final boolean[] getKeyUsage() {
        return this.a.getKeyUsage();
    }

    @Override // java.security.cert.X509Extension
    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.a.getNonCriticalExtensionOIDs();
    }

    public final Date getNotAfter() {
        return this.a.getNotAfter();
    }

    public final Date getNotBefore() {
        return this.a.getNotBefore();
    }

    public final PublicKey getPublicKey() {
        return this.a.getPublicKey();
    }

    public final BigInteger getSerialNumber() {
        return this.a.getSerialNumber();
    }

    public final String getSigAlgName() {
        return this.a.getSigAlgName();
    }

    public final String getSigAlgOID() {
        return this.a.getSigAlgOID();
    }

    public final byte[] getSigAlgParams() {
        return this.a.getSigAlgParams();
    }

    public final byte[] getSignature() {
        return this.a.getSignature();
    }

    public final Principal getSubjectDN() {
        return this.a.getSubjectDN();
    }

    public final boolean[] getSubjectUniqueID() {
        return this.a.getSubjectUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.a.getTBSCertificate();
    }

    public final int getVersion() {
        return this.a.getVersion();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        return this.a.hasUnsupportedCriticalExtension();
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.a.verify(publicKey);
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.a.verify(publicKey, str);
    }
}
