package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.internal.cj;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* access modifiers changed from: package-private */
public final class g implements i {
    final /* synthetic */ Set a;
    final /* synthetic */ q b;
    final /* synthetic */ ZipFile c;

    g(Set set, q qVar, ZipFile zipFile) {
        this.a = set;
        this.b = qVar;
        this.c = zipFile;
    }

    @Override // com.google.android.play.core.splitcompat.i
    public final void a(j jVar, File file, boolean z) throws IOException {
        this.a.add(file);
        if (!z) {
            Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", this.b.b(), jVar.a, this.b.a().getAbsolutePath(), jVar.b.getName(), file.getAbsolutePath()));
            ZipFile zipFile = this.c;
            ZipEntry zipEntry = jVar.b;
            int i = k.a;
            byte[] bArr = new byte[4096];
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        cj.a(th, th);
                    }
                }
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                cj.a(th, th2);
            }
        } else {
            return;
        }
        throw th;
        throw th;
    }
}
