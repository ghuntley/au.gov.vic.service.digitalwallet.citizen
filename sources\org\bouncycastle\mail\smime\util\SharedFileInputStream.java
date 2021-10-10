package org.bouncycastle.mail.smime.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import javax.mail.internet.SharedInputStream;

public class SharedFileInputStream extends FilterInputStream implements SharedInputStream {
    private final File _file;
    private final long _length;
    private long _markedPosition;
    private final SharedFileInputStream _parent;
    private long _position;
    private final long _start;
    private List _subStreams;

    public SharedFileInputStream(File file) throws IOException {
        this(file, 0, file.length());
    }

    private SharedFileInputStream(File file, long j, long j2) throws IOException {
        super(new BufferedInputStream(new FileInputStream(file)));
        this._subStreams = new LinkedList();
        this._parent = null;
        this._file = file;
        this._start = j;
        this._length = j2;
        this.in.skip(j);
    }

    public SharedFileInputStream(String str) throws IOException {
        this(new File(str));
    }

    private SharedFileInputStream(SharedFileInputStream sharedFileInputStream, long j, long j2) throws IOException {
        super(new BufferedInputStream(new FileInputStream(sharedFileInputStream._file)));
        this._subStreams = new LinkedList();
        this._parent = sharedFileInputStream;
        this._file = sharedFileInputStream._file;
        this._start = j;
        this._length = j2;
        this.in.skip(j);
    }

    public void dispose() throws IOException {
        for (SharedFileInputStream sharedFileInputStream : this._subStreams) {
            try {
                sharedFileInputStream.dispose();
            } catch (IOException unused) {
            }
        }
        this.in.close();
    }

    public long getPosition() {
        return this._position;
    }

    public SharedFileInputStream getRoot() {
        SharedFileInputStream sharedFileInputStream = this._parent;
        return sharedFileInputStream != null ? sharedFileInputStream.getRoot() : this;
    }

    public void mark(int i) {
        this._markedPosition = this._position;
        this.in.mark(i);
    }

    public boolean markSupported() {
        return true;
    }

    public InputStream newStream(long j, long j2) {
        SharedFileInputStream sharedFileInputStream;
        if (j2 < 0) {
            try {
                long j3 = this._length;
                sharedFileInputStream = j3 > 0 ? new SharedFileInputStream(this, this._start + j, this._length - j) : j3 == 0 ? new SharedFileInputStream(this, this._start + j, 0) : new SharedFileInputStream(this, this._start + j, -1);
            } catch (IOException e) {
                throw new IllegalStateException("unable to create shared stream: " + e);
            }
        } else {
            sharedFileInputStream = new SharedFileInputStream(this, this._start + j, j2 - j);
        }
        this._subStreams.add(sharedFileInputStream);
        return sharedFileInputStream;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        long j = this._position;
        if (j == this._length) {
            return -1;
        }
        this._position = j + 1;
        return this.in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i3 < i2) {
            int read = read();
            if (read < 0) {
                break;
            }
            bArr[i + i3] = (byte) read;
            i3++;
        }
        if (i3 == 0) {
            return -1;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        this._position = this._markedPosition;
        this.in.reset();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 != j && read() >= 0) {
            j2++;
        }
        return j2;
    }
}
