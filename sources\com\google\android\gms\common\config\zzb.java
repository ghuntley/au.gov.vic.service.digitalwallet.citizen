package com.google.android.gms.common.config;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.common.internal.Preconditions;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzb extends GservicesValue<Boolean> {
    zzb(String str, Boolean bool) {
        super(str, bool);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.config.GservicesValue
    public final /* synthetic */ Boolean zza(String str) {
        return ((GservicesValue.zza) Preconditions.checkNotNull(null)).zza(this.zza, (Boolean) this.zzb);
    }
}
