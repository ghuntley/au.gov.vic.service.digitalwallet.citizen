package org.bouncycastle.cms;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientIdentifier;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.TBSCertificateStructure;

class KeyTransIntRecipientInfoGenerator implements IntRecipientInfoGenerator {
    private SubjectPublicKeyInfo info;
    private PublicKey recipientPublicKey;
    private TBSCertificateStructure recipientTBSCert;
    private ASN1OctetString subjectKeyIdentifier;

    KeyTransIntRecipientInfoGenerator() {
    }

    @Override // org.bouncycastle.cms.IntRecipientInfoGenerator
    public RecipientInfo generate(SecretKey secretKey, SecureRandom secureRandom, Provider provider) throws GeneralSecurityException {
        byte[] bArr;
        AlgorithmIdentifier algorithmId = this.info.getAlgorithmId();
        Cipher createAsymmetricCipher = CMSEnvelopedHelper.INSTANCE.createAsymmetricCipher(algorithmId.getObjectId().getId(), provider);
        try {
            createAsymmetricCipher.init(3, this.recipientPublicKey, secureRandom);
            bArr = createAsymmetricCipher.wrap(secretKey);
        } catch (IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException unused) {
            bArr = null;
        }
        if (bArr == null) {
            createAsymmetricCipher.init(1, this.recipientPublicKey, secureRandom);
            bArr = createAsymmetricCipher.doFinal(secretKey.getEncoded());
        }
        TBSCertificateStructure tBSCertificateStructure = this.recipientTBSCert;
        return new RecipientInfo(new KeyTransRecipientInfo(tBSCertificateStructure != null ? new RecipientIdentifier(new IssuerAndSerialNumber(tBSCertificateStructure.getIssuer(), this.recipientTBSCert.getSerialNumber().getValue())) : new RecipientIdentifier(this.subjectKeyIdentifier), algorithmId, new DEROctetString(bArr)));
    }

    /* access modifiers changed from: package-private */
    public void setRecipientCert(X509Certificate x509Certificate) {
        this.recipientTBSCert = CMSUtils.getTBSCertificateStructure(x509Certificate);
        this.recipientPublicKey = x509Certificate.getPublicKey();
        this.info = this.recipientTBSCert.getSubjectPublicKeyInfo();
    }

    /* access modifiers changed from: package-private */
    public void setRecipientPublicKey(PublicKey publicKey) {
        this.recipientPublicKey = publicKey;
        try {
            this.info = SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray(publicKey.getEncoded()));
        } catch (IOException unused) {
            throw new IllegalArgumentException("can't extract key algorithm from this key");
        }
    }

    /* access modifiers changed from: package-private */
    public void setSubjectKeyIdentifier(ASN1OctetString aSN1OctetString) {
        this.subjectKeyIdentifier = aSN1OctetString;
    }
}
