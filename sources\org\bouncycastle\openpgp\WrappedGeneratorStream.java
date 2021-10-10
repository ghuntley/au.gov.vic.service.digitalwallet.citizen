package org.bouncycastle.openpgp;

import java.io.IOException;
import java.io.OutputStream;

class WrappedGeneratorStream extends OutputStream {
    private final OutputStream _out;
    private final StreamGenerator _sGen;

    public WrappedGeneratorStream(OutputStream outputStream, StreamGenerator streamGenerator) {
        this._out = outputStream;
        this._sGen = streamGenerator;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._sGen.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this._out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this._out.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this._out.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this._out.write(bArr, i, i2);
    }
}
