package org.bouncycastle.mail.smime;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimePart;
import org.bouncycastle.cms.CMSEnvelopedDataParser;
import org.bouncycastle.cms.CMSException;

public class SMIMEEnvelopedParser extends CMSEnvelopedDataParser {
    private final MimePart message;

    public SMIMEEnvelopedParser(MimeBodyPart mimeBodyPart) throws IOException, MessagingException, CMSException {
        this(mimeBodyPart, 0);
    }

    public SMIMEEnvelopedParser(MimeBodyPart mimeBodyPart, int i) throws IOException, MessagingException, CMSException {
        super(getInputStream(mimeBodyPart, i));
        this.message = mimeBodyPart;
    }

    public SMIMEEnvelopedParser(MimeMessage mimeMessage) throws IOException, MessagingException, CMSException {
        this(mimeMessage, 0);
    }

    public SMIMEEnvelopedParser(MimeMessage mimeMessage, int i) throws IOException, MessagingException, CMSException {
        super(getInputStream(mimeMessage, i));
        this.message = mimeMessage;
    }

    private static InputStream getInputStream(Part part, int i) throws MessagingException {
        try {
            InputStream inputStream = part.getInputStream();
            return i == 0 ? new BufferedInputStream(inputStream) : new BufferedInputStream(inputStream, i);
        } catch (IOException e) {
            throw new MessagingException("can't extract input stream: " + e);
        }
    }

    public MimePart getEncryptedContent() {
        return this.message;
    }
}
