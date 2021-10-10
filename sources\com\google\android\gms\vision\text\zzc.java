package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
final class zzc {
    static Rect zza(Text text) {
        Point[] cornerPoints = text.getCornerPoints();
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (Point point : cornerPoints) {
            i4 = Math.min(i4, point.x);
            i = Math.max(i, point.x);
            i2 = Math.min(i2, point.y);
            i3 = Math.max(i3, point.y);
        }
        return new Rect(i4, i2, i, i3);
    }

    static Point[] zza(zzab zzab) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzab.zze));
        double cos = Math.cos(Math.toRadians((double) zzab.zze));
        pointArr[0] = new Point(zzab.zza, zzab.zzb);
        pointArr[1] = new Point((int) (((double) zzab.zza) + (((double) zzab.zzc) * cos)), (int) (((double) zzab.zzb) + (((double) zzab.zzc) * sin)));
        pointArr[2] = new Point((int) (((double) pointArr[1].x) - (((double) zzab.zzd) * sin)), (int) (((double) pointArr[1].y) + (((double) zzab.zzd) * cos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return pointArr;
    }
}
