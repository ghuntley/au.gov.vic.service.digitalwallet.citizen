package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public final class RxTextView {
    public static Observable<Integer> editorActions(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return editorActions(textView, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<Integer> editorActions(TextView textView, Predicate<? super Integer> predicate) {
        Preconditions.checkNotNull(textView, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new TextViewEditorActionObservable(textView, predicate);
    }

    public static Observable<TextViewEditorActionEvent> editorActionEvents(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return editorActionEvents(textView, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<TextViewEditorActionEvent> editorActionEvents(TextView textView, Predicate<? super TextViewEditorActionEvent> predicate) {
        Preconditions.checkNotNull(textView, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new TextViewEditorActionEventObservable(textView, predicate);
    }

    public static InitialValueObservable<CharSequence> textChanges(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new TextViewTextObservable(textView);
    }

    public static InitialValueObservable<TextViewTextChangeEvent> textChangeEvents(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new TextViewTextChangeEventObservable(textView);
    }

    public static InitialValueObservable<TextViewBeforeTextChangeEvent> beforeTextChangeEvents(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new TextViewBeforeTextChangeEventObservable(textView);
    }

    public static InitialValueObservable<TextViewAfterTextChangeEvent> afterTextChangeEvents(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new TextViewAfterTextChangeEventObservable(textView);
    }

    @Deprecated
    public static Consumer<? super CharSequence> text(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        textView.getClass();
        return new Consumer(textView) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$utKc67gVrgqHkBkFWHBnEDli_8 */
            public final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setText((CharSequence) obj);
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> textRes(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        textView.getClass();
        return new Consumer(textView) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$PkT1AHweQ6_5xqgvKgDASubwmg */
            public final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setText(((Integer) obj).intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super CharSequence> error(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        textView.getClass();
        return new Consumer(textView) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$MaUoJitx8yK0tStmvRO2fL_pKqM */
            public final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setError((CharSequence) obj);
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> errorRes(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        return new Consumer(textView) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$RxTextView$FXL4RZEoo3U8WXN60Rfi8o9Cc */
            public final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxTextView.lambda$errorRes$0(this.f$0, (Integer) obj);
            }
        };
    }

    @Deprecated
    public static Consumer<? super CharSequence> hint(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        textView.getClass();
        return new Consumer(textView) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$bn2X4OswG6IlY7yyLyuISg1Xnw */
            public final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setHint((CharSequence) obj);
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> hintRes(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        textView.getClass();
        return new Consumer(textView) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$uDtbmhGf_ZwYWJj2AHqrzl2mKDw */
            public final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setHint(((Integer) obj).intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> color(TextView textView) {
        Preconditions.checkNotNull(textView, "view == null");
        textView.getClass();
        return new Consumer(textView) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$96PSJICVipp_h6O3CJFKcK4SQU */
            public final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setTextColor(((Integer) obj).intValue());
            }
        };
    }

    private RxTextView() {
        throw new AssertionError("No instances.");
    }
}
