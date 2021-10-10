package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Status;

/* access modifiers changed from: package-private */
public final class zzmr<T> {
    private T data;
    private Status zzaen;
    private long zzasv;

    public zzmr(Status status, T t, long j) {
        this.zzaen = status;
        this.data = t;
        this.zzasv = j;
    }

    public final void zzb(Status status) {
        this.zzaen = status;
    }

    public final long zzlj() {
        return this.zzasv;
    }

    public final void zzo(long j) {
        this.zzasv = j;
    }

    public final void zzp(T t) {
        this.data = t;
    }
}
