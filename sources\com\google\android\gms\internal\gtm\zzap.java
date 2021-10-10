package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import org.objectweb.asm.Opcodes;

public class zzap {
    private static volatile zzap zzwf;
    private final Context zzrm;
    private final Clock zzsd = DefaultClock.getInstance();
    private final Context zzwg;
    private final zzbq zzwh = new zzbq(this);
    private final zzci zzwi;
    private final zzk zzwj;
    private final zzae zzwk;
    private final zzbv zzwl;
    private final zzda zzwm;
    private final zzcm zzwn;
    private final GoogleAnalytics zzwo;
    private final zzbh zzwp;
    private final zzad zzwq;
    private final zzba zzwr;
    private final zzbu zzws;

    private zzap(zzar zzar) {
        Context applicationContext = zzar.getApplicationContext();
        Preconditions.checkNotNull(applicationContext, "Application context can't be null");
        Context zzdc = zzar.zzdc();
        Preconditions.checkNotNull(zzdc);
        this.zzrm = applicationContext;
        this.zzwg = zzdc;
        zzci zzci = new zzci(this);
        zzci.zzag();
        this.zzwi = zzci;
        zzci zzco = zzco();
        String str = zzao.VERSION;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + Opcodes.I2F);
        sb.append("Google Analytics ");
        sb.append(str);
        sb.append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        zzco.zzs(sb.toString());
        zzcm zzcm = new zzcm(this);
        zzcm.zzag();
        this.zzwn = zzcm;
        zzda zzda = new zzda(this);
        zzda.zzag();
        this.zzwm = zzda;
        zzae zzae = new zzae(this, zzar);
        zzbh zzbh = new zzbh(this);
        zzad zzad = new zzad(this);
        zzba zzba = new zzba(this);
        zzbu zzbu = new zzbu(this);
        zzk zzb = zzk.zzb(applicationContext);
        zzb.zza(new zzaq(this));
        this.zzwj = zzb;
        GoogleAnalytics googleAnalytics = new GoogleAnalytics(this);
        zzbh.zzag();
        this.zzwp = zzbh;
        zzad.zzag();
        this.zzwq = zzad;
        zzba.zzag();
        this.zzwr = zzba;
        zzbu.zzag();
        this.zzws = zzbu;
        zzbv zzbv = new zzbv(this);
        zzbv.zzag();
        this.zzwl = zzbv;
        zzae.zzag();
        this.zzwk = zzae;
        googleAnalytics.zzag();
        this.zzwo = googleAnalytics;
        zzae.start();
    }

    public static zzap zzc(Context context) {
        Preconditions.checkNotNull(context);
        if (zzwf == null) {
            synchronized (zzap.class) {
                if (zzwf == null) {
                    Clock instance = DefaultClock.getInstance();
                    long elapsedRealtime = instance.elapsedRealtime();
                    zzap zzap = new zzap(new zzar(context));
                    zzwf = zzap;
                    GoogleAnalytics.zzah();
                    long elapsedRealtime2 = instance.elapsedRealtime() - elapsedRealtime;
                    long longValue = zzby.zzaap.get().longValue();
                    if (elapsedRealtime2 > longValue) {
                        zzap.zzco().zzc("Slow initialization (ms)", Long.valueOf(elapsedRealtime2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return zzwf;
    }

    public final Context getContext() {
        return this.zzrm;
    }

    public final Context zzdc() {
        return this.zzwg;
    }

    public final Clock zzcn() {
        return this.zzsd;
    }

    public final zzbq zzcp() {
        return this.zzwh;
    }

    public final zzci zzco() {
        zza(this.zzwi);
        return this.zzwi;
    }

    public final zzci zzdd() {
        return this.zzwi;
    }

    public final zzk zzcq() {
        Preconditions.checkNotNull(this.zzwj);
        return this.zzwj;
    }

    public final zzae zzcs() {
        zza(this.zzwk);
        return this.zzwk;
    }

    public final zzbv zzct() {
        zza(this.zzwl);
        return this.zzwl;
    }

    public final GoogleAnalytics zzde() {
        Preconditions.checkNotNull(this.zzwo);
        Preconditions.checkArgument(this.zzwo.isInitialized(), "Analytics instance not initialized");
        return this.zzwo;
    }

    public final zzda zzcu() {
        zza(this.zzwm);
        return this.zzwm;
    }

    public final zzcm zzcv() {
        zza(this.zzwn);
        return this.zzwn;
    }

    public final zzcm zzdf() {
        zzcm zzcm = this.zzwn;
        if (zzcm == null || !zzcm.isInitialized()) {
            return null;
        }
        return this.zzwn;
    }

    public final zzad zzdg() {
        zza(this.zzwq);
        return this.zzwq;
    }

    public final zzbh zzdh() {
        zza(this.zzwp);
        return this.zzwp;
    }

    public final zzba zzcy() {
        zza(this.zzwr);
        return this.zzwr;
    }

    public final zzbu zzcz() {
        return this.zzws;
    }

    private static void zza(zzan zzan) {
        Preconditions.checkNotNull(zzan, "Analytics service not created/initialized");
        Preconditions.checkArgument(zzan.isInitialized(), "Analytics service not initialized");
    }
}
