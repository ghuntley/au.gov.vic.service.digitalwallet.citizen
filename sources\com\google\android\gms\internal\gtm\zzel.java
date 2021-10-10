package com.google.android.gms.internal.gtm;

import java.util.Map;

final class zzel implements Runnable {
    private final /* synthetic */ long zzahg;
    private final /* synthetic */ String zzahh;
    private final /* synthetic */ zzej zzany;
    private final /* synthetic */ String zzanz;
    private final /* synthetic */ String zzaoa;
    private final /* synthetic */ Map zzaob;
    private final /* synthetic */ String zzaoc;
    private final /* synthetic */ zzek zzaod;

    zzel(zzek zzek, zzej zzej, long j, String str, String str2, String str3, Map map, String str4) {
        this.zzaod = zzek;
        this.zzany = zzej;
        this.zzahg = j;
        this.zzahh = str;
        this.zzanz = str2;
        this.zzaoa = str3;
        this.zzaob = map;
        this.zzaoc = str4;
    }

    public final void run() {
        if (this.zzaod.zzanx == null) {
            zzfo zzkv = zzfo.zzkv();
            zzkv.zza(this.zzaod.zzrm, this.zzany);
            this.zzaod.zzanx = zzkv.zzkw();
        }
        this.zzaod.zzanx.zza(this.zzahg, this.zzahh, this.zzanz, this.zzaoa, this.zzaob, this.zzaoc);
    }
}
