package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.common.internal.Preconditions;

public final class zzlu implements zzgz {
    private DisplayMetrics zzarx = new DisplayMetrics();
    private Context zzrm;

    public zzlu(Context context) {
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
        ((WindowManager) this.zzrm.getSystemService("window")).getDefaultDisplay().getMetrics(this.zzarx);
        return new zzom(this.zzarx.widthPixels + "x" + this.zzarx.heightPixels);
    }
}
