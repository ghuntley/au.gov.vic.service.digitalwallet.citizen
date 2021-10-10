package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzgp;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class zzgl extends zzes {
    private final ExecutorService zzamv;
    private final zzcm zzamx;
    private final Map<String, zzdq> zzaqs;
    private final zzdy zzaqt;
    private final Context zzrm;

    public zzgl(Context context, zzcm zzcm, zzcd zzcd) {
        this(context, zzcm, new zzdy(context, zzcm, zzcd), zzgp.zza.zzr(context));
    }

    private zzgl(Context context, zzcm zzcm, zzdy zzdy, ExecutorService executorService) {
        this.zzaqs = new HashMap(1);
        Preconditions.checkNotNull(zzcm);
        this.zzamx = zzcm;
        this.zzaqt = zzdy;
        this.zzamv = executorService;
        this.zzrm = context;
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void zzc(String str, String str2, String str3) {
        zza(str, str2, str3, null);
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void zza(String str, String str2, String str3, zzeo zzeo) {
        this.zzamv.execute(new zzgm(this, str, str2, str3, zzeo));
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void zzkm() {
        this.zzaqs.clear();
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void zza(String str, Bundle bundle, String str2, long j, boolean z) {
        this.zzamv.execute(new zzgn(this, new zzee(str, bundle, str2, new Date(j), z, this.zzamx)));
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void dispatch() {
        this.zzamv.execute(new zzgo(this));
    }
}
