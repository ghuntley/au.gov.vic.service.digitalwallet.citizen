package com.jakewharton.rxbinding2.widget;

import android.widget.RadioGroup;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxRadioGroup {
    public static InitialValueObservable<Integer> checkedChanges(RadioGroup radioGroup) {
        Preconditions.checkNotNull(radioGroup, "view == null");
        return new RadioGroupCheckedChangeObservable(radioGroup);
    }

    public static Consumer<? super Integer> checked(RadioGroup radioGroup) {
        Preconditions.checkNotNull(radioGroup, "view == null");
        return new Consumer(radioGroup) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$RxRadioGroup$rUwulPpYdeLR44tFBjgpxVLpD0 */
            public final /* synthetic */ RadioGroup f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxRadioGroup.lambda$checked$0(this.f$0, (Integer) obj);
            }
        };
    }

    static /* synthetic */ void lambda$checked$0(RadioGroup radioGroup, Integer num) throws Exception {
        if (num.intValue() == -1) {
            radioGroup.clearCheck();
        } else {
            radioGroup.check(num.intValue());
        }
    }

    private RxRadioGroup() {
        throw new AssertionError("No instances.");
    }
}
