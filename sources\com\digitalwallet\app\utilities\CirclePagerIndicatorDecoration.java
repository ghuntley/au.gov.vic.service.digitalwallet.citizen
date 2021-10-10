package com.digitalwallet.app.utilities;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J(\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/utilities/CirclePagerIndicatorDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "cardViewHeight", "", "colorActive", "", "colorInactive", "indicatorItemLength", "indicatorItemPadding", "interpolator", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "paint", "Landroid/graphics/Paint;", "drawHighlights", "", "c", "Landroid/graphics/Canvas;", "indicatorStartX", "indicatorPosY", "highlightPosition", NotificationCompat.CATEGORY_PROGRESS, "drawInactiveIndicators", "itemCount", "onDrawOver", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CirclePagerIndicatorDecoration.kt */
public final class CirclePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    public static final Companion Companion = new Companion(null);
    private final float cardViewHeight;
    private final int colorActive = Color.parseColor("#3b4a60");
    private final int colorInactive = Color.parseColor("#403b4a60");
    private final float indicatorItemLength;
    private final float indicatorItemPadding;
    private final AccelerateDecelerateInterpolator interpolator;
    private final Paint paint;

    public CirclePagerIndicatorDecoration() {
        Companion companion = Companion;
        this.cardViewHeight = companion.toDp(242);
        this.indicatorItemLength = companion.toDp(4);
        this.indicatorItemPadding = companion.toDp(8);
        this.interpolator = new AccelerateDecelerateInterpolator();
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(companion.toDp(4));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.paint = paint2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        int i = 0;
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        float width = (((float) recyclerView.getWidth()) - ((this.indicatorItemLength * ((float) itemCount)) + (((float) Math.max(0, itemCount - 1)) * this.indicatorItemPadding))) / 2.0f;
        float f = this.cardViewHeight;
        drawInactiveIndicators(canvas, width, f, itemCount);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition != -1) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            int left = findViewByPosition != null ? findViewByPosition.getLeft() : 0;
            if (findViewByPosition != null) {
                i = findViewByPosition.getWidth();
            }
            drawHighlights(canvas, width, f, findFirstVisibleItemPosition, this.interpolator.getInterpolation(((float) (left * -1)) / ((float) i)));
        }
    }

    private final void drawInactiveIndicators(Canvas canvas, float f, float f2, int i) {
        this.paint.setColor(this.colorInactive);
        float f3 = this.indicatorItemLength + this.indicatorItemPadding;
        for (int i2 = 0; i2 < i; i2++) {
            canvas.drawCircle(f, f2, this.indicatorItemLength / 2.0f, this.paint);
            f += f3;
        }
    }

    private final void drawHighlights(Canvas canvas, float f, float f2, int i, float f3) {
        this.paint.setColor(this.colorActive);
        float f4 = this.indicatorItemLength;
        float f5 = this.indicatorItemPadding;
        float f6 = f4 + f5;
        if (f3 == 0.0f) {
            canvas.drawCircle(f + (f6 * ((float) i)), f2, f4 / 2.0f, this.paint);
        } else {
            canvas.drawCircle(f + (f6 * ((float) i)) + (f4 * f3) + (f5 * f3), f2, f4 / 2.0f, this.paint);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/utilities/CirclePagerIndicatorDecoration$Companion;", "", "()V", "toDp", "", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CirclePagerIndicatorDecoration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final float toDp(int i) {
            Resources system = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
            return ((float) i) * system.getDisplayMetrics().density;
        }
    }
}
