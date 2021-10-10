package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzao;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public class Element implements Text {
    private zzao zza;

    Element(zzao zzao) {
        this.zza = zzao;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        return this.zza.zzb;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        return zzc.zza(this);
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        return zzc.zza(this.zza.zza);
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        return new ArrayList();
    }
}
