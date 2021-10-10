package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class zzs extends zzq<Bundle> {
    zzs(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.zzq
    public final boolean zza() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.cloudmessaging.zzq
    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zza((Object) bundle2);
    }
}
