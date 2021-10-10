package com.google.android.gms.common.api.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class zaba {
    private final zaay zaa;

    protected zaba(zaay zaay) {
        this.zaa = zaay;
    }

    /* access modifiers changed from: protected */
    public abstract void zaa();

    public final void zaa(zaax zaax) {
        zaax.zaf.lock();
        try {
            if (zaax.zan == this.zaa) {
                zaa();
                zaax.zaf.unlock();
            }
        } finally {
            zaax.zaf.unlock();
        }
    }
}
