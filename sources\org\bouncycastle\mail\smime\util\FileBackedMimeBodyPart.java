package org.bouncycastle.mail.smime.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;

public class FileBackedMimeBodyPart extends MimeBodyPart {
    private static final int BUF_SIZE = 32760;
    private final File _file;

    public FileBackedMimeBodyPart(File file) throws MessagingException, IOException {
        super(new SharedFileInputStream(file));
        this._file = file;
    }

    public FileBackedMimeBodyPart(InputStream inputStream, File file) throws MessagingException, IOException {
        this(saveStreamToFile(inputStream, file));
    }

    public FileBackedMimeBodyPart(InternetHeaders internetHeaders, InputStream inputStream, File file) throws MessagingException, IOException {
        this(saveStreamToFile(internetHeaders, inputStream, file));
    }

    private static void saveContentToStream(OutputStream outputStream, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[BUF_SIZE];
        while (true) {
            int read = inputStream.read(bArr, 0, BUF_SIZE);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.close();
                inputStream.close();
                return;
            }
        }
    }

    private static File saveStreamToFile(InputStream inputStream, File file) throws IOException {
        saveContentToStream(new FileOutputStream(file), inputStream);
        return file;
    }

    private static File saveStreamToFile(InternetHeaders internetHeaders, InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Enumeration allHeaderLines = internetHeaders.getAllHeaderLines();
        while (allHeaderLines.hasMoreElements()) {
            writeHeader(fileOutputStream, (String) allHeaderLines.nextElement());
        }
        writeSeperator(fileOutputStream);
        saveContentToStream(fileOutputStream, inputStream);
        return file;
    }

    private static void writeHeader(OutputStream outputStream, String str) throws IOException {
        for (int i = 0; i != str.length(); i++) {
            outputStream.write(str.charAt(i));
        }
        writeSeperator(outputStream);
    }

    private static void writeSeperator(OutputStream outputStream) throws IOException {
        outputStream.write(13);
        outputStream.write(10);
    }

    public void dispose() throws IOException {
        ((SharedFileInputStream) this.contentStream).getRoot().dispose();
        if (this._file.exists() && !this._file.delete()) {
            throw new IOException("deletion of underlying file <" + this._file.getCanonicalPath() + "> failed.");
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        if (this._file.exists()) {
            FileBackedMimeBodyPart.super.writeTo(outputStream);
            return;
        }
        throw new IOException("file " + this._file.getCanonicalPath() + " no longer exists.");
    }
}
