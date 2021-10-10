package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;

/* access modifiers changed from: package-private */
public final class bk implements az {
    bk() {
    }

    @Override // com.google.android.play.core.internal.az
    public final boolean a(Object obj, File file, File file2) {
        try {
            return !((Boolean) br.e(Class.forName("dalvik.system.DexFile"), Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
