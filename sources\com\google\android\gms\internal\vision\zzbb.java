package com.google.android.gms.internal.vision;

import android.os.Binder;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final /* synthetic */ class zzbb {
    public static <V> V zza(zzba<V> zzba) {
        long clearCallingIdentity;
        try {
            return zzba.zza();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zza = zzba.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zza;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
