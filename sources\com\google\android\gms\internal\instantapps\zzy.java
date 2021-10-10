package com.google.android.gms.internal.instantapps;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.instantapps.zze;
import com.google.android.gms.instantapps.zzf;

public final class zzy {
    public final PendingResult<zze> zza(GoogleApiClient googleApiClient, String str) {
        Preconditions.checkNotNull(googleApiClient);
        Preconditions.checkNotNull(str);
        return googleApiClient.enqueue(new zzx(this, googleApiClient, str));
    }

    public final PendingResult<zzf> zza(GoogleApiClient googleApiClient) {
        Preconditions.checkNotNull(googleApiClient);
        return googleApiClient.enqueue(new zzz(this, googleApiClient));
    }
}
