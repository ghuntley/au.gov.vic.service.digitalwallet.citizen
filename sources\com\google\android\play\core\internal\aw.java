package com.google.android.play.core.internal;

import android.os.Build;
import java.io.File;

public final class aw {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static av a() {
        if (Build.VERSION.SDK_INT >= 21) {
            switch (Build.VERSION.SDK_INT) {
                case 21:
                    return new bb();
                case 22:
                    return new bc();
                case 23:
                    return new bg();
                case 24:
                    return new bh();
                case 25:
                    return new bi();
                case 26:
                    return new bl();
                case 27:
                    if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                        return new bm();
                    }
                    break;
            }
            return new bo();
        }
        throw new AssertionError("Unsupported Android Version");
    }

    public static String b(File file) {
        if (file.getName().endsWith(".apk")) {
            String str = "";
            String replaceFirst = file.getName().replaceFirst("(_\\d+)?\\.apk", str);
            if (replaceFirst.equals("base-master")) {
                return str;
            }
            String str2 = "base-";
            if (replaceFirst.startsWith(str2)) {
                str = "config.";
            } else {
                replaceFirst = replaceFirst.replace("-", ".config.");
                str2 = ".config.master";
            }
            return replaceFirst.replace(str2, str);
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    public static void c(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> void d(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException((String) obj);
        }
    }
}
