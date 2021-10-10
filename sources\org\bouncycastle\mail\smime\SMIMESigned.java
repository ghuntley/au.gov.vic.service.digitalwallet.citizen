package org.bouncycastle.mail.smime;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSSignedData;

public class SMIMESigned extends CMSSignedData {
    MimeBodyPart content;
    Object message;

    static {
        MailcapCommandMap defaultCommandMap = CommandMap.getDefaultCommandMap();
        defaultCommandMap.addMailcap("application/pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_signature");
        defaultCommandMap.addMailcap("application/pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_mime");
        defaultCommandMap.addMailcap("application/x-pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_signature");
        defaultCommandMap.addMailcap("application/x-pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_mime");
        defaultCommandMap.addMailcap("multipart/signed;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.multipart_signed");
        CommandMap.setDefaultCommandMap(defaultCommandMap);
    }

    public SMIMESigned(Part part) throws MessagingException, CMSException, SMIMEException {
        super(getInputStream(part));
        this.message = part;
        CMSProcessable signedContent = getSignedContent();
        if (signedContent != null) {
            this.content = SMIMEUtil.toMimeBodyPart((byte[]) signedContent.getContent());
        }
    }

    public SMIMESigned(MimeMultipart mimeMultipart) throws MessagingException, CMSException {
        super(new CMSProcessableBodyPartInbound(mimeMultipart.getBodyPart(0)), getInputStream(mimeMultipart.getBodyPart(1)));
        this.message = mimeMultipart;
        this.content = mimeMultipart.getBodyPart(0);
    }

    public SMIMESigned(MimeMultipart mimeMultipart, String str) throws MessagingException, CMSException {
        super(new CMSProcessableBodyPartInbound(mimeMultipart.getBodyPart(0), str), getInputStream(mimeMultipart.getBodyPart(1)));
        this.message = mimeMultipart;
        this.content = mimeMultipart.getBodyPart(0);
    }

    private static InputStream getInputStream(Part part) throws MessagingException {
        try {
            if (!part.isMimeType("multipart/signed")) {
                return part.getInputStream();
            }
            throw new MessagingException("attempt to create signed data object from multipart content - use MimeMultipart constructor.");
        } catch (IOException e) {
            throw new MessagingException("can't extract input stream: " + e);
        }
    }

    public MimeBodyPart getContent() {
        return this.content;
    }

    public MimeMessage getContentAsMimeMessage(Session session) throws MessagingException, IOException {
        byte[] bArr;
        Object content2 = getSignedContent().getContent();
        if (content2 instanceof byte[]) {
            bArr = (byte[]) content2;
        } else if (content2 instanceof MimePart) {
            MimePart mimePart = (MimePart) content2;
            ByteArrayOutputStream byteArrayOutputStream = mimePart.getSize() > 0 ? new ByteArrayOutputStream(mimePart.getSize()) : new ByteArrayOutputStream();
            mimePart.writeTo(byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
        } else {
            String name = content2 != null ? content2.getClass().getName() : "<null>";
            throw new MessagingException("Could not transfrom content of type " + name + " into MimeMessage.");
        }
        if (bArr != null) {
            return new MimeMessage(session, new ByteArrayInputStream(bArr));
        }
        return null;
    }

    public Object getContentWithSignature() {
        return this.message;
    }
}
