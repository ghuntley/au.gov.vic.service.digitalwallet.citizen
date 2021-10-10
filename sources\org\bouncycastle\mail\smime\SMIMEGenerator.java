package org.bouncycastle.mail.smime;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.mail.Header;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.cms.CMSEnvelopedGenerator;
import org.bouncycastle.util.Strings;

public class SMIMEGenerator {
    private static Map BASE_CIPHER_NAMES;
    protected String encoding = "base64";
    protected boolean useBase64 = true;

    static {
        HashMap hashMap = new HashMap();
        BASE_CIPHER_NAMES = hashMap;
        hashMap.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDE");
        BASE_CIPHER_NAMES.put(CMSEnvelopedGenerator.AES128_CBC, "AES");
        BASE_CIPHER_NAMES.put(CMSEnvelopedGenerator.AES192_CBC, "AES");
        BASE_CIPHER_NAMES.put(CMSEnvelopedGenerator.AES256_CBC, "AES");
    }

    protected SMIMEGenerator() {
    }

    private KeyGenerator createKeyGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        return provider != null ? KeyGenerator.getInstance(str, provider) : KeyGenerator.getInstance(str);
    }

    private void extractHeaders(MimeBodyPart mimeBodyPart, MimeMessage mimeMessage) throws MessagingException {
        Enumeration allHeaders = mimeMessage.getAllHeaders();
        while (allHeaders.hasMoreElements()) {
            Header header = (Header) allHeaders.nextElement();
            mimeBodyPart.addHeader(header.getName(), header.getValue());
        }
    }

    /* access modifiers changed from: protected */
    public KeyGenerator createSymmetricKeyGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return createKeyGenerator(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                String str2 = (String) BASE_CIPHER_NAMES.get(str);
                if (str2 != null) {
                    return createKeyGenerator(str2, provider);
                }
            } catch (NoSuchAlgorithmException unused) {
            }
            if (provider != null) {
                return createSymmetricKeyGenerator(str, null);
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public MimeBodyPart makeContentBodyPart(MimeBodyPart mimeBodyPart) throws SMIMEException {
        try {
            MimeMessage mimeMessage = new MimeMessage((Session) null);
            Enumeration allHeaders = mimeBodyPart.getAllHeaders();
            mimeMessage.setDataHandler(mimeBodyPart.getDataHandler());
            while (allHeaders.hasMoreElements()) {
                Header header = (Header) allHeaders.nextElement();
                mimeMessage.setHeader(header.getName(), header.getValue());
            }
            mimeMessage.saveChanges();
            Enumeration allHeaders2 = mimeMessage.getAllHeaders();
            while (allHeaders2.hasMoreElements()) {
                Header header2 = (Header) allHeaders2.nextElement();
                if (Strings.toLowerCase(header2.getName()).startsWith("content-")) {
                    mimeBodyPart.setHeader(header2.getName(), header2.getValue());
                }
            }
            return mimeBodyPart;
        } catch (MessagingException e) {
            throw new SMIMEException("exception saving message state.", e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        throw new org.bouncycastle.mail.smime.SMIMEException("exception getting message content.", r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c A[ExcHandler: IOException (r4v2 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:1:0x0007] */
    public MimeBodyPart makeContentBodyPart(MimeMessage mimeMessage) throws SMIMEException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        try {
            mimeMessage.removeHeader("Message-Id");
            mimeMessage.removeHeader("Mime-Version");
            if (mimeMessage.getContent() instanceof Multipart) {
                mimeBodyPart.setContent(mimeMessage.getRawInputStream(), mimeMessage.getContentType());
                extractHeaders(mimeBodyPart, mimeMessage);
                return mimeBodyPart;
            }
            mimeBodyPart.setContent(mimeMessage.getContent(), mimeMessage.getContentType());
            mimeBodyPart.setDataHandler(mimeMessage.getDataHandler());
            extractHeaders(mimeBodyPart, mimeMessage);
            return mimeBodyPart;
        } catch (MessagingException e) {
            throw new SMIMEException("exception saving message state.", e);
        } catch (IOException e2) {
        }
    }

    public void setContentTransferEncoding(String str) {
        this.encoding = str;
        this.useBase64 = Strings.toLowerCase(str).equals("base64");
    }
}
