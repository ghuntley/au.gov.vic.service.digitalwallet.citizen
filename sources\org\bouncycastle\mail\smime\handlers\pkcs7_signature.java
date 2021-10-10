package org.bouncycastle.mail.smime.handlers;

import java.awt.datatransfer.DataFlavor;
import javax.activation.ActivationDataFlavor;
import javax.mail.internet.MimeBodyPart;

public class pkcs7_signature extends PKCS7ContentHandler {
    private static final ActivationDataFlavor ADF;
    private static final DataFlavor[] DFS;

    static {
        DataFlavor activationDataFlavor = new ActivationDataFlavor(MimeBodyPart.class, "application/pkcs7-signature", "Signature");
        ADF = activationDataFlavor;
        DFS = new DataFlavor[]{activationDataFlavor};
    }

    public pkcs7_signature() {
        super(ADF, DFS);
    }
}
