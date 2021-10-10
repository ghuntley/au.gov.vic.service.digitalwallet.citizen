package org.bouncycastle.openpgp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.bouncycastle.apache.bzip2.CBZip2OutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.CompressionAlgorithmTags;

public class PGPCompressedDataGenerator implements CompressionAlgorithmTags, StreamGenerator {
    private int algorithm;
    private int compression;
    private OutputStream dOut;
    private OutputStream out;
    private BCPGOutputStream pkOut;

    public PGPCompressedDataGenerator(int i) {
        this(i, -1);
    }

    public PGPCompressedDataGenerator(int i, int i2) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            throw new IllegalArgumentException("unknown compression algorithm");
        } else if (i2 == -1 || (i2 >= 0 && i2 <= 9)) {
            this.algorithm = i;
            this.compression = i2;
        } else {
            throw new IllegalArgumentException("unknown compression level: " + i2);
        }
    }

    @Override // org.bouncycastle.openpgp.StreamGenerator
    public void close() throws IOException {
        OutputStream outputStream = this.dOut;
        if (outputStream != null) {
            if (outputStream instanceof DeflaterOutputStream) {
                ((DeflaterOutputStream) outputStream).finish();
            } else if (outputStream instanceof CBZip2OutputStream) {
                ((CBZip2OutputStream) outputStream).finish();
            }
            this.dOut.flush();
            this.pkOut.finish();
            this.pkOut.flush();
            this.out.flush();
            this.dOut = null;
            this.pkOut = null;
            this.out = null;
        }
    }

    public OutputStream open(OutputStream outputStream) throws IOException {
        OutputStream outputStream2;
        if (this.dOut == null) {
            this.out = outputStream;
            int i = this.algorithm;
            if (i == 0) {
                BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream, 8);
                this.pkOut = bCPGOutputStream;
                bCPGOutputStream.write(0);
                outputStream2 = this.pkOut;
            } else if (i == 1) {
                BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(outputStream, 8);
                this.pkOut = bCPGOutputStream2;
                bCPGOutputStream2.write(1);
                outputStream2 = new DeflaterOutputStream(this.pkOut, new Deflater(this.compression, true));
            } else if (i == 2) {
                BCPGOutputStream bCPGOutputStream3 = new BCPGOutputStream(outputStream, 8);
                this.pkOut = bCPGOutputStream3;
                bCPGOutputStream3.write(2);
                outputStream2 = new DeflaterOutputStream(this.pkOut, new Deflater(this.compression));
            } else if (i == 3) {
                BCPGOutputStream bCPGOutputStream4 = new BCPGOutputStream(outputStream, 8);
                this.pkOut = bCPGOutputStream4;
                bCPGOutputStream4.write(3);
                outputStream2 = new CBZip2OutputStream(this.pkOut);
            } else {
                throw new IllegalStateException("generator not initialised");
            }
            this.dOut = outputStream2;
            return new WrappedGeneratorStream(this.dOut, this);
        }
        throw new IllegalStateException("generator already in open state");
    }

    public OutputStream open(OutputStream outputStream, byte[] bArr) throws IOException, PGPException {
        OutputStream outputStream2;
        if (this.dOut == null) {
            this.out = outputStream;
            int i = this.algorithm;
            if (i == 0) {
                BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream, 8, bArr);
                this.pkOut = bCPGOutputStream;
                bCPGOutputStream.write(0);
                outputStream2 = this.pkOut;
            } else if (i == 1) {
                BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(outputStream, 8, bArr);
                this.pkOut = bCPGOutputStream2;
                bCPGOutputStream2.write(1);
                outputStream2 = new DeflaterOutputStream(this.pkOut, new Deflater(this.compression, true));
            } else if (i == 2) {
                BCPGOutputStream bCPGOutputStream3 = new BCPGOutputStream(outputStream, 8, bArr);
                this.pkOut = bCPGOutputStream3;
                bCPGOutputStream3.write(2);
                outputStream2 = new DeflaterOutputStream(this.pkOut, new Deflater(this.compression));
            } else if (i == 3) {
                BCPGOutputStream bCPGOutputStream4 = new BCPGOutputStream(outputStream, 8, bArr);
                this.pkOut = bCPGOutputStream4;
                bCPGOutputStream4.write(3);
                outputStream2 = new CBZip2OutputStream(this.pkOut);
            } else {
                throw new IllegalStateException("generator not initialised");
            }
            this.dOut = outputStream2;
            return new WrappedGeneratorStream(this.dOut, this);
        }
        throw new IllegalStateException("generator already in open state");
    }
}
