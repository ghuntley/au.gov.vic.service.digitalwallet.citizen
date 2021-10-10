package org.bouncycastle.mail.smime.examples;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Iterator;
import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.mail.smime.SMIMESigned;
import org.bouncycastle.util.Store;

public class ReadSignedMail {
    private static final String BC = BouncyCastleProvider.PROVIDER_NAME;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b4, code lost:
        if ((r0 instanceof java.lang.String) != false) goto L_0x00b6;
     */
    public static void main(String[] strArr) throws Exception {
        SMIMESigned sMIMESigned;
        Object obj;
        MimeMessage mimeMessage = new MimeMessage(Session.getDefaultInstance(System.getProperties(), (Authenticator) null), new FileInputStream("signed.message"));
        if (mimeMessage.isMimeType("multipart/signed")) {
            sMIMESigned = new SMIMESigned((MimeMultipart) mimeMessage.getContent());
            MimeBodyPart content = sMIMESigned.getContent();
            System.out.println("Content:");
            obj = content.getContent();
            if (!(obj instanceof String)) {
                if (obj instanceof Multipart) {
                    Multipart multipart = (Multipart) obj;
                    int count = multipart.getCount();
                    for (int i = 0; i < count; i++) {
                        Object content2 = multipart.getBodyPart(i).getContent();
                        PrintStream printStream = System.out;
                        printStream.println("Part " + i);
                        System.out.println("---------------------------");
                        if (content2 instanceof String) {
                            System.out.println((String) content2);
                        } else {
                            System.out.println("can't print...");
                        }
                    }
                }
                System.out.println("Status:");
                verify(sMIMESigned);
            }
        } else if (mimeMessage.isMimeType("application/pkcs7-mime") || mimeMessage.isMimeType("application/x-pkcs7-mime")) {
            sMIMESigned = new SMIMESigned((Part) mimeMessage);
            MimeBodyPart content3 = sMIMESigned.getContent();
            System.out.println("Content:");
            obj = content3.getContent();
        } else {
            System.err.println("Not a signed message!");
            return;
        }
        System.out.println((String) obj);
        System.out.println("Status:");
        verify(sMIMESigned);
    }

    private static void verify(SMIMESigned sMIMESigned) throws Exception {
        String str;
        PrintStream printStream;
        Store certificates = sMIMESigned.getCertificates();
        for (SignerInformation signerInformation : sMIMESigned.getSignerInfos().getSigners()) {
            Iterator it = certificates.getMatches(signerInformation.getSID()).iterator();
            JcaX509CertificateConverter jcaX509CertificateConverter = new JcaX509CertificateConverter();
            String str2 = BC;
            if (signerInformation.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider(str2).build(jcaX509CertificateConverter.setProvider(str2).getCertificate((X509CertificateHolder) it.next())))) {
                printStream = System.out;
                str = "signature verified";
            } else {
                printStream = System.out;
                str = "signature failed!";
            }
            printStream.println(str);
        }
    }
}
