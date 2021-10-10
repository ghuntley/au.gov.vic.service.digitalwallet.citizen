package com.google.android.gms.common.config;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    private static zza zzd;
    private static int zze;
    private static Context zzf;
    private static Set<String> zzg;
    protected final String zza;
    protected final T zzb;
    private T zzh = null;

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public interface zza {
        Boolean zza(String str, Boolean bool);

        Float zza(String str, Float f);

        Integer zza(String str, Integer num);

        Long zza(String str, Long l);

        String zza(String str, String str2);
    }

    private static boolean zza() {
        synchronized (zzc) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(String str);

    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    protected GservicesValue(String str, T t) {
        this.zza = str;
        this.zzb = t;
    }

    public void override(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzh = t;
        synchronized (zzc) {
            zza();
        }
    }

    public void resetOverride() {
        this.zzh = null;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = android.os.Binder.clearCallingIdentity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3 = zza(r4.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0032, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0035, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0036, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0039, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0020 */
    public final T get() {
        T t = this.zzh;
        if (t != null) {
            return t;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = zzc;
        synchronized (obj) {
        }
        synchronized (obj) {
            zzg = null;
            zzf = null;
        }
        T zza2 = zza(this.zza);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zza2;
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new zzb(str, Boolean.valueOf(z));
    }

    public static GservicesValue<Long> value(String str, Long l) {
        return new zza(str, l);
    }

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzd(str, num);
    }

    public static GservicesValue<Float> value(String str, Float f) {
        return new zzc(str, f);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zze(str, str2);
    }
}
