package org.bouncycastle.mail.smime.handlers;

import java.awt.datatransfer.DataFlavor;
import java.io.BufferedInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import org.bouncycastle.mail.smime.SMIMEStreamingProcessor;

public class multipart_signed implements DataContentHandler {
    private static final ActivationDataFlavor ADF;
    private static final DataFlavor[] DFS;

    /* access modifiers changed from: private */
    public static class LineOutputStream extends FilterOutputStream {
        private static byte[] newline;

        static {
            byte[] bArr = new byte[2];
            newline = bArr;
            bArr[0] = 13;
            bArr[1] = 10;
        }

        public LineOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        private static byte[] getBytes(String str) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            return bArr;
        }

        public void writeln() throws MessagingException {
            try {
                ((FilterOutputStream) this).out.write(newline);
            } catch (Exception e) {
                throw new MessagingException("IOException", e);
            }
        }

        public void writeln(String str) throws MessagingException {
            try {
                ((FilterOutputStream) this).out.write(getBytes(str));
                ((FilterOutputStream) this).out.write(newline);
            } catch (Exception e) {
                throw new MessagingException("IOException", e);
            }
        }
    }

    static {
        DataFlavor activationDataFlavor = new ActivationDataFlavor(MimeMultipart.class, "multipart/signed", "Multipart Signed");
        ADF = activationDataFlavor;
        DFS = new DataFlavor[]{activationDataFlavor};
    }

    private void outputBodyPart(OutputStream outputStream, Object obj) throws MessagingException, IOException {
        if (obj instanceof Multipart) {
            Multipart multipart = (Multipart) obj;
            ContentType contentType = new ContentType(multipart.getContentType());
            String str = "--" + contentType.getParameter("boundary");
            LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
            for (int i = 0; i < multipart.getCount(); i++) {
                lineOutputStream.writeln(str);
                outputBodyPart(outputStream, multipart.getBodyPart(i));
                lineOutputStream.writeln();
            }
            lineOutputStream.writeln(str + "--");
            return;
        }
        MimeBodyPart mimeBodyPart = (MimeBodyPart) obj;
        if (mimeBodyPart.getContent() instanceof Multipart) {
            Multipart multipart2 = (Multipart) mimeBodyPart.getContent();
            ContentType contentType2 = new ContentType(multipart2.getContentType());
            String str2 = "--" + contentType2.getParameter("boundary");
            LineOutputStream lineOutputStream2 = new LineOutputStream(outputStream);
            Enumeration allHeaderLines = mimeBodyPart.getAllHeaderLines();
            while (allHeaderLines.hasMoreElements()) {
                lineOutputStream2.writeln((String) allHeaderLines.nextElement());
            }
            lineOutputStream2.writeln();
            outputPreamble(lineOutputStream2, mimeBodyPart, str2);
            outputBodyPart(outputStream, multipart2);
            return;
        }
        mimeBodyPart.writeTo(outputStream);
    }

    static void outputPreamble(LineOutputStream lineOutputStream, MimeBodyPart mimeBodyPart, String str) throws MessagingException, IOException {
        String readLine;
        try {
            InputStream rawInputStream = mimeBodyPart.getRawInputStream();
            while (true) {
                readLine = readLine(rawInputStream);
                if (readLine == null || readLine.equals(str)) {
                    rawInputStream.close();
                } else {
                    lineOutputStream.writeln(readLine);
                }
            }
            rawInputStream.close();
            if (readLine == null) {
                throw new MessagingException("no boundary found");
            }
        } catch (MessagingException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A[RETURN] */
    private static String readLine(InputStream inputStream) throws IOException {
        int read;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            read = inputStream.read();
            if (read < 0 || read == 10) {
                if (read >= 0) {
                    return null;
                }
                return stringBuffer.toString();
            } else if (read != 13) {
                stringBuffer.append((char) read);
            }
        }
        if (read >= 0) {
        }
    }

    public Object getContent(DataSource dataSource) throws IOException {
        try {
            return new MimeMultipart(dataSource);
        } catch (MessagingException unused) {
            return null;
        }
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws IOException {
        if (ADF.equals(dataFlavor)) {
            return getContent(dataSource);
        }
        return null;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return DFS;
    }

    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (obj instanceof MimeMultipart) {
            try {
                outputBodyPart(outputStream, obj);
            } catch (MessagingException e) {
                throw new IOException(e.getMessage());
            }
        } else if (obj instanceof byte[]) {
            outputStream.write((byte[]) obj);
        } else if (obj instanceof InputStream) {
            InputStream inputStream = (InputStream) obj;
            if (!(inputStream instanceof BufferedInputStream)) {
                inputStream = new BufferedInputStream(inputStream);
            }
            while (true) {
                int read = inputStream.read();
                if (read >= 0) {
                    outputStream.write(read);
                } else {
                    return;
                }
            }
        } else if (obj instanceof SMIMEStreamingProcessor) {
            ((SMIMEStreamingProcessor) obj).write(outputStream);
        } else {
            throw new IOException("unknown object in writeTo " + obj);
        }
    }
}
