package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInRepository.kt */
public final class CheckInRepository$postCheckIns$1 implements Action {
    final /* synthetic */ CheckInRepository this$0;

    CheckInRepository$postCheckIns$1(CheckInRepository checkInRepository) {
        this.this$0 = checkInRepository;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.this$0.clearPendingCheckIns();
    }
}
