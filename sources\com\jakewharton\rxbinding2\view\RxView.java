package com.jakewharton.rxbinding2.view;

import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

public final class RxView {
    public static Observable<Object> attaches(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewAttachesObservable(view, true);
    }

    public static Observable<ViewAttachEvent> attachEvents(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewAttachEventObservable(view);
    }

    public static Observable<Object> detaches(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewAttachesObservable(view, false);
    }

    public static Observable<Object> clicks(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewClickObservable(view);
    }

    public static Observable<DragEvent> drags(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewDragObservable(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<DragEvent> drags(View view, Predicate<? super DragEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new ViewDragObservable(view, predicate);
    }

    public static Observable<Object> draws(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewTreeObserverDrawObservable(view);
    }

    public static InitialValueObservable<Boolean> focusChanges(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewFocusChangeObservable(view);
    }

    public static Observable<Object> globalLayouts(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewTreeObserverGlobalLayoutObservable(view);
    }

    public static Observable<MotionEvent> hovers(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewHoverObservable(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<MotionEvent> hovers(View view, Predicate<? super MotionEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new ViewHoverObservable(view, predicate);
    }

    public static Observable<Object> layoutChanges(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewLayoutChangeObservable(view);
    }

    public static Observable<ViewLayoutChangeEvent> layoutChangeEvents(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewLayoutChangeEventObservable(view);
    }

    public static Observable<Object> longClicks(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewLongClickObservable(view, Functions.CALLABLE_ALWAYS_TRUE);
    }

    public static Observable<Object> longClicks(View view, Callable<Boolean> callable) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(callable, "handled == null");
        return new ViewLongClickObservable(view, callable);
    }

    public static Observable<Object> preDraws(View view, Callable<Boolean> callable) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(callable, "proceedDrawingPass == null");
        return new ViewTreeObserverPreDrawObservable(view, callable);
    }

    public static Observable<ViewScrollChangeEvent> scrollChangeEvents(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewScrollChangeEventObservable(view);
    }

    public static Observable<Integer> systemUiVisibilityChanges(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewSystemUiVisibilityChangeObservable(view);
    }

    public static Observable<MotionEvent> touches(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewTouchObservable(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<MotionEvent> touches(View view, Predicate<? super MotionEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new ViewTouchObservable(view, predicate);
    }

    public static Observable<KeyEvent> keys(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewKeyObservable(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<KeyEvent> keys(View view, Predicate<? super KeyEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new ViewKeyObservable(view, predicate);
    }

    @Deprecated
    public static Consumer<? super Boolean> activated(View view) {
        Preconditions.checkNotNull(view, "view == null");
        view.getClass();
        return new Consumer(view) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$2wSKS1W8lTDfwjphSRc7ETKZEPo */
            public final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setActivated(((Boolean) obj).booleanValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Boolean> clickable(View view) {
        Preconditions.checkNotNull(view, "view == null");
        view.getClass();
        return new Consumer(view) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$hrSYLJQPd9V4lvSghjEbvIpWj2A */
            public final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setClickable(((Boolean) obj).booleanValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Boolean> enabled(View view) {
        Preconditions.checkNotNull(view, "view == null");
        view.getClass();
        return new Consumer(view) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$FkomRFtttY_jw_s2W2HRNrevyE */
            public final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setEnabled(((Boolean) obj).booleanValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Boolean> pressed(View view) {
        Preconditions.checkNotNull(view, "view == null");
        view.getClass();
        return new Consumer(view) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$TcSmAgf81eJzs8tLJmKT76zBzNE */
            public final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setPressed(((Boolean) obj).booleanValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Boolean> selected(View view) {
        Preconditions.checkNotNull(view, "view == null");
        view.getClass();
        return new Consumer(view) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$9r6ZdfEuzIFMfrxCryaxUVt8Ui0 */
            public final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setSelected(((Boolean) obj).booleanValue());
            }
        };
    }

    public static Consumer<? super Boolean> visibility(View view) {
        Preconditions.checkNotNull(view, "view == null");
        return visibility(view, 8);
    }

    public static Consumer<? super Boolean> visibility(View view, int i) {
        Preconditions.checkNotNull(view, "view == null");
        if (i == 0) {
            throw new IllegalArgumentException("Setting visibility to VISIBLE when false would have no effect.");
        } else if (i == 4 || i == 8) {
            return new Consumer(view, i) {
                /* class com.jakewharton.rxbinding2.view.$$Lambda$RxView$tBPS4QAD9l3NWtAUkwePQwk2STY */
                public final /* synthetic */ View f$0;
                public final /* synthetic */ int f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RxView.lambda$visibility$0(this.f$0, this.f$1, (Boolean) obj);
                }
            };
        } else {
            throw new IllegalArgumentException("Must set visibility to INVISIBLE or GONE when false.");
        }
    }

    static /* synthetic */ void lambda$visibility$0(View view, int i, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            i = 0;
        }
        view.setVisibility(i);
    }

    private RxView() {
        throw new AssertionError("No instances.");
    }
}
