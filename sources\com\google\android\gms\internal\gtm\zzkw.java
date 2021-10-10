package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.common.internal.Preconditions;
import net.openid.appauth.AuthorizationRequest;

public final class zzkw implements zzgz {
    private final Context zzrm;

    public zzkw(Context context) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
    }

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        String networkOperatorName;
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        TelephonyManager telephonyManager = (TelephonyManager) this.zzrm.getSystemService(AuthorizationRequest.Scope.PHONE);
        zzog zzog = zzog.zzaum;
        return (telephonyManager == null || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null) ? zzog : new zzom(networkOperatorName);
    }
}
