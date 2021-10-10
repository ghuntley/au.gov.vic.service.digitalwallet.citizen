package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
public final class zzpt extends zzpv {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzps zzawa;

    zzpt(zzps zzps) {
        this.zzawa = zzps;
        this.limit = zzps.size();
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.gtm.zzpz
    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzawa.zzal(i);
        }
        throw new NoSuchElementException();
    }
}
