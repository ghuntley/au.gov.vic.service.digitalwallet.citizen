package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import com.google.android.gms.tagmanager.zzch;

/* access modifiers changed from: package-private */
public final class zzgc extends zzch {
    final /* synthetic */ zzfy zzaqb;

    zzgc(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    @Override // com.google.android.gms.tagmanager.zzcg
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (!str.endsWith("+gtm")) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4);
            sb.append(str);
            sb.append("+gtm");
            this.zzaqb.zzamv.execute(new zzgd(this, str2, bundle, sb.toString(), j, str));
        }
    }
}
