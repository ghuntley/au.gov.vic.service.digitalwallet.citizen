package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzw {
    public static Bitmap zza(Bitmap bitmap, zzs zzs) {
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (zzs.zze != 0) {
            Matrix matrix = new Matrix();
            int i2 = zzs.zze;
            if (i2 == 0) {
                i = 0;
            } else if (i2 == 1) {
                i = 90;
            } else if (i2 == 2) {
                i = 180;
            } else if (i2 == 3) {
                i = 270;
            } else {
                throw new IllegalArgumentException("Unsupported rotation degree.");
            }
            matrix.postRotate((float) i);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        if (zzs.zze == 1 || zzs.zze == 3) {
            zzs.zza = height;
            zzs.zzb = width;
        }
        return bitmap;
    }

    public static ByteBuffer zza(Bitmap bitmap, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((((width + 1) / 2) * ((height + 1) / 2)) << 1) + i);
        int i2 = i;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 % width;
            int i5 = i3 / width;
            int pixel = bitmap.getPixel(i4, i5);
            int red = Color.red(pixel);
            float f = (float) red;
            float green = (float) Color.green(pixel);
            float blue = (float) Color.blue(pixel);
            allocateDirect.put(i3, (byte) ((int) ((0.299f * f) + (0.587f * green) + (0.114f * blue))));
            if (i5 % 2 == 0 && i4 % 2 == 0) {
                int i6 = i2 + 1;
                allocateDirect.put(i2, (byte) ((int) ((-0.169f * f) + (-0.331f * green) + (blue * 0.5f) + 128.0f)));
                i2 = i6 + 1;
                allocateDirect.put(i6, (byte) ((int) ((f * 0.5f) + (green * -0.419f) + (blue * -0.081f) + 128.0f)));
            }
        }
        return allocateDirect;
    }
}
