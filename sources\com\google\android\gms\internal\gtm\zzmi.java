package com.google.android.gms.internal.gtm;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

public final class zzmi extends zzhb {
    private final zzei zzary;

    public zzmi(zzei zzei) {
        this.zzary = zzei;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        zzoa<?> zzoa = zzoaArr[0];
        Preconditions.checkArgument(!(zzoa instanceof zzog));
        zzog zzog = zzoaArr.length > 1 ? zzoaArr[1] : zzog.zzaum;
        Preconditions.checkArgument(zzog == zzog.zzaum || (zzog instanceof zzoh));
        zzog zzog2 = zzoaArr.length > 2 ? zzoaArr[2] : zzog.zzaum;
        if (zzog2 != zzog.zzaum && (zzog2 instanceof zzog)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Uri.Builder buildUpon = Uri.parse(zzha.zzd(zzoa)).buildUpon();
        if (zzog != zzog.zzaum) {
            for (zzoa zzoa2 : (List) ((zzoh) zzog).value()) {
                Preconditions.checkArgument(zzoa2 instanceof zzok);
                for (Map.Entry entry : ((Map) ((zzok) zzoa2).value()).entrySet()) {
                    buildUpon.appendQueryParameter(((String) entry.getKey()).toString(), zzha.zzd(zzoo.zza(zzfl, (zzoa) entry.getValue())));
                }
            }
        }
        String uri = buildUpon.build().toString();
        if (zzog2 == zzog.zzaum) {
            this.zzary.zzay(uri);
            String valueOf = String.valueOf(uri);
            zzev.zzab(valueOf.length() != 0 ? "SendPixel: url = ".concat(valueOf) : new String("SendPixel: url = "));
        } else {
            String zzd = zzha.zzd(zzog2);
            this.zzary.zzf(uri, zzd);
            StringBuilder sb = new StringBuilder(String.valueOf(uri).length() + 30 + String.valueOf(zzd).length());
            sb.append("SendPixel: url = ");
            sb.append(uri);
            sb.append(", uniqueId = ");
            sb.append(zzd);
            zzev.zzab(sb.toString());
        }
        return zzog.zzaum;
    }
}
