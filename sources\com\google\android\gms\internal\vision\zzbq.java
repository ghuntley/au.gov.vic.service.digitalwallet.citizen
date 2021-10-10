package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzbq implements zzay {
    private static final Map<String, zzbq> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;
    private final Object zzd = new Object();
    private volatile Map<String, ?> zze;
    private final List<zzaz> zzf = new ArrayList();

    static zzbq zza(Context context, String str) {
        zzbq zzbq;
        if (!((!zzas.zza() || str.startsWith("direct_boot:")) ? true : zzas.zza(context))) {
            return null;
        }
        synchronized (zzbq.class) {
            Map<String, zzbq> map = zza;
            zzbq = map.get(str);
            if (zzbq == null) {
                zzbq = new zzbq(zzb(context, str));
                map.put(str, zzbq);
            }
        }
        return zzbq;
    }

    private static SharedPreferences zzb(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzas.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private zzbq(SharedPreferences sharedPreferences) {
        zzbt zzbt = new zzbt(this);
        this.zzc = zzbt;
        this.zzb = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(zzbt);
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.gms.internal.vision.zzay
    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zza() {
        synchronized (zzbq.class) {
            for (zzbq zzbq : zza.values()) {
                zzbq.zzb.unregisterOnSharedPreferenceChangeListener(zzbq.zzc);
            }
            zza.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzbi.zza();
        }
        synchronized (this) {
            for (zzaz zzaz : this.zzf) {
                zzaz.zza();
            }
        }
    }
}
