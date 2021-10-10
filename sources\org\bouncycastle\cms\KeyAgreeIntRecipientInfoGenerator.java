package org.bouncycastle.cms;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientIdentifier;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.bouncycastle.asn1.cms.OriginatorIdentifierOrKey;
import org.bouncycastle.asn1.cms.OriginatorPublicKey;
import org.bouncycastle.asn1.cms.RecipientEncryptedKey;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.cms.ecc.MQVuserKeyingMaterial;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.spec.MQVPrivateKeySpec;
import org.bouncycastle.jce.spec.MQVPublicKeySpec;

/* access modifiers changed from: package-private */
public class KeyAgreeIntRecipientInfoGenerator implements IntRecipientInfoGenerator {
    private DERObjectIdentifier keyAgreementOID;
    private DERObjectIdentifier keyEncryptionOID;
    private ArrayList recipientCerts;
    private KeyPair senderKeyPair;

    KeyAgreeIntRecipientInfoGenerator() {
    }

    private static OriginatorPublicKey createOriginatorPublicKey(PublicKey publicKey) throws IOException {
        SubjectPublicKeyInfo instance = SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray(publicKey.getEncoded()));
        return new OriginatorPublicKey(new AlgorithmIdentifier(instance.getAlgorithmId().getObjectId(), DERNull.INSTANCE), instance.getPublicKeyData().getBytes());
    }

    @Override // org.bouncycastle.cms.IntRecipientInfoGenerator
    public RecipientInfo generate(SecretKey secretKey, SecureRandom secureRandom, Provider provider) throws GeneralSecurityException {
        PublicKey publicKey = this.senderKeyPair.getPublic();
        PrivateKey privateKey = this.senderKeyPair.getPrivate();
        try {
            OriginatorIdentifierOrKey originatorIdentifierOrKey = new OriginatorIdentifierOrKey(createOriginatorPublicKey(publicKey));
            DEROctetString dEROctetString = null;
            if (this.keyAgreementOID.getId().equals(CMSEnvelopedGenerator.ECMQV_SHA1KDF)) {
                try {
                    ECParameterSpec params = ((ECPublicKey) publicKey).getParams();
                    KeyPairGenerator instance = KeyPairGenerator.getInstance(this.keyAgreementOID.getId(), provider);
                    instance.initialize(params, secureRandom);
                    KeyPair generateKeyPair = instance.generateKeyPair();
                    DEROctetString dEROctetString2 = new DEROctetString(new MQVuserKeyingMaterial(createOriginatorPublicKey(generateKeyPair.getPublic()), null));
                    privateKey = new MQVPrivateKeySpec(privateKey, generateKeyPair.getPrivate(), generateKeyPair.getPublic());
                    dEROctetString = dEROctetString2;
                } catch (InvalidAlgorithmParameterException e) {
                    throw new InvalidKeyException("cannot determine MQV ephemeral key pair parameters from public key: " + e);
                } catch (IOException e2) {
                    throw new InvalidKeyException("cannot extract MQV ephemeral public key: " + e2);
                }
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(this.keyEncryptionOID);
            aSN1EncodableVector.add(DERNull.INSTANCE);
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(this.keyAgreementOID, new DERSequence(aSN1EncodableVector));
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            Iterator it = this.recipientCerts.iterator();
            while (it.hasNext()) {
                X509Certificate x509Certificate = (X509Certificate) it.next();
                KeyAgreeRecipientIdentifier keyAgreeRecipientIdentifier = new KeyAgreeRecipientIdentifier(CMSUtils.getIssuerAndSerialNumber(x509Certificate));
                PublicKey publicKey2 = x509Certificate.getPublicKey();
                if (this.keyAgreementOID.getId().equals(CMSEnvelopedGenerator.ECMQV_SHA1KDF)) {
                    publicKey2 = new MQVPublicKeySpec(publicKey2, publicKey2);
                }
                KeyAgreement instance2 = KeyAgreement.getInstance(this.keyAgreementOID.getId(), provider);
                instance2.init(privateKey, secureRandom);
                instance2.doPhase(publicKey2, true);
                SecretKey generateSecret = instance2.generateSecret(this.keyEncryptionOID.getId());
                Cipher createSymmetricCipher = CMSEnvelopedHelper.INSTANCE.createSymmetricCipher(this.keyEncryptionOID.getId(), provider);
                createSymmetricCipher.init(3, generateSecret, secureRandom);
                aSN1EncodableVector2.add(new RecipientEncryptedKey(keyAgreeRecipientIdentifier, new DEROctetString(createSymmetricCipher.wrap(secretKey))));
            }
            return new RecipientInfo(new KeyAgreeRecipientInfo(originatorIdentifierOrKey, dEROctetString, algorithmIdentifier, new DERSequence(aSN1EncodableVector2)));
        } catch (IOException e3) {
            throw new InvalidKeyException("cannot extract originator public key: " + e3);
        }
    }

    /* access modifiers changed from: package-private */
    public void setKeyAgreementOID(DERObjectIdentifier dERObjectIdentifier) {
        this.keyAgreementOID = dERObjectIdentifier;
    }

    /* access modifiers changed from: package-private */
    public void setKeyEncryptionOID(DERObjectIdentifier dERObjectIdentifier) {
        this.keyEncryptionOID = dERObjectIdentifier;
    }

    /* access modifiers changed from: package-private */
    public void setRecipientCerts(Collection collection) {
        this.recipientCerts = new ArrayList(collection);
    }

    /* access modifiers changed from: package-private */
    public void setSenderKeyPair(KeyPair keyPair) {
        this.senderKeyPair = keyPair;
    }
}
