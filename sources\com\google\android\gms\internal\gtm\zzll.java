package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

public final class zzll implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return new zzom("");
        }
        String language = locale.getLanguage();
        if (language == null) {
            return new zzom("");
        }
        return new zzom(language.toLowerCase());
    }
}
