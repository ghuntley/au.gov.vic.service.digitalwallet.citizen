package com.google.android.gms.internal.gtm;

import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import org.bouncycastle.i18n.TextBundle;

public final class zzle extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        byte[] bArr;
        String str2;
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        String zzd = zzha.zzd(zzoaArr[0]);
        String zzd2 = zzoaArr.length > 1 ? zzha.zzd(zzoaArr[1]) : TextBundle.TEXT_ENTRY;
        int i = 2;
        if (zzoaArr.length > 2) {
            str = zzha.zzd(zzoaArr[2]);
        } else {
            str = "base16";
        }
        if (zzoaArr.length <= 3 || !zzha.zza(zzoaArr[3])) {
            z = false;
        }
        if (z) {
            i = 3;
        }
        try {
            if (TextBundle.TEXT_ENTRY.equals(zzd2)) {
                bArr = zzd.getBytes();
            } else if ("base16".equals(zzd2)) {
                bArr = zzdp.decode(zzd);
            } else if ("base64".equals(zzd2)) {
                bArr = Base64.decode(zzd, i);
            } else if ("base64url".equals(zzd2)) {
                bArr = Base64.decode(zzd, i | 8);
            } else {
                String valueOf = String.valueOf(zzd2);
                throw new UnsupportedOperationException(valueOf.length() != 0 ? "Encode: unknown input format: ".concat(valueOf) : new String("Encode: unknown input format: "));
            }
            if ("base16".equals(str)) {
                str2 = zzdp.encode(bArr);
            } else if ("base64".equals(str)) {
                str2 = Base64.encodeToString(bArr, i);
            } else if ("base64url".equals(str)) {
                str2 = Base64.encodeToString(bArr, i | 8);
            } else {
                String valueOf2 = String.valueOf(str);
                throw new RuntimeException(valueOf2.length() != 0 ? "Encode: unknown output format: ".concat(valueOf2) : new String("Encode: unknown output format: "));
            }
            return new zzom(str2);
        } catch (IllegalArgumentException unused) {
            String valueOf3 = String.valueOf(zzd2);
            throw new RuntimeException(valueOf3.length() != 0 ? "Encode: invalid input:".concat(valueOf3) : new String("Encode: invalid input:"));
        }
    }
}
