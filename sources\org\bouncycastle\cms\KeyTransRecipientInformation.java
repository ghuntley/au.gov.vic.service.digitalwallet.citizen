package org.bouncycastle.cms;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KeyTransRecipientInformation extends RecipientInformation {
    private KeyTransRecipientInfo info;

    KeyTransRecipientInformation(KeyTransRecipientInfo keyTransRecipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        super(keyTransRecipientInfo.getKeyEncryptionAlgorithm(), algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        KeyTransRecipientId keyTransRecipientId;
        this.info = keyTransRecipientInfo;
        RecipientIdentifier recipientIdentifier = keyTransRecipientInfo.getRecipientIdentifier();
        boolean isTagged = recipientIdentifier.isTagged();
        DEREncodable id = recipientIdentifier.getId();
        if (isTagged) {
            keyTransRecipientId = new KeyTransRecipientId(ASN1OctetString.getInstance(id).getOctets());
        } else {
            IssuerAndSerialNumber instance = IssuerAndSerialNumber.getInstance(id);
            keyTransRecipientId = new KeyTransRecipientId(instance.getName(), instance.getSerialNumber().getValue());
        }
        this.rid = keyTransRecipientId;
    }

    private String getExchangeEncryptionAlgorithmName(DERObjectIdentifier dERObjectIdentifier) {
        return PKCSObjectIdentifiers.rsaEncryption.equals(dERObjectIdentifier) ? "RSA/ECB/PKCS1Padding" : dERObjectIdentifier.getId();
    }

    @Override // org.bouncycastle.cms.RecipientInformation
    public CMSTypedStream getContentStream(Key key, String str) throws CMSException, NoSuchProviderException {
        return getContentStream(key, CMSUtils.getProvider(str));
    }

    @Override // org.bouncycastle.cms.RecipientInformation
    public CMSTypedStream getContentStream(Key key, Provider provider) throws CMSException {
        return getContentFromSessionKey(getSessionKey(key, provider), provider);
    }

    /* access modifiers changed from: protected */
    @Override // org.bouncycastle.cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient recipient) throws CMSException {
        return ((KeyTransRecipient) recipient).getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, this.info.getEncryptedKey().getOctets());
    }

    /* access modifiers changed from: protected */
    public Key getSessionKey(Key key, Provider provider) throws CMSException {
        Key key2 = null;
        try {
            Cipher createAsymmetricCipher = CMSEnvelopedHelper.INSTANCE.createAsymmetricCipher(getExchangeEncryptionAlgorithmName(this.keyEncAlg.getObjectId()), provider);
            byte[] octets = this.info.getEncryptedKey().getOctets();
            String contentAlgorithmName = getContentAlgorithmName();
            try {
                createAsymmetricCipher.init(4, key);
                key2 = createAsymmetricCipher.unwrap(octets, contentAlgorithmName, 3);
            } catch (IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException unused) {
            }
            if (key2 != null) {
                return key2;
            }
            createAsymmetricCipher.init(2, key);
            return new SecretKeySpec(createAsymmetricCipher.doFinal(octets), contentAlgorithmName);
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find algorithm.", e);
        } catch (InvalidKeyException e2) {
            throw new CMSException("key invalid in message.", e2);
        } catch (NoSuchPaddingException e3) {
            throw new CMSException("required padding not supported.", e3);
        } catch (IllegalBlockSizeException e4) {
            throw new CMSException("illegal blocksize in message.", e4);
        } catch (BadPaddingException e5) {
            throw new CMSException("bad padding in message.", e5);
        }
    }
}
