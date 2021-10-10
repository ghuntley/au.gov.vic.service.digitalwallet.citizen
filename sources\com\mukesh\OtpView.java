package com.mukesh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

public class OtpView extends AppCompatEditText {
    private static final int BLINK = 500;
    private static final boolean DBG = false;
    private static final int DEFAULT_COUNT = 4;
    private static final int[] FILLED_STATE = {R.attr.OtpState_filled};
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private static final int[] SELECTED_STATE = {16842913};
    private static final int VIEW_TYPE_LINE = 1;
    private static final int VIEW_TYPE_NONE = 2;
    private static final int VIEW_TYPE_RECTANGLE = 0;
    private final TextPaint animatorTextPaint;
    private Blink blink;
    private int cursorColor;
    private float cursorHeight;
    private int cursorLineColor;
    private int cursorWidth;
    private ValueAnimator defaultAddAnimator;
    private boolean drawCursor;
    private boolean hideLineWhenFilled;
    private boolean isAllCaps;
    private boolean isAnimationEnable;
    private boolean isCursorVisible;
    private Drawable itemBackground;
    private int itemBackgroundResource;
    private final RectF itemBorderRect;
    private final PointF itemCenterPoint;
    private final RectF itemLineRect;
    private ColorStateList lineColor;
    private int lineWidth;
    private String maskingChar;
    private OnOtpCompletionListener onOtpCompletionListener;
    private int otpViewItemCount;
    private int otpViewItemHeight;
    private int otpViewItemRadius;
    private int otpViewItemSpacing;
    private int otpViewItemWidth;
    private final Paint paint;
    private final Path path;
    private boolean rtlTextDirection;
    private final Rect textRect;
    private int viewType;

    private static boolean isNumberInputType(int i) {
        return i == 2;
    }

