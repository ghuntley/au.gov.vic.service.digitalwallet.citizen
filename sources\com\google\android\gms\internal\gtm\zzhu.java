package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

final class zzhu implements Comparator<zzoa<?>> {
    private final /* synthetic */ zzof zzari;
    private final /* synthetic */ zzfl zzarj;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    zzhu(zzhs zzhs, zzof zzof, zzfl zzfl) {
        this.zzari = zzof;
        this.zzarj = zzfl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzoa<?> zzoa, zzoa<?> zzoa2) {
        zzoa<?> zzoa3 = zzoa;
        zzoa<?> zzoa4 = zzoa2;
        if (zzoa3 == null) {
            return zzoa4 != null ? 1 : 0;
        }
        if (zzoa4 == null) {
            return zzoa3 != null ? -1 : 0;
        }
        zzoa<?> zzb = ((zzgz) this.zzari.value()).zzb(this.zzarj, zzoa3, zzoa4);
        Preconditions.checkState(zzb instanceof zzoe);
        return (int) ((Double) ((zzoe) zzb).value()).doubleValue();
    }
}
