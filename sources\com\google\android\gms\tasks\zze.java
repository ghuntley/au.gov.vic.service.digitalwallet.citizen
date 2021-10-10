package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
final class zze implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzc zzb;

    zze(zzc zzc, Task task) {
        this.zzb = zzc;
        this.zza = task;
    }

    public final void run() {
        if (this.zza.isCanceled()) {
            zzc.zza(this.zzb).zza();
            return;
        }
        try {
            zzc.zza(this.zzb).zza(zzc.zzb(this.zzb).then(this.zza));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                zzc.zza(this.zzb).zza((Exception) e.getCause());
            } else {
                zzc.zza(this.zzb).zza((Exception) e);
            }
        } catch (Exception e2) {
            zzc.zza(this.zzb).zza(e2);
        }
    }
}
