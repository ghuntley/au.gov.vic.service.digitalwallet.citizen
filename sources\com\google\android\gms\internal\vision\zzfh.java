package com.google.android.gms.internal.vision;

import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzfh extends zzfd {
    private final zzfg zza = new zzfg();

    zzfh() {
    }

    @Override // com.google.android.gms.internal.vision.zzfd
    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.zza.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }

    @Override // com.google.android.gms.internal.vision.zzfd
    public final void zza(Throwable th) {
        th.printStackTrace();
        List<Throwable> zza2 = this.zza.zza(th, false);
        if (zza2 != null) {
            synchronized (zza2) {
                for (Throwable th2 : zza2) {
                    System.err.print("Suppressed: ");
                    th2.printStackTrace();
                }
            }
        }
    }
}
