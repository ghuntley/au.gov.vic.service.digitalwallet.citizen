package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.common.internal.Preconditions;

public final class zzlb implements zzgz {
    private final Context zzrm;

    public zzlb(Context context) {
        this.zzrm = context;
    }

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        String string = Settings.Secure.getString(this.zzrm.getContentResolver(), "android_id");
        if (string == null) {
            string = "";
        }
        return new zzom(string);
    }
}
