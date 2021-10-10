package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzli extends zzlo {
    private final /* synthetic */ zzlh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzli(zzlh zzlh) {
        super(zzlh, null);
        this.zza = zzlh;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.google.android.gms.internal.vision.zzlo, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzlj(this.zza, null);
    }

    /* synthetic */ zzli(zzlh zzlh, zzlg zzlg) {
        this(zzlh);
    }
}
