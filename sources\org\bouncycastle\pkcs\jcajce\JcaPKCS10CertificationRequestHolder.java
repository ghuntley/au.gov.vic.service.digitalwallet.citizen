package org.bouncycastle.pkcs.jcajce;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Hashtable;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.JcaJceHelper;
import org.bouncycastle.jcajce.NamedJcaJceHelper;
import org.bouncycastle.jcajce.ProviderJcaJceHelper;
import org.bouncycastle.pkcs.PKCS10CertificationRequestHolder;

public class JcaPKCS10CertificationRequestHolder extends PKCS10CertificationRequestHolder {
    private static Hashtable keyAlgorithms;
    private JcaJceHelper helper = new DefaultJcaJceHelper();

    static {
        Hashtable hashtable = new Hashtable();
        keyAlgorithms = hashtable;
        hashtable.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        keyAlgorithms.put(X9ObjectIdentifiers.id_dsa, "DSA");
    }

    public JcaPKCS10CertificationRequestHolder(CertificationRequest certificationRequest) {
        super(certificationRequest);
    }

    public JcaPKCS10CertificationRequestHolder(PKCS10CertificationRequestHolder pKCS10CertificationRequestHolder) {
        super(pKCS10CertificationRequestHolder.toASN1Structure());
    }

    public JcaPKCS10CertificationRequestHolder(byte[] bArr) throws IOException {
        super(bArr);
    }

    public PublicKey getPublicKey() throws InvalidKeyException, NoSuchAlgorithmException {
        KeyFactory keyFactory;
        try {
            SubjectPublicKeyInfo subjectPublicKeyInfo = getSubjectPublicKeyInfo();
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded());
            try {
                keyFactory = this.helper.createKeyFactory(subjectPublicKeyInfo.getAlgorithmId().getAlgorithm().getId());
            } catch (NoSuchAlgorithmException e) {
                if (keyAlgorithms.get(subjectPublicKeyInfo.getAlgorithmId().getAlgorithm()) != null) {
                    keyFactory = this.helper.createKeyFactory((String) keyAlgorithms.get(subjectPublicKeyInfo.getAlgorithmId().getAlgorithm()));
                } else {
                    throw e;
                }
            }
            return keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (InvalidKeySpecException unused) {
            throw new InvalidKeyException("error decoding public key");
        } catch (IOException unused2) {
            throw new InvalidKeyException("error extracting key encoding");
        } catch (NoSuchProviderException e2) {
            throw new NoSuchAlgorithmException("cannot find provider: " + e2.getMessage());
        }
    }

    public JcaPKCS10CertificationRequestHolder setProvider(String str) {
        this.helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcaPKCS10CertificationRequestHolder setProvider(Provider provider) {
        this.helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
