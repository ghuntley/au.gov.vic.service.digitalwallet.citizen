package com.google.android.gms.vision.clearcut;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzb {
    private final long zza = Math.round(30000.0d);
    private final Object zzb = new Object();
    private long zzc = Long.MIN_VALUE;

    public zzb(double d) {
    }

    public final boolean zza() {
        synchronized (this.zzb) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzc + this.zza > currentTimeMillis) {
                return false;
            }
            this.zzc = currentTimeMillis;
            return true;
        }
    }
}
