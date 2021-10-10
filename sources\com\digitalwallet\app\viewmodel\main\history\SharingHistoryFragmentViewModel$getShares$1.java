package com.digitalwallet.app.viewmodel.main.history;

import androidx.databinding.ObservableField;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: SharingHistoryFragmentViewModel.kt */
public final class SharingHistoryFragmentViewModel$getShares$1<T> implements Consumer<List<? extends ShareRecord>> {
    final /* synthetic */ SharingHistoryFragmentViewModel this$0;

    SharingHistoryFragmentViewModel$getShares$1(SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel) {
        this.this$0 = sharingHistoryFragmentViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends ShareRecord> list) {
        accept((List<ShareRecord>) list);
    }

    public final void accept(List<ShareRecord> list) {
        ObservableField<Boolean> sharesArePresent = this.this$0.getSharesArePresent();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        sharesArePresent.set(Boolean.valueOf(!list.isEmpty()));
    }
}
