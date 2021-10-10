package com.google.android.gms.internal.vision;

import android.content.Context;
import java.util.Objects;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzav extends zzbr {
    private final Context zza;
    private final zzdf<zzcy<zzbe>> zzb;

    zzav(Context context, @Nullable zzdf<zzcy<zzbe>> zzdf) {
        Objects.requireNonNull(context, "Null context");
        this.zza = context;
        this.zzb = zzdf;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzbr
    public final Context zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzbr
    @Nullable
    public final zzdf<zzcy<zzbe>> zzb() {
        return this.zzb;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(valueOf2).length());
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        zzdf<zzcy<zzbe>> zzdf;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbr) {
            zzbr zzbr = (zzbr) obj;
            return this.zza.equals(zzbr.zza()) && ((zzdf = this.zzb) != null ? zzdf.equals(zzbr.zzb()) : zzbr.zzb() == null);
        }
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzdf<zzcy<zzbe>> zzdf = this.zzb;
        return hashCode ^ (zzdf == null ? 0 : zzdf.hashCode());
    }
}
