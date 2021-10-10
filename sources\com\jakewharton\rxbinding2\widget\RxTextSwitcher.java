package com.jakewharton.rxbinding2.widget;

import android.widget.TextSwitcher;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxTextSwitcher {
    @Deprecated
    public static Consumer<? super CharSequence> text(TextSwitcher textSwitcher) {
        Preconditions.checkNotNull(textSwitcher, "view == null");
        textSwitcher.getClass();
        return new Consumer(textSwitcher) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$GJlNNFsYnbGffM0c_UN9ONA */
            public final /* synthetic */ TextSwitcher f$0;

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
    public static Consumer<? super CharSequence> currentText(TextSwitcher textSwitcher) {
        Preconditions.checkNotNull(textSwitcher, "view == null");
        textSwitcher.getClass();
        return new Consumer(textSwitcher) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$zXPdTO8ww5uZdT0TTfRU2ZmjayY */
            public final /* synthetic */ TextSwitcher f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setCurrentText((CharSequence) obj);
            }
        };
    }

    private RxTextSwitcher() {
        throw new AssertionError("No instances.");
    }
}
