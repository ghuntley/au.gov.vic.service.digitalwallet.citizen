package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzdk<T> implements zzdf<T> {
    private volatile zzdf<T> zza;
    private volatile boolean zzb;
    @NullableDecl
    private T zzc;

    zzdk(zzdf<T> zzdf) {
        this.zza = (zzdf) zzde.zza(zzdf);
    }

    @Override // com.google.android.gms.internal.vision.zzdf
    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            String valueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
