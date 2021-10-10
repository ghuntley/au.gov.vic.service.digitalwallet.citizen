package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.google.android.play.core.internal.aw;
import com.google.android.play.core.internal.cj;
import com.google.android.play.core.splitcompat.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipException;
import kotlin.UByte;

public final class db {
    private static a a;

    static String a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int read;
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        for (File file : list) {
            FileInputStream fileInputStream = new FileInputStream(file);
            do {
                try {
                    read = fileInputStream.read(bArr);
                    if (read > 0) {
                        instance.update(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    cj.a(th, th);
                }
            } while (read != -1);
            fileInputStream.close();
        }
        return Base64.encodeToString(instance.digest(), 11);
        throw th;
    }

    static AssetLocation b(String str, String str2) throws IOException {
        Long l;
        aw.c(str != null, "Attempted to get file location from a null apk path.");
        aw.c(str2 != null, String.format("Attempted to get file location in apk %s with a null file path.", str));
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        byte[] bArr = new byte[22];
        randomAccessFile.seek(randomAccessFile.length() - 22);
        randomAccessFile.readFully(bArr);
        bj k = c(bArr, 0) == 1347093766 ? k(bArr) : null;
        byte b = 5;
        if (k == null) {
            long length = randomAccessFile.length() - 22;
            long j = -65536 + length;
            if (j < 0) {
                j = 0;
            }
            int min = (int) Math.min((long) PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID, randomAccessFile.length());
            byte[] bArr2 = new byte[min];
            byte[] bArr3 = new byte[22];
            loop0:
            while (true) {
                long max = Math.max(3 + (length - ((long) min)), j);
                randomAccessFile.seek(max);
                randomAccessFile.readFully(bArr2);
                for (int i = min - 4; i >= 0; i -= 4) {
                    byte b2 = bArr2[i];
                    int i2 = b2 != b ? b2 != 6 ? b2 != 75 ? b2 != 80 ? -1 : 0 : 1 : 3 : 2;
                    if (i2 >= 0 && i >= i2 && c(bArr2, i - i2) == 1347093766) {
                        randomAccessFile.seek((max + ((long) i)) - ((long) i2));
                        randomAccessFile.readFully(bArr3);
                        k = k(bArr3);
                        break loop0;
                    }
                    b = 5;
                }
                if (max != j) {
                    length = max;
                } else {
                    throw new ZipException(String.format("End Of Central Directory signature not found in APK %s", str));
                }
            }
        }
        long j2 = k.a;
        byte[] bytes = str2.getBytes(Key.STRING_CHARSET_NAME);
        byte[] bArr4 = new byte[46];
        byte[] bArr5 = new byte[str2.length()];
        int i3 = 0;
        while (true) {
            if (i3 >= k.b) {
                l = null;
                break;
            }
            randomAccessFile.seek(j2);
            randomAccessFile.readFully(bArr4);
            int c = c(bArr4, 0);
            if (c == 1347092738) {
                randomAccessFile.seek(j2 + 28);
                int e = e(bArr4, 28);
                if (e == str2.length()) {
                    randomAccessFile.seek(46 + j2);
                    randomAccessFile.read(bArr5);
                    if (Arrays.equals(bArr5, bytes)) {
                        l = Long.valueOf(d(bArr4, 42));
                        break;
                    }
                }
                j2 += (long) (e + 46 + e(bArr4, 30) + e(bArr4, 32));
                i3++;
            } else {
                throw new ZipException(String.format("Missing central directory file header signature when looking for file %s in APK %s. Read %d entries out of %d. Found %d instead of the header signature %d.", str2, str, Integer.valueOf(i3), Integer.valueOf(k.b), Integer.valueOf(c), 1347092738));
            }
        }
        if (l == null) {
            return null;
        }
        long longValue = l.longValue();
        byte[] bArr6 = new byte[8];
        randomAccessFile.seek(22 + longValue);
        randomAccessFile.readFully(bArr6);
        return AssetLocation.a(str, longValue + 30 + ((long) e(bArr6, 4)) + ((long) e(bArr6, 6)), d(bArr6, 0));
    }

    static int c(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    static long d(byte[] bArr, int i) {
        return ((long) ((e(bArr, i + 2) << 16) | e(bArr, i))) & 4294967295L;
    }

    static int e(byte[] bArr, int i) {
        return ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | (bArr[i] & UByte.MAX_VALUE);
    }

    public static boolean f(int i) {
        return i == 1 || i == 7 || i == 2 || i == 3;
    }

    public static boolean g(int i) {
        return i == 5 || i == 6 || i == 4;
    }

    public static boolean h(int i) {
        return i == 2 || i == 7 || i == 3;
    }

    static boolean i(int i, int i2) {
        if (i == 5) {
            if (i2 != 5) {
                return true;
            }
            i = 5;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i == 4 && i2 != 4) {
            return true;
        }
        if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
            return true;
        }
        if (i == 2) {
            return i2 == 1 || i2 == 8;
        }
        return false;
    }

    static synchronized a j(Context context) {
        a aVar;
        synchronized (db.class) {
            if (a == null) {
                bq bqVar = new bq(null);
                bqVar.b(new n(p.c(context)));
                a = bqVar.a();
            }
            aVar = a;
        }
        return aVar;
    }

    private static bj k(byte[] bArr) {
        int e = e(bArr, 10);
        d(bArr, 12);
        return new bj(d(bArr, 16), e);
    }
}
