package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitcompat.c;
import com.google.android.play.core.splitcompat.p;
import com.google.android.play.core.splitinstall.d;
import com.google.android.play.core.splitinstall.f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.concurrent.Executor;

public final class at implements f {
    private final Context a;
    private final c b;
    private final au c;
    private final Executor d;
    private final p e;

    public at(Context context, Executor executor, au auVar, c cVar, p pVar) {
        this.a = context;
        this.b = cVar;
        this.c = auVar;
        this.d = executor;
        this.e = pVar;
    }

    static /* synthetic */ void c(at atVar, d dVar) {
        try {
            if (!SplitCompat.a(p.c(atVar.a))) {
                Log.e("SplitCompat", "Emulating splits failed.");
                dVar.c(-12);
                return;
            }
            Log.i("SplitCompat", "Splits installed.");
            dVar.a();
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error emulating splits.", e2);
            dVar.c(-12);
        }
    }

    static /* synthetic */ void d(at atVar, List list, d dVar) {
        Integer e2 = atVar.e(list);
        if (e2 != null) {
            if (e2.intValue() == 0) {
                dVar.b();
            } else {
                dVar.c(e2.intValue());
            }
        }
    }

    private final Integer e(List<Intent> list) {
        FileLock fileLock;
        try {
            FileChannel channel = new RandomAccessFile(this.b.f(), "rw").getChannel();
            Integer num = null;
            try {
                fileLock = channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                fileLock = null;
            }
            if (fileLock != null) {
                int i = 0;
                try {
                    Log.i("SplitCompat", "Copying splits.");
                    for (Intent intent : list) {
                        String stringExtra = intent.getStringExtra("split_id");
                        AssetFileDescriptor openAssetFileDescriptor = this.a.getContentResolver().openAssetFileDescriptor(intent.getData(), "r");
                        File b2 = this.b.b(stringExtra);
                        if (!b2.exists() || b2.length() == openAssetFileDescriptor.getLength()) {
                            if (b2.exists()) {
                            }
                        }
                        if (!this.b.c(stringExtra).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(b2);
                                try {
                                    byte[] bArr = new byte[4096];
                                    while (true) {
                                        int read = bufferedInputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.close();
                                    bufferedInputStream.close();
                                } catch (Throwable th) {
                                    cj.a(th, th);
                                }
                            } catch (Throwable th2) {
                                cj.a(th, th2);
                            }
                        }
                    }
                    Log.i("SplitCompat", "Splits copied.");
                    try {
                        if (!this.c.a()) {
                            try {
                                Log.e("SplitCompat", "Split verification failed.");
                                i = -11;
                                num = Integer.valueOf(i);
                                fileLock.release();
                            } catch (Throwable th3) {
                                cj.a(th, th3);
                            }
                        } else {
                            Log.i("SplitCompat", "Splits verified.");
                            num = Integer.valueOf(i);
                            fileLock.release();
                        }
                    } catch (Exception e2) {
                        Log.e("SplitCompat", "Error verifying splits.", e2);
                    }
                } catch (Exception e3) {
                    Log.e("SplitCompat", "Error copying splits.", e3);
                    i = -13;
                }
            }
            if (channel != null) {
                channel.close();
            }
            return num;
            throw th;
            throw th;
            throw th;
        } catch (Exception e4) {
            Log.e("SplitCompat", "Error locking files.", e4);
            return -13;
        }
    }

    @Override // com.google.android.play.core.splitinstall.f
    public final void a(List<Intent> list, d dVar) {
        if (SplitCompat.b()) {
            this.d.execute(new as(this, list, dVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}
