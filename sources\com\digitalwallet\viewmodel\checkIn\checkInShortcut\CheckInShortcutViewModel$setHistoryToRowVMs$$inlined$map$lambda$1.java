package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel$setHistoryToRowVMs$rowVMs$1$2"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInShortcutViewModel.kt */
public final class CheckInShortcutViewModel$setHistoryToRowVMs$$inlined$map$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $cached$inlined;
    final /* synthetic */ CheckIn $checkIn;
    final /* synthetic */ CheckInUtils.CheckInCode $checkInCode;
    final /* synthetic */ boolean $editing$inlined;
    final /* synthetic */ CheckInShortcutViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInShortcutViewModel$setHistoryToRowVMs$$inlined$map$lambda$1(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode, CheckInShortcutViewModel checkInShortcutViewModel, boolean z, List list) {
        super(0);
        this.$checkIn = checkIn;
        this.$checkInCode = checkInCode;
        this.this$0 = checkInShortcutViewModel;
        this.$editing$inlined = z;
        this.$cached$inlined = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ActionEventKt.postEvent(this.this$0.getToHistoryDetailEvent(), TuplesKt.to(this.$checkIn, this.$checkInCode));
    }
}
