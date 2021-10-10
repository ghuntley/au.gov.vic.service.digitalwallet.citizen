package org.bouncycastle.openpgp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.util.encoders.Base64;

public class PGPUtil implements HashAlgorithmTags {
    private static final int READ_AHEAD = 60;
    private static String defProvider = "BC";

    static class BufferedInputStreamExt extends BufferedInputStream {
        BufferedInputStreamExt(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.InputStream
        public synchronized int available() throws IOException {
            int available;
            available = super.available();
            if (available < 0) {
                available = Integer.MAX_VALUE;
            }
            return available;
        }
    }

    static MPInteger[] dsaSigToMpi(byte[] bArr) throws PGPException {
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(bArr).readObject();
            return new MPInteger[]{new MPInteger(((DERInteger) aSN1Sequence.getObjectAt(0)).getValue()), new MPInteger(((DERInteger) aSN1Sequence.getObjectAt(1)).getValue())};
        } catch (IOException e) {
            throw new PGPException("exception encoding signature", e);
        }
    }

    public static InputStream getDecoderStream(InputStream inputStream) throws IOException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStreamExt(inputStream);
        }
        inputStream.mark(60);
        int read = inputStream.read();
        if ((read & 128) != 0) {
            inputStream.reset();
            return inputStream;
        } else if (!isPossiblyBase64(read)) {
            inputStream.reset();
            return new ArmoredInputStream(inputStream);
        } else {
            byte[] bArr = new byte[60];
            bArr[0] = (byte) read;
            int i = 1;
            int i2 = 1;
            while (i != 60) {
                int read2 = inputStream.read();
                if (read2 < 0) {
                    break;
                } else if (!isPossiblyBase64(read2)) {
                    inputStream.reset();
                    return new ArmoredInputStream(inputStream);
                } else {
                    if (!(read2 == 10 || read2 == 13)) {
                        bArr[i2] = (byte) read2;
                        i2++;
                    }
                    i++;
                }
            }
            inputStream.reset();
            if (i < 4) {
                return new ArmoredInputStream(inputStream);
            }
            byte[] bArr2 = new byte[8];
            System.arraycopy(bArr, 0, bArr2, 0, 8);
            return (Base64.decode(bArr2)[0] & 128) != 0 ? new ArmoredInputStream(inputStream, false) : new ArmoredInputStream(inputStream);
        }
    }

    public static String getDefaultProvider() {
        return defProvider;
    }

    static MessageDigest getDigestInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return MessageDigest.getInstance(str, provider);
        } catch (NoSuchAlgorithmException unused) {
            return MessageDigest.getInstance(str);
        }
    }

    static String getDigestName(int i) throws PGPException {
        if (i == 1) {
            return "MD5";
        }
        if (i == 2) {
            return "SHA1";
        }
        if (i == 3) {
            return "RIPEMD160";
        }
        if (i == 5) {
            return "MD2";
        }
        switch (i) {
            case 8:
                return "SHA256";
            case 9:
                return "SHA384";
            case 10:
                return "SHA512";
            case 11:
                return "SHA224";
            default:
                throw new PGPException("unknown hash algorithm tag in getDigestName: " + i);
        }
    }

    static Provider getProvider(String str) throws NoSuchProviderException {
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new NoSuchProviderException("provider " + str + " not found.");
    }

    static String getSignatureName(int i, int i2) throws PGPException {
        String str;
        if (i == 1 || i == 3) {
            str = "RSA";
        } else if (i == 20 || i == 16) {
            str = "ElGamal";
        } else if (i == 17) {
            str = "DSA";
        } else {
            throw new PGPException("unknown algorithm tag in signature:" + i);
        }
        return getDigestName(i2) + "with" + str;
    }

    static String getSymmetricCipherName(int i) throws PGPException {
        switch (i) {
            case 0:
                return null;
            case 1:
                return "IDEA";
            case 2:
                return "DESEDE";
            case 3:
                return "CAST5";
            case 4:
                return "Blowfish";
            case 5:
                return "SAFER";
            case 6:
                return "DES";
            case 7:
            case 8:
            case 9:
                return "AES";
            case 10:
                return "Twofish";
            default:
                throw new PGPException("unknown symmetric algorithm: " + i);
        }
    }

    private static boolean isPossiblyBase64(int i) {
        return (i >= 65 && i <= 90) || (i >= 97 && i <= 122) || ((i >= 48 && i <= 57) || i == 43 || i == 47 || i == 13 || i == 10);
    }

    public static SecretKey makeKeyFromPassPhrase(int i, S2K s2k, char[] cArr, String str) throws PGPException, NoSuchProviderException {
        return makeKeyFromPassPhrase(i, s2k, cArr, getProvider(str));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fe  */
    public static SecretKey makeKeyFromPassPhrase(int i, S2K s2k, char[] cArr, Provider provider) throws PGPException, NoSuchProviderException {
        MessageDigest messageDigest;
        byte[] digest;
        int i2;
        int i3 = 256;
        String str = "AES";
        switch (i) {
            case 1:
                str = "IDEA";
                i3 = 128;
                break;
            case 2:
                str = "DES_EDE";
                i3 = 192;
                break;
            case 3:
                str = "CAST5";
                i3 = 128;
                break;
            case 4:
                str = "Blowfish";
                i3 = 128;
                break;
            case 5:
                str = "SAFER";
                i3 = 128;
                break;
            case 6:
                i3 = 64;
                str = "DES";
                break;
            case 7:
                i3 = 128;
                break;
            case 8:
                i3 = 192;
                break;
            case 9:
                break;
            case 10:
                str = "Twofish";
                break;
            default:
                throw new PGPException("unknown symmetric algorithm: " + i);
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 != cArr.length; i4++) {
            bArr[i4] = (byte) cArr[i4];
        }
        int i5 = (i3 + 7) / 8;
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            if (s2k != null) {
                try {
                    messageDigest = getDigestInstance(getDigestName(s2k.getHashAlgorithm()), provider);
                    for (int i8 = 0; i8 != i7; i8++) {
                        messageDigest.update((byte) 0);
                    }
                    byte[] iv = s2k.getIV();
                    int type = s2k.getType();
                    if (type != 0) {
                        if (type == 1) {
                            messageDigest.update(iv);
                        } else if (type == 3) {
                            long iterationCount = s2k.getIterationCount();
                            messageDigest.update(iv);
                            messageDigest.update(bArr);
                            long length2 = (long) (iv.length + length);
                            while (true) {
                                long j = iterationCount - length2;
                                while (true) {
                                    if (j > 0) {
                                        if (j < ((long) iv.length)) {
                                            messageDigest.update(iv, 0, (int) j);
                                        } else {
                                            messageDigest.update(iv);
                                            iterationCount = j - ((long) iv.length);
                                            length2 = (long) length;
                                            if (iterationCount < length2) {
                                                messageDigest.update(bArr, 0, (int) iterationCount);
                                                j = 0;
                                            } else {
                                                messageDigest.update(bArr);
                                            }
                                        }
                                    }
                                }
                            }
                            digest = messageDigest.digest();
                            i2 = i5 - i6;
                            if (digest.length <= i2) {
                                System.arraycopy(digest, 0, bArr2, i6, i2);
                            } else {
                                System.arraycopy(digest, 0, bArr2, i6, digest.length);
                            }
                            i6 += digest.length;
                            i7++;
                        } else {
                            throw new PGPException("unknown S2K type: " + s2k.getType());
                        }
                    }
                } catch (NoSuchAlgorithmException e) {
                    throw new PGPException("can't find S2K digest", e);
                }
            } else {
                try {
                    messageDigest = getDigestInstance("MD5", provider);
                    for (int i9 = 0; i9 != i7; i9++) {
                        messageDigest.update((byte) 0);
                    }
                } catch (NoSuchAlgorithmException e2) {
                    throw new PGPException("can't find MD5 digest", e2);
                }
            }
            messageDigest.update(bArr);
            digest = messageDigest.digest();
            i2 = i5 - i6;
            if (digest.length <= i2) {
            }
            i6 += digest.length;
            i7++;
        }
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = 0;
        }
        return new SecretKeySpec(bArr2, str);
    }

    public static SecretKey makeKeyFromPassPhrase(int i, char[] cArr, String str) throws NoSuchProviderException, PGPException {
        return makeKeyFromPassPhrase(i, (S2K) null, cArr, str);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static SecretKey makeRandomKey(int i, SecureRandom secureRandom) throws PGPException {
        int i2 = 256;
        String str = "AES";
        switch (i) {
            case 1:
                str = "IDEA";
                i2 = 128;
                break;
            case 2:
                str = "DES_EDE";
                i2 = 192;
                break;
            case 3:
                str = "CAST5";
                i2 = 128;
                break;
            case 4:
                str = "Blowfish";
                i2 = 128;
                break;
            case 5:
                str = "SAFER";
                i2 = 128;
                break;
            case 6:
                i2 = 64;
                str = "DES";
                break;
            case 7:
                i2 = 128;
                break;
            case 8:
                i2 = 192;
                break;
            case 9:
                break;
            case 10:
                str = "Twofish";
                break;
            default:
                throw new PGPException("unknown symmetric algorithm: " + i);
        }
        byte[] bArr = new byte[((i2 + 7) / 8)];
        secureRandom.nextBytes(bArr);
        return new SecretKeySpec(bArr, str);
    }

    private static void pipeFileContents(File file, OutputStream outputStream, int i) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[i];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.close();
                fileInputStream.close();
                return;
            }
        }
    }

    public static void setDefaultProvider(String str) {
        defProvider = str;
    }

    public static void writeFileToLiteralData(OutputStream outputStream, char c, File file) throws IOException {
        pipeFileContents(file, new PGPLiteralDataGenerator().open(outputStream, c, file.getName(), file.length(), new Date(file.lastModified())), 4096);
    }

    public static void writeFileToLiteralData(OutputStream outputStream, char c, File file, byte[] bArr) throws IOException {
        pipeFileContents(file, new PGPLiteralDataGenerator().open(outputStream, c, file.getName(), new Date(file.lastModified()), bArr), bArr.length);
    }
}
