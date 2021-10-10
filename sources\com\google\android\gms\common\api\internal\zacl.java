package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zacl {
    public static final Status zaa = new Status(8, "The connection to Google Play services was lost");
    final Set<BasePendingResult<?>> zab = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zacn zac = new zaco(this);

    /* access modifiers changed from: package-private */
    public final void zaa(BasePendingResult<? extends Result> basePendingResult) {
        this.zab.add(basePendingResult);
        basePendingResult.zaa(this.zac);
    }

    public final void zaa() {
        BasePendingResult[] basePendingResultArr = (BasePendingResult[]) this.zab.toArray(new BasePendingResult[0]);
        for (BasePendingResult basePendingResult : basePendingResultArr) {
            basePendingResult.zaa((zacn) null);
            if (basePendingResult.zaa()) {
                this.zab.remove(basePendingResult);
            }
        }
    }
}
