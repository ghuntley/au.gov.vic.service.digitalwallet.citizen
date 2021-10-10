package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.security.Provider;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.AuthEnvelopedData;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.OriginatorInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

class CMSAuthEnvelopedData {
    private ASN1Set authAttrs;
    private AlgorithmIdentifier authEncAlg;
    ContentInfo contentInfo;
    private byte[] mac;
    private OriginatorInfo originator;
    RecipientInformationStore recipientInfoStore;
    private ASN1Set unauthAttrs;

    public CMSAuthEnvelopedData(InputStream inputStream) throws CMSException {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public CMSAuthEnvelopedData(ContentInfo contentInfo2) throws CMSException {
        this.contentInfo = contentInfo2;
        AuthEnvelopedData instance = AuthEnvelopedData.getInstance(contentInfo2.getContent());
        this.originator = instance.getOriginatorInfo();
        ASN1Set recipientInfos = instance.getRecipientInfos();
        this.authEncAlg = instance.getAuthEncryptedContentInfo().getContentEncryptionAlgorithm();
        this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(recipientInfos, this.authEncAlg, new CMSSecureReadable() {
            /* class org.bouncycastle.cms.CMSAuthEnvelopedData.AnonymousClass1 */

            @Override // org.bouncycastle.cms.CMSSecureReadable
            public AlgorithmIdentifier getAlgorithm() {
                return CMSAuthEnvelopedData.this.authEncAlg;
            }

            @Override // org.bouncycastle.cms.CMSSecureReadable
            public Object getCryptoObject() {
                return null;
            }

            @Override // org.bouncycastle.cms.CMSSecureReadable
            public InputStream getInputStream() throws IOException, CMSException {
                return null;
            }

            @Override // org.bouncycastle.cms.CMSSecureReadable
            public CMSReadable getReadable(SecretKey secretKey, Provider provider) throws CMSException {
                throw new CMSException("AuthEnveloped data decryption not yet implemented");
            }
        });
        this.authAttrs = instance.getAuthAttrs();
        this.mac = instance.getMac().getOctets();
        this.unauthAttrs = instance.getUnauthAttrs();
    }

    public CMSAuthEnvelopedData(byte[] bArr) throws CMSException {
        this(CMSUtils.readContentInfo(bArr));
    }
}
