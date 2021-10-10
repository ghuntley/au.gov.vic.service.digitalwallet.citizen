package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
final class zzj implements Runnable {
    private final /* synthetic */ Task zza;
    private final /* synthetic */ zzi zzb;

    zzj(zzi zzi, Task task) {
        this.zzb = zzi;
        this.zza = task;
    }

    public final void run() {
        synchronized (zzi.zza(this.zzb)) {
            if (zzi.zzb(this.zzb) != null) {
                zzi.zzb(this.zzb).onComplete(this.zza);
            }
        }
    }
}
