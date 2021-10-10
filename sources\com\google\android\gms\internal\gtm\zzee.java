package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Date;
import java.util.Map;

public final class zzee implements Clock {
    private final zzcm zzamx;
    private final Bundle zzann;
    private final String zzano;
    private final Date zzanp;
    private final String zzanq;
    private Map<String, Object> zzanr;
    private boolean zzans;

    public zzee(String str, Bundle bundle, String str2, Date date, boolean z, zzcm zzcm) {
        this.zzano = str;
        this.zzann = bundle == null ? new Bundle() : bundle;
        this.zzanp = date;
        this.zzanq = str2;
        this.zzans = z;
        this.zzamx = zzcm;
    }

    public final String zzkf() {
        return this.zzano;
    }

    public final Bundle zzkg() {
        return this.zzann;
    }

    public final String zzkh() {
        return this.zzanq;
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long currentTimeMillis() {
        return this.zzanp.getTime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long nanoTime() {
        return System.nanoTime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public final long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public final Map<String, Object> zzib() {
        if (this.zzanr == null) {
            try {
                this.zzanr = this.zzamx.zzib();
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e.getMessage());
                zzev.zzav(valueOf.length() != 0 ? "Error calling measurement proxy:".concat(valueOf) : new String("Error calling measurement proxy:"));
            }
        }
        return this.zzanr;
    }

    public final boolean zzki() {
        return this.zzans;
    }

    public final void zzg(boolean z) {
        this.zzans = false;
    }
}
