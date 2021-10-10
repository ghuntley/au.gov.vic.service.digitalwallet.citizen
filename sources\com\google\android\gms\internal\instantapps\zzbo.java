package com.google.android.gms.internal.instantapps;

import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
public final class zzbo extends zzbq {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzbp zzaku;

    zzbo(zzbp zzbp) {
        this.zzaku = zzbp;
        this.limit = zzbp.size();
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.instantapps.zzbu
    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzaku.zzk(i);
        }
        throw new NoSuchElementException();
    }
}
