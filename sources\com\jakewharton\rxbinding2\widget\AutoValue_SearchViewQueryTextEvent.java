package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import java.util.Objects;

/* access modifiers changed from: package-private */
public final class AutoValue_SearchViewQueryTextEvent extends SearchViewQueryTextEvent {
    private final boolean isSubmitted;
    private final CharSequence queryText;
    private final SearchView view;

    AutoValue_SearchViewQueryTextEvent(SearchView searchView, CharSequence charSequence, boolean z) {
        Objects.requireNonNull(searchView, "Null view");
        this.view = searchView;
        Objects.requireNonNull(charSequence, "Null queryText");
        this.queryText = charSequence;
        this.isSubmitted = z;
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    public SearchView view() {
        return this.view;
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    public CharSequence queryText() {
        return this.queryText;
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    public boolean isSubmitted() {
        return this.isSubmitted;
    }

    public String toString() {
        return "SearchViewQueryTextEvent{view=" + this.view + ", queryText=" + ((Object) this.queryText) + ", isSubmitted=" + this.isSubmitted + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchViewQueryTextEvent)) {
            return false;
        }
        SearchViewQueryTextEvent searchViewQueryTextEvent = (SearchViewQueryTextEvent) obj;
        return this.view.equals(searchViewQueryTextEvent.view()) && this.queryText.equals(searchViewQueryTextEvent.queryText()) && this.isSubmitted == searchViewQueryTextEvent.isSubmitted();
    }

    public int hashCode() {
        return ((((this.view.hashCode() ^ 1000003) * 1000003) ^ this.queryText.hashCode()) * 1000003) ^ (this.isSubmitted ? 1231 : 1237);
    }
}
