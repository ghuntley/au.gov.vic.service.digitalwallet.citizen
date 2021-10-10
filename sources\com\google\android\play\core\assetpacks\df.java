package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ag;
import java.io.File;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class df {
    private static final ag a = new ag("MergeSliceTaskHandler");
    private final bb b;

    df(bb bbVar) {
        this.b = bbVar;
    }

    private static void b(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            File[] listFiles = file.listFiles();
            for (File file3 : listFiles) {
                b(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
                sb.append("Unable to delete directory: ");
                sb.append(valueOf);
                throw new bv(sb.toString());
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 51);
            sb2.append("File clashing with existing file from other slice: ");
            sb2.append(valueOf2);
            throw new bv(sb2.toString());
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append("Unable to move file: ");
            sb3.append(valueOf3);
            throw new bv(sb3.toString());
        }
    }

    public final void a(de deVar) {
        File i = this.b.i(deVar.k, deVar.a, deVar.b, deVar.c);
        if (i.exists()) {
            File j = this.b.j(deVar.k, deVar.a, deVar.b);
            if (!j.exists()) {
                j.mkdirs();
            }
            b(i, j);
            try {
                this.b.l(deVar.k, deVar.a, deVar.b, this.b.k(deVar.k, deVar.a, deVar.b) + 1);
            } catch (IOException e) {
                a.b("Writing merge checkpoint failed with %s.", e.getMessage());
                throw new bv("Writing merge checkpoint failed.", e, deVar.j);
            }
        } else {
            throw new bv(String.format("Cannot find verified files for slice %s.", deVar.c), deVar.j);
        }
    }
}
