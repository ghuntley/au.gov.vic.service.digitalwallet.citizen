package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzbj {
    public static Looper zza(Looper looper) {
        return looper != null ? looper : zza();
    }

    public static Looper zza() {
        Preconditions.checkState(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
