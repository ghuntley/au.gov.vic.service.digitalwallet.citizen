package com.digitalwallet.view.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import kotlin.Metadata;
import kotlin.Pair;
import org.bouncycastle.i18n.TextBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJf\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/view/util/ColorUnderlineSpan;", "Landroid/text/style/LineBackgroundSpan;", "underlineColor", "", "underlineStart", "underlineEnd", "underlineOffset", "", "(IIIF)V", "paint", "Landroid/graphics/Paint;", "drawBackground", "", "c", "Landroid/graphics/Canvas;", "p", "left", "right", "top", "baseline", "bottom", TextBundle.TEXT_ENTRY, "", "start", "end", "lnum", "lowHighPair", "Lkotlin/Pair;", "a", "b", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ColorUnderlineSpan.kt */
public final class ColorUnderlineSpan implements LineBackgroundSpan {
    private final Paint paint;
    private final int underlineEnd;
    private final float underlineOffset;
    private final int underlineStart;

    public ColorUnderlineSpan(int i, int i2, int i3, float f) {
        this.underlineStart = i2;
        this.underlineEnd = i3;
        this.underlineOffset = f;
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(i);
        paint2.setStrokeWidth(4.0f);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void drawBackground(Canvas canvas, Paint paint2, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
        int i9 = this.underlineStart;
        int i10 = this.underlineEnd;
        int i11 = 0;
        if (!(i9 < i10)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (i9 <= i7 && i10 >= i6) {
            Pair<Integer, Integer> lowHighPair = lowHighPair(i6, i9);
            CharSequence charSequence2 = null;
            String valueOf = String.valueOf(charSequence != null ? charSequence.subSequence(lowHighPair.component1().intValue(), lowHighPair.component2().intValue()) : null);
            if (paint2 != null) {
                i11 = (int) paint2.measureText(valueOf);
            }
            int i12 = this.underlineStart;
            float f = 0.0f;
            float f2 = i12 > i6 ? (float) i11 : 0.0f;
            int max = Math.max(i6, i12);
            int min = Math.min(i7, this.underlineEnd);
            if (charSequence != null) {
                charSequence2 = charSequence.subSequence(max, min);
            }
            String valueOf2 = String.valueOf(charSequence2);
            if (paint2 != null) {
                f = paint2.measureText(valueOf2);
            }
            float f3 = ((float) i4) + this.underlineOffset;
            if (canvas != null) {
                canvas.drawLine(f2, f3, f + f2, f3, this.paint);
            }
        }
    }

    private final Pair<Integer, Integer> lowHighPair(int i, int i2) {
        Pair<Integer, Integer> pair;
        if (i < i2) {
            Integer.valueOf(i);
            Integer.valueOf(i2);
        } else {
            pair = new Pair<>(Integer.valueOf(i2), Integer.valueOf(i));
        }
        return pair;
    }
}
