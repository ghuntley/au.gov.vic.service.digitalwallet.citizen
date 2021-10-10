package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
public final /* synthetic */ class cx implements FilenameFilter {
    private final String a;

    cx(String str) {
        this.a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.a).concat("-")) && str.endsWith(".apk");
    }
}
