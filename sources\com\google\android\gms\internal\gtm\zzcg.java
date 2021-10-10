package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.Clock;

public final class zzcg {
    private final long zzabf;
    private final int zzabg;
    private double zzabh;
    private long zzabi;
    private final Object zzabj;
    private final Clock zzsd;
    private final String zzup;

    private zzcg(int i, long j, String str, Clock clock) {
        this.zzabj = new Object();
        this.zzabg = 60;
        this.zzabh = (double) 60;
        this.zzabf = 2000;
        this.zzup = str;
        this.zzsd = clock;
    }

    public zzcg(String str, Clock clock) {
        this(60, 2000, str, clock);
    }

    public final boolean zzfm() {
        synchronized (this.zzabj) {
            long currentTimeMillis = this.zzsd.currentTimeMillis();
            double d = this.zzabh;
            int i = this.zzabg;
            if (d < ((double) i)) {
                double d2 = ((double) (currentTimeMillis - this.zzabi)) / ((double) this.zzabf);
                if (d2 > 0.0d) {
                    this.zzabh = Math.min((double) i, d + d2);
                }
            }
            this.zzabi = currentTimeMillis;
            double d3 = this.zzabh;
            if (d3 >= 1.0d) {
                this.zzabh = d3 - 1.0d;
                return true;
            }
            String str = this.zzup;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
            sb.append("Excessive ");
            sb.append(str);
            sb.append(" detected; call ignored.");
            zzch.zzac(sb.toString());
            return false;
        }
    }
}
