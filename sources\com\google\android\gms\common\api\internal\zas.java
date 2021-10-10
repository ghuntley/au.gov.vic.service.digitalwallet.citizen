package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zas implements zabm {
    private final /* synthetic */ zaq zaa;

    private zas(zaq zaq) {
        this.zaa = zaq;
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(Bundle bundle) {
        this.zaa.zam.lock();
        try {
            this.zaa.zaa((zaq) bundle);
            this.zaa.zaj = ConnectionResult.RESULT_SUCCESS;
            this.zaa.zah();
        } finally {
            this.zaa.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(ConnectionResult connectionResult) {
        this.zaa.zam.lock();
        try {
            this.zaa.zaj = connectionResult;
            this.zaa.zah();
        } finally {
            this.zaa.zam.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabm
    public final void zaa(int i, boolean z) {
        this.zaa.zam.lock();
        try {
            if (!(this.zaa.zal) && this.zaa.zak != null) {
                if (this.zaa.zak.isSuccess()) {
                    this.zaa.zal = true;
                    this.zaa.zae.onConnectionSuspended(i);
                    this.zaa.zam.unlock();
                    return;
                }
            }
            this.zaa.zal = false;
            this.zaa.zaa((zaq) i, (int) z);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    /* synthetic */ zas(zaq zaq, zat zat) {
        this(zaq);
    }
}
