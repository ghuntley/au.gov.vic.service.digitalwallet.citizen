package org.bouncycastle.mail.smime;

import java.io.IOException;
import java.io.InputStream;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimePart;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.CMSException;

public class SMIMEEnveloped extends CMSEnvelopedData {
    MimePart message;

    public SMIMEEnveloped(MimeBodyPart mimeBodyPart) throws MessagingException, CMSException {
        super(getInputStream(mimeBodyPart));
        this.message = mimeBodyPart;
    }

    public SMIMEEnveloped(MimeMessage mimeMessage) throws MessagingException, CMSException {
        super(getInputStream(mimeMessage));
        this.message = mimeMessage;
    }

    private static InputStream getInputStream(Part part) throws MessagingException {
        try {
            return part.getInputStream();
        } catch (IOException e) {
            throw new MessagingException("can't extract input stream: " + e);
        }
    }

    public MimePart getEncryptedContent() {
        return this.message;
    }
}
