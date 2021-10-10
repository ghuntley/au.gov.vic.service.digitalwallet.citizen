package com.google.android.gms.common.api.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class zaan implements Runnable {
    private final /* synthetic */ zaad zaa;

    private zaan(zaad zaad) {
        this.zaa = zaad;
    }

    /* access modifiers changed from: protected */
    public abstract void zaa();

    public void run() {
        this.zaa.zab.lock();
        try {
            if (!Thread.interrupted()) {
                zaa();
                this.zaa.zab.unlock();
            }
        } catch (RuntimeException e) {
            this.zaa.zaa.zaa(e);
        } finally {
            this.zaa.zab.unlock();
        }
    }

    /* synthetic */ zaan(zaad zaad, zaag zaag) {
        this(zaad);
    }
}
