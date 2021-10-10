package com.digitalwallet.view.checkIn.checkInShortcut;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.model.P2PMessage;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J(\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J \u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0016R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/HeaderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "shouldFadeOutHeader", "", "isHeader", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "itemPosition", "(Landroidx/recyclerview/widget/RecyclerView;ZLkotlin/jvm/functions/Function1;)V", "currentHeader", "Lkotlin/Pair;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "drawHeader", "", "c", "Landroid/graphics/Canvas;", P2PMessage.headerKey, "Landroid/view/View;", "paddingTop", "fixLayoutSize", "Landroid/view/ViewGroup;", Promotion.ACTION_VIEW, "getChildInContact", "contactPoint", "getHeaderPositionForItem", "getHeaderViewForItem", "moveHeader", "nextHeader", "onDrawOver", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HeaderItemDecoration.kt */
public final class HeaderItemDecoration extends RecyclerView.ItemDecoration {
    private Pair<Integer, ? extends RecyclerView.ViewHolder> currentHeader;
    private final Function1<Integer, Boolean> isHeader;
    private final boolean shouldFadeOutHeader;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderItemDecoration(RecyclerView recyclerView, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? false : z, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public HeaderItemDecoration(RecyclerView recyclerView, boolean z, Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(function1, "isHeader");
        this.shouldFadeOutHeader = z;
        this.isHeader = function1;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) {
                /* class com.digitalwallet.view.checkIn.checkInShortcut.HeaderItemDecoration.AnonymousClass1 */
                final /* synthetic */ HeaderItemDecoration this$0;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.this$0 = r1;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    this.this$0.currentHeader = null;
                }
            });
        }
        recyclerView.addOnLayoutChangeListener(new HeaderItemDecoration$$special$$inlined$doOnEachNextLayout$1(this));
        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(this) {
            /* class com.digitalwallet.view.checkIn.checkInShortcut.HeaderItemDecoration.AnonymousClass3 */
            final /* synthetic */ HeaderItemDecoration this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener, androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                RecyclerView.ViewHolder viewHolder;
                View view;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                float y = motionEvent.getY();
                Pair pair = this.this$0.currentHeader;
                if (y <= ((float) ((pair == null || (viewHolder = (RecyclerView.ViewHolder) pair.getSecond()) == null || (view = viewHolder.itemView) == null) ? 0 : view.getBottom()))) {
                    return true;
                }
                return false;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition;
        View headerViewForItem;
        View childInContact;
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) != -1 && (headerViewForItem = getHeaderViewForItem(childAdapterPosition, recyclerView)) != null && (childInContact = getChildInContact(recyclerView, headerViewForItem.getBottom() + recyclerView.getPaddingTop())) != null) {
            if (this.isHeader.invoke(Integer.valueOf(recyclerView.getChildAdapterPosition(childInContact))).booleanValue()) {
                moveHeader(canvas, headerViewForItem, childInContact, recyclerView.getPaddingTop());
            } else {
                drawHeader(canvas, headerViewForItem, recyclerView.getPaddingTop());
            }
        }
    }

    private final View getHeaderViewForItem(int i, RecyclerView recyclerView) {
        int headerPositionForItem;
        RecyclerView.Adapter adapter;
        Pair<Integer, ? extends RecyclerView.ViewHolder> pair;
        RecyclerView.ViewHolder viewHolder;
        RecyclerView.ViewHolder viewHolder2;
        if (recyclerView.getAdapter() == null || (headerPositionForItem = getHeaderPositionForItem(i)) == -1 || (adapter = recyclerView.getAdapter()) == null) {
            return null;
        }
        int itemViewType = adapter.getItemViewType(headerPositionForItem);
        Pair<Integer, ? extends RecyclerView.ViewHolder> pair2 = this.currentHeader;
        if (pair2 == null || pair2.getFirst().intValue() != headerPositionForItem || (pair = this.currentHeader) == null || (viewHolder = (RecyclerView.ViewHolder) pair.getSecond()) == null || viewHolder.getItemViewType() != itemViewType) {
            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
            RecyclerView.ViewHolder createViewHolder = adapter2 != null ? adapter2.createViewHolder(recyclerView, itemViewType) : null;
            if (createViewHolder != null) {
                RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
                if (adapter3 != null) {
                    adapter3.onBindViewHolder(createViewHolder, headerPositionForItem);
                }
                View view = createViewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "headerHolder.itemView");
                fixLayoutSize(recyclerView, view);
                this.currentHeader = TuplesKt.to(Integer.valueOf(headerPositionForItem), createViewHolder);
            }
            if (createViewHolder != null) {
                return createViewHolder.itemView;
            }
            return null;
        }
        Pair<Integer, ? extends RecyclerView.ViewHolder> pair3 = this.currentHeader;
        if (pair3 == null || (viewHolder2 = (RecyclerView.ViewHolder) pair3.getSecond()) == null) {
            return null;
        }
        return viewHolder2.itemView;
    }

    private final void drawHeader(Canvas canvas, View view, int i) {
        canvas.save();
        canvas.translate(0.0f, (float) i);
        view.draw(canvas);
        canvas.restore();
    }

    private final void moveHeader(Canvas canvas, View view, View view2, int i) {
        canvas.save();
        if (!this.shouldFadeOutHeader) {
            canvas.clipRect(0, i, canvas.getWidth(), view.getHeight() + i);
        } else if (Build.VERSION.SDK_INT >= 21) {
            canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), (int) ((((float) (view2.getTop() - i)) / ((float) view2.getHeight())) * ((float) 255)));
        } else {
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((((float) (view2.getTop() - i)) / ((float) view2.getHeight())) * ((float) 255)), 31);
        }
        canvas.translate(0.0f, (float) (view2.getTop() - view.getHeight()));
        view.draw(canvas);
        if (this.shouldFadeOutHeader) {
            canvas.restore();
        }
        canvas.restore();
    }

    private final View getChildInContact(RecyclerView recyclerView, int i) {
        View view = null;
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            Rect rect = new Rect();
            recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
            if (rect.bottom > i && rect.top <= i) {
                return childAt;
            }
        }
        return view;
    }

    private final void fixLayoutSize(ViewGroup viewGroup, View view) {
        view.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(viewGroup.getHeight(), 0), viewGroup.getPaddingTop() + viewGroup.getPaddingBottom(), view.getLayoutParams().height));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private final int getHeaderPositionForItem(int i) {
        while (!this.isHeader.invoke(Integer.valueOf(i)).booleanValue()) {
            i--;
            if (i < 0) {
                return -1;
            }
        }
        return i;
    }
}
