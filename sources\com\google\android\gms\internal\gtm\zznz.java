package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zznz {
    private final Object value;
    private final List<Integer> zzaua = new ArrayList();
    private final Integer zzauc;
    private boolean zzqw = false;

    public zznz(int i, Object obj) {
        this.zzauc = Integer.valueOf(i);
        this.value = obj;
    }

    public final zznz zzab(int i) {
        this.zzaua.add(Integer.valueOf(i));
        return this;
    }

    public final zznz zzh(boolean z) {
        this.zzqw = true;
        return this;
    }

    public final zznx zzme() {
        Preconditions.checkNotNull(this.zzauc);
        Preconditions.checkNotNull(this.value);
        return new zznx(this.zzauc, this.value, this.zzaua, this.zzqw);
    }
}
