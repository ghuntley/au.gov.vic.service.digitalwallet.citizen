package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzad;
import com.google.android.gms.internal.gtm.zzao;
import com.google.android.gms.internal.gtm.zzas;
import com.google.android.gms.internal.gtm.zzcd;
import com.google.android.gms.internal.gtm.zzcz;
import com.google.android.gms.internal.gtm.zzq;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzp implements Runnable {
    private final /* synthetic */ Map zzti;
    private final /* synthetic */ boolean zztj;
    private final /* synthetic */ String zztk;
    private final /* synthetic */ long zztl;
    private final /* synthetic */ boolean zztm;
    private final /* synthetic */ boolean zztn;
    private final /* synthetic */ String zzto;
    private final /* synthetic */ Tracker zztp;

    zzp(Tracker tracker, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.zztp = tracker;
        this.zzti = map;
        this.zztj = z;
        this.zztk = str;
        this.zztl = j;
        this.zztm = z2;
        this.zztn = z3;
        this.zzto = str2;
    }

    public final void run() {
        if (this.zztp.zztf.zzax()) {
            this.zzti.put("sc", "start");
        }
        Map map = this.zzti;
        GoogleAnalytics zzcr = this.zztp.zzcr();
        Preconditions.checkNotMainThread("getClientId can not be called from the main thread");
        zzcz.zzc(map, "cid", zzcr.zzab().zzdh().zzeh());
        String str = (String) this.zzti.get("sf");
        if (str != null) {
            double zza = zzcz.zza(str, 100.0d);
            if (zzcz.zza(zza, (String) this.zzti.get("cid"))) {
                this.zztp.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                return;
            }
        }
        zzad zzad = this.zztp.zzcx();
        if (this.zztj) {
            zzcz.zzb(this.zzti, "ate", zzad.zzbw());
            zzcz.zzb(this.zzti, "adid", zzad.zzcd());
        } else {
            this.zzti.remove("ate");
            this.zzti.remove("adid");
        }
        zzq zzdv = this.zztp.zzcy().zzdv();
        zzcz.zzb(this.zzti, "an", zzdv.zzaz());
        zzcz.zzb(this.zzti, "av", zzdv.zzba());
        zzcz.zzb(this.zzti, "aid", zzdv.zzbb());
        zzcz.zzb(this.zzti, "aiid", zzdv.zzbc());
        this.zzti.put("v", "1");
        this.zzti.put("_v", zzao.zzwe);
        zzcz.zzb(this.zzti, "ul", this.zztp.zzcz().zzfa().getLanguage());
        zzcz.zzb(this.zzti, "sr", this.zztp.zzcz().zzfb());
        if ((this.zztk.equals("transaction") || this.zztk.equals("item")) || this.zztp.zzte.zzfm()) {
            long zzag = zzcz.zzag((String) this.zzti.get("ht"));
            if (zzag == 0) {
                zzag = this.zztl;
            }
            if (this.zztm) {
                this.zztp.zzco().zzc("Dry run enabled. Would have sent hit", new zzcd(this.zztp, this.zzti, zzag, this.zztn));
                return;
            }
            String str2 = (String) this.zzti.get("cid");
            HashMap hashMap = new HashMap();
            zzcz.zza(hashMap, "uid", this.zzti);
            zzcz.zza(hashMap, "an", this.zzti);
            zzcz.zza(hashMap, "aid", this.zzti);
            zzcz.zza(hashMap, "av", this.zzti);
            zzcz.zza(hashMap, "aiid", this.zzti);
            this.zzti.put("_s", String.valueOf(this.zztp.zzcs().zza(new zzas(0, str2, this.zzto, !TextUtils.isEmpty((CharSequence) this.zzti.get("adid")), 0, hashMap))));
            this.zztp.zzcs().zza(new zzcd(this.zztp, this.zzti, zzag, this.zztn));
            return;
        }
        this.zztp.zzco().zza(this.zzti, "Too many hits sent too quickly, rate limiting invoked");
    }
}
