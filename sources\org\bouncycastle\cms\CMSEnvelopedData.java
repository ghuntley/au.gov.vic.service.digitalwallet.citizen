package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.NoSuchProviderException;
import java.security.Provider;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EncryptedContentInfo;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSEnvelopedHelper;

public class CMSEnvelopedData {
    ContentInfo contentInfo;
    private AlgorithmIdentifier encAlg;
    RecipientInformationStore recipientInfoStore;
    private ASN1Set unprotectedAttributes;

    public CMSEnvelopedData(InputStream inputStream) throws CMSException {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public CMSEnvelopedData(ContentInfo contentInfo2) {
        this.contentInfo = contentInfo2;
        EnvelopedData instance = EnvelopedData.getInstance(contentInfo2.getContent());
        ASN1Set recipientInfos = instance.getRecipientInfos();
        EncryptedContentInfo encryptedContentInfo = instance.getEncryptedContentInfo();
        this.encAlg = encryptedContentInfo.getContentEncryptionAlgorithm();
        this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(recipientInfos, this.encAlg, new CMSEnvelopedHelper.CMSEnvelopedSecureReadable(this.encAlg, new CMSProcessableByteArray(encryptedContentInfo.getEncryptedContent().getOctets())));
        this.unprotectedAttributes = instance.getUnprotectedAttrs();
    }

    public CMSEnvelopedData(byte[] bArr) throws CMSException {
        this(CMSUtils.readContentInfo(bArr));
    }

    private byte[] encodeObj(DEREncodable dEREncodable) throws IOException {
        if (dEREncodable != null) {
            return dEREncodable.getDERObject().getEncoded();
        }
        return null;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public byte[] getEncoded() throws IOException {
        return this.contentInfo.getEncoded();
    }

    public String getEncryptionAlgOID() {
        return this.encAlg.getObjectId().getId();
    }

    public byte[] getEncryptionAlgParams() {
        try {
            return encodeObj(this.encAlg.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AlgorithmParameters getEncryptionAlgorithmParameters(String str) throws CMSException, NoSuchProviderException {
        return getEncryptionAlgorithmParameters(CMSUtils.getProvider(str));
    }

    public AlgorithmParameters getEncryptionAlgorithmParameters(Provider provider) throws CMSException {
        return CMSEnvelopedHelper.INSTANCE.getEncryptionAlgorithmParameters(getEncryptionAlgOID(), getEncryptionAlgParams(), provider);
    }

    public RecipientInformationStore getRecipientInfos() {
        return this.recipientInfoStore;
    }

    public AttributeTable getUnprotectedAttributes() {
        ASN1Set aSN1Set = this.unprotectedAttributes;
        if (aSN1Set == null) {
            return null;
        }
        return new AttributeTable(aSN1Set);
    }
}
