package com.google.android.play.core.splitcompat;

import android.os.Build;
import android.util.Log;
import com.google.android.play.core.internal.cj;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class k {
    public static final /* synthetic */ int a = 0;
    private static final Pattern b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    private final c c;

    k(c cVar) throws IOException {
        this.c = cVar;
    }

    static /* synthetic */ Set d(k kVar, Set set, q qVar, ZipFile zipFile) throws IOException {
        HashSet hashSet = new HashSet();
        kVar.f(qVar, set, new g(hashSet, qVar, zipFile));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f4 A[SYNTHETIC, Splitter:B:33:0x00f4] */
    private static void e(q qVar, h hVar) throws IOException {
        IOException e;
        ZipFile zipFile;
        String format;
        try {
            zipFile = new ZipFile(qVar.a());
            try {
                String b2 = qVar.b();
                HashMap hashMap = new HashMap();
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    Matcher matcher = b.matcher(zipEntry.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        Log.d("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", b2, group2, group));
                        Set set = (Set) hashMap.get(group);
                        if (set == null) {
                            set = new HashSet();
                            hashMap.put(group, set);
                        }
                        set.add(new j(zipEntry, group2));
                    }
                }
                HashMap hashMap2 = new HashMap();
                String[] strArr = Build.SUPPORTED_ABIS;
                for (String str : strArr) {
                    if (hashMap.containsKey(str)) {
                        Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI", str));
                        for (j jVar : (Set) hashMap.get(str)) {
                            if (hashMap2.containsKey(jVar.a)) {
                                format = String.format("NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI", jVar.a, str);
                            } else {
                                hashMap2.put(jVar.a, jVar);
                                format = String.format("NativeLibraryExtractor: using library %s for ABI %s", jVar.a, str);
                            }
                            Log.d("SplitCompat", format);
                        }
                    } else {
                        Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are no native libraries for supported ABI %s", str));
                    }
                }
                hVar.a(zipFile, new HashSet(hashMap2.values()));
                zipFile.close();
            } catch (IOException e2) {
                e = e2;
                if (zipFile != null) {
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e4) {
                    cj.a(e, e4);
                }
            }
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void f(q qVar, Set<j> set, i iVar) throws IOException {
        for (j jVar : set) {
            File e = this.c.e(qVar.b(), jVar.a);
            boolean z = false;
            if (e.exists() && e.length() == jVar.b.getSize()) {
                z = true;
            }
            iVar.a(jVar, e, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final Set<File> a() throws IOException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<q> i = this.c.i();
        for (String str : this.c.j()) {
            Iterator<q> it = i.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().b().equals(str)) {
                        break;
                    }
                } else {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", str));
                    this.c.k(str);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (q qVar : i) {
            HashSet hashSet2 = new HashSet();
            e(qVar, new f(this, hashSet2, qVar));
            for (File file : this.c.m(qVar.b())) {
                if (!hashSet2.contains(file)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", file.getAbsolutePath(), qVar.b(), qVar.a().getAbsolutePath()));
                    this.c.l(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final Set<File> b(q qVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        e(qVar, new e(this, qVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }
}
