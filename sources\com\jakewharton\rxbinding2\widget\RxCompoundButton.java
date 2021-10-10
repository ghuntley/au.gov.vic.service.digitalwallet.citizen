package com.jakewharton.rxbinding2.widget;

import android.widget.CompoundButton;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxCompoundButton {
    public static InitialValueObservable<Boolean> checkedChanges(CompoundButton compoundButton) {
        Preconditions.checkNotNull(compoundButton, "view == null");
        return new CompoundButtonCheckedChangeObservable(compoundButton);
    }

    @Deprecated
    public static Consumer<? super Boolean> checked(CompoundButton compoundButton) {
        Preconditions.checkNotNull(compoundButton, "view == null");
        compoundButton.getClass();
        return new Consumer(compoundButton) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$Zmqbl6geWJsZkaaQkgMZLD9o8 */
            public final /* synthetic */ CompoundButton f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setChecked(((Boolean) obj).booleanValue());
            }
        };
    }

    public static Consumer<? super Object> toggle(CompoundButton compoundButton) {
        Preconditions.checkNotNull(compoundButton, "view == null");
        return new Consumer(compoundButton) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$RxCompoundButton$wK4UCKl3DaT00Lghdifj_dJIC0 */
            public final /* synthetic */ CompoundButton f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxCompoundButton.lambda$toggle$0(this.f$0, obj);
            }
        };
    }

    private RxCompoundButton() {
        throw new AssertionError("No instances.");
    }
}
