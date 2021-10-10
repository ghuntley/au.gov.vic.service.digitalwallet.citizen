package com.google.android.gms.internal.measurement;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzlf extends IllegalArgumentException {
    /* JADX WARNING: Illegal instructions before constructor call */
    zzlf(int i, int i2) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
    }
}
