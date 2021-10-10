package org.bouncycastle.mail.smime;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedDataParser;
import org.bouncycastle.cms.CMSTypedStream;

public class SMIMESignedParser extends CMSSignedDataParser {
    MimeBodyPart content;
    Object message;

    /* access modifiers changed from: private */
    public static class TemporaryFileInputStream extends BufferedInputStream {
        private final File _file;

        TemporaryFileInputStream(File file) throws FileNotFoundException {
            super(new FileInputStream(file));
            this._file = file;
        }

        @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() throws IOException {
            super.close();
            this._file.delete();
        }
    }

    static {
        MailcapCommandMap defaultCommandMap = CommandMap.getDefaultCommandMap();
        defaultCommandMap.addMailcap("application/pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_signature");
        defaultCommandMap.addMailcap("application/pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_mime");
        defaultCommandMap.addMailcap("application/x-pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_signature");
        defaultCommandMap.addMailcap("application/x-pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_mime");
        defaultCommandMap.addMailcap("multipart/signed;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.multipart_signed");
        CommandMap.setDefaultCommandMap(defaultCommandMap);
    }

    public SMIMESignedParser(Part part) throws MessagingException, CMSException, SMIMEException {
        super(getInputStream(part));
        this.message = part;
        CMSTypedStream signedContent = getSignedContent();
        if (signedContent != null) {
            this.content = SMIMEUtil.toWriteOnceBodyPart(signedContent);
        }
    }

    public SMIMESignedParser(Part part, File file) throws MessagingException, CMSException, SMIMEException {
        super(getInputStream(part));
        this.message = part;
        CMSTypedStream signedContent = getSignedContent();
        if (signedContent != null) {
            this.content = SMIMEUtil.toMimeBodyPart(signedContent, file);
        }
    }

    public SMIMESignedParser(MimeMultipart mimeMultipart) throws MessagingException, CMSException {
        this(mimeMultipart, getTmpFile());
    }

    public SMIMESignedParser(MimeMultipart mimeMultipart, File file) throws MessagingException, CMSException {
        this(mimeMultipart, "7bit", file);
    }

    public SMIMESignedParser(MimeMultipart mimeMultipart, String str) throws MessagingException, CMSException {
        this(mimeMultipart, str, getTmpFile());
    }

    public SMIMESignedParser(MimeMultipart mimeMultipart, String str, File file) throws MessagingException, CMSException {
        super(getSignedInputStream(mimeMultipart.getBodyPart(0), str, file), getInputStream(mimeMultipart.getBodyPart(1)));
        this.message = mimeMultipart;
        this.content = mimeMultipart.getBodyPart(0);
        drainContent();
    }

    private void drainContent() throws CMSException {
        try {
            getSignedContent().drain();
        } catch (IOException e) {
            throw new CMSException("unable to read content for verification: " + e, e);
        }
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

    private static CMSTypedStream getSignedInputStream(BodyPart bodyPart, String str, File file) throws MessagingException {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            SMIMEUtil.outputBodyPart(bufferedOutputStream, bodyPart, str);
            bufferedOutputStream.close();
            return new CMSTypedStream(new TemporaryFileInputStream(file));
        } catch (IOException e) {
            throw new MessagingException("can't extract input stream: " + e);
        }
    }

    private static File getTmpFile() throws MessagingException {
        try {
            return File.createTempFile("bcMail", ".mime");
        } catch (IOException e) {
            throw new MessagingException("can't extract input stream: " + e);
        }
    }

    public MimeBodyPart getContent() {
        return this.content;
    }

    public MimeMessage getContentAsMimeMessage(Session session) throws MessagingException, IOException {
        Object obj = this.message;
        return obj instanceof MimeMultipart ? new MimeMessage(session, ((MimeMultipart) obj).getBodyPart(0).getInputStream()) : new MimeMessage(session, getSignedContent().getContentStream());
    }

    public Object getContentWithSignature() {
        return this.message;
    }
}
