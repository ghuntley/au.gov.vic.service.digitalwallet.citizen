package com.google.android.gms.internal.gtm;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzdm implements zzdo {
    private final /* synthetic */ zzdl zzamq;

    zzdm(zzdl zzdl) {
        this.zzamq = zzdl;
    }

    @Override // com.google.android.gms.internal.gtm.zzdo
    public final AdvertisingIdClient.Info zzgv() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(zzdl.zza(this.zzamq));
        } catch (IllegalStateException e) {
            zzev.zzb("IllegalStateException getting Advertising Id Info", e);
        } catch (GooglePlayServicesRepairableException e2) {
            zzev.zzb("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
        } catch (IOException e3) {
            zzev.zzb("IOException getting Ad Id Info", e3);
        } catch (GooglePlayServicesNotAvailableException e4) {
            zzdl.zza(this.zzamq, false);
            zzev.zzb("GooglePlayServicesNotAvailableException getting Advertising Id Info", e4);
        } catch (Exception e5) {
            zzev.zzb("Unknown exception. Could not get the Advertising Id Info.", e5);
        }
        return null;
    }
}
