package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.List;

public final class zzgy extends zzhb {
    private final String name;
    private zzfl zzape = null;
    private final List<String> zzarg;
    private final List<zzol> zzarh;

    public zzgy(zzfl zzfl, String str, List<String> list, List<zzol> list2) {
        this.name = str;
        this.zzarg = list;
        this.zzarh = list2;
    }

    public final void zza(zzfl zzfl) {
        this.zzape = zzfl;
    }

    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        try {
            zzfl zzku = this.zzape.zzku();
            for (int i = 0; i < this.zzarg.size(); i++) {
                if (zzoaArr.length > i) {
                    zzku.zza(this.zzarg.get(i), zzoaArr[i]);
                } else {
                    zzku.zza(this.zzarg.get(i), zzog.zzaum);
                }
            }
            zzku.zza("arguments", new zzoh(Arrays.asList(zzoaArr)));
            for (zzol zzol : this.zzarh) {
                zzoa zza = zzoo.zza(zzku, zzol);
                if ((zza instanceof zzog) && ((zzog) zza).zzmh()) {
                    return (zzoa) ((zzog) zza).value();
                }
            }
        } catch (RuntimeException e) {
            String str = this.name;
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(message).length());
            sb.append("Internal error - Function call: ");
            sb.append(str);
            sb.append("\n");
            sb.append(message);
            zzev.zzav(sb.toString());
        }
        return zzog.zzaum;
    }

    public final String getName() {
        return this.name;
    }

    public final String toString() {
        String str = this.name;
        String obj = this.zzarg.toString();
        String obj2 = this.zzarh.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(obj).length() + String.valueOf(obj2).length());
        sb.append(str);
        sb.append("\n\tparams: ");
        sb.append(obj);
        sb.append("\n\t: statements: ");
        sb.append(obj2);
        return sb.toString();
    }
}
