package com.jakewharton.rxbinding2.support.v4.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding2.internal.Preconditions;
import com.jakewharton.rxbinding2.view.MenuItemActionViewEvent;
import com.jakewharton.rxbinding2.view.RxMenuItem;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

@Deprecated
public final class RxMenuItemCompat {
    @Deprecated
    public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return RxMenuItem.actionViewEvents(menuItem);
    }

    @Deprecated
    public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem menuItem, Predicate<? super MenuItemActionViewEvent> predicate) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return RxMenuItem.actionViewEvents(menuItem, predicate);
    }

    private RxMenuItemCompat() {
        throw new AssertionError("No instances.");
    }
}
