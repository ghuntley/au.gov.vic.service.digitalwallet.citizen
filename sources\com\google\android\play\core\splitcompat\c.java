package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.internal.aw;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c {
    private final long a;
    private final Context b;
    private File c;

    public c(Context context) throws PackageManager.NameNotFoundException {
        this.b = context;
        this.a = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    public static void o(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                o(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", file.getAbsolutePath()));
        }
    }

    private final File p() throws IOException {
        File file = new File(q(), "verified-splits");
        w(file);
        return file;
    }

    private final File q() throws IOException {
        File file = new File(r(), Long.toString(this.a));
        w(file);
        return file;
    }

    private final File r() throws IOException {
        if (this.c == null) {
            Context context = this.b;
            if (context != null) {
                this.c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.c, "splitcompat");
        w(file);
        return file;
    }

    private final File s() throws IOException {
        File file = new File(q(), "native-libraries");
        w(file);
        return file;
    }

    private final File t(String str) throws IOException {
        File u = u(s(), str);
        w(u);
        return u;
    }

    private static File u(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    private static String v(String str) {
        return String.valueOf(str).concat(".apk");
    }

    private static void w(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() != 0 ? "Unable to create directory: ".concat(valueOf) : new String("Unable to create directory: "));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    public final void a() throws IOException {
        File r = r();
        String[] list = r.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.a))) {
                    File file = new File(r, str);
                    String valueOf = String.valueOf(file);
                    long j = this.a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    o(file);
                }
            }
        }
    }

    public final File b(String str) throws IOException {
        return u(g(), v(str));
    }

    public final File c(String str) throws IOException {
        return u(p(), v(str));
    }

    public final File d(File file) throws IOException {
        return u(p(), file.getName());
    }

    public final File e(String str, String str2) throws IOException {
        return u(t(str), str2);
    }

    public final File f() throws IOException {
        return new File(q(), "lock.tmp");
    }

    public final File g() throws IOException {
        File file = new File(q(), "unverified-splits");
        w(file);
        return file;
    }

    public final File h(String str) throws IOException {
        File file = new File(q(), "dex");
        w(file);
        File u = u(file, str);
        w(u);
        return u;
    }

    /* access modifiers changed from: package-private */
    public final Set<q> i() throws IOException {
        File p = p();
        HashSet hashSet = new HashSet();
        File[] listFiles = p.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new q(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final List<String> j() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = s().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final void k(String str) throws IOException {
        o(t(str));
    }

    /* access modifiers changed from: package-private */
    public final void l(File file) throws IOException {
        aw.c(file.getParentFile().getParentFile().equals(s()), "File to remove is not a native library");
        o(file);
    }

    /* access modifiers changed from: package-private */
    public final Set<File> m(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = t(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final void n(String str) throws IOException {
        o(c(str));
    }
}
