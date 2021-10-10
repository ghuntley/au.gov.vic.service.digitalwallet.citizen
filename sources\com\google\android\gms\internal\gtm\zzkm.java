package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzkm extends zzhb {
    private final int type;
    private final zzfl zzaow;

    public zzkm(int i, zzfl zzfl) {
        this.type = i;
        this.zzaow = zzfl;
    }

    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        try {
            zzgy zzo = zzmm.zzo(new JSONArray((String) ((zzom) zzoaArr[0]).value()).getJSONArray(0));
            zzo.zza(this.zzaow);
            return this.type == 0 ? zzog.zzaum : zzo.zzb(zzfl, new zzoa[0]);
        } catch (JSONException e) {
            zzev.zza("Unable to convert Custom Pixie to instruction", e);
            return zzog.zzaum;
        }
    }
}
