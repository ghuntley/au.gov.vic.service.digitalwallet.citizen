package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zam;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zaam extends zad {
    private final WeakReference<zaad> zaa;

    zaam(zaad zaad) {
        this.zaa = new WeakReference<>(zaad);
    }

    @Override // com.google.android.gms.signin.internal.zad, com.google.android.gms.signin.internal.zac
    public final void zaa(zam zam) {
        zaad zaad = this.zaa.get();
        if (zaad != null) {
            zaad.zaa.zaa(new zaal(this, zaad, zaad, zam));
        }
    }
}
