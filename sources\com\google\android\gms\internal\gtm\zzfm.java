package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

final class zzfm implements zzfe {
    private final long zzabf;
    private final int zzabg;
    private double zzabh;
    private final Object zzabj;
    private long zzakm;
    private Clock zzsd;

    private zzfm(int i, long j) {
        this.zzabj = new Object();
        this.zzabg = 60;
        this.zzabh = (double) 60;
        this.zzabf = 2000;
        this.zzsd = DefaultClock.getInstance();
    }

    public zzfm() {
        this(60, 2000);
    }

    @Override // com.google.android.gms.internal.gtm.zzfe
    public final boolean zzfm() {
        synchronized (this.zzabj) {
            long currentTimeMillis = this.zzsd.currentTimeMillis();
            double d = this.zzabh;
            int i = this.zzabg;
            if (d < ((double) i)) {
                double d2 = ((double) (currentTimeMillis - this.zzakm)) / ((double) this.zzabf);
                if (d2 > 0.0d) {
                    this.zzabh = Math.min((double) i, d + d2);
                }
            }
            this.zzakm = currentTimeMillis;
            double d3 = this.zzabh;
            if (d3 >= 1.0d) {
                this.zzabh = d3 - 1.0d;
                return true;
            }
            zzev.zzac("No more tokens available.");
            return false;
        }
    }
}
