package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.i18n.TextBundle;

public final class zzli extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        byte[] bArr;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        if (zzoaArr[0] == zzog.zzaum) {
            return zzog.zzaum;
        }
        String zzd = zzha.zzd(zzoaArr[0]);
        String str = "MD5";
        if (zzoaArr.length > 1 && zzoaArr[1] != zzog.zzaum) {
            str = zzha.zzd(zzoaArr[1]);
        }
        String zzd2 = (zzoaArr.length <= 2 || zzoaArr[2] == zzog.zzaum) ? TextBundle.TEXT_ENTRY : zzha.zzd(zzoaArr[2]);
        if (TextBundle.TEXT_ENTRY.equals(zzd2)) {
            bArr = zzd.getBytes();
        } else if ("base16".equals(zzd2)) {
            bArr = zzdp.decode(zzd);
        } else {
            String valueOf = String.valueOf(zzd2);
            throw new RuntimeException(valueOf.length() != 0 ? "Hash: Unknown input format: ".concat(valueOf) : new String("Hash: Unknown input format: "));
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return new zzom(zzdp.encode(instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            String valueOf2 = String.valueOf(str);
            throw new RuntimeException(valueOf2.length() != 0 ? "Hash: Unknown algorithm: ".concat(valueOf2) : new String("Hash: Unknown algorithm: "), e);
        }
    }
}
