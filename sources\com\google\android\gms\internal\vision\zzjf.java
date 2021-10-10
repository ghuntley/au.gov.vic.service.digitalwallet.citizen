package com.google.android.gms.internal.vision;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import org.bouncycastle.i18n.LocalizedMessage;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzjf {
    static final Charset zza = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final byte[] zzb;
    private static final Charset zzc = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
    private static final ByteBuffer zzd;
    private static final zzif zze;

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T zza(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    static <T> T zza(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static boolean zza(byte[] bArr) {
        return zzmd.zza(bArr);
    }

    public static String zzb(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        int zza2 = zza(length, bArr, 0, length);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static boolean zza(zzkk zzkk) {
        if (!(zzkk instanceof zzhh)) {
            return false;
        }
        zzhh zzhh = (zzhh) zzkk;
        return false;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzkk) obj).zzp().zza((zzkk) obj2).zze();
    }

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zzd = ByteBuffer.wrap(bArr);
        zze = zzif.zza(bArr, 0, bArr.length, false);
    }
}
