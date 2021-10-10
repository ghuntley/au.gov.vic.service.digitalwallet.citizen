package org.bouncycastle.mail.smime.examples;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.mail.smime.validator.SignedMailValidator;
import org.bouncycastle.x509.PKIXCertPathReviewer;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

public class ValidateSignedMail {
    public static final int DETAIL = 3;
    private static final String RESOURCE_NAME = "org.bouncycastle.mail.smime.validator.SignedMailValidatorMessages";
    public static final int SUMMARY = 2;
    public static final int TEXT = 1;
    public static final int TITLE = 0;
    static int dbgLvl = 3;
    public static final boolean useCaCerts = false;

    private static TrustAnchor getDummyTrustAnchor() throws Exception {
        X500Principal x500Principal = new X500Principal("CN=Dummy Trust Anchor");
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "BC");
        instance.initialize(1024, new SecureRandom());
        return new TrustAnchor(x500Principal, instance.generateKeyPair().getPublic(), (byte[]) null);
    }

    protected static TrustAnchor getTrustAnchor(String str) throws Exception {
        X509Certificate loadCert = loadCert(str);
        if (loadCert == null) {
            return null;
        }
        byte[] extensionValue = loadCert.getExtensionValue(X509Extensions.NameConstraints.getId());
        return extensionValue != null ? new TrustAnchor(loadCert, X509ExtensionUtil.fromExtensionValue(extensionValue).getDEREncoded()) : new TrustAnchor(loadCert, null);
    }

    protected static X509CRL loadCRL(String str) {
        try {
            return (X509CRL) CertificateFactory.getInstance("X.509", "BC").generateCRL(new FileInputStream(str));
        } catch (Exception unused) {
            PrintStream printStream = System.out;
            printStream.println("crlfile \"" + str + "\" not found - classpath is " + System.getProperty("java.class.path"));
            return null;
        }
    }

    protected static X509Certificate loadCert(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509", "BC").generateCertificate(new FileInputStream(str));
        } catch (Exception unused) {
            PrintStream printStream = System.out;
            printStream.println("certfile \"" + str + "\" not found - classpath is " + System.getProperty("java.class.path"));
            return null;
        }
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        MimeMessage mimeMessage = new MimeMessage(Session.getDefaultInstance(System.getProperties(), (Authenticator) null), new FileInputStream("signed.message"));
        HashSet hashSet = new HashSet();
        TrustAnchor trustAnchor = getTrustAnchor("trustanchor");
        if (trustAnchor == null) {
            System.out.println("no trustanchor file found, using a dummy trustanchor");
            trustAnchor = getDummyTrustAnchor();
        }
        hashSet.add(trustAnchor);
        PKIXParameters pKIXParameters = new PKIXParameters(hashSet);
        ArrayList arrayList = new ArrayList();
        X509CRL loadCRL = loadCRL("crl.file");
        if (loadCRL != null) {
            arrayList.add(loadCRL);
        }
        pKIXParameters.addCertStore(CertStore.getInstance("Collection", new CollectionCertStoreParameters(arrayList), "BC"));
        pKIXParameters.setRevocationEnabled(true);
        verifySignedMail(mimeMessage, pKIXParameters);
    }

    public static void verifySignedMail(MimeMessage mimeMessage, PKIXParameters pKIXParameters) throws Exception {
        String str;
        PrintStream printStream;
        StringBuilder sb;
        PrintStream printStream2;
        String str2;
        StringBuilder sb2;
        PrintStream printStream3;
        String str3;
        StringBuilder sb3;
        PrintStream printStream4;
        String str4;
        StringBuilder sb4;
        PrintStream printStream5;
        String str5;
        StringBuilder sb5;
        PrintStream printStream6;
        String str6;
        Locale locale = Locale.ENGLISH;
        SignedMailValidator signedMailValidator = new SignedMailValidator(mimeMessage, pKIXParameters);
        for (SignerInformation signerInformation : signedMailValidator.getSignerInformationStore().getSigners()) {
            SignedMailValidator.ValidationResult validationResult = signedMailValidator.getValidationResult(signerInformation);
            if (validationResult.isValidSignature()) {
                System.out.println(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.sigValid").getText(locale));
            } else {
                System.out.println(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.sigInvalid").getText(locale));
                System.out.println("Errors:");
                for (ErrorBundle errorBundle : validationResult.getErrors()) {
                    if (dbgLvl == 3) {
                        printStream6 = System.out;
                        sb5 = new StringBuilder();
                        sb5.append("\t\t");
                        str6 = errorBundle.getDetail(locale);
                    } else {
                        printStream6 = System.out;
                        sb5 = new StringBuilder();
                        sb5.append("\t\t");
                        str6 = errorBundle.getText(locale);
                    }
                    sb5.append(str6);
                    printStream6.println(sb5.toString());
                }
            }
            if (!validationResult.getNotifications().isEmpty()) {
                System.out.println("Notifications:");
                for (ErrorBundle errorBundle2 : validationResult.getNotifications()) {
                    if (dbgLvl == 3) {
                        printStream5 = System.out;
                        sb4 = new StringBuilder();
                        sb4.append("\t\t");
                        str5 = errorBundle2.getDetail(locale);
                    } else {
                        printStream5 = System.out;
                        sb4 = new StringBuilder();
                        sb4.append("\t\t");
                        str5 = errorBundle2.getText(locale);
                    }
                    sb4.append(str5);
                    printStream5.println(sb4.toString());
                }
            }
            PKIXCertPathReviewer certPathReview = validationResult.getCertPathReview();
            if (certPathReview != null) {
                if (certPathReview.isValidCertPath()) {
                    printStream = System.out;
                    str = "Certificate path valid";
                } else {
                    printStream = System.out;
                    str = "Certificate path invalid";
                }
                printStream.println(str);
                System.out.println("\nCertificate path validation results:");
                System.out.println("Errors:");
                for (ErrorBundle errorBundle3 : certPathReview.getErrors(-1)) {
                    if (dbgLvl == 3) {
                        printStream4 = System.out;
                        sb3 = new StringBuilder();
                        sb3.append("\t\t");
                        str4 = errorBundle3.getDetail(locale);
                    } else {
                        printStream4 = System.out;
                        sb3 = new StringBuilder();
                        sb3.append("\t\t");
                        str4 = errorBundle3.getText(locale);
                    }
                    sb3.append(str4);
                    printStream4.println(sb3.toString());
                }
                System.out.println("Notifications:");
                Iterator it = certPathReview.getNotifications(-1).iterator();
                while (it.hasNext()) {
                    PrintStream printStream7 = System.out;
                    printStream7.println("\t" + ((ErrorBundle) it.next()).getText(locale));
                }
                Iterator<? extends Certificate> it2 = certPathReview.getCertPath().getCertificates().iterator();
                int i = 0;
                while (it2.hasNext()) {
                    X509Certificate x509Certificate = (X509Certificate) it2.next();
                    PrintStream printStream8 = System.out;
                    printStream8.println("\nCertificate " + i + "\n========");
                    PrintStream printStream9 = System.out;
                    printStream9.println("Issuer: " + x509Certificate.getIssuerDN().getName());
                    PrintStream printStream10 = System.out;
                    printStream10.println("Subject: " + x509Certificate.getSubjectDN().getName());
                    System.out.println("\tErrors:");
                    for (ErrorBundle errorBundle4 : certPathReview.getErrors(i)) {
                        if (dbgLvl == 3) {
                            printStream3 = System.out;
                            sb2 = new StringBuilder();
                            sb2.append("\t\t");
                            str3 = errorBundle4.getDetail(locale);
                        } else {
                            printStream3 = System.out;
                            sb2 = new StringBuilder();
                            sb2.append("\t\t");
                            str3 = errorBundle4.getText(locale);
                        }
                        sb2.append(str3);
                        printStream3.println(sb2.toString());
                    }
                    System.out.println("\tNotifications:");
                    for (ErrorBundle errorBundle5 : certPathReview.getNotifications(i)) {
                        if (dbgLvl == 3) {
                            printStream2 = System.out;
                            sb = new StringBuilder();
                            sb.append("\t\t");
                            str2 = errorBundle5.getDetail(locale);
                        } else {
                            printStream2 = System.out;
                            sb = new StringBuilder();
                            sb.append("\t\t");
                            str2 = errorBundle5.getText(locale);
                        }
                        sb.append(str2);
                        printStream2.println(sb.toString());
                    }
                    i++;
                }
            }
        }
    }
}
