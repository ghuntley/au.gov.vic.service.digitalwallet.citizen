package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

public final class RxSearchView {
    public static InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(SearchView searchView) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new SearchViewQueryTextChangeEventsObservable(searchView);
    }

    public static InitialValueObservable<CharSequence> queryTextChanges(SearchView searchView) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new SearchViewQueryTextChangesObservable(searchView);
    }

    public static Consumer<? super CharSequence> query(SearchView searchView, boolean z) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new Consumer(searchView, z) {
            /* class com.jakewharton.rxbinding2.widget.$$Lambda$RxSearchView$wC1TZVesGIVgc41jtENYs7BDHU */
            public final /* synthetic */ SearchView f$0;
            public final /* synthetic */ boolean f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxSearchView.lambda$query$0(this.f$0, this.f$1, (CharSequence) obj);
            }
        };
    }

    private RxSearchView() {
        throw new AssertionError("No instances.");
    }
}
