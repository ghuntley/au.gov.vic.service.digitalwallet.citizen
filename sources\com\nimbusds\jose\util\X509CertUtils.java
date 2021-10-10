package com.nimbusds.jose.util;

import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class X509CertUtils {
    private static final String PEM_BEGIN_MARKER = "-----BEGIN CERTIFICATE-----";
    private static final String PEM_END_MARKER = "-----END CERTIFICATE-----";

    public static X509Certificate parse(byte[] bArr) {
        try {
            return parseWithException(bArr);
        } catch (CertificateException unused) {
            return null;
        }
    }

    public static X509Certificate parseWithException(byte[] bArr) throws CertificateException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        if (generateCertificate instanceof X509Certificate) {
            return (X509Certificate) generateCertificate;
        }
        throw new CertificateException("Not a X.509 certificate: " + generateCertificate.getType());
    }

    public static X509Certificate parse(String str) {
        int indexOf;
        String substring;
        int indexOf2;
        if (str == null || str.isEmpty() || (indexOf = str.indexOf(PEM_BEGIN_MARKER)) < 0 || (indexOf2 = (substring = str.substring(indexOf + 27)).indexOf(PEM_END_MARKER)) < 0) {
            return null;
        }
        return parse(new Base64(substring.substring(0, indexOf2).replaceAll("\\s", "")).decode());
    }

    public static X509Certificate parseWithException(String str) throws CertificateException {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int indexOf = str.indexOf(PEM_BEGIN_MARKER);
        if (indexOf >= 0) {
            String substring = str.substring(indexOf + 27);
            int indexOf2 = substring.indexOf(PEM_END_MARKER);
            if (indexOf2 >= 0) {
                return parseWithException(new Base64(substring.substring(0, indexOf2).replaceAll("\\s", "")).decode());
            }
            throw new CertificateException("PEM end marker not found");
        }
        throw new CertificateException("PEM begin marker not found");
    }

    public static String toPEMString(X509Certificate x509Certificate) {
        return toPEMString(x509Certificate, true);
    }

    public static String toPEMString(X509Certificate x509Certificate, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(PEM_BEGIN_MARKER);
        if (z) {
            sb.append('\n');
        }
        try {
            sb.append(Base64.encode(x509Certificate.getEncoded()).toString());
            if (z) {
                sb.append('\n');
            }
            sb.append(PEM_END_MARKER);
            return sb.toString();
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    public static Base64URL computeSHA256Thumbprint(X509Certificate x509Certificate) {
        try {
            return Base64URL.encode(MessageDigest.getInstance("SHA-256").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException | CertificateEncodingException unused) {
            return null;
        }
    }
}
