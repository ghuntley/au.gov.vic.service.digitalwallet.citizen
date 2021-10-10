package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzio extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzom);
        Preconditions.checkArgument(zzoaArr[2] instanceof zzoh);
        zzoa<?> zzoa = zzoaArr[0];
        String str = (String) ((zzom) zzoaArr[1]).value();
        List list = (List) ((zzoh) zzoaArr[2]).value();
        if (zzoa.zzcn(str)) {
            zzoa<?> zzco = zzoa.zzco(str);
            if (zzco instanceof zzof) {
                return ((zzgz) ((zzof) zzco).value()).zzb(zzfl, (zzoa[]) list.toArray(new zzoa[list.size()]));
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35);
            sb.append("Apply TypeError: ");
            sb.append(str);
            sb.append(" is not a function");
            throw new IllegalArgumentException(sb.toString());
        } else if (zzoa.zzcp(str)) {
            zzgz zzcq = zzoa.zzcq(str);
            list.add(0, zzoa);
            return zzcq.zzb(zzfl, (zzoa[]) list.toArray(new zzoa[list.size()]));
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 40);
            sb2.append("Apply TypeError: object has no ");
            sb2.append(str);
            sb2.append(" property");
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
