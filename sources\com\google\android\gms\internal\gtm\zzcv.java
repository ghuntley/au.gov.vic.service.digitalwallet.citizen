package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* access modifiers changed from: package-private */
public final class zzcv {
    private long startTime;
    private final Clock zzsd;

    public zzcv(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zzsd = clock;
    }

    public zzcv(Clock clock, long j) {
        Preconditions.checkNotNull(clock);
        this.zzsd = clock;
        this.startTime = j;
    }

    public final void start() {
        this.startTime = this.zzsd.elapsedRealtime();
    }

    public final void clear() {
        this.startTime = 0;
    }

    public final boolean zzj(long j) {
        if (this.startTime != 0 && this.zzsd.elapsedRealtime() - this.startTime <= j) {
            return false;
        }
        return true;
    }
}
