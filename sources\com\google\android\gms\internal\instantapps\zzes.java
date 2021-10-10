package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcx;

final class zzes implements zzed {
    private final int flags;
    private final String info;
    private final Object[] zzaro;
    private final zzef zzarr;

    zzes(zzef zzef, String str, Object[] objArr) {
        this.zzarr = zzef;
        this.info = str;
        this.zzaro = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            } else {
                this.flags = i | (charAt2 << i2);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzdj() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzdk() {
        return this.zzaro;
    }

    @Override // com.google.android.gms.internal.instantapps.zzed
    public final zzef zzdd() {
        return this.zzarr;
    }

    @Override // com.google.android.gms.internal.instantapps.zzed
    public final int zzdb() {
        return (this.flags & 1) == 1 ? zzcx.zzd.zzapo : zzcx.zzd.zzapp;
    }

    @Override // com.google.android.gms.internal.instantapps.zzed
    public final boolean zzdc() {
        return (this.flags & 2) == 2;
    }
}
