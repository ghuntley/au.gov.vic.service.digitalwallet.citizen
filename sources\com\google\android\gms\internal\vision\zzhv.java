package com.google.android.gms.internal.vision;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzhv implements Comparator<zzht> {
    zzhv() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzht zzht, zzht zzht2) {
        zzht zzht3 = zzht;
        zzht zzht4 = zzht2;
        zzhy zzhy = (zzhy) zzht3.iterator();
        zzhy zzhy2 = (zzhy) zzht4.iterator();
        while (zzhy.hasNext() && zzhy2.hasNext()) {
            int compare = Integer.compare(zzht.zzb(zzhy.zza()), zzht.zzb(zzhy2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzht3.zza(), zzht4.zza());
    }
}
