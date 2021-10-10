package org.bouncycastle.mail.smime.examples;

import java.io.PrintStream;
import java.util.Iterator;
import javax.mail.Authenticator;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.mail.smime.SMIMESignedParser;
import org.bouncycastle.mail.smime.util.SharedFileInputStream;
import org.bouncycastle.util.Store;

public class ReadLargeSignedMail {
    private static final String BC = BouncyCastleProvider.PROVIDER_NAME;

    public static void main(String[] strArr) throws Exception {
        SMIMESignedParser sMIMESignedParser;
        MimeMessage mimeMessage = new MimeMessage(Session.getDefaultInstance(System.getProperties(), (Authenticator) null), new SharedFileInputStream("signed.message"));
        if (mimeMessage.isMimeType("multipart/signed")) {
            sMIMESignedParser = new SMIMESignedParser((MimeMultipart) mimeMessage.getContent());
        } else if (mimeMessage.isMimeType("application/pkcs7-mime")) {
            sMIMESignedParser = new SMIMESignedParser((Part) mimeMessage);
        } else {
            System.err.println("Not a signed message!");
            return;
        }
        System.out.println("Status:");
        verify(sMIMESignedParser);
    }

    private static void verify(SMIMESignedParser sMIMESignedParser) throws Exception {
        String str;
        PrintStream printStream;
        Store certificates = sMIMESignedParser.getCertificates();
        for (SignerInformation signerInformation : sMIMESignedParser.getSignerInfos().getSigners()) {
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
