package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class bb implements av {
    bb() {
    }

    static void c(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File file : set) {
                String valueOf = String.valueOf(file.getParentFile().getAbsolutePath());
                Log.d("Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "));
                hashSet.add(file.getParentFile());
            }
            bq d = br.d(e(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) d.a()));
            synchronized (k.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                Log.d("Splitcompat", sb.toString());
                d.e(hashSet);
            }
        }
    }

    static boolean d(ClassLoader classLoader, File file, File file2, boolean z, ba baVar, String str, az azVar) {
        ArrayList<IOException> arrayList = new ArrayList<>();
        Object e = e(classLoader);
        bq d = br.d(e, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) d.a());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : asList) {
            arrayList2.add((File) br.c(obj, str, File.class).a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || azVar.a(e, file2, file)) {
            d.d(Arrays.asList(baVar.a(e, new ArrayList<>(Collections.singleton(file2)), file, arrayList)));
            if (arrayList.isEmpty()) {
                return true;
            }
            bp bpVar = new bp("DexPathList.makeDexElement failed");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = arrayList.get(i);
                Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                cj.a(bpVar, iOException);
            }
            br.d(e, "dexElementsSuppressedExceptions", IOException.class).d(arrayList);
            throw bpVar;
        }
        String valueOf = String.valueOf(file2.getPath());
        Log.w("SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "));
        return false;
    }

    static Object e(ClassLoader classLoader) {
        return br.c(classLoader, "pathList", Object.class).a();
    }

    static ba f() {
        return new ax();
    }

    static az g() {
        return new ay();
    }

    @Override // com.google.android.play.core.internal.av
    public final void a(ClassLoader classLoader, Set<File> set) {
        c(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.av
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return d(classLoader, file, file2, z, f(), "zip", g());
    }
}