    private static boolean isPasswordInputType(int i) {
        int i2 = i & 4095;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    public OtpView(Context context) {
        this(context, null);
    }

    public OtpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.otpViewStyle);
    }

    public OtpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TextPaint textPaint = new TextPaint();
        this.animatorTextPaint = textPaint;
        this.cursorLineColor = ViewCompat.MEASURED_STATE_MASK;
        this.textRect = new Rect();
        this.itemBorderRect = new RectF();
        this.itemLineRect = new RectF();
        this.path = new Path();
        this.itemCenterPoint = new PointF();
        this.isAnimationEnable = false;
        this.isAllCaps = false;
        Resources resources = getResources();
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        textPaint.set(getPaint());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.OtpView, i, 0);
        this.viewType = obtainStyledAttributes.getInt(R.styleable.OtpView_OtpViewType, 2);
        this.otpViewItemCount = obtainStyledAttributes.getInt(R.styleable.OtpView_OtpItemCount, 4);
        this.otpViewItemHeight = (int) obtainStyledAttributes.getDimension(R.styleable.OtpView_OtpItemHeight, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_size));
        this.otpViewItemWidth = (int) obtainStyledAttributes.getDimension(R.styleable.OtpView_OtpItemWidth, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_size));
        this.otpViewItemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OtpView_OtpItemSpacing, resources.getDimensionPixelSize(R.dimen.otp_view_item_spacing));
        this.otpViewItemRadius = (int) obtainStyledAttributes.getDimension(R.styleable.OtpView_OtpItemRadius, 0.0f);
        this.lineWidth = (int) obtainStyledAttributes.getDimension(R.styleable.OtpView_OtpLineWidth, (float) resources.getDimensionPixelSize(R.dimen.otp_view_item_line_width));
        this.lineColor = obtainStyledAttributes.getColorStateList(R.styleable.OtpView_OtpLineColor);
        this.isCursorVisible = obtainStyledAttributes.getBoolean(R.styleable.OtpView_android_cursorVisible, true);
        this.cursorColor = obtainStyledAttributes.getColor(R.styleable.OtpView_OtpCursorColor, getCurrentTextColor());
        this.cursorWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.OtpView_OtpCursorWidth, resources.getDimensionPixelSize(R.dimen.otp_view_cursor_width));
        this.itemBackground = obtainStyledAttributes.getDrawable(R.styleable.OtpView_android_itemBackground);
        this.hideLineWhenFilled = obtainStyledAttributes.getBoolean(R.styleable.OtpView_OtpHideLineWhenFilled, false);
        this.rtlTextDirection = obtainStyledAttributes.getBoolean(R.styleable.OtpView_OtpRtlTextDirection, false);
        this.maskingChar = obtainStyledAttributes.getString(R.styleable.OtpView_OtpMaskingChar);
        this.isAllCaps = obtainStyledAttributes.getBoolean(R.styleable.OtpView_android_textAllCaps, false);
        obtainStyledAttributes.recycle();
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList != null) {
            this.cursorLineColor = colorStateList.getDefaultColor();
        }
        updateCursorHeight();
        checkItemRadius();
        setMaxLength(this.otpViewItemCount);
        paint2.setStrokeWidth((float) this.lineWidth);
        setupAnimator();
        setTextIsSelectable(false);
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(typeface, i);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.animatorTextPaint;
        if (textPaint != null) {
            textPaint.set(getPaint());
        }
    }

    private void setMaxLength(int i) {
        setFilters(i >= 0 ? new InputFilter[]{new InputFilter.LengthFilter(i)} : NO_FILTERS);
    }

    private void setupAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.5f, 1.0f);
        this.defaultAddAnimator = ofFloat;
        ofFloat.setDuration(150L);
        this.defaultAddAnimator.setInterpolator(new DecelerateInterpolator());
        this.defaultAddAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.mukesh.OtpView.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OtpView.this.animatorTextPaint.setTextSize(OtpView.this.getTextSize() * floatValue);
                OtpView.this.animatorTextPaint.setAlpha((int) (255.0f * floatValue));
                OtpView.this.postInvalidate();
            }
        });
    }

    private void checkItemRadius() {
        int i = this.viewType;
        if (i == 1) {
            if (((float) this.otpViewItemRadius) > ((float) this.lineWidth) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than lineWidth when viewType is line");
            }
        } else if (i == 0) {
            if (((float) this.otpViewItemRadius) > ((float) this.otpViewItemWidth) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than itemWidth");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.otpViewItemHeight;
        if (mode != 1073741824) {
            int i4 = this.otpViewItemCount;
            size = ViewCompat.getPaddingStart(this) + ((i4 - 1) * this.otpViewItemSpacing) + (i4 * this.otpViewItemWidth) + ViewCompat.getPaddingEnd(this);
            if (this.otpViewItemSpacing == 0) {
                size -= (this.otpViewItemCount - 1) * this.lineWidth;
            }
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingBottom() + i3 + getPaddingTop();
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ValueAnimator valueAnimator;
        OnOtpCompletionListener onOtpCompletionListener2;
        if (i != charSequence.length()) {
            moveSelectionToEnd();
        }
        if (charSequence.length() == this.otpViewItemCount && (onOtpCompletionListener2 = this.onOtpCompletionListener) != null) {
            onOtpCompletionListener2.onOtpCompleted(charSequence.toString());
        }
        makeBlink();
        if (this.isAnimationEnable) {
            if ((i3 - i2 > 0) && (valueAnimator = this.defaultAddAnimator) != null) {
                valueAnimator.end();
                this.defaultAddAnimator.start();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            moveSelectionToEnd();
            makeBlink();
        }
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (getText() != null && i2 != getText().length()) {
            moveSelectionToEnd();
        }
    }

    private void moveSelectionToEnd() {
        if (getText() != null) {
            setSelection(getText().length());
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatEditText
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.lineColor;
        if (colorStateList == null || colorStateList.isStateful()) {
            updateColors();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.save();
        updatePaints();
        drawOtpView(canvas);
        canvas.restore();
    }

    private void updatePaints() {
        this.paint.setColor(this.cursorLineColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth((float) this.lineWidth);
        getPaint().setColor(getCurrentTextColor());
    }

    private void drawOtpView(Canvas canvas) {
        int i;
        if (this.rtlTextDirection) {
            i = this.otpViewItemCount - 1;
        } else {
            i = getText() != null ? getText().length() : 0;
        }
        int i2 = 0;
        while (i2 < this.otpViewItemCount) {
            boolean z = isFocused() && i == i2;
            int[] iArr = null;
            if (i2 < i) {
                iArr = FILLED_STATE;
            } else if (z) {
                iArr = SELECTED_STATE;
            }
            this.paint.setColor(iArr != null ? getLineColorForState(iArr) : this.cursorLineColor);
            updateItemRectF(i2);
            updateCenterPoint();
            canvas.save();
            if (this.viewType == 0) {
                updateOtpViewBoxPath(i2);
                canvas.clipPath(this.path);
            }
            drawItemBackground(canvas, iArr);
            canvas.restore();
            if (z) {
                drawCursor(canvas);
            }
            int i3 = this.viewType;
            if (i3 == 0) {
                drawOtpBox(canvas, i2);
            } else if (i3 == 1) {
                drawOtpLine(canvas, i2);
            }
            if (this.rtlTextDirection) {
                if (getText().length() >= this.otpViewItemCount - i2) {
                    drawInput(canvas, i2);
                } else if (!TextUtils.isEmpty(getHint()) && getHint().length() == this.otpViewItemCount) {
                    drawHint(canvas, i2);
                }
            } else if (getText().length() > i2) {
                drawInput(canvas, i2);
            } else if (!TextUtils.isEmpty(getHint()) && getHint().length() == this.otpViewItemCount) {
                drawHint(canvas, i2);
            }
            i2++;
        }
        if (isFocused() && getText() != null && getText().length() != this.otpViewItemCount && this.viewType == 0) {
            int length = getText().length();
            updateItemRectF(length);
            updateCenterPoint();
            updateOtpViewBoxPath(length);
            this.paint.setColor(getLineColorForState(SELECTED_STATE));
            drawOtpBox(canvas, length);
        }
    }

    private void drawInput(Canvas canvas, int i) {
        if (this.maskingChar != null && (isNumberInputType(getInputType()) || isPasswordInputType(getInputType()))) {
            drawMaskingText(canvas, i, Character.toString(this.maskingChar.charAt(0)));
        } else if (isPasswordInputType(getInputType())) {
            drawCircle(canvas, i);
        } else {
            drawText(canvas, i);
        }
    }

    private int getLineColorForState(int... iArr) {
        ColorStateList colorStateList = this.lineColor;
        return colorStateList != null ? colorStateList.getColorForState(iArr, this.cursorLineColor) : this.cursorLineColor;
    }

    private void drawItemBackground(Canvas canvas, int[] iArr) {
        if (this.itemBackground != null) {
            float f = ((float) this.lineWidth) / 2.0f;
            this.itemBackground.setBounds(Math.round(this.itemBorderRect.left - f), Math.round(this.itemBorderRect.top - f), Math.round(this.itemBorderRect.right + f), Math.round(this.itemBorderRect.bottom + f));
            if (this.viewType != 2) {
                Drawable drawable = this.itemBackground;
                if (iArr == null) {
                    iArr = getDrawableState();
                }
                drawable.setState(iArr);
            }
            this.itemBackground.draw(canvas);
        }
    }

    private void updateOtpViewBoxPath(int i) {
        boolean z;
        boolean z2;
        if (this.otpViewItemSpacing != 0) {
            z2 = true;
            z = true;
        } else {
            boolean z3 = i == 0 && i != this.otpViewItemCount - 1;
            if (i != this.otpViewItemCount - 1 || i == 0) {
                z2 = z3;
                z = false;
            } else {
                z2 = z3;
                z = true;
            }
        }
        RectF rectF = this.itemBorderRect;
        int i2 = this.otpViewItemRadius;
        updateRoundRectPath(rectF, (float) i2, (float) i2, z2, z);
    }

    private void drawOtpBox(Canvas canvas, int i) {
        if (getText() == null || !this.hideLineWhenFilled || i >= getText().length()) {
            canvas.drawPath(this.path, this.paint);
        }
    }

    private void drawOtpLine(Canvas canvas, int i) {
        boolean z;
        boolean z2;
        int i2;
        if (getText() == null || !this.hideLineWhenFilled || i >= getText().length()) {
            if (this.otpViewItemSpacing != 0 || (i2 = this.otpViewItemCount) <= 1) {
                z2 = true;
            } else {
                if (i == 0) {
                    z = false;
                    z2 = true;
                } else if (i == i2 - 1) {
                    z2 = false;
                    z = true;
                } else {
                    z2 = false;
                }
                this.paint.setStyle(Paint.Style.FILL);
                this.paint.setStrokeWidth(((float) this.lineWidth) / 10.0f);
                float f = ((float) this.lineWidth) / 2.0f;
                this.itemLineRect.set(this.itemBorderRect.left - f, this.itemBorderRect.bottom - f, this.itemBorderRect.right + f, this.itemBorderRect.bottom + f);
                RectF rectF = this.itemLineRect;
                int i3 = this.otpViewItemRadius;
                updateRoundRectPath(rectF, (float) i3, (float) i3, z2, z);
                canvas.drawPath(this.path, this.paint);
            }
            z = z2;
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setStrokeWidth(((float) this.lineWidth) / 10.0f);
            float f2 = ((float) this.lineWidth) / 2.0f;
            this.itemLineRect.set(this.itemBorderRect.left - f2, this.itemBorderRect.bottom - f2, this.itemBorderRect.right + f2, this.itemBorderRect.bottom + f2);
            RectF rectF2 = this.itemLineRect;
            int i32 = this.otpViewItemRadius;
            updateRoundRectPath(rectF2, (float) i32, (float) i32, z2, z);
            canvas.drawPath(this.path, this.paint);
        }
    }

    private void drawCursor(Canvas canvas) {
        if (this.drawCursor) {
            float f = this.itemCenterPoint.x;
            float f2 = this.itemCenterPoint.y - (this.cursorHeight / 2.0f);
            int color = this.paint.getColor();
            float strokeWidth = this.paint.getStrokeWidth();
            this.paint.setColor(this.cursorColor);
            this.paint.setStrokeWidth((float) this.cursorWidth);
            canvas.drawLine(f, f2, f, f2 + this.cursorHeight, this.paint);
            this.paint.setColor(color);
            this.paint.setStrokeWidth(strokeWidth);
        }
    }

    private void updateRoundRectPath(RectF rectF, float f, float f2, boolean z, boolean z2) {
        updateRoundRectPath(rectF, f, f2, z, z2, z2, z);
    }

    private void updateRoundRectPath(RectF rectF, float f, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.path.reset();
        float f3 = rectF.left;
        float f4 = rectF.top;
        float f5 = (rectF.right - f3) - (f * 2.0f);
        float f6 = (rectF.bottom - f4) - (2.0f * f2);
        this.path.moveTo(f3, f4 + f2);
        if (z) {
            float f7 = -f2;
            this.path.rQuadTo(0.0f, f7, f, f7);
        } else {
            this.path.rLineTo(0.0f, -f2);
            this.path.rLineTo(f, 0.0f);
        }
        this.path.rLineTo(f5, 0.0f);
        if (z2) {
            this.path.rQuadTo(f, 0.0f, f, f2);
        } else {
            this.path.rLineTo(f, 0.0f);
            this.path.rLineTo(0.0f, f2);
        }
        this.path.rLineTo(0.0f, f6);
        if (z3) {
            this.path.rQuadTo(0.0f, f2, -f, f2);
        } else {
            this.path.rLineTo(0.0f, f2);
            this.path.rLineTo(-f, 0.0f);
        }
        this.path.rLineTo(-f5, 0.0f);
        if (z4) {
            float f8 = -f;
            this.path.rQuadTo(f8, 0.0f, f8, -f2);
        } else {
            this.path.rLineTo(-f, 0.0f);
            this.path.rLineTo(0.0f, -f2);
        }
        this.path.rLineTo(0.0f, -f6);
        this.path.close();
    }

    private void updateItemRectF(int i) {
        float f = ((float) this.lineWidth) / 2.0f;
        int scrollX = getScrollX() + ViewCompat.getPaddingStart(this);
        int i2 = this.otpViewItemSpacing;
        int i3 = this.otpViewItemWidth;
        float f2 = ((float) (scrollX + ((i2 + i3) * i))) + f;
        if (i2 == 0 && i > 0) {
            f2 -= (float) (this.lineWidth * i);
        }
        float f3 = (((float) i3) + f2) - ((float) this.lineWidth);
        float scrollY = ((float) (getScrollY() + getPaddingTop())) + f;
        this.itemBorderRect.set(f2, scrollY, f3, (((float) this.otpViewItemHeight) + scrollY) - ((float) this.lineWidth));
    }

    private void drawText(Canvas canvas, int i) {
        Paint paintByIndex = getPaintByIndex(i);
        paintByIndex.setColor(getCurrentTextColor());
        if (this.rtlTextDirection) {
            int i2 = this.otpViewItemCount - i;
            if (getText() != null) {
                i2 -= getText().length();
            }
            if (i2 <= 0 && getText() != null) {
                drawTextAtBox(canvas, paintByIndex, getText(), Math.abs(i2));
            }
        } else if (getText() != null) {
            drawTextAtBox(canvas, paintByIndex, getText(), i);
        }
    }

    private void drawMaskingText(Canvas canvas, int i, String str) {
        Paint paintByIndex = getPaintByIndex(i);
        paintByIndex.setColor(getCurrentTextColor());
        if (this.rtlTextDirection) {
            int i2 = this.otpViewItemCount - i;
            if (getText() != null) {
                i2 -= getText().length();
            }
            if (i2 <= 0 && getText() != null) {
                drawTextAtBox(canvas, paintByIndex, getText().toString().replaceAll(".", str), Math.abs(i2));
            }
        } else if (getText() != null) {
            drawTextAtBox(canvas, paintByIndex, getText().toString().replaceAll(".", str), i);
        }
    }

    private void drawHint(Canvas canvas, int i) {
        Paint paintByIndex = getPaintByIndex(i);
        paintByIndex.setColor(getCurrentHintTextColor());
        if (this.rtlTextDirection) {
            int length = (this.otpViewItemCount - i) - getHint().length();
            if (length <= 0) {
                drawTextAtBox(canvas, paintByIndex, getHint(), Math.abs(length));
                return;
            }
            return;
        }
        drawTextAtBox(canvas, paintByIndex, getHint(), i);
    }

    private void drawTextAtBox(Canvas canvas, Paint paint2, CharSequence charSequence, int i) {
        int i2 = i + 1;
        paint2.getTextBounds(charSequence.toString(), i, i2, this.textRect);
        float f = this.itemCenterPoint.x;
        float f2 = this.itemCenterPoint.y;
        float abs = (f - (Math.abs((float) this.textRect.width()) / 2.0f)) - ((float) this.textRect.left);
        float abs2 = (f2 + (Math.abs((float) this.textRect.height()) / 2.0f)) - ((float) this.textRect.bottom);
        if (this.isAllCaps) {
            canvas.drawText(charSequence.toString().toUpperCase(), i, i2, abs, abs2, paint2);
        } else {
            canvas.drawText(charSequence, i, i2, abs, abs2, paint2);
        }
    }

    private void drawCircle(Canvas canvas, int i) {
        Paint paintByIndex = getPaintByIndex(i);
        float f = this.itemCenterPoint.x;
        float f2 = this.itemCenterPoint.y;
        if (!this.rtlTextDirection) {
            canvas.drawCircle(f, f2, paintByIndex.getTextSize() / 2.0f, paintByIndex);
        } else if ((this.otpViewItemCount - i) - getHint().length() <= 0) {
            canvas.drawCircle(f, f2, paintByIndex.getTextSize() / 2.0f, paintByIndex);
        }
    }

    private Paint getPaintByIndex(int i) {
        if (getText() == null || !this.isAnimationEnable || i != getText().length() - 1) {
            return getPaint();
        }
        this.animatorTextPaint.setColor(getPaint().getColor());
        return this.animatorTextPaint;
    }

    private void drawAnchorLine(Canvas canvas) {
        float f = this.itemCenterPoint.x;
        float f2 = this.itemCenterPoint.y;
        this.paint.setStrokeWidth(1.0f);
        float strokeWidth = f - (this.paint.getStrokeWidth() / 2.0f);
        float strokeWidth2 = f2 - (this.paint.getStrokeWidth() / 2.0f);
        this.path.reset();
        this.path.moveTo(strokeWidth, this.itemBorderRect.top);
        this.path.lineTo(strokeWidth, this.itemBorderRect.top + Math.abs(this.itemBorderRect.height()));
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
        this.path.moveTo(this.itemBorderRect.left, strokeWidth2);
        this.path.lineTo(this.itemBorderRect.left + Math.abs(this.itemBorderRect.width()), strokeWidth2);
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
        this.paint.setStrokeWidth((float) this.lineWidth);
    }

    private void updateColors() {
        int i;
        ColorStateList colorStateList = this.lineColor;
        boolean z = false;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(getDrawableState(), 0);
        } else {
            i = getCurrentTextColor();
        }
        if (i != this.cursorLineColor) {
            this.cursorLineColor = i;
            z = true;
        }
        if (z) {
            invalidate();
        }
    }

    private void updateCenterPoint() {
        this.itemCenterPoint.set(this.itemBorderRect.left + (Math.abs(this.itemBorderRect.width()) / 2.0f), this.itemBorderRect.top + (Math.abs(this.itemBorderRect.height()) / 2.0f));
    }

    /* access modifiers changed from: protected */
    public MovementMethod getDefaultMovementMethod() {
        return DefaultMovementMethod.getInstance();
    }

    public void setLineColor(int i) {
        this.lineColor = ColorStateList.valueOf(i);
        updateColors();
    }

    public void setLineColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.lineColor = colorStateList;
            updateColors();
            return;
        }
        throw new IllegalArgumentException("Color cannot be null");
    }

    public ColorStateList getLineColors() {
        return this.lineColor;
    }

    public int getCurrentLineColor() {
        return this.cursorLineColor;
    }

    public void setLineWidth(int i) {
        this.lineWidth = i;
        checkItemRadius();
        requestLayout();
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public void setItemCount(int i) {
        this.otpViewItemCount = i;
        setMaxLength(i);
        requestLayout();
    }

    public int getItemCount() {
        return this.otpViewItemCount;
    }

    public void setItemRadius(int i) {
        this.otpViewItemRadius = i;
        checkItemRadius();
        requestLayout();
    }

    public int getItemRadius() {
        return this.otpViewItemRadius;
    }

    public void setItemSpacing(int i) {
        this.otpViewItemSpacing = i;
        requestLayout();
    }

    public int getItemSpacing() {
        return this.otpViewItemSpacing;
    }

    public void setItemHeight(int i) {
        this.otpViewItemHeight = i;
        updateCursorHeight();
        requestLayout();
    }

    public int getItemHeight() {
        return this.otpViewItemHeight;
    }

    public void setItemWidth(int i) {
        this.otpViewItemWidth = i;
        checkItemRadius();
        requestLayout();
    }

    public int getItemWidth() {
        return this.otpViewItemWidth;
    }

    public void setAnimationEnable(boolean z) {
        this.isAnimationEnable = z;
    }

    public void setHideLineWhenFilled(boolean z) {
        this.hideLineWhenFilled = z;
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        updateCursorHeight();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        updateCursorHeight();
    }

    public void setOtpCompletionListener(OnOtpCompletionListener onOtpCompletionListener2) {
        this.onOtpCompletionListener = onOtpCompletionListener2;
    }

    public void setItemBackgroundResources(int i) {
        if (i == 0 || this.itemBackgroundResource == i) {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), i, getContext().getTheme());
            this.itemBackground = drawable;
            setItemBackground(drawable);
            this.itemBackgroundResource = i;
        }
    }

    public void setItemBackgroundColor(int i) {
        Drawable drawable = this.itemBackground;
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable.mutate()).setColor(i);
            this.itemBackgroundResource = 0;
            return;
        }
        setItemBackground(new ColorDrawable(i));
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackgroundResource = 0;
        this.itemBackground = drawable;
        invalidate();
    }

    public void setCursorWidth(int i) {
        this.cursorWidth = i;
        if (isCursorVisible()) {
            invalidateCursor(true);
        }
    }

    public int getCursorWidth() {
        return this.cursorWidth;
    }

    public void setCursorColor(int i) {
        this.cursorColor = i;
        if (isCursorVisible()) {
            invalidateCursor(true);
        }
    }

    public int getCursorColor() {
        return this.cursorColor;
    }

    public void setMaskingChar(String str) {
        this.maskingChar = str;
        requestLayout();
    }

    public String getMaskingChar() {
        return this.maskingChar;
    }

    public void setCursorVisible(boolean z) {
        if (this.isCursorVisible != z) {
            this.isCursorVisible = z;
            invalidateCursor(z);
            makeBlink();
        }
    }

    public boolean isCursorVisible() {
        return this.isCursorVisible;
    }

    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (i == 1) {
            resumeBlink();
        } else if (i == 0) {
            suspendBlink();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeBlink();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        suspendBlink();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean shouldBlink() {
        return isCursorVisible() && isFocused();
    }

    private void makeBlink() {
        if (shouldBlink()) {
            if (this.blink == null) {
                this.blink = new Blink();
            }
            removeCallbacks(this.blink);
            this.drawCursor = false;
            postDelayed(this.blink, 500);
            return;
        }
        Blink blink2 = this.blink;
        if (blink2 != null) {
            removeCallbacks(blink2);
        }
    }

    private void suspendBlink() {
        Blink blink2 = this.blink;
        if (blink2 != null) {
            blink2.cancel();
            invalidateCursor(false);
        }
    }

    private void resumeBlink() {
        Blink blink2 = this.blink;
        if (blink2 != null) {
            blink2.unCancel();
            makeBlink();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invalidateCursor(boolean z) {
        if (this.drawCursor != z) {
            this.drawCursor = z;
            invalidate();
        }
    }

    private void updateCursorHeight() {
        float dpToPx = (float) (dpToPx() * 2);
        this.cursorHeight = ((float) this.otpViewItemHeight) - getTextSize() > dpToPx ? getTextSize() + dpToPx : getTextSize();
    }

    /* access modifiers changed from: private */
    public class Blink implements Runnable {
        private boolean cancelled;

        private Blink() {
        }

        public void run() {
            if (!this.cancelled) {
                OtpView.this.removeCallbacks(this);
                if (OtpView.this.shouldBlink()) {
                    OtpView otpView = OtpView.this;
                    otpView.invalidateCursor(!otpView.drawCursor);
                    OtpView.this.postDelayed(this, 500);
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void cancel() {
            if (!this.cancelled) {
                OtpView.this.removeCallbacks(this);
                this.cancelled = true;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void unCancel() {
            this.cancelled = false;
        }
    }

    private int dpToPx() {
        return (int) ((getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }
}
