package org.bouncycastle.crypto.tls;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.UByte;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.Streams;

public class TlsUtils {
    protected static byte[] PRF(byte[] bArr, String str, byte[] bArr2, int i) {
        byte[] byteArray = Strings.toByteArray(str);
        int length = (bArr.length + 1) / 2;
        byte[] bArr3 = new byte[length];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr, bArr.length - length, bArr4, 0, length);
        byte[] concat = concat(byteArray, bArr2);
        byte[] bArr5 = new byte[i];
        byte[] bArr6 = new byte[i];
        hmac_hash(new MD5Digest(), bArr3, concat, bArr6);
        hmac_hash(new SHA1Digest(), bArr4, concat, bArr5);
        for (int i2 = 0; i2 < i; i2++) {
            bArr5[i2] = (byte) (bArr5[i2] ^ bArr6[i2]);
        }
        return bArr5;
    }

    protected static void checkVersion(InputStream inputStream, TlsProtocolHandler tlsProtocolHandler) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if (read != 3 || read2 != 1) {
            throw new TlsFatalAlert(70);
        }
    }

    protected static void checkVersion(byte[] bArr, TlsProtocolHandler tlsProtocolHandler) throws IOException {
        if (bArr[0] != 3 || bArr[1] != 1) {
            throw new TlsFatalAlert(70);
        }
    }

    static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static void hmac_hash(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        HMac hMac = new HMac(digest);
        KeyParameter keyParameter = new KeyParameter(bArr);
        int digestSize = digest.getDigestSize();
        int length = ((bArr3.length + digestSize) - 1) / digestSize;
        int macSize = hMac.getMacSize();
        byte[] bArr4 = new byte[macSize];
        byte[] bArr5 = new byte[hMac.getMacSize()];
        byte[] bArr6 = bArr2;
        int i = 0;
        while (i < length) {
            hMac.init(keyParameter);
            hMac.update(bArr6, 0, bArr6.length);
            hMac.doFinal(bArr4, 0);
            hMac.init(keyParameter);
            hMac.update(bArr4, 0, macSize);
            hMac.update(bArr2, 0, bArr2.length);
            hMac.doFinal(bArr5, 0);
            int i2 = digestSize * i;
            System.arraycopy(bArr5, 0, bArr3, i2, Math.min(digestSize, bArr3.length - i2));
            i++;
            bArr6 = bArr4;
        }
    }

    protected static void readFully(byte[] bArr, InputStream inputStream) throws IOException {
        if (Streams.readFully(inputStream, bArr) != bArr.length) {
            throw new EOFException();
        }
    }

    protected static byte[] readOpaque16(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[readUint16(inputStream)];
        readFully(bArr, inputStream);
        return bArr;
    }

    protected static byte[] readOpaque8(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[readUint8(inputStream)];
        readFully(bArr, inputStream);
        return bArr;
    }

    protected static int readUint16(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if ((read | read2) >= 0) {
            return read2 | (read << 8);
        }
        throw new EOFException();
    }

    protected static int readUint24(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        if ((read | read2 | read3) >= 0) {
            return read3 | (read << 16) | (read2 << 8);
        }
        throw new EOFException();
    }

    protected static long readUint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (((long) read2) << 16) | (((long) read) << 24) | (((long) read3) << 8) | ((long) read4);
        }
        throw new EOFException();
    }

    protected static short readUint8(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return (short) read;
        }
        throw new EOFException();
    }

    static void validateKeyUsage(X509CertificateStructure x509CertificateStructure, int i) throws IOException {
        X509Extension extension;
        X509Extensions extensions = x509CertificateStructure.getTBSCertificate().getExtensions();
        if (extensions != null && (extension = extensions.getExtension(X509Extension.keyUsage)) != null && (KeyUsage.getInstance(extension).getBytes()[0] & UByte.MAX_VALUE & i) != i) {
            throw new TlsFatalAlert(46);
        }
    }

    protected static void writeGMTUnixTime(byte[] bArr, int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        bArr[i] = (byte) (currentTimeMillis >> 24);
        bArr[i + 1] = (byte) (currentTimeMillis >> 16);
        bArr[i + 2] = (byte) (currentTimeMillis >> 8);
        bArr[i + 3] = (byte) currentTimeMillis;
    }

    protected static void writeOpaque16(byte[] bArr, OutputStream outputStream) throws IOException {
        writeUint16(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    protected static void writeOpaque24(byte[] bArr, OutputStream outputStream) throws IOException {
        writeUint24(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    protected static void writeOpaque8(byte[] bArr, OutputStream outputStream) throws IOException {
        writeUint8((short) bArr.length, outputStream);
        outputStream.write(bArr);
    }

    protected static void writeUint16(int i, OutputStream outputStream) throws IOException {
        outputStream.write(i >> 8);
        outputStream.write(i);
    }

    protected static void writeUint16(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 8);
        bArr[i2 + 1] = (byte) i;
    }

    protected static void writeUint16Array(int[] iArr, OutputStream outputStream) throws IOException {
        for (int i : iArr) {
            writeUint16(i, outputStream);
        }
    }

    protected static void writeUint24(int i, OutputStream outputStream) throws IOException {
        outputStream.write(i >> 16);
        outputStream.write(i >> 8);
        outputStream.write(i);
    }

    protected static void writeUint24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) i;
    }

    protected static void writeUint32(long j, OutputStream outputStream) throws IOException {
        outputStream.write((int) (j >> 24));
        outputStream.write((int) (j >> 16));
        outputStream.write((int) (j >> 8));
        outputStream.write((int) j);
    }

    protected static void writeUint32(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((int) (j >> 24));
        bArr[i + 1] = (byte) ((int) (j >> 16));
        bArr[i + 2] = (byte) ((int) (j >> 8));
        bArr[i + 3] = (byte) ((int) j);
    }

    protected static void writeUint64(long j, OutputStream outputStream) throws IOException {
        outputStream.write((int) (j >> 56));
        outputStream.write((int) (j >> 48));
        outputStream.write((int) (j >> 40));
        outputStream.write((int) (j >> 32));
        outputStream.write((int) (j >> 24));
        outputStream.write((int) (j >> 16));
        outputStream.write((int) (j >> 8));
        outputStream.write((int) j);
    }

    protected static void writeUint64(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((int) (j >> 56));
        bArr[i + 1] = (byte) ((int) (j >> 48));
        bArr[i + 2] = (byte) ((int) (j >> 40));
        bArr[i + 3] = (byte) ((int) (j >> 32));
        bArr[i + 4] = (byte) ((int) (j >> 24));
        bArr[i + 5] = (byte) ((int) (j >> 16));
        bArr[i + 6] = (byte) ((int) (j >> 8));
        bArr[i + 7] = (byte) ((int) j);
    }

    protected static void writeUint8(short s, OutputStream outputStream) throws IOException {
        outputStream.write(s);
    }

    protected static void writeUint8(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
    }

    protected static void writeUint8Array(short[] sArr, OutputStream outputStream) throws IOException {
        for (short s : sArr) {
            writeUint8(s, outputStream);
        }
    }

    protected static void writeVersion(OutputStream outputStream) throws IOException {
        outputStream.write(3);
        outputStream.write(1);
    }

    protected static void writeVersion(byte[] bArr, int i) throws IOException {
        bArr[i] = 3;
        bArr[i + 1] = 1;
    }
}
