package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import com.google.android.gms.internal.gtm.zzv;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk {
    private static volatile zzk zzsq;
    private final Context zzrm;
    private final List<zzn> zzsr = new CopyOnWriteArrayList();
    private final zze zzss = new zze();
    private final zza zzst = new zza();
    private volatile zzq zzsu;
    private Thread.UncaughtExceptionHandler zzsv;

    static class zzb implements ThreadFactory {
        private static final AtomicInteger zzsz = new AtomicInteger();

        private zzb() {
        }

        public final Thread newThread(Runnable runnable) {
            int incrementAndGet = zzsz.incrementAndGet();
            StringBuilder sb = new StringBuilder(23);
            sb.append("measurement-");
            sb.append(incrementAndGet);
            return new zzc(runnable, sb.toString());
        }

        /* synthetic */ zzb(zzl zzl) {
            this();
        }
    }

    private zzk(Context context) {
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzrm = applicationContext;
    }

    /* access modifiers changed from: package-private */
    public static class zzc extends Thread {
        zzc(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* access modifiers changed from: package-private */
    public class zza extends ThreadPoolExecutor {
        public zza() {
            super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new zzb(null));
            allowCoreThreadTimeOut(true);
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new zzm(this, runnable, t);
        }
    }

    public static zzk zzb(Context context) {
        Preconditions.checkNotNull(context);
        if (zzsq == null) {
            synchronized (zzk.class) {
                if (zzsq == null) {
                    zzsq = new zzk(context);
                }
            }
        }
        return zzsq;
    }

    public final zzq zzat() {
        if (this.zzsu == null) {
            synchronized (this) {
                if (this.zzsu == null) {
                    zzq zzq = new zzq();
                    PackageManager packageManager = this.zzrm.getPackageManager();
                    String packageName = this.zzrm.getPackageName();
                    zzq.setAppId(packageName);
                    zzq.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.zzrm.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(packageName);
                        Log.e("GAv4", valueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(valueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    zzq.setAppName(packageName);
                    zzq.setAppVersion(str);
                    this.zzsu = zzq;
                }
            }
        }
        return this.zzsu;
    }

    public final zzv zzau() {
        DisplayMetrics displayMetrics = this.zzrm.getResources().getDisplayMetrics();
        zzv zzv = new zzv();
        zzv.setLanguage(zzcz.zza(Locale.getDefault()));
        zzv.zzul = displayMetrics.widthPixels;
        zzv.zzum = displayMetrics.heightPixels;
        return zzv;
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzg zzg) {
        if (zzg.zzaq()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (!zzg.zzan()) {
            zzg zzai = zzg.zzai();
            zzai.zzao();
            this.zzst.execute(new zzl(this, zzai));
        } else {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
    }

    public final Context getContext() {
        return this.zzrm;
    }

    public static void zzav() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void zza(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzsv = uncaughtExceptionHandler;
    }

    public final <V> Future<V> zza(Callable<V> callable) {
        Preconditions.checkNotNull(callable);
        if (!(Thread.currentThread() instanceof zzc)) {
            return this.zzst.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        this.zzst.submit(runnable);
    }

    /* access modifiers changed from: private */
    public static void zzb(zzg zzg) {
        Preconditions.checkNotMainThread("deliver should be called from worker thread");
        Preconditions.checkArgument(zzg.zzan(), "Measurement must be submitted");
        List<zzo> zzak = zzg.zzak();
        if (!zzak.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (zzo zzo : zzak) {
                Uri zzae = zzo.zzae();
                if (!hashSet.contains(zzae)) {
                    hashSet.add(zzae);
                    zzo.zzb(zzg);
                }
            }
        }
    }
}
