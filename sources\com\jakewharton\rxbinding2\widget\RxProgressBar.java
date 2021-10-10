package com.jakewharton.rxbinding2.widget;

import android.widget.ProgressBar;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxProgressBar {
    @Deprecated
    public static Consumer<? super Integer> incrementProgressBy(ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        progressBar.getClass();
        return new Consumer(progressBar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$dWaJC7HYCFgMBqOtgJW99YOwgcg */
            public final /* synthetic */ ProgressBar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.incrementProgressBy(((Integer) obj).intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> incrementSecondaryProgressBy(ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        progressBar.getClass();
        return new Consumer(progressBar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$KWD2r8GMYOPOjzPbLOtzqoT8UMA */
            public final /* synthetic */ ProgressBar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.incrementSecondaryProgressBy(((Integer) obj).intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Boolean> indeterminate(ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        progressBar.getClass();
        return new Consumer(progressBar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$__s1c4Iv2Llk6zuoJyJKSUcls */
            public final /* synthetic */ ProgressBar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setIndeterminate(((Boolean) obj).booleanValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> max(ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        progressBar.getClass();
        return new Consumer(progressBar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$_8pGpFODdE4haIVxA5G77DgAnxA */
            public final /* synthetic */ ProgressBar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setMax(((Integer) obj).intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> progress(ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        progressBar.getClass();
        return new Consumer(progressBar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$HHpJwd4QXDwpRCXnwMOpSfw5fo4 */
            public final /* synthetic */ ProgressBar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setProgress(((Integer) obj).intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> secondaryProgress(ProgressBar progressBar) {
        Preconditions.checkNotNull(progressBar, "view == null");
        progressBar.getClass();
        return new Consumer(progressBar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$UDrluSI4aOE5kHAgh_PBI80uKIo */
            public final /* synthetic */ ProgressBar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setSecondaryProgress(((Integer) obj).intValue());
            }
        };
    }

    private RxProgressBar() {
        throw new AssertionError("No instances.");
    }
}
