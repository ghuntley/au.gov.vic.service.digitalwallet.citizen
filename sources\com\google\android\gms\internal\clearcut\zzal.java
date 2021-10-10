package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;

/* access modifiers changed from: package-private */
public final class zzal extends zzae<T> {
    private final Object lock = new Object();
    private String zzec;
    private T zzed;
    private final /* synthetic */ zzan zzee;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(zzao zzao, String str, Object obj, zzan zzan) {
        super(zzao, str, obj, null);
        this.zzee = zzan;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.zzae
    public final T zza(SharedPreferences sharedPreferences) {
        try {
            return (T) zzb(sharedPreferences.getString(this.zzds, ""));
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid byte[] value in SharedPreferences for ".concat(valueOf) : new String("Invalid byte[] value in SharedPreferences for "), e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1 = r4.zzds;
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 27) + java.lang.String.valueOf(r5).length());
        r3.append("Invalid byte[] value for ");
        r3.append(r1);
        r3.append(": ");
        r3.append(r5);
        android.util.Log.e("PhenotypeFlag", r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        return null;
     */
    @Override // com.google.android.gms.internal.clearcut.zzae
    public final T zzb(String str) {
        T t;
        synchronized (this.lock) {
            if (!str.equals(this.zzec)) {
                this.zzec = str;
                this.zzed = (T) this.zzee.zzb(Base64.decode(str, 3));
            }
            t = this.zzed;
        }
        return t;
    }
}
