package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.Logger;

final class zzgv implements Logger {
    zzgv() {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(String str) {
        zzev.zzav(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(Exception exc) {
        zzev.zza("", exc);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void info(String str) {
        zzev.zzaw(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void verbose(String str) {
        zzev.zzab(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void warn(String str) {
        zzev.zzac(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void setLogLevel(int i) {
        zzev.zzac("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    @Override // com.google.android.gms.analytics.Logger
    public final int getLogLevel() {
        zzev.getLogLevel();
        return 3;
    }
}
