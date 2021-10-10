package org.bouncycastle.openpgp;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.bouncycastle.apache.bzip2.CBZip2InputStream;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.CompressedDataPacket;
import org.bouncycastle.bcpg.CompressionAlgorithmTags;

public class PGPCompressedData implements CompressionAlgorithmTags {
    CompressedDataPacket data;

    public PGPCompressedData(BCPGInputStream bCPGInputStream) throws IOException {
        this.data = (CompressedDataPacket) bCPGInputStream.readPacket();
    }

    public int getAlgorithm() {
        return this.data.getAlgorithm();
    }

    public InputStream getDataStream() throws PGPException {
        if (getAlgorithm() == 0) {
            return getInputStream();
        }
        if (getAlgorithm() == 1) {
            return new InflaterInputStream(getInputStream(), new Inflater(true)) {
                /* class org.bouncycastle.openpgp.PGPCompressedData.AnonymousClass1 */
                private boolean eof = false;

                /* access modifiers changed from: protected */
                @Override // java.util.zip.InflaterInputStream
                public void fill() throws IOException {
                    if (!this.eof) {
                        this.len = this.in.read(this.buf, 0, this.buf.length);
                        if (this.len == -1) {
                            this.buf[0] = 0;
                            this.len = 1;
                            this.eof = true;
                        }
                        this.inf.setInput(this.buf, 0, this.len);
                        return;
                    }
                    throw new EOFException("Unexpected end of ZIP input stream");
                }
            };
        }
        if (getAlgorithm() == 2) {
            return new InflaterInputStream(getInputStream()) {
                /* class org.bouncycastle.openpgp.PGPCompressedData.AnonymousClass2 */
                private boolean eof = false;

                /* access modifiers changed from: protected */
                @Override // java.util.zip.InflaterInputStream
                public void fill() throws IOException {
                    if (!this.eof) {
                        this.len = this.in.read(this.buf, 0, this.buf.length);
                        if (this.len == -1) {
                            this.buf[0] = 0;
                            this.len = 1;
                            this.eof = true;
                        }
                        this.inf.setInput(this.buf, 0, this.len);
                        return;
                    }
                    throw new EOFException("Unexpected end of ZIP input stream");
                }
            };
        }
        if (getAlgorithm() == 3) {
            try {
                return new CBZip2InputStream(getInputStream());
            } catch (IOException e) {
                throw new PGPException("I/O problem with stream: " + e, e);
            }
        } else {
            throw new PGPException("can't recognise compression algorithm: " + getAlgorithm());
        }
    }

    public InputStream getInputStream() {
        return this.data.getInputStream();
    }
}
