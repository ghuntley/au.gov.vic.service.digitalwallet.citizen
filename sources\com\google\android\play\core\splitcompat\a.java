package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.play.core.internal.br;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class a {
    private final c a;

    a(c cVar) {
        this.a = cVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028 A[Catch:{ Exception -> 0x0045, all -> 0x0043 }, LOOP:0: B:14:0x0022->B:16:0x0028, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    public final synchronized boolean a(Context context, Set<String> set) {
        StrictMode.ThreadPolicy threadPolicy;
        boolean z;
        Exception e;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.allowThreadDiskReads();
                StrictMode.allowThreadDiskWrites();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            threadPolicy = null;
            Log.i("SplitCompat", "Unable to set up strict mode.", e);
            HashSet hashSet = new HashSet();
            while (r6.hasNext()) {
            }
            b(context, hashSet);
            if (threadPolicy != null) {
            }
            z = true;
            return z;
        }
        try {
            HashSet hashSet2 = new HashSet();
            for (String str : set) {
                hashSet2.add(this.a.c(str));
            }
            b(context, hashSet2);
            if (threadPolicy != null) {
                StrictMode.setThreadPolicy(threadPolicy);
            }
            z = true;
        } catch (Exception e4) {
            Log.e("SplitCompat", "Error installing additional splits", e4);
            if (threadPolicy != null) {
                StrictMode.setThreadPolicy(threadPolicy);
            }
            z = false;
        } catch (Throwable th) {
            if (threadPolicy != null) {
                StrictMode.setThreadPolicy(threadPolicy);
            }
            throw th;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(Context context, Set<File> set) {
        AssetManager assets = context.getAssets();
        for (File file : set) {
            int intValue = ((Integer) br.a(assets, "addAssetPath", Integer.class, String.class, file.getPath())).intValue();
            StringBuilder sb = new StringBuilder(39);
            sb.append("addAssetPath completed with ");
            sb.append(intValue);
            Log.d("SplitCompat", sb.toString());
        }
    }
}
