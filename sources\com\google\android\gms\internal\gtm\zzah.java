package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzah implements Runnable {
    private final /* synthetic */ zzae zzvw;
    private final /* synthetic */ String zzvy;
    private final /* synthetic */ Runnable zzvz;

    zzah(zzae zzae, String str, Runnable runnable) {
        this.zzvw = zzae;
        this.zzvy = str;
        this.zzvz = runnable;
    }

    public final void run() {
        this.zzvw.zzvu.zzy(this.zzvy);
        Runnable runnable = this.zzvz;
        if (runnable != null) {
            runnable.run();
        }
    }
}
