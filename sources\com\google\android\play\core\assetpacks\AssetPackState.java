package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.internal.i;

public abstract class AssetPackState {
    public static AssetPackState b(String str, int i, int i2, long j, long j2, double d, int i3) {
        return new bh(str, i, i2, j, j2, (int) Math.rint(100.0d * d), i3);
    }

    static AssetPackState c(Bundle bundle, String str, bz bzVar, az azVar) {
        int a = azVar.a(bundle.getInt(i.e("status", str)), str);
        int i = bundle.getInt(i.e("error_code", str));
        long j = bundle.getLong(i.e("bytes_downloaded", str));
        long j2 = bundle.getLong(i.e("total_bytes_to_download", str));
        double b = bzVar.b(str);
        long j3 = bundle.getLong(i.e("pack_version", str));
        long j4 = bundle.getLong(i.e("pack_base_version", str));
        int i2 = 1;
        if (!(a != 4 || j4 == 0 || j4 == j3)) {
            i2 = 2;
        }
        return b(str, a, i, j, j2, b, i2);
    }

    public abstract int a();

    public abstract long bytesDownloaded();

    public abstract int errorCode();

    public abstract String name();

    public abstract int status();

    public abstract long totalBytesToDownload();

    public abstract int transferProgressPercentage();
}
