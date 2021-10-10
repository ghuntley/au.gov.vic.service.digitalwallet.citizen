package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class zzl {
    private static final zzl zzb = new zzl(true, null, null);
    final boolean zza;
    @Nullable
    private final String zzc;
    @Nullable
    private final Throwable zzd;

    zzl(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzc = str;
        this.zzd = th;
    }

    static zzl zza() {
        return zzb;
    }

    static zzl zza(Callable<String> callable) {
        return new zzn(callable);
    }

    static zzl zza(String str) {
        return new zzl(false, str, null);
    }

    static zzl zza(String str, Throwable th) {
        return new zzl(false, str, th);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzd != null) {
                Log.d("GoogleCertificatesRslt", zzb(), this.zzd);
            } else {
                Log.d("GoogleCertificatesRslt", zzb());
            }
        }
    }

    static String zza(String str, zzd zzd2, boolean z, boolean z2) {
        String str2 = z2 ? "debug cert rejected" : "not allowed";
        StringBuilder sb = new StringBuilder(14);
        sb.append("12451009.false");
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(((MessageDigest) Preconditions.checkNotNull(AndroidUtilsLight.zza("SHA-1"))).digest(zzd2.zza())), Boolean.valueOf(z), sb.toString());
    }
}
