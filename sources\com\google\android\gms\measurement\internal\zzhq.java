package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhq implements zzky {
    private final /* synthetic */ zzhb zza;

    zzhq(zzhb zzhb) {
        this.zza = zzhb;
    }

    @Override // com.google.android.gms.measurement.internal.zzky
    public final void zza(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle, str);
        } else {
            this.zza.zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle);
        }
    }
}
