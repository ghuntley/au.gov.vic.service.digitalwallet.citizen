package com.digitalwallet.view.checkIn.checkInShortcut;

import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.databinding.FragmentCheckInShortcutBinding;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/digitalwallet/model/CheckIn;", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInShortcutFragment.kt */
public final class CheckInShortcutFragment$observeEvents$2 extends Lambda implements Function1<Pair<? extends CheckIn, ? extends CheckInUtils.CheckInCode>, Unit> {
    final /* synthetic */ CheckInShortcutFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInShortcutFragment$observeEvents$2(CheckInShortcutFragment checkInShortcutFragment) {
        super(1);
        this.this$0 = checkInShortcutFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends CheckIn, ? extends CheckInUtils.CheckInCode> pair) {
        invoke((Pair<CheckIn, CheckInUtils.CheckInCode>) pair);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<CheckIn, CheckInUtils.CheckInCode> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        CheckIn component1 = pair.component1();
        CheckInUtils.CheckInCode component2 = pair.component2();
        RecyclerView recyclerView = ((FragmentCheckInShortcutBinding) this.this$0.getBinding()).historyList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.historyList");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (!(adapter instanceof HistoryListAdapter)) {
            adapter = null;
        }
        HistoryListAdapter historyListAdapter = (HistoryListAdapter) adapter;
        if (historyListAdapter != null) {
            historyListAdapter.clearSearchFocus();
        }
        this.this$0.navigateToCheckInHistoryDetail(component1, component2);
    }
}
