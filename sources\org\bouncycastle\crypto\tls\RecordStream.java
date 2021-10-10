package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* access modifiers changed from: package-private */
public class RecordStream {
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private TlsProtocolHandler handler;
    private CombinedHash hash;
    private InputStream is;
    private OutputStream os;
    private TlsCipher readCipher = null;
    private TlsCompression readCompression = null;
    private TlsCipher writeCipher = null;
    private TlsCompression writeCompression = null;

    RecordStream(TlsProtocolHandler tlsProtocolHandler, InputStream inputStream, OutputStream outputStream) {
        this.handler = tlsProtocolHandler;
        this.is = inputStream;
        this.os = outputStream;
        this.hash = new CombinedHash();
        TlsNullCompression tlsNullCompression = new TlsNullCompression();
        this.readCompression = tlsNullCompression;
        this.writeCompression = tlsNullCompression;
        TlsNullCipher tlsNullCipher = new TlsNullCipher();
        this.readCipher = tlsNullCipher;
        this.writeCipher = tlsNullCipher;
    }

    private static byte[] doFinal(CombinedHash combinedHash) {
        byte[] bArr = new byte[combinedHash.getDigestSize()];
        combinedHash.doFinal(bArr, 0);
        return bArr;
    }

    private byte[] getBufferContents() {
        byte[] byteArray = this.buffer.toByteArray();
        this.buffer.reset();
        return byteArray;
    }

    /* access modifiers changed from: package-private */
    public void clientCipherSpecDecided(TlsCompression tlsCompression, TlsCipher tlsCipher) {
        this.writeCompression = tlsCompression;
        this.writeCipher = tlsCipher;
    }

    /* access modifiers changed from: protected */
    public void close() throws IOException {
        IOException e;
        try {
            this.is.close();
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            this.os.close();
        } catch (IOException e3) {
            e = e3;
        }
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] decodeAndVerify(short s, InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        TlsUtils.readFully(bArr, inputStream);
        byte[] decodeCiphertext = this.readCipher.decodeCiphertext(s, bArr, 0, i);
        OutputStream decompress = this.readCompression.decompress(this.buffer);
        if (decompress == this.buffer) {
            return decodeCiphertext;
        }
        decompress.write(decodeCiphertext, 0, decodeCiphertext.length);
        decompress.flush();
        return getBufferContents();
    }

    /* access modifiers changed from: protected */
    public void flush() throws IOException {
        this.os.flush();
    }

    /* access modifiers changed from: package-private */
    public byte[] getCurrentHash() {
        return doFinal(new CombinedHash(this.hash));
    }

    public void readData() throws IOException {
        short readUint8 = TlsUtils.readUint8(this.is);
        TlsUtils.checkVersion(this.is, this.handler);
        byte[] decodeAndVerify = decodeAndVerify(readUint8, this.is, TlsUtils.readUint16(this.is));
        this.handler.processData(readUint8, decodeAndVerify, 0, decodeAndVerify.length);
    }

    /* access modifiers changed from: package-private */
    public void serverClientSpecReceived() {
        this.readCompression = this.writeCompression;
        this.readCipher = this.writeCipher;
    }

    /* access modifiers changed from: package-private */
    public void updateHandshakeData(byte[] bArr, int i, int i2) {
        this.hash.update(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public void writeMessage(short s, byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        if (s == 22) {
            updateHandshakeData(bArr, i, i2);
        }
        OutputStream compress = this.writeCompression.compress(this.buffer);
        if (compress == this.buffer) {
            bArr2 = this.writeCipher.encodePlaintext(s, bArr, i, i2);
        } else {
            compress.write(bArr, i, i2);
            compress.flush();
            byte[] bufferContents = getBufferContents();
            bArr2 = this.writeCipher.encodePlaintext(s, bufferContents, 0, bufferContents.length);
        }
        byte[] bArr3 = new byte[(bArr2.length + 5)];
        TlsUtils.writeUint8(s, bArr3, 0);
        TlsUtils.writeVersion(bArr3, 1);
        TlsUtils.writeUint16(bArr2.length, bArr3, 3);
        System.arraycopy(bArr2, 0, bArr3, 5, bArr2.length);
        this.os.write(bArr3);
        this.os.flush();
    }
}
