package com.google.android.gms.internal.instantapps;

import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import org.bouncycastle.i18n.LocalizedMessage;

public final class zzcy {
    private static final Charset ISO_8859_1 = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
    static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final byte[] zzapu;
    private static final ByteBuffer zzapv;
    private static final zzcb zzapw;

    public static int zzc(boolean z) {
        return z ? 1231 : 1237;
    }

    static boolean zzf(zzef zzef) {
        return false;
    }

    public static int zzm(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    static <T> T zza(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static boolean zzd(byte[] bArr) {
        return zzfv.zzd(bArr);
    }

    public static String zze(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzef) obj).zzcb().zza((zzef) obj2).zzbv();
    }

    static {
        byte[] bArr = new byte[0];
        zzapu = bArr;
        zzapv = ByteBuffer.wrap(bArr);
        zzapw = zzcb.zza(bArr, 0, bArr.length, false);
    }
}
