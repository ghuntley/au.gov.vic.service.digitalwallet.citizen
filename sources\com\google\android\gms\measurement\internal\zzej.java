package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzej<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzeh<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzej(String str, V v, V v2, zzeh<V> zzeh) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzeh;
    }

    public final String zza() {
        return this.zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4 = com.google.android.gms.measurement.internal.zzas.zzco.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002f, code lost:
        if (r4.hasNext() == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0031, code lost:
        r0 = (com.google.android.gms.measurement.internal.zzej) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        if (com.google.android.gms.measurement.internal.zzw.zza() != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003d, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r2 = r0.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0040, code lost:
        if (r2 == null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0042, code lost:
        r1 = r2.zza();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0057, code lost:
        throw new java.lang.IllegalStateException("Refreshing flag cache must be done on a worker thread.");
     */
    public final V zza(V v) {
        zzej zzej;
        V v2;
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzeg.zza == null) {
            return this.zzc;
        }
        synchronized (zzf) {
            if (zzw.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
        }
        synchronized (zzf) {
            zzej.zzh = v2;
        }
        zzeh<V> zzeh = this.zzb;
        if (zzeh == null) {
            return this.zzc;
        }
        try {
            return zzeh.zza();
        } catch (SecurityException unused) {
            return this.zzc;
        } catch (IllegalStateException unused2) {
            return this.zzc;
        }
    }
}
