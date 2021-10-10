package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.digitalwallet.app.model.ShareHolding;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.cj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
public final class bb {
    private static final ag a = new ag("AssetPackStorage");
    private static final long b = TimeUnit.DAYS.toMillis(14);
    private static final long c = TimeUnit.DAYS.toMillis(28);
    private final Context d;
    private final dl e;

    bb(Context context, dl dlVar) {
        this.d = context;
        this.e = dlVar;
    }

    private final File B(String str, int i) {
        return new File(C(str), String.valueOf(i));
    }

    private final File C(String str) {
        return new File(K(), str);
    }

    private final File D(String str, int i, long j) {
        return new File(j(str, i, j), "merge.tmp");
    }

    private static void E(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long F = F(file);
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (!file2.getName().equals(String.valueOf(F)) && !file2.getName().equals("stale.tmp")) {
                    L(file2);
                }
            }
        }
    }

    private static long F(File file) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e2) {
            a.c(e2, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    private static List<String> G(PackageInfo packageInfo, String str) {
        ArrayList arrayList = new ArrayList();
        if (packageInfo.splitNames == null) {
            return arrayList;
        }
        int i = (-Arrays.binarySearch(packageInfo.splitNames, str)) - 1;
        while (i < packageInfo.splitNames.length && packageInfo.splitNames[i].startsWith(str)) {
            arrayList.add(packageInfo.applicationInfo.splitSourceDirs[i]);
            i++;
        }
        return arrayList;
    }

    private final List<File> H() {
        ArrayList arrayList = new ArrayList();
        try {
            if (K().exists()) {
                if (K().listFiles() != null) {
                    File[] listFiles = K().listFiles();
                    for (File file : listFiles) {
                        if (!file.getCanonicalPath().equals(J().getCanonicalPath())) {
                            arrayList.add(file);
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (IOException e2) {
            a.b("Could not process directory while scanning installed packs. %s", e2);
        }
    }

    private final File I(String str, int i, long j) {
        return new File(new File(new File(J(), str), String.valueOf(i)), String.valueOf(j));
    }

    private final File J() {
        return new File(K(), "_tmp");
    }

    private final File K() {
        return new File(this.d.getFilesDir(), "assetpacks");
    }

    private static boolean L(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File file2 : listFiles) {
                z &= L(file2);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    /* access modifiers changed from: package-private */
    public final void A(String str, int i, long j) {
        if (I(str, i, j).exists()) {
            L(I(str, i, j));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str) {
        try {
            return e(str) != null;
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<String, AssetPackLocation> b() {
        HashMap hashMap = new HashMap();
        try {
            for (File file : H()) {
                AssetPackLocation d2 = d(file.getName());
                if (d2 != null) {
                    hashMap.put(file.getName(), d2);
                }
            }
        } catch (IOException e2) {
            a.b("Could not process directory while scanning installed packs: %s", e2);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Long> c() {
        HashMap hashMap = new HashMap();
        for (String str : b().keySet()) {
            hashMap.put(str, Long.valueOf(t(str)));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final AssetPackLocation d(String str) throws IOException {
        String e2 = e(str);
        if (e2 == null) {
            return null;
        }
        File file = new File(e2, ShareHolding.assetDataKey);
        if (file.isDirectory()) {
            return AssetPackLocation.b(e2, file.getCanonicalPath());
        }
        a.b("Failed to find assets directory: %s", file);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String e(String str) throws IOException {
        int length;
        File file = new File(K(), str);
        if (!file.exists()) {
            a.a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.e.a()));
        if (!file2.exists()) {
            a.a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            a.a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            a.b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.e.a()));
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final File f(String str, int i, long j) {
        return new File(B(str, i), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final File g(String str, int i, long j) {
        return new File(f(str, i, j), "_metadata");
    }

    /* access modifiers changed from: package-private */
    public final File h(String str, int i, long j, String str2) {
        return new File(new File(new File(I(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* access modifiers changed from: package-private */
    public final File i(String str, int i, long j, String str2) {
        return new File(new File(new File(I(str, i, j), "_slices"), "_verified"), str2);
    }

    /* access modifiers changed from: package-private */
    public final File j(String str, int i, long j) {
        return new File(I(str, i, j), "_packs");
    }

    /* access modifiers changed from: package-private */
    public final int k(String str, int i, long j) throws IOException {
        File D = D(str, i, j);
        if (!D.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(D);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e2) {
                    throw new bv("Merge checkpoint file corrupt.", e2);
                }
            } else {
                throw new bv("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            cj.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void l(String str, int i, long j, int i2) throws IOException {
        File D = D(str, i, j);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        D.getParentFile().mkdirs();
        D.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(D);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final File m(String str, int i, long j, String str2) {
        return new File(o(str, i, j, str2), "checkpoint.dat");
    }

    /* access modifiers changed from: package-private */
    public final File n(String str, int i, long j, String str2) {
        return new File(o(str, i, j, str2), "checkpoint_ext.dat");
    }

    /* access modifiers changed from: package-private */
    public final File o(String str, int i, long j, String str2) {
        return new File(p(str, i, j), str2);
    }

    /* access modifiers changed from: package-private */
    public final File p(String str, int i, long j) {
        return new File(new File(I(str, i, j), "_slices"), "_metadata");
    }

    /* access modifiers changed from: package-private */
    public final boolean q(String str) {
        if (!C(str).exists()) {
            return true;
        }
        return L(C(str));
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        for (File file : H()) {
            if (file.listFiles() != null) {
                E(file);
                long F = F(file);
                if (((long) this.e.a()) != F) {
                    try {
                        new File(new File(file, String.valueOf(F)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        a.b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File file2 : file.listFiles()) {
                    E(file2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int s(String str) {
        return (int) F(C(str));
    }

    /* access modifiers changed from: package-private */
    public final long t(String str) {
        return F(B(str, s(str)));
    }

    /* access modifiers changed from: package-private */
    public final void u() {
        for (File file : H()) {
            if (file.listFiles() != null) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    File file3 = new File(file2, "stale.tmp");
                    if (file3.exists() && System.currentTimeMillis() - file3.lastModified() > c) {
                        L(file2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void v() {
        if (J().exists()) {
            File[] listFiles = J().listFiles();
            for (File file : listFiles) {
                if (System.currentTimeMillis() - file.lastModified() > b) {
                    L(file);
                } else {
                    E(file);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void w() {
        L(K());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    public final AssetLocation x(String str, String str2) {
        PackageInfo packageInfo;
        ArrayList<String> arrayList;
        String str3;
        String str4;
        try {
            packageInfo = this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            a.b("Could not find PackageInfo.", new Object[0]);
            packageInfo = null;
        }
        if (packageInfo == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT < 21) {
                arrayList.add(packageInfo.applicationInfo.sourceDir);
            } else {
                if (packageInfo.splitNames == null || packageInfo.applicationInfo.splitSourceDirs == null) {
                    a.a("No splits present for package %s.", str);
                } else {
                    int binarySearch = Arrays.binarySearch(packageInfo.splitNames, str);
                    if (binarySearch < 0) {
                        a.a("Asset Pack '%s' is not installed.", str);
                    } else {
                        str3 = packageInfo.applicationInfo.splitSourceDirs[binarySearch];
                        if (str3 != null) {
                            arrayList.add(packageInfo.applicationInfo.sourceDir);
                            str4 = "config.";
                        } else {
                            arrayList.add(str3);
                            str4 = String.valueOf(str).concat(".config.");
                        }
                        arrayList.addAll(G(packageInfo, str4));
                    }
                }
                str3 = null;
                if (str3 != null) {
                }
                arrayList.addAll(G(packageInfo, str4));
            }
        }
        if (arrayList == null) {
            return null;
        }
        String path = new File(ShareHolding.assetDataKey, str2).getPath();
        for (String str5 : arrayList) {
            try {
                AssetLocation b2 = db.b(str5, path);
                if (b2 != null) {
                    return b2;
                }
            } catch (IOException e2) {
                a.c(e2, "Failed to parse APK file '%s' looking for asset '%s'.", str5, str2);
                return null;
            }
        }
        a.a("The asset %s is not present in Asset Pack %s. Searched in APKs: %s", str2, str, arrayList);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final AssetLocation y(String str, String str2, AssetPackLocation assetPackLocation) {
        File file = new File(assetPackLocation.assetsPath(), str2);
        if (file.exists()) {
            return AssetLocation.a(file.getPath(), 0, file.length());
        }
        a.a("The asset %s is not present in Asset Pack %s. Searched in folder: %s", str2, str, assetPackLocation.assetsPath());
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void z(List<String> list) {
        int a2 = this.e.a();
        for (File file : H()) {
            if (!list.contains(file.getName()) && F(file) != ((long) a2)) {
                L(file);
            }
        }
    }
}
