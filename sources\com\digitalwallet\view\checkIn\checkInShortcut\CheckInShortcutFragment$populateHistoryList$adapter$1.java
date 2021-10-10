package com.digitalwallet.view.checkIn.checkInShortcut;

import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInShortcutFragment.kt */
public final /* synthetic */ class CheckInShortcutFragment$populateHistoryList$adapter$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    CheckInShortcutFragment$populateHistoryList$adapter$1(CheckInShortcutViewModel checkInShortcutViewModel) {
        super(1, checkInShortcutViewModel, CheckInShortcutViewModel.class, "filterHistoryItems", "filterHistoryItems(Ljava/lang/String;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke(str);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p1");
        ((CheckInShortcutViewModel) this.receiver).filterHistoryItems(str);
    }
}
