package com.digitalwallet.utilities;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.digitalwallet.R;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001/B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0018\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J\u0018\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020%H\u0002R\u0015\u0010\t\u001a\u00020\n8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R$\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u0017R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/digitalwallet/utilities/UnderlinedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "extraSpace", "", "getExtraSpace", "()F", "internalAdd", "value", "lineColor", "getLineColor", "()I", "setLineColor", "(I)V", "lineHeight", "getLineHeight", "setLineHeight", "(F)V", "linePaint", "Landroid/graphics/Paint;", "linePosition", "getLinePosition$annotations", "()V", "getLinePosition", "setLinePosition", "lineTopOffset", "getLineTopOffset", "setLineTopOffset", "rect", "Landroid/graphics/Rect;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setLineSpacing", ProductAction.ACTION_ADD, "mult", "updateSpacing", "UnderLinePosition", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnderlinedTextView.kt */
public final class UnderlinedTextView extends AppCompatTextView {
    private HashMap _$_findViewCache;
    private float internalAdd;
    private final Paint linePaint;
    private int linePosition;
    private float lineTopOffset;
    private final Rect rect;

    public UnderlinedTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public UnderlinedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public static /* synthetic */ void getLinePosition$annotations() {
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnderlinedTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnderlinedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        Unit unit = Unit.INSTANCE;
        this.linePaint = paint;
        this.rect = new Rect();
        this.internalAdd = getLineSpacingExtra();
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        float f = resources.getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinedTextView, i, 0);
        setLineColor(obtainStyledAttributes.getColor(1, getCurrentTextColor()));
        setLineTopOffset(obtainStyledAttributes.getDimension(3, 0.0f));
        setLineHeight(obtainStyledAttributes.getDimension(2, f * ((float) 1)));
        this.linePosition = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/utilities/UnderlinedTextView$UnderLinePosition;", "", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* compiled from: UnderlinedTextView.kt */
    public @interface UnderLinePosition {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int POSITION_BASELINE = 0;
        public static final int POSITION_BELOW = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/utilities/UnderlinedTextView$UnderLinePosition$Companion;", "", "()V", "POSITION_BASELINE", "", "POSITION_BELOW", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
        /* compiled from: UnderlinedTextView.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int POSITION_BASELINE = 0;
            public static final int POSITION_BELOW = 1;

            private Companion() {
            }
        }
    }

    public final int getLineColor() {
        return this.linePaint.getColor();
    }

    public final void setLineColor(int i) {
        if (this.linePaint.getColor() != i) {
            this.linePaint.setColor(i);
            invalidate();
        }
    }

    public final float getLineHeight() {
        return this.linePaint.getStrokeWidth();
    }

    public final void setLineHeight(float f) {
        if (this.linePaint.getStrokeWidth() != f) {
            this.linePaint.setStrokeWidth(f);
            updateSpacing();
        }
    }

    public final float getLineTopOffset() {
        return this.lineTopOffset;
    }

    public final void setLineTopOffset(float f) {
        if (this.lineTopOffset != f) {
            this.lineTopOffset = f;
            updateSpacing();
        }
    }

    public final int getLinePosition() {
        return this.linePosition;
    }

    public final void setLinePosition(int i) {
        this.linePosition = i;
    }

    private final float getExtraSpace() {
        return getLineTopOffset() + getLineHeight();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + ((int) (getLineTopOffset() + getLineHeight() + 0.5f)));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        if (canvas != null) {
            CharSequence text = getText();
            if (((text == null || text.length() == 0) ^ true ? canvas : null) != null) {
                int lineCount = getLineCount();
                Layout layout = getLayout();
                float lineSpacingExtra = getLineSpacingExtra() * getLineSpacingMultiplier();
                int i = 0;
                while (i < lineCount) {
                    int lineBounds = getLineBounds(i, this.rect);
                    int i2 = i == lineCount + -1 ? 1 : 0;
                    int lineStart = layout.getLineStart(i);
                    int lineEnd = layout.getLineEnd(i);
                    float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
                    float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - (i2 ^ 1));
                    int i3 = this.linePosition;
                    if (i3 == 0) {
                        f = ((float) lineBounds) + this.lineTopOffset;
                    } else if (i3 == 1) {
                        f = (((float) this.rect.bottom) + this.lineTopOffset) - (i2 != 0 ? 0.0f : lineSpacingExtra);
                    } else {
                        throw new NotImplementedError("");
                    }
                    canvas.drawRect(primaryHorizontal, f, primaryHorizontal2, f + getLineHeight(), this.linePaint);
                    i++;
                }
            }
        }
        super.onDraw(canvas);
    }

    private final void updateSpacing() {
        setLineSpacing(this.internalAdd, 1.0f);
    }

    public void setLineSpacing(float f, float f2) {
        this.internalAdd = f;
        super.setLineSpacing(f + getLineTopOffset() + getLineHeight(), 1.0f);
    }
}
