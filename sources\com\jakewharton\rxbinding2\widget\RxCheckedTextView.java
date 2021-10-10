package com.jakewharton.rxbinding2.widget;

import android.widget.CheckedTextView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxCheckedTextView {
    @Deprecated
    public static Consumer<? super Boolean> check(CheckedTextView checkedTextView) {
        Preconditions.checkNotNull(checkedTextView, "view == null");
        checkedTextView.getClass();
        return new Consumer(checkedTextView) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$I4ctKtezLzNDwfnlaJ26fpD10 */
            public final /* synthetic */ CheckedTextView f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setChecked(((Boolean) obj).booleanValue());
            }
        };
    }

    private RxCheckedTextView() {
        throw new AssertionError("No instances.");
    }
}
