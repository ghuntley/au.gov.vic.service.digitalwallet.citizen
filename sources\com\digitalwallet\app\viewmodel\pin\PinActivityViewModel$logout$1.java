package com.digitalwallet.app.viewmodel.pin;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: PinActivityViewModel.kt */
public final class PinActivityViewModel$logout$1<V> implements Callable<Object> {
    final /* synthetic */ PinActivityViewModel this$0;

    PinActivityViewModel$logout$1(PinActivityViewModel pinActivityViewModel) {
        this.this$0 = pinActivityViewModel;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.this$0.authenticationUtility.revokeUser();
    }
}
