package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzc implements Callable<Boolean> {
    private final /* synthetic */ SharedPreferences zzo;
    private final /* synthetic */ String zzp;
    private final /* synthetic */ Boolean zzq;

    zzc(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.zzo = sharedPreferences;
        this.zzp = str;
        this.zzq = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf(this.zzo.getBoolean(this.zzp, this.zzq.booleanValue()));
    }
}
