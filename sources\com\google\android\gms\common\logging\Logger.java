package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    /* JADX WARNING: Illegal instructions before constructor call */
    public Logger(String str, String... strArr) {
        this(str, r8);
        String str2;
        if (strArr.length == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append(']');
            sb.append(' ');
            str2 = sb.toString();
        }
    }

    private Logger(String str, String str2) {
        this.zzb = str2;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    public String getTag() {
        return this.zza;
    }

    public boolean isLoggable(int i) {
        return this.zzd <= i;
    }

    public void v(String str, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr));
        }
    }

    public void v(String str, Throwable th, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr), th);
        }
    }

    public void d(String str, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr));
        }
    }

    public void d(String str, Throwable th, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr), th);
        }
    }

    public void i(String str, Object... objArr) {
        Log.i(this.zza, format(str, objArr));
    }

    public void w(String str, Object... objArr) {
        Log.w(this.zza, format(str, objArr));
    }

    public void e(String str, Object... objArr) {
        Log.e(this.zza, format(str, objArr));
    }

    public void e(String str, Throwable th, Object... objArr) {
        Log.e(this.zza, format(str, objArr), th);
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        Log.wtf(this.zza, format(str, objArr), th);
    }

    public void wtf(Throwable th) {
        Log.wtf(this.zza, th);
    }

    /* access modifiers changed from: protected */
    public String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }
}
