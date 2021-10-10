package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class zzp extends WeakReference<Throwable> {
    private final int zza;

    public zzp(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zza = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzp zzp = (zzp) obj;
            return this.zza == zzp.zza && get() == zzp.get();
        }
    }
}
