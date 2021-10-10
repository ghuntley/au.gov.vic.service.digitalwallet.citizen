package org.bouncycastle.cms;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

class PasswordIntRecipientInfoGenerator implements IntRecipientInfoGenerator {
    private AlgorithmIdentifier keyDerivationAlgorithm;
    private SecretKey keyEncryptionKey;

    PasswordIntRecipientInfoGenerator() {
    }

    @Override // org.bouncycastle.cms.IntRecipientInfoGenerator
    public RecipientInfo generate(SecretKey secretKey, SecureRandom secureRandom, Provider provider) throws GeneralSecurityException {
        CMSEnvelopedHelper cMSEnvelopedHelper = CMSEnvelopedHelper.INSTANCE;
        Cipher createSymmetricCipher = cMSEnvelopedHelper.createSymmetricCipher(cMSEnvelopedHelper.getRFC3211WrapperName(this.keyEncryptionKey.getAlgorithm()), provider);
        createSymmetricCipher.init(3, this.keyEncryptionKey, secureRandom);
        DEROctetString dEROctetString = new DEROctetString(createSymmetricCipher.wrap(secretKey));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERObjectIdentifier(this.keyEncryptionKey.getAlgorithm()));
        aSN1EncodableVector.add(new DEROctetString(createSymmetricCipher.getIV()));
        return new RecipientInfo(new PasswordRecipientInfo(this.keyDerivationAlgorithm, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_PWRI_KEK, new DERSequence(aSN1EncodableVector)), dEROctetString));
    }

    /* access modifiers changed from: package-private */
    public void setKeyDerivationAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        this.keyDerivationAlgorithm = algorithmIdentifier;
    }

    /* access modifiers changed from: package-private */
    public void setKeyEncryptionKey(SecretKey secretKey) {
        this.keyEncryptionKey = secretKey;
    }
}
