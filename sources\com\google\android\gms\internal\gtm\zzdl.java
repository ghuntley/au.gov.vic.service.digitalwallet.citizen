package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

public final class zzdl {
    private static Object zzadq = new Object();
    private static zzdl zzamp;
    private volatile boolean closed;
    private volatile long zzadj;
    private volatile long zzadk;
    private volatile long zzadl;
    private volatile long zzadm;
    private final Thread zzadn;
    private final Object zzado;
    private volatile boolean zzamn;
    private zzdo zzamo;
    private final Context zzrm;
    private final Clock zzsd;
    private volatile AdvertisingIdClient.Info zzvp;

    public static zzdl zzo(Context context) {
        if (zzamp == null) {
            synchronized (zzadq) {
                if (zzamp == null) {
                    zzdl zzdl = new zzdl(context);
                    zzamp = zzdl;
                    zzdl.zzadn.start();
                }
            }
        }
        return zzamp;
    }

    private zzdl(Context context) {
        this(context, null, DefaultClock.getInstance());
    }

    private zzdl(Context context, zzdo zzdo, Clock clock) {
        this.zzadj = 900000;
        this.zzadk = 30000;
        this.zzamn = true;
        this.closed = false;
        this.zzado = new Object();
        this.zzamo = new zzdm(this);
        this.zzsd = clock;
        if (context != null) {
            this.zzrm = context.getApplicationContext();
        } else {
            this.zzrm = context;
        }
        this.zzadl = clock.currentTimeMillis();
        this.zzadn = new Thread(new zzdn(this));
    }

    public final String zzgq() {
        if (this.zzvp == null) {
            zzgr();
        } else {
            zzgs();
        }
        zzgt();
        if (this.zzvp == null) {
            return null;
        }
        return this.zzvp.getId();
    }

    public final boolean isLimitAdTrackingEnabled() {
        if (this.zzvp == null) {
            zzgr();
        } else {
            zzgs();
        }
        zzgt();
        if (this.zzvp == null) {
            return true;
        }
        return this.zzvp.isLimitAdTrackingEnabled();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
    private final void zzgr() {
        synchronized (this) {
            zzgs();
            wait(500);
        }
    }

    private final void zzgs() {
        if (this.zzsd.currentTimeMillis() - this.zzadl > this.zzadk) {
            synchronized (this.zzado) {
                this.zzado.notify();
            }
            this.zzadl = this.zzsd.currentTimeMillis();
        }
    }

    private final void zzgt() {
        if (this.zzsd.currentTimeMillis() - this.zzadm > 3600000) {
            this.zzvp = null;
        }
    }

    /* access modifiers changed from: public */
    private final void zzgu() {
        Process.setThreadPriority(10);
        while (true) {
            AdvertisingIdClient.Info info = null;
            if (this.zzamn) {
                info = this.zzamo.zzgv();
            }
            if (info != null) {
                this.zzvp = info;
                this.zzadm = this.zzsd.currentTimeMillis();
                zzev.zzaw("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.zzado) {
                    this.zzado.wait(this.zzadj);
                }
            } catch (InterruptedException unused) {
                zzev.zzaw("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }
}
