package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public class TextBlock implements Text {
    private zzah[] zza;
    private Point[] zzb;
    private List<Line> zzc;
    private String zzd;
    private Rect zze;

    TextBlock(SparseArray<zzah> sparseArray) {
        this.zza = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahArr = this.zza;
            if (i < zzahArr.length) {
                zzahArr[i] = sparseArray.valueAt(i);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        zzah[] zzahArr = this.zza;
        for (zzah zzah : zzahArr) {
            hashMap.put(zzah.zzd, Integer.valueOf((hashMap.containsKey(zzah.zzd) ? ((Integer) hashMap.get(zzah.zzd)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(hashMap.entrySet(), new zza(this))).getKey();
        this.zzd = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzd = "und";
        }
        return this.zzd;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        zzah[] zzahArr = this.zza;
        if (zzahArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zzahArr[0].zzc);
        for (int i = 1; i < this.zza.length; i++) {
            sb.append("\n");
            sb.append(this.zza[i].zzc);
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        TextBlock textBlock;
        zzah[] zzahArr;
        TextBlock textBlock2 = this;
        if (textBlock2.zzb == null) {
            char c = 0;
            if (textBlock2.zza.length == 0) {
                textBlock2.zzb = new Point[0];
            } else {
                int i = Integer.MIN_VALUE;
                int i2 = 0;
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MAX_VALUE;
                int i5 = Integer.MIN_VALUE;
                while (true) {
                    zzahArr = textBlock2.zza;
                    if (i2 >= zzahArr.length) {
                        break;
                    }
                    zzab zzab = zzahArr[i2].zzb;
                    zzab zzab2 = textBlock2.zza[c].zzb;
                    double sin = Math.sin(Math.toRadians((double) zzab2.zze));
                    double cos = Math.cos(Math.toRadians((double) zzab2.zze));
                    Point[] pointArr = new Point[4];
                    pointArr[c] = new Point(zzab.zza, zzab.zzb);
                    pointArr[c].offset(-zzab2.zza, -zzab2.zzb);
                    int i6 = (int) ((((double) pointArr[c].x) * cos) + (((double) pointArr[c].y) * sin));
                    int i7 = (int) ((((double) (-pointArr[0].x)) * sin) + (((double) pointArr[0].y) * cos));
                    pointArr[0].x = i6;
                    pointArr[0].y = i7;
                    pointArr[1] = new Point(zzab.zzc + i6, i7);
                    pointArr[2] = new Point(zzab.zzc + i6, zzab.zzd + i7);
                    pointArr[3] = new Point(i6, i7 + zzab.zzd);
                    i5 = i5;
                    for (int i8 = 0; i8 < 4; i8++) {
                        Point point = pointArr[i8];
                        i3 = Math.min(i3, point.x);
                        i = Math.max(i, point.x);
                        i4 = Math.min(i4, point.y);
                        i5 = Math.max(i5, point.y);
                    }
                    i2++;
                    c = 0;
                    textBlock2 = this;
                }
                zzab zzab3 = zzahArr[c].zzb;
                int i9 = zzab3.zza;
                int i10 = zzab3.zzb;
                double sin2 = Math.sin(Math.toRadians((double) zzab3.zze));
                double cos2 = Math.cos(Math.toRadians((double) zzab3.zze));
                Point[] pointArr2 = {new Point(i3, i4), new Point(i, i4), new Point(i, i5), new Point(i3, i5)};
                for (int i11 = 0; i11 < 4; i11++) {
                    pointArr2[i11].x = (int) ((((double) pointArr2[i11].x) * cos2) - (((double) pointArr2[i11].y) * sin2));
                    pointArr2[i11].y = (int) ((((double) pointArr2[i11].x) * sin2) + (((double) pointArr2[i11].y) * cos2));
                    pointArr2[i11].offset(i9, i10);
                }
                textBlock = this;
                textBlock.zzb = pointArr2;
                return textBlock.zzb;
            }
        }
        textBlock = textBlock2;
        return textBlock.zzb;
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        if (this.zza.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzc == null) {
            this.zzc = new ArrayList(this.zza.length);
            for (zzah zzah : this.zza) {
                this.zzc.add(new Line(zzah));
            }
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        if (this.zze == null) {
            this.zze = zzc.zza(this);
        }
        return this.zze;
    }
}
