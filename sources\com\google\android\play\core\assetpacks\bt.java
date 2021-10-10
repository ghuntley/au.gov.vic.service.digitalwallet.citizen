package com.google.android.play.core.assetpacks;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.cj;
import com.google.android.play.core.internal.ck;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.zip.GZIPInputStream;

/* access modifiers changed from: package-private */
public final class bt {
    private static final ag a = new ag("ExtractChunkTaskHandler");
    private final byte[] b = new byte[8192];
    private final bb c;
    private final ck<w> d;
    private final ck<aw> e;
    private final bz f;

    bt(bb bbVar, ck<w> ckVar, ck<aw> ckVar2, bz bzVar) {
        this.c = bbVar;
        this.d = ckVar;
        this.e = ckVar2;
        this.f = bzVar;
    }

    private final File b(bs bsVar) {
        File h = this.c.h(bsVar.k, bsVar.a, bsVar.b, bsVar.c);
        if (!h.exists()) {
            h.mkdirs();
        }
        return h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017d A[Catch:{ all -> 0x032d, all -> 0x0333 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0291 A[SYNTHETIC, Splitter:B:91:0x0291] */
    public final void a(bs bsVar) {
        InputStream inputStream;
        dx a2;
        long j;
        File file;
        int min;
        int max;
        long j2;
        dr drVar = new dr(this.c, bsVar.k, bsVar.a, bsVar.b, bsVar.c);
        File o = this.c.o(bsVar.k, bsVar.a, bsVar.b, bsVar.c);
        if (!o.exists()) {
            o.mkdirs();
        }
        try {
            InputStream inputStream2 = bsVar.i;
            GZIPInputStream gZIPInputStream = bsVar.d != 1 ? inputStream2 : new GZIPInputStream(inputStream2, 8192);
            try {
                if (bsVar.e > 0) {
                    dq e2 = drVar.e();
                    int e3 = e2.e();
                    int i = bsVar.e;
                    if (e3 == i - 1) {
                        int a3 = e2.a();
                        if (a3 == 1) {
                            a.a("Resuming zip entry from last chunk during file %s.", e2.b());
                            File file2 = new File(e2.b());
                            if (file2.exists()) {
                                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                                randomAccessFile.seek(e2.c());
                                long d2 = e2.d();
                                while (true) {
                                    min = (int) Math.min(d2, (long) PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                                    max = Math.max(gZIPInputStream.read(this.b, 0, min), 0);
                                    if (max > 0) {
                                        randomAccessFile.write(this.b, 0, max);
                                    }
                                    j2 = d2 - ((long) max);
                                    if (j2 <= 0) {
                                        break;
                                    } else if (max <= 0) {
                                        break;
                                    } else {
                                        d2 = j2;
                                    }
                                }
                                long length = randomAccessFile.length();
                                randomAccessFile.close();
                                if (max != min) {
                                    a.a("Chunk has ended while resuming the previous chunks file content.", new Object[0]);
                                    drVar.a(file2.getCanonicalPath(), length, j2, bsVar.e);
                                }
                            } else {
                                throw new bv("Partial file specified in checkpoint does not exist. Corrupt directory.", bsVar.j);
                            }
                        } else if (a3 == 2) {
                            a.a("Resuming zip entry from last chunk during local file header.", new Object[0]);
                            File n = this.c.n(bsVar.k, bsVar.a, bsVar.b, bsVar.c);
                            if (n.exists()) {
                                inputStream = new SequenceInputStream(new FileInputStream(n), gZIPInputStream);
                                if (inputStream != null) {
                                    bm bmVar = new bm(inputStream);
                                    File b2 = b(bsVar);
                                    do {
                                        a2 = bmVar.a();
                                        if (!a2.g() && !bmVar.c()) {
                                            if (!a2.c() || a2.b()) {
                                                drVar.h(a2.i(), bmVar);
                                            } else {
                                                drVar.g(a2.i());
                                                File file3 = new File(b2, a2.d());
                                                file3.getParentFile().mkdirs();
                                                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                                int read = bmVar.read(this.b);
                                                while (read > 0) {
                                                    fileOutputStream.write(this.b, 0, read);
                                                    read = bmVar.read(this.b);
                                                }
                                                fileOutputStream.close();
                                            }
                                        }
                                        if (bmVar.b()) {
                                            break;
                                        }
                                    } while (!bmVar.c());
                                    if (bmVar.c()) {
                                        a.a("Writing central directory metadata.", new Object[0]);
                                        drVar.h(a2.i(), inputStream);
                                    }
                                    if (!bsVar.a()) {
                                        if (a2.g()) {
                                            a.a("Writing slice checkpoint for partial local file header.", new Object[0]);
                                            drVar.b(a2.i(), bsVar.e);
                                        } else if (bmVar.c()) {
                                            a.a("Writing slice checkpoint for central directory.", new Object[0]);
                                            drVar.c(bsVar.e);
                                        } else {
                                            if (a2.f() == 0) {
                                                a.a("Writing slice checkpoint for partial file.", new Object[0]);
                                                file = new File(b(bsVar), a2.d());
                                                j = a2.e() - bmVar.d();
                                                if (file.length() != j) {
                                                    throw new bv("Partial file is of unexpected size.");
                                                }
                                            } else {
                                                a.a("Writing slice checkpoint for partial unextractable file.", new Object[0]);
                                                file = drVar.j();
                                                j = file.length();
                                            }
                                            drVar.a(file.getCanonicalPath(), j, bmVar.d(), bsVar.e);
                                        }
                                    }
                                }
                                gZIPInputStream.close();
                                if (bsVar.a()) {
                                    try {
                                        drVar.d(bsVar.e);
                                    } catch (IOException e4) {
                                        a.b("Writing extraction finished checkpoint failed with %s.", e4.getMessage());
                                        throw new bv("Writing extraction finished checkpoint failed.", e4, bsVar.j);
                                    }
                                }
                                a.d("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(bsVar.e), bsVar.c, bsVar.k, Integer.valueOf(bsVar.j));
                                this.d.a().e(bsVar.j, bsVar.k, bsVar.c, bsVar.e);
                                bsVar.i.close();
                                if (bsVar.h == 3) {
                                    String str = bsVar.k;
                                    long j3 = bsVar.g;
                                    this.e.a().b(AssetPackState.b(str, 3, 0, j3, j3, this.f.c(str, bsVar), 1));
                                    return;
                                }
                                return;
                            }
                            throw new bv("Checkpoint extension file not found.", bsVar.j);
                        } else if (a3 == 3) {
                            a.a("Resuming central directory from last chunk.", new Object[0]);
                            drVar.f(gZIPInputStream, e2.c());
                            if (!bsVar.a()) {
                                throw new bv("Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB.", bsVar.j);
                            }
                        } else {
                            throw new bv(String.format("Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s.", Integer.valueOf(e2.a())), bsVar.j);
                        }
                        inputStream = null;
                        if (inputStream != null) {
                        }
                        gZIPInputStream.close();
                        if (bsVar.a()) {
                        }
                        a.d("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(bsVar.e), bsVar.c, bsVar.k, Integer.valueOf(bsVar.j));
                        this.d.a().e(bsVar.j, bsVar.k, bsVar.c, bsVar.e);
                        bsVar.i.close();
                        if (bsVar.h == 3) {
                        }
                    } else {
                        throw new bv(String.format("Trying to resume with chunk number %s when previously processed chunk was number %s.", Integer.valueOf(i), Integer.valueOf(e2.e())), bsVar.j);
                    }
                }
                inputStream = gZIPInputStream;
                if (inputStream != null) {
                }
                gZIPInputStream.close();
                if (bsVar.a()) {
                }
                a.d("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(bsVar.e), bsVar.c, bsVar.k, Integer.valueOf(bsVar.j));
                this.d.a().e(bsVar.j, bsVar.k, bsVar.c, bsVar.e);
                try {
                    bsVar.i.close();
                } catch (IOException unused) {
                    a.e("Could not close file for chunk %s of slice %s of pack %s.", Integer.valueOf(bsVar.e), bsVar.c, bsVar.k);
                }
                if (bsVar.h == 3) {
                }
            } catch (Throwable th) {
                cj.a(th, th);
            }
            throw th;
        } catch (IOException e5) {
            a.b("IOException during extraction %s.", e5.getMessage());
            throw new bv(String.format("Error extracting chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(bsVar.e), bsVar.c, bsVar.k, Integer.valueOf(bsVar.j)), e5, bsVar.j);
        }
    }
}
