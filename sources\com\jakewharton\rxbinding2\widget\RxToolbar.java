package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public final class RxToolbar {
    public static Observable<MenuItem> itemClicks(Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new ToolbarItemClickObservable(toolbar);
    }

    public static Observable<Object> navigationClicks(Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new ToolbarNavigationClickObservable(toolbar);
    }

    @Deprecated
    public static Consumer<? super CharSequence> title(Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        toolbar.getClass();
        return new Consumer(toolbar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$UdwHu8X1uE8u9nLIht9U_XbyuvA */
            public final /* synthetic */ Toolbar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setTitle((CharSequence) obj);
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> titleRes(Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        toolbar.getClass();
        return new Consumer(toolbar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$5kMmerBw3yQ3AffEmYPkY8m1cG8 */
            public final /* synthetic */ Toolbar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setTitle(((Integer) obj).intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super CharSequence> subtitle(Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        toolbar.getClass();
        return new Consumer(toolbar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$Gu9pyuGS5w7C1Stseww3kKWbAN8 */
            public final /* synthetic */ Toolbar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setSubtitle((CharSequence) obj);
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> subtitleRes(Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        toolbar.getClass();
        return new Consumer(toolbar) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$w6my4rwHQHzgqlh7gthzbmgFSk */
            public final /* synthetic */ Toolbar f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setSubtitle(((Integer) obj).intValue());
            }
        };
    }

    private RxToolbar() {
        throw new AssertionError("No instances.");
    }
}
