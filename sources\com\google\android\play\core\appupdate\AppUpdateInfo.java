package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

public abstract class AppUpdateInfo {
    public static AppUpdateInfo a(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        return new t(str, i, i2, i3, num, i4, j, j2, j3, j4, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4);
    }

    private final boolean i(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && b() <= c();
    }

    public abstract int availableVersionCode();

    /* access modifiers changed from: package-private */
    public abstract long b();

    public abstract long bytesDownloaded();

    /* access modifiers changed from: package-private */
    public abstract long c();

    public abstract Integer clientVersionStalenessDays();

    /* access modifiers changed from: package-private */
    public abstract PendingIntent d();

    /* access modifiers changed from: package-private */
    public abstract PendingIntent e();

    /* access modifiers changed from: package-private */
    public abstract PendingIntent f();

    /* access modifiers changed from: package-private */
    public abstract PendingIntent g();

    /* access modifiers changed from: package-private */
    public final PendingIntent h(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() != 0) {
            if (appUpdateOptions.appUpdateType() == 1) {
                if (d() != null) {
                    return d();
                }
                if (i(appUpdateOptions)) {
                    return f();
                }
            }
            return null;
        } else if (e() != null) {
            return e();
        } else {
            if (i(appUpdateOptions)) {
                return g();
            }
            return null;
        }
    }

    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(int i) {
        return h(AppUpdateOptions.defaultOptions(i)) != null;
    }

    public boolean isUpdateTypeAllowed(AppUpdateOptions appUpdateOptions) {
        return h(appUpdateOptions) != null;
    }

    public abstract String packageName();

    public abstract long totalBytesToDownload();

    public abstract int updateAvailability();

    public abstract int updatePriority();
}
