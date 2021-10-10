package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.CompressedData;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.operator.InputExpanderProvider;

public class CMSCompressedData {
    ContentInfo contentInfo;

    public CMSCompressedData(InputStream inputStream) throws CMSException {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public CMSCompressedData(ContentInfo contentInfo2) throws CMSException {
        this.contentInfo = contentInfo2;
    }

    public CMSCompressedData(byte[] bArr) throws CMSException {
        this(CMSUtils.readContentInfo(bArr));
    }

    public byte[] getContent() throws CMSException {
        try {
            return CMSUtils.streamToByteArray(new InflaterInputStream(((ASN1OctetString) CompressedData.getInstance(this.contentInfo.getContent()).getEncapContentInfo().getContent()).getOctetStream()));
        } catch (IOException e) {
            throw new CMSException("exception reading compressed stream.", e);
        }
    }

    public byte[] getContent(int i) throws CMSException {
        try {
            return CMSUtils.streamToByteArray(new InflaterInputStream(((ASN1OctetString) CompressedData.getInstance(this.contentInfo.getContent()).getEncapContentInfo().getContent()).getOctetStream()), i);
        } catch (IOException e) {
            throw new CMSException("exception reading compressed stream.", e);
        }
    }

    public byte[] getContent(InputExpanderProvider inputExpanderProvider) throws CMSException {
        CompressedData instance = CompressedData.getInstance(this.contentInfo.getContent());
        try {
            return CMSUtils.streamToByteArray(inputExpanderProvider.get(instance.getCompressionAlgorithmIdentifier()).getInputStream(((ASN1OctetString) instance.getEncapContentInfo().getContent()).getOctetStream()));
        } catch (IOException e) {
            throw new CMSException("exception reading compressed stream.", e);
        }
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentInfo.getContentType();
    }

    public byte[] getEncoded() throws IOException {
        return this.contentInfo.getEncoded();
    }
}
