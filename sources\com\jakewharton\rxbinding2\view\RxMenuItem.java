package com.jakewharton.rxbinding2.view;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public final class RxMenuItem {
    public static Observable<Object> clicks(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new MenuItemClickOnSubscribe(menuItem, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<Object> clicks(MenuItem menuItem, Predicate<? super MenuItem> predicate) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new MenuItemClickOnSubscribe(menuItem, predicate);
    }

    public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new MenuItemActionViewEventObservable(menuItem, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem menuItem, Predicate<? super MenuItemActionViewEvent> predicate) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new MenuItemActionViewEventObservable(menuItem, predicate);
    }

    @Deprecated
    public static Consumer<? super Boolean> checked(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        menuItem.getClass();
        return new Consumer(menuItem) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$Iyi0mGjWzdH3ZWeJkOB2qlM3osc */
            public final /* synthetic */ MenuItem f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setChecked(((Boolean) obj).booleanValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Boolean> enabled(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        menuItem.getClass();
        return new Consumer(menuItem) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$KO9tUwjRVopxSn0_39DBGM6_2tg */
            public final /* synthetic */ MenuItem f$0;

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
    public static Consumer<? super Drawable> icon(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        menuItem.getClass();
        return new Consumer(menuItem) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$Y1yj4y0xQ8CANsDa1I6XC4h6ug4 */
            public final /* synthetic */ MenuItem f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setIcon((Drawable) obj);
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> iconRes(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        menuItem.getClass();
        return new Consumer(menuItem) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$WNCwVYM3rqiGT68iDeLqUPC_IM */
            public final /* synthetic */ MenuItem f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setIcon(((Integer) obj).intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super CharSequence> title(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        menuItem.getClass();
        return new Consumer(menuItem) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$5gpKEuxtIQ6O_WI77LL5ka7eI */
            public final /* synthetic */ MenuItem f$0;

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
    public static Consumer<? super Integer> titleRes(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        menuItem.getClass();
        return new Consumer(menuItem) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$BrzvWE6nzxImuHcpc0ofi3HGFsw */
            public final /* synthetic */ MenuItem f$0;

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
    public static Consumer<? super Boolean> visible(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        menuItem.getClass();
        return new Consumer(menuItem) {
            /* class com.jakewharton.rxbinding2.view.$$Lambda$0aCWgyQk4UUJ4w2Lng_a2Vq5TWg */
            public final /* synthetic */ MenuItem f$0;

            {
                this.f$0 = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setVisible(((Boolean) obj).booleanValue());
            }
        };
    }

    private RxMenuItem() {
        throw new AssertionError("No instances.");
    }
}
