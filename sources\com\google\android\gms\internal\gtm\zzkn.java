package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzkn extends zzhb {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        if (r3.equals("i") == false) goto L_0x0031;
     */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        char c = 1;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String zzd = zzha.zzd(zzoaArr[1]);
        String str = (String) ((zzom) zzoaArr[0]).value();
        str.hashCode();
        switch (str.hashCode()) {
            case 101:
                if (str.equals("e")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 105:
                break;
            case 118:
                if (str.equals("v")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 119:
                if (str.equals("w")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                zzev.zzav(zzd);
                break;
            case 1:
                zzev.zzaw(zzd);
                break;
            case 2:
                zzev.zzab(zzd);
                break;
            case 3:
                zzev.zzac(zzd);
                break;
            default:
                String valueOf = String.valueOf((String) ((zzom) zzoaArr[0]).value());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid logging level: ".concat(valueOf) : new String("Invalid logging level: "));
        }
        return zzog.zzaum;
    }
}
