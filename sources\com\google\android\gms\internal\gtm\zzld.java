package com.google.android.gms.internal.gtm;

import android.os.Build;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Preconditions;

public final class zzld implements zzgz {
    private final String zzarr = Build.MANUFACTURER;
    private final String zzars = Build.MODEL;

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = false;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length == 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        String str = this.zzarr;
        String str2 = this.zzars;
        if (!str2.startsWith(str) && !str.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            str2 = sb.toString();
        }
        return new zzom(str2);
    }
}
