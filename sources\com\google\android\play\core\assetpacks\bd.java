package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

final class bd extends InputStream {
    private final InputStream a;
    private long b;

    bd(InputStream inputStream, long j) {
        this.a = inputStream;
        this.b = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() throws IOException {
        super.close();
        this.a.close();
        this.b = 0;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        long j = this.b;
        if (j <= 0) {
            return -1;
        }
        this.b = j - 1;
        return this.a.read();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.b;
        if (j <= 0) {
            return -1;
        }
        int read = this.a.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.b -= (long) read;
        }
        return read;
    }
}
