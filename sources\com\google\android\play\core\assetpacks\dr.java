package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.cj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* access modifiers changed from: package-private */
public final class dr {
    private static final ag a = new ag("SliceMetadataManager");
    private final byte[] b = new byte[8192];
    private final bb c;
    private final String d;
    private final int e;
    private final long f;
    private final String g;
    private int h;

    dr(bb bbVar, String str, int i, long j, String str2) {
        this.c = bbVar;
        this.d = str;
        this.e = i;
        this.f = j;
        this.g = str2;
        this.h = -1;
    }

    private final File n() {
        File o = this.c.o(this.d, this.e, this.f, this.g);
        if (!o.exists()) {
            o.mkdirs();
        }
        return o;
    }

    private final File o() throws IOException {
        File m = this.c.m(this.d, this.e, this.f, this.g);
        m.getParentFile().mkdirs();
        m.createNewFile();
        return m;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void b(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File n = this.c.n(this.d, this.e, this.f, this.g);
            if (n.exists()) {
                n.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(n);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                return;
            } catch (Throwable th) {
                cj.a(th, th);
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            cj.a(th, th2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(j().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void d(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.h));
        FileOutputStream fileOutputStream = new FileOutputStream(o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final dq e() throws IOException {
        File m = this.c.m(this.d, this.e, this.f, this.g);
        if (m.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(m);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new bv("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.h = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new dq(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e2) {
                    throw new bv("Slice checkpoint file corrupt.", e2);
                }
            } catch (Throwable th) {
                cj.a(th, th);
            }
        } else {
            throw new bv("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void f(InputStream inputStream, long j) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(j(), "rw");
        try {
            randomAccessFile.seek(j);
            do {
                read = inputStream.read(this.b);
                if (read > 0) {
                    randomAccessFile.write(this.b, 0, read);
                }
            } while (read == 8192);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void g(byte[] bArr) throws IOException {
        this.h++;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(n(), String.format("%s-LFH.dat", Integer.valueOf(this.h))));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                return;
            } catch (Throwable th) {
                cj.a(th, th);
            }
            throw th;
        } catch (IOException e2) {
            throw new bv("Could not write metadata file.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void h(byte[] bArr, InputStream inputStream) throws IOException {
        this.h++;
        FileOutputStream fileOutputStream = new FileOutputStream(j());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.b);
            while (read > 0) {
                fileOutputStream.write(this.b, 0, read);
                read = inputStream.read(this.b);
            }
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void i(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(j(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final File j() {
        return new File(n(), String.format("%s-NAM.dat", Integer.valueOf(this.h)));
    }

    /* access modifiers changed from: package-private */
    public final int k() throws IOException {
        File m = this.c.m(this.d, this.e, this.f, this.g);
        if (!m.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(m);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new bv("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final boolean l() {
        File m = this.c.m(this.d, this.e, this.f, this.g);
        if (!m.exists()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(m);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") != null) {
                    return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
                }
                a.b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                return false;
            } catch (Throwable th) {
                cj.a(th, th);
            }
        } catch (IOException e2) {
            a.b("Could not read checkpoint while checking if extraction finished. %s", e2);
            return false;
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void m(byte[] bArr, int i) throws IOException {
        this.h++;
        FileOutputStream fileOutputStream = new FileOutputStream(j());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }
}
