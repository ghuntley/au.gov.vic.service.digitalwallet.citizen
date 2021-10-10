package org.bouncycastle.mail.smime;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimePart;
import org.bouncycastle.cms.CMSCompressedDataParser;
import org.bouncycastle.cms.CMSException;

public class SMIMECompressedParser extends CMSCompressedDataParser {
    private final MimePart message;

    public SMIMECompressedParser(MimeBodyPart mimeBodyPart) throws MessagingException, CMSException {
        this(mimeBodyPart, 0);
    }

    public SMIMECompressedParser(MimeBodyPart mimeBodyPart, int i) throws MessagingException, CMSException {
        super(getInputStream(mimeBodyPart, i));
        this.message = mimeBodyPart;
    }

    public SMIMECompressedParser(MimeMessage mimeMessage) throws MessagingException, CMSException {
        this(mimeMessage, 0);
    }

    public SMIMECompressedParser(MimeMessage mimeMessage, int i) throws MessagingException, CMSException {
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

    public MimePart getCompressedContent() {
        return this.message;
    }
}
