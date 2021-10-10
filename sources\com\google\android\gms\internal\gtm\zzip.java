package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzip extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) ((zzom) zzoaArr[0]).value();
        if (zzfl.has(str)) {
            zzfl.zzb(str, zzoaArr[1]);
            return zzoaArr[1];
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Attempting to assign to undefined variable ".concat(valueOf) : new String("Attempting to assign to undefined variable "));
    }
}
