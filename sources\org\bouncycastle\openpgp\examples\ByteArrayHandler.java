package org.bouncycastle.openpgp.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPBEEncryptedData;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.io.Streams;

public class ByteArrayHandler {
    private static byte[] compress(byte[] bArr, String str, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(i);
        OutputStream open = new PGPLiteralDataGenerator().open(pGPCompressedDataGenerator.open(byteArrayOutputStream), 'b', str, (long) bArr.length, new Date());
        open.write(bArr);
        open.close();
        pGPCompressedDataGenerator.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decrypt(byte[] bArr, char[] cArr) throws IOException, PGPException, NoSuchProviderException {
        PGPObjectFactory pGPObjectFactory = new PGPObjectFactory(PGPUtil.getDecoderStream(new ByteArrayInputStream(bArr)));
        Object nextObject = pGPObjectFactory.nextObject();
        if (!(nextObject instanceof PGPEncryptedDataList)) {
            nextObject = pGPObjectFactory.nextObject();
        }
        return Streams.readAll(((PGPLiteralData) new PGPObjectFactory(((PGPCompressedData) new PGPObjectFactory(((PGPPBEEncryptedData) ((PGPEncryptedDataList) nextObject).get(0)).getDataStream(cArr, "BC")).nextObject()).getDataStream()).nextObject()).getInputStream());
    }

    public static byte[] encrypt(byte[] bArr, char[] cArr, String str, int i, boolean z) throws IOException, PGPException, NoSuchProviderException {
        if (str == null) {
            str = "_CONSOLE";
        }
        byte[] compress = compress(bArr, str, 1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream armoredOutputStream = z ? new ArmoredOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
        PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(i, new SecureRandom(), "BC");
        pGPEncryptedDataGenerator.addMethod(cArr);
        OutputStream open = pGPEncryptedDataGenerator.open(armoredOutputStream, (long) compress.length);
        open.write(compress);
        open.close();
        if (z) {
            armoredOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        char[] charArray = "Dick Beck".toCharArray();
        byte[] bytes = "Hello world".getBytes();
        System.out.println("Starting PGP test");
        byte[] encrypt = encrypt(bytes, charArray, "iway", 3, true);
        PrintStream printStream = System.out;
        printStream.println("\nencrypted data = '" + new String(encrypt) + "'");
        byte[] decrypt = decrypt(encrypt, charArray);
        PrintStream printStream2 = System.out;
        printStream2.println("\ndecrypted data = '" + new String(decrypt) + "'");
        byte[] encrypt2 = encrypt(bytes, charArray, "iway", 9, false);
        PrintStream printStream3 = System.out;
        printStream3.println("\nencrypted data = '" + new String(Hex.encode(encrypt2)) + "'");
        byte[] decrypt2 = decrypt(encrypt2, charArray);
        PrintStream printStream4 = System.out;
        printStream4.println("\ndecrypted data = '" + new String(decrypt2) + "'");
    }
}
