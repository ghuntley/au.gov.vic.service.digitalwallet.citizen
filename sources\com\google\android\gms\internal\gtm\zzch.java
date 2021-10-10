package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public final class zzch {
    private static volatile Logger zzabk = new zzbr();

    public static void zzf(String str, Object obj) {
        String str2;
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zze(str, obj);
        } else if (isLoggable(3)) {
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(valueOf).length());
                sb.append(str);
                sb.append(":");
                sb.append(valueOf);
                str2 = sb.toString();
            } else {
                str2 = str;
            }
            Log.e(zzby.zzzb.get(), str2);
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void zzab(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzq(str);
        } else if (isLoggable(0)) {
            Log.v(zzby.zzzb.get(), str);
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void zzac(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzt(str);
        } else if (isLoggable(2)) {
            Log.w(zzby.zzzb.get(), str);
        }
        Logger logger = zzabk;
        if (logger != null) {
            logger.warn(str);
        }
    }

    private static boolean isLoggable(int i) {
        if (zzabk == null || zzabk.getLogLevel() > i) {
            return false;
        }
        return true;
    }

    public static void setLogger(Logger logger) {
        zzabk = logger;
    }

    public static Logger getLogger() {
        return zzabk;
    }
}
