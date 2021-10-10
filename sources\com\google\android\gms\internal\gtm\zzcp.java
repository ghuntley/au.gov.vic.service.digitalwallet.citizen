package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.stats.WakeLock;

public final class zzcp {
    static Object lock = new Object();
    static WakeLock zzacb;
    private static Boolean zzri;

    public static boolean zza(Context context) {
        Preconditions.checkNotNull(context);
        Boolean bool = zzri;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zza = zzcz.zza(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        zzri = Boolean.valueOf(zza);
        return zza;
    }

    public static void onReceive(Context context, Intent intent) {
        zzci zzco = zzap.zzc(context).zzco();
        if (intent == null) {
            zzco.zzt("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzco.zza("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zze = zzcq.zze(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (lock) {
                context.startService(intent2);
                if (zze) {
                    try {
                        if (zzacb == null) {
                            WakeLock wakeLock = new WakeLock(context, 1, "Analytics WakeLock");
                            zzacb = wakeLock;
                            wakeLock.setReferenceCounted(false);
                        }
                        zzacb.acquire(1000);
                    } catch (SecurityException unused) {
                        zzco.zzt("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }
}
