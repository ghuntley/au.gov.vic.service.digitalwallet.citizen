package com.google.android.gms.internal.vision;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzbm extends zzbi<T> {
    private final /* synthetic */ zzbp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbm(zzbo zzbo, String str, Object obj, boolean z, zzbp zzbp) {
        super(zzbo, str, obj, true, null);
        this.zza = zzbp;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzbi
    public final T zza(Object obj) {
        if (obj instanceof String) {
            try {
                return (T) this.zza.zza(Base64.decode((String) obj, 3));
            } catch (IOException | IllegalArgumentException unused) {
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid byte[] value for ");
        sb.append(zzb);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
