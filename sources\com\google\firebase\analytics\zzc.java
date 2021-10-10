package com.google.firebase.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final /* synthetic */ class zzc {
    static final /* synthetic */ int[] zza;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    static {
        int[] iArr = new int[FirebaseAnalytics.ConsentStatus.values().length];
        zza = iArr;
        iArr[FirebaseAnalytics.ConsentStatus.GRANTED.ordinal()] = 1;
        zza[FirebaseAnalytics.ConsentStatus.DENIED.ordinal()] = 2;
    }
}
