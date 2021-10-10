package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzud extends IllegalArgumentException {
    /* JADX WARNING: Illegal instructions before constructor call */
    zzud(int i, int i2) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
    }
}
