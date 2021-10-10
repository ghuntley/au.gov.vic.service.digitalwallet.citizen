package com.google.android.play.core.internal;

import com.google.android.play.core.splitinstall.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class bg implements av {
    bg() {
    }

    public static void c(ClassLoader classLoader, Set<File> set, bf bfVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File file : set) {
                hashSet.add(file.getParentFile());
            }
            Object e = bb.e(classLoader);
            bq c = br.c(e, "nativeLibraryDirectories", List.class);
            synchronized (k.class) {
                ArrayList arrayList = new ArrayList((Collection) c.a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                c.b(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a = bfVar.a(e, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                bp bpVar = new bp("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    cj.a(bpVar, arrayList2.get(i));
                }
                throw bpVar;
            }
            synchronized (k.class) {
                br.d(e, "nativeLibraryPathElements", Object.class).e(Arrays.asList(a));
            }
        }
    }

    static ba d() {
        return new bd();
    }

    static bf e() {
        return new be();
    }

    public static boolean f(ClassLoader classLoader, File file, File file2, boolean z) {
        return bb.d(classLoader, file, file2, z, d(), "zip", bb.g());
    }

    @Override // com.google.android.play.core.internal.av
    public final void a(ClassLoader classLoader, Set<File> set) {
        c(classLoader, set, e());
    }

    @Override // com.google.android.play.core.internal.av
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return f(classLoader, file, file2, z);
    }
}
