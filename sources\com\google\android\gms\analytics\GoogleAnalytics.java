package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzby;
import com.google.android.gms.internal.gtm.zzch;
import com.google.android.gms.internal.gtm.zzcw;
import com.google.android.gms.internal.gtm.zzcy;
import com.google.android.gms.internal.gtm.zzda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics extends zza {
    private static List<Runnable> zzrp = new ArrayList();
    private boolean zzrq;
    private Set<zza> zzrr = new HashSet();
    private boolean zzrs;
    private boolean zzrt;
    private volatile boolean zzru;
    private boolean zzrv;

    /* access modifiers changed from: package-private */
    public interface zza {
        void zzc(Activity activity);

        void zzd(Activity activity);
    }

    /* access modifiers changed from: package-private */
    public class zzb implements Application.ActivityLifecycleCallbacks {
        zzb() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.zza(activity);
        }

        public final void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.zzb(activity);
        }
    }

    public final void zzag() {
        zzda zzcu = zzab().zzcu();
        zzcu.zzgh();
        if (zzcu.zzgi()) {
            setDryRun(zzcu.zzgj());
        }
        zzcu.zzgh();
        this.zzrq = true;
    }

    public final boolean isInitialized() {
        return this.zzrq;
    }

    public GoogleAnalytics(zzap zzap) {
        super(zzap);
    }

    public static GoogleAnalytics getInstance(Context context) {
        return zzap.zzc(context).zzde();
    }

    public static void zzah() {
        synchronized (GoogleAnalytics.class) {
            List<Runnable> list = zzrp;
            if (list != null) {
                for (Runnable runnable : list) {
                    runnable.run();
                }
                zzrp = null;
            }
        }
    }

    public final void setDryRun(boolean z) {
        this.zzrt = z;
    }

    public final boolean isDryRunEnabled() {
        return this.zzrt;
    }

    public final void enableAutoActivityReports(Application application) {
        if (!this.zzrs) {
            application.registerActivityLifecycleCallbacks(new zzb());
            this.zzrs = true;
        }
    }

    public final void reportActivityStart(Activity activity) {
        if (!this.zzrs) {
            zza(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Activity activity) {
        for (zza zza2 : this.zzrr) {
            zza2.zzc(activity);
        }
    }

    public final void reportActivityStop(Activity activity) {
        if (!this.zzrs) {
            zzb(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Activity activity) {
        for (zza zza2 : this.zzrr) {
            zza2.zzd(activity);
        }
    }

    public final Tracker newTracker(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzab(), str, null);
            tracker.zzag();
        }
        return tracker;
    }

    public final Tracker newTracker(int i) {
        Tracker tracker;
        zzcy zzcy;
        synchronized (this) {
            tracker = new Tracker(zzab(), null, null);
            if (i > 0 && (zzcy = (zzcy) new zzcw(zzab()).zzq(i)) != null) {
                tracker.zza(zzcy);
            }
            tracker.zzag();
        }
        return tracker;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zza zza2) {
        this.zzrr.add(zza2);
        Context context = zzab().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zza zza2) {
        this.zzrr.remove(zza2);
    }

    public final void setAppOptOut(boolean z) {
        this.zzru = z;
        if (this.zzru) {
            zzab().zzcs().zzch();
        }
    }

    public final boolean getAppOptOut() {
        return this.zzru;
    }

    @Deprecated
    public final Logger getLogger() {
        return zzch.getLogger();
    }

    @Deprecated
    public final void setLogger(Logger logger) {
        zzch.setLogger(logger);
        if (!this.zzrv) {
            String str = zzby.zzzb.get();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 112);
            sb.append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
            sb.append(str);
            sb.append(" DEBUG");
            Log.i(zzby.zzzb.get(), sb.toString());
            this.zzrv = true;
        }
    }

    public final void setLocalDispatchPeriod(int i) {
        zzab().zzcs().setLocalDispatchPeriod(i);
    }

    public final void dispatchLocalHits() {
        zzab().zzcs().zzci();
    }
}
