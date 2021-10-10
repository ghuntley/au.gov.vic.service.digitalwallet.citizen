package org.bouncycastle.mail.smime;

import java.io.IOException;
import java.io.OutputStream;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.cms.CMSCompressedDataStreamGenerator;

public class SMIMECompressedGenerator extends SMIMEGenerator {
    private static final String COMPRESSED_CONTENT_TYPE = "application/pkcs7-mime; name=\"smime.p7z\"; smime-type=compressed-data";
    public static final String ZLIB = "1.2.840.113549.1.9.16.3.8";

    /* access modifiers changed from: private */
    public class ContentCompressor implements SMIMEStreamingProcessor {
        private final String _compressionOid;
        private final MimeBodyPart _content;

        ContentCompressor(MimeBodyPart mimeBodyPart, String str) {
            this._content = mimeBodyPart;
            this._compressionOid = str;
        }

        @Override // org.bouncycastle.mail.smime.SMIMEStreamingProcessor
        public void write(OutputStream outputStream) throws IOException {
            OutputStream open = new CMSCompressedDataStreamGenerator().open(outputStream, this._compressionOid);
            try {
                this._content.writeTo(open);
                open.close();
            } catch (MessagingException e) {
                throw new IOException(e.toString());
            }
        }
    }

    static {
        MailcapCommandMap defaultCommandMap = CommandMap.getDefaultCommandMap();
        defaultCommandMap.addMailcap("application/pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_mime");
        defaultCommandMap.addMailcap("application/x-pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_mime");
        CommandMap.setDefaultCommandMap(defaultCommandMap);
    }

    private MimeBodyPart make(MimeBodyPart mimeBodyPart, String str) throws SMIMEException {
        try {
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setContent(new ContentCompressor(mimeBodyPart, str), COMPRESSED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Type", COMPRESSED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Disposition", "attachment; filename=\"smime.p7z\"");
            mimeBodyPart2.addHeader("Content-Description", "S/MIME Compressed Message");
            mimeBodyPart2.addHeader("Content-Transfer-Encoding", this.encoding);
            return mimeBodyPart2;
        } catch (MessagingException e) {
            throw new SMIMEException("exception putting multi-part together.", e);
        }
    }

    public MimeBodyPart generate(MimeBodyPart mimeBodyPart, String str) throws SMIMEException {
        return make(makeContentBodyPart(mimeBodyPart), str);
    }

    public MimeBodyPart generate(MimeMessage mimeMessage, String str) throws SMIMEException {
        try {
            mimeMessage.saveChanges();
            return make(makeContentBodyPart(mimeMessage), str);
        } catch (MessagingException e) {
            throw new SMIMEException("unable to save message", e);
        }
    }
}
