package com.google.android.gms.internal.gtm;

import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class zzkh extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        try {
            return new zzom(encode(zzha.zzd(zzoaArr.length > 0 ? (zzoa) Preconditions.checkNotNull(zzoaArr[0]) : zzog.zzaum), "#;/?:@&=+$,abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_.!~*'()0123456789"));
        } catch (UnsupportedEncodingException unused) {
            return zzog.zzaum;
        }
    }

    static String encode(String str, String str2) throws UnsupportedEncodingException {
        int i;
        StringBuilder sb = new StringBuilder();
        Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (str2.indexOf(charAt) != -1) {
                sb.append((char) charAt);
                i2++;
            } else {
                if (Character.isHighSurrogate((char) charAt)) {
                    int i3 = i2 + 1;
                    if (i3 >= str.length()) {
                        throw new UnsupportedEncodingException();
                    } else if (Character.isLowSurrogate(str.charAt(i3))) {
                        i = 2;
                    } else {
                        throw new UnsupportedEncodingException();
                    }
                } else {
                    i = 1;
                }
                int i4 = i + i2;
                byte[] bytes = str.substring(i2, i4).getBytes(forName);
                for (int i5 = 0; i5 < bytes.length; i5++) {
                    sb.append("%");
                    sb.append(Character.toUpperCase(Character.forDigit((bytes[i5] >> 4) & 15, 16)));
                    sb.append(Character.toUpperCase(Character.forDigit(bytes[i5] & 15, 16)));
                }
                i2 = i4;
            }
        }
        return sb.toString().replaceAll(" ", "%20");
    }
}
