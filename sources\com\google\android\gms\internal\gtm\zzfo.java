package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.IntentFilter;

final class zzfo extends zzfn {
    private static final Object zzakn = new Object();
    private static zzfo zzapl;
    private boolean connected = true;
    private Context zzako;
    private int zzakr = 1800000;
    private boolean zzaks = true;
    private boolean zzakt = false;
    private boolean zzaku = true;
    private boolean zzakx = false;
    private zzen zzaol = new zzfp(this);
    private zzem zzapg;
    private volatile zzej zzaph;
    private boolean zzapi = false;
    private zzfr zzapj;
    private zzex zzapk;

    public static zzfo zzkv() {
        if (zzapl == null) {
            zzapl = new zzfo();
        }
        return zzapl;
    }

    private zzfo() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(Context context, zzej zzej) {
        if (this.zzako == null) {
            this.zzako = context.getApplicationContext();
            if (this.zzaph == null) {
                this.zzaph = zzej;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized zzem zzkw() {
        if (this.zzapg == null) {
            if (this.zzako != null) {
                this.zzapg = new zzey(this.zzaol, this.zzako);
            } else {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
        }
        if (this.zzapj == null) {
            zzfs zzfs = new zzfs(this, null);
            this.zzapj = zzfs;
            int i = this.zzakr;
            if (i > 0) {
                zzfs.zzh((long) i);
            }
        }
        this.zzakt = true;
        if (this.zzaks) {
            dispatch();
            this.zzaks = false;
        }
        if (this.zzapk == null && this.zzaku) {
            zzex zzex = new zzex(this);
            this.zzapk = zzex;
            Context context = this.zzako;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(zzex, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter2.addCategory(context.getPackageName());
            context.registerReceiver(zzex, intentFilter2);
        }
        return this.zzapg;
    }

    public final synchronized void dispatch() {
        if (!this.zzakt) {
            zzev.zzab("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzaks = true;
            return;
        }
        if (!this.zzapi) {
            this.zzapi = true;
            this.zzaph.zzc(new zzfq(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(boolean z, boolean z2) {
        boolean isPowerSaveMode = isPowerSaveMode();
        this.zzakx = z;
        this.connected = z2;
        if (isPowerSaveMode() != isPowerSaveMode) {
            if (isPowerSaveMode()) {
                this.zzapj.cancel();
                zzev.zzab("PowerSaveMode initiated.");
                return;
            }
            this.zzapj.zzh((long) this.zzakr);
            zzev.zzab("PowerSaveMode terminated.");
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzfn
    public final synchronized void zzf(boolean z) {
        zza(this.zzakx, z);
    }

    @Override // com.google.android.gms.internal.gtm.zzfn
    public final synchronized void zzjp() {
        if (!isPowerSaveMode()) {
            this.zzapj.zzjt();
        }
    }

    /* access modifiers changed from: private */
    public final boolean isPowerSaveMode() {
        return this.zzakx || !this.connected || this.zzakr <= 0;
    }
}
