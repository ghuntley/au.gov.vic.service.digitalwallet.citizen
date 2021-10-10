package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzq<TResult> {
    private final Object zza = new Object();
    private Queue<zzr<TResult>> zzb;
    private boolean zzc;

    zzq() {
    }

    public final void zza(zzr<TResult> zzr) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new ArrayDeque();
            }
            this.zzb.add(zzr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r1 = r2.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = r2.zzb.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r2.zzc = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r0.zza(r3);
     */
    public final void zza(Task<TResult> task) {
        synchronized (this.zza) {
            if (this.zzb != null) {
                if (!this.zzc) {
                    this.zzc = true;
                }
            }
        }
    }
}
