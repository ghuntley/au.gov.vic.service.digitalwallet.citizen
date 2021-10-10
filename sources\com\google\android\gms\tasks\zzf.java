package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
final class zzf implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzd zzb;

    zzf(zzd zzd, Task task) {
        this.zzb = zzd;
        this.zza = task;
    }

    public final void run() {
        try {
            Task task = (Task) zzd.zza(this.zzb).then(this.zza);
            if (task == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.addOnSuccessListener(TaskExecutors.zza, this.zzb);
            task.addOnFailureListener(TaskExecutors.zza, this.zzb);
            task.addOnCanceledListener(TaskExecutors.zza, this.zzb);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                zzd.zzb(this.zzb).zza((Exception) e.getCause());
            } else {
                zzd.zzb(this.zzb).zza((Exception) e);
            }
        } catch (Exception e2) {
            zzd.zzb(this.zzb).zza(e2);
        }
    }
}
