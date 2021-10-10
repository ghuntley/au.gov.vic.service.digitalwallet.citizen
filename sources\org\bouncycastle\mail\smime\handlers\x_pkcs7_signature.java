package org.bouncycastle.mail.smime.handlers;

import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

public class x_pkcs7_signature implements DataContentHandler {
    private static final ActivationDataFlavor ADF;
    private static final DataFlavor[] ADFs;

    static {
        DataFlavor activationDataFlavor = new ActivationDataFlavor(MimeBodyPart.class, "application/x-pkcs7-signature", "Signature");
        ADF = activationDataFlavor;
        ADFs = new DataFlavor[]{activationDataFlavor};
    }

    public Object getContent(DataSource dataSource) throws IOException {
        return dataSource.getInputStream();
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws IOException {
        if (ADF.equals(dataFlavor)) {
            return getContent(dataSource);
        }
        return null;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return ADFs;
    }

    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (obj instanceof MimeBodyPart) {
            try {
                ((MimeBodyPart) obj).writeTo(outputStream);
            } catch (MessagingException e) {
                throw new IOException(e.getMessage());
            }
        } else if (obj instanceof byte[]) {
            outputStream.write((byte[]) obj);
        } else if (obj instanceof InputStream) {
            InputStream inputStream = (InputStream) obj;
            while (true) {
                int read = inputStream.read();
                if (read >= 0) {
                    outputStream.write(read);
                } else {
                    return;
                }
            }
        } else {
            throw new IOException("unknown object in writeTo " + obj);
        }
    }
}
