package com.digitalwallet.app.view.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.objectweb.asm.Opcodes;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/view/main/CardSwipeViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "flipCard", "Lkotlin/Function1;", "", "", "getFlipCard", "()Lkotlin/jvm/functions/Function1;", "setFlipCard", "(Lkotlin/jvm/functions/Function1;)V", "swipeStartPosition", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CardSwipeViewGroup.kt */
public final class CardSwipeViewGroup extends FrameLayout {
    private HashMap _$_findViewCache;
    private Function1<? super Boolean, Unit> flipCard;
    private float swipeStartPosition;

    public CardSwipeViewGroup(Context context) {
        this(context, null, 0, 6, null);
    }

    public CardSwipeViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
    public /* synthetic */ CardSwipeViewGroup(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardSwipeViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    public final Function1<Boolean, Unit> getFlipCard() {
        return this.flipCard;
    }

    public final void setFlipCard(Function1<? super Boolean, Unit> function1) {
        this.flipCard = function1;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.flipCard == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf == null || valueOf.intValue() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.swipeStartPosition = motionEvent.getX();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.flipCard == null) {
            return super.onTouchEvent(motionEvent);
        }
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.swipeStartPosition = motionEvent.getX();
            return true;
        } else if (valueOf == null || valueOf.intValue() != 1) {
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            float x = motionEvent.getX();
            if (Math.abs(x - this.swipeStartPosition) <= ((float) Opcodes.FCMPG)) {
                return true;
            }
            if (this.swipeStartPosition > x) {
                Function1<? super Boolean, Unit> function1 = this.flipCard;
                if (function1 == null) {
                    return true;
                }
                function1.invoke(true);
                return true;
            }
            Function1<? super Boolean, Unit> function12 = this.flipCard;
            if (function12 == null) {
                return true;
            }
            function12.invoke(false);
            return true;
        }
    }
}
