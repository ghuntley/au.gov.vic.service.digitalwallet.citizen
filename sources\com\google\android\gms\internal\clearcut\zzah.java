package com.google.android.gms.internal.clearcut;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzah implements zzam {
    private final String zzea;
    private final boolean zzeb = false;

    zzah(String str, boolean z) {
        this.zzea = str;
    }

    @Override // com.google.android.gms.internal.clearcut.zzam
    public final Object zzp() {
        return Boolean.valueOf(zzy.zza(zzae.zzh.getContentResolver(), this.zzea, this.zzeb));
    }
}
