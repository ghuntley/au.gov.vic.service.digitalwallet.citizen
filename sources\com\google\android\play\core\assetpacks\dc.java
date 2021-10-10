package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;

public final class dc extends InputStream {
    private final Enumeration<File> a;
    private InputStream b;

    public dc(Enumeration<File> enumeration) throws IOException {
        this.a = enumeration;
        a();
    }

    /* access modifiers changed from: package-private */
    public final void a() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.b = this.a.hasMoreElements() ? new FileInputStream(this.a.nextElement()) : null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
            this.b = null;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.b == null) {
            return -1;
        }
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.b.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                a();
            } while (this.b != null);
            return -1;
        }
    }
}
