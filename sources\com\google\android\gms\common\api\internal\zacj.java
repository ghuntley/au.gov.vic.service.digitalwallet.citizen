package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zacj implements Runnable {
    private final /* synthetic */ Result zaa;
    private final /* synthetic */ zack zab;

    zacj(zack zack, Result result) {
        this.zab = zack;
        this.zaa = result;
    }

    public final void run() {
        try {
            BasePendingResult.zaa.set(true);
            this.zab.zah.sendMessage(this.zab.zah.obtainMessage(0, ((ResultTransform) Preconditions.checkNotNull(this.zab.zaa)).onSuccess(this.zaa)));
            BasePendingResult.zaa.set(false);
            zack zack = this.zab;
            zack.zaa((zack) this.zaa);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient != null) {
                googleApiClient.zab(this.zab);
            }
        } catch (RuntimeException e) {
            this.zab.zah.sendMessage(this.zab.zah.obtainMessage(1, e));
            BasePendingResult.zaa.set(false);
            zack zack2 = this.zab;
            zack.zaa((zack) this.zaa);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zab(this.zab);
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(false);
            zack zack3 = this.zab;
            zack.zaa((zack) this.zaa);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zab(this.zab);
            }
            throw th;
        }
    }
}
