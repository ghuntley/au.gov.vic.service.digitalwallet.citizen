package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
final class zzn implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzm zzb;

    zzn(zzm zzm, Task task) {
        this.zzb = zzm;
        this.zza = task;
    }

    public final void run() {
        synchronized (zzm.zza(this.zzb)) {
            if (zzm.zzb(this.zzb) != null) {
                zzm.zzb(this.zzb).onSuccess(this.zza.getResult());
            }
        }
    }
}
