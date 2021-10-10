package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.play.core.internal.at;
import com.google.android.play.core.internal.au;
import com.google.android.play.core.internal.av;
import com.google.android.play.core.internal.aw;
import com.google.android.play.core.internal.bp;
import com.google.android.play.core.internal.cj;
import com.google.android.play.core.splitinstall.l;
import com.google.android.play.core.splitinstall.o;
import com.google.android.play.core.splitinstall.p;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SplitCompat {
    private static final AtomicReference<SplitCompat> a = new AtomicReference<>(null);
    private final c b;
    private final Set<String> c = new HashSet();
    private final a d;

    private SplitCompat(Context context) {
        try {
            c cVar = new c(context);
            this.b = cVar;
            this.d = new a(cVar);
        } catch (PackageManager.NameNotFoundException e) {
            throw new bp(e);
        }
    }

    public static boolean a(Context context) {
        return g(context, true);
    }

    public static boolean b() {
        return a.get() != null;
    }

    private static boolean e() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* access modifiers changed from: private */
    public final Set<String> f() {
        HashSet hashSet;
        synchronized (this.c) {
            hashSet = new HashSet(this.c);
        }
        return hashSet;
    }

    private static boolean g(Context context, boolean z) {
        if (e()) {
            return false;
        }
        AtomicReference<SplitCompat> atomicReference = a;
        boolean compareAndSet = atomicReference.compareAndSet(null, new SplitCompat(context));
        SplitCompat splitCompat = atomicReference.get();
        if (compareAndSet) {
            l.a.b(new at(context, p.a(), new au(context, splitCompat.b, new aw(), null), splitCompat.b, new p()));
            o.b(new l(splitCompat));
            p.a().execute(new m(context));
        }
        try {
            splitCompat.h(context, z);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a4 A[SYNTHETIC, Splitter:B:76:0x01a4] */
    private final synchronized void h(Context context, boolean z) throws IOException {
        IOException e;
        ZipFile zipFile;
        if (z) {
            this.b.a();
        } else {
            p.a().execute(new n(this));
        }
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            List<String> arrayList = packageInfo.splitNames == null ? new ArrayList() : Arrays.asList(packageInfo.splitNames);
            Set<q> i = this.b.i();
            HashSet hashSet = new HashSet();
            Iterator<q> it = i.iterator();
            while (it.hasNext()) {
                String b2 = it.next().b();
                if (arrayList.contains(b2)) {
                    if (z) {
                        this.b.n(b2);
                    } else {
                        hashSet.add(b2);
                    }
                    it.remove();
                }
            }
            if (!hashSet.isEmpty()) {
                p.a().execute(new o(this, hashSet));
            }
            HashSet hashSet2 = new HashSet();
            for (q qVar : i) {
                String b3 = qVar.b();
                if (!p.e(b3)) {
                    hashSet2.add(b3);
                }
            }
            for (String str : arrayList) {
                if (!p.e(str)) {
                    hashSet2.add(str);
                }
            }
            HashSet<q> hashSet3 = new HashSet(i.size());
            for (q qVar2 : i) {
                if (!p.d(qVar2.b())) {
                    String b4 = qVar2.b();
                    if (!hashSet2.contains(p.d(b4) ? "" : b4.split("\\.config\\.", 2)[0])) {
                    }
                }
                hashSet3.add(qVar2);
            }
            k kVar = new k(this.b);
            av a2 = aw.a();
            ClassLoader classLoader = context.getClassLoader();
            if (z) {
                a2.a(classLoader, kVar.a());
            } else {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    Set<File> b5 = kVar.b((q) it2.next());
                    if (b5 == null) {
                        it2.remove();
                    } else {
                        a2.a(classLoader, b5);
                    }
                }
            }
            HashSet hashSet4 = new HashSet();
            for (q qVar3 : hashSet3) {
                try {
                    zipFile = new ZipFile(qVar3.a());
                    try {
                        ZipEntry entry = zipFile.getEntry("classes.dex");
                        zipFile.close();
                        if (entry == null || a2.b(classLoader, this.b.h(qVar3.b()), qVar3.a(), z)) {
                            hashSet4.add(qVar3.a());
                        } else {
                            String valueOf = String.valueOf(qVar3.a());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
                            sb.append("split was not installed ");
                            sb.append(valueOf);
                            Log.w("SplitCompat", sb.toString());
                        }
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
            this.d.b(context, hashSet4);
            HashSet hashSet5 = new HashSet();
            for (q qVar4 : hashSet3) {
                if (hashSet4.contains(qVar4.a())) {
                    String b6 = qVar4.b();
                    StringBuilder sb2 = new StringBuilder(b6.length() + 30);
                    sb2.append("Split '");
                    sb2.append(b6);
                    sb2.append("' installation emulated");
                    Log.d("SplitCompat", sb2.toString());
                    hashSet5.add(qVar4.b());
                } else {
                    String b7 = qVar4.b();
                    StringBuilder sb3 = new StringBuilder(b7.length() + 35);
                    sb3.append("Split '");
                    sb3.append(b7);
                    sb3.append("' installation not emulated.");
                    Log.d("SplitCompat", sb3.toString());
                }
            }
            synchronized (this.c) {
                this.c.addAll(hashSet5);
            }
        } catch (PackageManager.NameNotFoundException e5) {
            throw new IOException(String.format("Cannot load data for application '%s'", packageName), e5);
        }
    }

    public static boolean install(Context context) {
        return g(context, false);
    }

    public static boolean installActivity(Context context) {
        if (e()) {
            return false;
        }
        SplitCompat splitCompat = a.get();
        if (splitCompat != null) {
            return splitCompat.d.a(context, splitCompat.f());
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }
}
