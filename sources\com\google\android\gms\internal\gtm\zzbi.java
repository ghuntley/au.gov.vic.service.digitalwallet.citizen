package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzbi implements Callable<String> {
    private final /* synthetic */ zzbh zzyi;

    zzbi(zzbh zzbh) {
        this.zzyi = zzbh;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.zzyi.zzej();
    }
}
