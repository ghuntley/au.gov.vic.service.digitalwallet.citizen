package com.digitalwallet.view.checkIn.checkInShortcut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.ItemCheckInHistoryHeaderBinding;
import com.digitalwallet.databinding.ItemCheckInHistoryRowBinding;
import com.digitalwallet.databinding.LayoutCheckInHistorySearchBinding;
import com.digitalwallet.databinding.LayoutInfoBoxBinding;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.HistoryRowViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004%&'(B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\r\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\fJ\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\fH\u0016J\u0014\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fXD¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/HistoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onSearchQueryChange", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "compositeData", "", "", "historySearchLayoutId", "", "infoBoxTextId", "infoBoxViewType", "searchLayoutViewHolder", "Lcom/digitalwallet/view/checkIn/checkInShortcut/HistoryListAdapter$SearchLayoutViewHolder;", "searchLayoutViewType", "sectionHeaderViewType", "sectionRowViewType", "clearSearchFocus", "()Lkotlin/Unit;", "getItemCount", "getItemViewType", "position", "isItemASectionHeader", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateHistoryList", "newList", "", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/HistoryRowViewModel;", "HistoryHeaderViewHolder", "HistoryRowViewHolder", "InfoBoxViewHolder", "SearchLayoutViewHolder", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShortcutItemViewAdapters.kt */
public final class HistoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Object> compositeData = new ArrayList();
    private final int historySearchLayoutId = R.layout.layout_check_in_history_search;
    private final int infoBoxTextId = R.string.check_in_history_deletion_rules;
    private final int infoBoxViewType = R.layout.layout_info_box;
    private final Function1<String, Unit> onSearchQueryChange;
    private SearchLayoutViewHolder searchLayoutViewHolder;
    private final int searchLayoutViewType = R.layout.layout_check_in_history_search;
    private final int sectionHeaderViewType = R.layout.item_check_in_history_header;
    private final int sectionRowViewType = R.layout.item_check_in_history_row;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public HistoryListAdapter(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onSearchQueryChange");
        this.onSearchQueryChange = function1;
    }

    public final void updateHistoryList(List<HistoryRowViewModel> list) {
        HistoryRowViewModel historyRowViewModel;
        ObservableBoolean showDivider;
        ObservableBoolean showDivider2;
        Intrinsics.checkNotNullParameter(list, "newList");
        this.compositeData.clear();
        this.compositeData.add(Integer.valueOf(this.historySearchLayoutId));
        int i = 1;
        if (!list.isEmpty()) {
            HistoryRowViewModel historyRowViewModel2 = list.get(0);
            this.compositeData.add(historyRowViewModel2.getHistory().getDate());
            this.compositeData.add(historyRowViewModel2);
            int size = list.size();
            while (true) {
                historyRowViewModel = null;
                if (i >= size) {
                    break;
                }
                HistoryRowViewModel historyRowViewModel3 = list.get(i);
                if (!historyRowViewModel3.isSameDayAs(list.get(i - 1))) {
                    Object lastOrNull = CollectionsKt.lastOrNull((List) this.compositeData);
                    if (lastOrNull instanceof HistoryRowViewModel) {
                        historyRowViewModel = lastOrNull;
                    }
                    HistoryRowViewModel historyRowViewModel4 = (HistoryRowViewModel) historyRowViewModel;
                    if (!(historyRowViewModel4 == null || (showDivider2 = historyRowViewModel4.getShowDivider()) == null)) {
                        showDivider2.set(false);
                    }
                    this.compositeData.add(historyRowViewModel3.getHistory().getDate());
                }
                this.compositeData.add(historyRowViewModel3);
                i++;
            }
            Object lastOrNull2 = CollectionsKt.lastOrNull((List) this.compositeData);
            if (lastOrNull2 instanceof HistoryRowViewModel) {
                historyRowViewModel = lastOrNull2;
            }
            HistoryRowViewModel historyRowViewModel5 = historyRowViewModel;
            if (!(historyRowViewModel5 == null || (showDivider = historyRowViewModel5.getShowDivider()) == null)) {
                showDivider.set(false);
            }
        }
        this.compositeData.add(Integer.valueOf(this.infoBoxTextId));
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Object obj = this.compositeData.get(i);
        if (Intrinsics.areEqual(obj, Integer.valueOf(this.historySearchLayoutId))) {
            return this.searchLayoutViewType;
        }
        if (obj == null || (obj instanceof Date)) {
            return this.sectionHeaderViewType;
        }
        if (Intrinsics.areEqual(obj, Integer.valueOf(this.infoBoxTextId))) {
            return this.infoBoxViewType;
        }
        return this.sectionRowViewType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == this.searchLayoutViewType) {
            LayoutCheckInHistorySearchBinding inflate = LayoutCheckInHistorySearchBinding.inflate(from, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutCheckInHistorySear…tInflater, parent, false)");
            SearchLayoutViewHolder searchLayoutViewHolder2 = new SearchLayoutViewHolder(inflate);
            this.searchLayoutViewHolder = searchLayoutViewHolder2;
            return searchLayoutViewHolder2;
        } else if (i == this.sectionHeaderViewType) {
            ItemCheckInHistoryHeaderBinding inflate2 = ItemCheckInHistoryHeaderBinding.inflate(from, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "ItemCheckInHistoryHeader…tInflater, parent, false)");
            return new HistoryHeaderViewHolder(inflate2);
        } else if (i == this.infoBoxViewType) {
            LayoutInfoBoxBinding inflate3 = LayoutInfoBoxBinding.inflate(from, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "LayoutInfoBoxBinding.inf…tInflater, parent, false)");
            return new InfoBoxViewHolder(inflate3);
        } else {
            ItemCheckInHistoryRowBinding inflate4 = ItemCheckInHistoryRowBinding.inflate(from, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "ItemCheckInHistoryRowBin…tInflater, parent, false)");
            return new HistoryRowViewHolder(inflate4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.compositeData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Object obj = this.compositeData.get(i);
        if (Intrinsics.areEqual(obj, Integer.valueOf(this.historySearchLayoutId))) {
            if (!(viewHolder instanceof SearchLayoutViewHolder)) {
                viewHolder = null;
            }
            SearchLayoutViewHolder searchLayoutViewHolder2 = (SearchLayoutViewHolder) viewHolder;
            if (searchLayoutViewHolder2 != null) {
                searchLayoutViewHolder2.bind(this.onSearchQueryChange);
            }
        } else if (obj instanceof Date) {
            if (!(viewHolder instanceof HistoryHeaderViewHolder)) {
                viewHolder = null;
            }
            HistoryHeaderViewHolder historyHeaderViewHolder = (HistoryHeaderViewHolder) viewHolder;
            if (historyHeaderViewHolder != null) {
                historyHeaderViewHolder.bind((Date) obj);
            }
        } else if (obj instanceof HistoryRowViewModel) {
            if (!(viewHolder instanceof HistoryRowViewHolder)) {
                viewHolder = null;
            }
            HistoryRowViewHolder historyRowViewHolder = (HistoryRowViewHolder) viewHolder;
            if (historyRowViewHolder != null) {
                historyRowViewHolder.bind((HistoryRowViewModel) obj);
            }
        } else if (Intrinsics.areEqual(obj, Integer.valueOf(this.infoBoxTextId))) {
            if (!(viewHolder instanceof InfoBoxViewHolder)) {
                viewHolder = null;
            }
            InfoBoxViewHolder infoBoxViewHolder = (InfoBoxViewHolder) viewHolder;
            if (infoBoxViewHolder != null) {
                infoBoxViewHolder.bind(this.infoBoxTextId);
            }
        }
    }

    public final boolean isItemASectionHeader(int i) {
        return getItemViewType(i) == this.sectionHeaderViewType;
    }

    public final Unit clearSearchFocus() {
        SearchLayoutViewHolder searchLayoutViewHolder2 = this.searchLayoutViewHolder;
        if (searchLayoutViewHolder2 == null) {
            return null;
        }
        searchLayoutViewHolder2.clearSearchFocus();
        return Unit.INSTANCE;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bJ\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/HistoryListAdapter$SearchLayoutViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/databinding/LayoutCheckInHistorySearchBinding;", "(Lcom/digitalwallet/databinding/LayoutCheckInHistorySearchBinding;)V", "bind", "", "onSearchQueryChange", "Lkotlin/Function1;", "", "clearSearchFocus", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ShortcutItemViewAdapters.kt */
    public static final class SearchLayoutViewHolder extends RecyclerView.ViewHolder {
        private final LayoutCheckInHistorySearchBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SearchLayoutViewHolder(LayoutCheckInHistorySearchBinding layoutCheckInHistorySearchBinding) {
            super(layoutCheckInHistorySearchBinding.getRoot());
            Intrinsics.checkNotNullParameter(layoutCheckInHistorySearchBinding, "binding");
            this.binding = layoutCheckInHistorySearchBinding;
        }

        public final void bind(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onSearchQueryChange");
            this.binding.searchView.setOnQueryTextListener(new HistoryListAdapter$SearchLayoutViewHolder$bind$1(function1));
        }

        public final void clearSearchFocus() {
            this.binding.searchView.clearFocus();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/HistoryListAdapter$HistoryHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/databinding/ItemCheckInHistoryHeaderBinding;", "(Lcom/digitalwallet/databinding/ItemCheckInHistoryHeaderBinding;)V", "bind", "", "date", "Ljava/util/Date;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ShortcutItemViewAdapters.kt */
    public static final class HistoryHeaderViewHolder extends RecyclerView.ViewHolder {
        private final ItemCheckInHistoryHeaderBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HistoryHeaderViewHolder(ItemCheckInHistoryHeaderBinding itemCheckInHistoryHeaderBinding) {
            super(itemCheckInHistoryHeaderBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemCheckInHistoryHeaderBinding, "binding");
            this.binding = itemCheckInHistoryHeaderBinding;
        }

        public final void bind(Date date) {
            Intrinsics.checkNotNullParameter(date, "date");
            this.binding.setMediumDate(DateFormattingHelper.INSTANCE.toStringAsShortWeekdayDayMonth(date));
            ItemCheckInHistoryHeaderBinding itemCheckInHistoryHeaderBinding = this.binding;
            DateFormattingHelper dateFormattingHelper = DateFormattingHelper.INSTANCE;
            View root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            itemCheckInHistoryHeaderBinding.setRelativeDay(dateFormattingHelper.getRelativeDay(date, context));
            this.binding.executePendingBindings();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/HistoryListAdapter$HistoryRowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/databinding/ItemCheckInHistoryRowBinding;", "(Lcom/digitalwallet/databinding/ItemCheckInHistoryRowBinding;)V", "bind", "", "item", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/HistoryRowViewModel;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ShortcutItemViewAdapters.kt */
    public static final class HistoryRowViewHolder extends RecyclerView.ViewHolder {
        private final ItemCheckInHistoryRowBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HistoryRowViewHolder(ItemCheckInHistoryRowBinding itemCheckInHistoryRowBinding) {
            super(itemCheckInHistoryRowBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemCheckInHistoryRowBinding, "binding");
            this.binding = itemCheckInHistoryRowBinding;
        }

        public final void bind(HistoryRowViewModel historyRowViewModel) {
            Intrinsics.checkNotNullParameter(historyRowViewModel, "item");
            this.binding.setVm(historyRowViewModel);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/HistoryListAdapter$InfoBoxViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/databinding/LayoutInfoBoxBinding;", "(Lcom/digitalwallet/databinding/LayoutInfoBoxBinding;)V", "bind", "", "textId", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ShortcutItemViewAdapters.kt */
    public static final class InfoBoxViewHolder extends RecyclerView.ViewHolder {
        private final LayoutInfoBoxBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InfoBoxViewHolder(LayoutInfoBoxBinding layoutInfoBoxBinding) {
            super(layoutInfoBoxBinding.getRoot());
            Intrinsics.checkNotNullParameter(layoutInfoBoxBinding, "binding");
            this.binding = layoutInfoBoxBinding;
        }

        public final void bind(int i) {
            LayoutInfoBoxBinding layoutInfoBoxBinding = this.binding;
            View root = layoutInfoBoxBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            layoutInfoBoxBinding.setInfo(root.getContext().getString(i));
        }
    }
}
