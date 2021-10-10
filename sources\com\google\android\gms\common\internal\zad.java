package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zad extends zab {
    private final /* synthetic */ Intent zaa;
    private final /* synthetic */ Fragment zab;
    private final /* synthetic */ int zac;

    zad(Intent intent, Fragment fragment, int i) {
        this.zaa = intent;
        this.zab = fragment;
        this.zac = i;
    }

    @Override // com.google.android.gms.common.internal.zab
    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
