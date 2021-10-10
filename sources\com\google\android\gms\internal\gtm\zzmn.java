package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

public abstract class zzmn {
    private int zzasj;
    protected final zzmw zzask;
    private final zzms zzasl;
    private final Clock zzasm;
    protected final zzdz zzasn;

    public zzmn(int i, zzmw zzmw, zzms zzms, zzdz zzdz) {
        this(i, zzmw, zzms, zzdz, DefaultClock.getInstance());
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzmx zzmx);

    private zzmn(int i, zzmw zzmw, zzms zzms, zzdz zzdz, Clock clock) {
        this.zzask = (zzmw) Preconditions.checkNotNull(zzmw);
        Preconditions.checkNotNull(zzmw.zzlk());
        this.zzasj = i;
        this.zzasl = (zzms) Preconditions.checkNotNull(zzms);
        this.zzasm = (Clock) Preconditions.checkNotNull(clock);
        this.zzasn = zzdz;
    }

    public final void zzc(byte[] bArr) {
        zzmx zzmx;
        zzmx zzd = zzd(bArr);
        zzdz zzdz = this.zzasn;
        if (zzdz != null && this.zzasj == 0) {
            zzdz.zzho();
        }
        if (zzd == null || zzd.getStatus() != Status.RESULT_SUCCESS) {
            zzmx = new zzmx(Status.RESULT_INTERNAL_ERROR, this.zzasj);
        } else {
            zzmx = new zzmx(Status.RESULT_SUCCESS, this.zzasj, new zzmy(this.zzask.zzlk(), bArr, zzd.zzll().zzlq(), this.zzasm.currentTimeMillis()), zzd.zzlm());
        }
        zza(zzmx);
    }

    public final void zzb(int i, int i2) {
        zzdz zzdz = this.zzasn;
        if (zzdz != null && i2 == 0 && i == 3) {
            zzdz.zzhn();
        }
        String containerId = this.zzask.zzlk().getContainerId();
        String str = i != 0 ? i != 1 ? i != 2 ? "Unknown reason" : "Server error" : "IOError" : "Resource not available";
        StringBuilder sb = new StringBuilder(String.valueOf(containerId).length() + 61 + String.valueOf(str).length());
        sb.append("Failed to fetch the container resource for the container \"");
        sb.append(containerId);
        sb.append("\": ");
        sb.append(str);
        zzev.zzab(sb.toString());
        zza(new zzmx(Status.RESULT_INTERNAL_ERROR, i2));
    }

    private final zzmx zzd(byte[] bArr) {
        zzmx zzmx;
        try {
            zzmx = this.zzasl.zze(bArr);
            if (zzmx == null) {
                try {
                    zzev.zzaw("Parsed resource from is null");
                } catch (zzml unused) {
                }
            }
        } catch (zzml unused2) {
            zzmx = null;
            zzev.zzaw("Resource data is corrupted");
            return zzmx;
        }
        return zzmx;
    }
}
