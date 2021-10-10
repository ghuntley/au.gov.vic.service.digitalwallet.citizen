package com.google.android.gms.internal.vision;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzbd implements zzay {
    private static zzbd zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    static zzbd zza(Context context) {
        zzbd zzbd;
        synchronized (zzbd.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzbd(context) : new zzbd();
            }
            zzbd = zza;
        }
        return zzbd;
    }

    private zzbd(Context context) {
        this.zzb = context;
        zzbf zzbf = new zzbf(this, null);
        this.zzc = zzbf;
        context.getContentResolver().registerContentObserver(zzaq.zza, true, zzbf);
    }

    private zzbd() {
        this.zzb = null;
        this.zzc = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzbb.zza(new zzbc(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    static synchronized void zza() {
        Context context;
        synchronized (zzbd.class) {
            zzbd zzbd = zza;
            if (!(zzbd == null || (context = zzbd.zzb) == null || zzbd.zzc == null)) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzb(String str) {
        return zzaq.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
