package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zal implements Runnable {
    final /* synthetic */ zak zaa;
    private final zam zab;

    zal(zak zak, zam zam) {
        this.zaa = zak;
        this.zab = zam;
    }

    public final void run() {
        if (this.zaa.zaa) {
            ConnectionResult zab2 = this.zab.zab();
            if (zab2.hasResolution()) {
                this.zaa.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(this.zaa.getActivity(), (PendingIntent) Preconditions.checkNotNull(zab2.getResolution()), this.zab.zaa(), false), 1);
            } else if (this.zaa.zac.getErrorResolutionIntent(this.zaa.getActivity(), zab2.getErrorCode(), null) != null) {
                this.zaa.zac.zaa(this.zaa.getActivity(), this.zaa.mLifecycleFragment, zab2.getErrorCode(), 2, this.zaa);
            } else if (zab2.getErrorCode() == 18) {
                this.zaa.zac.zaa(this.zaa.getActivity().getApplicationContext(), new zan(this, GoogleApiAvailability.zaa(this.zaa.getActivity(), this.zaa)));
            } else {
                this.zaa.zaa(zab2, this.zab.zaa());
            }
        }
    }
}
