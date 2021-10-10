package com.google.android.gms.analytics;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

public class zzj<T extends zzj> {
    private final zzk zzsn;
    protected final zzg zzso;
    private final List<zzh> zzsp = new ArrayList();

    protected zzj(zzk zzk, Clock clock) {
        Preconditions.checkNotNull(zzk);
        this.zzsn = zzk;
        zzg zzg = new zzg(this, clock);
        zzg.zzar();
        this.zzso = zzg;
    }

    /* access modifiers changed from: protected */
    public void zza(zzg zzg) {
    }

    public zzg zzac() {
        zzg zzai = this.zzso.zzai();
        zzd(zzai);
        return zzai;
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzg zzg) {
        for (zzh zzh : this.zzsp) {
            zzh.zza(this, zzg);
        }
    }

    /* access modifiers changed from: protected */
    public final zzk zzas() {
        return this.zzsn;
    }
}
