package com.google.android.gms.internal.gtm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class zzph {
    private final ConcurrentHashMap<zzpi, List<Throwable>> zzavl = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzavm = new ReferenceQueue<>();

    zzph() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzavm.poll();
        while (poll != null) {
            this.zzavl.remove(poll);
            poll = this.zzavm.poll();
        }
        return this.zzavl.get(new zzpi(th, null));
    }
}
