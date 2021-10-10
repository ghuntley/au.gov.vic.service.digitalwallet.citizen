package com.google.android.gms.internal.gtm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbv extends zzan {
    private boolean zzyv;
    private boolean zzyw;
    private final AlarmManager zzyx = ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM));
    private Integer zzyy;

    protected zzbv(zzap zzap) {
        super(zzap);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
        try {
            cancel();
            if (zzbq.zzeq() > 0) {
                Context context = getContext();
                ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo != null && receiverInfo.enabled) {
                    zzq("Receiver registered for local dispatch.");
                    this.zzyv = true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final boolean zzfc() {
        return this.zzyv;
    }

    public final boolean zzez() {
        return this.zzyw;
    }

    public final void zzfd() {
        zzdb();
        Preconditions.checkState(this.zzyv, "Receiver not registered");
        long zzeq = zzbq.zzeq();
        if (zzeq > 0) {
            cancel();
            long elapsedRealtime = zzcn().elapsedRealtime() + zzeq;
            this.zzyw = true;
            zzby.zzaaq.get().booleanValue();
            if (Build.VERSION.SDK_INT >= 24) {
                zzq("Scheduling upload with JobScheduler");
                Context context = getContext();
                ComponentName componentName = new ComponentName(context, "com.google.android.gms.analytics.AnalyticsJobService");
                int jobId = getJobId();
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                JobInfo build = new JobInfo.Builder(jobId, componentName).setMinimumLatency(zzeq).setOverrideDeadline(zzeq << 1).setExtras(persistableBundle).build();
                zza("Scheduling job. JobID", Integer.valueOf(jobId));
                zzdb.zza(context, build, "com.google.android.gms", "DispatchAlarm");
                return;
            }
            zzq("Scheduling upload with AlarmManager");
            this.zzyx.setInexactRepeating(2, elapsedRealtime, zzeq, zzfe());
        }
    }

    private final PendingIntent zzfe() {
        Context context = getContext();
        return PendingIntent.getBroadcast(context, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }

    public final void cancel() {
        this.zzyw = false;
        this.zzyx.cancel(zzfe());
        if (Build.VERSION.SDK_INT >= 24) {
            int jobId = getJobId();
            zza("Cancelling job. JobID", Integer.valueOf(jobId));
            ((JobScheduler) getContext().getSystemService("jobscheduler")).cancel(jobId);
        }
    }

    private final int getJobId() {
        if (this.zzyy == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzyy = Integer.valueOf((valueOf.length() != 0 ? "analytics".concat(valueOf) : new String("analytics")).hashCode());
        }
        return this.zzyy.intValue();
    }
}
