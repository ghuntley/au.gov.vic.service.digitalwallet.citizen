package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.NoSuchProviderException;
import java.security.Provider;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.EncryptedContentInfoParser;
import org.bouncycastle.asn1.cms.EnvelopedDataParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSEnvelopedHelper;

public class CMSEnvelopedDataParser extends CMSContentInfoParser {
    private boolean _attrNotRead;
    private AlgorithmIdentifier _encAlg;
    EnvelopedDataParser _envelopedData;
    RecipientInformationStore _recipientInfoStore;
    private AttributeTable _unprotectedAttributes;

    public CMSEnvelopedDataParser(InputStream inputStream) throws CMSException, IOException {
        super(inputStream);
        this._attrNotRead = true;
        EnvelopedDataParser envelopedDataParser = new EnvelopedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16));
        this._envelopedData = envelopedDataParser;
        ASN1Set instance = ASN1Set.getInstance(envelopedDataParser.getRecipientInfos().getDERObject());
        EncryptedContentInfoParser encryptedContentInfo = this._envelopedData.getEncryptedContentInfo();
        this._encAlg = encryptedContentInfo.getContentEncryptionAlgorithm();
        this._recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(instance, this._encAlg, new CMSEnvelopedHelper.CMSEnvelopedSecureReadable(this._encAlg, new CMSProcessableInputStream(((ASN1OctetStringParser) encryptedContentInfo.getEncryptedContent(4)).getOctetStream())));
    }

    public CMSEnvelopedDataParser(byte[] bArr) throws CMSException, IOException {
        this(new ByteArrayInputStream(bArr));
    }

    private byte[] encodeObj(DEREncodable dEREncodable) throws IOException {
        if (dEREncodable != null) {
            return dEREncodable.getDERObject().getEncoded();
        }
        return null;
    }

    public String getEncryptionAlgOID() {
        return this._encAlg.getObjectId().toString();
    }

    public byte[] getEncryptionAlgParams() {
        try {
            return encodeObj(this._encAlg.getParameters());
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
        return this._recipientInfoStore;
    }

    public AttributeTable getUnprotectedAttributes() throws IOException {
        if (this._unprotectedAttributes == null && this._attrNotRead) {
            ASN1SetParser unprotectedAttrs = this._envelopedData.getUnprotectedAttrs();
            this._attrNotRead = false;
            if (unprotectedAttrs != null) {
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                while (true) {
                    DEREncodable readObject = unprotectedAttrs.readObject();
                    if (readObject == null) {
                        break;
                    }
                    aSN1EncodableVector.add(((ASN1SequenceParser) readObject).getDERObject());
                }
                this._unprotectedAttributes = new AttributeTable(new DERSet(aSN1EncodableVector));
            }
        }
        return this._unprotectedAttributes;
    }
}
