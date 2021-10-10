package com.google.android.gms.common.api.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaco implements zacn {
    private final /* synthetic */ zacl zaa;

    zaco(zacl zacl) {
        this.zaa = zacl;
    }

    @Override // com.google.android.gms.common.api.internal.zacn
    public final void zaa(BasePendingResult<?> basePendingResult) {
        this.zaa.zab.remove(basePendingResult);
    }
}
