package org.bouncycastle.mail.smime.handlers;

import java.awt.datatransfer.DataFlavor;
import javax.activation.ActivationDataFlavor;
import javax.mail.internet.MimeBodyPart;

public class x_pkcs7_mime extends PKCS7ContentHandler {
    private static final ActivationDataFlavor ADF;
    private static final DataFlavor[] DFS;

    static {
        DataFlavor activationDataFlavor = new ActivationDataFlavor(MimeBodyPart.class, "application/x-pkcs7-mime", "Encrypted Data");
        ADF = activationDataFlavor;
        DFS = new DataFlavor[]{activationDataFlavor};
    }

    public x_pkcs7_mime() {
        super(ADF, DFS);
    }
}
